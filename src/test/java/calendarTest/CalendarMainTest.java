package calendarTest;

import org.junit.jupiter.api.Test;
import calendar.CalendarMain;

import java.time.Month;

import static java.lang.String.format;
import static tools.ConsolePrintCheck.assertValidConsolePrint;
import static tools.ExceptionMessagesTest.*;

/**
 * Unit test class for {@link CalendarMain}.
 *
 * <p>This class extends {@link CalendarTest} and provides specific test configurations
 * for verifying the behavior of the {@link CalendarMain} program. It sets up the main method
 * for execution during tests and defines a system-dependent line separator.</p>
 *
 */
public class CalendarMainTest extends CalendarTest {
    /** System-dependent line separator used for formatting expected test output. */
    final static String SEPARATOR = System.lineSeparator();
    /**
     * A {@link Runnable} reference to the {@code main} method of {@link CalendarMain}.
     *
     * <p>This runnable executes {@link CalendarMain#main(String[])} with an empty argument array,
     * allowing test cases to simulate program execution.</p>
     */
    final static Runnable MAIN_METHOD = () -> CalendarMain.main(new String[]{});

    @Test
    void overRangeInputTest(){
        //(MAX, MIN, MAX)
        assertInvalidNewYearInput("2147483648", "-2147483648", "2147483647");//(MAX + 1, MIN, MAX)
        assertInvalidNewYearInput("2147483648", "-2147483648", "2147483648");//(MAX + 1, MIN, MAX + 1)
        assertInvalidNewYearInput("2147483648", "-2147483648", "2147483646");//(MAX + 1, MIN, MAX - 1)
        assertInvalidNewYearInput("2147483648", "-2147483649", "2147483647");//(MAX + 1, MIN - 1, MAX)
        assertInvalidNewYearInput("2147483648", "-2147483649", "2147483648");//(MAX + 1, MIN - 1, MAX + 1)
        assertInvalidNewYearInput("2147483648", "-2147483647", "2147483648");//(MAX + 1, MIN + 1, MAX + 1)
        assertInvalidNewYearInput("2147483648", "-2147483647", "2147483646");//(MAX + 1, MIN + 1, MAX - 1)
        assertInvalidNewYearInput("2147483648", "-2147483649", "2147483646");//(MAX + 1, MIN - 1, MAX - 1)
        assertInvalidNewYearInput("2147483648", "-2147483647", "2147483647");//(MAX + 1, MIN - 1, MAX)
        assertInvalidDayInput("2147483647", "-2147483649", "2147483647");//(MAX, MIN - 1, MAX)
        assertInvalidDayInput("2147483647", "-2147483649", "2147483648");//(MAX, MIN - 1, MAX + 1)
        assertInvalidDayInput("2147483647", "-2147483649", "2147483646");//(MAX, MIN - 1, MAX - 1)
        assertInvalidDayInput("2147483646", "-2147483649", "2147483647");//(MAX - 1, MIN - 1, MAX)
        assertInvalidDayInput("2147483646", "-2147483649", "2147483648");//(MAX - 1, MIN - 1, MAX + 1)
        assertInvalidDayInput("2147483646", "-2147483649", "2147483646");//(MAX - 1, MIN - 1, MAX - 1)
        assertThrowsIllegalMonth("2147483646", "-2147483647", "2147483648");//(MAX - 1, MIN + 1, MAX + 1)
        assertThrowsIllegalMonth("2147483646", "-2147483648", "2147483648");//(MAX - 1, MIN, MAX + 1)
        assertThrowsIllegalMonth("2147483647", "-2147483647", "2147483648");//(MAX, MIN + 1, MAX + 1)
        assertThrowsIllegalMonth("2147483647", "-2147483648", "2147483648");//(MAX, MIN, MAX + 1)
        //(MAX, MIN, MIN)
        assertInvalidNewYearInput("2147483648", "-2147483648", "-2147483648");//(MAX + 1, MIN, MIN)
        assertInvalidNewYearInput("2147483648", "-2147483648", "-2147483649");//(MAX + 1, MIN, MIN - 1)
        assertInvalidNewYearInput("2147483648", "-2147483648", "-2147483647");//(MAX + 1, MIN, MIN + 1)
        assertInvalidNewYearInput("2147483648", "-2147483649", "-2147483648");//(MAX + 1, MIN - 1, MIN)
        assertInvalidNewYearInput("2147483648", "-2147483649", "-2147483649");//(MAX + 1, MIN - 1, MIN - 1)
        assertInvalidNewYearInput("2147483648", "-2147483649", "-2147483647");//(MAX + 1, MIN - 1, MIN + 1)
        assertInvalidNewYearInput("2147483648", "-2147483647", "-2147483648");//(MAX + 1, MIN + 1, MIN)
        assertInvalidNewYearInput("2147483648", "-2147483647", "-2147483649");//(MAX + 1, MIN + 1, MIN - 1)
        assertInvalidNewYearInput("2147483648", "-2147483647", "-2147483647");//(MAX + 1, MIN + 1, MIN + 1)
        assertInvalidDayInput("2147483646", "-2147483649", "-2147483648");//(MAX - 1, MIN - 1, MIN)
        assertInvalidDayInput("2147483646", "-2147483649", "-2147483649");//(MAX - 1, MIN - 1, MIN - 1)
        assertInvalidDayInput("2147483646", "-2147483649", "-2147483647");//(MAX - 1, MIN - 1, MIN + 1)
        assertInvalidDayInput("2147483647", "-2147483649", "-2147483648");//(MAX, MIN - 1, MIN)
        assertInvalidDayInput("2147483647", "-2147483649", "-2147483649");//(MAX, MIN - 1, MIN - 1)
        assertThrowsIllegalMonth("2147483647", "-2147483647", "-2147483649");//(MAX, MIN + 1, MIN - 1)
        assertThrowsIllegalMonth("2147483646", "-2147483647", "-2147483649");//(MAX - 1, MIN + 1, MIN - 1)
        assertThrowsIllegalMonth("2147483646", "-2147483648", "-2147483649");//(MAX - 1, MIN, MIN - 1)
        assertThrowsIllegalMonth("2147483647", "-2147483648", "-2147483649");//(MAX, MIN, MIN - 1)
        assertThrowsIllegalMonth("2147483647", "-2147483648", "-2147483649");//(MAX, MIN, MIN - 1)
        //(MAX, MAX, MIN)
        assertInvalidNewYearInput("2147483648", "2147483647", "-2147483648");//(MAX + 1, MAX, MIN)
        assertInvalidNewYearInput("2147483648", "2147483647", "-2147483649");//(MAX + 1, MAX, MIN - 1)
        assertInvalidNewYearInput("2147483648", "2147483647", "-2147483647");//(MAX + 1, MAX, MIN + 1)
        assertInvalidNewYearInput("2147483648", "2147483648", "-2147483648");//(MAX + 1, MAX + 1, MIN)
        assertInvalidNewYearInput("2147483648", "2147483648", "-2147483649");//(MAX + 1, MAX + 1, MIN - 1)
        assertInvalidNewYearInput("2147483648", "2147483648", "-2147483647");//(MAX + 1, MAX + 1, MIN + 1)
        assertInvalidNewYearInput("2147483648", "2147483646", "-2147483648");//(MAX + 1, MAX - 1, MIN)
        assertInvalidNewYearInput("2147483648", "2147483646", "-2147483649");//(MAX + 1, MAX - 1, MIN - 1)
        assertInvalidNewYearInput("2147483648", "2147483646", "-2147483647");//(MAX + 1, MAX - 1,  + 1)
        assertInvalidDayInput("2147483647", "2147483648", "-2147483648");//(MAX, MAX + 1, MIN)
        assertInvalidDayInput("2147483647", "2147483648", "-2147483649");//(MAX, MAX + 1, MIN - 1)
        assertInvalidDayInput("2147483647", "2147483648", "-2147483647");//(MAX, MAX + 1, MIN + 1)
        assertInvalidDayInput("2147483646", "2147483648", "-2147483648");//(MAX - 1, MAX + 1, MIN)
        assertInvalidDayInput("2147483646", "2147483648", "-2147483649");//(MAX - 1, MAX + 1, MIN - 1)
        assertInvalidDayInput("2147483646", "2147483648", "-2147483647");//(MAX - 1, MAX + 1, MIN + 1)
        assertThrowsIllegalMonth("2147483647", "2147483646", "-2147483649");//(MAX, MAX - 1, MIN - 1)
        assertThrowsIllegalMonth("2147483647", "2147483647", "-2147483649");//(MAX, MAX, MIN - 1)
        assertThrowsIllegalMonth("2147483646", "2147483647", "-2147483649");//(MAX - 1, MAX, MIN - 1)
        assertThrowsIllegalMonth("2147483646", "2147483646", "-2147483649");//(MAX - 1, MAX - 1, MIN - 1)
        //(MAX, MAX, MAX)
        assertInvalidNewYearInput("2147483648", "2147483647", "2147483647");//(MAX + 1, MAX, MAX)
        assertInvalidNewYearInput("2147483648", "2147483647", "2147483648");//(MAX + 1, MAX, MAX + 1)
        assertInvalidNewYearInput("2147483648", "2147483647", "2147483646");//(MAX + 1, MAX, MAX - 1)
        assertInvalidNewYearInput("2147483648", "2147483648", "2147483647");//(MAX + 1, MAX + 1, MAX)
        assertInvalidNewYearInput("2147483648", "2147483648", "2147483648");//(MAX + 1, MAX + 1, MAX + 1)
        assertInvalidNewYearInput("2147483648", "2147483648", "2147483646");//(MAX + 1, MAX + 1, MAX - )
        assertInvalidNewYearInput("2147483648", "2147483646", "2147483647");//(MAX + 1, MAX - 1, MAX)
        assertInvalidNewYearInput("2147483648", "2147483646", "2147483648");//(MAX + 1, MAX - 1, MAX + 1)
        assertInvalidNewYearInput("2147483648", "2147483646", "2147483646");//(MAX + 1, MAX - 1, MAX - 1)
        assertInvalidDayInput("2147483646", "2147483648", "2147483647");//(MAX - 1, MAX + 1, MAX)
        assertInvalidDayInput("2147483646", "2147483648", "2147483648");//(MAX - 1, MAX + 1, MAX + 1)
        assertInvalidDayInput("2147483646", "2147483648", "2147483646");//(MAX - 1, MAX + 1, MAX - 1)
        assertInvalidDayInput("2147483647", "2147483648", "2147483647");//(MAX, MAX + 1, MAX)
        assertInvalidDayInput("2147483647", "2147483648", "2147483648");//(MAX, MAX + 1, MAX + 1)
        assertInvalidDayInput("2147483647", "2147483648", "2147483646");//(MAX, MAX + 1, MAX - 1)
        assertThrowsIllegalMonth("2147483647", "2147483646", "2147483648");//(MAX, MAX - 1, MAX + 1)
        assertThrowsIllegalMonth("2147483647", "2147483647", "2147483648");//(MAX, MAX, MAX + 1)
        assertThrowsIllegalMonth("2147483646", "2147483647", "2147483648");//(MAX - 1, MAX, MAX + 1)
        assertThrowsIllegalMonth("2147483646", "2147483646", "2147483648");//(MAX - 1, MAX - 1, MAX + 1)
        //(MIN, MAX, MIN)
        assertInvalidNewYearInput("-2147483649", "2147483647", "-2147483648");//(MIN - 1, MAX, MIN)
        assertInvalidNewYearInput("-2147483649", "2147483647", "-2147483649");//(MIN - 1, MAX, MIN - 1)
        assertInvalidNewYearInput("-2147483649", "2147483647", "-2147483647");//(MIN - 1, MAX, MIN + 1)
        assertInvalidNewYearInput("-2147483649", "2147483648", "-2147483648");//(MIN - 1, MAX + 1, MIN)
        assertInvalidNewYearInput("-2147483649", "2147483648", "-2147483649");//(MIN - 1, MAX + 1, MIN - 1)
        assertInvalidNewYearInput("-2147483649", "2147483648", "-2147483647");//(MIN - 1, MAX + 1, MIN + 1)
        assertInvalidNewYearInput("-2147483649", "2147483646", "-2147483648");//(MIN - 1, MAX - 1, MIN)
        assertInvalidNewYearInput("-2147483649", "2147483646", "-2147483649");//(MIN - 1, MAX - 1, MIN - 1)
        assertInvalidNewYearInput("-2147483649", "2147483646", "-2147483647");//(MIN - 1, MAX - 1, MIN + 1)
        assertInvalidDayInput("-2147483647", "2147483648", "-2147483648");//(MIN + 1, MAX + 1, MIN)
        assertInvalidDayInput("-2147483647", "2147483648", "-2147483649");//(MIN + 1, MAX + 1, MIN - 1)
        assertInvalidDayInput("-2147483647", "2147483648", "-2147483647");//(MIN + 1, MAX + 1, MIN + 1)
        assertInvalidDayInput("-2147483648", "2147483648", "-2147483648");//(MIN, MAX + 1, MIN)
        assertInvalidDayInput("-2147483648", "2147483648", "-2147483649");//(MIN, MAX + 1, MIN - 1)
        assertInvalidDayInput("-2147483648", "2147483648", "-2147483647");//(MIN, MAX + 1, MIN + 1)
        assertThrowsIllegalMonth("-2147483648", "2147483646", "-2147483649");//(MIN, MAX - 1, MIN - 1)
        assertThrowsIllegalMonth("-2147483648", "2147483647", "-2147483649");//(MIN, MAX, MIN - 1)
        assertThrowsIllegalMonth("-2147483647", "2147483647", "-2147483649");//(MIN + 1, MAX, MIN - 1)
        assertThrowsIllegalMonth("-2147483647", "2147483646", "-2147483649");//(MIN + 1, MAX - 1, MIN - 1)
        //(MIN, MAX, MAX)
        assertInvalidNewYearInput("-2147483649", "2147483647", "2147483647");//(MIN - 1, MAX, MAX)
        assertInvalidNewYearInput("-2147483649", "2147483647", "2147483648");//(MIN - 1, MAX, MAX + 1)
        assertInvalidNewYearInput("-2147483649", "2147483647", "2147483646");//(MIN - 1, MAX, MAX - 1)
        assertInvalidNewYearInput("-2147483649", "2147483648", "2147483647");//(MIN - 1, MAX + 1, MAX)
        assertInvalidNewYearInput("-2147483649", "2147483648", "2147483648");//(MIN - 1, MAX + 1, MAX + 1)
        assertInvalidNewYearInput("-2147483649", "2147483648", "2147483646");//(MIN - 1, MAX + 1, MAX - 1)
        assertInvalidNewYearInput("-2147483649", "2147483646", "2147483647");//(MIN - 1, MAX - 1, MAX)
        assertInvalidNewYearInput("-2147483649", "2147483646", "2147483648");//(MIN - 1, MAX - 1, MAX + 1)
        assertInvalidNewYearInput("-2147483649", "2147483646", "2147483646");//(MIN - 1, MAX - 1, MAX - 1)
        assertInvalidDayInput("-2147483648", "2147483648", "2147483647");//(MIN, MAX + 1, MAX)
        assertInvalidDayInput("-2147483648", "2147483648", "2147483648");//(MIN, MAX + 1, MAX + 1)
        assertInvalidDayInput("-2147483648", "2147483648", "2147483646");//(MIN, MAX + 1, MAX - 1)
        assertInvalidDayInput("-2147483647", "2147483648", "2147483647");//(MIN + 1, MAX + 1, MAX)
        assertInvalidDayInput("-2147483647", "2147483648", "2147483648");//(MIN + 1, MAX + 1, MAX + 1)
        assertInvalidDayInput("-2147483647", "2147483648", "2147483646");//(MIN + 1, MAX + 1, MAX - 1)
        assertThrowsIllegalMonth("-2147483648", "2147483647", "2147483648");//(MIN, MAX, MAX + 1)
        assertThrowsIllegalMonth("-2147483648", "2147483646", "2147483648");//(MIN, MAX - 1, MAX + 1)
        assertThrowsIllegalMonth("-2147483647", "2147483647", "2147483648");//(MIN + 1, MAX, MAX + 1)
        assertThrowsIllegalMonth("-2147483647", "2147483646", "2147483648");//(MIN + 1, MAX - 1, MAX + 1)
        //(MIN, MIN, MAX)
        assertInvalidNewYearInput("-2147483649", "-2147483648", "2147483647");//(MIN - 1, MIN, MAX)
        assertInvalidNewYearInput("-2147483649", "-2147483648", "2147483648");//(MIN - 1, MIN, MAX + 1)
        assertInvalidNewYearInput("-2147483649", "-2147483648", "2147483646");//(MIN - 1, MIN, MAX - 1)
        assertInvalidNewYearInput("-2147483649", "-2147483649", "2147483647");//(MIN - 1, MIN - 1, MAX)
        assertInvalidNewYearInput("-2147483649", "-2147483649", "2147483648");//(MIN - 1, MIN - 1, MAX + 1)
        assertInvalidNewYearInput("-2147483649", "-2147483649", "2147483646");//(MIN - 1, MIN - 1, MAX - 1)
        assertInvalidNewYearInput("-2147483649", "-2147483647", "2147483647");//(MIN - 1, MIN + 1, MAX)
        assertInvalidNewYearInput("-2147483649", "-2147483647", "2147483648");//(MIN - 1, MIN + 1, MAX + 1)
        assertInvalidNewYearInput("-2147483649", "-2147483647", "2147483646");//(MIN - 1, MIN + 1, MAX - 1)
        assertInvalidDayInput("-2147483648", "-2147483649", "2147483647");//(MIN, MIN - 1, MAX)
        assertInvalidDayInput("-2147483648", "-2147483649", "2147483648");//(MIN, MIN - 1, MAX + 1)
        assertInvalidDayInput("-2147483648", "-2147483649", "2147483646");//(MIN, MIN - 1, MAX - 1)
        assertInvalidDayInput("-2147483647", "-2147483649", "2147483647");//(MIN + 1, MIN - 1, MAX)
        assertInvalidDayInput("-2147483647", "-2147483649", "2147483648");//(MIN + 1, MIN - 1, MAX + 1)
        assertInvalidDayInput("-2147483647", "-2147483649", "2147483646");//(MIN + 1, MIN - 1, MAX - 1)
        assertThrowsIllegalMonth("-2147483647", "-2147483647", "2147483648");//(MIN + 1, MIN + 1, MAX + 1)
        assertThrowsIllegalMonth("-2147483648", "-2147483647", "2147483648");//(MIN, MIN + 1, MAX + 1)
        assertThrowsIllegalMonth("-2147483648", "-2147483648", "2147483648");//(MIN, MIN, MAX + 1)
        assertThrowsIllegalMonth("-2147483647", "-2147483648", "2147483648");//(MIN + 1, MIN, MAX + 1)
        //(MIN, MIN, MIN)
        assertInvalidNewYearInput("-2147483649", "-2147483648", "-2147483648");//(MIN - 1, MIN, MIN)
        assertInvalidNewYearInput("-2147483649", "-2147483648", "-2147483649");//(MIN - 1, MIN, MIN - 1)
        assertInvalidNewYearInput("-2147483649", "-2147483648", "-2147483647");//(MIN - 1, MIN, MIN + 1)
        assertInvalidNewYearInput("-2147483649", "-2147483649", "-2147483648");//(MIN - 1, MIN - 1, MIN)
        assertInvalidNewYearInput("-2147483649", "-2147483649", "-2147483649");//(MIN - 1, MIN - 1, MIN - 1)
        assertInvalidNewYearInput("-2147483649", "-2147483649", "-2147483647");//(MIN - 1, MIN - 1, MIN + 1)
        assertInvalidNewYearInput("-2147483649", "-2147483647", "-2147483648");//(MIN - 1, MIN + 1, MIN)
        assertInvalidNewYearInput("-2147483649", "-2147483647", "-2147483649");//(MIN - 1, MIN + 1, MIN - 1)
        assertInvalidNewYearInput("-2147483649", "-2147483647", "-2147483647");//(MIN - 1, MIN + 1, MIN + 1)
        assertInvalidDayInput("-2147483647", "-2147483649", "-2147483648");//(MIN + 1, MIN - 1, MIN)
        assertInvalidDayInput("-2147483647", "-2147483649", "-2147483649");//(MIN + 1, MIN - 1, MIN - 1)
        assertInvalidDayInput("-2147483647", "-2147483649", "-2147483647");//(MIN + 1, MIN - 1, MIN + 1)
        assertInvalidDayInput("-2147483648", "-2147483649", "-2147483648");//(MIN, MIN - 1, MIN)
        assertInvalidDayInput("-2147483648", "-2147483649", "-2147483649");//(MIN, MIN - 1, MIN - 1)
        assertInvalidDayInput("-2147483648", "-2147483649", "-2147483647");//(MIN, MIN - 1, MIN + 1)
        assertThrowsIllegalMonth("-2147483647", "-2147483647", "-2147483649");//(MIN + 1, MIN + 1, MIN - 1)
        assertThrowsIllegalMonth("-2147483648", "-2147483648", "-2147483649");//(MIN, MIN, MIN - 1)
        assertThrowsIllegalMonth("-2147483648", "-2147483647", "-2147483649");//(MIN, MIN + 1, MIN - 1)
        assertThrowsIllegalMonth("-2147483647", "-2147483648", "-2147483649");//(MIN + 1, MIN, MIN - 1)

    }

