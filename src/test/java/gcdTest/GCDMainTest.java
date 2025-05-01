package gcdTest;

import org.junit.jupiter.api.Test;
import gcd.GCDMain;

import static java.lang.String.format;
import static tools.ConsolePrintCheck.assertConsolePrint;

/**
 * Unit test class for {@link GCDMain}.
 *
 * <p>This class extends {@link GCDTest} and provides specific test configurations
 * for verifying the behavior of the {@link GCDMain} program. It sets up the main method
 * for execution during tests and defines a system-dependent line separator.</p>
 */
public class GCDMainTest extends GCDTest {

    /**
     * A {@link Runnable} reference to the {@code main} method of {@link GCDMain}.
     *
     * <p>This runnable executes {@link GCDMain#main(String[])} with an empty argument array,
     * allowing test cases to simulate program execution.</p>
     */
    private final static Runnable MAIN_METHOD = () -> GCDMain.main(new String[]{});

    /**
     * System-dependent line separator used for formatting expected test output.
     */
    private final static String LINE_BREAK = System.lineSeparator();

    /**
     * Prompt message for entering the first number.
     */
    private final static String PROMPT_NUM1 = String.format("Enter first number:%n");
    /**
     * Prompt message for entering the second number.
     */
    private final static String PROMPT_NUM2 = String.format("Enter second number:%n");
    /**
     * Prompt message for entering the third number.
     */
    private final static String PROMPT_NUM3 = String.format("Enter third number:%n");
    /**
     * Prompt message for entering the fourth number.
     */
    private final static String PROMPT_NUM4 = String.format("Enter fourth number:%n");

    /**
     * Warning message displayed when invalid input is provided.
     * Indicates that a number between -2147483648 and 2147483647 is expected.
     */
    private final static String WARNING_MESSAGE =
            String.format("[Warning] Invalid input value. Number from -2147483648 to 2147483647 was expected.%n");

    /**
     * Message for invalid first number input, including the warning and x prompt, using for giving new attempt to enter value.
     */
    private static final String ATTEMPT_FOURTH_NUM_MESSAGE = WARNING_MESSAGE + PROMPT_NUM4;
    /**
     * Message for invalid second number input, including the warning and x prompt, using for giving new attempt to enter value.
     */
    private static final String ATTEMPT_THIRD_NUM_MESSAGE = WARNING_MESSAGE + PROMPT_NUM3;
    /**
     * Message for invalid third number input, including the warning and x prompt, using for giving new attempt to enter value.
     */
    private static final String ATTEMPT_SECOND_NUM_MESSAGE = WARNING_MESSAGE + PROMPT_NUM2;
    /**
     * Message for invalid fourth number input, including the warning and x prompt, using for giving new attempt to enter value.
     */
    private static final String ATTEMPT_FIRST_NUM_MESSAGE = WARNING_MESSAGE + PROMPT_NUM1;


    @Test
    void overRangeInputTest() {
        assertInvalidArguments("2", "4", "6", "2147483648|8", "2");
        assertInvalidArguments("2", "4", "2147483648|6", "8", "2");
        assertInvalidArguments("2", "2147483648|4", "6", "8", "2");
        assertInvalidArguments("2147483648|2", "4", "6", "8", "2");
        assertInvalidArguments("2147483648|2", "2147483648|4", "2147483648|6", "2147483648|8", "2");

        assertInvalidArguments("2", "4", "6", "-2147483649|8", "2");
        assertInvalidArguments("2", "4", "-2147483649|6", "8", "2");
        assertInvalidArguments("2", "-2147483649|4", "6", "8", "2");
        assertInvalidArguments("-2147483649|2", "4", "6", "8", "2");
        assertInvalidArguments("-2147483649|2", "-2147483649|4", "-2147483649|6", "-2147483649|8", "2");

    }

