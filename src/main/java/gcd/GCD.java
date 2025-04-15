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
     * <p>The method recursively finds the GCD by replacing (a, number2) with (number2, a % number2)
     * until number2 becomes zero. At that point, a is the GCD.</p>
     *
     * @param number1 the first integer
     * @param number2 the second integer
     * @return the greatest common divisor of {@code a} and {@code number2}
     */
    public static int gcd(int number1, int number2) {
        if (number2 == 0) {
            return number1;
        }
        return gcd(number2, number1 % number2);
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
     * @param number1 the first integer
     * @param number2 the second integer
     * @param number3 the third integer
     * @param number4 the fourth integer
     * @return the greatest common divisor of the four integers (always non-negative)
     * @throws CalculationException if the computed GCD is invalid
     */
    public static int gcdOfFour(int number1, int number2, int number3, int number4) throws CalculationException {
        if (number1 == 0 && number2 == 0 && number3 == 0 && number4 == 0) {
            return 0;
        }
        int result = gcd(gcd(gcd(number1, number2), number3), number4);

        if (result == Integer.MIN_VALUE) {
            throw new CalculationException(INVALID_RESULT_MESSAGE);
        }

        return abs(result);
    }

}