    @Test
    void invalidTypeDayOfNewYearTest(){
        assertInvalidNewYearInput("a", "1", "a");
        assertInvalidNewYearInput("z", "z", "z");

        assertInvalidNewYearInput("A", "A", "A");
        assertInvalidNewYearInput("Z", "Z", "Z");

        assertInvalidNewYearInput("a", "1", "1");
        assertInvalidNewYearInput("z", "1", "1");

        assertInvalidNewYearInput("a", "a", "1");
        assertInvalidNewYearInput("a", "1", "a");

        assertInvalidNewYearInput("!", "!", "!");
        assertInvalidNewYearInput("?", "#", "$");
        assertInvalidNewYearInput("@", "@", "@");

        assertInvalidNewYearInput("!", "1", "45");
        assertInvalidNewYearInput("%^", "56", "88");
        assertInvalidNewYearInput("@", "985", "89");

        assertInvalidNewYearInput("#889232", "#364977", "#259689");
        assertInvalidNewYearInput("#112233", "#562111", "#136569");
        assertInvalidNewYearInput("#449796", "#562236", "#566846");

        assertInvalidNewYearInput("#862669", "1", "45");
        assertInvalidNewYearInput("#566224", "56", "88");
        assertInvalidNewYearInput("#466256", "985", "89");

        assertInvalidNewYearInput("M0nday", "89", "71");
        assertInvalidNewYearInput("Sun day", "89", "71");
        assertInvalidNewYearInput("3% 1", "89", "71");
        assertInvalidNewYearInput("#111111 Apr", "89", "71");
        assertInvalidNewYearInput("18.23 Jan", "89", "71");
    }

