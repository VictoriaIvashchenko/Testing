package gcd;

import exceptions.CalculationException;
import exceptions.InvalidInputException;

import java.util.Scanner;

import static exceptions.CheckConsoleInput.readInteger;
import static exceptions.ExceptionMessages.*;
import static gcd.GCD.gcdOfFour;

public class GCDMain {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Task 3. Enter four numbers for searching gcd:");

        try {
            String message = INVALID_TYPE_INPUT_GCD.getMessage();
            Integer a = readInteger(in, "a", message);

            Integer b = readInteger(in, "b", message);

            Integer c = readInteger(in, "c", message);

            Integer d = readInteger(in, "d", message);

            System.out.printf("GCD(%d, %d, %d, %d) = ", a, b, c, d);
            System.out.print(gcdOfFour(a, b, c, d));
        }catch (InvalidInputException | CalculationException e){

            if(e.getMessage().equals(INVALID_RESULT_GCD.getMessage())){
                System.out.print("2147483648");
            }
            else{
                System.out.print(e.getMessage());
            }
        }
    }

}
