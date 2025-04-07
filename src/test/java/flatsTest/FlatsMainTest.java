package flatsTest;

import org.junit.jupiter.api.Test;
import flats.FlatsMain;

import static java.lang.String.format;
import static tools.ConsolePrintCheck.assertValidConsolePrint;

/**
 * Unit test class for {@link FlatsMain}.
 *
 * <p>This class extends {@link FlatsTest} and provides specific test configurations
 * for verifying the behavior of the {@link FlatsMain} program. It sets up the main method
 * for execution during tests and defines a system-dependent line separator.</p>
 */
public class FlatsMainTest extends FlatsTest {

    /**
     * Error message for an invalid type input in flat calculations.
     */
    final static String INVALID_INPUT_TYPE_MESSAGE =
            "Invalid type of %s. Number from 1 to 2147483647 was expected, but '%s' was received.";
    /**
     * System-dependent line separator used for formatting expected test output.
     */
    final static String SEPARATOR = System.lineSeparator();
    /**
     * A {@link Runnable} reference to the {@code main} method of {@link FlatsMain}.
     *
     * <p>This runnable executes {@link FlatsMain#main(String[])} with an empty argument array,
     * allowing test cases to simulate program execution.</p>
     */
    final static Runnable MAIN_METHOD = () -> FlatsMain.main(new String[]{});

