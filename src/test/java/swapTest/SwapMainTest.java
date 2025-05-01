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
     * Prompt message for entering the x value.
     */
    private static final String PROMPT_X = String.format("Enter x:%n");
    /**
     * Prompt message for entering the y value.
     */
    private static final String PROMPT_Y = String.format("Enter y:%n");

    /**
     * Warning message displayed when invalid input is provided.
     * Indicates that a number between -2147483648 and 2147483647 is expected.
     */
    private static final String WARNING =
            String.format("[Warning] Invalid input value. Number from -2147483648 to 2147483647 was expected.%n");

    /**
     * Message for invalid x input, including the warning and x prompt, using for giving new attempt to enter value.
     */
    private static final String ATTEMPT_X_MESSAGE = WARNING + PROMPT_X;
    /**
     * Message for invalid y input, including the warning and y prompt,using for giving new attempt to enter value.
     */
    private static final String ATTEMPT_Y_MESSAGE = WARNING + PROMPT_Y;

    @Test
    void overRangeInputTest() {
        //(MAX, MAX)
        assertInvalidInput("2147483646", "2147483648|1");//(MAX - 1, MAX + 1)
        assertInvalidInput("2147483647", "2147483648|1");//(MAX, MAX + 1)
        assertInvalidInput("2147483648|1", "2147483648|1");//(MAX + 1, MAX + 1)
        assertInvalidInput("2147483648|1", "2147483647");//(MAX + 1, MAX)
        assertInvalidInput("2147483648|1", "2147483646");//(MAX + 1, MAX - 1)
        //(MAX, MIN)
        assertInvalidInput("2147483646", "-2147483649|1");//(MAX - 1, MIN - 1)
        assertInvalidInput("2147483647", "-2147483649|1");//(MAX, MIN - 1)
        assertInvalidInput("2147483648|1", "-2147483649|1");//(MAX + 1, MIN - 1)
        assertInvalidInput("2147483648|1", "-2147483648");//(MAX + 1, MIN)
        assertInvalidInput("2147483648|1", "-2147483647");//(MAX + 1, MIN + 1)
        //(MIN, MIN)
        assertInvalidInput("-2147483647", "-2147483649|1");//(MIN + 1, MIN - 1)
        assertInvalidInput("-2147483648", "-2147483649|1");//(MIN, MIN - 1)
        assertInvalidInput("-2147483649|1", "-2147483649|1");//(MIN - 1, MIN - 1)
        assertInvalidInput("-2147483649|1", "-2147483648");//(MIN - 1, MIN)
        assertInvalidInput("-2147483649|1", "-2147483647");//(MIN - 1, MIN + 1)
        //(MIN, MAX)
        assertInvalidInput("-2147483647", "2147483648|1");//(MIN + 1, MAX + 1)
        assertInvalidInput("-2147483648", "2147483648|1");//(MIN, MAX + 1)
        assertInvalidInput("-2147483649|1", "2147483648|1");//(MIN - 1, MAX + 1)
        assertInvalidInput("-2147483649|1", "2147483647");//(MIN - 1, MAX)
        assertInvalidInput("-2147483649|1", "2147483646");//(MIN - 1, MAX - 1)
        //ребра
        assertInvalidInput("1073741826", "2147483648|1");//(х, MAX + 1)
        assertInvalidInput("2147483648|1", "1073741826");//(MAX + 1, y)
        assertInvalidInput("2147483648|1", "-1073741826");//(MAX + 1, y)
        assertInvalidInput("1073741826", "-2147483649|1");//(x, MIN - 1)
        assertInvalidInput("-1073741826", "-2147483649|1");//(x, MIN - 1)
        assertInvalidInput("-2147483649|1", "-1073741826");//(MIN - 1, y)
        assertInvalidInput("-1073741826", "2147483648|1");//(x, MAX + 1)
        assertInvalidInput("-2147483649|1", "1073741826");//(MIN - 1, y)
    }

    @Test
    public void charactersInputTest() {
        assertInvalidInput("a|1", "1");
        assertInvalidInput("a|b|1", "2");
        assertInvalidInput("a|b|c|1", "1");
        assertInvalidInput("a|b|c|d|1", "1");

        assertInvalidInput("z|1", "1");
        assertInvalidInput("y|z|1", "1");
        assertInvalidInput("x|y|z|1", "1");
        assertInvalidInput("w|x|y|z|1", "1");

        assertInvalidInput("A|1", "1");
        assertInvalidInput("Z|1", "1");

        assertInvalidInput("A|B|1", "1");
        assertInvalidInput("A|B|C|1", "1");
        assertInvalidInput("A|B|C|D|1", "1");

        assertInvalidInput("Y|Z|1", "1");
        assertInvalidInput("X|Y|Z|1", "1");
        assertInvalidInput("W|X|Y|Z|1", "1");

        assertInvalidInput("1", "a|1");
        assertInvalidInput("2", "a|b|1");
        assertInvalidInput("4", "a|b|c|1");
        assertInvalidInput("5", "a|b|c|d|1");

        assertInvalidInput("6", "z|1");
        assertInvalidInput("7", "y|z|1");
        assertInvalidInput("8", "x|y|z|1");
        assertInvalidInput("24", "w|x|y|z|1");

        assertInvalidInput("44", "A|1");
        assertInvalidInput("2", "Z|1");

        assertInvalidInput("54", "A|B|1");
        assertInvalidInput("67", "A|B|C|1");
        assertInvalidInput("7", "A|B|C|D|1");

        assertInvalidInput("-34", "Y|Z|1");
        assertInvalidInput("54", "X|Y|Z|1");
        assertInvalidInput("6", "W|X|Y|Z|1");

        assertInvalidInput("!|2", "1");
        assertInvalidInput("@|!|3", "2");
        assertInvalidInput("#|$|%|4", "3");

        assertInvalidInput("1", "!|2");
        assertInvalidInput("34", "!|@|2");
        assertInvalidInput("5", "!|@|%|2");
        assertInvalidInput("-123", "!|3^3| 4%5|99%|2");

        assertInvalidInput("1%|3", "3$|6");
        assertInvalidInput("556^7|45&4|43", "955_566|23L|6");
        assertInvalidInput("1_23%|45 6%|45 1#|3", "3m|6^2|45");
        assertInvalidInput("23@45|12$ 45%|56^1/2|3", "3$|123");
        assertInvalidInput("1#45 1|45% 100 56|3", "3$|6");

    }

    @Test
    void invalidNumericTypeTest() {
        assertInvalidInput("#245658|1", "2");
        assertInvalidInput("#896456|#453296|2", "1");
        assertInvalidInput("#865456|#455694|#479723|3", "1");

        assertInvalidInput("12.8|1", "3");
        assertInvalidInput("9856.23|.45|0.46|1", "316");
        assertInvalidInput("95.1|45.46|-56.56|66.4|1", "15468745");
        assertInvalidInput("-1.23|-.56|-569.654|85.56|1", "574254");

        assertInvalidInput("1 1|1", "1");
        assertInvalidInput("2147483647 56|1", "1");
        assertInvalidInput("a a|14_|1", "1");
        assertInvalidInput("a 1|1", "1");
        assertInvalidInput("1 a|1", "1");
        assertInvalidInput("! 1|1", "1");
        assertInvalidInput("1 !|1", "2");
        assertInvalidInput("! !|1", "2");
        assertInvalidInput("12.3 1|1", "1");
        assertInvalidInput("1 23.56|1", "1");
        assertInvalidInput("12.3 123.85|1", "1");

        assertInvalidInput("2", "#245658|1");
        assertInvalidInput("2", "#896456|#453296|1");
        assertInvalidInput("2", "#865456|#455694|#479723|1");

        assertInvalidInput("2", "12.8|1");
        assertInvalidInput("2", "9856.23|.45|0.46|1");
        assertInvalidInput("2", "95.1|45.46|-56.56|66.4|1");
        assertInvalidInput("2", "-1.23|-.56|-569.654|85.56|1");

        assertInvalidInput("2", "1 1|1");
        assertInvalidInput("2", "2147483647 56|1");
        assertInvalidInput("2", "a a|14_|1");
        assertInvalidInput("2", "a 1|1");
        assertInvalidInput("2", "1 a|1");
        assertInvalidInput("2", "! 1|1");
        assertInvalidInput("2", "1 !|1");
        assertInvalidInput("2", "! !|1");
        assertInvalidInput("2", "12.3 1|1");
        assertInvalidInput("2", "1 23.56|1");
        assertInvalidInput("2", "12.3 123.85|1");
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
                "%s%sBefore: x = %d y = %d%n" +
                        "After: x = %d y = %d%n", PROMPT_X, PROMPT_Y, num1, num2, num2, num1);
        String expectedErrorOutput = "";

        assertConsolePrint(input, expectedOutput, expectedErrorOutput, expectedOutput, MAIN_METHOD);

    }

    /**
     * Tests the console output for invalid input scenarios, ensuring proper prompts and error messages.
     * The method splits the input strings for x and y, counts invalid inputs, and constructs expected
     * console output and error output based on the number of invalid attempts.
     *
     * @param x a string containing x input values separated by "|", where only the last value is valid
     * @param y a string containing y input values separated by "|", where only the last value is valid
     */
    public void assertInvalidInput(String x, String y) {
        String[] firstValueInput = x.split("\\|");
        String[] secondValueInput = y.split("\\|");

        int countXValues = firstValueInput.length;
        int countYValues = secondValueInput.length;
        int countAllInvalidInputs = countXValues + countYValues - 2;//count of all invalid values

        String input = getInput(firstValueInput, secondValueInput);

        String expectedResult = getExpectedResult(firstValueInput, secondValueInput);

        String expectedOutput = PROMPT_X.repeat(countXValues) + PROMPT_Y.repeat(countYValues) + expectedResult;
        String expectedErrorOutput = WARNING.repeat(countAllInvalidInputs);
        String expectedFullOutput = PROMPT_X + ATTEMPT_X_MESSAGE.repeat(countXValues - 1) +
                PROMPT_Y + ATTEMPT_Y_MESSAGE.repeat(countYValues - 1) + expectedResult;

        assertConsolePrint(input, expectedOutput, expectedErrorOutput, expectedFullOutput, MAIN_METHOD);
    }

    /**
     * Constructs the input string by combining x and y values with line breaks.
     *
     * @param firstValues  array of x input values
     * @param secondValues array of y input values
     * @return a string representing the combined input with line breaks
     */
    private static String getInput(String[] firstValues, String[] secondValues) {
        String xValues = String.join(LINE_BREAK, firstValues);
        String yValues = String.join(LINE_BREAK, secondValues);
        return String.join(LINE_BREAK, xValues, yValues);
    }

    /**
     * Generates the expected result string for valid x and y inputs, formatting the "Before" and "After" states.
     *
     * @param xValues array of x input values, where only the last value is valid
     * @param yValues array of y input values, where only the last value is valid
     * @return a formatted string showing the valid x and y values before and after swapping
     */
    private static String getExpectedResult(String[] xValues, String[] yValues) {
        String validX = xValues[xValues.length - 1];
        String validY = yValues[yValues.length - 1];

        return String.format("Before: x = %s y = %s%n" +
                "After: x = %s y = %s%n", validX, validY, validY, validX);
    }
}