    @Test
    void invalidDayTypeTest(){
        assertInvalidDayInput("1", "a", "a");
        assertInvalidDayInput("1", "z", "z");

        assertInvalidDayInput("1", "A", "A");
        assertInvalidDayInput("1", "Z", "Z");

        assertInvalidDayInput("1", "a", "26");
        assertInvalidDayInput("1", "z", "68");

        assertInvalidDayInput("1", "D", "123");
        assertInvalidDayInput("1", "Z", "895");

        assertInvalidDayInput("1", "!", "!");
        assertInvalidDayInput("1", "#", "$");
        assertInvalidDayInput("1", "@", "@");

        assertInvalidDayInput("1", "!", "45");
        assertInvalidDayInput("1", "?", "88");
        assertInvalidDayInput("1", "@", "89");

        assertInvalidDayInput("1", "#364977", "#259689");
        assertInvalidDayInput("1", "#562111", "#136569");
        assertInvalidDayInput("1", "#562236", "#566846");

        assertInvalidDayInput("1", "#862669", "45");
        assertInvalidDayInput("1", "#566224", "88");
        assertInvalidDayInput("1", "#466256", "89");

        assertInvalidDayInput("1", "1 1", "71");
        assertInvalidDayInput("1", "e 1", "71");
        assertInvalidDayInput("1", "$ 1", "71");
        assertInvalidDayInput("1", "#111111 1", "71");
        assertInvalidDayInput("1", "18.23 1", "71");

    }

