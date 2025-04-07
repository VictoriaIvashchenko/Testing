package swapTest;

import org.junit.jupiter.api.Test;
import swap.SwapMain;

import static java.lang.String.format;
import static tools.ConsolePrintCheck.assertValidConsolePrint;

/**
 * Unit test class for {@link SwapMain}.
 *
 * <p>This class extends {@link SwapTest} and provides specific test configurations
 * for verifying the behavior of the {@link SwapMain} program. It sets up the main method
 * for execution during tests and defines a system-dependent line separator.</p>
 */
public class SwapMainTest extends SwapTest {

    /**
     * Error message for an invalid type input in swap operations.
     */
    final static String INVALID_TYPE_INPUT_SWAP_TEST =
            "Invalid type of %s. Number from -2147483648 to 2147483647 was expected, but '%s' was received.";

    /**
     * System-dependent line separator used for formatting expected test output.
     */
    final static String SEPARATOR = System.lineSeparator();

    /**
     * A {@link Runnable} reference to the {@code main} method of {@link SwapMain}.
     *
     * <p>This runnable executes {@link SwapMain#main(String[])} with an empty argument array,
     * allowing test cases to simulate program execution.</p>
     */
    final static Runnable MAIN_METHOD = () -> SwapMain.main(new String[]{});

    @Test
    void overRangeInputTest() {
        //(MAX, MAX)
        assertInvalidTypeSecondArgument("2147483646", "2147483648");//(MAX - 1, MAX + 1)
        assertInvalidTypeSecondArgument("2147483647", "2147483648");//(MAX, MAX + 1)
        assertInvalidTypeFirstArgument("2147483648", "2147483648");//(MAX + 1, MAX + 1)
        assertInvalidTypeFirstArgument("2147483648", "2147483647");//(MAX + 1, MAX)
        assertInvalidTypeFirstArgument("2147483648", "2147483646");//(MAX + 1, MAX - 1)
        //(MAX, MIN)
        assertInvalidTypeSecondArgument("2147483646", "-2147483649");//(MAX - 1, MIN - 1)
        assertInvalidTypeSecondArgument("2147483647", "-2147483649");//(MAX, MIN - 1)
        assertInvalidTypeFirstArgument("2147483648", "-2147483649");//(MAX + 1, MIN - 1)
        assertInvalidTypeFirstArgument("2147483648", "-2147483648");//(MAX + 1, MIN)
        assertInvalidTypeFirstArgument("2147483648", "-2147483647");//(MAX + 1, MIN + 1)
        //(MIN, MIN)
        assertInvalidTypeSecondArgument("-2147483647", "-2147483649");//(MIN + 1, MIN - 1)
        assertInvalidTypeSecondArgument("-2147483648", "-2147483649");//(MIN, MIN - 1)
        assertInvalidTypeFirstArgument("-2147483649", "-2147483649");//(MIN - 1, MIN - 1)
        assertInvalidTypeFirstArgument("-2147483649", "-2147483648");//(MIN - 1, MIN)
        assertInvalidTypeFirstArgument("-2147483649", "-2147483647");//(MIN - 1, MIN + 1)
        //(MIN, MAX)
        assertInvalidTypeSecondArgument("-2147483647", "2147483648");//(MIN + 1, MAX + 1)
        assertInvalidTypeSecondArgument("-2147483648", "2147483648");//(MIN, MAX + 1)
        assertInvalidTypeFirstArgument("-2147483649", "2147483648");//(MIN - 1, MAX + 1)
        assertInvalidTypeFirstArgument("-2147483649", "2147483647");//(MIN - 1, MAX)
        assertInvalidTypeFirstArgument("-2147483649", "2147483646");//(MIN - 1, MAX - 1)
        //ребра
        assertInvalidTypeSecondArgument("1073741826", "2147483648");//(х, MAX + 1)
        assertInvalidTypeFirstArgument("2147483648", "1073741826");//(MAX + 1, y)
        assertInvalidTypeFirstArgument("2147483648", "-1073741826");//(MAX + 1, y)
        assertInvalidTypeSecondArgument("1073741826", "-2147483649");//(x, MIN - 1)
        assertInvalidTypeSecondArgument("-1073741826", "-2147483649");//(x, MIN - 1)
        assertInvalidTypeFirstArgument("-2147483649", "-1073741826");//(MIN - 1, y)
        assertInvalidTypeSecondArgument("-1073741826", "2147483648");//(x, MAX + 1)
        assertInvalidTypeFirstArgument("-2147483649", "1073741826");//(MIN - 1, y)
    }