    @Test
    void overRangeTypeTest() {
        //(1, 1, MAX)
        assertInvalidFlatNumberType("1", "1", "2147483648");
        assertInvalidFlatNumberType("1", "0", "2147483648");
        assertInvalidFlatNumberType("1", "2", "2147483648");
        assertInvalidFlatNumberType("0", "1", "2147483648");
        assertInvalidFlatNumberType("0", "0", "2147483648");
        assertInvalidFlatNumberType("0", "2", "2147483648");
        assertInvalidFlatNumberType("2", "1", "2147483648");
        assertInvalidFlatNumberType("2", "0", "2147483648");
        assertInvalidFlatNumberType("2", "2", "2147483648");
        //(MAX, 1, 1)
        assertInvalidFloorsType("2147483648", "1", "1");
        assertInvalidFloorsType("2147483648", "1", "0");
        assertInvalidFloorsType("2147483648", "1", "2");
        assertInvalidFloorsType("2147483648", "0", "1");
        assertInvalidFloorsType("2147483648", "0", "0");
        assertInvalidFloorsType("2147483648", "0", "2");
        assertInvalidFloorsType("2147483648", "2", "1");
        assertInvalidFloorsType("2147483648", "2", "0");
        assertInvalidFloorsType("2147483648", "2", "2");
        //(MAX, 1, MAX)
        assertInvalidFlatNumberType("2147483647", "1", "2147483648");
        assertInvalidFlatNumberType("2147483647", "0", "2147483648");
        assertInvalidFlatNumberType("2147483647", "2", "2147483648");
        assertInvalidFloorsType("2147483648", "1", "2147483647");
        assertInvalidFloorsType("2147483648", "1", "2147483648");
        assertInvalidFloorsType("2147483648", "1", "2147483646");
        assertInvalidFloorsType("2147483648", "0", "2147483647");
        assertInvalidFloorsType("2147483648", "0", "2147483648");
        assertInvalidFloorsType("2147483648", "0", "2147483646");
        assertInvalidFloorsType("2147483648", "2", "2147483647");
        assertInvalidFloorsType("2147483648", "2", "2147483648");
        assertInvalidFloorsType("2147483648", "2", "2147483646");
        assertInvalidFlatNumberType("2147483646", "1", "2147483648");
        assertInvalidFlatNumberType("2147483646", "0", "2147483648");
        assertInvalidFlatNumberType("2147483646", "2", "2147483648");
        //(1, MAX, MAX)
        assertInvalidFlatNumberType("1", "2147483647", "2147483648");
        assertInvalidFlatLocationOnFloorType("1", "2147483648", "2147483647");
        assertInvalidFlatLocationOnFloorType("1", "2147483648", "2147483648");
        assertInvalidFlatLocationOnFloorType("1", "2147483648", "2147483646");
        assertInvalidFlatNumberType("1", "2147483646", "2147483648");
        assertInvalidFlatNumberType("0", "2147483647", "2147483648");
        assertInvalidFlatLocationOnFloorType("0", "2147483648", "2147483647");
        assertInvalidFlatLocationOnFloorType("0", "2147483648", "2147483648");
        assertInvalidFlatLocationOnFloorType("0", "2147483648", "2147483646");
        assertInvalidFlatNumberType("0", "2147483646", "2147483648");
        assertInvalidFlatNumberType("2", "2147483647", "2147483648");
        assertInvalidFlatLocationOnFloorType("2", "2147483648", "2147483647");
        assertInvalidFlatLocationOnFloorType("2", "2147483648", "2147483648");
        assertInvalidFlatLocationOnFloorType("2", "2147483648", "2147483646");
        assertInvalidFlatNumberType("2", "2147483646", "2147483648");
        //(1, MAX, 1)
        assertInvalidFlatLocationOnFloorType("1", "2147483648", "1");
        assertInvalidFlatLocationOnFloorType("1", "2147483648", "0");
        assertInvalidFlatLocationOnFloorType("1", "2147483648", "2");
        assertInvalidFlatLocationOnFloorType("0", "2147483648", "1");
        assertInvalidFlatLocationOnFloorType("0", "2147483648", "0");
        assertInvalidFlatLocationOnFloorType("0", "2147483648", "2");
        assertInvalidFlatLocationOnFloorType("2", "2147483648", "1");
        assertInvalidFlatLocationOnFloorType("2", "2147483648", "0");
        assertInvalidFlatLocationOnFloorType("2", "2147483648", "2");
        //(MAX, MAX, MAX)
        assertInvalidFlatNumberType("2147483647", "2147483647", "2147483648");
        assertInvalidFlatLocationOnFloorType("2147483647", "2147483648", "2147483647");
        assertInvalidFlatLocationOnFloorType("2147483647", "2147483648", "2147483648");
        assertInvalidFlatLocationOnFloorType("2147483647", "2147483648", "2147483646");
        assertInvalidFlatNumberType("2147483647", "2147483646", "2147483648");
        assertInvalidFloorsType("2147483648", "2147483647", "2147483647");
        assertInvalidFloorsType("2147483648", "2147483647", "2147483648");
        assertInvalidFloorsType("2147483648", "2147483647", "2147483646");
        assertInvalidFloorsType("2147483648", "2147483648", "2147483647");
        assertInvalidFloorsType("2147483648", "2147483648", "2147483648");
        assertInvalidFloorsType("2147483648", "2147483648", "2147483646");
        assertInvalidFloorsType("2147483648", "2147483646", "2147483647");
        assertInvalidFloorsType("2147483648", "2147483646", "2147483648");
        assertInvalidFloorsType("2147483648", "2147483646", "2147483646");
        assertInvalidFlatNumberType("2147483646", "2147483647", "2147483648");
        assertInvalidFlatLocationOnFloorType("2147483646", "2147483648", "2147483647");
        assertInvalidFlatLocationOnFloorType("2147483646", "2147483648", "2147483648");
        assertInvalidFlatLocationOnFloorType("2147483646", "2147483648", "2147483646");
        assertInvalidFlatNumberType("2147483646", "2147483646", "2147483648");
        //(MAX, MIN, MAX)
        assertInvalidFloorsType("2147483648", "-2147483648", "2147483647");//(MAX + 1, MIN, MAX)
        assertInvalidFloorsType("2147483648", "-2147483648", "2147483648");//(MAX + 1, MIN, MAX + 1)
        assertInvalidFloorsType("2147483648", "-2147483648", "2147483646");//(MAX + 1, MIN, MAX - 1)
        assertInvalidFloorsType("2147483648", "-2147483649", "2147483647");//(MAX + 1, MIN - 1, MAX)
        assertInvalidFloorsType("2147483648", "-2147483649", "2147483648");//(MAX + 1, MIN - 1, MAX + 1)
        assertInvalidFloorsType("2147483648", "-2147483647", "2147483648");//(MAX + 1, MIN + 1, MAX + 1)
        assertInvalidFloorsType("2147483648", "-2147483647", "2147483646");//(MAX + 1, MIN + 1, MAX - 1)
        assertInvalidFloorsType("2147483648", "-2147483649", "2147483646");//(MAX + 1, MIN - 1, MAX - 1)
        assertInvalidFloorsType("2147483648", "-2147483647", "2147483647");//(MAX + 1, MIN - 1, MAX)
        assertInvalidFlatLocationOnFloorType("2147483647", "-2147483649", "2147483647");//(MAX, MIN - 1, MAX)
        assertInvalidFlatLocationOnFloorType("2147483647", "-2147483649", "2147483648");//(MAX, MIN - 1, MAX + 1)
        assertInvalidFlatLocationOnFloorType("2147483647", "-2147483649", "2147483646");//(MAX, MIN - 1, MAX - 1)
        assertInvalidFlatLocationOnFloorType("2147483646", "-2147483649", "2147483647");//(MAX - 1, MIN - 1, MAX)
        assertInvalidFlatLocationOnFloorType("2147483646", "-2147483649", "2147483648");//(MAX - 1, MIN - 1, MAX + 1)
        assertInvalidFlatLocationOnFloorType("2147483646", "-2147483649", "2147483646");//(MAX - 1, MIN - 1, MAX - 1)
        assertInvalidFlatNumberType("2147483646", "-2147483647", "2147483648");//(MAX - 1, MIN + 1, MAX + 1)
        assertInvalidFlatNumberType("2147483646", "-2147483648", "2147483648");//(MAX - 1, MIN, MAX + 1)
        assertInvalidFlatNumberType("2147483647", "-2147483647", "2147483648");//(MAX, MIN + 1, MAX + 1)
        assertInvalidFlatNumberType("2147483647", "-2147483648", "2147483648");//(MAX, MIN, MAX + 1)
        //(MAX, MIN, MIN)
        assertInvalidFloorsType("2147483648", "-2147483648", "-2147483648");//(MAX + 1, MIN, MIN)
        assertInvalidFloorsType("2147483648", "-2147483648", "-2147483649");//(MAX + 1, MIN, MIN - 1)
        assertInvalidFloorsType("2147483648", "-2147483648", "-2147483647");//(MAX + 1, MIN, MIN + 1)
        assertInvalidFloorsType("2147483648", "-2147483649", "-2147483648");//(MAX + 1, MIN - 1, MIN)
        assertInvalidFloorsType("2147483648", "-2147483649", "-2147483649");//(MAX + 1, MIN - 1, MIN - 1)
        assertInvalidFloorsType("2147483648", "-2147483649", "-2147483647");//(MAX + 1, MIN - 1, MIN + 1)
        assertInvalidFloorsType("2147483648", "-2147483647", "-2147483648");//(MAX + 1, MIN + 1, MIN)
        assertInvalidFloorsType("2147483648", "-2147483647", "-2147483649");//(MAX + 1, MIN + 1, MIN - 1)
        assertInvalidFloorsType("2147483648", "-2147483647", "-2147483647");//(MAX + 1, MIN + 1, MIN + 1)
        assertInvalidFlatLocationOnFloorType("2147483646", "-2147483649", "-2147483648");//(MAX - 1, MIN - 1, MIN)
        assertInvalidFlatLocationOnFloorType("2147483646", "-2147483649", "-2147483649");//(MAX - 1, MIN - 1, MIN - 1)
        assertInvalidFlatLocationOnFloorType("2147483646", "-2147483649", "-2147483647");//(MAX - 1, MIN - 1, MIN + 1)
        assertInvalidFlatLocationOnFloorType("2147483647", "-2147483649", "-2147483648");//(MAX, MIN - 1, MIN)
        assertInvalidFlatLocationOnFloorType("2147483647", "-2147483649", "-2147483649");//(MAX, MIN - 1, MIN - 1)
        assertInvalidFlatNumberType("2147483647", "-2147483647", "-2147483649");//(MAX, MIN + 1, MIN - 1)
        assertInvalidFlatNumberType("2147483646", "-2147483647", "-2147483649");//(MAX - 1, MIN + 1, MIN - 1)
        assertInvalidFlatNumberType("2147483646", "-2147483648", "-2147483649");//(MAX - 1, MIN, MIN - 1)
        assertInvalidFlatNumberType("2147483647", "-2147483648", "-2147483649");//(MAX, MIN, MIN - 1)
        assertInvalidFlatNumberType("2147483647", "-2147483648", "-2147483649");//(MAX, MIN, MIN - 1)
        //(MAX, MAX, MIN)
        assertInvalidFloorsType("2147483648", "2147483647", "-2147483648");//(MAX + 1, MAX, MIN)
        assertInvalidFloorsType("2147483648", "2147483647", "-2147483649");//(MAX + 1, MAX, MIN - 1)
        assertInvalidFloorsType("2147483648", "2147483647", "-2147483647");//(MAX + 1, MAX, MIN + 1)
        assertInvalidFloorsType("2147483648", "2147483648", "-2147483648");//(MAX + 1, MAX + 1, MIN)
        assertInvalidFloorsType("2147483648", "2147483648", "-2147483649");//(MAX + 1, MAX + 1, MIN - 1)
        assertInvalidFloorsType("2147483648", "2147483648", "-2147483647");//(MAX + 1, MAX + 1, MIN + 1)
        assertInvalidFloorsType("2147483648", "2147483646", "-2147483648");//(MAX + 1, MAX - 1, MIN)
        assertInvalidFloorsType("2147483648", "2147483646", "-2147483649");//(MAX + 1, MAX - 1, MIN - 1)
        assertInvalidFloorsType("2147483648", "2147483646", "-2147483647");//(MAX + 1, MAX - 1,  + 1)
        assertInvalidFlatLocationOnFloorType("2147483647", "2147483648", "-2147483648");//(MAX, MAX + 1, MIN)
        assertInvalidFlatLocationOnFloorType("2147483647", "2147483648", "-2147483649");//(MAX, MAX + 1, MIN - 1)
        assertInvalidFlatLocationOnFloorType("2147483647", "2147483648", "-2147483647");//(MAX, MAX + 1, MIN + 1)
        assertInvalidFlatLocationOnFloorType("2147483646", "2147483648", "-2147483648");//(MAX - 1, MAX + 1, MIN)
        assertInvalidFlatLocationOnFloorType("2147483646", "2147483648", "-2147483649");//(MAX - 1, MAX + 1, MIN - 1)
        assertInvalidFlatLocationOnFloorType("2147483646", "2147483648", "-2147483647");//(MAX - 1, MAX + 1, MIN + 1)
        assertInvalidFlatNumberType("2147483647", "2147483646", "-2147483649");//(MAX, MAX - 1, MIN - 1)
        assertInvalidFlatNumberType("2147483647", "2147483647", "-2147483649");//(MAX, MAX, MIN - 1)
        assertInvalidFlatNumberType("2147483646", "2147483647", "-2147483649");//(MAX - 1, MAX, MIN - 1)
        assertInvalidFlatNumberType("2147483646", "2147483646", "-2147483649");//(MAX - 1, MAX - 1, MIN - 1)
        //(MIN, MAX, MIN)
        assertInvalidFloorsType("-2147483649", "2147483647", "-2147483648");//(MIN - 1, MAX, MIN)
        assertInvalidFloorsType("-2147483649", "2147483647", "-2147483649");//(MIN - 1, MAX, MIN - 1)
        assertInvalidFloorsType("-2147483649", "2147483647", "-2147483647");//(MIN - 1, MAX, MIN + 1)
        assertInvalidFloorsType("-2147483649", "2147483648", "-2147483648");//(MIN - 1, MAX + 1, MIN)
        assertInvalidFloorsType("-2147483649", "2147483648", "-2147483649");//(MIN - 1, MAX + 1, MIN - 1)
        assertInvalidFloorsType("-2147483649", "2147483648", "-2147483647");//(MIN - 1, MAX + 1, MIN + 1)
        assertInvalidFloorsType("-2147483649", "2147483646", "-2147483648");//(MIN - 1, MAX - 1, MIN)
        assertInvalidFloorsType("-2147483649", "2147483646", "-2147483649");//(MIN - 1, MAX - 1, MIN - 1)
        assertInvalidFloorsType("-2147483649", "2147483646", "-2147483647");//(MIN - 1, MAX - 1, MIN + 1)
        assertInvalidFlatLocationOnFloorType("-2147483647", "2147483648", "-2147483648");//(MIN + 1, MAX + 1, MIN)
        assertInvalidFlatLocationOnFloorType("-2147483647", "2147483648", "-2147483649");//(MIN + 1, MAX + 1, MIN - 1)
        assertInvalidFlatLocationOnFloorType("-2147483647", "2147483648", "-2147483647");//(MIN + 1, MAX + 1, MIN + 1)
        assertInvalidFlatLocationOnFloorType("-2147483648", "2147483648", "-2147483648");//(MIN, MAX + 1, MIN)
        assertInvalidFlatLocationOnFloorType("-2147483648", "2147483648", "-2147483649");//(MIN, MAX + 1, MIN - 1)
        assertInvalidFlatLocationOnFloorType("-2147483648", "2147483648", "-2147483647");//(MIN, MAX + 1, MIN + 1)
        assertInvalidFlatNumberType("-2147483648", "2147483646", "-2147483649");//(MIN, MAX - 1, MIN - 1)
        assertInvalidFlatNumberType("-2147483648", "2147483647", "-2147483649");//(MIN, MAX, MIN - 1)
        assertInvalidFlatNumberType("-2147483647", "2147483647", "-2147483649");//(MIN + 1, MAX, MIN - 1)
        assertInvalidFlatNumberType("-2147483647", "2147483646", "-2147483649");//(MIN + 1, MAX - 1, MIN - 1)
        //(MIN, MAX, MAX)
        assertInvalidFloorsType("-2147483649", "2147483647", "2147483647");//(MIN - 1, MAX, MAX)
        assertInvalidFloorsType("-2147483649", "2147483647", "2147483648");//(MIN - 1, MAX, MAX + 1)
        assertInvalidFloorsType("-2147483649", "2147483647", "2147483646");//(MIN - 1, MAX, MAX - 1)
        assertInvalidFloorsType("-2147483649", "2147483648", "2147483647");//(MIN - 1, MAX + 1, MAX)
        assertInvalidFloorsType("-2147483649", "2147483648", "2147483648");//(MIN - 1, MAX + 1, MAX + 1)
        assertInvalidFloorsType("-2147483649", "2147483648", "2147483646");//(MIN - 1, MAX + 1, MAX - 1)
        assertInvalidFloorsType("-2147483649", "2147483646", "2147483647");//(MIN - 1, MAX - 1, MAX)
        assertInvalidFloorsType("-2147483649", "2147483646", "2147483648");//(MIN - 1, MAX - 1, MAX + 1)
        assertInvalidFloorsType("-2147483649", "2147483646", "2147483646");//(MIN - 1, MAX - 1, MAX - 1)
        assertInvalidFlatLocationOnFloorType("-2147483648", "2147483648", "2147483647");//(MIN, MAX + 1, MAX)
        assertInvalidFlatLocationOnFloorType("-2147483648", "2147483648", "2147483648");//(MIN, MAX + 1, MAX + 1)
        assertInvalidFlatLocationOnFloorType("-2147483648", "2147483648", "2147483646");//(MIN, MAX + 1, MAX - 1)
        assertInvalidFlatLocationOnFloorType("-2147483647", "2147483648", "2147483647");//(MIN + 1, MAX + 1, MAX)
        assertInvalidFlatLocationOnFloorType("-2147483647", "2147483648", "2147483648");//(MIN + 1, MAX + 1, MAX + 1)
        assertInvalidFlatLocationOnFloorType("-2147483647", "2147483648", "2147483646");//(MIN + 1, MAX + 1, MAX - 1)
        assertInvalidFlatNumberType("-2147483648", "2147483647", "2147483648");//(MIN, MAX, MAX + 1)
        assertInvalidFlatNumberType("-2147483648", "2147483646", "2147483648");//(MIN, MAX - 1, MAX + 1)
        assertInvalidFlatNumberType("-2147483647", "2147483647", "2147483648");//(MIN + 1, MAX, MAX + 1)
        assertInvalidFlatNumberType("-2147483647", "2147483646", "2147483648");//(MIN + 1, MAX - 1, MAX + 1)
        //(MIN, MIN, MAX)
        assertInvalidFloorsType("-2147483649", "-2147483648", "2147483647");//(MIN - 1, MIN, MAX)
        assertInvalidFloorsType("-2147483649", "-2147483648", "2147483648");//(MIN - 1, MIN, MAX + 1)
        assertInvalidFloorsType("-2147483649", "-2147483648", "2147483646");//(MIN - 1, MIN, MAX - 1)
        assertInvalidFloorsType("-2147483649", "-2147483649", "2147483647");//(MIN - 1, MIN - 1, MAX)
        assertInvalidFloorsType("-2147483649", "-2147483649", "2147483648");//(MIN - 1, MIN - 1, MAX + 1)
        assertInvalidFloorsType("-2147483649", "-2147483649", "2147483646");//(MIN - 1, MIN - 1, MAX - 1)
        assertInvalidFloorsType("-2147483649", "-2147483647", "2147483647");//(MIN - 1, MIN + 1, MAX)
        assertInvalidFloorsType("-2147483649", "-2147483647", "2147483648");//(MIN - 1, MIN + 1, MAX + 1)
        assertInvalidFloorsType("-2147483649", "-2147483647", "2147483646");//(MIN - 1, MIN + 1, MAX - 1)
        assertInvalidFlatLocationOnFloorType("-2147483648", "-2147483649", "2147483647");//(MIN, MIN - 1, MAX)
        assertInvalidFlatLocationOnFloorType("-2147483648", "-2147483649", "2147483648");//(MIN, MIN - 1, MAX + 1)
        assertInvalidFlatLocationOnFloorType("-2147483648", "-2147483649", "2147483646");//(MIN, MIN - 1, MAX - 1)
        assertInvalidFlatLocationOnFloorType("-2147483647", "-2147483649", "2147483647");//(MIN + 1, MIN - 1, MAX)
        assertInvalidFlatLocationOnFloorType("-2147483647", "-2147483649", "2147483648");//(MIN + 1, MIN - 1, MAX + 1)
        assertInvalidFlatLocationOnFloorType("-2147483647", "-2147483649", "2147483646");//(MIN + 1, MIN - 1, MAX - 1)
        assertInvalidFlatNumberType("-2147483647", "-2147483647", "2147483648");//(MIN + 1, MIN + 1, MAX + 1)
        assertInvalidFlatNumberType("-2147483648", "-2147483647", "2147483648");//(MIN, MIN + 1, MAX + 1)
        assertInvalidFlatNumberType("-2147483648", "-2147483648", "2147483648");//(MIN, MIN, MAX + 1)
        assertInvalidFlatNumberType("-2147483647", "-2147483648", "2147483648");//(MIN + 1, MIN, MAX + 1)
        //(MIN, MIN, MIN)
        assertInvalidFloorsType("-2147483649", "-2147483648", "-2147483648");//(MIN - 1, MIN, MIN)
        assertInvalidFloorsType("-2147483649", "-2147483648", "-2147483649");//(MIN - 1, MIN, MIN - 1)
        assertInvalidFloorsType("-2147483649", "-2147483648", "-2147483647");//(MIN - 1, MIN, MIN + 1)
        assertInvalidFloorsType("-2147483649", "-2147483649", "-2147483648");//(MIN - 1, MIN - 1, MIN)
        assertInvalidFloorsType("-2147483649", "-2147483649", "-2147483649");//(MIN - 1, MIN - 1, MIN - 1)
        assertInvalidFloorsType("-2147483649", "-2147483649", "-2147483647");//(MIN - 1, MIN - 1, MIN + 1)
        assertInvalidFloorsType("-2147483649", "-2147483647", "-2147483648");//(MIN - 1, MIN + 1, MIN)
        assertInvalidFloorsType("-2147483649", "-2147483647", "-2147483649");//(MIN - 1, MIN + 1, MIN - 1)
        assertInvalidFloorsType("-2147483649", "-2147483647", "-2147483647");//(MIN - 1, MIN + 1, MIN + 1)
        assertInvalidFlatLocationOnFloorType("-2147483647", "-2147483649", "-2147483648");//(MIN + 1, MIN - 1, MIN)
        assertInvalidFlatLocationOnFloorType("-2147483647", "-2147483649", "-2147483649");//(MIN + 1, MIN - 1, MIN - 1)
        assertInvalidFlatLocationOnFloorType("-2147483647", "-2147483649", "-2147483647");//(MIN + 1, MIN - 1, MIN + 1)
        assertInvalidFlatLocationOnFloorType("-2147483648", "-2147483649", "-2147483648");//(MIN, MIN - 1, MIN)
        assertInvalidFlatLocationOnFloorType("-2147483648", "-2147483649", "-2147483649");//(MIN, MIN - 1, MIN - 1)
        assertInvalidFlatLocationOnFloorType("-2147483648", "-2147483649", "-2147483647");//(MIN, MIN - 1, MIN + 1)
        assertInvalidFlatNumberType("-2147483647", "-2147483647", "-2147483649");//(MIN + 1, MIN + 1, MIN - 1)
        assertInvalidFlatNumberType("-2147483648", "-2147483648", "-2147483649");//(MIN, MIN, MIN - 1)
        assertInvalidFlatNumberType("-2147483648", "-2147483647", "-2147483649");//(MIN, MIN + 1, MIN - 1)
        assertInvalidFlatNumberType("-2147483647", "-2147483648", "-2147483649");//(MIN + 1, MIN, MIN - 1)
    }

