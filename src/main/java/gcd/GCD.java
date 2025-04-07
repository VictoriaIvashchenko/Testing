package gcd;

import exceptions.CalculationException;

import static java.lang.Math.abs;

/**
 * Class {@code GCD} provides utility methods for calculating the greatest common divisor (GCD)
 * of two or more integers using the Euclidean algorithm.
 *
 * <p>This class contains methods to compute the GCD of two integers and four integers efficiently,
 * handling special cases such as all zeros and invalid results.</p>
 */
public class GCD {

    /**
     * Error message when modulus of Integer.MIN_VALUE is attempted.
     */
    private static final String INVALID_RESULT_MESSAGE = "Absolut value of a -2147483648 can't be calculated.";

    /**
     * Calculates the greatest common divisor (GCD) of two integers using the Euclidean algorithm.
     *
     * <p>The method recursively finds the GCD by replacing (a, b) with (b, a % b)
     * until b becomes zero. At that point, a is the GCD.</p>
     *
     * @param a the first integer
     * @param b the second integer
     * @return the greatest common divisor of {@code a} and {@code b}
     */
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    /**
     * Calculates the greatest common divisor (GCD) of four integers.
     *
     * <p>The method computes the GCD of the given four numbers using the
     * Euclidean algorithm recursively. It first finds the GCD of the first
     * two numbers, then finds the GCD of the result with the third number,
     * and finally computes the GCD with the fourth number.</p>
     *
     * <p>If all input numbers are zero, the method returns 0.</p>
     *
     * <p>If the computed GCD results in an invalid value (e.g., {@code Integer.MIN_VALUE}),
     * a {@link CalculationException} is thrown.</p>
     *
     * @param a the first integer
     * @param b the second integer
     * @param c the third integer
     * @param d the fourth integer
     * @return the greatest common divisor of the four integers (always non-negative)
     * @throws CalculationException if the computed GCD is invalid
     */
    public static int gcdOfFour(int a, int b, int c, int d) throws CalculationException {
        if (a == 0 & b == 0 & c == 0 & d == 0) {
            return 0;
        }
        int result = gcd(gcd(gcd(a, b), c), d);

        if (result == Integer.MIN_VALUE) {
            throw new CalculationException(INVALID_RESULT_MESSAGE);
        }

        return abs(result);
    }

}
