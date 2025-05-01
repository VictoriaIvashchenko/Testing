package flatsTest;

import org.junit.jupiter.api.Test;
import flats.FlatsMain;

import static java.lang.String.format;
import static tools.ConsolePrintCheck.assertConsolePrint;

/**
 * Unit test class for {@link FlatsMain}.
 *
 * <p>This class extends {@link FlatsTest} and provides specific test configurations
 * for verifying the behavior of the {@link FlatsMain} program. It sets up the main method
 * for execution during tests and defines a system-dependent line separator.</p>
 */
public class FlatsMainTest extends FlatsTest {

    /**
     * A {@link Runnable} reference to the {@code main} method of {@link FlatsMain}.
     *
     * <p>This runnable executes {@link FlatsMain#main(String[])} with an empty argument array,
     * allowing test cases to simulate program execution.</p>
     */
    private final static Runnable MAIN_METHOD = () -> FlatsMain.main(new String[]{});

    /**
     * System-dependent line separator used for formatting expected test output.
     */
    private final static String LINE_BREAK = System.lineSeparator();

    /**
     * Prompt message for entering the number of floors.
     */
    private static final String PROMPT_FLOORS = String.format("Enter number of floors:%n");
    /**
     * Prompt message for entering the number of flats per floor.
     */
    private static final String PROMPT_FLATS_ON_FLOOR = String.format("Enter number of flats on floor:%n");
    /**
     * Prompt message for entering the flat number.
     */
    private static final String PROMPT_FLAT_NUMBER = String.format("Enter flat number:%n");

    /**
     * Warning message for invalid floors input, expecting a number from 1 to 2,147,483,647.
     */
    private static final String FLOORS_WARNING =
            String.format("[Warning] Invalid input value. Number from 1 to 2147483647 was expected.%n");
    /**
     * Warning message format for invalid flats per floor input, expecting a number from 1 to the maximum allowed
     * based on the number of floors.
     */
    private static final String FLATS_ON_FLOOR_WARNING =
            "[Warning] Invalid input value. Number from 1 to %d was expected.%n";
    /**
     * Warning message for invalid flat number input, expecting a number from 1 to 2,147,483,647.
     */
    private static final String FLAT_NUMBER_WARNING =
            String.format("[Warning] Invalid input value. Number from 1 to 2147483647 was expected.%n");


    /**
     * Message for invalid floors input followed by the month prompt, using for giving new attempt to enter value..
     */
    private static final String ATTEMPT_FLOORS_MESSAGE = FLOORS_WARNING + PROMPT_FLOORS;
    /**
     * Message for invalid number of flat input followed by the month prompt, using for giving new attempt to enter value..
     */
    private static final String ATTEMPT_FLAT_NUMBER_MESSAGE = FLAT_NUMBER_WARNING + PROMPT_FLAT_NUMBER;

    @Test
    public void floorsInputOverRangeTest() {
        assertInvalidArguments("2147483648|2", "2147483648|1", "2147483648|1", "1", "1");
        assertInvalidArguments("2147483648|2", "1", "1", "1", "1");
        assertInvalidArguments("2", "2147483648|1", "1", "1", "1");
        assertInvalidArguments("2", "1", "2147483648|1", "1", "1");

        assertInvalidArguments("0|2", "0|1", "0|1", "1", "1");
        assertInvalidArguments("0|2", "1", "1", "1", "1");
        assertInvalidArguments("2", "0|1", "1", "1", "1");
        assertInvalidArguments("2", "1", "0|1", "1", "1");

        assertInvalidArguments("-2147483649|2", "-2147483649|1", "-2147483649|1", "1", "1");
        assertInvalidArguments("-2147483649|2", "1", "1", "1", "1");
        assertInvalidArguments("2", "-2147483649|1", "1", "1", "1");
        assertInvalidArguments("2", "1", "-2147483649|1", "1", "1");
    }

