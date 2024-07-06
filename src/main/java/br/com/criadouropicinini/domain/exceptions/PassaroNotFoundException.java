package br.com.criadouropicinini.domain.exceptions;

public class PassaroNotFoundException extends EntityNotFoundException {

    private static final long serialVersionUID = 1L;

    public PassaroNotFoundException(String mensage) {
        super(mensage);
    }

    public PassaroNotFoundException(Long passaroId) {
        this(String.format("Este passaro com o código %d não existe.", passaroId));
    }
}


