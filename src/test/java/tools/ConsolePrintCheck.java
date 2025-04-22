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
     * Tests the console output of a given task by providing an input string and comparing the standard output and error output
     * against the expected values. The method captures both merged and separated outputs to ensure they match the expected results.
     * The original system input, output, and error streams are restored after execution.
     *
     * @param input          the input string to be provided to the task via System.in
     * @param expectedOutput the expected standard output from the task
     * @param expectedError  the expected error output from the task
     * @param task           the Runnable task to be executed
     */
    public static void assertConsolePrint(String input, String expectedOutput, String expectedError,
                                          String expectedFullOutput, Runnable task) {
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;
        PrintStream originalErr = System.err;

        try {
            setInput(input);
            assertMergedOutput(expectedFullOutput, task, originalOut, originalErr);

            setInput(input);
            assertSeparatedOutput(expectedOutput, expectedError, task, originalOut, originalErr);

        } finally {
            System.setIn(originalIn);
        }
    }

    /**
     * Sets the system input stream to a ByteArrayInputStream containing the provided input string.
     *
     * @param input the input string to set as the system input
     */
    private static void setInput(String input) {
        ByteArrayInputStream testInput = new ByteArrayInputStream(input.getBytes());
        System.setIn(testInput);
    }

    /**
     * Asserts that the merged standard output and error output of a task matches the concatenated expected output and error strings.
     *
     * @param expectedFullOutput the expected full output
     * @param task           the Runnable task to be executed
     * @param originalOut    the original System.out PrintStream
     * @param originalErr    the original System.err PrintStream
     */
    private static void assertMergedOutput(String expectedFullOutput, Runnable task, PrintStream originalOut,
                                           PrintStream originalErr) {
        ByteArrayOutputStream combinedStream = new ByteArrayOutputStream();

        runWithRedirectedStreams(task, combinedStream, combinedStream, originalOut, originalErr);

        String actualOutput = combinedStream.toString();

        assertEquals(expectedFullOutput, actualOutput, "Unexpected full output.");
    }

    /**
     * Asserts that the standard output and error output of a task match the expected output and error strings separately.
     *
     * @param expectedOutput the expected standard output
     * @param expectedError  the expected error output
     * @param task           the Runnable task to be executed
     * @param originalOut    the original System.out PrintStream
     * @param originalErr    the original System.err PrintStream
     */
    private static void assertSeparatedOutput(String expectedOutput, String expectedError, Runnable task,
                                              PrintStream originalOut, PrintStream originalErr) {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        ByteArrayOutputStream errStream = new ByteArrayOutputStream();

        runWithRedirectedStreams(task, outStream, errStream, originalOut, originalErr);

        String actualOutput = outStream.toString();
        String actualError = errStream.toString();

        assertEquals(expectedOutput, actualOutput, "Unexpected standard output.");
        assertEquals(expectedError, actualError, "Unexpected error output.");
    }

    /**
     * Executes a task with redirected output and error streams, restoring the original streams after execution.
     *
     * @param task        the Runnable task to be executed
     * @param outStream   the OutputStream to redirect System.out to
     * @param errStream   the OutputStream to redirect System.err to
     * @param originalOut the original System.out PrintStream
     * @param originalErr the original System.err PrintStream
     */
    private static void runWithRedirectedStreams(Runnable task, OutputStream outStream, OutputStream errStream,
                                                 PrintStream originalOut, PrintStream originalErr) {
        try {
            System.setOut(new PrintStream(outStream));
            System.setErr(new PrintStream(errStream));

            task.run();

        } finally {
            System.setOut(originalOut);
            System.setErr(originalErr);
        }
    }
}