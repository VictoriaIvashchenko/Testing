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
     * Tests the console output of a given task by providing an input string and comparing the standard output, error output,
     * and combined output against the expected values. The method captures both standard and error outputs separately while
     * also maintaining a combined output stream to verify the concatenated result. The original system input, output, and error
     * streams are restored after execution.
     *
     * @param input          the input string to be provided to the task via System.in
     * @param expectedOutput the expected standard output from the task
     * @param expectedError  the expected error output from the task
     * @param task           the Runnable task to be executed
     */
    public static void assertConsolePrint(String input, String expectedOutput, String expectedError, String expectedFullOutput,
                                          Runnable task) {
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;
        PrintStream originalErr = System.err;

        try {
            ByteArrayInputStream testIn = new ByteArrayInputStream(input.getBytes());
            System.setIn(testIn);

            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            ByteArrayOutputStream errStream = new ByteArrayOutputStream();
            ByteArrayOutputStream combinedStream = new ByteArrayOutputStream();

            PrintStream newOutputStream = wrapWithCombinedStream(outStream, combinedStream);
            PrintStream newErrorStream = wrapWithCombinedStream(errStream, combinedStream);

            System.setOut(newOutputStream);
            System.setErr(newErrorStream);

            task.run();

            String actualOut = outStream.toString();
            String actualErr = errStream.toString();
            String actualCombined = combinedStream.toString();

            assertEquals(expectedOutput, actualOut, "Unexpected stdout output.");
            assertEquals(expectedError, actualErr, "Unexpected stderr output.");
            assertEquals(expectedFullOutput, actualCombined, "Unexpected combined output.");

        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
            System.setErr(originalErr);
        }
    }

    /**
     * Wraps a given {@link ByteArrayOutputStream} in a {@link PrintStream} that also writes
     * all output to a second combined {@link ByteArrayOutputStream}.
     *
     * <p>This is useful for testing or logging purposes when you want to capture output
     * to both a specific stream (e.g., standard output or error) and a shared combined stream
     * for unified analysis or verification.</p>
     *
     * <p>The returned {@code PrintStream} overrides the {@code write(byte[], int, int)} method
     * to duplicate the output into the combined stream alongside the original target stream.</p>
     *
     * @param stream   the original output stream that the {@code PrintStream} will write to
     * @param combined the additional output stream to which all data will also be copied
     * @return a {@code PrintStream} that writes to both the provided streams
     */
    private static PrintStream wrapWithCombinedStream(ByteArrayOutputStream stream, ByteArrayOutputStream combined) {
        return new PrintStream(stream) {
            @Override
            public void write(byte[] buf, int off, int len) {
                super.write(buf, off, len);
                combined.write(buf, off, len);
            }
        };
    }
}