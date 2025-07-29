package br.pro.em.escola.exceptions;

public class PessoaJaExistenteException extends RuntimeException {
    public PessoaJaExistenteException(String message) {
        super(message);
    }
}
