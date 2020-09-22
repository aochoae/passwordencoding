package dev.luisalberto.util.passwordencoding.exception;

/**
 * @author Luis A. Ochoa
 */
public class PasswordArgumentException extends RuntimeException {

    /**
     * Default Serial Version UI
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructs a PasswordArgumentException exception.
     */
    public PasswordArgumentException() {
        super("You must enter a password.");
    }

    /**
     * Constructs a PasswordArgumentException exception.
     * 
     * @param message The detail message.
     */
    public PasswordArgumentException(String message) {
        super(message);
    }
}
