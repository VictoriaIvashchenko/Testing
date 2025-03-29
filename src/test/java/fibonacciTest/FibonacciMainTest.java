package fibonacciTest;

import exceptions.InvalidInputException;
import org.junit.jupiter.api.Test;
import fibonacci.FibonacciMain;

import static java.lang.String.format;
import static java.lang.String.valueOf;
import static tools.ConsolePrintCheck.assertValidConsolePrint;
import static tools.ExceptionMessagesTest.INVALID_TYPE_INPUT_FIBONACCI_TEST;
import static tools.ExceptionMessagesTest.INVALID_VALUE_INPUT_FIBONACCI_TEST;

public class FibonacciMainTest extends FibonacciTest {

    String SEPARATOR = System.lineSeparator();

    @Test
    void overRangeInputTest(){
        assertInvalidTypeArguments("21475483648");
        assertInvalidTypeArguments("21475483649");
        assertInvalidTypeArguments("21475483650");
        assertInvalidTypeArguments("21475483651");
        assertInvalidTypeArguments("21475483652");

        assertInvalidTypeArguments("-21475483649");
        assertInvalidTypeArguments("-21475483650");
        assertInvalidTypeArguments("-21475483651");
        assertInvalidTypeArguments("-21475483652");
        assertInvalidTypeArguments("-21475483653");
    }

    @Test
    void invalidArgumentsType(){
        assertInvalidTypeArguments("a");
        assertInvalidTypeArguments("z");
        assertInvalidTypeArguments("y");
        assertInvalidTypeArguments("b");

        assertInvalidTypeArguments("A");
        assertInvalidTypeArguments("Z");
        assertInvalidTypeArguments("B");
        assertInvalidTypeArguments("Y");

        assertInvalidTypeArguments("!");
        assertInvalidTypeArguments("@");
        assertInvalidTypeArguments("#$");

        assertInvalidTypeArguments("#424543");
        assertInvalidTypeArguments("#111111");
        assertInvalidTypeArguments("#446564");

        assertInvalidTypeArguments("12.");
        assertInvalidTypeArguments("9856.23");
        assertInvalidTypeArguments("0.45");
        assertInvalidTypeArguments(".0546");
        assertInvalidTypeArguments("0.0");

        assertInvalidTypeArguments("1 2");
        assertInvalidTypeArguments("0 2");
        assertInvalidTypeArguments("1.5 2");
        assertInvalidTypeArguments("a 2");
        assertInvalidTypeArguments("D 2");
        assertInvalidTypeArguments("! 2");
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
     * @param expected the expected Fibonacci number as a string
     */
    @Override
    public void assertFibonacciEquals(int actualIndex, String expected){
        String input = valueOf(actualIndex);

        String expectedOutput = format("Task 4. Enter index of number in fibonacci sequence:" + SEPARATOR +
                "F(%d) = %s", actualIndex, expected);

        assertValidConsolePrint(input, expectedOutput, ()->FibonacciMain.main(new String[]{}));
    }

    /**
     * Asserts that the {@code fibonacci} method throws an {@link InvalidInputException} for an invalid index.
     *
     * <p>This method simulates console input for an invalid Fibonacci index and verifies that the correct exception
     * message is printed. It ensures that an error message for an invalid index is shown as expected.</p>
     *
     * @param index the index to test, which should cause an exception to be thrown in the Fibonacci calculation
     */
    @Override
    public void assertThrowsInvalidInputException(int index){
        String expectedOutput = format("Task 4. Enter index of number in fibonacci sequence:" + SEPARATOR +
                INVALID_VALUE_INPUT_FIBONACCI_TEST.getTestMessage(), index);
        assertValidConsolePrint(valueOf(index), expectedOutput, ()->FibonacciMain.main(new String[]{}));
    }
    /**
     * Asserts that an invalid type argument for the Fibonacci index is handled correctly by the {@code FibonacciMain.main()} method.
     *
     * <p>This method simulates console input for an invalid type (non-numeric) and verifies that the expected error message is printed,
     * indicating that the input is not a valid Fibonacci index.</p>
     *
     * @param input the invalid input to test (non-numeric or invalid format for a Fibonacci index)
     */
    public void assertInvalidTypeArguments(String input){
        String expectedOutput = format("Task 4. Enter index of number in fibonacci sequence:" + SEPARATOR +
                INVALID_TYPE_INPUT_FIBONACCI_TEST.getTestMessage(), "n", input);
        assertValidConsolePrint(input, expectedOutput, ()->FibonacciMain.main(new String[]{}));
    }

}