    @Test
    void invalidFirstArgumentTypeTest() {
        assertInvalidFloorsType("a", "a", "a");
        assertInvalidFloorsType("z", "z", "z");

        assertInvalidFloorsType("A", "A", "A");
        assertInvalidFloorsType("Z", "Z", "Z");

        assertInvalidFloorsType("a", "1", "1");
        assertInvalidFloorsType("z", "1", "1");

        assertInvalidFloorsType("a", "a", "1");
        assertInvalidFloorsType("a", "1", "a");

        assertInvalidFloorsType("!", "!", "!");
        assertInvalidFloorsType("?", "#", "$");
        assertInvalidFloorsType("@", "@", "@");

        assertInvalidFloorsType("!", "1", "45");
        assertInvalidFloorsType("?", "56", "88");
        assertInvalidFloorsType("@", "985", "89");

        assertInvalidFloorsType("#889232", "#364977", "#259689");
        assertInvalidFloorsType("#566123", "#562111", "#136569");
        assertInvalidFloorsType("#566325", "#562236", "#566846");

        assertInvalidFloorsType("#862669", "1", "45");
        assertInvalidFloorsType("#566224", "56", "88");
        assertInvalidFloorsType("#466256", "985", "89");

        assertInvalidFloorsType("1 1", "89", "71");
        assertInvalidFloorsType("e 1", "89", "71");
        assertInvalidFloorsType("$ 1", "89", "71");
        assertInvalidFloorsType("#111111 1", "89", "71");
        assertInvalidFloorsType("18.23 1", "89", "71");
    }

