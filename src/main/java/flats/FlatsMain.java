package flats;

import exceptions.CalculationException;
import exceptions.InvalidInputException;

import java.util.Scanner;

import static tools.CheckConsoleInput.readInteger;
import static flats.Flats.flatLocation;

/**
 * Class {@code FlatMain} serves as entry point for determining the location of a flat in a building.
 *
 * <p>This class reads user input for the number of floors in a building,
 * the number of flats on each floor, and a specific flat number.
 * It then calculates and determines the flat's location within the building.</p>
 *
 */
public class FlatsMain {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String message = "Invalid type of %s. Number from 1 to 2147483647 was expected, but '%s' was received.";

        System.out.println("Task 2. Enter number of floors in building, number flats on floor and number of searching flat:");
        try {
            int floors = readInteger(in, "number of floors", message);
            int flatsOnFloor = readInteger(in, "number of flats on floors", message);
            int flatNumber = readInteger(in, "number of flat", message);

            int [] result = flatLocation(floors, flatsOnFloor, flatNumber);

            printResult(result);

        }catch (InvalidInputException | CalculationException e){
            System.err.print(e.getMessage());
        }
    }

    private static void printResult(int [] values){
        System.out.printf("Floor: %d, entrance: %d", values[0], values[1]);
    }

}
