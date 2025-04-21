package calendarTest;

import org.junit.jupiter.api.Test;
import calendar.CalendarMain;

import java.time.DayOfWeek;
import java.time.Month;

import static java.lang.String.format;
import static tools.ConsolePrintCheck.assertConsolePrint;

/**
 * Unit test class for {@link CalendarMain}.
 *
 * <p>This class extends {@link CalendarTest} and provides specific test configurations
 * for verifying the behavior of the {@link CalendarMain} program. It sets up the main method
 * for execution during tests and defines a system-dependent line separator.</p>
 */
public class CalendarMainTest extends CalendarTest {

    /**
     * System-dependent line separator used for formatting expected test output.
     */
    private final static String SEPARATOR = System.lineSeparator();

    /**
     * A {@link Runnable} reference to the {@code main} method of {@link CalendarMain}.
     *
     * <p>This runnable executes {@link CalendarMain#main(String[])} with an empty argument array,
     * allowing test cases to simulate program execution.</p>
     */
    private final static Runnable MAIN_METHOD = () -> CalendarMain.main(new String[]{});

    /**
     * Error message for an invalid New Year's starting day input in calendar calculations.
     */
    private final static String INVALID_DAY_OF_NEW_YEAR_INPUT_VALUE_MESSAGE =
            "Invalid input day of New Year. Number of weekday was expected, but '%s' was received.";

    /**
     * Error message for an invalid month input in calendar calculations.
     */
    private final static String INVALID_MONTH_INPUT_VALUE_MESSAGE =
            "Invalid input number of month. Number of month was expected, but '%s' was received.";

    /**
     * Error message for an invalid type input in calendar calculations.
     */
    private final static String INVALID_INPUT_TYPE_MESSAGE =
            "Invalid type of %s. Number from -2147483648 to 2147483647 was expected, but '%s' was received.";

    /**
     * Obligatory starting message with instructions.
     */
    private final static String EXPECTED_OUTPUT = String.format(
            "Task 5. Enter number day of New Year, day and month of searching day:%n");