    @Test
    void invalidSecondArgumentTypeTest() {
        assertInvalidFlatLocationOnFloorType("123", "a", "a");
        assertInvalidFlatLocationOnFloorType("123", "z", "z");

        assertInvalidFlatLocationOnFloorType("1356", "A", "A");
        assertInvalidFlatLocationOnFloorType("587", "Z", "Z");

        assertInvalidFlatLocationOnFloorType("95", "a", "26");
        assertInvalidFlatLocationOnFloorType("213", "z", "68");

        assertInvalidFlatLocationOnFloorType("856", "D", "123");
        assertInvalidFlatLocationOnFloorType("8132", "Z", "895");

        assertInvalidFlatLocationOnFloorType("13", "!", "!");
        assertInvalidFlatLocationOnFloorType("345", "#", "$");
        assertInvalidFlatLocationOnFloorType("654", "@", "@");

        assertInvalidFlatLocationOnFloorType("1", "!", "45");
        assertInvalidFlatLocationOnFloorType("56", "?", "88");
        assertInvalidFlatLocationOnFloorType("985", "@", "89");

        assertInvalidFlatLocationOnFloorType("9232", "#364977", "#259689");
        assertInvalidFlatLocationOnFloorType("623", "#562111", "#136569");
        assertInvalidFlatLocationOnFloorType("63", "#562236", "#566846");

        assertInvalidFlatLocationOnFloorType("1", "#862669", "45");
        assertInvalidFlatLocationOnFloorType("56", "#566224", "88");
        assertInvalidFlatLocationOnFloorType("985", "#466256", "89");

        assertInvalidFlatLocationOnFloorType("89", "1 1", "71");
        assertInvalidFlatLocationOnFloorType("856", "e 1", "71");
        assertInvalidFlatLocationOnFloorType("149", "$ 1", "71");
        assertInvalidFlatLocationOnFloorType("154", "#111111 1", "71");
        assertInvalidFlatLocationOnFloorType("1809", "18.23 1", "71");
    }

