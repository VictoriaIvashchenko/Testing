package fibonacciTest;

import org.junit.jupiter.api.Test;
import fibonacci.FibonacciMain;

import static java.lang.String.format;
import static java.lang.String.valueOf;
import static tools.ConsolePrintCheck.assertConsolePrint;

/**
 * Unit test class for {@link FibonacciMain}.
 *
 * <p>This class extends {@link FibonacciTest} and provides specific test configurations
 * for verifying the behavior of the {@link FibonacciMain} program. It sets up the main method
 * for execution during tests and defines a system-dependent line separator.</p>
 */
public class FibonacciMainTest extends FibonacciTest {

    /**
     * A {@link Runnable} reference to the {@code main} method of {@link FibonacciMain}.
     *
     * <p>This runnable executes {@link FibonacciMain#main(String[])} with an empty argument array,
     * allowing test cases to simulate program execution.</p>
     */
    private final static Runnable MAIN_METHOD = () -> FibonacciMain.main(new String[]{});

    /**
     * Prompt message for entering the index.
     */
    private static final String PROMPT = String.format("Enter index:%n");

    /**
     * Warning message for invalid index input, expecting a number from 0 to 2,147,483,647.
     */
    private static final String WARNING =
            String.format("[Warning] Invalid input value. Number from 0 to 2147483647 was expected.%n");

    /**
     * Message for invalid index input followed by the index prompt, using for giving new attempt to enter value.
     */
    public static final String ATTEMPT_MESSAGE = String.format(
            "[Warning] Invalid input value. Number from 0 to 2147483647 was expected.%n" +
                    "Enter index:%n");

    @Test
    void overRangeInputTest() {
        assertInvalidTypeArguments("21475483648");
        assertInvalidTypeArguments("21475483648\n21475483649");
        assertInvalidTypeArguments("21475483648\n21475483649\n21475483650");
        assertInvalidTypeArguments("21475483648\n21475483649\n21475483650\n21475483651");
        assertInvalidTypeArguments("21475483648\n21475483649\n21475483650\n21475483651\n21475483652");

        assertInvalidTypeArguments("-21475483649");
        assertInvalidTypeArguments("-21475483650\n-21475483649");
        assertInvalidTypeArguments("-21475483651\n-21475483650\n-21475483649");
        assertInvalidTypeArguments("-21475483652\n-21475483651\n-21475483650\n-21475483649");
        assertInvalidTypeArguments("-21475483653\n-21475483652\n-21475483651\n-21475483650\n-21475483649");

        assertInvalidTypeArguments("21475483648 1");
        assertInvalidTypeArguments("-21475483649 1");
        assertInvalidTypeArguments("21475483648 1 \n1 2");
        assertInvalidTypeArguments("-2147483649 1\n7 2");
    }

    @Test
    void charactersInputTest() {
        assertInvalidTypeArguments("a");
        assertInvalidTypeArguments("z");

        assertInvalidTypeArguments("a\nb");
        assertInvalidTypeArguments("a\nb\nc");
        assertInvalidTypeArguments("a\nb\nc\nd");

        assertInvalidTypeArguments("y\nz");
        assertInvalidTypeArguments("x\ny\nz");
        assertInvalidTypeArguments("w\nx\ny\nz");

        assertInvalidTypeArguments("A");
        assertInvalidTypeArguments("Z");

        assertInvalidTypeArguments("B");
        assertInvalidTypeArguments("A\nB");
        assertInvalidTypeArguments("A\nB\nC");
        assertInvalidTypeArguments("A\nB\nC\nD");

        assertInvalidTypeArguments("Y\nZ");
        assertInvalidTypeArguments("X\nY\nZ");
        assertInvalidTypeArguments("W\nX\nY\nZ");

        assertInvalidTypeArguments("a 1");
        assertInvalidTypeArguments("1 a");
        assertInvalidTypeArguments("pi 45\na 3\nr");
        assertInvalidTypeArguments("584 zero\none 34\ntwo");

        assertInvalidTypeArguments("!");
        assertInvalidTypeArguments("@");
        assertInvalidTypeArguments("#\n$");
        assertInvalidTypeArguments("#\n$\n%");
        assertInvalidTypeArguments("^\n \n&\n*");

        assertInvalidTypeArguments("4 .");
        assertInvalidTypeArguments("2^10");
        assertInvalidTypeArguments("1 @\n3 &");
        assertInvalidTypeArguments("23% 3\n45*8");
        assertInvalidTypeArguments("(；￢＿￢)");
    }

