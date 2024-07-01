package br.com.criadouropicinini.domain.exceptions;

public class ClubeNotFoundException extends EntityNotFoundException {

    private static final long serialVersionUID = 1L;

    public ClubeNotFoundException(String mensage) {
        super(mensage);
    }

    public ClubeNotFoundException(Long especieId) {
        this(String.format("Este código %d do clube não existe", especieId));
    }
}