    @Test
    void invalidThirdArgumentTypeTest() {
        assertInvalidFlatNumberType("123", "566", "a");
        assertInvalidFlatNumberType("123", "8656", "z");

        assertInvalidFlatNumberType("1356", "562", "A");
        assertInvalidFlatNumberType("587", "1274", "Z");

        assertInvalidFlatNumberType("13", "532", "!");
        assertInvalidFlatNumberType("345", "1345", "$");
        assertInvalidFlatNumberType("654", "4562", "@");

        assertInvalidFlatNumberType("1", "45", "!");
        assertInvalidFlatNumberType("56", "88", "?");
        assertInvalidFlatNumberType("985", "89", "@");

        assertInvalidFlatNumberType("9232", "64977", "#259689");
        assertInvalidFlatNumberType("623", "111", "#136569");
        assertInvalidFlatNumberType("63", "2236", "#566846");

        assertInvalidFlatNumberType("89", "4552", "1 1");
        assertInvalidFlatNumberType("856", "126", "e 1");
        assertInvalidFlatNumberType("149", "324", "$ 1");
        assertInvalidFlatNumberType("154", "97", "#111111 1");
        assertInvalidFlatNumberType("1809", "1565", "18.23 1");
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
        String input = floors + SEPARATOR + flatsOnFloor + SEPARATOR + flatNumber;
        String expectedOutput = format(
                "Task 2. Enter number of floors in building, number flats on floor and number of searching flat:" + SEPARATOR +
                        "Floor: %d, entrance: %d", expectedFloor, expectedEntrance);

        assertValidConsolePrint(input, expectedOutput, MAIN_METHOD, false);
    }

