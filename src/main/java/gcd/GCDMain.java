package gcd;

import exceptions.CalculationException;
import exceptions.InvalidInputException;

import java.util.Scanner;

import static exceptions.CheckConsoleInput.readInteger;
import static gcd.GCD.gcdOfFour;

/**
 * Class {@code GCDMain} serves as the entry point for calculating the greatest common divisor (GCD)
 * of four integers.
 *
 * <p>This class prompts the user to input four integers, validates the input, and calculates the GCD of the four numbers
 * using the {@link GCD#gcdOfFour(int, int, int, int)} method. It handles invalid inputs and exceptional cases appropriately.</p>
 */
public class GCDMain {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String message = "Invalid type of %s. Number from -2147483648 to 2147483647 was expected, but '%s' was received.";
        String exceptionalCase = "2147483648";

        System.out.println("Task 3. Enter four numbers for searching gcd:");
        try {
            int a = readInteger(in, "a", message);
            int b = readInteger(in, "b", message);
            int c = readInteger(in, "c", message);
            int d = readInteger(in, "d", message);

            printGCDMessage(a, b, c, d);

            int result = gcdOfFour(a, b, c, d);
            System.out.print(result);

        } catch (InvalidInputException e) {
            System.err.print(e.getMessage());

        } catch (CalculationException e) {
            System.out.print(exceptionalCase);
        }
    }

    private static void printGCDMessage(int a, int b, int c, int d) {
        System.out.printf("GCD(%d, %d, %d, %d) = ", a, b, c, d);
    }
}