    @Test
    void invalidNumericTypeTest() {
        assertInvalidTypeArguments("12.");
        assertInvalidTypeArguments("9856.23");
        assertInvalidTypeArguments("0.45");
        assertInvalidTypeArguments(".0546");
        assertInvalidTypeArguments("-15.5");
        assertInvalidTypeArguments("0.0");

        assertInvalidTypeArguments("1.2\n1.5");
        assertInvalidTypeArguments("178.29\n541.5\n0.25");
        assertInvalidTypeArguments("2.14\n17.85\n0.256\n78.53");
        assertInvalidTypeArguments("42.57\n189.7\n59.57\n56.58\n558.5");

        assertInvalidTypeArguments("-1.5");
        assertInvalidTypeArguments("-8.4\n.24");
        assertInvalidTypeArguments("-78.6\n-0.25\n-659.65");
        assertInvalidTypeArguments("-1.5\n-656.56\n-46.562\n-87.56");

        assertInvalidTypeArguments("#111111\n#424543");
        assertInvalidTypeArguments("#446564\n#783223\n#424543");
        assertInvalidTypeArguments("#764613\n#464689\n#476643\n#566396");

        assertInvalidTypeArguments("#424543");
        assertInvalidTypeArguments("#111111\n#424543");
        assertInvalidTypeArguments("#446564\n#783223\n#424543");
        assertInvalidTypeArguments("#764613\n#464689\n#476643\n#566396");

        assertInvalidTypeArguments("1.5 2");
        assertInvalidTypeArguments("a 2\n3% 4");
        assertInvalidTypeArguments("D 2\nzero 7\n3$");
        assertInvalidTypeArguments("! 2\n3.14 2\npi 1 8\n5L");
        assertInvalidTypeArguments("% 2");
        assertInvalidTypeArguments("-56 2");

        assertInvalidTypeArguments("34 1");
        assertInvalidTypeArguments("24 0\na 2");
        assertInvalidTypeArguments("45 1.5\n4 a\n1.2 2");
        assertInvalidTypeArguments("51 a\na 6\n8.3 7\n3 7%");
        assertInvalidTypeArguments("56 D 2\n5 -1\n1 * 2\n5/5");
    }

    /**
     * Asserts that the Fibonacci number at a given index is equal to the expected value.
     *
     * <p>This method simulates console input for the Fibonacci index and compares the actual output with the expected
     * Fibonacci number at that index. It verifies that the Fibonacci value for the specified index is correct.</p>
     *
     * @param actualIndex the index in the Fibonacci sequence to check
     * @param expected    the expected Fibonacci number as a string
     */
    @Override
    public void assertFibonacciEquals(int actualIndex, String expected) {
        String input = valueOf(actualIndex);

        String expectedOutput = format("Enter index:%n" +
                "F(%d) = %s%n", actualIndex, expected);
        String expectedErrorOutput = "";

        assertConsolePrint(input, expectedOutput, expectedErrorOutput, expectedOutput, MAIN_METHOD);
    }

    /**
     * Asserts that the console output and error messages match the expected results for a sequence of invalid index
     * inputs followed by a valid mock index, simulating user interaction and validating the final result.
     *
     * @param invalidValues a string of pipe-separated index inputs (e.g., "a\n-1\ninvalid"), where the last input is ignored
     *                      and replaced by a mock valid index (0)
     */
    public void assertInvalidTypeArguments(String invalidValues) {
        String mockIndex = "0";
        String mockOutput = String.format(
                "F(%s) = %d%n", mockIndex, 0
        );

        String[] inputValue = invalidValues.split("\n");
        int count = inputValue.length;

        String input = String.join("\n", invalidValues, mockIndex);

        String expectedOutput = PROMPT.repeat(count + 1) + mockOutput;
        String expectedErrorOutput = WARNING.repeat(count);
        String expectedFullOutput = PROMPT + ATTEMPT_MESSAGE.repeat(count) + mockOutput;

        assertConsolePrint(input, expectedOutput, expectedErrorOutput, expectedFullOutput, MAIN_METHOD);
    }

}
