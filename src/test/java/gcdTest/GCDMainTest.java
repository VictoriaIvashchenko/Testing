package gcdTest;

import org.junit.jupiter.api.Test;
import gcd.GCDMain;

import static java.lang.String.format;
import static tools.ConsolePrintCheck.assertValidConsolePrint;

/**
 * Unit test class for {@link GCDMain}.
 *
 * <p>This class extends {@link GCDTest} and provides specific test configurations
 * for verifying the behavior of the {@link GCDMain} program. It sets up the main method
 * for execution during tests and defines a system-dependent line separator.</p>
 */
public class GCDMainTest extends GCDTest {

    /**
     * Error message for an invalid type input in GCD calculations.
     */
    final static String INVALID_INPUT_TYPE_MESSAGE =
            "Invalid type of %s. Number from -2147483648 to 2147483647 was expected, but '%s' was received.";
    /**
     * System-dependent line separator used for formatting expected test output.
     */
    final static String SEPARATOR = System.lineSeparator();
    /**
     * A {@link Runnable} reference to the {@code main} method of {@link GCDMain}.
     *
     * <p>This runnable executes {@link GCDMain#main(String[])} with an empty argument array,
     * allowing test cases to simulate program execution.</p>
     */
    final static Runnable MAIN_METHOD = () -> GCDMain.main(new String[]{});

    @Test
    void overRangeInputTest() {
        assertInvalidFirstArgumentType("2147483648", "2147483648", "2147483648", "2147483648");
        assertInvalidSecondArgumentType("1", "2147483648", "2147483648", "2147483648");
        assertInvalidThirdArgumentType("1", "1", "2147483648", "2147483648");
        assertInvalidFourthArgumentType("1", "1", "1", "2147483648");

        assertInvalidFirstArgumentType("-2147483649", "-2147483649", "-2147483649", "-2147483649");
        assertInvalidSecondArgumentType("1", "-2147483649", "-2147483649", "-2147483649");
        assertInvalidThirdArgumentType("1", "1", "-2147483649", "-2147483649");
        assertInvalidFourthArgumentType("1", "1", "1", "-2147483649");
    }

    @Test
    void invalidFirstArgumentTypeTest() {
        assertInvalidFirstArgumentType("a", "a", "a", "a");
        assertInvalidFirstArgumentType("b", "c", "d", "e");
        assertInvalidFirstArgumentType("y", "r", "x", "q");
        assertInvalidFirstArgumentType("z", "z", "z", "z");

        assertInvalidFirstArgumentType("A", "A", "A", "A");
        assertInvalidFirstArgumentType("B", "C", "D", "E");
        assertInvalidFirstArgumentType("Y", "R", "X", "Q");
        assertInvalidFirstArgumentType("Z", "Z", "Z", "Z");

        assertInvalidFirstArgumentType("a", "1", "1", "2");
        assertInvalidFirstArgumentType("b", "1", "1", "2");
        assertInvalidFirstArgumentType("y", "1", "1", "2");
        assertInvalidFirstArgumentType("z", "1", "1", "2");

        assertInvalidFirstArgumentType("A", "A", "A", "A");
        assertInvalidFirstArgumentType("B", "C", "D", "E");
        assertInvalidFirstArgumentType("Y", "R", "X", "Q");
        assertInvalidFirstArgumentType("Z", "Z", "Z", "Z");

        assertInvalidFirstArgumentType("A", "1", "1", "2");
        assertInvalidFirstArgumentType("B", "1", "1", "2");
        assertInvalidFirstArgumentType("Y", "1", "1", "2");
        assertInvalidFirstArgumentType("Z", "1", "1", "2");

        assertInvalidFirstArgumentType("a", "a", "1", "1");
        assertInvalidFirstArgumentType("a", "1", "a", "1");
        assertInvalidFirstArgumentType("a", "1", "1", "a");
        assertInvalidFirstArgumentType("a", "a", "a", "1");
        assertInvalidFirstArgumentType("a", "a", "1", "a");
        assertInvalidFirstArgumentType("a", "1", "a", "a");

        assertInvalidFirstArgumentType("!", "!", "!", "!");
        assertInvalidFirstArgumentType("@", "@", "@", "@");

        assertInvalidFirstArgumentType("!", "1", "1", "1");
        assertInvalidFirstArgumentType("@", "1", "1", "1");

        assertInvalidFirstArgumentType("!", "!", "1", "1");
        assertInvalidFirstArgumentType("!", "!", "!", "1");
        assertInvalidFirstArgumentType("!", "1", "1", "!");
        assertInvalidFirstArgumentType("!", "!", "!", "1");
        assertInvalidFirstArgumentType("!", "!", "1", "!");
        assertInvalidFirstArgumentType("!", "1", "!", "!");

        assertInvalidFirstArgumentType("#564595", "#569864", "#785123", "#459712");
        assertInvalidFirstArgumentType("#115865", "#146658", "#565893", "#142365");

        assertInvalidFirstArgumentType(".564", ".78", ".12", ".463");
        assertInvalidFirstArgumentType("45.4", "14.14", "78.94", "45.310");

    }