    @Test
    public void charactersInputTest() {
        assertInvalidArguments("a|2", "a|1", "a|1", "1", "1");
        assertInvalidArguments("z|2", "z|1", "z|1", "1", "1");

        assertInvalidArguments("a|b|2", "a|b|1", "a|b|1", "1", "1");
        assertInvalidArguments("a|b|c|2", "a|b|c|1", "a|b|c|1", "1", "1");
        assertInvalidArguments("a|b|c|d|2", "a|b|c|d|1", "a|b|c|d|1", "1", "1");

        assertInvalidArguments("y|z|2", "y|z|1", "y|z|1", "1", "1");
        assertInvalidArguments("x|y|z|2", "x|y|z|1", "x|y|z|1", "1", "1");
        assertInvalidArguments("w|x|y|z|2", "w|x|y|z|1", "w|x|y|z|1", "1", "1");

        assertInvalidArguments("A|2", "A|1", "a|1", "1", "1");
        assertInvalidArguments("Z|2", "Z|1", "z|1", "1", "1");

        assertInvalidArguments("A|B|2", "A|B|1", "A|B|1", "1", "1");
        assertInvalidArguments("A|B|C|2", "A|B|C|1", "A|B|C|1", "1", "1");
        assertInvalidArguments("A|B|C|D|2", "A|B|C|D|1", "A|B|C|D|1", "1", "1");

        assertInvalidArguments("Y|Z|2", "Y|Z|1", "Y|Z|1", "1", "1");
        assertInvalidArguments("X|Y|Z|2", "X|Y|Z|1", "X|Y|Z|1", "1", "1");
        assertInvalidArguments("W|X|Y|Z|2", "W|X|Y|Z|1", "W|X|Y|Z|1", "1", "1");

        assertInvalidArguments("!|2", "!|2", "!|1", "1", "1");
        assertInvalidArguments("!|@|2", "!|@|2", "!|@|1", "1", "1");
        assertInvalidArguments("!|@|#|2", "!|@|#|1", "!|@|#|1", "1", "1");

        assertInvalidArguments("a 1|2", "pi|1", "zero 2|1", "1", "1");
        assertInvalidArguments("5 7|2", "8 9|1", "2 4|1", "1", "1");
        assertInvalidArguments("2%|2", "5^4|1", "4 %|1", "1", "1");
    }

    @Test
    public void invalidNumericTypeTest() {
        assertInvalidArguments("1.3|2", "34.5|1", "21.4|1", "1", "1");
        assertInvalidArguments("587.57|0.56|2", "34.5|0.46|1", "21.4|0.48|1", "1", "1");
        assertInvalidArguments("57.39|0.4|-15.22|2", "34.5|0.465|-464.2|1", "21.4|0.26|-12.5|1", "1", "1");
        assertInvalidArguments("1.3|0.45|-5.23|.45|2", "34.5|0.45|-5.23|.45|1", "21.4|0.45|-5.23|.45|1", "1", "1");

        assertInvalidArguments("1.3 1|2", "45.56 2|1", "5.5 5|1", "1", "1");
        assertInvalidArguments("1L 1|45.5|2", "-411.4 2|1", "-0.12 5|455.1|1", "1", "1");
        assertInvalidArguments("1.3 1|584.45 5|2", "45.56 2|430.1 12|1", "5.5 5|54.5|1", "1", "1");

        assertInvalidArguments("#456236|2", "#596345|1", "#569812|1", "1", "1");
        assertInvalidArguments("#786215|#125621|2", "#786215|#125621|1", "#786215|#125621|1", "1", "1");
        assertInvalidArguments("#786215|#125621|#896546|2", "#786215|#125621|#786512|1", "#783236|#786215|#125621|1", "1", "1");

        assertInvalidArguments("#456236 5|2", "#596345 1|1", "#569812 5|1", "1", "1");
        assertInvalidArguments("#456236 7|2", "#596345 9|1", "#569812 7|1", "1", "1");
    }

    /**
     * Asserts that the floor and entrance for a given flat number are correctly calculated
     * based on the provided input values for floors in the building, flats on each floor, and the flat number.
     *
     * @param floors           the total number of floors in the building
     * @param flatsOnFloor     the number of flats on each floor
     * @param flatNumber       the flat number for which the floor and entrance are being calculated
     * @param expectedFloor    the expected floor number where the flat is located
     * @param expectedEntrance the expected entrance number for the flat
     */
    @Override
    public void assertEqualsApart(int floors, int flatsOnFloor, int flatNumber, int expectedFloor, int expectedEntrance) {
        String input = getInput(floors, flatsOnFloor, flatNumber);

        String expectedOutput = format("%s%s%sFloor: %d, entrance: %d%n", PROMPT_FLOORS, PROMPT_FLATS_ON_FLOOR, PROMPT_FLAT_NUMBER, expectedFloor, expectedEntrance);
        String expectedErrorOutput = "";

        assertConsolePrint(input, expectedOutput, expectedErrorOutput, expectedOutput, MAIN_METHOD);
    }

