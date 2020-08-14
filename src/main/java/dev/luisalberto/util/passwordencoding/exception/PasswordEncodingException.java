package dev.luisalberto.util.passwordencoding.exception;

public class PasswordEncodingException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public PasswordEncodingException(String message) {
        super(message);
    }

    public PasswordEncodingException(String message, Throwable cause) {
        super(message, cause);
    }
}
