package gcd;

import exceptions.CalculationException;

import java.util.Scanner;

import static tools.GetConsoleInput.readInteger;
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

        int a = readInteger(in, MIN_VALUE, MAX_VALUE, "first number");
        int b = readInteger(in, MIN_VALUE, MAX_VALUE, "second number");
        int c = readInteger(in, MIN_VALUE, MAX_VALUE, "third number");
        int d = readInteger(in, MIN_VALUE, MAX_VALUE, "fourth number");

        printGCDMessage(a, b, c, d);
        try {
            int gcd = gcdOfFour(a, b, c, d);

            System.out.println(gcd);
        } catch (CalculationException e) {
            System.out.println(EXCEPTIONAL_CASE);
        }
    }

    /**
     * Method prints method that helps to represent calculation gcd of four numbers
     * @param a first number
     * @param b second number
     * @param c third number
     * @param d four number
     */
    private static void printGCDMessage(int a, int b, int c, int d) {
        System.out.printf("GCD(%d, %d, %d, %d) = ", a, b, c, d);
    }
}
