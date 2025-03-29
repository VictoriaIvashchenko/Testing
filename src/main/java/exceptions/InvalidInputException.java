package exceptions;

/**
 * Thrown to indicate that an argument with an incorrect type or value was passed to the method.
 */
public class InvalidInputException extends Exception{
    /**
     * Constructs a new {@code InvalidInputException} with the specified detail message.
     *
     * @param message the detail message which describes the error in the calculation
     */
    public InvalidInputException(String message){
        super(message);
    }
}
