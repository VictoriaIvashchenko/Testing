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
     * Asserts that the console output and error streams match expected values for a given task.
     *
     * <p>This method executes the specified {@code task} twice and checks its console output.
     * The first check is done with merged standard output and error streams,
     * and the second with separated streams. It verifies that the output and error match
     * the given expected values.</p>
     *
     * @param input          the simulated user input provided to {@code System.in}
     * @param expectedOutput the expected output written to {@code System.out}
     * @param expectedError  the expected error output written to {@code System.err}
     * @param task           the code to be executed that generates the console output
     */
    public static void assertValidConsolePrint(String input, String expectedOutput, String expectedError, Runnable task) {
        assertConsolePrint(input, expectedOutput, expectedError, task, true);
        assertConsolePrint(input, expectedOutput, expectedError, task, false);
    }

    /**
     * Asserts console output and error output for a given task, with an option to merge streams.
     *
     * <p>This method sets up input and output streams, runs the provided {@code task},
     * and compares its output with expected values. It supports two modes of stream checking:
     * merged (both {@code System.out} and {@code System.err} go to the same stream)
     * or separated (outputs are verified individually).</p>
     *
     * @param input          the simulated input to feed into {@code System.in}
     * @param expectedOutput the expected standard output
     * @param expectedError  the expected error output
     * @param task           the task to be executed
     * @param mergeStreams   if {@code true}, merges output and error streams for combined checking;
     *                       otherwise checks them separately
     */
    private static void assertConsolePrint(String input, String expectedOutput, String expectedError, Runnable task, boolean mergeStreams) {
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;
        PrintStream originalErr = System.err;

        try {
            ByteArrayInputStream testIn = new ByteArrayInputStream(input.getBytes());
            System.setIn(testIn);

            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            ByteArrayOutputStream errStream;

            if (mergeStreams) {
                errStream = outStream;
            } else {
                errStream = new ByteArrayOutputStream();
            }

            PrintStream newOutStream = new PrintStream(outStream);
            PrintStream newErrStream = new PrintStream(errStream);

            System.setOut(newOutStream);
            System.setErr(newErrStream);

            task.run();

            if (mergeStreams) {
                String expectedCombined = expectedOutput + expectedError;
                String actualCombined = outStream.toString();

                assertEquals(expectedCombined, actualCombined, "Unexpected full output.");
            } else {
                assertEquals(expectedOutput, outStream.toString(), "Unexpected output.");
                assertEquals(expectedError, errStream.toString(), "Unexpected error output.");
            }

        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
            System.setErr(originalErr);
        }
    }


}
