package swap;

import java.util.Scanner;

import static tools.GetConsoleInput.readInteger;
import static swap.Swap.swap;

/**
 * The {@code SwapMain} class serves as the entry point for executing the swap operation.
 *
 * <p>This class reads two integer inputs from the user, performs validation, and invokes the {@link Swap#swap(int, int)} method
 * to swap the values.</p>
 */
public class SwapMain {

    /**
     * Value that represents max numeric value for input arguments.
     */
    private static final int MAX_VALUE = Integer.MAX_VALUE;

    /**
     * Value that represents min numeric value for input arguments.
     */
    private static final int MIN_VALUE =  Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int x = readInteger(in, MIN_VALUE, MAX_VALUE, "x");
        int y = readInteger(in, MIN_VALUE, MAX_VALUE, "y");

        printValues("Before", x, y);

        int[] swapped = swap(x, y);

        printValues("After", swapped[0], swapped[1]);
    }

    /**
     * Method that prints the values of two integers with a specified label in a formatted manner.
     *
     * @param label the label to describe the context of the values (e.g., "Before" or "After")
     * @param x the first integer value to print
     * @param y the second integer value to print
     */
    private static void printValues(String label, int x, int y) {
        System.out.printf("%s: x = %d y = %d%n", label, x, y);
    }
}
