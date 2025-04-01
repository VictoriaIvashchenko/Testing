package fibonacci;

import exceptions.InvalidInputException;

import java.util.Scanner;

import static exceptions.CheckConsoleInput.readInteger;
import static exceptions.ExceptionMessages.INVALID_TYPE_INPUT_FIBONACCI;
import static fibonacci.Fibonacci.fibonacci;

/**
 * Class {@code FibonacciMain} serves as entry point for computing Fibonacci numbers using user input.
 *
 * <p>This class reads an integer from the console representing the index in the Fibonacci sequence
 * and invoke {@link fibonacci} method from class {@link Fibonacci} to calculate the corresponding Fibonacci number using matrix exponentiation.
 * The result is then printed to the console.</p>
 *
 * <p>If the input is invalid (e.g., non-integer or negative), an error message is displayed.</p>
 */
public class FibonacciMain {
    /**
     * The main method for executing the Fibonacci calculation.
     *
     * <p>This method prompts the user to enter an index for the Fibonacci sequence.
     * It reads the input, validates it, and calls {@link Fibonacci#fibonacci(int)} for getting the corresponding Fibonacci number.
     * If the input is invalid, an error message is printed.</p>
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Task 4. Enter index of number in fibonacci sequence:");
        try {
            Integer n = readInteger(in, "n", INVALID_TYPE_INPUT_FIBONACCI.getMessage());
            System.out.printf("F(%d) = %s", n, fibonacci(n).toString());
        }catch (InvalidInputException e){
            System.err.print(e.getMessage());

        }
    }
}
