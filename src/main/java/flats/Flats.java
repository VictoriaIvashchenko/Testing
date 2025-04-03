package flats;

import exceptions.CalculationException;
import exceptions.ExceptionMessages;
import exceptions.InvalidInputException;

import static exceptions.ExceptionMessages.*;
import static java.lang.String.format;

public class Flats {
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
     * @param floors the total number of floors in the building
     * @param flatsOnFloor the number of apartments on each floor
     * @param flatNumber the apartment number to locate
     * @return an array where the first element is the floor number and the second element is the entrance number
     * @throws InvalidInputException if any input parameter is non-positive
     * @throws CalculationException if an overflow occurs during calculations
     */
    public static int[] flats(int floors, int flatsOnFloor, int flatNumber) throws InvalidInputException, CalculationException{
        checkValues(floors, INVALID_VALUE_FLOORS_INPUT_FLATS);
        checkValues(flatsOnFloor, INVALID_VALUE_FLATS_ON_FLOOR_INPUT_FLATS);
        checkValues(flatNumber, INVALID_VALUE_FLAT_NUMBER_INPUT_FLATS);

        if (floors > Integer.MAX_VALUE / flatsOnFloor)
            throw new CalculationException(format(INVALID_CALCULATIONS_FLATS.getMessage(), floors, flatsOnFloor));

        int apartmentsPerEntrance =  floors * flatsOnFloor;
        int numOfEntrance = ((flatNumber - 1) / apartmentsPerEntrance + 1);
        int floorNumber = (((flatNumber - 1) % apartmentsPerEntrance) / flatsOnFloor + 1);

        System.out.printf("Floor: %d, entrance: %d", floorNumber, numOfEntrance);

        return new int [] {floorNumber, numOfEntrance};
    }

    private static void checkValues(int value, ExceptionMessages message) throws InvalidInputException {
        if(value <= 0){
            throw new InvalidInputException(format(message.getMessage(), value));
        }
    }
}
