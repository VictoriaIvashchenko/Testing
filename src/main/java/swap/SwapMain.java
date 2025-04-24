package swap;

import exceptions.InvalidInputException;

import java.util.Scanner;

import static tools.CheckConsoleInput.readInteger;
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

        System.out.println("Task 1. Enter two numbers x and y:");
        try {
            int x = readInteger(in);
            int y = readInteger(in);

            printValues("Before", x, y);

            int[] swapped = swap(x, y);

            printValues("After", swapped[0], swapped[1]);

        } catch (InvalidInputException e) {
            System.err.print(e.getMessage());
        }
    }

    private static void printValues(String label, int x, int y) {
        System.out.printf("%s: x = %d y = %d%n", label, x, y);
    }
}
