package br.com.aceleradev.exceptions;

public class UsuarioSemAutorizacaoException extends RuntimeException {
    public UsuarioSemAutorizacaoException(String s) {
        super(s);
    }
}