    @Test
    void invalidMonthTypeTest(){
        assertThrowsIllegalMonth("1", "1", "a");
        assertThrowsIllegalMonth("1", "8", "z");

        assertThrowsIllegalMonth("1", "1", "!");
        assertThrowsIllegalMonth("1", "3", "$");
        assertThrowsIllegalMonth("1", "4", "@");

        assertThrowsIllegalMonth("1", "4", "#259689");
        assertThrowsIllegalMonth("1", "5", "#136569");
        assertThrowsIllegalMonth("1", "5", "#566846");

        assertThrowsIllegalMonth("1", "1", "1 1");
        assertThrowsIllegalMonth("1", "2", "e 1");
        assertThrowsIllegalMonth("1", "4", "$ 1");
        assertThrowsIllegalMonth("1", "5", "#111111 1");
        assertThrowsIllegalMonth("1", "6", "18.23 1");
    }

    /**
     * Asserts that the method {@link calendar} produces the correct output when given valid input for day of the week,
     * day of the month, and month.
     *
     * <p>This method simulates user input by providing the day of the week, the specific day of the month, and the month,
     * then checks whether the output matches the expected formatted string, which indicates the corresponding day
     * of the week and month.</p>
     *
     * @param expected the expected output string, which represents the correct result for the given input
     * @param dayOfStart the starting day of the week for the given date
     * @param day the specific day of the month to check
     * @param month the month in which the day is located
     */
    @Override
    public void assertCalendar(String expected, int dayOfStart, int day, int month){
        String input = dayOfStart + SEPARATOR + day + SEPARATOR + month;

        String expectedOutput = format(
                "Task 5. Enter number day of New Year, day and month of searching day:" + SEPARATOR +
                "It is %s" + SEPARATOR, expected);

        assertValidConsolePrint(input, expectedOutput, MAIN_METHOD, false);
    }
    /**
     * Asserts that the method {@link calendar} correctly handles invalid day values by throwing an appropriate exception
     * with a message indicating the invalid day and month combination.
     *
     * <p>This method simulates user input with an invalid day of the month and checks whether the correct error message
     * is produced. The message should indicate the invalid day and the length of the month for the given input.</p>
     *
     * @param dayOfStart the starting day of the week for the given date
     * @param day the specific day of the month to check, which is invalid in this case
     * @param month the month in which the day is located
     */
    @Override
    public void assertThrowsIllegalDayValue(int dayOfStart, int day, int month){
        String input = dayOfStart + SEPARATOR + day + SEPARATOR + month;
        int daysInMonth = Month.of(month).length(false);

        String expectedOutput = format(INVALID_VALUE_DAY_INPUT_CALENDAR_TEST.getTestMessage(), daysInMonth, day);

        assertValidConsolePrint(input, expectedOutput, MAIN_METHOD, true);
    }

