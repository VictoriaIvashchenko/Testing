package fibonacci;

import java.math.BigInteger;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;

/**
 * Class {@code Fibonacci} provides methods for calculating Fibonacci numbers using matrix exponentiation.
 *
 * <p>This class offers an efficient approach for computing Fibonacci numbers using matrix exponentiation.
 * By representing the Fibonacci sequence with matrix multiplication, we can compute the n-th Fibonacci number
 * in logarithmic time (O(log n)) through matrix exponentiation by squaring.</p>
 */
public class Fibonacci {

    /**
     * Error message for an invalid index input in Fibonacci sequence.
     */
    private static final String INVALID_VALUE_INPUT_MESSAGE =
            "Invalid value of index. Positive integer from 0 to 2147483647 was expected, but '%d' was received.";

    /**
     * Computes the n-th Fibonacci number using matrix exponentiation.
     *
     * <p>This method efficiently calculates Fibonacci numbers using matrix exponentiation,
     * which reduces the time complexity to O(log n). It leverages the following matrix identity:</p>
     *
     * <pre>
     * | F(n)   F(n-1) | = | 1  1 | ^ (n-1)
     * | F(n-1) F(n-2) |   | 1  0 |
     * </pre>
     *
     * <p>Where matrix exponentiation is performed iteratively using exponentiation by squaring.</p>
     *
     * @param n the position of the Fibonacci sequence to compute (must be non-negative)
     * @return the n-th Fibonacci number as a {@link BigInteger}
     * @throws IllegalArgumentException if {@code n} is negative
     */
    public static BigInteger fibonacci(int n) {
        // Check for an invalid value
        if (n < 0) {
            throw new IllegalArgumentException(
                    String.format(INVALID_VALUE_INPUT_MESSAGE, n));
        }

        // F(0) = 0
        if (n == 0) {
            return ZERO;
        }

        // F(1) = 1
        if (n == 1) {
            return ONE;
        }

        // Initial unit matrix 2x2
        BigInteger[][] result = new BigInteger[][]{
                {ONE, ZERO},
                {ZERO, ONE}};
        // Base matrix for calculating Fibonacci numbers:
        // [1 1]
        // [1 0]
        BigInteger[][] base = new BigInteger[][]{
                {ONE, ONE},
                {ONE, ZERO}};

        // Reduce the indicator by 1, since it starts with F(1)
        n -= 1;
        // Quickly raise a matrix to the power of n
        while (n > 0) {
            // If the current degree is odd, multiply the result by the base matrix
            if (n % 2 == 1) {
                result = matrixMultiple(result, base);
            }
            // Each time we raise the base to the power of 2
            base = matrixMultiple(base, base);
            // Divide the power by 2
            n /= 2;
        }

        // Return the upper left value from the result matrix - this is F(n)
        return result[0][0];
    }

    /**
     * Multiplies two 2×2 matrices of {@link BigInteger} values.
     *
     * <p>This method performs matrix multiplication for two 2×2 matrices using
     * standard matrix multiplication rules:</p>
     *
     * <pre>
     * C = A × B, where:
     *
     * C[0][0] = A[0][0] * B[0][0] + A[0][1] * B[1][0]
     * C[0][1] = A[0][0] * B[0][1] + A[0][1] * B[1][1]
     * C[1][0] = A[1][0] * B[0][0] + A[1][1] * B[1][0]
     * C[1][1] = A[1][0] * B[0][1] + A[1][1] * B[1][1]
     * </pre>
     *
     * <p>Both input matrices must be 2×2 in size.</p>
     *
     * @param a the first 2×2 matrix
     * @param b the second 2×2 matrix
     * @return the resulting 2×2 matrix after multiplication
     */
    private static BigInteger[][] matrixMultiple(BigInteger[][] a, BigInteger[][] b) {
        BigInteger c00 = calculatingElementOfMatrix(a[0][0], b[0][0], a[0][1], b[1][0]);
        BigInteger c01 = calculatingElementOfMatrix(a[0][0], b[0][1], a[0][1], b[1][1]);
        BigInteger c10 = calculatingElementOfMatrix(a[1][0], b[0][0], a[1][1], b[1][0]);
        BigInteger c11 = calculatingElementOfMatrix(a[1][0], b[0][1], a[1][1], b[1][1]);

        return new BigInteger[][]{
                {c00, c01},
                {c10, c11}
        };
    }

    /**
     * Calculates the element of a 2×2 matrix by multiplying and adding the corresponding elements.
     * <p>
     * This method calculates a single element of the result matrix, which is the sum of the products of the corresponding
     * elements of the two matrices: {@code a[i][0] * b[0][j]} and {@code a[i][1] * b[1][j]}, where {@code i} number of
     * row of calculating element and {@code j} are number of and column.</p>
     *
     * @param aI0 first element of the first matrix
     * @param b0J first element of the second matrix
     * @param aI1 second element of the first matrix
     * @param b1J second element of the second matrix
     * @return the result of calculating the matrix element
     */
    private static BigInteger calculatingElementOfMatrix(BigInteger aI0, BigInteger b0J, BigInteger aI1, BigInteger b1J) {
        BigInteger mul1 = aI0.multiply(b0J);
        BigInteger mul2 = aI1.multiply(b1J);
        return mul1.add(mul2);
    }
}
