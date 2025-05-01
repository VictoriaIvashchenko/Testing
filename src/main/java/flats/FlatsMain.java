package flats;

import java.util.Scanner;

import static tools.GetConsoleInput.readInteger;
import static flats.Flats.flatLocation;

/**
 * Class {@code FlatMain} serves as entry point for determining the location of a flat in a building.
 *
 * <p>This class reads user input for the number of floors in a building,
 * the number of flats on each floor, and a specific flat number.
 * It then calculates and determines the flat's location within the building.</p>
 */
public class FlatsMain {

    /**
     * Value that represents max numeric value for input arguments(floors and number of flat).
     */
    private final static int MAX_VALUE = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int floors = readInteger(in, 1, MAX_VALUE, "number of floors");
        int maxFlatsOnFloor = Integer.MAX_VALUE / floors;

        int flatsOnFloor = readInteger(in, 1, maxFlatsOnFloor, "number of flats on floor");
        int flatNumber = readInteger(in, 1, MAX_VALUE, "flat number");

        int[] flatLocation = flatLocation(floors, flatsOnFloor, flatNumber);

        printResult(flatLocation);
    }

    /**
     * Method that prints results of calculations from method {@link Flats#flatLocation(int, int, int)}
     * @param values array that contains number of floor and entrance where the flat is situated
     */
    private static void printResult(int[] values) {
        System.out.printf("Floor: %d, entrance: %d%n", values[0], values[1]);
    }
}
