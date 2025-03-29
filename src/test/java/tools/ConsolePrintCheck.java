package tools;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsolePrintCheck {
    /**
     * Asserts that the output printed to the console by a given task matches the expected output.
     *
     * <p>This method temporarily redirects the standard input and output streams to simulate user input
     * and capture console output. It runs the specified {@code task}, captures what it prints to the console,
     * and compares it to the expected output. After execution, it restores the original input and output streams.</p>
     *
     * @param input the simulated user input to provide to {@code System.in}
     * @param expectedOutput the expected console output produced by the task
     * @param task the {@link Runnable} task that performs console I/O
     * @throws AssertionError if the actual console output does not match the expected output
     */
    public static void assertValidConsolePrint(String input, String expectedOutput, Runnable task){
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;

        try {
            ByteArrayInputStream testIn = new ByteArrayInputStream(input.getBytes());
            System.setIn(testIn);

            ByteArrayOutputStream testOut = new ByteArrayOutputStream();
            System.setOut(new PrintStream(testOut));

            task.run();

            String actualOutput = testOut.toString();

            assertEquals(expectedOutput, actualOutput);
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }
    }
}
