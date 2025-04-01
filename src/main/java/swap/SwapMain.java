package swap;

import exceptions.InvalidInputException;

import java.util.Scanner;

import static exceptions.CheckConsoleInput.readInteger;
import static exceptions.ExceptionMessages.INVALID_TYPE_INPUT_SWAP;
import static swap.Swap.swap;

/**
 * The {@code SwapMain} class serves as the entry point for executing the swap operation.
 *
 * <p>This class reads two integer inputs from the user, performs validation, and invokes the {@link swap} method
 * from the {@link Swap} class to swap the values.</p>
 *
 */
public class SwapMain {
    /**
     * The main method that executes the swapping operation.
     *
     * <p>It prompts the user to enter two integer values, validates the input,
     * and calls the {@link swap} method. If the input is invalid, an error message is displayed.</p>
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Task 1. Enter two numbers x and y:");
        String message = INVALID_TYPE_INPUT_SWAP.getMessage();

        try {
            Integer x = readInteger(in, "x", message);
            Integer y = readInteger(in, "y", message);

            swap(x, y);
        }catch (InvalidInputException e){
            System.err.print(e.getMessage());
        }


    }

}
