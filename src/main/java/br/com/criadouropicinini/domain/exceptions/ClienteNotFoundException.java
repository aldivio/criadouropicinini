package br.com.criadouropicinini.domain.exceptions;

public class ClienteNotFoundException extends EntityNotFoundException {

    private static final long serialVersionUID = 1L;

    public ClienteNotFoundException(String mensage) {
        super(mensage);
    }

    public ClienteNotFoundException(Long clienteId) {
        this(String.format("Este cliente com o código %d não existe.", clienteId));
    }
}