    @Test
    void invalidTypeFirstArgumentInputTest() {
        assertInvalidTypeFirstArgument("a", "a");
        assertInvalidTypeFirstArgument("z", "z");
        assertInvalidTypeFirstArgument("a", "z");
        assertInvalidTypeFirstArgument("b", "y");

        assertInvalidTypeFirstArgument("A", "A");
        assertInvalidTypeFirstArgument("Z", "Z");
        assertInvalidTypeFirstArgument("A", "Z");
        assertInvalidTypeFirstArgument("B", "Y");

        assertInvalidTypeFirstArgument("a", "1");
        assertInvalidTypeFirstArgument("a", "2");
        assertInvalidTypeFirstArgument("b", "1");

        assertInvalidTypeFirstArgument("f", "1");
        assertInvalidTypeFirstArgument("f", "2");
        assertInvalidTypeFirstArgument("e", "1");

        assertInvalidTypeFirstArgument("A", "1");
        assertInvalidTypeFirstArgument("A", "2");
        assertInvalidTypeFirstArgument("B", "1");

        assertInvalidTypeFirstArgument("F", "1");
        assertInvalidTypeFirstArgument("F", "2");
        assertInvalidTypeFirstArgument("E", "1");

        assertInvalidTypeFirstArgument("!", "@");
        assertInvalidTypeFirstArgument("@", "!");
        assertInvalidTypeFirstArgument("#$", "%^&");

        assertInvalidTypeFirstArgument("!", "1");
        assertInvalidTypeFirstArgument("@", "2");
        assertInvalidTypeFirstArgument("#$", "3");

        assertInvalidTypeFirstArgument("#424543", "#404929");
        assertInvalidTypeFirstArgument("#111111", "#554166");
        assertInvalidTypeFirstArgument("#446564", "#655236");

        assertInvalidTypeFirstArgument("#245658", "2");
        assertInvalidTypeFirstArgument("#896456", "1");
        assertInvalidTypeFirstArgument("#865456", "1");

        assertInvalidTypeFirstArgument("12.8", "3");
        assertInvalidTypeFirstArgument("14.5", "564.");
        assertInvalidTypeFirstArgument("93.8", "356.");
        assertInvalidTypeFirstArgument("9856.23", "316");
        assertInvalidTypeFirstArgument("124.78", "656.45");
        assertInvalidTypeFirstArgument("6647.23", "574.254");

        assertInvalidTypeFirstArgument("12.3", "1");
        assertInvalidTypeFirstArgument("-1114.1", "2");
        assertInvalidTypeFirstArgument("95.1", "15468745");
        assertInvalidTypeFirstArgument("-156.3", "2147483647");
        assertInvalidTypeFirstArgument("88.1", "1073741820");
        assertInvalidTypeFirstArgument("6647.23", "88545");

        assertInvalidTypeFirstArgument("1 1", "1");
        assertInvalidTypeFirstArgument("32 56", "1");
        assertInvalidTypeFirstArgument("a a", "1");
        assertInvalidTypeFirstArgument("a 1", "1");
        assertInvalidTypeFirstArgument("1 a", "1");
        assertInvalidTypeFirstArgument("! 1", "1");
        assertInvalidTypeFirstArgument("1 !", "2");
        assertInvalidTypeFirstArgument("! !", "2");
        assertInvalidTypeFirstArgument("12.3 1", "1");
        assertInvalidTypeFirstArgument("1 23.56", "1");
        assertInvalidTypeFirstArgument("12.3 123.85", "1");
    }

    @Test
    void invalidTypeSecondArgumentInputTest() {
        assertInvalidTypeSecondArgument("1", "a");
        assertInvalidTypeSecondArgument("2", "a");
        assertInvalidTypeSecondArgument("1", "b");

        assertInvalidTypeSecondArgument("1", "f");
        assertInvalidTypeSecondArgument("2", "f");
        assertInvalidTypeSecondArgument("1", "e");

        assertInvalidTypeSecondArgument("1", "A");
        assertInvalidTypeSecondArgument("2", "A");
        assertInvalidTypeSecondArgument("1", "B");

        assertInvalidTypeSecondArgument("1", "F");
        assertInvalidTypeSecondArgument("2", "F");
        assertInvalidTypeSecondArgument("1", "E");

        assertInvalidTypeSecondArgument("1", "@");
        assertInvalidTypeSecondArgument("1", "!");
        assertInvalidTypeSecondArgument("1", "%^&");

        assertInvalidTypeSecondArgument("44573", "#404929");
        assertInvalidTypeSecondArgument("-5628564", "#554166");
        assertInvalidTypeSecondArgument("24565", "#655236");

        assertInvalidTypeSecondArgument("12", "3.1");
        assertInvalidTypeSecondArgument("14", "564.01");
        assertInvalidTypeSecondArgument("93", "356.");
        assertInvalidTypeSecondArgument("9823", "316.5");
        assertInvalidTypeSecondArgument("124", "656.45");
        assertInvalidTypeSecondArgument("6647", "574.254");
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
        String input = num1 + SEPARATOR + num2;
        String expectedOutput = String.format(
                "Task 1. Enter two numbers x and y:" + SEPARATOR +
                        "Before: x = %d y = %d" + SEPARATOR +
                        "After: x = %d y = %d" + SEPARATOR,
                num1, num2, num2, num1);

        assertValidConsolePrint(input, expectedOutput, MAIN_METHOD, false);

    }

    /**
     * Asserts that an invalid type input for the first argument is handled correctly by the {@link  SwapMain#main(String[])} method.
     *
     * @param x the first input value (which will be tested for invalid type)
     * @param y the second input value
     */
    public void assertInvalidTypeFirstArgument(String x, String y) {
        String input = x + SEPARATOR + y;
        String expectedOutput = format(INVALID_TYPE_INPUT_SWAP_TEST, "x", x);

        assertValidConsolePrint(input, expectedOutput, MAIN_METHOD, true);
    }

    /**
     * Asserts that an invalid type input for the second argument is handled correctly by the {@link SwapMain#main(String[])} method.
     *
     * @param x the first input value
     * @param y the second input value (which will be tested for invalid type)
     */
    public void assertInvalidTypeSecondArgument(String x, String y) {
        String input = x + SEPARATOR + y;
        String expectedOutput = format(INVALID_TYPE_INPUT_SWAP_TEST, "y", y);

        assertValidConsolePrint(input, expectedOutput, MAIN_METHOD, true);
    }
}