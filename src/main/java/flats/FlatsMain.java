package flats;

import exceptions.CalculationException;
import exceptions.InvalidInputException;

import java.util.Scanner;

import static exceptions.CheckConsoleInput.readInteger;
import static exceptions.ExceptionMessages.INVALID_TYPE_INPUT_FLATS;
import static flats.Flats.numbers;

public class FlatsMain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Task 2. Enter number of floors in building, number flats on floor and number of searching flat:");

        try {
            String message = INVALID_TYPE_INPUT_FLATS.getMessage();

            Integer floors = readInteger(in, "number of floors", message);
            Integer flatsOnFloor = readInteger(in, "number of flats on floors", message);
            Integer flatNumber = readInteger(in, "number of flat", message);

            numbers(floors, flatsOnFloor, flatNumber);
        }catch (InvalidInputException | CalculationException e){
            System.out.print(e.getMessage());
        }

    }

}
