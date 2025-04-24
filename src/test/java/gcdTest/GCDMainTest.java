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
     * Obligatory starting message with instructions.
     */
    private final static String PROMPT = "Task 3. Enter four numbers for searching gcd:" + LINE_BREAK;

    @Test
    void overRangeInputTest() {
        assertInvalidInputArgumentType("2147483648", "2147483648", "2147483648", "2147483648");
        assertInvalidInputArgumentType("1", "2147483648", "2147483648", "2147483648");
        assertInvalidInputArgumentType("1", "1", "2147483648", "2147483648");
        assertInvalidInputArgumentType("1", "1", "1", "2147483648");

        assertInvalidInputArgumentType("-2147483649", "-2147483649", "-2147483649", "-2147483649");
        assertInvalidInputArgumentType("1", "-2147483649", "-2147483649", "-2147483649");
        assertInvalidInputArgumentType("1", "1", "-2147483649", "-2147483649");
        assertInvalidInputArgumentType("1", "1", "1", "-2147483649");
    }

    @Test
    void invalidFirstArgumentTypeTest() {
        assertInvalidInputArgumentType("a", "a", "a", "a");
        assertInvalidInputArgumentType("b", "c", "d", "e");
        assertInvalidInputArgumentType("y", "r", "x", "q");
        assertInvalidInputArgumentType("z", "z", "z", "z");

        assertInvalidInputArgumentType("A", "A", "A", "A");
        assertInvalidInputArgumentType("B", "C", "D", "E");
        assertInvalidInputArgumentType("Y", "R", "X", "Q");
        assertInvalidInputArgumentType("Z", "Z", "Z", "Z");

        assertInvalidInputArgumentType("a", "1", "1", "2");
        assertInvalidInputArgumentType("b", "1", "1", "2");
        assertInvalidInputArgumentType("y", "1", "1", "2");
        assertInvalidInputArgumentType("z", "1", "1", "2");

        assertInvalidInputArgumentType("A", "A", "A", "A");
        assertInvalidInputArgumentType("B", "C", "D", "E");
        assertInvalidInputArgumentType("Y", "R", "X", "Q");
        assertInvalidInputArgumentType("Z", "Z", "Z", "Z");

        assertInvalidInputArgumentType("A", "1", "1", "2");
        assertInvalidInputArgumentType("B", "1", "1", "2");
        assertInvalidInputArgumentType("Y", "1", "1", "2");
        assertInvalidInputArgumentType("Z", "1", "1", "2");

        assertInvalidInputArgumentType("a", "a", "1", "1");
        assertInvalidInputArgumentType("a", "1", "a", "1");
        assertInvalidInputArgumentType("a", "1", "1", "a");
        assertInvalidInputArgumentType("a", "a", "a", "1");
        assertInvalidInputArgumentType("a", "a", "1", "a");
        assertInvalidInputArgumentType("a", "1", "a", "a");

        assertInvalidInputArgumentType("!", "!", "!", "!");
        assertInvalidInputArgumentType("@", "@", "@", "@");

        assertInvalidInputArgumentType("!", "1", "1", "1");
        assertInvalidInputArgumentType("@", "1", "1", "1");

        assertInvalidInputArgumentType("!", "!", "1", "1");
        assertInvalidInputArgumentType("!", "!", "!", "1");
        assertInvalidInputArgumentType("!", "1", "1", "!");
        assertInvalidInputArgumentType("!", "!", "!", "1");
        assertInvalidInputArgumentType("!", "!", "1", "!");
        assertInvalidInputArgumentType("!", "1", "!", "!");

        assertInvalidInputArgumentType("#564595", "#569864", "#785123", "#459712");
        assertInvalidInputArgumentType("#115865", "#146658", "#565893", "#142365");

        assertInvalidInputArgumentType(".564", ".78", ".12", ".463");
        assertInvalidInputArgumentType("45.4", "14.14", "78.94", "45.310");

    }

    @Test
    void invalidSecondArgumentTypeTest() {
        assertInvalidInputArgumentType("1", "a", "a", "a");
        assertInvalidInputArgumentType("1", "c", "d", "e");
        assertInvalidInputArgumentType("1", "r", "x", "q");
        assertInvalidInputArgumentType("1", "z", "z", "z");

        assertInvalidInputArgumentType("1", "A", "A", "A");
        assertInvalidInputArgumentType("1", "C", "D", "E");
        assertInvalidInputArgumentType("1", "R", "X", "Q");
        assertInvalidInputArgumentType("1", "Z", "Z", "Z");

        assertInvalidInputArgumentType("1", "a", "1", "2");
        assertInvalidInputArgumentType("1", "b", "1", "2");
        assertInvalidInputArgumentType("1", "y", "1", "2");
        assertInvalidInputArgumentType("1", "z", "1", "2");

        assertInvalidInputArgumentType("1", "a", "a", "2");
        assertInvalidInputArgumentType("1", "b", "b", "2");
        assertInvalidInputArgumentType("1", "y", "y", "2");
        assertInvalidInputArgumentType("1", "z", "z", "2");

        assertInvalidInputArgumentType("1", "a", "1", "a");
        assertInvalidInputArgumentType("1", "b", "1", "b");
        assertInvalidInputArgumentType("1", "y", "1", "y");
        assertInvalidInputArgumentType("1", "z", "1", "z");

        assertInvalidInputArgumentType("1", "!", "!", "!");
        assertInvalidInputArgumentType("1", "@", "@", "@");
        assertInvalidInputArgumentType("1", "!", "34", "12");
        assertInvalidInputArgumentType("1", "@", "76", "26");
        assertInvalidInputArgumentType("1", "!", "#", "12");
        assertInvalidInputArgumentType("1", "@", "$36", "26");
        assertInvalidInputArgumentType("1", "!", "34", "3%");
        assertInvalidInputArgumentType("1", "@", "76", "@4");

        assertInvalidInputArgumentType("1", "#856956", "#546646", "#223455");
        assertInvalidInputArgumentType("1", "#124631", "#233466", "@");
        assertInvalidInputArgumentType("1", "#245763", "34", "#235469");

        assertInvalidInputArgumentType("1", "12.56", "236.2", "563.12");
        assertInvalidInputArgumentType("1", ".156", "236", "56.36");
        assertInvalidInputArgumentType("56", "-56.56", "563.23", "237");

        assertInvalidInputArgumentType("45", "5 5", "45 55", "15 63");
        assertInvalidInputArgumentType("45", "78 63", "1575", "145 4.5");
        assertInvalidInputArgumentType("45", "55 0.26", "26 302", "1453");
    }

    @Test
    void invalidThirdArgumentTypeTest() {
        assertInvalidInputArgumentType("367", "56", "a", "a");
        assertInvalidInputArgumentType("463", "123", "d", "e");
        assertInvalidInputArgumentType("45", "563", "x", "q");
        assertInvalidInputArgumentType("98", "866", "z", "z");

        assertInvalidInputArgumentType("367", "56", "A", "A");
        assertInvalidInputArgumentType("463", "123", "D", "E");
        assertInvalidInputArgumentType("45", "563", "X", "Q");
        assertInvalidInputArgumentType("98", "866", "Z", "Z");

        assertInvalidInputArgumentType("1", "1", "a", "462");
        assertInvalidInputArgumentType("1", "1", "b", "256");
        assertInvalidInputArgumentType("1", "1", "y", "5300");
        assertInvalidInputArgumentType("1", "44", "z", "144");

        assertInvalidInputArgumentType("1", "55", "!", "!");
        assertInvalidInputArgumentType("1", "463", "@", "@");
        assertInvalidInputArgumentType("1", "665", "!", "12");
        assertInvalidInputArgumentType("1", "236", "@", "26");

        assertInvalidInputArgumentType("1", "6956", "#546646", "#223455");
        assertInvalidInputArgumentType("1", "4631", "#233466", "@");
        assertInvalidInputArgumentType("1", "763", "#586989", "469");

        assertInvalidInputArgumentType("1", "1256", "236.2", "563.12");
        assertInvalidInputArgumentType("1", "86", "236.", "56.36");
        assertInvalidInputArgumentType("56", "-556", "563.23", "237");

        assertInvalidInputArgumentType("45", "663", "45 55", "15 63");
        assertInvalidInputArgumentType("45", "7863", "15 75", "145 4.5");
        assertInvalidInputArgumentType("45", "5526", "26 302", "1453");
        assertInvalidInputArgumentType("45", "7863", "15 75", "145 4%");
    }

    @Test
    void invalidFourthArgumentTypeTest() {
        assertInvalidInputArgumentType("1", "1", "1", "a");
        assertInvalidInputArgumentType("1", "1", "1", "b");
        assertInvalidInputArgumentType("1", "1", "1", "y");
        assertInvalidInputArgumentType("1", "1", "1", "z");

        assertInvalidInputArgumentType("1", "1", "1", "A");
        assertInvalidInputArgumentType("1", "1", "1", "B");
        assertInvalidInputArgumentType("1", "1", "1", "Y");
        assertInvalidInputArgumentType("1", "1", "1", "Z");

        assertInvalidInputArgumentType("1", "55", "86", "!");
        assertInvalidInputArgumentType("1", "463", "146", "@");
        assertInvalidInputArgumentType("1", "665", "856", "#$");
        assertInvalidInputArgumentType("1", "236", "662", "346%");

        assertInvalidInputArgumentType("1", "6956", "646", "#223455");
        assertInvalidInputArgumentType("1", "4631", "236", "#46455");
        assertInvalidInputArgumentType("1", "763", "989", "#456469");

        assertInvalidInputArgumentType("1", "1256", "2362", "563.12");
        assertInvalidInputArgumentType("1", "86", "236", ".36");
        assertInvalidInputArgumentType("56", "-556", "56323", "-11.237");

        assertInvalidInputArgumentType("45", "663", "4575", "15 63");
        assertInvalidInputArgumentType("45", "7863", "1575", "145 4.5");
        assertInvalidInputArgumentType("45", "5526", "2602", "14 -53");
        assertInvalidInputArgumentType("45", "7863", "1575", "145 4%");
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

        String expectedOutput = format("%sGCD(%d, %d, %d, %d) = %d%n", PROMPT, a, b, c, d, expected);
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

        String expectedOutput = format("%sGCD(%d, %d, %d, %d) = 2147483648%n", PROMPT, a, b, c, d);
        String expectedErrorOutput = "";

        assertConsolePrint(input, expectedOutput, expectedErrorOutput, expectedOutput, MAIN_METHOD);
    }

    /**
     * Asserts that the method {@link gcd.GCD#gcdOfFour(int, int, int, int)} throws an error for an invalid type in the argument.
     *
     * @param a the first argument as a string
     * @param b the second argument as a string
     * @param c the third argument as a string
     * @param d the fourth argument as a string
     */
    public void assertInvalidInputArgumentType(String a, String b, String c, String d) {
        String input = a + LINE_BREAK + b + LINE_BREAK + c + LINE_BREAK + d;

        String expectedErrorOutput = "Invalid type of input value. Number from -2147483648 to 2147483647 was expected.";
        String expectedFullOutput = PROMPT + expectedErrorOutput;

        assertConsolePrint(input, PROMPT, expectedErrorOutput, expectedFullOutput, MAIN_METHOD);
    }

    private static String getInput(int a, int b, int c, int d) {
        return a + LINE_BREAK + b + LINE_BREAK + c + LINE_BREAK + d;
    }
}
