package fibonacci;

import exceptions.InvalidInputException;

import java.math.BigInteger;

import static exceptions.ExceptionMessages.INVALID_VALUE_INPUT_FIBONACCI;
import static java.lang.String.format;

public class Fibonacci {
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
     * @throws InvalidInputException if {@code n} is negative
     */
    public static BigInteger fibonacci(int n) throws InvalidInputException{
        if(n < 0){
            throw new InvalidInputException(
                    format(INVALID_VALUE_INPUT_FIBONACCI.getMessage(), n));
        }
        if(n == 0){
            return BigInteger.ZERO;
        }
        if(n == 1){
            return BigInteger.ONE;
        }
        BigInteger [][] result = new BigInteger[][]{{BigInteger.ONE,BigInteger.ZERO},{BigInteger.ZERO, BigInteger.ONE}};
        BigInteger [][] base = new BigInteger[][]{{BigInteger.ONE,BigInteger.ONE},{BigInteger.ONE, BigInteger.ZERO}};
        n -= 1;
        while(n > 0){
            if(n % 2 == 1){
                result = matrixMultiple(result, base);
            }
            base = matrixMultiple(base, base);
            n /= 2;
        }

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
     * @throws NullPointerException if any of the input matrices or their elements are null
     * @throws ArrayIndexOutOfBoundsException if the input matrices are not properly structured as 2×2
     */
    public static BigInteger[][] matrixMultiple(BigInteger[][] a, BigInteger[][] b) {
        return new BigInteger[][]{
                {(a[0][0].multiply(b[0][0])).add(a[0][1].multiply(b[1][0])), (a[0][0].multiply(b[0][1])).add(a[0][1].multiply(b[1][1]))},
                {(a[1][0].multiply(b[0][0])).add(a[1][1].multiply(b[1][0])), (a[1][0].multiply(b[0][1])).add(a[1][1].multiply(b[1][1]))}
        };
    }


}
