package br.com.criadouropicinini.domain.exceptions;

public class FederacaoNotFoundException extends EntityNotFoundException {

    private static final long serialVersionUID = 1L;

    public FederacaoNotFoundException(String mensage) {
        super(mensage);
    }

    public FederacaoNotFoundException(Long especieId) {
        this(String.format("Este código %d da federação não existe", especieId));
    }
}


