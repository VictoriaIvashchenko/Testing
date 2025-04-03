package exceptions;

import java.util.Scanner;

import static java.lang.Integer.parseInt;
import static java.lang.String.format;

/**
 * The {@code CheckConsoleInput} class provides utility methods for reading and validating user input.
 *
 * <p>This class ensures that user-provided input meets the expected format and handles invalid cases
 * by throwing appropriate exceptions.</p>
 *
 */
public class CheckConsoleInput {
    /**
     * Reads an integer value from the input scanner and validates it.
     *
     * <p>This method reads a line of input, trims it, and attempts to parse it as an integer.
     * If the input is not a valid integer, an {@link InvalidInputException} is thrown
     * with a formatted error message.</p>
     *
     * @param in the {@link Scanner} object used for reading user input
     * @param varName the name of the variable being read (used for error messages)
     * @param message the error message format string in case of invalid input
     * @return the parsed integer value
     * @throws InvalidInputException if the input cannot be parsed as an integer
     */
    public static Integer readInteger(Scanner in, String varName, String message) throws InvalidInputException {
        String input = in.nextLine().trim();

        try {
            return parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidInputException(format(message, varName, input));
        }
    }

}
