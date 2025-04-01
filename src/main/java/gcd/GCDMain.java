package gcd;

import exceptions.CalculationException;
import exceptions.InvalidInputException;

import java.util.Scanner;

import static exceptions.CheckConsoleInput.readInteger;
import static exceptions.ExceptionMessages.*;
import static gcd.GCD.gcdOfFour;
/**
 * Class {@code GCDMain} serves as the entry point for calculating the greatest common divisor (GCD)
 * of four integers using the {@link GCD} class methods.
 *
 * <p>This class prompts the user to input four integers, validates the input, and calculates the GCD of the four numbers
 * using the {@link GCD#gcdOfFour(int, int, int, int)} method. It handles invalid inputs and exceptional cases appropriately.</p>
 *
 */
public class GCDMain {
    /**
     * The main method that execute calculation gcd of four numbers.
     *
     * <p>This method interacts with the user to gather four integer values and
     * invoke {@link GCD#gcdOfFour(int, int, int, int)} to calculate the GCD of those values. It also handles any input or calculation
     * errors by printing appropriate error messages.</p>
     *
     * @param args command-line arguments (not used in this program)
     */
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Task 3. Enter four numbers for searching gcd:");

        String message = INVALID_TYPE_INPUT_GCD.getMessage();
        String exceptionalCase = "2147483648";

        try {
            Integer a = readInteger(in, "a", message);

            Integer b = readInteger(in, "b", message);

            Integer c = readInteger(in, "c", message);

            Integer d = readInteger(in, "d", message);

            System.out.printf("GCD(%d, %d, %d, %d) = ", a, b, c, d);
            System.out.print(gcdOfFour(a, b, c, d));
        }catch (InvalidInputException | CalculationException e){
            if(e.getMessage().equals(INVALID_RESULT_GCD.getMessage())){
                System.out.print(exceptionalCase);
            } else{
                System.err.print(e.getMessage());
            }
        }
    }

}