    @Test
    void invalidSecondArgumentTypeTest() {
        assertInvalidSecondArgumentType("1", "a", "a", "a");
        assertInvalidSecondArgumentType("1", "c", "d", "e");
        assertInvalidSecondArgumentType("1", "r", "x", "q");
        assertInvalidSecondArgumentType("1", "z", "z", "z");

        assertInvalidSecondArgumentType("1", "A", "A", "A");
        assertInvalidSecondArgumentType("1", "C", "D", "E");
        assertInvalidSecondArgumentType("1", "R", "X", "Q");
        assertInvalidSecondArgumentType("1", "Z", "Z", "Z");

        assertInvalidSecondArgumentType("1", "a", "1", "2");
        assertInvalidSecondArgumentType("1", "b", "1", "2");
        assertInvalidSecondArgumentType("1", "y", "1", "2");
        assertInvalidSecondArgumentType("1", "z", "1", "2");

        assertInvalidSecondArgumentType("1", "a", "a", "2");
        assertInvalidSecondArgumentType("1", "b", "b", "2");
        assertInvalidSecondArgumentType("1", "y", "y", "2");
        assertInvalidSecondArgumentType("1", "z", "z", "2");

        assertInvalidSecondArgumentType("1", "a", "1", "a");
        assertInvalidSecondArgumentType("1", "b", "1", "b");
        assertInvalidSecondArgumentType("1", "y", "1", "y");
        assertInvalidSecondArgumentType("1", "z", "1", "z");

        assertInvalidSecondArgumentType("1", "!", "!", "!");
        assertInvalidSecondArgumentType("1", "@", "@", "@");
        assertInvalidSecondArgumentType("1", "!", "34", "12");
        assertInvalidSecondArgumentType("1", "@", "76", "26");
        assertInvalidSecondArgumentType("1", "!", "#", "12");
        assertInvalidSecondArgumentType("1", "@", "$36", "26");
        assertInvalidSecondArgumentType("1", "!", "34", "3%");
        assertInvalidSecondArgumentType("1", "@", "76", "@4");

        assertInvalidSecondArgumentType("1", "#856956", "#546646", "#223455");
        assertInvalidSecondArgumentType("1", "#124631", "#233466", "@");
        assertInvalidSecondArgumentType("1", "#245763", "34", "#235469");

        assertInvalidSecondArgumentType("1", "12.56", "236.2", "563.12");
        assertInvalidSecondArgumentType("1", ".156", "236", "56.36");
        assertInvalidSecondArgumentType("56", "-56.56", "563.23", "237");

        assertInvalidSecondArgumentType("45", "5 5", "45 55", "15 63");
        assertInvalidSecondArgumentType("45", "78 63", "1575", "145 4.5");
        assertInvalidSecondArgumentType("45", "55 0.26", "26 302", "1453");
    }

    @Test
    void invalidThirdArgumentTypeTest() {
        assertInvalidThirdArgumentType("367", "56", "a", "a");
        assertInvalidThirdArgumentType("463", "123", "d", "e");
        assertInvalidThirdArgumentType("45", "563", "x", "q");
        assertInvalidThirdArgumentType("98", "866", "z", "z");

        assertInvalidThirdArgumentType("367", "56", "A", "A");
        assertInvalidThirdArgumentType("463", "123", "D", "E");
        assertInvalidThirdArgumentType("45", "563", "X", "Q");
        assertInvalidThirdArgumentType("98", "866", "Z", "Z");

        assertInvalidThirdArgumentType("1", "1", "a", "462");
        assertInvalidThirdArgumentType("1", "1", "b", "256");
        assertInvalidThirdArgumentType("1", "1", "y", "5300");
        assertInvalidThirdArgumentType("1", "44", "z", "144");

        assertInvalidThirdArgumentType("1", "55", "!", "!");
        assertInvalidThirdArgumentType("1", "463", "@", "@");
        assertInvalidThirdArgumentType("1", "665", "!", "12");
        assertInvalidThirdArgumentType("1", "236", "@", "26");

        assertInvalidThirdArgumentType("1", "6956", "#546646", "#223455");
        assertInvalidThirdArgumentType("1", "4631", "#233466", "@");
        assertInvalidThirdArgumentType("1", "763", "#586989", "469");

        assertInvalidThirdArgumentType("1", "1256", "236.2", "563.12");
        assertInvalidThirdArgumentType("1", "86", "236.", "56.36");
        assertInvalidThirdArgumentType("56", "-556", "563.23", "237");

        assertInvalidThirdArgumentType("45", "663", "45 55", "15 63");
        assertInvalidThirdArgumentType("45", "7863", "15 75", "145 4.5");
        assertInvalidThirdArgumentType("45", "5526", "26 302", "1453");
        assertInvalidThirdArgumentType("45", "7863", "15 75", "145 4%");
    }

