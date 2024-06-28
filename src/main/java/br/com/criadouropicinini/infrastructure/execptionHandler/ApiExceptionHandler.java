package br.com.criadouropicinini.infrastructure.execptionHandler;


import br.com.criadouropicinini.domain.exceptions.BusinessException;
import br.com.criadouropicinini.domain.exceptions.EntityInUseException;
import br.com.criadouropicinini.domain.exceptions.EntityNotFoundException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.exc.PropertyBindingException;
import org.flywaydb.core.internal.util.ExceptionUtils;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    public static final String MESSAGE_ERROR_GENERIC_FOR_USER = "Ocorreu um erro interno" +
            " inesperado no sistema. "
            + "Tente novamente e se o problema persistir, entre em contato "
            + "com o administrador do sistema.";

    @Autowired
    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(
            HttpMediaTypeNotAcceptableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return ResponseEntity.status(status).headers(headers).build();
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return handleValidationInternal(ex, headers, status, request, ex.getBindingResult());
    }

    private ResponseEntity<Object> handleValidationInternal(Exception ex, HttpHeaders headers, HttpStatusCode status,
                                                            WebRequest request, BindingResult bindingResult) {
        ProblemType problemType = ProblemType.INVALID_DATA;
        String detail = "Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente.";


        List<Problem.Object> problemFields = bindingResult.getFieldErrors().stream()
                .map(fieldError -> {
                    String message = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());

                    return Problem.Object.builder()
                            .name(fieldError.getField())
                            .userMessage(message)
                            .build();
                })
                .collect(Collectors.toList());

        Problem problem = createProblemBuilder((HttpStatus) status, problemType, detail)
                .userMessage(detail)
                .fields(problemFields)
                .build();

        return handleExceptionInternal(ex, problem, headers, status, request);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleUncaugh(Exception ex, WebRequest request) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        ProblemType problemType = ProblemType.SYSTEM_ERROR;
        String detail = MESSAGE_ERROR_GENERIC_FOR_USER;
        ex.printStackTrace();
        Problem problem = createProblemBuilder(status, problemType, detail)
                .userMessage(detail)
                .build();
        return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
    }

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex,
                                                                   HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        ProblemType problemType = ProblemType.RESOURCE_NOT_FOUND;
        String detail = String.format("O recurso %s, que você tentou acessar, é inexistente.",
                ex.getRequestURL());

        Problem problem = createProblemBuilder((HttpStatus) status, problemType, detail)
                .userMessage(MESSAGE_ERROR_GENERIC_FOR_USER)
                .build();

        return handleExceptionInternal(ex, problem, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
                                                        HttpStatusCode status, WebRequest request) {
        if (ex instanceof MethodArgumentTypeMismatchException) {
            return handleMethodArgumentTypeMismatch(
                    (MethodArgumentTypeMismatchException) ex, headers, (HttpStatus) status, request);
        }

        return super.handleTypeMismatch(ex, headers, status, request);
    }

    private ResponseEntity<Object> handleMethodArgumentTypeMismatch(
            MethodArgumentTypeMismatchException ex, HttpHeaders headers,
            HttpStatus status, WebRequest request) {

        ProblemType problemType = ProblemType.INVALID_PARAMETER;

        String detail = String.format("O parâmetro de URL '%s' recebeu o valor '%s', "
                        + "que é de um tipo inválido. Corrija e informe um valor " +
                        " compatível com o tipo %s.",
                ex.getName(), ex.getValue(), ex.getRequiredType().getSimpleName());

        Problem problem = createProblemBuilder(status, problemType, detail)
                .userMessage(MESSAGE_ERROR_GENERIC_FOR_USER)
                .build();

        return handleExceptionInternal(ex, problem, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
                                                                  HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Throwable rootCause = ExceptionUtils.getRootCause(ex);

        if (rootCause instanceof InvalidFormatException) {
            return handleInvalidFormatException((InvalidFormatException) rootCause, headers, status, request);
        } else if (rootCause instanceof PropertyBindingException) {
            return handlePropertyBindingException((PropertyBindingException) rootCause, headers, status, request);
        }

        ProblemType problemType = ProblemType.MESAGE_INCOMPREHENSIBLE;
        String detail = "O corpo da requisição está inválido. Verifique erro de sintaxe. ";
        Problem problem = createProblemBuilder((HttpStatus) status, problemType, detail)
                .userMessage(MESSAGE_ERROR_GENERIC_FOR_USER)
                .build();

        return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> handlerEntityNotFoundException(EntityNotFoundException ex, WebRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        String detail = ex.getMessage();

        ProblemType problemType = ProblemType.RESOURCE_NOT_FOUND;
        Problem problem = createProblemBuilder(status, problemType, detail)
                .userMessage(detail)
                .build();

        return handleExceptionInternal(ex, problem, new HttpHeaders(),
                status, request);
    }

    @ExceptionHandler(EntityInUseException.class)
    public ResponseEntity<?> handlerEntityInUseException(EntityInUseException ex, WebRequest request) {
        HttpStatus status = HttpStatus.CONFLICT;
        ProblemType problemType = ProblemType.ENTITY_IN_USER;
        String detail = ex.getMessage();
        Problem problem = createProblemBuilder(status, problemType, detail)
                .userMessage(detail)
                .build();
        return handleExceptionInternal(ex, problem, new HttpHeaders(),
                status, request);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<?> handlerBusinessException(BusinessException ex, WebRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ProblemType problemType = ProblemType.ERROR_BUSINESS;
        String detail = ex.getMessage();
        Problem problem = createProblemBuilder(status, problemType, detail)
                .userMessage(detail)
                .build();
        return handleExceptionInternal(ex, problem, new HttpHeaders(),
                status, request);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body,
                                                             HttpHeaders headers, HttpStatusCode statusCode, WebRequest request) {

        if (body == null) {
            body = Problem.builder()
                    .title(statusCode.toString())
                    .status(statusCode.value())
                    .dateTime(OffsetDateTime.now())
                    .userMessage(MESSAGE_ERROR_GENERIC_FOR_USER)
                    .build();
        } else if (body instanceof String) {
            body = Problem.builder()
                    .title((String) body)
                    .status(statusCode.value())
                    .dateTime(OffsetDateTime.now())
                    .userMessage(MESSAGE_ERROR_GENERIC_FOR_USER)
                    .build();
        }
        return super.handleExceptionInternal(ex, body, headers, statusCode, request);
    }

    private Problem.ProblemBuilder createProblemBuilder(HttpStatus status, ProblemType problemType,
                                                        String detail) {
        return Problem.builder()
                .status(status.value())
                .type(problemType.getUri())
                .title(problemType.getTitle())
                .dateTime(OffsetDateTime.now())
                .detail(detail);
    }

    private ResponseEntity<Object> handleInvalidFormatException(InvalidFormatException ex,
                                                                HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        String path = ex.getPath().stream()
                .map(ref -> ref.getFieldName())
                .collect(Collectors.joining("."));

        ProblemType problemType = ProblemType.MESAGE_INCOMPREHENSIBLE;
        String detail = String.format("A propriedade '%s' recebeu o valor '%s', " +
                "que é de um tipo inválido. Corrija e informe um valor compatível com o tipo " +
                "%s.", path, ex.getValue(), ex.getTargetType().getSimpleName());
        Problem problem = createProblemBuilder((HttpStatus) status, problemType, detail)
                .userMessage(MESSAGE_ERROR_GENERIC_FOR_USER)
                .build();

        return handleExceptionInternal(ex, problem, headers, status, request);
    }

    private ResponseEntity<Object> handlePropertyBindingException(PropertyBindingException ex,
                                                                  HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        String path = joinPath(ex.getPath());
        ProblemType problemType = ProblemType.MESAGE_INCOMPREHENSIBLE;
        String detail = String.format("A propriedade '%s' não existe. "
                + "Corrija ou remova essa propriedade e tente novamente.", path);
        Problem problem = createProblemBuilder((HttpStatus) status, problemType, detail)
                .userMessage(MESSAGE_ERROR_GENERIC_FOR_USER)
                .build();

        return handleExceptionInternal(ex, problem, headers, status, request);
    }

    private String joinPath(List<JsonMappingException.Reference> references) {
        return references.stream()
                .map(ref -> ref.getFieldName())
                .collect(Collectors.joining("."));
    }

}
