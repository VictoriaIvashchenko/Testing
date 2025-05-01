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
     * System-dependent line separator used for formatting expected test output.
     */
    private final static String LINE_BREAK = System.lineSeparator();

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
        assertInvalidTypeArguments("21475483648|21475483649");
        assertInvalidTypeArguments("21475483648|21475483649|21475483650");
        assertInvalidTypeArguments("21475483648|21475483649|21475483650|21475483651");
        assertInvalidTypeArguments("21475483648|21475483649|21475483650|21475483651|21475483652");

        assertInvalidTypeArguments("-21475483649");
        assertInvalidTypeArguments("-21475483650|-21475483649");
        assertInvalidTypeArguments("-21475483651|-21475483650|-21475483649");
        assertInvalidTypeArguments("-21475483652|-21475483651|-21475483650|-21475483649");
        assertInvalidTypeArguments("-21475483653|-21475483652|-21475483651|-21475483650|-21475483649");

        assertInvalidTypeArguments("21475483648 1");
        assertInvalidTypeArguments("-21475483649 1");
        assertInvalidTypeArguments("21475483648 1 |1 2");
        assertInvalidTypeArguments("-2147483649 1|7 2");
    }

    @Test
    void charactersInputTest() {
        assertInvalidTypeArguments("a");
        assertInvalidTypeArguments("z");

        assertInvalidTypeArguments("a|b");
        assertInvalidTypeArguments("a|b|c");
        assertInvalidTypeArguments("a|b|c|d");

        assertInvalidTypeArguments("y|z");
        assertInvalidTypeArguments("x|y|z");
        assertInvalidTypeArguments("w|x|y|z");

        assertInvalidTypeArguments("A");
        assertInvalidTypeArguments("Z");

        assertInvalidTypeArguments("B");
        assertInvalidTypeArguments("A|B");
        assertInvalidTypeArguments("A|B|C");
        assertInvalidTypeArguments("A|B|C|D");

        assertInvalidTypeArguments("Y|Z");
        assertInvalidTypeArguments("X|Y|Z");
        assertInvalidTypeArguments("W|X|Y|Z");

        assertInvalidTypeArguments("a 1");
        assertInvalidTypeArguments("1 a");
        assertInvalidTypeArguments("pi 45|a 3|r");
        assertInvalidTypeArguments("584 zero|one 34|two");

        assertInvalidTypeArguments("!");
        assertInvalidTypeArguments("@");
        assertInvalidTypeArguments("#|$");
        assertInvalidTypeArguments("#|$|%");
        assertInvalidTypeArguments("^| |&|*");

        assertInvalidTypeArguments("4 .");
        assertInvalidTypeArguments("2^10");
        assertInvalidTypeArguments("1 @|3 &");
        assertInvalidTypeArguments("23% 3|45*8");
    }

    @Test
    void invalidNumericTypeTest() {
        assertInvalidTypeArguments("12.");
        assertInvalidTypeArguments("9856.23");
        assertInvalidTypeArguments("0.45");
        assertInvalidTypeArguments(".0546");
        assertInvalidTypeArguments("0.0");

        assertInvalidTypeArguments("1.2|1.5");
        assertInvalidTypeArguments("178.29|541.5|0.25");
        assertInvalidTypeArguments("2.14|17.85|0.256|78.53");
        assertInvalidTypeArguments("42.57|189.7|59.57|56.58|558.5");

        assertInvalidTypeArguments("-1.5");
        assertInvalidTypeArguments("-8.4|.24");
        assertInvalidTypeArguments("-78.6|-0.25|-659.65");
        assertInvalidTypeArguments("-1.5|-656.56|-46.562|-87.56");

        assertInvalidTypeArguments("#111111|#424543");
        assertInvalidTypeArguments("#446564|#783223|#424543");
        assertInvalidTypeArguments("#764613|#464689|#476643|#566396");

        assertInvalidTypeArguments("#424543");
        assertInvalidTypeArguments("#111111|#424543");
        assertInvalidTypeArguments("#446564|#783223|#424543");
        assertInvalidTypeArguments("#764613|#464689|#476643|#566396");

        assertInvalidTypeArguments("1.5 2");
        assertInvalidTypeArguments("a 2|3% 4");
        assertInvalidTypeArguments("D 2|zero 7|3$");
        assertInvalidTypeArguments("! 2|3.14 2|pi 1 8|5L");
        assertInvalidTypeArguments("% 2");
        assertInvalidTypeArguments("-56 2");

        assertInvalidTypeArguments("34 1");
        assertInvalidTypeArguments("24 0");
        assertInvalidTypeArguments("45 1.5");
        assertInvalidTypeArguments("51 a");
        assertInvalidTypeArguments("56 D 2");
        assertInvalidTypeArguments("45 !");
        assertInvalidTypeArguments("2 $");
        assertInvalidTypeArguments("32 _");
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
     * @param rawInput a string of pipe-separated index inputs (e.g., "a|-1|invalid"), where the last input is ignored
     *                 and replaced by a mock valid index (0)
     */
    public void assertInvalidTypeArguments(String rawInput) {
        int mockIndex = 0;
        String mockOutput = String.format(
                "F(%d) = %d%n", mockIndex, 0
        );

        String[] inputValue = rawInput.split("\\|");
        String invalidValues = String.join(LINE_BREAK, inputValue);
        int count = inputValue.length;

        String input = invalidValues + LINE_BREAK + mockIndex;

        String expectedOutput = PROMPT.repeat(count + 1) + mockOutput;
        String expectedErrorOutput = WARNING.repeat(count);
        String expectedFullOutput = PROMPT + ATTEMPT_MESSAGE.repeat(count) + mockOutput;

        assertConsolePrint(input, expectedOutput, expectedErrorOutput, expectedFullOutput, MAIN_METHOD);
    }

}
