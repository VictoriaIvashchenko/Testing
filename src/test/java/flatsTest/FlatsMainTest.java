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
     * Obligatory starting message with instructions.
     */
    private final static String PROMPT =
            "Task 2. Enter number of floors in building, number flats on floor and number of searching flat:" + LINE_BREAK;

    @Test
    void overRangeTypeTest() {
        //(1, 1, MAX)
        assertInvalidInputType("1", "1", "2147483648");
        assertInvalidInputType("1", "0", "2147483648");
        assertInvalidInputType("1", "2", "2147483648");
        assertInvalidInputType("0", "1", "2147483648");
        assertInvalidInputType("0", "0", "2147483648");
        assertInvalidInputType("0", "2", "2147483648");
        assertInvalidInputType("2", "1", "2147483648");
        assertInvalidInputType("2", "0", "2147483648");
        assertInvalidInputType("2", "2", "2147483648");
        //(MAX, 1, 1)
        assertInvalidInputType("2147483648", "1", "1");
        assertInvalidInputType("2147483648", "1", "0");
        assertInvalidInputType("2147483648", "1", "2");
        assertInvalidInputType("2147483648", "0", "1");
        assertInvalidInputType("2147483648", "0", "0");
        assertInvalidInputType("2147483648", "0", "2");
        assertInvalidInputType("2147483648", "2", "1");
        assertInvalidInputType("2147483648", "2", "0");
        assertInvalidInputType("2147483648", "2", "2");
        //(MAX, 1, MAX)
        assertInvalidInputType("2147483647", "1", "2147483648");
        assertInvalidInputType("2147483647", "0", "2147483648");
        assertInvalidInputType("2147483647", "2", "2147483648");
        assertInvalidInputType("2147483648", "1", "2147483647");
        assertInvalidInputType("2147483648", "1", "2147483648");
        assertInvalidInputType("2147483648", "1", "2147483646");
        assertInvalidInputType("2147483648", "0", "2147483647");
        assertInvalidInputType("2147483648", "0", "2147483648");
        assertInvalidInputType("2147483648", "0", "2147483646");
        assertInvalidInputType("2147483648", "2", "2147483647");
        assertInvalidInputType("2147483648", "2", "2147483648");
        assertInvalidInputType("2147483648", "2", "2147483646");
        assertInvalidInputType("2147483646", "1", "2147483648");
        assertInvalidInputType("2147483646", "0", "2147483648");
        assertInvalidInputType("2147483646", "2", "2147483648");
        //(1, MAX, MAX)
        assertInvalidInputType("1", "2147483647", "2147483648");
        assertInvalidInputType("1", "2147483648", "2147483647");
        assertInvalidInputType("1", "2147483648", "2147483648");
        assertInvalidInputType("1", "2147483648", "2147483646");
        assertInvalidInputType("1", "2147483646", "2147483648");
        assertInvalidInputType("0", "2147483647", "2147483648");
        assertInvalidInputType("0", "2147483648", "2147483647");
        assertInvalidInputType("0", "2147483648", "2147483648");
        assertInvalidInputType("0", "2147483648", "2147483646");
        assertInvalidInputType("0", "2147483646", "2147483648");
        assertInvalidInputType("2", "2147483647", "2147483648");
        assertInvalidInputType("2", "2147483648", "2147483647");
        assertInvalidInputType("2", "2147483648", "2147483648");
        assertInvalidInputType("2", "2147483648", "2147483646");
        assertInvalidInputType("2", "2147483646", "2147483648");
        //(1, MAX, 1)
        assertInvalidInputType("1", "2147483648", "1");
        assertInvalidInputType("1", "2147483648", "0");
        assertInvalidInputType("1", "2147483648", "2");
        assertInvalidInputType("0", "2147483648", "1");
        assertInvalidInputType("0", "2147483648", "0");
        assertInvalidInputType("0", "2147483648", "2");
        assertInvalidInputType("2", "2147483648", "1");
        assertInvalidInputType("2", "2147483648", "0");
        assertInvalidInputType("2", "2147483648", "2");
        //(MAX, MAX, MAX)
        assertInvalidInputType("2147483647", "2147483647", "2147483648");
        assertInvalidInputType("2147483647", "2147483648", "2147483647");
        assertInvalidInputType("2147483647", "2147483648", "2147483648");
        assertInvalidInputType("2147483647", "2147483648", "2147483646");
        assertInvalidInputType("2147483647", "2147483646", "2147483648");
        assertInvalidInputType("2147483648", "2147483647", "2147483647");
        assertInvalidInputType("2147483648", "2147483647", "2147483648");
        assertInvalidInputType("2147483648", "2147483647", "2147483646");
        assertInvalidInputType("2147483648", "2147483648", "2147483647");
        assertInvalidInputType("2147483648", "2147483648", "2147483648");
        assertInvalidInputType("2147483648", "2147483648", "2147483646");
        assertInvalidInputType("2147483648", "2147483646", "2147483647");
        assertInvalidInputType("2147483648", "2147483646", "2147483648");
        assertInvalidInputType("2147483648", "2147483646", "2147483646");
        assertInvalidInputType("2147483646", "2147483647", "2147483648");
        assertInvalidInputType("2147483646", "2147483648", "2147483647");
        assertInvalidInputType("2147483646", "2147483648", "2147483648");
        assertInvalidInputType("2147483646", "2147483648", "2147483646");
        assertInvalidInputType("2147483646", "2147483646", "2147483648");
        //(MAX, MIN, MAX)
        assertInvalidInputType("2147483648", "-2147483648", "2147483647");//(MAX + 1, MIN, MAX)
        assertInvalidInputType("2147483648", "-2147483648", "2147483648");//(MAX + 1, MIN, MAX + 1)
        assertInvalidInputType("2147483648", "-2147483648", "2147483646");//(MAX + 1, MIN, MAX - 1)
        assertInvalidInputType("2147483648", "-2147483649", "2147483647");//(MAX + 1, MIN - 1, MAX)
        assertInvalidInputType("2147483648", "-2147483649", "2147483648");//(MAX + 1, MIN - 1, MAX + 1)
        assertInvalidInputType("2147483648", "-2147483647", "2147483648");//(MAX + 1, MIN + 1, MAX + 1)
        assertInvalidInputType("2147483648", "-2147483647", "2147483646");//(MAX + 1, MIN + 1, MAX - 1)
        assertInvalidInputType("2147483648", "-2147483649", "2147483646");//(MAX + 1, MIN - 1, MAX - 1)
        assertInvalidInputType("2147483648", "-2147483647", "2147483647");//(MAX + 1, MIN - 1, MAX)
        assertInvalidInputType("2147483647", "-2147483649", "2147483647");//(MAX, MIN - 1, MAX)
        assertInvalidInputType("2147483647", "-2147483649", "2147483648");//(MAX, MIN - 1, MAX + 1)
        assertInvalidInputType("2147483647", "-2147483649", "2147483646");//(MAX, MIN - 1, MAX - 1)
        assertInvalidInputType("2147483646", "-2147483649", "2147483647");//(MAX - 1, MIN - 1, MAX)
        assertInvalidInputType("2147483646", "-2147483649", "2147483648");//(MAX - 1, MIN - 1, MAX + 1)
        assertInvalidInputType("2147483646", "-2147483649", "2147483646");//(MAX - 1, MIN - 1, MAX - 1)
        assertInvalidInputType("2147483646", "-2147483647", "2147483648");//(MAX - 1, MIN + 1, MAX + 1)
        assertInvalidInputType("2147483646", "-2147483648", "2147483648");//(MAX - 1, MIN, MAX + 1)
        assertInvalidInputType("2147483647", "-2147483647", "2147483648");//(MAX, MIN + 1, MAX + 1)
        assertInvalidInputType("2147483647", "-2147483648", "2147483648");//(MAX, MIN, MAX + 1)
        //(MAX, MIN, MIN)
        assertInvalidInputType("2147483648", "-2147483648", "-2147483648");//(MAX + 1, MIN, MIN)
        assertInvalidInputType("2147483648", "-2147483648", "-2147483649");//(MAX + 1, MIN, MIN - 1)
        assertInvalidInputType("2147483648", "-2147483648", "-2147483647");//(MAX + 1, MIN, MIN + 1)
        assertInvalidInputType("2147483648", "-2147483649", "-2147483648");//(MAX + 1, MIN - 1, MIN)
        assertInvalidInputType("2147483648", "-2147483649", "-2147483649");//(MAX + 1, MIN - 1, MIN - 1)
        assertInvalidInputType("2147483648", "-2147483649", "-2147483647");//(MAX + 1, MIN - 1, MIN + 1)
        assertInvalidInputType("2147483648", "-2147483647", "-2147483648");//(MAX + 1, MIN + 1, MIN)
        assertInvalidInputType("2147483648", "-2147483647", "-2147483649");//(MAX + 1, MIN + 1, MIN - 1)
        assertInvalidInputType("2147483648", "-2147483647", "-2147483647");//(MAX + 1, MIN + 1, MIN + 1)
        assertInvalidInputType("2147483646", "-2147483649", "-2147483648");//(MAX - 1, MIN - 1, MIN)
        assertInvalidInputType("2147483646", "-2147483649", "-2147483649");//(MAX - 1, MIN - 1, MIN - 1)
        assertInvalidInputType("2147483646", "-2147483649", "-2147483647");//(MAX - 1, MIN - 1, MIN + 1)
        assertInvalidInputType("2147483647", "-2147483649", "-2147483648");//(MAX, MIN - 1, MIN)
        assertInvalidInputType("2147483647", "-2147483649", "-2147483649");//(MAX, MIN - 1, MIN - 1)
        assertInvalidInputType("2147483647", "-2147483647", "-2147483649");//(MAX, MIN + 1, MIN - 1)
        assertInvalidInputType("2147483646", "-2147483647", "-2147483649");//(MAX - 1, MIN + 1, MIN - 1)
        assertInvalidInputType("2147483646", "-2147483648", "-2147483649");//(MAX - 1, MIN, MIN - 1)
        assertInvalidInputType("2147483647", "-2147483648", "-2147483649");//(MAX, MIN, MIN - 1)
        assertInvalidInputType("2147483647", "-2147483648", "-2147483649");//(MAX, MIN, MIN - 1)
        //(MAX, MAX, MIN)
        assertInvalidInputType("2147483648", "2147483647", "-2147483648");//(MAX + 1, MAX, MIN)
        assertInvalidInputType("2147483648", "2147483647", "-2147483649");//(MAX + 1, MAX, MIN - 1)
        assertInvalidInputType("2147483648", "2147483647", "-2147483647");//(MAX + 1, MAX, MIN + 1)
        assertInvalidInputType("2147483648", "2147483648", "-2147483648");//(MAX + 1, MAX + 1, MIN)
        assertInvalidInputType("2147483648", "2147483648", "-2147483649");//(MAX + 1, MAX + 1, MIN - 1)
        assertInvalidInputType("2147483648", "2147483648", "-2147483647");//(MAX + 1, MAX + 1, MIN + 1)
        assertInvalidInputType("2147483648", "2147483646", "-2147483648");//(MAX + 1, MAX - 1, MIN)
        assertInvalidInputType("2147483648", "2147483646", "-2147483649");//(MAX + 1, MAX - 1, MIN - 1)
        assertInvalidInputType("2147483648", "2147483646", "-2147483647");//(MAX + 1, MAX - 1,  + 1)
        assertInvalidInputType("2147483647", "2147483648", "-2147483648");//(MAX, MAX + 1, MIN)
        assertInvalidInputType("2147483647", "2147483648", "-2147483649");//(MAX, MAX + 1, MIN - 1)
        assertInvalidInputType("2147483647", "2147483648", "-2147483647");//(MAX, MAX + 1, MIN + 1)
        assertInvalidInputType("2147483646", "2147483648", "-2147483648");//(MAX - 1, MAX + 1, MIN)
        assertInvalidInputType("2147483646", "2147483648", "-2147483649");//(MAX - 1, MAX + 1, MIN - 1)
        assertInvalidInputType("2147483646", "2147483648", "-2147483647");//(MAX - 1, MAX + 1, MIN + 1)
        assertInvalidInputType("2147483647", "2147483646", "-2147483649");//(MAX, MAX - 1, MIN - 1)
        assertInvalidInputType("2147483647", "2147483647", "-2147483649");//(MAX, MAX, MIN - 1)
        assertInvalidInputType("2147483646", "2147483647", "-2147483649");//(MAX - 1, MAX, MIN - 1)
        assertInvalidInputType("2147483646", "2147483646", "-2147483649");//(MAX - 1, MAX - 1, MIN - 1)
        //(MIN, MAX, MIN)
        assertInvalidInputType("-2147483649", "2147483647", "-2147483648");//(MIN - 1, MAX, MIN)
        assertInvalidInputType("-2147483649", "2147483647", "-2147483649");//(MIN - 1, MAX, MIN - 1)
        assertInvalidInputType("-2147483649", "2147483647", "-2147483647");//(MIN - 1, MAX, MIN + 1)
        assertInvalidInputType("-2147483649", "2147483648", "-2147483648");//(MIN - 1, MAX + 1, MIN)
        assertInvalidInputType("-2147483649", "2147483648", "-2147483649");//(MIN - 1, MAX + 1, MIN - 1)
        assertInvalidInputType("-2147483649", "2147483648", "-2147483647");//(MIN - 1, MAX + 1, MIN + 1)
        assertInvalidInputType("-2147483649", "2147483646", "-2147483648");//(MIN - 1, MAX - 1, MIN)
        assertInvalidInputType("-2147483649", "2147483646", "-2147483649");//(MIN - 1, MAX - 1, MIN - 1)
        assertInvalidInputType("-2147483649", "2147483646", "-2147483647");//(MIN - 1, MAX - 1, MIN + 1)
        assertInvalidInputType("-2147483647", "2147483648", "-2147483648");//(MIN + 1, MAX + 1, MIN)
        assertInvalidInputType("-2147483647", "2147483648", "-2147483649");//(MIN + 1, MAX + 1, MIN - 1)
        assertInvalidInputType("-2147483647", "2147483648", "-2147483647");//(MIN + 1, MAX + 1, MIN + 1)
        assertInvalidInputType("-2147483648", "2147483648", "-2147483648");//(MIN, MAX + 1, MIN)
        assertInvalidInputType("-2147483648", "2147483648", "-2147483649");//(MIN, MAX + 1, MIN - 1)
        assertInvalidInputType("-2147483648", "2147483648", "-2147483647");//(MIN, MAX + 1, MIN + 1)
        assertInvalidInputType("-2147483648", "2147483646", "-2147483649");//(MIN, MAX - 1, MIN - 1)
        assertInvalidInputType("-2147483648", "2147483647", "-2147483649");//(MIN, MAX, MIN - 1)
        assertInvalidInputType("-2147483647", "2147483647", "-2147483649");//(MIN + 1, MAX, MIN - 1)
        assertInvalidInputType("-2147483647", "2147483646", "-2147483649");//(MIN + 1, MAX - 1, MIN - 1)
        //(MIN, MAX, MAX)
        assertInvalidInputType("-2147483649", "2147483647", "2147483647");//(MIN - 1, MAX, MAX)
        assertInvalidInputType("-2147483649", "2147483647", "2147483648");//(MIN - 1, MAX, MAX + 1)
        assertInvalidInputType("-2147483649", "2147483647", "2147483646");//(MIN - 1, MAX, MAX - 1)
        assertInvalidInputType("-2147483649", "2147483648", "2147483647");//(MIN - 1, MAX + 1, MAX)
        assertInvalidInputType("-2147483649", "2147483648", "2147483648");//(MIN - 1, MAX + 1, MAX + 1)
        assertInvalidInputType("-2147483649", "2147483648", "2147483646");//(MIN - 1, MAX + 1, MAX - 1)
        assertInvalidInputType("-2147483649", "2147483646", "2147483647");//(MIN - 1, MAX - 1, MAX)
        assertInvalidInputType("-2147483649", "2147483646", "2147483648");//(MIN - 1, MAX - 1, MAX + 1)
        assertInvalidInputType("-2147483649", "2147483646", "2147483646");//(MIN - 1, MAX - 1, MAX - 1)
        assertInvalidInputType("-2147483648", "2147483648", "2147483647");//(MIN, MAX + 1, MAX)
        assertInvalidInputType("-2147483648", "2147483648", "2147483648");//(MIN, MAX + 1, MAX + 1)
        assertInvalidInputType("-2147483648", "2147483648", "2147483646");//(MIN, MAX + 1, MAX - 1)
        assertInvalidInputType("-2147483647", "2147483648", "2147483647");//(MIN + 1, MAX + 1, MAX)
        assertInvalidInputType("-2147483647", "2147483648", "2147483648");//(MIN + 1, MAX + 1, MAX + 1)
        assertInvalidInputType("-2147483647", "2147483648", "2147483646");//(MIN + 1, MAX + 1, MAX - 1)
        assertInvalidInputType("-2147483648", "2147483647", "2147483648");//(MIN, MAX, MAX + 1)
        assertInvalidInputType("-2147483648", "2147483646", "2147483648");//(MIN, MAX - 1, MAX + 1)
        assertInvalidInputType("-2147483647", "2147483647", "2147483648");//(MIN + 1, MAX, MAX + 1)
        assertInvalidInputType("-2147483647", "2147483646", "2147483648");//(MIN + 1, MAX - 1, MAX + 1)
        //(MIN, MIN, MAX)
        assertInvalidInputType("-2147483649", "-2147483648", "2147483647");//(MIN - 1, MIN, MAX)
        assertInvalidInputType("-2147483649", "-2147483648", "2147483648");//(MIN - 1, MIN, MAX + 1)
        assertInvalidInputType("-2147483649", "-2147483648", "2147483646");//(MIN - 1, MIN, MAX - 1)
        assertInvalidInputType("-2147483649", "-2147483649", "2147483647");//(MIN - 1, MIN - 1, MAX)
        assertInvalidInputType("-2147483649", "-2147483649", "2147483648");//(MIN - 1, MIN - 1, MAX + 1)
        assertInvalidInputType("-2147483649", "-2147483649", "2147483646");//(MIN - 1, MIN - 1, MAX - 1)
        assertInvalidInputType("-2147483649", "-2147483647", "2147483647");//(MIN - 1, MIN + 1, MAX)
        assertInvalidInputType("-2147483649", "-2147483647", "2147483648");//(MIN - 1, MIN + 1, MAX + 1)
        assertInvalidInputType("-2147483649", "-2147483647", "2147483646");//(MIN - 1, MIN + 1, MAX - 1)
        assertInvalidInputType("-2147483648", "-2147483649", "2147483647");//(MIN, MIN - 1, MAX)
        assertInvalidInputType("-2147483648", "-2147483649", "2147483648");//(MIN, MIN - 1, MAX + 1)
        assertInvalidInputType("-2147483648", "-2147483649", "2147483646");//(MIN, MIN - 1, MAX - 1)
        assertInvalidInputType("-2147483647", "-2147483649", "2147483647");//(MIN + 1, MIN - 1, MAX)
        assertInvalidInputType("-2147483647", "-2147483649", "2147483648");//(MIN + 1, MIN - 1, MAX + 1)
        assertInvalidInputType("-2147483647", "-2147483649", "2147483646");//(MIN + 1, MIN - 1, MAX - 1)
        assertInvalidInputType("-2147483647", "-2147483647", "2147483648");//(MIN + 1, MIN + 1, MAX + 1)
        assertInvalidInputType("-2147483648", "-2147483647", "2147483648");//(MIN, MIN + 1, MAX + 1)
        assertInvalidInputType("-2147483648", "-2147483648", "2147483648");//(MIN, MIN, MAX + 1)
        assertInvalidInputType("-2147483647", "-2147483648", "2147483648");//(MIN + 1, MIN, MAX + 1)
        //(MIN, MIN, MIN)
        assertInvalidInputType("-2147483649", "-2147483648", "-2147483648");//(MIN - 1, MIN, MIN)
        assertInvalidInputType("-2147483649", "-2147483648", "-2147483649");//(MIN - 1, MIN, MIN - 1)
        assertInvalidInputType("-2147483649", "-2147483648", "-2147483647");//(MIN - 1, MIN, MIN + 1)
        assertInvalidInputType("-2147483649", "-2147483649", "-2147483648");//(MIN - 1, MIN - 1, MIN)
        assertInvalidInputType("-2147483649", "-2147483649", "-2147483649");//(MIN - 1, MIN - 1, MIN - 1)
        assertInvalidInputType("-2147483649", "-2147483649", "-2147483647");//(MIN - 1, MIN - 1, MIN + 1)
        assertInvalidInputType("-2147483649", "-2147483647", "-2147483648");//(MIN - 1, MIN + 1, MIN)
        assertInvalidInputType("-2147483649", "-2147483647", "-2147483649");//(MIN - 1, MIN + 1, MIN - 1)
        assertInvalidInputType("-2147483649", "-2147483647", "-2147483647");//(MIN - 1, MIN + 1, MIN + 1)
        assertInvalidInputType("-2147483647", "-2147483649", "-2147483648");//(MIN + 1, MIN - 1, MIN)
        assertInvalidInputType("-2147483647", "-2147483649", "-2147483649");//(MIN + 1, MIN - 1, MIN - 1)
        assertInvalidInputType("-2147483647", "-2147483649", "-2147483647");//(MIN + 1, MIN - 1, MIN + 1)
        assertInvalidInputType("-2147483648", "-2147483649", "-2147483648");//(MIN, MIN - 1, MIN)
        assertInvalidInputType("-2147483648", "-2147483649", "-2147483649");//(MIN, MIN - 1, MIN - 1)
        assertInvalidInputType("-2147483648", "-2147483649", "-2147483647");//(MIN, MIN - 1, MIN + 1)
        assertInvalidInputType("-2147483647", "-2147483647", "-2147483649");//(MIN + 1, MIN + 1, MIN - 1)
        assertInvalidInputType("-2147483648", "-2147483648", "-2147483649");//(MIN, MIN, MIN - 1)
        assertInvalidInputType("-2147483648", "-2147483647", "-2147483649");//(MIN, MIN + 1, MIN - 1)
        assertInvalidInputType("-2147483647", "-2147483648", "-2147483649");//(MIN + 1, MIN, MIN - 1)
    }

    @Test
    void invalidFirstArgumentTypeTest() {
        assertInvalidInputType("a", "a", "a");
        assertInvalidInputType("z", "z", "z");

        assertInvalidInputType("A", "A", "A");
        assertInvalidInputType("Z", "Z", "Z");

        assertInvalidInputType("a", "1", "1");
        assertInvalidInputType("z", "1", "1");

        assertInvalidInputType("a", "a", "1");
        assertInvalidInputType("a", "1", "a");

        assertInvalidInputType("!", "!", "!");
        assertInvalidInputType("?", "#", "$");
        assertInvalidInputType("@", "@", "@");

        assertInvalidInputType("!", "1", "45");
        assertInvalidInputType("?", "56", "88");
        assertInvalidInputType("@", "985", "89");

        assertInvalidInputType("#889232", "#364977", "#259689");
        assertInvalidInputType("#566123", "#562111", "#136569");
        assertInvalidInputType("#566325", "#562236", "#566846");

        assertInvalidInputType("#862669", "1", "45");
        assertInvalidInputType("#566224", "56", "88");
        assertInvalidInputType("#466256", "985", "89");

        assertInvalidInputType("1 1", "89", "71");
        assertInvalidInputType("e 1", "89", "71");
        assertInvalidInputType("$ 1", "89", "71");
        assertInvalidInputType("#111111 1", "89", "71");
        assertInvalidInputType("18.23 1", "89", "71");
    }

    @Test
    void invalidSecondArgumentTypeTest() {
        assertInvalidInputType("123", "a", "a");
        assertInvalidInputType("123", "z", "z");

        assertInvalidInputType("1356", "A", "A");
        assertInvalidInputType("587", "Z", "Z");

        assertInvalidInputType("95", "a", "26");
        assertInvalidInputType("213", "z", "68");

        assertInvalidInputType("856", "D", "123");
        assertInvalidInputType("8132", "Z", "895");

        assertInvalidInputType("13", "!", "!");
        assertInvalidInputType("345", "#", "$");
        assertInvalidInputType("654", "@", "@");

        assertInvalidInputType("1", "!", "45");
        assertInvalidInputType("56", "?", "88");
        assertInvalidInputType("985", "@", "89");

        assertInvalidInputType("9232", "#364977", "#259689");
        assertInvalidInputType("623", "#562111", "#136569");
        assertInvalidInputType("63", "#562236", "#566846");

        assertInvalidInputType("1", "#862669", "45");
        assertInvalidInputType("56", "#566224", "88");
        assertInvalidInputType("985", "#466256", "89");

        assertInvalidInputType("89", "1 1", "71");
        assertInvalidInputType("856", "e 1", "71");
        assertInvalidInputType("149", "$ 1", "71");
        assertInvalidInputType("154", "#111111 1", "71");
        assertInvalidInputType("1809", "18.23 1", "71");
    }

    @Test
    void invalidThirdArgumentTypeTest() {
        assertInvalidInputType("123", "566", "a");
        assertInvalidInputType("123", "8656", "z");

        assertInvalidInputType("1356", "562", "A");
        assertInvalidInputType("587", "1274", "Z");

        assertInvalidInputType("13", "532", "!");
        assertInvalidInputType("345", "1345", "$");
        assertInvalidInputType("654", "4562", "@");

        assertInvalidInputType("1", "45", "!");
        assertInvalidInputType("56", "88", "?");
        assertInvalidInputType("985", "89", "@");

        assertInvalidInputType("9232", "64977", "#259689");
        assertInvalidInputType("623", "111", "#136569");
        assertInvalidInputType("63", "2236", "#566846");

        assertInvalidInputType("89", "4552", "1 1");
        assertInvalidInputType("856", "126", "e 1");
        assertInvalidInputType("149", "324", "$ 1");
        assertInvalidInputType("154", "97", "#111111 1");
        assertInvalidInputType("1809", "1565", "18.23 1");
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

        String expectedOutput = format("%sFloor: %d, entrance: %d%n", PROMPT, expectedFloor, expectedEntrance);
        String expectedErrorOutput = "";

        assertConsolePrint(input, expectedOutput, expectedErrorOutput, expectedOutput, MAIN_METHOD);
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
        String input = getInput(floor, flatsOnFloor, flatNumber);

        String expectedErrorOutput = format(INVALID_FLOORS_INPUT_VALUE_MESSAGE, floor);
        String expectedFullOutput = PROMPT + expectedErrorOutput;

        assertConsolePrint(input, PROMPT, expectedErrorOutput, expectedFullOutput, MAIN_METHOD);
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
        String input = getInput(floor, flatsOnFloor, flatNumber);

        String expectedErrorOutput = format(INVALID_FLATS_ON_FLOOR_INPUT_VALUE_MESSAGE, flatsOnFloor);
        String expectedFullOutput = PROMPT + expectedErrorOutput;

        assertConsolePrint(input, PROMPT, expectedErrorOutput, expectedFullOutput, MAIN_METHOD);
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
        String input = getInput(floor, flatsOnFloor, flatNumber);

        String expectedErrorOutput = format(INVALID_FLAT_NUMBER_INPUT_VALUE_MESSAGE, flatNumber);
        String expectedFullOutput = PROMPT + expectedErrorOutput;

        assertConsolePrint(input, PROMPT, expectedErrorOutput, expectedFullOutput, MAIN_METHOD);
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
        String input = getInput(floor, flatsOnFloor, flatNumber);

        String expectedErrorOutput = format(INVALID_CALCULATIONS_MESSAGE, floor, flatsOnFloor);
        String expectedFullOutput = PROMPT + expectedErrorOutput;

        assertConsolePrint(input, PROMPT, expectedErrorOutput, expectedFullOutput, MAIN_METHOD);
    }

    /**
     * Asserts that an invalid type of input argument thrown exception with specific message.
     *
     * @param floors       the input value representing the number of floors in the building
     * @param flatsOnFloor the input value representing the number of flats on each floor
     * @param flatNumber   the input value representing the flat number to be searched
     */
    public void assertInvalidInputType(String floors, String flatsOnFloor, String flatNumber) {
        String input = floors + LINE_BREAK + flatsOnFloor + LINE_BREAK + flatNumber + LINE_BREAK;

        String expectedErrorOutput = "Invalid type of input value. Number from -2147483648 to 2147483647 was expected.";
        String expectedFullOutput = PROMPT + expectedErrorOutput;

        assertConsolePrint(input, PROMPT, expectedErrorOutput, expectedFullOutput, MAIN_METHOD);
    }

    private static String getInput(int floor, int flatsOnFloor, int flatNumber) {
        return floor + LINE_BREAK + flatsOnFloor + LINE_BREAK + flatNumber + LINE_BREAK;
    }
}
