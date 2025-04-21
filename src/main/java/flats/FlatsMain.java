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
 */
public class FlatsMain {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Task 2. Enter number of floors in building, number flats on floor and number of searching flat:");
        try {
            int floors = readInteger(in, "number of floors");
            int flatsOnFloor = readInteger(in, "number of flats on floors");
            int flatNumber = readInteger(in, "number of flat");

            int[] flatLocation = flatLocation(floors, flatsOnFloor, flatNumber);

            printResult(flatLocation);

        } catch (InvalidInputException | CalculationException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void printResult(int[] values) {
        System.out.printf("Floor: %d, entrance: %d%n", values[0], values[1]);
    }
}
