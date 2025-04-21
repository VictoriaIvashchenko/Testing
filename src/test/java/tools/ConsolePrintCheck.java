package tools;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Class {@code ConsolePrintCheck} is utility class for checking the console output and error stream.
 *
 * <p>This class provides a method to capture and validate console output or error output from a task.
 * It allows for testing tasks that print to the console by redirecting the input and output streams.</p>
 *
 * <p>The class restores the original system input, output, and error streams after the task is executed.</p>
 */
public class ConsolePrintCheck {

    /**
     * Tests the console output of a task by redirecting standard input, capturing standard
     * output and error streams, and verifying them against expected values. Both output and
     * error streams are merged into a single stream, with each line prefixed by "out: " or
     * "err: " respectively, and compared to the concatenated expected output and error strings.
     * <p>
     * The method temporarily redirects {@link System#in} to a provided input string,
     * redirects {@link System#out} and {@link System#err} to a custom {@link PrefixPrintStream},
     * runs the provided task, and asserts that the combined output matches the expected
     * output. The original system streams are restored in a {@code finally} block to ensure
     * proper cleanup.
     *
     * @param input          the input string to provide to {@link System#in}, typically for
     *                       simulating user input
     * @param expectedOutput the expected standard output, without prefixes, to be prefixed
     *                       with "out: " for comparison
     * @param expectedError  the expected error output, without prefixes, to be prefixed
     *                       with "err: " for comparison
     * @param task           the {@link Runnable} task to execute, which produces the console
     *                       output to be tested
     */
    public static void assertConsolePrint(String input, String expectedOutput, String expectedError, Runnable task) {
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;
        PrintStream originalErr = System.err;

        try {
            ByteArrayInputStream testIn = new ByteArrayInputStream(input.getBytes());
            System.setIn(testIn);

            ByteArrayOutputStream outStream = new ByteArrayOutputStream();

            PrintStream newOutStream = new PrefixPrintStream(outStream, "out: ");
            PrintStream newErrStream = new PrefixPrintStream(outStream, "err: ");

            System.setOut(newOutStream);
            System.setErr(newErrStream);

            task.run();

            String expectedCombined = addPrefixToLines("out: ", expectedOutput) +
                    addPrefixToLines("err: ", expectedError);
            String actualCombined = outStream.toString();

            assertEquals(expectedCombined, actualCombined, "Unexpected full output.");

        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
            System.setErr(originalErr);
        }
    }

    /**
     * Prepends a specified prefix to each line of the input string, using the platform-specific
     * line separator. This method is used to format expected output strings for comparison
     * with actual output captured by a {@link PrefixPrintStream}.
     * <p>
     * The input string is split into lines using a platform-independent line break regex
     * ({@code \\R}), and each line is prefixed with the provided string. The lines are then
     * joined back together with the platform-specific line separator
     * ({@link System#lineSeparator()}).
     *
     * @param prefix the string to prepend to each line (e.g., "out: ")
     * @param input  the input string to process, which may contain multiple lines
     * @return a new string with the prefix prepended to each line, or an empty string if
     *         the input is {@code null} or empty
     */
    private static String addPrefixToLines(String prefix, String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }
        String lineSeparator = System.lineSeparator();
        String[] lines = input.split("\\R");

        StringBuilder result = new StringBuilder();
        for (String line : lines) {
            result.append(prefix);
            result.append(line);
            result.append(lineSeparator);
        }
        return result.toString();
    }
}