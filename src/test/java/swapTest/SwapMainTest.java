package swapTest;

import org.junit.jupiter.api.Test;
import swap.SwapMain;

import static tools.ConsolePrintCheck.assertConsolePrint;

/**
 * Unit test class for {@link SwapMain}.
 *
 * <p>This class extends {@link SwapTest} and provides specific test configurations
 * for verifying the behavior of the {@link SwapMain} program. It sets up the main method
 * for execution during tests and defines a system-dependent line separator.</p>
 */
public class SwapMainTest extends SwapTest {

    /**
     * A {@link Runnable} reference to the {@code main} method of {@link SwapMain}.
     *
     * <p>This runnable executes {@link SwapMain#main(String[])} with an empty argument array,
     * allowing test cases to simulate program execution.</p>
     */
    private final static Runnable MAIN_METHOD = () -> SwapMain.main(new String[]{});

    /**
     * System-dependent line separator used for formatting expected test output.
     */
    private final static String LINE_BREAK = System.lineSeparator();

    /**
     * Obligatory starting message with instructions.
     */
    private final static String PROMPT = "Task 1. Enter two numbers x and y:" + LINE_BREAK;

    @Test
    void overRangeInputTest() {
        //(MAX, MAX)
        assertInvalidTypeInputArgument("2147483646", "2147483648");//(MAX - 1, MAX + 1)
        assertInvalidTypeInputArgument("2147483647", "2147483648");//(MAX, MAX + 1)
        assertInvalidTypeInputArgument("2147483648", "2147483648");//(MAX + 1, MAX + 1)
        assertInvalidTypeInputArgument("2147483648", "2147483647");//(MAX + 1, MAX)
        assertInvalidTypeInputArgument("2147483648", "2147483646");//(MAX + 1, MAX - 1)
        //(MAX, MIN)
        assertInvalidTypeInputArgument("2147483646", "-2147483649");//(MAX - 1, MIN - 1)
        assertInvalidTypeInputArgument("2147483647", "-2147483649");//(MAX, MIN - 1)
        assertInvalidTypeInputArgument("2147483648", "-2147483649");//(MAX + 1, MIN - 1)
        assertInvalidTypeInputArgument("2147483648", "-2147483648");//(MAX + 1, MIN)
        assertInvalidTypeInputArgument("2147483648", "-2147483647");//(MAX + 1, MIN + 1)
        //(MIN, MIN)
        assertInvalidTypeInputArgument("-2147483647", "-2147483649");//(MIN + 1, MIN - 1)
        assertInvalidTypeInputArgument("-2147483648", "-2147483649");//(MIN, MIN - 1)
        assertInvalidTypeInputArgument("-2147483649", "-2147483649");//(MIN - 1, MIN - 1)
        assertInvalidTypeInputArgument("-2147483649", "-2147483648");//(MIN - 1, MIN)
        assertInvalidTypeInputArgument("-2147483649", "-2147483647");//(MIN - 1, MIN + 1)
        //(MIN, MAX)
        assertInvalidTypeInputArgument("-2147483647", "2147483648");//(MIN + 1, MAX + 1)
        assertInvalidTypeInputArgument("-2147483648", "2147483648");//(MIN, MAX + 1)
        assertInvalidTypeInputArgument("-2147483649", "2147483648");//(MIN - 1, MAX + 1)
        assertInvalidTypeInputArgument("-2147483649", "2147483647");//(MIN - 1, MAX)
        assertInvalidTypeInputArgument("-2147483649", "2147483646");//(MIN - 1, MAX - 1)
        //ребра
        assertInvalidTypeInputArgument("1073741826", "2147483648");//(х, MAX + 1)
        assertInvalidTypeInputArgument("2147483648", "1073741826");//(MAX + 1, y)
        assertInvalidTypeInputArgument("2147483648", "-1073741826");//(MAX + 1, y)
        assertInvalidTypeInputArgument("1073741826", "-2147483649");//(x, MIN - 1)
        assertInvalidTypeInputArgument("-1073741826", "-2147483649");//(x, MIN - 1)
        assertInvalidTypeInputArgument("-2147483649", "-1073741826");//(MIN - 1, y)
        assertInvalidTypeInputArgument("-1073741826", "2147483648");//(x, MAX + 1)
        assertInvalidTypeInputArgument("-2147483649", "1073741826");//(MIN - 1, y)
    }

