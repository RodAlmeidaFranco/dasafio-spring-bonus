package com.src.desafiospringbonus.exception;

public class RepositoryException extends RuntimeException {

    private static final long serialVersionUID = 2L;

    public RepositoryException(String mensagem) {
        super(mensagem);
    }
}
