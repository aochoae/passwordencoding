package dev.luisalberto.util.passwordencoding.exception;

/**
 * @author Luis A. Ochoa
 */
public class AlgorithmArgumentException extends RuntimeException {

    /**
     * Default Serial Version UI
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructs a AlgorithmArgumentException exception.
     */
    public AlgorithmArgumentException() {
        super("Invalid encryption algorithm.");
    }

    /**
     * Constructs a AlgorithmArgumentException exception.
     * 
     * @param message The detail message.
     */
    public AlgorithmArgumentException(String message) {
        super(message);
    }
}
