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
        assertInvalidArguments("2147483648\n2", "2147483648\n1", "2147483648\n1", "1", "1");
        assertInvalidArguments("2147483648\n2", "1", "1", "1", "1");
        assertInvalidArguments("2", "2147483648\n1", "1", "1", "1");
        assertInvalidArguments("2", "1", "2147483648\n1", "1", "1");

        assertInvalidArguments("0\n2", "0\n1", "0\n1", "1", "1");
        assertInvalidArguments("0\n2", "1", "1", "1", "1");
        assertInvalidArguments("2", "0\n1", "1", "1", "1");
        assertInvalidArguments("2", "1", "0\n1", "1", "1");

        assertInvalidArguments("-2147483649\n2", "-2147483649\n1", "-2147483649\n1", "1", "1");
        assertInvalidArguments("-2147483649\n2", "1", "1", "1", "1");
        assertInvalidArguments("2", "-2147483649\n1", "1", "1", "1");
        assertInvalidArguments("2", "1", "-2147483649\n1", "1", "1");

        assertInvalidArguments("2", "1073741824\n1073741823", "1", "1", "1");
        assertInvalidArguments("10", "214748365\n214748364", "2", "1", "1");

        assertInvalidArguments("2147483648\n2147483649\n1", "2147483648\n2147483649\n1", "2147483648\n2147483649\n1", "1", "1");
        assertInvalidArguments("0\n-1\n9", "0\n-1\n4", "0\n-1\n51", "4", "2");
        assertInvalidArguments("-2\n-3\n-3\n9", "-2\n-3\n-3\n4", "-2\n-3\n-3\n51", "4", "2");
        assertInvalidArguments("-4\n-5\n-6\n-7\n9", "-4\n-5\n-6\n-7\n4", "-4\n-5\n-6\n-7\n51", "4", "2");
        assertInvalidArguments("-4\n-5\n-6\n-7\n-10\n9", "-4\n-5\n-6\n-7\n-9\n4", "-4\n-5\n-6\n-7\n-122\n51", "4", "2");

    }

    @Test
    public void charactersInputTest() {
        assertInvalidArguments("a\n2", "a\n1", "a\n1", "1", "1");
        assertInvalidArguments("z\n2", "z\n1", "z\n1", "1", "1");

        assertInvalidArguments("a\nb\n2", "a\nb\n1", "a\nb\n1", "1", "1");
        assertInvalidArguments("a\nb\nc\n2", "a\nb\nc\n1", "a\nb\nc\n1", "1", "1");
        assertInvalidArguments("a\nb\nc\nd\n2", "a\nb\nc\nd\n1", "a\nb\nc\nd\n1", "1", "1");

        assertInvalidArguments("y\nz\n2", "y\nz\n1", "y\nz\n1", "1", "1");
        assertInvalidArguments("x\ny\nz\n2", "x\ny\nz\n1", "x\ny\nz\n1", "1", "1");
        assertInvalidArguments("w\nx\ny\nz\n2", "w\nx\ny\nz\n1", "w\nx\ny\nz\n1", "1", "1");

        assertInvalidArguments("A\n2", "A\n1", "a\n1", "1", "1");
        assertInvalidArguments("Z\n2", "Z\n1", "z\n1", "1", "1");

        assertInvalidArguments("A\nB\n2", "A\nB\n1", "A\nB\n1", "1", "1");
        assertInvalidArguments("A\nB\nC\n2", "A\nB\nC\n1", "A\nB\nC\n1", "1", "1");
        assertInvalidArguments("A\nB\nC\nD\n2", "A\nB\nC\nD\n1", "A\nB\nC\nD\n1", "1", "1");

        assertInvalidArguments("Y\nZ\n2", "Y\nZ\n1", "Y\nZ\n1", "1", "1");
        assertInvalidArguments("X\nY\nZ\n2", "X\nY\nZ\n1", "X\nY\nZ\n1", "1", "1");
        assertInvalidArguments("W\nX\nY\nZ\n2", "W\nX\nY\nZ\n1", "W\nX\nY\nZ\n1", "1", "1");

        assertInvalidArguments("!\n2", "!\n2", "!\n1", "1", "1");
        assertInvalidArguments("!\n@\n2", "!\n@\n2", "!\n@\n1", "1", "1");
        assertInvalidArguments("!\n@\n#\n2", "!\n@\n#\n1", "!\n@\n#\n1", "1", "1");

        assertInvalidArguments("a 1\n2", "pi\n1", "zero 2\n1", "1", "1");
        assertInvalidArguments("5 7\n2", "8 9\n1", "2 4\n1", "1", "1");
        assertInvalidArguments("2%\n2", "5^4\n1", "4 %\n1", "1", "1");

        assertInvalidArguments("(o･｀Д´･o)!!\n9", "U^ェ^U\n4", "(*・ｘ・)ノ~~~♪\n74", "1", "3");
    }

    @Test
    public void invalidNumericTypeTest() {
        assertInvalidArguments("1.3\n2", "34.5\n1", "21.4\n1", "1", "1");
        assertInvalidArguments("587.57\n0.56\n2", "34.5\n0.46\n1", "21.4\n0.48\n1", "1", "1");
        assertInvalidArguments("57.39\n0.4\n-15.22\n2", "34.5\n0.465\n-464.2\n1", "21.4\n0.26\n-12.5\n1", "1", "1");
        assertInvalidArguments("1.3\n0.45\n-5.23\n.45\n2", "34.5\n0.45\n-5.23\n.45\n1", "21.4\n0.45\n-5.23\n.45\n1", "1", "1");

        assertInvalidArguments("1.3 1\n2", "45.56 2\n1", "5.5 5\n1", "1", "1");
        assertInvalidArguments("1L 1\n45.5\n2", "-411.4 2\n1", "-0.12 5\n455.1\n1", "1", "1");
        assertInvalidArguments("1.3 1\n584.45 5\n2", "45.56 2\n430.1 12\n1", "5.5 5\n54.5\n1", "1", "1");

        assertInvalidArguments("#456236\n2", "#596345\n1", "#569812\n1", "1", "1");
        assertInvalidArguments("#786215\n#125621\n2", "#786215\n#125621\n1", "#786215\n#125621\n1", "1", "1");
        assertInvalidArguments("#786215\n#125621\n#896546\n2", "#786215\n#125621\n#786512\n1", "#783236\n#786215\n#125621\n1", "1", "1");

        assertInvalidArguments("#456236 5\n2", "#596345 1\n1", "#569812 5\n1", "1", "1");
        assertInvalidArguments("#456236 7\n2", "#596345 9\n1", "#569812 7\n1", "1", "1");
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
     * @param floor        the number of floors
     * @param flatsOnFloor the number of flats per floor
     * @param flatNumber   the flat number
     * @return a string containing the floors, flats per floor, and flat number, separated by "\n"
     */
    private static String getInput(int floor, int flatsOnFloor, int flatNumber) {
        return floor + "\n" + flatsOnFloor + "\n" + flatNumber + "\n";
    }

    /**
     * Asserts that the console output and error messages match the expected results for a sequence of invalid and valid
     * inputs for floors, flats per floor, and flat number, simulating user interaction and validating the final result.
     *
     * @param floors           a string of pipe-separated floors inputs (e.g., "0\n-1\n5"), where the last value is valid
     * @param flatsOnFloor     a string of pipe-separated flats per floor inputs (e.g., "0\n1000000000\n4"), where the last value is valid
     * @param flatNumber       a string of pipe-separated flat number inputs (e.g., "0\n-1\n12"), where the last value is valid
     * @param expectedFloor    the expected floor number as a string
     * @param expectedEntrance the expected entrance number as a string
     */
    public void assertInvalidArguments(String floors, String flatsOnFloor, String flatNumber, String expectedFloor,
                                       String expectedEntrance) {
        int countFloorsValues = getCount(floors);
        int countFlatsOnFloorValues = getCount(flatsOnFloor);
        int countFlatNumbersValues = getCount(flatNumber);

        String flatsOnFloorWarning = getFlatsOnFloorMessage(floors);
        String attemptFlatsOnFloor = flatsOnFloorWarning + PROMPT_FLATS_ON_FLOOR;

        String expectedResult = format("Floor: %s, entrance: %s%n", expectedFloor, expectedEntrance);

        String input = String.join("\n", floors, flatsOnFloor, flatNumber);

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
     * Method counts values in input string in which "\n" uses as separator
     *
     * @param stringInput string contains input values
     * @return count of values in input string
     */
    private static int getCount(String stringInput) {
        String[] values = stringInput.split("\n");
        return values.length;
    }

    /**
     * Generates a warning message for invalid flats per floor input based on the maximum allowed flats
     * given the number of floors.
     *
     * @param floorsInput string of floors input values, where the last value is assumed to be valid
     * @return a formatted warning message indicating the valid range for flats per floor
     */
    private static String getFlatsOnFloorMessage(String floorsInput) {
        String[] floorsValues = floorsInput.split("\n");
        String validFloors = floorsValues[floorsValues.length - 1];
        int floors = Integer.parseInt(validFloors);

        int maxFlatsOnFloor = Integer.MAX_VALUE / floors;

        return String.format(FLATS_ON_FLOOR_WARNING, maxFlatsOnFloor);
    }
}