    /**
     * Asserts that an illegal value for the number of floors in the building results in the expected error message.
     *
     * @param floor        the total number of floors in the building
     * @param flatsOnFloor the number of flats on each floor
     * @param flatNumber   the flat number for which the floor and entrance are being calculated
     */
    @Override
    public void assertThrowsIllegalFloorsException(int floor, int flatsOnFloor, int flatNumber) {
        String input = floor + SEPARATOR + flatsOnFloor + SEPARATOR + flatNumber;
        String expectedOutput = format(INVALID_FLOORS_INPUT_VALUE_MESSAGE, floor);

        assertValidConsolePrint(input, expectedOutput, MAIN_METHOD, true);
    }

    /**
     * Asserts that an illegal value for the number of flats on each floor results in the expected error message.
     *
     * @param floor        the total number of floors in the building
     * @param flatsOnFloor the number of flats on each floor
     * @param flatNumber   the flat number for which the floor and entrance are being calculated
     */
    @Override
    public void assertThrowsIllegalFlatLocationOnFloorException(int floor, int flatsOnFloor, int flatNumber) {
        String input = floor + SEPARATOR + flatsOnFloor + SEPARATOR + flatNumber;
        String expectedOutput = format(INVALID_FLATS_ON_FLOOR_INPUT_VALUE_MESSAGE, flatsOnFloor);

        assertValidConsolePrint(input, expectedOutput, MAIN_METHOD, true);
    }