    @Test
    void invalidFourthArgumentTypeTest() {
        assertInvalidFourthArgumentType("1", "1", "1", "a");
        assertInvalidFourthArgumentType("1", "1", "1", "b");
        assertInvalidFourthArgumentType("1", "1", "1", "y");
        assertInvalidFourthArgumentType("1", "1", "1", "z");

        assertInvalidFourthArgumentType("1", "1", "1", "A");
        assertInvalidFourthArgumentType("1", "1", "1", "B");
        assertInvalidFourthArgumentType("1", "1", "1", "Y");
        assertInvalidFourthArgumentType("1", "1", "1", "Z");

        assertInvalidFourthArgumentType("1", "55", "86", "!");
        assertInvalidFourthArgumentType("1", "463", "146", "@");
        assertInvalidFourthArgumentType("1", "665", "856", "#$");
        assertInvalidFourthArgumentType("1", "236", "662", "346%");

        assertInvalidFourthArgumentType("1", "6956", "646", "#223455");
        assertInvalidFourthArgumentType("1", "4631", "236", "#46455");
        assertInvalidFourthArgumentType("1", "763", "989", "#456469");

        assertInvalidFourthArgumentType("1", "1256", "2362", "563.12");
        assertInvalidFourthArgumentType("1", "86", "236", ".36");
        assertInvalidFourthArgumentType("56", "-556", "56323", "-11.237");

        assertInvalidFourthArgumentType("45", "663", "4575", "15 63");
        assertInvalidFourthArgumentType("45", "7863", "1575", "145 4.5");
        assertInvalidFourthArgumentType("45", "5526", "2602", "14 -53");
        assertInvalidFourthArgumentType("45", "7863", "1575", "145 4%");
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
        String input = a + SEPARATOR + b + SEPARATOR + c + SEPARATOR + d;
        String expectedOutput = format(
                "Task 3. Enter four numbers for searching gcd:" + SEPARATOR +
                        "GCD(%d, %d, %d, %d) = %d", a, b, c, d, expected);

        assertValidConsolePrint(input, expectedOutput, MAIN_METHOD, false);

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
        String input = a + SEPARATOR + b + SEPARATOR + c + SEPARATOR + d;
        String expectedOutput = format(
                "Task 3. Enter four numbers for searching gcd:" + SEPARATOR +
                        "GCD(%d, %d, %d, %d) = 2147483648", a, b, c, d);

        assertValidConsolePrint(input, expectedOutput, MAIN_METHOD, false);
    }

    /**
     * Asserts that the method {@link gcd.GCD#gcdOfFour(int, int, int, int)} throws an error for an invalid type in the first argument.
     *
     * @param a the first argument as a string (invalid type)
     * @param b the second argument as a string
     * @param c the third argument as a string
     * @param d the fourth argument as a string
     */
    public void assertInvalidFirstArgumentType(String a, String b, String c, String d) {
        String input = a + SEPARATOR + b + SEPARATOR + c + SEPARATOR + d;
        String expectedOutput = format(INVALID_INPUT_TYPE_MESSAGE, "a", a);

        assertValidConsolePrint(input, expectedOutput, MAIN_METHOD, true);

    }

    /**
     * Asserts that the method {@link gcd.GCD#gcdOfFour(int, int, int, int)} throws an error for an invalid type in the second argument.
     *
     * @param a the first argument as a string
     * @param b the second argument as a string (invalid type)
     * @param c the third argument as a string
     * @param d the fourth argument as a string
     */
    public void assertInvalidSecondArgumentType(String a, String b, String c, String d) {
        String input = a + SEPARATOR + b + SEPARATOR + c + SEPARATOR + d;
        String expectedOutput = format(INVALID_INPUT_TYPE_MESSAGE, "b", b);

        assertValidConsolePrint(input, expectedOutput, MAIN_METHOD, true);

    }

    /**
     * Asserts that the method {@link gcd.GCD#gcdOfFour(int, int, int, int)} throws an error for an invalid type in the third argument.
     *
     * @param a the first argument as a string
     * @param b the second argument as a string
     * @param c the third argument as a string (invalid type)
     * @param d the fourth argument as a string
     */
    public void assertInvalidThirdArgumentType(String a, String b, String c, String d) {
        String input = a + SEPARATOR + b + SEPARATOR + c + SEPARATOR + d;
        String expectedOutput = format(INVALID_INPUT_TYPE_MESSAGE, "c", c);

        assertValidConsolePrint(input, expectedOutput, MAIN_METHOD, true);
    }

    /**
     * Asserts that the method {@link gcd.GCD#gcdOfFour(int, int, int, int)} throws an error for an invalid type in the fourth argument.
     *
     * @param a the first argument as a string
     * @param b the second argument as a string
     * @param c the third argument as a string
     * @param d the fourth argument as a string (invalid type)
     */
    public void assertInvalidFourthArgumentType(String a, String b, String c, String d) {
        String input = a + SEPARATOR + b + SEPARATOR + c + SEPARATOR + d;
        String expectedOutput = format(INVALID_INPUT_TYPE_MESSAGE, "d", d);

        assertValidConsolePrint(input, expectedOutput, MAIN_METHOD, true);
    }

}