    @Test
    void invalidTypeFirstArgumentInputTest() {
        assertInvalidTypeInputArgument("a", "a");
        assertInvalidTypeInputArgument("z", "z");
        assertInvalidTypeInputArgument("a", "z");
        assertInvalidTypeInputArgument("b", "y");

        assertInvalidTypeInputArgument("A", "A");
        assertInvalidTypeInputArgument("Z", "Z");
        assertInvalidTypeInputArgument("A", "Z");
        assertInvalidTypeInputArgument("B", "Y");

        assertInvalidTypeInputArgument("a", "1");
        assertInvalidTypeInputArgument("a", "2");
        assertInvalidTypeInputArgument("b", "1");

        assertInvalidTypeInputArgument("f", "1");
        assertInvalidTypeInputArgument("f", "2");
        assertInvalidTypeInputArgument("e", "1");

        assertInvalidTypeInputArgument("A", "1");
        assertInvalidTypeInputArgument("A", "2");
        assertInvalidTypeInputArgument("B", "1");

        assertInvalidTypeInputArgument("F", "1");
        assertInvalidTypeInputArgument("F", "2");
        assertInvalidTypeInputArgument("E", "1");

        assertInvalidTypeInputArgument("!", "@");
        assertInvalidTypeInputArgument("@", "!");
        assertInvalidTypeInputArgument("#$", "%^&");

        assertInvalidTypeInputArgument("!", "1");
        assertInvalidTypeInputArgument("@", "2");
        assertInvalidTypeInputArgument("#$", "3");

        assertInvalidTypeInputArgument("#424543", "#404929");
        assertInvalidTypeInputArgument("#111111", "#554166");
        assertInvalidTypeInputArgument("#446564", "#655236");

        assertInvalidTypeInputArgument("#245658", "2");
        assertInvalidTypeInputArgument("#896456", "1");
        assertInvalidTypeInputArgument("#865456", "1");

        assertInvalidTypeInputArgument("12.8", "3");
        assertInvalidTypeInputArgument("14.5", "564.");
        assertInvalidTypeInputArgument("93.8", "356.");
        assertInvalidTypeInputArgument("9856.23", "316");
        assertInvalidTypeInputArgument("124.78", "656.45");
        assertInvalidTypeInputArgument("6647.23", "574.254");

        assertInvalidTypeInputArgument("12.3", "1");
        assertInvalidTypeInputArgument("-1114.1", "2");
        assertInvalidTypeInputArgument("95.1", "15468745");
        assertInvalidTypeInputArgument("-156.3", "2147483647");
        assertInvalidTypeInputArgument("88.1", "1073741820");
        assertInvalidTypeInputArgument("6647.23", "88545");

        assertInvalidTypeInputArgument("1 1", "1");
        assertInvalidTypeInputArgument("32 56", "1");
        assertInvalidTypeInputArgument("a a", "1");
        assertInvalidTypeInputArgument("a 1", "1");
        assertInvalidTypeInputArgument("1 a", "1");
        assertInvalidTypeInputArgument("! 1", "1");
        assertInvalidTypeInputArgument("1 !", "2");
        assertInvalidTypeInputArgument("! !", "2");
        assertInvalidTypeInputArgument("12.3 1", "1");
        assertInvalidTypeInputArgument("1 23.56", "1");
        assertInvalidTypeInputArgument("12.3 123.85", "1");
    }

    @Test
    void invalidTypeSecondArgumentInputTest() {
        assertInvalidTypeInputArgument("1", "a");
        assertInvalidTypeInputArgument("2", "a");
        assertInvalidTypeInputArgument("1", "b");

        assertInvalidTypeInputArgument("1", "f");
        assertInvalidTypeInputArgument("2", "f");
        assertInvalidTypeInputArgument("1", "e");

        assertInvalidTypeInputArgument("1", "A");
        assertInvalidTypeInputArgument("2", "A");
        assertInvalidTypeInputArgument("1", "B");

        assertInvalidTypeInputArgument("1", "F");
        assertInvalidTypeInputArgument("2", "F");
        assertInvalidTypeInputArgument("1", "E");

        assertInvalidTypeInputArgument("1", "@");
        assertInvalidTypeInputArgument("1", "!");
        assertInvalidTypeInputArgument("1", "%^&");

        assertInvalidTypeInputArgument("44573", "#404929");
        assertInvalidTypeInputArgument("-5628564", "#554166");
        assertInvalidTypeInputArgument("24565", "#655236");

        assertInvalidTypeInputArgument("12", "3.1");
        assertInvalidTypeInputArgument("14", "564.01");
        assertInvalidTypeInputArgument("93", "356.");
        assertInvalidTypeInputArgument("9823", "316.5");
        assertInvalidTypeInputArgument("124", "656.45");
        assertInvalidTypeInputArgument("6647", "574.254");
    }

    /**
     * Overrides the base {@link SwapTest#assertSwapTwoNumbers} method to test the correctness of the
     * {@link SwapMain#main(String[])} method using console input and output.
     *
     * @param num1 the first number to be swapped
     * @param num2 the second number to be swapped
     */
    @Override
    public void assertSwapTwoNumbers(int num1, int num2) {
        String input = num1 + LINE_BREAK + num2;

        String expectedOutput = String.format(
                        "%sBefore: x = %d y = %d%n" +
                        "After: x = %d y = %d%n", PROMPT, num1, num2, num2, num1);
        String expectedErrorOutput = "";

        assertConsolePrint(input, expectedOutput, expectedErrorOutput, expectedOutput, MAIN_METHOD);

    }

    /**
     * Asserts that an invalid type input for the argument is handled correctly by the {@link  SwapMain#main(String[])} method.
     *
     * @param x the first input value
     * @param y the second input value
     */
    public void assertInvalidTypeInputArgument(String x, String y) {
        String input = x + LINE_BREAK + y;

        String expectedErrorOutput = "Invalid type of input value. Number from -2147483648 to 2147483647 was expected.";
        String expectedFullOutput = PROMPT + expectedErrorOutput;

        assertConsolePrint(input, PROMPT, expectedErrorOutput, expectedFullOutput, MAIN_METHOD);
    }

}