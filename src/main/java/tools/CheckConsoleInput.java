package tools;

import exceptions.InvalidInputException;

import java.util.Scanner;

/**
 * The {@code CheckConsoleInput} class provides utility methods for reading and validating user input.
 *
 * <p>This class ensures that user-provided input meets the expected format and handles invalid cases
 * by throwing appropriate exceptions.</p>
 *
 */
public class CheckConsoleInput {

    /**
     * The error message format string with two string arguments: name of variable and input, in case of invalid input
     */
    private final static String INVALID_TYPE_MESSAGE =
            "Invalid type of input value. Number from -2147483648 to 2147483647 was expected.";

    /**
     * Reads an integer value from the input scanner and validates it.
     *
     * <p>This method reads a line of input, trims it, and attempts to parse it as an integer.
     * If the input is not a valid integer, an {@link InvalidInputException} is thrown
     * with a formatted error message.</p>
     *
     * @param in the {@link Scanner} object used for reading user input
     * @return the parsed integer value
     * @throws InvalidInputException if the input cannot be parsed as an integer
     */
    public static Integer readInteger(Scanner in) throws InvalidInputException {
        String input = in.nextLine().trim();
        try {
            return Integer.parseInt(input);

        } catch (NumberFormatException e) {
            throw new InvalidInputException(INVALID_TYPE_MESSAGE);
        }
    }

}