    /**
     * Asserts that an illegal flat number results in the expected error message in the console output.
     *
     * @param floor        the total number of floors in the building
     * @param flatsOnFloor the number of flats on each floor
     * @param flatNumber   the flat number to be checked
     */
    @Override
    public void assertThrowsIllegalFlatNumberException(int floor, int flatsOnFloor, int flatNumber) {
        String input = floor + SEPARATOR + flatsOnFloor + SEPARATOR + flatNumber;
        String expectedOutput = format(INVALID_FLAT_NUMBER_INPUT_VALUE_MESSAGE, flatNumber);

        assertValidConsolePrint(input, expectedOutput, MAIN_METHOD, true);
    }

    /**
     * Asserts that a calculation exception is thrown for the given input values.
     *
     * @param floor        the total number of floors in the building
     * @param flatsOnFloor the number of flats on each floor
     * @param flatNumber   the flat number to be checked
     */
    @Override
    public void assertThrowsCalculationException(int floor, int flatsOnFloor, int flatNumber) {
        String input = floor + SEPARATOR + flatsOnFloor + SEPARATOR + flatNumber;
        String expectedOutput = format(INVALID_CALCULATIONS_MESSAGE, floor, flatsOnFloor);

        assertValidConsolePrint(input, expectedOutput, MAIN_METHOD, true);
    }

