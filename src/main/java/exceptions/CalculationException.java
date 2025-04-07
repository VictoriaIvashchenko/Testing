package exceptions;

/**
 * Thrown to indicate that a calculation error occurs
 */
public class CalculationException extends Exception {

    /**
     * Constructs a new {@code CalculationException} with the specified detail message.
     *
     * @param message the detail message which describes the error in the calculation
     */
    public CalculationException(String message) {
        super(message);
    }
}
