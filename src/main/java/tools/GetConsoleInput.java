package tools;

import java.util.Scanner;

/**
 * The {@code GetConsoleInput} class provides utility methods for reading and validating user input.
 *
 * <p>This class ensures that user-provided input meets the expected format and handles invalid cases
 * by throwing appropriate exceptions.</p>
 */
public class GetConsoleInput {

    /**
     * The error message format string with two integer arguments: minimum and maximum values,
     * used to display a warning in case of invalid input.
     */
    private final static String INVALID_TYPE_MESSAGE =
            "[Warning] Invalid input value. Number from %d to %d was expected.%n";

    /**
     * Reads an integer from the provided scanner, ensuring it falls within the specified range.
     * Prompts the user with the variable name and handles invalid inputs by displaying an error message.
     *
     * @param in the Scanner object to read input from
     * @param minValue the minimum acceptable value for the input
     * @param maxValue the maximum acceptable value for the input
     * @param varName the name of the variable for the prompt (e.g., "x" or "y")
     * @return the integer value read from the input, guaranteed to be within [minValue, maxValue]
     */
    public static Integer readInteger(Scanner in, int minValue, int maxValue, String varName) {
        while (true) {
            System.out.printf("Enter %s:%n", varName);
            String input = in.nextLine().trim();
            try {
                int value = Integer.parseInt(input);

                if (value < minValue || value > maxValue) {
                    throw new NumberFormatException();
                }else {
                    return value;
                }
            } catch (NumberFormatException e) {
                System.err.printf(INVALID_TYPE_MESSAGE, minValue, maxValue);
            }
        }

    }

}
