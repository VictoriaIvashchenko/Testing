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
        assertInvalidInput("2147483646", "2147483648\n1");//(MAX - 1, MAX + 1)
        assertInvalidInput("2147483647", "2147483648\n1");//(MAX, MAX + 1)
        assertInvalidInput("2147483648\n1", "2147483648\n1");//(MAX + 1, MAX + 1)
        assertInvalidInput("2147483648\n1", "2147483647");//(MAX + 1, MAX)
        assertInvalidInput("2147483648\n1", "2147483646");//(MAX + 1, MAX - 1)
        //(MAX, MIN)
        assertInvalidInput("2147483646", "-2147483649\n1");//(MAX - 1, MIN - 1)
        assertInvalidInput("2147483647", "-2147483649\n1");//(MAX, MIN - 1)
        assertInvalidInput("2147483648\n1", "-2147483649\n1");//(MAX + 1, MIN - 1)
        assertInvalidInput("2147483648\n1", "-2147483648");//(MAX + 1, MIN)
        assertInvalidInput("2147483648\n1", "-2147483647");//(MAX + 1, MIN + 1)
        //(MIN, MIN)
        assertInvalidInput("-2147483647", "-2147483649\n1");//(MIN + 1, MIN - 1)
        assertInvalidInput("-2147483648", "-2147483649\n1");//(MIN, MIN - 1)
        assertInvalidInput("-2147483649\n1", "-2147483649\n1");//(MIN - 1, MIN - 1)
        assertInvalidInput("-2147483649\n1", "-2147483648");//(MIN - 1, MIN)
        assertInvalidInput("-2147483649\n1", "-2147483647");//(MIN - 1, MIN + 1)
        //(MIN, MAX)
        assertInvalidInput("-2147483647", "2147483648\n1");//(MIN + 1, MAX + 1)
        assertInvalidInput("-2147483648", "2147483648\n1");//(MIN, MAX + 1)
        assertInvalidInput("-2147483649\n1", "2147483648\n1");//(MIN - 1, MAX + 1)
        assertInvalidInput("-2147483649\n1", "2147483647");//(MIN - 1, MAX)
        assertInvalidInput("-2147483649\n1", "2147483646");//(MIN - 1, MAX - 1)
        //ребра
        assertInvalidInput("1073741826", "2147483648\n1");//(х, MAX + 1)
        assertInvalidInput("2147483648\n1", "1073741826");//(MAX + 1, y)
        assertInvalidInput("2147483648\n1", "-1073741826");//(MAX + 1, y)
        assertInvalidInput("1073741826", "-2147483649\n1");//(x, MIN - 1)
        assertInvalidInput("-1073741826", "-2147483649\n1");//(x, MIN - 1)
        assertInvalidInput("-2147483649\n1", "-1073741826");//(MIN - 1, y)
        assertInvalidInput("-1073741826", "2147483648\n1");//(x, MAX + 1)
        assertInvalidInput("-2147483649\n1", "1073741826");//(MIN - 1, y)

        assertInvalidInput("2147483648\n2147483649\n2", "2147483648\n2147483649\n54");
        assertInvalidInput("2147483648\n2147483649\n2147483650\n321", "2147483648\n2147483649\n2147483650\n123");
        assertInvalidInput("2147483648\n2147483649\n2147483650\n2147483651\n2", "2147483648\n2147483649\n2147483650\n2147483651\n54");
        assertInvalidInput("2147483648\n2147483649\n2147483650\n2147483651\n2147483652\n56", "2147483648\n2147483649\n2147483650\n2147483651\n2147483652\n54");
    }

    @Test
    public void charactersInputTest() {
        assertInvalidInput("a\n1", "1");
        assertInvalidInput("a\nb\n1", "2");
        assertInvalidInput("a\nb\nc\n45", "78");
        assertInvalidInput("a\nb\nc\nd\n1", "52");
        assertInvalidInput("a\nb\nc\nd\nf\n123", "321");

        assertInvalidInput("z\n1", "1");
        assertInvalidInput("y\nz\n1", "1");
        assertInvalidInput("x\ny\nz\n1", "1");
        assertInvalidInput("w\nx\ny\nz\n1", "1");

        assertInvalidInput("A\n1", "1");
        assertInvalidInput("Z\n1", "1");

        assertInvalidInput("A\nB\n1", "1");
        assertInvalidInput("A\nB\nC\n1", "1");
        assertInvalidInput("A\nB\nC\nD\n1", "1");

        assertInvalidInput("Y\nZ\n1", "1");
        assertInvalidInput("X\nY\nZ\n1", "1");
        assertInvalidInput("W\nX\nY\nZ\n1", "1");

        assertInvalidInput("1", "a\n1");
        assertInvalidInput("2", "a\nb\n1");
        assertInvalidInput("4", "a\nb\nc\n1");
        assertInvalidInput("5", "a\nb\nc\nd\n1");

        assertInvalidInput("6", "z\n1");
        assertInvalidInput("7", "y\nz\n1");
        assertInvalidInput("8", "x\ny\nz\n1");
        assertInvalidInput("24", "w\nx\ny\nz\n1");

        assertInvalidInput("44", "A\n1");
        assertInvalidInput("2", "Z\n1");

        assertInvalidInput("54", "A\nB\n1");
        assertInvalidInput("67", "A\nB\nC\n1");
        assertInvalidInput("7", "A\nB\nC\nD\n1");

        assertInvalidInput("-34", "Y\nZ\n1");
        assertInvalidInput("54", "X\nY\nZ\n1");
        assertInvalidInput("6", "W\nX\nY\nZ\n1");

        assertInvalidInput("!\n2", "1");
        assertInvalidInput("@\n!\n3", "-743");
        assertInvalidInput("#\n$\n%\n-464", "345");
        assertInvalidInput("#\n$\n%\n^\n568", "895");

        assertInvalidInput("1", "!\n2");
        assertInvalidInput("34", "!\n@\n2");
        assertInvalidInput("5", "!\n@\n%\n2");
        assertInvalidInput("-123", "!\n3^3\n 4%5\n99%\n2");

        assertInvalidInput("1%\n3", "3$\n6");
        assertInvalidInput("556^7\n45&4\n43", "955_566\n23L\n6");
        assertInvalidInput("1_23%\n45 6%\n45 1#\n3", "3m\n6^2\n45");
        assertInvalidInput("23@45\n12$ 45%\n56^1/2\n3", "3$\n123");
        assertInvalidInput("1#45 1\n45% 100 56\n3", "3$\n6");
        assertInvalidInput("~(゜゜;)＼(--;)\n\\(^^)/\n(-.-)y-~\n4", "(＠＾＾＠)／\n(._.)\n5");

    }

    @Test
    void invalidNumericTypeTest() {
        assertInvalidInput("#245658\n1", "2");
        assertInvalidInput("#896456\n#453296\n2", "-7621");
        assertInvalidInput("#478996\n#445954\n#479723\n3", "45");
        assertInvalidInput("#865456\n#459423\n#348648\n#784531\n3", "1");
        assertInvalidInput("#459879\n#455694\n#479723\n#479632\n#448783\n4", "489");

        assertInvalidInput("12.8\n1", "3");
        assertInvalidInput("9856.23\n.45\n0.46\n1", "316");
        assertInvalidInput("95.1\n45.46\n-56.56\n66.4\n1", "15468745");
        assertInvalidInput("-1.23\n-.56\n-569.654\n85.56\n1", "574254");

        assertInvalidInput("1 1\n1", "1");
        assertInvalidInput("2147483647 56\n78 0\n5", "1");
        assertInvalidInput("a a\n14_\n55L 55\n77", "88");
        assertInvalidInput("a 1\nzero 0\n0b111\n47%7\n7+1-2\n1", "1");
        assertInvalidInput("12.3 123.85\n-0.21\na\n(9)\n1", "1");

        assertInvalidInput("2", "#245658\n1");
        assertInvalidInput("2", "#896456\n#453296\n1");
        assertInvalidInput("2", "#865456\n#455694\n#479723\n1");

        assertInvalidInput("2", "12.8\n1");
        assertInvalidInput("2", "9856.23\n.45\n0.46\n1");
        assertInvalidInput("2", "95.1\n45.46\n-56.56\n66.4\n1");
        assertInvalidInput("2", "-1.23\n-.56\n-569.654\n85.56\n1");

        assertInvalidInput("2", "1 1\n1");
        assertInvalidInput("23", "2147483647 56\na 23\n1");
        assertInvalidInput("68", "a a\n14_\n12$ 4\n445 f\n1");
        assertInvalidInput("-15", "a 1\n№1 2\n45^2 -5\n56+4\n#1\n5");
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
        String input = num1 + "\n" + num2;

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
     * @param x a string containing x input values separated by "\n", where only the last value is valid
     * @param y a string containing y input values separated by "\n", where only the last value is valid
     */
    public void assertInvalidInput(String x, String y) {
        int countXValues = getCount(x);
        int countYValues = getCount(y);
        int countAllInvalidInputs = countXValues + countYValues - 2;//count of all invalid values

        String input = String.join("\n", x, y);

        String expectedResult = getExpectedResult(x, y);

        String expectedOutput = PROMPT_X.repeat(countXValues) + PROMPT_Y.repeat(countYValues) + expectedResult;
        String expectedErrorOutput = WARNING.repeat(countAllInvalidInputs);
        String expectedFullOutput = PROMPT_X + ATTEMPT_X_MESSAGE.repeat(countXValues - 1) +
                PROMPT_Y + ATTEMPT_Y_MESSAGE.repeat(countYValues - 1) + expectedResult;

        assertConsolePrint(input, expectedOutput, expectedErrorOutput, expectedFullOutput, MAIN_METHOD);
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
     * Generates the expected result string for valid x and y inputs, formatting the "Before" and "After" states.
     *
     * @param x string contains x input values, where only the last value is valid
     * @param y string contains y input values, where only the last value is valid
     * @return a formatted string showing the valid x and y values before and after swapping
     */
    private static String getExpectedResult(String x, String y) {
        String[] xValues = x.split("\n");
        String[] yValues = y.split("\n");

        String validX = xValues[xValues.length - 1];
        String validY = yValues[yValues.length - 1];

        return String.format("Before: x = %s y = %s%n" +
                "After: x = %s y = %s%n", validX, validY, validY, validX);
    }
}