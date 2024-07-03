package br.com.criadouropicinini.domain.exceptions;

public class CriadorNotFoundException extends EntityNotFoundException {

    private static final long serialVersionUID = 1L;

    public CriadorNotFoundException(String mensage) {
        super(mensage);
    }

    public CriadorNotFoundException(Long criadorId) {
        this(String.format("Este código %d do criador não existe.", criadorId));
    }
}