    @Test
    void overRangeInputTest() {
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
    void invalidTypeDayOfNewYearTest() {
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
    void invalidDayTypeTest() {
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
    void invalidMonthTypeTest() {
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

    @Test
    void invalidValueDayOfNewYearTest() {
        assertInvalidValueDayOfNewYear("0", "1", "1");
        assertInvalidValueDayOfNewYear("-1", "1", "1");
        assertInvalidValueDayOfNewYear("-2147483647", "1", "1");
        assertInvalidValueDayOfNewYear("-2147483648", "1", "1");

        assertInvalidValueDayOfNewYear("8", "1", "1");
        assertInvalidValueDayOfNewYear("9", "1", "1");
        assertInvalidValueDayOfNewYear("2147483646", "1", "1");
        assertInvalidValueDayOfNewYear("2147483647", "1", "1");
    }

    @Test
    void invalidMonthValueTest() {
        assertInvalidValueMonth("1", "1", "0");
        assertInvalidValueMonth("1", "1", "-1");
        assertInvalidValueMonth("1", "1", "-2147483647");
        assertInvalidValueMonth("1", "1", "-2147483648");

        assertInvalidValueMonth("1", "1", "13");
        assertInvalidValueMonth("1", "1", "14");
        assertInvalidValueMonth("1", "1", "2147483646");
        assertInvalidValueMonth("1", "1", "2147483647");
    }

    /**
     * Asserts that the method {@link calendar.Calendar#calendar(DayOfWeek, int, Month)} produces the correct output when given valid input for day of the week,
     * day of the month, and month.
     *
     * @param expected   the expected output string, which represents the correct result for the given input
     * @param dayOfStart the starting day of the week for the given date
     * @param day        the specific day of the month to check
     * @param month      the month in which the day is located
     */
    @Override
    public void assertCalendar(String expected, DayOfWeek dayOfStart, int day, Month month) {
        String expectedErrorOutput = "";
        String expectedOutput = format("%sIt is %s%n", EXPECTED_OUTPUT, expected);

        assertConsoleOutput(dayOfStart, day, month, expectedOutput, expectedErrorOutput);
    }

    /**
     * Asserts that the method {@link calendar.Calendar#calendar(DayOfWeek, int, Month)} correctly handles
     * invalid day values by throwing an appropriate exception with a message indicating the invalid day and month combination.
     *
     * @param dayOfStart the starting day of the week for the given date
     * @param day        the specific day of the month to check, which is invalid in this case
     * @param month      the month in which the day is located
     */
    @Override
    public void assertThrowsIllegalDayValue(DayOfWeek dayOfStart, int day, Month month) {
        String expectedErrorOutput = format(INVALID_VALUE_DAY_INPUT_CALENDAR_TEST, month.length(false), day);

        assertConsoleOutput(dayOfStart, day, month, EXPECTED_OUTPUT, expectedErrorOutput);
    }

    /**
     * Asserts that the method {@link calendar.Calendar#calendar(DayOfWeek, int, Month)} correctly handles invalid month input by throwing an appropriate exception
     * with a message indicating the invalid month.
     *
     * @param dayOfStart the starting day of the week for the given date
     * @param day        the specific day of the month to check
     * @param month      the invalid month input to be tested
     */
    public void assertThrowsIllegalMonth(String dayOfStart, String day, String month) {
        String expectedErrorOutput = format(INVALID_INPUT_TYPE_MESSAGE, "month", month);

        assertConsoleOutput(dayOfStart, day, month, EXPECTED_OUTPUT, expectedErrorOutput);
    }

    /**
     * Asserts that the method {@link calendar.Calendar#calendar(DayOfWeek, int, Month)} correctly handles invalid New Year input by throwing an appropriate exception
     * with a message indicating the invalid New Year day input.
     *
     * @param dayOfStart the invalid starting day of the week for the New Year
     * @param day        the specific day of the month to check
     * @param month      the month in which the day is located
     */
    public void assertInvalidNewYearInput(String dayOfStart, String day, String month) {
        String expectedErrorOutput = format(INVALID_INPUT_TYPE_MESSAGE, "day of New Year", dayOfStart);

        assertConsoleOutput(dayOfStart, day, month, EXPECTED_OUTPUT, expectedErrorOutput);
    }

    /**
     * Asserts that the method {@link calendar.Calendar#calendar(DayOfWeek, int, Month)} correctly handles invalid day input by throwing an appropriate exception
     * with a message indicating the invalid day input.
     *
     * @param dayOfStart the starting day of the week for the given date
     * @param day        the invalid specific day of the month to be tested
     * @param month      the month in which the day is located
     */
    public void assertInvalidDayInput(String dayOfStart, String day, String month) {
        String expectedErrorOutput = format(INVALID_INPUT_TYPE_MESSAGE, "day", day);

        assertConsoleOutput(dayOfStart, day, month, EXPECTED_OUTPUT, expectedErrorOutput);
    }

    /**
     * Asserts that the method {@link calendar.Calendar#calendar(DayOfWeek, int, Month)} correctly handles invalid day input by throwing an appropriate exception
     * with a message indicating the invalid input value number weekday of New Year.
     *
     * @param dayOfStart the invalid starting day of the week for the given date
     * @param day        the specific day of the month to be tested
     * @param month      the month in which the day is located
     */
    public void assertInvalidValueDayOfNewYear(String dayOfStart, String day, String month) {
        String expectedErrorOutput = format(INVALID_DAY_OF_NEW_YEAR_INPUT_VALUE_MESSAGE, dayOfStart);

        assertConsoleOutput(dayOfStart, day, month, EXPECTED_OUTPUT, expectedErrorOutput);
    }

    /**
     * Asserts that the method {@link calendar.Calendar#calendar(DayOfWeek, int, Month)} correctly handles invalid day input by throwing an appropriate exception
     * with a message indicating the invalid input value of month number.
     *
     * @param dayOfStart the starting day of the week for the given date
     * @param day        the specific day of the month to be tested
     * @param month      the invalid month in which the day is located
     */
    public void assertInvalidValueMonth(String dayOfStart, String day, String month) {
        String expectedErrorOutput = format(INVALID_MONTH_INPUT_VALUE_MESSAGE, month);

        assertConsoleOutput(dayOfStart, day, month, EXPECTED_OUTPUT, expectedErrorOutput);
    }

    /**
     * Asserts that the console output and error output match the expected values
     * when the main method is executed with the given input values as strings.
     *
     * <p>Method tests the console output of the main method by providing input in the format of day of start, day, and month as strings
     * The input is formatted as a single string with components separated by a predefined separator.</p>
     *
     * @param dayOfStart          the day of the week to start (e.g., "Monday")
     * @param day                 the day of the month (e.g., "15")
     * @param month               the month (e.g., "January")
     * @param expectedOutput      the expected console output
     * @param expectedErrorOutput the expected console error output
     */
    public void assertConsoleOutput(String dayOfStart, String day, String month, String expectedOutput, String expectedErrorOutput) {
        String input = dayOfStart + SEPARATOR + day + SEPARATOR + month;

        assertConsolePrint(input, expectedOutput, expectedErrorOutput, MAIN_METHOD);
    }

    /**
     * Asserts that the console output and error output match the expected values
     * when the main method is executed with the given input values as enums and integers.
     *
     * <p>Method tests the console output of the main method by providing input as a DayOfWeek enum, an integer day, and a
     * Month enum.The input is formatted as a single string with components separated by a predefined separator, using the numeric
     * values of the DayOfWeek and Month enums.</p>
     *
     * @param dayOfStart          the day of the week the year starts on, as a {@link DayOfWeek} enum
     * @param day                 the day of the month
     * @param month               the month, as a {@link Month} enum
     * @param expectedOutput      the expected output to {@code System.out}
     * @param expectedErrorOutput the expected output to {@code System.err}
     */
    public void assertConsoleOutput(DayOfWeek dayOfStart, int day, Month month, String expectedOutput, String expectedErrorOutput) {
        String input = dayOfStart.getValue() + SEPARATOR + day + SEPARATOR + month.getValue();

        assertConsolePrint(input, expectedOutput, expectedErrorOutput, MAIN_METHOD);
    }

}
