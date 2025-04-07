package flats;

import exceptions.CalculationException;
import exceptions.InvalidInputException;

import static java.lang.String.format;

public class Flats {
    /**
     * Error message for an invalid number of floors input in flat calculations.
     */
    private final static String INVALID_VALUE_FLOORS_INPUT_MESSAGE =
            "Invalid input number of floors. Number from 1 to 2147483647 was expected, but '%s' was received.";
    /**
     * Error message for an invalid number of flats per floor in flat calculations.
     */
    private final static String INVALID_VALUE_FLATS_ON_FLOOR_INPUT_MESSAGE =
            "Invalid input number of flats on floor. Number from 1 to 2147483647 was expected, but '%s' was received.";
    /**
     * Error message for an invalid flat number input.
     */
    private final static String INVALID_VALUE_FLAT_NUMBER_INPUT_MESSAGE =
            "Invalid input number of flat. Number from 1 to 2147483647 was expected, but '%s' was received.";
    /**
     * Error message when calculations with the given flat parameters are not possible.
     */
    private final static String INVALID_CALCULATIONS_MESSAGE =
            "Task can't be calculated with input arguments: %d floors, %d flats on floor.";

    /**
     * Determines the floor and entrance number of an apartment in a multi-story building.
     *
     * <p>The method calculates the entrance and floor number based on the total number
     * of floors in the building, the number of apartments per floor, and the given
     * apartment number.</p>
     *
     * <p>It first validates the input values to ensure they are positive and
     * within a reasonable range. If any value is invalid, an {@link InvalidInputException}
     * is thrown. Additionally, if the calculation results in an overflow,
     * a {@link CalculationException} is thrown.</p>
     *
     * @param floors       the total number of floors in the building
     * @param flatsOnFloor the number of apartments on each floor
     * @param flatNumber   the apartment number to locate
     * @return an array where the first element is the floor number and the second element is the entrance number
     * @throws InvalidInputException if any input parameter is non-positive
     * @throws CalculationException  if an overflow occurs during calculations
     */
    public static int[] flatLocation(int floors, int flatsOnFloor, int flatNumber) throws InvalidInputException, CalculationException {
        checkValues(floors, INVALID_VALUE_FLOORS_INPUT_MESSAGE);
        checkValues(flatsOnFloor, INVALID_VALUE_FLATS_ON_FLOOR_INPUT_MESSAGE);
        checkValues(flatNumber, INVALID_VALUE_FLAT_NUMBER_INPUT_MESSAGE);

        if (floors > Integer.MAX_VALUE / flatsOnFloor)
            throw new CalculationException(format(INVALID_CALCULATIONS_MESSAGE, floors, flatsOnFloor));

        int apartmentsPerEntrance = floors * flatsOnFloor;
        int numOfEntrance = ((flatNumber - 1) / apartmentsPerEntrance + 1);
        int floorNumber = (((flatNumber - 1) % apartmentsPerEntrance) / flatsOnFloor + 1);

        return new int[]{floorNumber, numOfEntrance};
    }

    private static void checkValues(int value, String message) throws InvalidInputException {
        if (value <= 0) {
            throw new InvalidInputException(format(message, value));
        }
    }
}