    @Test
    void charactersInputTest() {
        assertInvalidArguments("a|2", "a|4", "a|6", "a|8", "2");
        assertInvalidArguments("z|2", "z|4", "z|6", "z|8", "2");

        assertInvalidArguments("a|b|2", "a|b|4", "a|b|6", "a|b|8", "2");
        assertInvalidArguments("a|b|c|2", "a|b|c|4", "a|b|c|6", "a|b|c|8", "2");
        assertInvalidArguments("a|b|c|d|2", "a|b|c|d|4", "a|b|c|d|6", "a|b|c|d|8", "2");

        assertInvalidArguments("A|2", "A|4", "A|6", "A|8", "2");
        assertInvalidArguments("Z|2", "Z|4", "Z|6", "Z|8", "2");

        assertInvalidArguments("A|B|2", "A|B|4", "A|B|6", "A|B|8", "2");
        assertInvalidArguments("A|B|C|2", "A|B|C|4", "A|B|C|6", "A|B|C|8", "2");
        assertInvalidArguments("A|B|C|D|2", "A|B|C|D|4", "A|B|C|D|6", "A|B|C|D|8", "2");

        assertInvalidArguments("!|2", "!|4", "!|6", "!|8", "2");
        assertInvalidArguments("!|@|2", "!|@|4", "!|@|6", "!|@|8", "2");
        assertInvalidArguments("!|@|#|2", "!|@|#|4", "!|@|#|6", "!|@|#|8", "2");
        assertInvalidArguments("!|@|#|$|2", "!|@|#|$|4", "!|@|#|$|6", "!|@|#|$|8", "2");

        assertInvalidArguments("1!|2", "2%|4", "6^2|6", "5$|8", "2");
        assertInvalidArguments("1 3%|2", "1@ 4|4", "3$ 4|6", "43$ 4|8", "2");
        assertInvalidArguments("23$ 4|2", "23# 4|4", "23! 3|6", "2 $4|8", "2");
    }

    @Test
    void invalidNumericTypeTest() {
        assertInvalidArguments("1.3|2", "23.3|4", "42.2|6", "23.5|8", "2");
        assertInvalidArguments("78.1|0.25|2", "26.1|0.94|4", "2.3|0.49|6", "3.5|0.1|8", "2");
        assertInvalidArguments("71.2|0.29|-0.2|2", "23.3|0.43|-12.2|4", "2.1|0.64|-1.6|6", "20.1|0.25|-8.3|8", "2");

        assertInvalidArguments("12.4 1|2", "45 2|4", "84 5|6", "14 3|8", "2");
        assertInvalidArguments("-56.5 8|2", "-45 5.8|4", "7.8 1|6", "85 96|8", "2");
    }

    private static String getInput(int a, int b, int c, int d) {
        return a + LINE_BREAK + b + LINE_BREAK + c + LINE_BREAK + d;
    }

    /**
     * Asserts that the method {@link gcd.GCD#gcdOfFour(int, int, int, int)} correctly calculates the GCD of four
     * integers and prints the expected output.
     *
     * @param expected the expected GCD result
     * @param a        the first integer input
     * @param b        the second integer input
     * @param c        the third integer input
     * @param d        the fourth integer input
     */
    @Override
    public void assertGCDResult(int expected, int a, int b, int c, int d) {
        String input = getInput(a, b, c, d);

        String expectedOutput = format("%s%s%s%sGCD(%d, %d, %d, %d) = %d%n",
                PROMPT_NUM1, PROMPT_NUM2, PROMPT_NUM3, PROMPT_NUM4, a, b, c, d, expected);
        String expectedErrorOutput = "";

        assertConsolePrint(input, expectedOutput, expectedErrorOutput, expectedOutput, MAIN_METHOD);
    }

    /**
     * Asserts that the method {@link gcd.GCD#gcdOfFour(int, int, int, int)} throws a {@link exceptions.CalculationException}
     * when calculating the GCD for four integers and also checks if the appropriate output message is printed to the console when the exception occurs.</p>
     *
     * @param a the first integer input
     * @param b the second integer input
     * @param c the third integer input
     * @param d the fourth integer input
     */
    @Override
    public void assertThrowsCalculationException(int a, int b, int c, int d) {
        String input = getInput(a, b, c, d);

        String expectedOutput = format("%s%s%s%sGCD(%d, %d, %d, %d) = 2147483648%n",
                PROMPT_NUM1, PROMPT_NUM2, PROMPT_NUM3, PROMPT_NUM4, a, b, c, d);
        String expectedErrorOutput = "";

        assertConsolePrint(input, expectedOutput, expectedErrorOutput, expectedOutput, MAIN_METHOD);
    }

