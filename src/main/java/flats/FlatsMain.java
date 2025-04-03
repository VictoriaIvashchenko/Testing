package flats;

import exceptions.CalculationException;
import exceptions.InvalidInputException;

import java.util.Scanner;

import static exceptions.CheckConsoleInput.readInteger;
import static exceptions.ExceptionMessages.INVALID_TYPE_INPUT_FLATS;
import static flats.Flats.flats;

/**
 * Class {@code FlatMain} serves as entry point for determining the location of a flat in a building.
 *
 * <p>This class reads user input for the number of floors in a building,
 * the number of flats on each floor, and a specific flat number.
 * It then calculates and determines the flat's location within the building.</p>
 *
 * <p>If the input is invalid (e.g., non-integer values or out-of-range numbers),
 * an error message is displayed.</p>
 */
public class FlatsMain {

    /**
     * The main method for executing the flat location calculation.
     *
     * <p>This method prompts the user to enter the number of floors, flats per floor,
     * and the flat number to search for. It reads the input, validates it, and invoke {@link flats} for computing
     * the flat's location. If the input is invalid, an error message is displayed.</p>
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Task 2. Enter number of floors in building, number flats on floor and number of searching flat:");

        String message = INVALID_TYPE_INPUT_FLATS.getMessage();

        try {

            Integer floors = readInteger(in, "number of floors", message);
            Integer flatsOnFloor = readInteger(in, "number of flats on floors", message);
            Integer flatNumber = readInteger(in, "number of flat", message);

            flats(floors, flatsOnFloor, flatNumber);
        }catch (InvalidInputException | CalculationException e){
            System.err.print(e.getMessage());
        }

    }

}