    /**
     * Constructs an input string from floors, flats per floor, and flat number, formatted with line breaks.
     *
     * @param floor the number of floors
     * @param flatsOnFloor the number of flats per floor
     * @param flatNumber the flat number
     * @return a string containing the floors, flats per floor, and flat number, separated by line breaks
     */
    private static String getInput(int floor, int flatsOnFloor, int flatNumber) {
        return floor + LINE_BREAK + flatsOnFloor + LINE_BREAK + flatNumber + LINE_BREAK;
    }

    /**
     * Asserts that the console output and error messages match the expected results for a sequence of invalid and valid
     * inputs for floors, flats per floor, and flat number, simulating user interaction and validating the final result.
     *
     * @param floors a string of pipe-separated floors inputs (e.g., "0|-1|5"), where the last value is valid
     * @param flatsOnFloor a string of pipe-separated flats per floor inputs (e.g., "0|1000000000|4"), where the last value is valid
     * @param flatNumber a string of pipe-separated flat number inputs (e.g., "0|-1|12"), where the last value is valid
     * @param expectedFloor the expected floor number as a string
     * @param expectedEntrance the expected entrance number as a string
     */
    public void assertInvalidArguments(String floors, String flatsOnFloor, String flatNumber, String expectedFloor,
                                       String expectedEntrance) {
        String[] floorsValues = floors.split("\\|");
        String[] flatsOnFloorValues = flatsOnFloor.split("\\|");
        String[] flatNumberInvalidValues = flatNumber.split("\\|");

        int countFloorsValues = floorsValues.length;
        int countFlatsOnFloorValues = flatsOnFloorValues.length;
        int countFlatNumbersValues = flatNumberInvalidValues.length;

        String expectedResult = format("Floor: %s, entrance: %s%n", expectedFloor, expectedEntrance);

        String flatsOnFloorWarning = getFlatsOnFloorMessage(floorsValues);
        String attemptFlatsOnFloor = flatsOnFloorWarning + PROMPT_FLATS_ON_FLOOR;

        String input = getInput(floorsValues, flatsOnFloorValues, flatNumberInvalidValues);

        String expectedOutput = PROMPT_FLOORS.repeat(countFloorsValues) +
                PROMPT_FLATS_ON_FLOOR.repeat(countFlatsOnFloorValues) +
                PROMPT_FLAT_NUMBER.repeat(countFlatNumbersValues) + expectedResult;
        String expectedError = FLOORS_WARNING.repeat(countFloorsValues - 1) +
                flatsOnFloorWarning.repeat(countFlatsOnFloorValues - 1) +
                FLAT_NUMBER_WARNING.repeat(countFlatNumbersValues - 1);
        String expectedFullOutput = PROMPT_FLOORS + ATTEMPT_FLOORS_MESSAGE.repeat(countFloorsValues - 1) +
                PROMPT_FLATS_ON_FLOOR + attemptFlatsOnFloor.repeat(countFlatsOnFloorValues - 1) +
                PROMPT_FLAT_NUMBER + ATTEMPT_FLAT_NUMBER_MESSAGE.repeat(countFlatNumbersValues - 1) + expectedResult;

        assertConsolePrint(input, expectedOutput, expectedError, expectedFullOutput, MAIN_METHOD);
    }

    /**
     * Constructs a single input string by combining arrays of floors, flats per floor, and flat number inputs,
     * separated by line breaks.
     *
     * @param floorsInput array of floors input values
     * @param flatsOnFloorInput array of flats per floor input values
     * @param flatNumberInput array of flat number input values
     * @return a string containing all input values concatenated with line breaks
     */
    private static String getInput(String[] floorsInput, String[] flatsOnFloorInput, String[] flatNumberInput) {
        String floorsValues = String.join(LINE_BREAK, floorsInput);
        String flatsOnFloorValues = String.join(LINE_BREAK, flatsOnFloorInput);
        String flatNumberValues = String.join(LINE_BREAK, flatNumberInput);

        return floorsValues + LINE_BREAK + flatsOnFloorValues + LINE_BREAK + flatNumberValues;
    }

    /**
     * Generates a warning message for invalid flats per floor input based on the maximum allowed flats
     * given the number of floors.
     *
     * @param floorsValues array of floors input values, where the last value is assumed to be valid
     * @return a formatted warning message indicating the valid range for flats per floor
     */
    private static String getFlatsOnFloorMessage(String[] floorsValues) {
        String validFloors = floorsValues[floorsValues.length - 1];
        int floors = Integer.parseInt(validFloors);

        int maxFlatsOnFloor = Integer.MAX_VALUE / floors;

        return String.format(FLATS_ON_FLOOR_WARNING, maxFlatsOnFloor);
    }
}