    /**
     * Tests the console output for invalid input scenarios, ensuring proper prompts and error messages.
     * The method splits the input strings for four input numbers, counts invalid inputs, and constructs expected
     * console output and error output based on the number of invalid attempts.
     *
     * @param number1 a string containing first number input values separated by "|", where only the last value is valid
     * @param number2 a string containing second number input values separated by "|", where only the last value is valid
     * @param number3 a string containing third number input values separated by "|", where only the last value is valid
     * @param number4 a string containing fourth number input values separated by "|", where only the last value is valid
     * @param expected expected calculation result
     */
    public void assertInvalidArguments(String number1, String number2, String number3, String number4, String expected) {
        String[] firstArgValues = number1.split("\\|");
        String[] secondArgValues = number2.split("\\|");
        String[] thirdArgValues = number3.split("\\|");
        String[] fourthArgValues = number4.split("\\|");

        int countNum1Values = firstArgValues.length;
        int countNum2Values = secondArgValues.length;
        int countNum3Values = thirdArgValues.length;
        int countNum4Values = fourthArgValues.length;
        int countInvalidValues = countNum1Values + countNum2Values + countNum3Values + countNum4Values - 4;

        String mockResult = getExpectedResult(firstArgValues, secondArgValues, thirdArgValues, fourthArgValues, expected);

        String input = getInput(firstArgValues, secondArgValues, thirdArgValues, fourthArgValues);

        String expectedOutput = PROMPT_NUM1.repeat(countNum1Values) + PROMPT_NUM2.repeat(countNum2Values) +
                PROMPT_NUM3.repeat(countNum3Values) + PROMPT_NUM4.repeat(countNum4Values) + mockResult;
        String expectedError = WARNING_MESSAGE.repeat(countInvalidValues);
        String expectedFullOutput = PROMPT_NUM1 + ATTEMPT_FIRST_NUM_MESSAGE.repeat(countNum1Values - 1) +
                PROMPT_NUM2 + ATTEMPT_SECOND_NUM_MESSAGE.repeat(countNum2Values - 1) +
                PROMPT_NUM3 + ATTEMPT_THIRD_NUM_MESSAGE.repeat(countNum3Values - 1) +
                PROMPT_NUM4 + ATTEMPT_FOURTH_NUM_MESSAGE.repeat(countNum4Values - 1) + mockResult;

        assertConsolePrint(input, expectedOutput, expectedError, expectedFullOutput, MAIN_METHOD);

    }

    /**
     * Constructs the input string by combining first, second, third and fourth values with line breaks.
     *
     * @param a array of first number input values
     * @param b array of second number input values
     * @param c array of third number input values
     * @param d array of fourth number input values
     * @return a string representing the combined input with line breaks
     */
    private static String getInput(String[] a, String[] b, String[] c, String[] d) {
        String firstArgumentInput = String.join(LINE_BREAK, a);
        String secondArgumentInput = String.join(LINE_BREAK, b);
        String thirdArgumentInput = String.join(LINE_BREAK, c);
        String fourthArgumentInput = String.join(LINE_BREAK, d);

        return String.join(LINE_BREAK, firstArgumentInput, secondArgumentInput, thirdArgumentInput, fourthArgumentInput);
    }

    /**
     * Generates the expected result string for representing calculated gcd of four numbers.
     *
     * @param a array of first number input values, where only the last value is valid
     * @param b array of second number input values, where only the last value is valid
     * @param c array of third number input values, where only the last value is valid
     * @param d array of fourth number input values, where only the last value is valid
     * @return a formatted string showing the valid x and y values before and after swapping
     */
    private static String getExpectedResult(String[] a, String[] b, String[] c, String[] d, String expected) {
        String validNum1 = a[a.length - 1];
        String validNum2 = b[b.length - 1];
        String validNum3 = c[c.length - 1];
        String validNum4 = d[d.length - 1];

        return format("GCD(%s, %s, %s, %s) = %s%n", validNum1, validNum2, validNum3, validNum4, expected);
    }

}
