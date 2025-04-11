package fibonacci;

import exceptions.InvalidInputException;

import java.math.BigInteger;
import java.util.Scanner;

import static tools.CheckConsoleInput.readInteger;
import static fibonacci.Fibonacci.fibonacci;

/**
 * Class {@code FibonacciMain} serves as entry point for computing Fibonacci numbers using user input.
 *
 * <p>This class reads an integer from the console representing the index in the Fibonacci sequence
 * and invoke {@link fibonacci} method from class {@link Fibonacci} to calculate the corresponding Fibonacci number using matrix exponentiation.
 * The result is then printed to the console.</p>
 */
public class FibonacciMain {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String message = "Invalid type of %s. Number from 0 to 2147483647 was expected, but '%s' was received.";

        System.out.println("Task 4. Enter index of number in fibonacci sequence:");
        try {
            int n = readInteger(in, "n", message);

            BigInteger result = fibonacci(n);

            printResult(n, result);

        } catch (InvalidInputException e) {
            System.err.print(e.getMessage());
        }
    }

    private static void printResult(int index, BigInteger number){
        System.out.printf("F(%d) = %s", index, number.toString());

    }
}