    /**
     * Asserts that an invalid month value results in the correct console output.
     *
     * <p>This method simulates user input for the day of the year, day, and month. It then checks if the console
     * outputs the expected error message when the "month" value is invalid. The expected error message is
     * formatted using the provided {@code month} value, and the method uses the {@link tools.ConsolePrintCheck#assertValidConsolePrint(String, String, Runnable, boolean)}
     * method to validate the console output.</p>
     *
     * @param dayOfStart the day of the week on which the year starts (1 for Monday, 7 for Sunday)
     * @param day the specific day of the month
     * @param month the month number (1 for January, 12 for December)
     */
    @Override
    public void assertThrowsIllegalMonthValue(int dayOfStart, int day, int month){
        String input = dayOfStart + SEPARATOR + day + SEPARATOR + month;

        String expectedOutput = format(INVALID_VALUE_MONTH_INPUT_CALENDAR_TEST.getTestMessage(), month);

        assertValidConsolePrint(input, expectedOutput, MAIN_METHOD, true);
    }
    /**
     * Asserts that an invalid day of the year value results in the correct console output.
     *
     * <p>This method simulates user input for the day of new year, day, and month. It then checks if the console
     * outputs the expected error message when the day of new year value is invalid. The expected error message is
     * formatted using the provided {@code dayOfStart} value, and the method uses the {@link tools.ConsolePrintCheck#assertValidConsolePrint(String, String, Runnable, boolean)}
     * method to validate the console output.</p>
     *
     * @param dayOfStart the day of the week on which the year starts (1 for Monday, 7 for Sunday)
     * @param day the specific day of the month
     * @param month the month number (1 for January, 12 for December)
     */
    @Override
    public void assertThrowsIllegalDayOfNewYearValue(int dayOfStart, int day, int month){
        String input = dayOfStart + SEPARATOR + day + SEPARATOR + month;

        String expectedOutput = format(INVALID_VALUE_DAY_OF_NEW_YEAR_INPUT_CALENDAR_TEST.getTestMessage(), dayOfStart);

        assertValidConsolePrint(input, expectedOutput, MAIN_METHOD, true);
    }
    /**
     * Asserts that the method {@link calendar} correctly handles invalid month input by throwing an appropriate exception
     * with a message indicating the invalid month.
     *
     * <p>This method simulates user input with an invalid month and checks whether the correct error message is produced.
     * The message should indicate the invalid month input provided by the user.</p>
     *
     * @param dayOfStart the starting day of the week for the given date
     * @param day the specific day of the month to check
     * @param month the invalid month input to be tested
     */
    public void assertThrowsIllegalMonth(String dayOfStart, String day, String month){
        String input = dayOfStart + SEPARATOR + day + SEPARATOR + month;

        String expectedOutput = format(INVALID_TYPE_INPUT_CALENDAR_TEST.getTestMessage(), "month", month);

        assertValidConsolePrint(input, expectedOutput, MAIN_METHOD, true);
    }
    /**
     * Asserts that the method {@link calendar} correctly handles invalid New Year input by throwing an appropriate exception
     * with a message indicating the invalid New Year day input.
     *
     * <p>This method simulates user input with an invalid New Year day and checks whether the correct error message
     * is produced, indicating the issue with the provided day of the start of the year.</p>
     *
     * @param dayOfStart the invalid starting day of the week for the New Year
     * @param day the specific day of the month to check
     * @param month the month in which the day is located
     */
    public void assertInvalidNewYearInput(String dayOfStart, String day, String month){
        String input = dayOfStart + SEPARATOR + day + SEPARATOR + month;

        String expectedOutput = format(INVALID_TYPE_INPUT_CALENDAR_TEST.getTestMessage(), "day of New Year", dayOfStart);

        assertValidConsolePrint(input, expectedOutput, MAIN_METHOD, true);
    }
    /**
     * Asserts that the method {@link calendar} correctly handles invalid day input by throwing an appropriate exception
     * with a message indicating the invalid day input.
     *
     * <p>This method simulates user input with an invalid day and checks whether the correct error message is produced,
     * indicating the issue with the provided day input.</p>
     *
     * @param dayOfStart the starting day of the week for the given date
     * @param day the invalid specific day of the month to be tested
     * @param month the month in which the day is located
     */
    public void assertInvalidDayInput(String dayOfStart, String day, String month){
        String input = dayOfStart + SEPARATOR + day + SEPARATOR + month;

        String expectedOutput = format(INVALID_TYPE_INPUT_CALENDAR_TEST.getTestMessage(), "day", day);

        assertValidConsolePrint(input, expectedOutput, MAIN_METHOD, true);
    }

}