    /**
     * Asserts that an invalid type for the number of floors results in the expected error message in the console output.
     *
     * @param floors       the input value representing the number of floors in the building
     * @param flatsOnFloor the input value representing the number of flats on each floor
     * @param flatNumber   the input value representing the flat number to be searched
     */
    public void assertInvalidFloorsType(String floors, String flatsOnFloor, String flatNumber) {
        String input = floors + SEPARATOR + flatsOnFloor + SEPARATOR + flatNumber;
        String expectedOutput = format(INVALID_INPUT_TYPE_MESSAGE, "number of floors", floors);

        assertValidConsolePrint(input, expectedOutput, MAIN_METHOD, true);
    }

    /**
     * Asserts that an invalid type for the number of flats on each floor results in the expected error message in the console output.
     *
     * @param floors       the input value representing the number of floors in the building
     * @param flatsOnFloor the input value representing the number of flats on each floor
     * @param flatNumber   the input value representing the flat number to be searched
     */
    public void assertInvalidFlatLocationOnFloorType(String floors, String flatsOnFloor, String flatNumber) {
        String input = floors + SEPARATOR + flatsOnFloor + SEPARATOR + flatNumber;
        String expectedOutput = format(INVALID_INPUT_TYPE_MESSAGE, "number of flats on floors", flatsOnFloor);

        assertValidConsolePrint(input, expectedOutput, MAIN_METHOD, true);
    }

    /**
     * Asserts that an invalid type for the flat number results in the expected error message in the console output.
     *
     * @param floors       the input value representing the number of floors in the building
     * @param flatsOnFloor the input value representing the number of flats on each floor
     * @param flatNumber   the input value representing the flat number to be searched
     */
    public void assertInvalidFlatNumberType(String floors, String flatsOnFloor, String flatNumber) {
        String input = floors + SEPARATOR + flatsOnFloor + SEPARATOR + flatNumber;
        String expectedOutput = format(INVALID_INPUT_TYPE_MESSAGE, "number of flat", flatNumber);

        assertValidConsolePrint(input, expectedOutput, MAIN_METHOD, true);
    }

}
