package fibonacci;

import java.math.BigInteger;
import java.util.Scanner;

import static tools.GetConsoleInput.readInteger;
import static fibonacci.Fibonacci.fibonacci;

/**
 * Class {@code FibonacciMain} serves as entry point for computing Fibonacci numbers using user input.
 *
 * <p>This class reads an integer from the console representing the index in the Fibonacci sequence
 * and invoke {@link fibonacci} method from class {@link Fibonacci} to calculate the corresponding Fibonacci number using matrix exponentiation.
 * The result is then printed to the console.</p>
 */
public class FibonacciMain {

    /**
     * Value that represents max index number in Fibonacci sequence.
     */
    private final static int MAX_INDEX = Integer.MAX_VALUE;

    /**
     * Value that represents min index number in Fibonacci sequence.
     */
    private final static int MIN_INDEX = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = readInteger(in, MIN_INDEX, MAX_INDEX, "index");

        BigInteger numberInFibonacciSequence = fibonacci(n);

        printResult(n, numberInFibonacciSequence);
    }

    /**
     * Method that prints result of calculations method {@link Fibonacci#fibonacci(int)}
     * @param index index of number in Fibonacci sequence
     * @param number value of number in Fibonacci sequence
     */
    private static void printResult(int index, BigInteger number) {
        System.out.printf("F(%d) = %s%n", index, number.toString());
    }
}
