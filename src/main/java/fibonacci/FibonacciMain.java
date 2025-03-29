package fibonacci;

import exceptions.InvalidInputException;

import java.util.Scanner;

import static exceptions.CheckConsoleInput.readInteger;
import static exceptions.ExceptionMessages.INVALID_TYPE_INPUT_FIBONACCI;
import static fibonacci.Fibonacci.fibonacci;

public class FibonacciMain {
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Task 4. Enter index of number in fibonacci sequence:");

        try {
            String message = INVALID_TYPE_INPUT_FIBONACCI.getMessage();
            Integer n = readInteger(in, "n", message);
            System.out.printf("F(%d) = %s", n, fibonacci(n).toString());
        }catch (InvalidInputException e){
            System.out.print(e.getMessage());

        }
    }
}
