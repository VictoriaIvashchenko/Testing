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
    private final static String LINE_BREAK = System.lineSeparator();

    /**
     * A {@link Runnable} reference to the {@code main} method of {@link CalendarMain}.
     *
     * <p>This runnable executes {@link CalendarMain#main(String[])} with an empty argument array,
     * allowing test cases to simulate program execution.</p>
     */
    private final static Runnable MAIN_METHOD = () -> CalendarMain.main(new String[]{});

    /**
     * Obligatory starting message with instructions.
     */
    private final static String PROMPT =
            "Task 5. Enter number day of New Year, day and month of searching day:" + LINE_BREAK;

    @Test
    void overRangeInputTest() {
        //(MAX, MIN, MAX)
        assertInvalidInputType("2147483648", "-2147483648", "2147483647");//(MAX + 1, MIN, MAX)
        assertInvalidInputType("2147483648", "-2147483648", "2147483648");//(MAX + 1, MIN, MAX + 1)
        assertInvalidInputType("2147483648", "-2147483648", "2147483646");//(MAX + 1, MIN, MAX - 1)
        assertInvalidInputType("2147483648", "-2147483649", "2147483647");//(MAX + 1, MIN - 1, MAX)
        assertInvalidInputType("2147483648", "-2147483649", "2147483648");//(MAX + 1, MIN - 1, MAX + 1)
        assertInvalidInputType("2147483648", "-2147483647", "2147483648");//(MAX + 1, MIN + 1, MAX + 1)
        assertInvalidInputType("2147483648", "-2147483647", "2147483646");//(MAX + 1, MIN + 1, MAX - 1)
        assertInvalidInputType("2147483648", "-2147483649", "2147483646");//(MAX + 1, MIN - 1, MAX - 1)
        assertInvalidInputType("2147483648", "-2147483647", "2147483647");//(MAX + 1, MIN - 1, MAX)
        assertInvalidInputType("2147483647", "-2147483649", "2147483647");//(MAX, MIN - 1, MAX)
        assertInvalidInputType("2147483647", "-2147483649", "2147483648");//(MAX, MIN - 1, MAX + 1)
        assertInvalidInputType("2147483647", "-2147483649", "2147483646");//(MAX, MIN - 1, MAX - 1)
        assertInvalidInputType("2147483646", "-2147483649", "2147483647");//(MAX - 1, MIN - 1, MAX)
        assertInvalidInputType("2147483646", "-2147483649", "2147483648");//(MAX - 1, MIN - 1, MAX + 1)
        assertInvalidInputType("2147483646", "-2147483649", "2147483646");//(MAX - 1, MIN - 1, MAX - 1)
        assertInvalidInputType("2147483646", "-2147483647", "2147483648");//(MAX - 1, MIN + 1, MAX + 1)
        assertInvalidInputType("2147483646", "-2147483648", "2147483648");//(MAX - 1, MIN, MAX + 1)
        assertInvalidInputType("2147483647", "-2147483647", "2147483648");//(MAX, MIN + 1, MAX + 1)
        assertInvalidInputType("2147483647", "-2147483648", "2147483648");//(MAX, MIN, MAX + 1)
        //(MAX, MIN, MIN)
        assertInvalidInputType("2147483648", "-2147483648", "-2147483648");//(MAX + 1, MIN, MIN)
        assertInvalidInputType("2147483648", "-2147483648", "-2147483649");//(MAX + 1, MIN, MIN - 1)
        assertInvalidInputType("2147483648", "-2147483648", "-2147483647");//(MAX + 1, MIN, MIN + 1)
        assertInvalidInputType("2147483648", "-2147483649", "-2147483648");//(MAX + 1, MIN - 1, MIN)
        assertInvalidInputType("2147483648", "-2147483649", "-2147483649");//(MAX + 1, MIN - 1, MIN - 1)
        assertInvalidInputType("2147483648", "-2147483649", "-2147483647");//(MAX + 1, MIN - 1, MIN + 1)
        assertInvalidInputType("2147483648", "-2147483647", "-2147483648");//(MAX + 1, MIN + 1, MIN)
        assertInvalidInputType("2147483648", "-2147483647", "-2147483649");//(MAX + 1, MIN + 1, MIN - 1)
        assertInvalidInputType("2147483648", "-2147483647", "-2147483647");//(MAX + 1, MIN + 1, MIN + 1)
        assertInvalidInputType("2147483646", "-2147483649", "-2147483648");//(MAX - 1, MIN - 1, MIN)
        assertInvalidInputType("2147483646", "-2147483649", "-2147483649");//(MAX - 1, MIN - 1, MIN - 1)
        assertInvalidInputType("2147483646", "-2147483649", "-2147483647");//(MAX - 1, MIN - 1, MIN + 1)
        assertInvalidInputType("2147483647", "-2147483649", "-2147483648");//(MAX, MIN - 1, MIN)
        assertInvalidInputType("2147483647", "-2147483649", "-2147483649");//(MAX, MIN - 1, MIN - 1)
        assertInvalidInputType("2147483647", "-2147483647", "-2147483649");//(MAX, MIN + 1, MIN - 1)
        assertInvalidInputType("2147483646", "-2147483647", "-2147483649");//(MAX - 1, MIN + 1, MIN - 1)
        assertInvalidInputType("2147483646", "-2147483648", "-2147483649");//(MAX - 1, MIN, MIN - 1)
        assertInvalidInputType("2147483647", "-2147483648", "-2147483649");//(MAX, MIN, MIN - 1)
        assertInvalidInputType("2147483647", "-2147483648", "-2147483649");//(MAX, MIN, MIN - 1)
        //(MAX, MAX, MIN)
        assertInvalidInputType("2147483648", "2147483647", "-2147483648");//(MAX + 1, MAX, MIN)
        assertInvalidInputType("2147483648", "2147483647", "-2147483649");//(MAX + 1, MAX, MIN - 1)
        assertInvalidInputType("2147483648", "2147483647", "-2147483647");//(MAX + 1, MAX, MIN + 1)
        assertInvalidInputType("2147483648", "2147483648", "-2147483648");//(MAX + 1, MAX + 1, MIN)
        assertInvalidInputType("2147483648", "2147483648", "-2147483649");//(MAX + 1, MAX + 1, MIN - 1)
        assertInvalidInputType("2147483648", "2147483648", "-2147483647");//(MAX + 1, MAX + 1, MIN + 1)
        assertInvalidInputType("2147483648", "2147483646", "-2147483648");//(MAX + 1, MAX - 1, MIN)
        assertInvalidInputType("2147483648", "2147483646", "-2147483649");//(MAX + 1, MAX - 1, MIN - 1)
        assertInvalidInputType("2147483648", "2147483646", "-2147483647");//(MAX + 1, MAX - 1,  + 1)
        assertInvalidInputType("2147483647", "2147483648", "-2147483648");//(MAX, MAX + 1, MIN)
        assertInvalidInputType("2147483647", "2147483648", "-2147483649");//(MAX, MAX + 1, MIN - 1)
        assertInvalidInputType("2147483647", "2147483648", "-2147483647");//(MAX, MAX + 1, MIN + 1)
        assertInvalidInputType("2147483646", "2147483648", "-2147483648");//(MAX - 1, MAX + 1, MIN)
        assertInvalidInputType("2147483646", "2147483648", "-2147483649");//(MAX - 1, MAX + 1, MIN - 1)
        assertInvalidInputType("2147483646", "2147483648", "-2147483647");//(MAX - 1, MAX + 1, MIN + 1)
        assertInvalidInputType("2147483647", "2147483646", "-2147483649");//(MAX, MAX - 1, MIN - 1)
        assertInvalidInputType("2147483647", "2147483647", "-2147483649");//(MAX, MAX, MIN - 1)
        assertInvalidInputType("2147483646", "2147483647", "-2147483649");//(MAX - 1, MAX, MIN - 1)
        assertInvalidInputType("2147483646", "2147483646", "-2147483649");//(MAX - 1, MAX - 1, MIN - 1)
        //(MAX, MAX, MAX)
        assertInvalidInputType("2147483648", "2147483647", "2147483647");//(MAX + 1, MAX, MAX)
        assertInvalidInputType("2147483648", "2147483647", "2147483648");//(MAX + 1, MAX, MAX + 1)
        assertInvalidInputType("2147483648", "2147483647", "2147483646");//(MAX + 1, MAX, MAX - 1)
        assertInvalidInputType("2147483648", "2147483648", "2147483647");//(MAX + 1, MAX + 1, MAX)
        assertInvalidInputType("2147483648", "2147483648", "2147483648");//(MAX + 1, MAX + 1, MAX + 1)
        assertInvalidInputType("2147483648", "2147483648", "2147483646");//(MAX + 1, MAX + 1, MAX - )
        assertInvalidInputType("2147483648", "2147483646", "2147483647");//(MAX + 1, MAX - 1, MAX)
        assertInvalidInputType("2147483648", "2147483646", "2147483648");//(MAX + 1, MAX - 1, MAX + 1)
        assertInvalidInputType("2147483648", "2147483646", "2147483646");//(MAX + 1, MAX - 1, MAX - 1)
        assertInvalidInputType("2147483646", "2147483648", "2147483647");//(MAX - 1, MAX + 1, MAX)
        assertInvalidInputType("2147483646", "2147483648", "2147483648");//(MAX - 1, MAX + 1, MAX + 1)
        assertInvalidInputType("2147483646", "2147483648", "2147483646");//(MAX - 1, MAX + 1, MAX - 1)
        assertInvalidInputType("2147483647", "2147483648", "2147483647");//(MAX, MAX + 1, MAX)
        assertInvalidInputType("2147483647", "2147483648", "2147483648");//(MAX, MAX + 1, MAX + 1)
        assertInvalidInputType("2147483647", "2147483648", "2147483646");//(MAX, MAX + 1, MAX - 1)
        assertInvalidInputType("2147483647", "2147483646", "2147483648");//(MAX, MAX - 1, MAX + 1)
        assertInvalidInputType("2147483647", "2147483647", "2147483648");//(MAX, MAX, MAX + 1)
        assertInvalidInputType("2147483646", "2147483647", "2147483648");//(MAX - 1, MAX, MAX + 1)
        assertInvalidInputType("2147483646", "2147483646", "2147483648");//(MAX - 1, MAX - 1, MAX + 1)
        //(MIN, MAX, MIN)
        assertInvalidInputType("-2147483649", "2147483647", "-2147483648");//(MIN - 1, MAX, MIN)
        assertInvalidInputType("-2147483649", "2147483647", "-2147483649");//(MIN - 1, MAX, MIN - 1)
        assertInvalidInputType("-2147483649", "2147483647", "-2147483647");//(MIN - 1, MAX, MIN + 1)
        assertInvalidInputType("-2147483649", "2147483648", "-2147483648");//(MIN - 1, MAX + 1, MIN)
        assertInvalidInputType("-2147483649", "2147483648", "-2147483649");//(MIN - 1, MAX + 1, MIN - 1)
        assertInvalidInputType("-2147483649", "2147483648", "-2147483647");//(MIN - 1, MAX + 1, MIN + 1)
        assertInvalidInputType("-2147483649", "2147483646", "-2147483648");//(MIN - 1, MAX - 1, MIN)
        assertInvalidInputType("-2147483649", "2147483646", "-2147483649");//(MIN - 1, MAX - 1, MIN - 1)
        assertInvalidInputType("-2147483649", "2147483646", "-2147483647");//(MIN - 1, MAX - 1, MIN + 1)
        assertInvalidInputType("-2147483647", "2147483648", "-2147483648");//(MIN + 1, MAX + 1, MIN)
        assertInvalidInputType("-2147483647", "2147483648", "-2147483649");//(MIN + 1, MAX + 1, MIN - 1)
        assertInvalidInputType("-2147483647", "2147483648", "-2147483647");//(MIN + 1, MAX + 1, MIN + 1)
        assertInvalidInputType("-2147483648", "2147483648", "-2147483648");//(MIN, MAX + 1, MIN)
        assertInvalidInputType("-2147483648", "2147483648", "-2147483649");//(MIN, MAX + 1, MIN - 1)
        assertInvalidInputType("-2147483648", "2147483648", "-2147483647");//(MIN, MAX + 1, MIN + 1)
        assertInvalidInputType("-2147483648", "2147483646", "-2147483649");//(MIN, MAX - 1, MIN - 1)
        assertInvalidInputType("-2147483648", "2147483647", "-2147483649");//(MIN, MAX, MIN - 1)
        assertInvalidInputType("-2147483647", "2147483647", "-2147483649");//(MIN + 1, MAX, MIN - 1)
        assertInvalidInputType("-2147483647", "2147483646", "-2147483649");//(MIN + 1, MAX - 1, MIN - 1)
        //(MIN, MAX, MAX)
        assertInvalidInputType("-2147483649", "2147483647", "2147483647");//(MIN - 1, MAX, MAX)
        assertInvalidInputType("-2147483649", "2147483647", "2147483648");//(MIN - 1, MAX, MAX + 1)
        assertInvalidInputType("-2147483649", "2147483647", "2147483646");//(MIN - 1, MAX, MAX - 1)
        assertInvalidInputType("-2147483649", "2147483648", "2147483647");//(MIN - 1, MAX + 1, MAX)
        assertInvalidInputType("-2147483649", "2147483648", "2147483648");//(MIN - 1, MAX + 1, MAX + 1)
        assertInvalidInputType("-2147483649", "2147483648", "2147483646");//(MIN - 1, MAX + 1, MAX - 1)
        assertInvalidInputType("-2147483649", "2147483646", "2147483647");//(MIN - 1, MAX - 1, MAX)
        assertInvalidInputType("-2147483649", "2147483646", "2147483648");//(MIN - 1, MAX - 1, MAX + 1)
        assertInvalidInputType("-2147483649", "2147483646", "2147483646");//(MIN - 1, MAX - 1, MAX - 1)
        assertInvalidInputType("-2147483648", "2147483648", "2147483647");//(MIN, MAX + 1, MAX)
        assertInvalidInputType("-2147483648", "2147483648", "2147483648");//(MIN, MAX + 1, MAX + 1)
        assertInvalidInputType("-2147483648", "2147483648", "2147483646");//(MIN, MAX + 1, MAX - 1)
        assertInvalidInputType("-2147483647", "2147483648", "2147483647");//(MIN + 1, MAX + 1, MAX)
        assertInvalidInputType("-2147483647", "2147483648", "2147483648");//(MIN + 1, MAX + 1, MAX + 1)
        assertInvalidInputType("-2147483647", "2147483648", "2147483646");//(MIN + 1, MAX + 1, MAX - 1)
        assertInvalidInputType("-2147483648", "2147483647", "2147483648");//(MIN, MAX, MAX + 1)
        assertInvalidInputType("-2147483648", "2147483646", "2147483648");//(MIN, MAX - 1, MAX + 1)
        assertInvalidInputType("-2147483647", "2147483647", "2147483648");//(MIN + 1, MAX, MAX + 1)
        assertInvalidInputType("-2147483647", "2147483646", "2147483648");//(MIN + 1, MAX - 1, MAX + 1)
        //(MIN, MIN, MAX)
        assertInvalidInputType("-2147483649", "-2147483648", "2147483647");//(MIN - 1, MIN, MAX)
        assertInvalidInputType("-2147483649", "-2147483648", "2147483648");//(MIN - 1, MIN, MAX + 1)
        assertInvalidInputType("-2147483649", "-2147483648", "2147483646");//(MIN - 1, MIN, MAX - 1)
        assertInvalidInputType("-2147483649", "-2147483649", "2147483647");//(MIN - 1, MIN - 1, MAX)
        assertInvalidInputType("-2147483649", "-2147483649", "2147483648");//(MIN - 1, MIN - 1, MAX + 1)
        assertInvalidInputType("-2147483649", "-2147483649", "2147483646");//(MIN - 1, MIN - 1, MAX - 1)
        assertInvalidInputType("-2147483649", "-2147483647", "2147483647");//(MIN - 1, MIN + 1, MAX)
        assertInvalidInputType("-2147483649", "-2147483647", "2147483648");//(MIN - 1, MIN + 1, MAX + 1)
        assertInvalidInputType("-2147483649", "-2147483647", "2147483646");//(MIN - 1, MIN + 1, MAX - 1)
        assertInvalidInputType("-2147483648", "-2147483649", "2147483647");//(MIN, MIN - 1, MAX)
        assertInvalidInputType("-2147483648", "-2147483649", "2147483648");//(MIN, MIN - 1, MAX + 1)
        assertInvalidInputType("-2147483648", "-2147483649", "2147483646");//(MIN, MIN - 1, MAX - 1)
        assertInvalidInputType("-2147483647", "-2147483649", "2147483647");//(MIN + 1, MIN - 1, MAX)
        assertInvalidInputType("-2147483647", "-2147483649", "2147483648");//(MIN + 1, MIN - 1, MAX + 1)
        assertInvalidInputType("-2147483647", "-2147483649", "2147483646");//(MIN + 1, MIN - 1, MAX - 1)
        assertInvalidInputType("-2147483647", "-2147483647", "2147483648");//(MIN + 1, MIN + 1, MAX + 1)
        assertInvalidInputType("-2147483648", "-2147483647", "2147483648");//(MIN, MIN + 1, MAX + 1)
        assertInvalidInputType("-2147483648", "-2147483648", "2147483648");//(MIN, MIN, MAX + 1)
        assertInvalidInputType("-2147483647", "-2147483648", "2147483648");//(MIN + 1, MIN, MAX + 1)
        //(MIN, MIN, MIN)
        assertInvalidInputType("-2147483649", "-2147483648", "-2147483648");//(MIN - 1, MIN, MIN)
        assertInvalidInputType("-2147483649", "-2147483648", "-2147483649");//(MIN - 1, MIN, MIN - 1)
        assertInvalidInputType("-2147483649", "-2147483648", "-2147483647");//(MIN - 1, MIN, MIN + 1)
        assertInvalidInputType("-2147483649", "-2147483649", "-2147483648");//(MIN - 1, MIN - 1, MIN)
        assertInvalidInputType("-2147483649", "-2147483649", "-2147483649");//(MIN - 1, MIN - 1, MIN - 1)
        assertInvalidInputType("-2147483649", "-2147483649", "-2147483647");//(MIN - 1, MIN - 1, MIN + 1)
        assertInvalidInputType("-2147483649", "-2147483647", "-2147483648");//(MIN - 1, MIN + 1, MIN)
        assertInvalidInputType("-2147483649", "-2147483647", "-2147483649");//(MIN - 1, MIN + 1, MIN - 1)
        assertInvalidInputType("-2147483649", "-2147483647", "-2147483647");//(MIN - 1, MIN + 1, MIN + 1)
        assertInvalidInputType("-2147483647", "-2147483649", "-2147483648");//(MIN + 1, MIN - 1, MIN)
        assertInvalidInputType("-2147483647", "-2147483649", "-2147483649");//(MIN + 1, MIN - 1, MIN - 1)
        assertInvalidInputType("-2147483647", "-2147483649", "-2147483647");//(MIN + 1, MIN - 1, MIN + 1)
        assertInvalidInputType("-2147483648", "-2147483649", "-2147483648");//(MIN, MIN - 1, MIN)
        assertInvalidInputType("-2147483648", "-2147483649", "-2147483649");//(MIN, MIN - 1, MIN - 1)
        assertInvalidInputType("-2147483648", "-2147483649", "-2147483647");//(MIN, MIN - 1, MIN + 1)
        assertInvalidInputType("-2147483647", "-2147483647", "-2147483649");//(MIN + 1, MIN + 1, MIN - 1)
        assertInvalidInputType("-2147483648", "-2147483648", "-2147483649");//(MIN, MIN, MIN - 1)
        assertInvalidInputType("-2147483648", "-2147483647", "-2147483649");//(MIN, MIN + 1, MIN - 1)
        assertInvalidInputType("-2147483647", "-2147483648", "-2147483649");//(MIN + 1, MIN, MIN - 1)

    }

    @Test
    void invalidTypeDayOfNewYearTest() {
        assertInvalidInputType("a", "1", "a");
        assertInvalidInputType("z", "z", "z");

        assertInvalidInputType("A", "A", "A");
        assertInvalidInputType("Z", "Z", "Z");

        assertInvalidInputType("a", "1", "1");
        assertInvalidInputType("z", "1", "1");

        assertInvalidInputType("a", "a", "1");
        assertInvalidInputType("a", "1", "a");

        assertInvalidInputType("!", "!", "!");
        assertInvalidInputType("?", "#", "$");
        assertInvalidInputType("@", "@", "@");

        assertInvalidInputType("!", "1", "45");
        assertInvalidInputType("%^", "56", "88");
        assertInvalidInputType("@", "985", "89");

        assertInvalidInputType("#889232", "#364977", "#259689");
        assertInvalidInputType("#112233", "#562111", "#136569");
        assertInvalidInputType("#449796", "#562236", "#566846");

        assertInvalidInputType("#862669", "1", "45");
        assertInvalidInputType("#566224", "56", "88");
        assertInvalidInputType("#466256", "985", "89");

        assertInvalidInputType("M0nday", "89", "71");
        assertInvalidInputType("Sun day", "89", "71");
        assertInvalidInputType("3% 1", "89", "71");
        assertInvalidInputType("#111111 Apr", "89", "71");
        assertInvalidInputType("18.23 Jan", "89", "71");
    }

    @Test
    void invalidDayTypeTest() {
        assertInvalidInputType("1", "a", "a");
        assertInvalidInputType("1", "z", "z");

        assertInvalidInputType("1", "A", "A");
        assertInvalidInputType("1", "Z", "Z");

        assertInvalidInputType("1", "a", "26");
        assertInvalidInputType("1", "z", "68");

        assertInvalidInputType("1", "D", "123");
        assertInvalidInputType("1", "Z", "895");

        assertInvalidInputType("1", "!", "!");
        assertInvalidInputType("1", "#", "$");
        assertInvalidInputType("1", "@", "@");

        assertInvalidInputType("1", "!", "45");
        assertInvalidInputType("1", "?", "88");
        assertInvalidInputType("1", "@", "89");

        assertInvalidInputType("1", "#364977", "#259689");
        assertInvalidInputType("1", "#562111", "#136569");
        assertInvalidInputType("1", "#562236", "#566846");

        assertInvalidInputType("1", "#862669", "45");
        assertInvalidInputType("1", "#566224", "88");
        assertInvalidInputType("1", "#466256", "89");

        assertInvalidInputType("1", "1 1", "71");
        assertInvalidInputType("1", "e 1", "71");
        assertInvalidInputType("1", "$ 1", "71");
        assertInvalidInputType("1", "#111111 1", "71");
        assertInvalidInputType("1", "18.23 1", "71");

    }

    @Test
    void invalidMonthTypeTest() {
        assertInvalidInputType("1", "1", "a");
        assertInvalidInputType("1", "8", "z");

        assertInvalidInputType("1", "1", "!");
        assertInvalidInputType("1", "3", "$");
        assertInvalidInputType("1", "4", "@");

        assertInvalidInputType("1", "4", "#259689");
        assertInvalidInputType("1", "5", "#136569");
        assertInvalidInputType("1", "5", "#566846");

        assertInvalidInputType("1", "1", "1 1");
        assertInvalidInputType("1", "2", "e 1");
        assertInvalidInputType("1", "4", "$ 1");
        assertInvalidInputType("1", "5", "#111111 1");
        assertInvalidInputType("1", "6", "18.23 1");
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
        String input = getInput(dayOfStart, day, month);

        String expectedOutput = format("%sIt is %s%n", PROMPT, expected);
        String expectedErrorOutput = "";

        assertConsolePrint(input, expectedOutput, expectedErrorOutput, expectedOutput, MAIN_METHOD);
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
        String input = getInput(dayOfStart, day, month);

        int dayInMonth = month.length(false);

        String expectedErrorOutput = format(INVALID_VALUE_DAY_INPUT_CALENDAR_TEST, dayInMonth, day);
        String expectedFullOutput = PROMPT + expectedErrorOutput;

        assertConsolePrint(input, PROMPT, expectedErrorOutput, expectedFullOutput, MAIN_METHOD);
    }

    /**
     * Asserts that the method {@link calendar.Calendar#calendar(DayOfWeek, int, Month)} correctly handles invalid type of
     * input argument by throwing an appropriate exception with a message indicating the invalid type input.
     *
     * @param dayOfStart the starting day of the week for the given date
     * @param day        the invalid specific day of the month to be tested
     * @param month      the month in which the day is located
     */
    public void assertInvalidInputType(String dayOfStart, String day, String month) {
        String input = getInput(dayOfStart, day, month);

        String expectedErrorOutput = "Invalid type of input value. Number from -2147483648 to 2147483647 was expected.";
        String expectedFullOutput = PROMPT + expectedErrorOutput;

        assertConsolePrint(input, PROMPT, expectedErrorOutput, expectedFullOutput, MAIN_METHOD);
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
        String input = getInput(dayOfStart, day, month);

        String expectedErrorOutput = format(
                "Invalid input day of New Year. Number of weekday was expected, but '%s' was received.", dayOfStart);
        String expectedFullOutput = PROMPT + expectedErrorOutput;

        assertConsolePrint(input, PROMPT, expectedErrorOutput, expectedFullOutput, MAIN_METHOD);
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
        String input = getInput(dayOfStart, day, month);

        String expectedErrorOutput = format(
                "Invalid input number of month. Number of month was expected, but '%s' was received.", month);
        String expectedFullOutput = PROMPT + expectedErrorOutput;

        assertConsolePrint(input, PROMPT, expectedErrorOutput, expectedFullOutput, MAIN_METHOD);
    }

    private static String getInput(String dayOfStart, String day, String month) {
        return dayOfStart + LINE_BREAK + day + LINE_BREAK + month;
    }

    private static String getInput(DayOfWeek dayOfStart, int day, Month month) {
        return dayOfStart.getValue() + LINE_BREAK + day + LINE_BREAK + month.getValue();
    }
}
