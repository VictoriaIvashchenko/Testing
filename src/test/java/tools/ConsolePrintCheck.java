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
     * @param input           the input string to be provided to the task via System.in
     * @param expectedOutput  the expected standard output from the task
     * @param expectedError   the expected error output from the task
     * @param task            the Runnable task to be executed
     */
    public static void assertConsolePrint(String input, String expectedOutput, String expectedError, Runnable task) {
        String expectedFullOutput = expectedOutput + expectedError;

        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;
        PrintStream originalErr = System.err;

        try {
            ByteArrayInputStream testIn = new ByteArrayInputStream(input.getBytes());
            System.setIn(testIn);

            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            ByteArrayOutputStream errStream = new ByteArrayOutputStream();
            ByteArrayOutputStream combinedStream = new ByteArrayOutputStream();

            PrintStream outPrintStream = new PrintStream(outStream) {
                @Override
                public void write(byte[] buf, int off, int len) {
                    super.write(buf, off, len);
                    combinedStream.write(buf, off, len);
                }
            };
            PrintStream errPrintStream = new PrintStream(errStream) {
                @Override
                public void write(byte[] buf, int off, int len) {
                    super.write(buf, off, len);
                    combinedStream.write(buf, off, len);
                }
            };

            System.setOut(outPrintStream);
            System.setErr(errPrintStream);

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
}