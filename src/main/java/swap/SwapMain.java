package swap;

import exceptions.InvalidInputException;

import java.util.Scanner;

import static exceptions.CheckConsoleInput.readInteger;
import static exceptions.ExceptionMessages.INVALID_TYPE_INPUT_SWAP;
import static swap.Swap.swap;

public class SwapMain {
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Task 1. Enter two numbers x and y:");
        try {
            String message = INVALID_TYPE_INPUT_SWAP.getMessage();

            Integer x = readInteger(in, "x", message);
            Integer y = readInteger(in, "y", message);

            swap(x, y);
        }catch (InvalidInputException e){
            System.out.print(e.getMessage());
        }


    }

}
