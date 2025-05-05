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
        assertInvalidArguments("2", "4", "6", "2147483648\n8", "2");
        assertInvalidArguments("2", "4", "2147483648\n6", "8", "2");
        assertInvalidArguments("2", "2147483648\n4", "6", "8", "2");
        assertInvalidArguments("2147483648\n2", "4", "6", "8", "2");
        assertInvalidArguments("2147483648\n2", "2147483648\n4", "2147483648\n6", "2147483648\n8", "2");

        assertInvalidArguments("2", "4", "6", "-2147483649\n8", "2");
        assertInvalidArguments("2", "4", "-2147483649\n6", "8", "2");
        assertInvalidArguments("2", "-2147483649\n4", "6", "8", "2");
        assertInvalidArguments("-2147483649\n2", "4", "6", "8", "2");
        assertInvalidArguments("-2147483649\n2", "-2147483649\n4", "-2147483649\n6", "-2147483649\n8", "2");

        assertInvalidArguments("2147483648\n2147483649\n6", "2147483648\n2147483649\n12", "2147483648\n2147483649\n36", "2147483648\n2147483649\n1", "1");
        assertInvalidArguments("2147483648\n2147483649\n2147483650\n11", "2147483648\n2147483649\n2147483650\n121", "2147483648\n2147483649\n2147483650\n22", "2147483648\n2147483649\n2147483650\n242", "11");
        assertInvalidArguments("2147483648\n2147483649\n2147483651\n2147483650\n4", "2147483648\n2147483649\n2147483651\n2147483650\n4", "2147483648\n2147483649\n2147483651\n2147483650\n4", "2147483648\n2147483649\n2147483651\n2147483650\n4", "4");
        assertInvalidArguments("2147483648\n2147483649\n2147483651\n2147483650\n2147483652\n4", "2147483648\n2147483649\n2147483651\n2147483650\n2147483652\n4", "2147483648\n2147483649\n2147483651\n2147483650\n2147483652\n4", "2147483648\n2147483649\n2147483651\n2147483650\n2147483652\n4", "4");

        assertInvalidArguments("-2147483649\n-2147483650\n6", "-2147483649\n-2147483650\n12", "-2147483649\n-2147483650\n36", "-2147483649\n-2147483650\n1", "1");
        assertInvalidArguments("-2147483649\n-2147483650\n-2147483651\n11", "-2147483649\n-2147483650\n-2147483651\n121", "-2147483649\n-2147483650\n-2147483651\n22", "-2147483649\n-2147483650\n-2147483651\n44", "11");
        assertInvalidArguments("-2147483649\n-2147483650\n-2147483651\n-2147483652\n4", "-2147483649\n-2147483650\n-2147483651\n-2147483652\n4", "-2147483649\n-2147483650\n-2147483651\n-2147483652\n4", "-2147483649\n-2147483650\n-2147483651\n-2147483652\n4", "4");
        assertInvalidArguments("-2147483649\n-2147483650\n-2147483651\n-2147483652\n-2147483653\n4", "-2147483649\n-2147483650\n-2147483651\n-2147483652\n2147483653\n4", "-2147483649\n-2147483650\n-2147483651\n-2147483652\n2147483653\n4", "-2147483649\n-2147483650\n-2147483651\n-2147483652\n2147483653\n4", "4");

    }

    @Test
    void charactersInputTest() {
        assertInvalidArguments("a\n2", "a\n4", "a\n6", "a\n8", "2");
        assertInvalidArguments("z\n2", "z\n4", "z\n6", "z\n8", "2");

        assertInvalidArguments("a\nb\n2", "a\nb\n4", "a\nb\n6", "a\nb\n8", "2");
        assertInvalidArguments("a\nb\nc\n2", "a\nb\nc\n4", "a\nb\nc\n6", "a\nb\nc\n8", "2");
        assertInvalidArguments("a\nb\nc\nd\n2", "a\nb\nc\nd\n4", "a\nb\nc\nd\n6", "a\nb\nc\nd\n8", "2");
        assertInvalidArguments("a\nb\nc\nd\nf\n2", "a\nb\nc\nd\nf\n4", "a\nb\nc\nd\nf\n6", "a\nb\nc\nd\nf\n8", "2");

        assertInvalidArguments("y\nz\n2", "y\nz\n4", "y\nz\n6", "y\nz\n8", "2");
        assertInvalidArguments("x\ny\nz\n4", "x\ny\nz\n2", "x\ny\nz\n6", "x\ny\nz\n8", "2");
        assertInvalidArguments("w\nx\ny\nz\n10", "w\nx\ny\nz\n4", "w\nx\ny\nz\n6", "w\nx\ny\nz\n8", "2");
        assertInvalidArguments("v\nw\nx\ny\nz\n12", "v\nw\nx\ny\nz\n4", "v\nw\nx\ny\nz\n24", "v\nw\nx\ny\nz\n8", "4");

        assertInvalidArguments("A\n2", "A\n4", "A\n6", "A\n8", "2");
        assertInvalidArguments("Z\n2", "Z\n4", "Z\n6", "Z\n8", "2");

        assertInvalidArguments("A\nB\n2", "A\nB\n4", "A\nB\n6", "A\nB\n8", "2");
        assertInvalidArguments("A\nB\nC\n2", "A\nB\nC\n4", "A\nB\nC\n6", "A\nB\nC\n8", "2");
        assertInvalidArguments("A\nB\nC\nD\n2", "A\nB\nC\nD\n4", "A\nB\nC\nD\n6", "A\nB\nC\nD\n8", "2");
        assertInvalidArguments("A\nB\nC\nD\nF\n2", "A\nB\nC\nD\nF\n4", "A\nB\nC\nD\nF\n6", "A\nB\nC\nD\nF\n8", "2");

        assertInvalidArguments("Y\nZ\n2", "Y\nZ\n4", "Y\nZ\n6", "Y\nZ\n8", "2");
        assertInvalidArguments("X\nY\nZ\n4", "X\nY\nZ\n2", "X\nY\nZ\n6", "X\nY\nZ\n8", "2");
        assertInvalidArguments("W\nX\nY\nZ\n10", "W\nX\nY\nZ\n4", "W\nX\nY\nZ\n6", "W\nX\nY\nZ\n8", "2");
        assertInvalidArguments("V\nW\nX\nY\nZ\n12", "V\nW\nX\nY\nZ\n4", "V\nW\nX\nY\nZ\n6", "V\nW\nX\nY\nZ\n8", "2");

        assertInvalidArguments("!\n2", "!\n4", "!\n6", "!\n8", "2");
        assertInvalidArguments("!\n@\n2", "!\n@\n4", "!\n@\n6", "!\n@\n8", "2");
        assertInvalidArguments("!\n@\n#\n2", "!\n@\n#\n4", "!\n@\n#\n6", "!\n@\n#\n8", "2");
        assertInvalidArguments("!\n@\n#\n$\n2", "!\n@\n#\n$\n4", "!\n@\n#\n$\n6", "!\n@\n#\n$\n8", "2");

        assertInvalidArguments("1!\n2", "2%\n4", "6^2\n6", "5$\n8", "2");
        assertInvalidArguments("1 3%\n2", "1@ 4\n4", "3$ 4\n6", "43$ 4\n8", "2");
        assertInvalidArguments("23$ 4\n2", "23# 4\n4", "23! 3\n6", "2 $4\n8", "2");

        assertInvalidArguments("(((￣へ￣井)\n10", "(｡-｀へ´-｡)\n35", "(； ・`д・´)\n125","｡ﾟヽ(ﾟ｀Д´ﾟ)ﾉﾟ｡\n15", "5");
    }

    @Test
    void invalidNumericTypeTest() {
        assertInvalidArguments("1.3\n2", "23.3\n4", "42.2\n6", "23.5\n8", "2");
        assertInvalidArguments("78.1\n0.25\n2", "26.1\n0.94\n4", "2.3\n0.49\n6", "3.5\n0.1\n8", "2");
        assertInvalidArguments("71.2\n0.29\n-0.2\n2", "23.3\n0.43\n-12.2\n4", "2.1\n0.64\n-1.6\n6", "20.1\n0.25\n-8.3\n8", "2");
        assertInvalidArguments("780.15\n-0.15\n-786.5\n0.4f\n2", "78.36\n0.91\n-783.1\n48.5f\n4", "2.1\n0.64\n-1.6\n55.55\n6", "20.1\n0.25\n-8.3\n7.8\n8", "2");
        assertInvalidArguments("71.2\n0.29\n-0.2\n72.12\n-15.5f\n2", "23.3\n0.43\n-12.2\n78.4\n-96.2\n4", "2.1\n0.64\n-1.6\n71.3\n-45.3f\n6", "20.1\n0.25\n-8.3\n73.2\n-0.2\n8", "2");

        assertInvalidArguments("12.4 1\n2", "45 2\n4", "84 5\n6", "14 3\n8", "2");
        assertInvalidArguments("-124.5\n45L\n13", "-0.5\n0b010\n169", "-1.7\n100_000\n26", "98.5\n45.12f\n65", "13");
        assertInvalidArguments("0.5\n4_014\n5.1f\n12", "5^2\n5.60\n0b111\n144", "36.2\n78L\n-6.3\n24", "0.6\n774.14\n86.3\n36", "12");
        assertInvalidArguments("-56.5\n0b111\nF\n123A\n2", "-45.4\n5.8\n-14L\n14F\n4", "7.8\n1.4f\n45$\n9%\n6", "85.7\n1L\n45.7\n-96^2\n8", "2");

        assertInvalidArguments("15", "2.5\n5", "10", "50", "5");
        assertInvalidArguments("1 2\n10", "1245.4f\n12 3.1\n2", "12", "45_4L\n0.1\n-78^2\n42", "2");
        assertInvalidArguments("5", "2.5\n15", "10", "50", "5");
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
     * Method forms string to simulate input from console.
     * @param a first integer input
     * @param b second integer input
     * @param c third integer input
     * @param d fourth integer input
     * @return string with input values separated with "\n"
     */
    private static String getInput(int a, int b, int c, int d) {
        return a + "\n" + b + "\n" + c + "\n" + d;
    }

    /**
     * Tests the console output for invalid input scenarios, ensuring proper prompts and error messages.
     * The method splits the input strings for four input numbers, counts invalid inputs, and constructs expected
     * console output and error output based on the number of invalid attempts.
     *
     * @param number1  a string containing first number input values separated by "\n", where only the last value is valid
     * @param number2  a string containing second number input values separated by "\n", where only the last value is valid
     * @param number3  a string containing third number input values separated by "\n", where only the last value is valid
     * @param number4  a string containing fourth number input values separated by "\n", where only the last value is valid
     * @param expected expected calculation result
     */
    public void assertInvalidArguments(String number1, String number2, String number3, String number4, String expected) {
        int countNum1Values = getCount(number1);
        int countNum2Values = getCount(number2);
        int countNum3Values = getCount(number3);
        int countNum4Values = getCount(number4);
        int countInvalidValues = countNum1Values + countNum2Values + countNum3Values + countNum4Values - 4;//count of all invalid values

        String expectedResult = getExpectedResult(number1, number2, number3, number4, expected);

        String input = String.join("\n", number1, number2, number3, number4);

        String expectedOutput = PROMPT_NUM1.repeat(countNum1Values) + PROMPT_NUM2.repeat(countNum2Values) +
                PROMPT_NUM3.repeat(countNum3Values) + PROMPT_NUM4.repeat(countNum4Values) + expectedResult;
        String expectedError = WARNING_MESSAGE.repeat(countInvalidValues);
        String expectedFullOutput = PROMPT_NUM1 + ATTEMPT_FIRST_NUM_MESSAGE.repeat(countNum1Values - 1) +
                PROMPT_NUM2 + ATTEMPT_SECOND_NUM_MESSAGE.repeat(countNum2Values - 1) +
                PROMPT_NUM3 + ATTEMPT_THIRD_NUM_MESSAGE.repeat(countNum3Values - 1) +
                PROMPT_NUM4 + ATTEMPT_FOURTH_NUM_MESSAGE.repeat(countNum4Values - 1) + expectedResult;

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
     * Generates the expected result string for representing calculated gcd of four numbers.
     *
     * @param a string contains first number input values, where only the last value is valid
     * @param b string contains second number input values, where only the last value is valid
     * @param c string contains third number input values, where only the last value is valid
     * @param d string contains fourth number input values, where only the last value is valid
     * @return a formatted string showing the valid x and y values before and after swapping
     */
    private static String getExpectedResult(String a, String b, String c, String d, String expected) {
        String[] valuesA = a.split("\n");
        String[] valuesB = b.split("\n");
        String[] valuesC = c.split("\n");
        String[] valuesD = d.split("\n");

        String validNum1 = valuesA[valuesA.length - 1];
        String validNum2 = valuesB[valuesB.length - 1];
        String validNum3 = valuesC[valuesC.length - 1];
        String validNum4 = valuesD[valuesD.length - 1];

        return format("GCD(%s, %s, %s, %s) = %s%n", validNum1, validNum2, validNum3, validNum4, expected);
    }

}
