package br.com.criadouropicinini.domain.exceptions;

public class EspecieNotFoundException extends EntityNotFoundException {

    private static final long serialVersionUID = 1L;

    public EspecieNotFoundException(String mensage) {
        super(mensage);
    }

    public EspecieNotFoundException(Long especieId) {
        this(String.format("Este código %d da especie não existe.", especieId));
    }
}


