package com.org.carvalho.webstore.api.share.util.crud.exception;

public class RegistroNaoEncontradoException extends RuntimeException {
    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public RegistroNaoEncontradoException(String message) {
        super(message);
    }
}
