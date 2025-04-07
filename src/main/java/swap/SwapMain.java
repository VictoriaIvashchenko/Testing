package swap;

import exceptions.InvalidInputException;

import java.util.Scanner;

import static exceptions.CheckConsoleInput.readInteger;
import static swap.Swap.swap;

/**
 * The {@code SwapMain} class serves as the entry point for executing the swap operation.
 *
 * <p>This class reads two integer inputs from the user, performs validation, and invokes the {@link Swap#swap(int, int)} method
 * to swap the values.</p>
 */
public class SwapMain {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String separator = System.lineSeparator();
        String message = "Invalid type of %s. Number from -2147483648 to 2147483647 was expected, but '%s' was received.";

        System.out.println("Task 1. Enter two numbers x and y:");
        try {
            int x = readInteger(in, "x", message);
            int y = readInteger(in, "y", message);

            printValues("Before", x, y, separator);

            int[] result = swap(x, y);

            printValues("After", result[0], result[1], separator);

        } catch (InvalidInputException e) {
            System.err.print(e.getMessage());
        }
    }

    private static void printValues(String label, int x, int y, String separator) {
        System.out.printf("%s: x = %d y = %d" + separator, label, x, y);
    }
}
