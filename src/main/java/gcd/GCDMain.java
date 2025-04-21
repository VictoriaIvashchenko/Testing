package gcd;

import exceptions.CalculationException;
import exceptions.InvalidInputException;

import java.util.Scanner;

import static tools.CheckConsoleInput.readInteger;
import static gcd.GCD.gcdOfFour;

/**
 * Class {@code GCDMain} serves as the entry point for calculating the greatest common divisor (GCD)
 * of four integers.
 *
 * <p>This class prompts the user to input four integers, validates the input, and calculates the GCD of the four numbers
 * using the {@link GCD#gcdOfFour(int, int, int, int)} method. It handles invalid inputs and exceptional cases appropriately.</p>
 */
public class GCDMain {

    /**
     * Exceptional case when we can't use int variable to show the answer.
     */
    private static final String EXCEPTIONAL_CASE = "2147483648";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Task 3. Enter four numbers for searching gcd:");
        try {
            int a = readInteger(in, "a");
            int b = readInteger(in, "b");
            int c = readInteger(in, "c");
            int d = readInteger(in, "d");

            printGCDMessage(a, b, c, d);

            int gcd = gcdOfFour(a, b, c, d);
            System.out.println(gcd);

        } catch (InvalidInputException e) {
            System.err.println(e.getMessage());

        } catch (CalculationException e) {
            System.out.println(EXCEPTIONAL_CASE);
        }
    }

    private static void printGCDMessage(int a, int b, int c, int d) {
        System.out.printf("GCD(%d, %d, %d, %d) = ", a, b, c, d);
    }
}
