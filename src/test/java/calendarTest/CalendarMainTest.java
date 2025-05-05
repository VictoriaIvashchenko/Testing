package calendarTest;

import calendar.CalendarMain;
import org.junit.jupiter.api.Test;

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
     * A {@link Runnable} reference to the {@code main} method of {@link CalendarMain}.
     *
     * <p>This runnable executes {@link CalendarMain#main(String[])} with an empty argument array,
     * allowing test cases to simulate program execution.</p>
     */
    private final static Runnable MAIN_METHOD = () -> CalendarMain.main(new String[]{});

    /**
     * Prompt message for entering the weekday of New Year's Day.
     */
    private static final String PROMPT_NEW_YEAR = String.format("Enter weekday of New Year:%n");
    /**
     * Prompt message for entering the month.
     */
    private static final String PROMPT_MONTH = String.format("Enter month:%n");
    /**
     * Prompt message for entering the day.
     */
    private static final String PROMPT_DAY = String.format("Enter day:%n");

    /**
     * Warning message for invalid weekday input, expecting a number from 1 to 7.
     */
    private static final String WEEKDAY_WARNING = String.format("[Warning] Invalid input value. Number from 1 to 7 was expected.%n");
    /**
     * Warning message format for invalid day input, expecting a number from 1 to the maximum days in the month.
     */
    private static final String DAY_WARNING = "[Warning] Invalid input value. Number from 1 to %d was expected.%n";
    /**
     * Warning message for invalid month input, expecting a number from 1 to 12.
     */
    private static final String MONTH_WARNING = String.format("[Warning] Invalid input value. Number from 1 to 12 was expected.%n");

    /**
     * Message for invalid month input followed by the month prompt, using for giving new attempt to enter value.
     */
    private static final String MONTH_ATTEMPT = MONTH_WARNING + PROMPT_MONTH;
    /**
     * Message for invalid weekday input followed by the weekday prompt, using for giving new attempt to enter value.
     */
    private static final String WEEKDAY_ATTEMPT = WEEKDAY_WARNING + PROMPT_NEW_YEAR;

    @Test
    void overRangeArgumentsTest() {
        assertInvalidArguments("8\n1", "32\n1", "13\n1", "Monday");
        assertInvalidArguments("8\n9\n1", "29\n30\n1", "13\n14\n2", "Thursday");
        assertInvalidArguments("8\n9\n10\n1", "31\n32\n33\n1", "13\n14\n15\n4", "Sunday");
        assertInvalidArguments("8\n9\n10\n11\n1", "32\n33\n34\n35\n1", "13\n14\n15\n16\n1", "Monday");

        assertInvalidArguments("0\n1", "0\n1", "0\n1", "Monday");
        assertInvalidArguments("0\n-1\n2", "0\n-1\n4", "0\n-1\n1", "Friday");
        assertInvalidArguments("0\n-1\n-2\n1", "0\n-1\n-2\n1", "0\n-1\n-2\n1", "Monday");
        assertInvalidArguments("0\n-1\n-2\n-3\n1", "0\n-1\n-2\n-3\n1", "0\n-1\n-2\n-3\n1", "Monday");

        assertInvalidArguments("2147483648\n1", "2147483648\n1", "2147483648\n1", "Monday");
        assertInvalidArguments("2147483648\n2147483649\n1", "2147483648\n2147483649\n2", "2147483648\n2147483649\n1", "Tuesday");
        assertInvalidArguments("2147483648\n2147483649\n2147483650\n3", "2147483648\n2147483649\n2147483650\n1", "2147483648\n2147483649\n2147483650\n1", "Wednesday");
        assertInvalidArguments("2147483648\n2147483649\n2147483650\n2147483651\n1", "2147483648\n2147483649\n2147483650\n2147483651\n1", "2147483648\n2147483649\n2147483650\n2147483651\n1", "Monday");

        assertInvalidArguments("-2147483649\n1", "-2147483649\n1", "-2147483649\n1", "Monday");
        assertInvalidArguments("-2147483649\n-2147483650\n5", "-2147483649\n-2147483650\n2", "-2147483649\n-2147483650\n1", "Saturday");
        assertInvalidArguments("-2147483649\n-2147483650\n-2147483651\n1", "-2147483649\n-2147483650\n-2147483651\n1", "-2147483649\n-2147483650\n-2147483651\n1", "Monday");
        assertInvalidArguments("-2147483649\n-2147483650\n-2147483651\n-2147483652\n1", "-2147483649\n-2147483650\n-2147483651\n-2147483652\n1", "-2147483649\n-2147483650\n-2147483651\n-2147483652\n1", "Monday");
    }

    @Test
    void characterInputTest() {
        assertInvalidArguments("a\n1", "a\n1", "a\n1", "Monday");
        assertInvalidArguments("z\n1", "z\n1", "z\n1", "Monday");

        assertInvalidArguments("a\nb\n1", "a\nb\n2", "a\nb\n1", "Tuesday");
        assertInvalidArguments("a\nb\nc\n1", "a\nb\nc\n1", "a\nb\nc\n1", "Monday");
        assertInvalidArguments("a\nb\nc\nd\n1", "a\nb\nc\nd\n1", "a\nb\nc\nd\n1", "Monday");

        assertInvalidArguments("z\ny\n1", "z\ny\n1", "z\ny\n1", "Monday");
        assertInvalidArguments("z\ny\nx\n1", "z\ny\nx\n3", "z\ny\nx\n1", "Wednesday");
        assertInvalidArguments("z\ny\nx\nw\n1", "z\ny\nx\nw\n1", "z\ny\nx\nw\n1", "Monday");

        assertInvalidArguments("A\n1", "A\n1", "A\n1", "Monday");
        assertInvalidArguments("Z\n7", "Z\n1", "Z\n1", "Sunday");

        assertInvalidArguments("A\nB\n1", "A\nB\n1", "A\nB\n1", "Monday");
        assertInvalidArguments("A\nB\nC\n1", "A\nB\nC\n1", "A\nB\nC\n1", "Monday");
        assertInvalidArguments("A\nB\nC\nD\n1", "A\nB\nC\nD\n1", "A\nB\nC\nD\n1", "Monday");

        assertInvalidArguments("Z\nY\n1", "Z\nY\n1", "Z\nY\n1", "Monday");
        assertInvalidArguments("Z\nY\nX\n5", "Z\nY\nX\n1", "Z\nY\nX\n1", "Friday");
        assertInvalidArguments("Z\nY\nX\nW\n1", "Z\nY\nX\nW\n1", "Z\nY\nX\nW\n1", "Monday");

        assertInvalidArguments("a 1\n1", "3 f\n1", "4 f\n1", "Monday");
        assertInvalidArguments("b 1\n2 f\n1", "3 f\nzero 2\n1", "4 f\none 1\n1", "Monday");

        assertInvalidArguments("!\n1", "!\n1", "!\n1", "Monday");
        assertInvalidArguments("@\n!\n2", "@\n!\n3", "@\n!\n1", "Thursday");
        assertInvalidArguments("!\n@\n#\n1", "!\n@\n#\n1", "!\n@\n#\n1", "Monday");

        assertInvalidArguments("3%\n1", "5$\n1", "2^2\n1", "Monday");
        assertInvalidArguments("3% 4\n(7-5)*2\n3", "8-1\n!\n2", "#5050\n7%2\n1", "Thursday");
        assertInvalidArguments("2@ 3\n4$\n5+1\n4", "4$ 6\n7^ 1\n3", "13 1\n1", "Saturday");
        assertInvalidArguments("(^.^)\nd=(^o^)=b\n(/--)/\n(・_・?)\n2", "#4\n|1|\n$2\n4$;\n2", "7^#%\n(0-0)\n1", "Wednesday");
    }

    @Test
    void invalidNumericTypeTest() {
        assertInvalidArguments("1.3\n1", "34.5\n1", "21.4\n1", "Monday");
        assertInvalidArguments("587.57\n0.56\n1", "34.5\n0.46\n1", "21.4\n0.48\n1", "Monday");
        assertInvalidArguments("57.39\n0.4\n-15.22\n1", "34.5\n0.465\n-464.2\n1", "21.4\n0.26\n-12.5\n1", "Monday");
        assertInvalidArguments("1.3\n0.45\n-5.23\n.45\n1", "34.5\n0.45\n-5.23\n.45\n1", "21.4\n0.45\n-5.23\n.45\n1", "Monday");

        assertInvalidArguments("1.3 1\n1", "45.56 2\n1", "5.5 5\n1", "Monday");
        assertInvalidArguments("1L 1\n45.5\n1", "-411.4 2\n1", "-0.12 5\n455.1\n1", "Monday");
        assertInvalidArguments("1.3 1\n584.45 5\n1", "45.56 2\n430.1 12\n1", "5.5 5\n54.5\n1", "Monday");

        assertInvalidArguments("#456236\n1", "#596345\n1", "#569812\n1", "Monday");
        assertInvalidArguments("#786215\n#125621\n1", "#786215\n#125621\n1", "#786215\n#125621\n1", "Monday");
        assertInvalidArguments("#786215\n#125621\n#896546\n1", "#786215\n#125621\n#786512\n1", "#783236\n#786215\n#125621\n1", "Monday");

        assertInvalidArguments("#456236 5\n1", "#596345 1\n1", "#569812 5\n1", "Monday");
        assertInvalidArguments("#456236 7\n 3 #459362 2\n1", "#596345 9\n 5 #761136\n1", "#569812 7\n1", "Monday");
        assertInvalidArguments("0b01 2\n1", "0b11 2\n3", "0b110\n1", "Wednesday");
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

        String expectedOutput = format("%s%s%sIt is %s%n", PROMPT_NEW_YEAR, PROMPT_MONTH, PROMPT_DAY, expected);
        String expectedErrorOutput = "";

        assertConsolePrint(input, expectedOutput, expectedErrorOutput, expectedOutput, MAIN_METHOD);
    }

    /**
     * Constructs an input string from a weekday, day, and month, formatted with line breaks.
     *
     * @param dayOfStart the day of the week for the start of the year (e.g., Monday as 1)
     * @param day        the day of the month
     * @param month      the month of the year
     * @return a string containing the weekday value, month value, and day, separated by "\n"
     */
    private static String getInput(DayOfWeek dayOfStart, int day, Month month) {
        return dayOfStart.getValue() + "\n" + month.getValue() + "\n" + day;
    }

    /**
     * Asserts that the console output and error messages match the expected results for a sequence of invalid and valid
     * inputs for weekday, day, and month, simulating user interaction and validating the final result.
     *
     * @param weekday  a string of pipe-separated weekday inputs (e.g., "8\n0\n1"), where the last value is valid
     * @param day      a string of pipe-separated day inputs (e.g., "32\n0\n15"), where the last value is valid
     * @param month    a string of pipe-separated month inputs (e.g., "13\n0\n6"), where the last value is valid
     * @param expected the expected final output message (e.g., the computed day of the week)
     */
    public void assertInvalidArguments(String weekday, String day, String month, String expected) {
        int countWeekdayValues = getCount(weekday);
        int countMonthValues = getCount(month);
        int countDayValues = getCount(day);

        String invalidDayMessage = getDayWarning(month);
        String dayAttempt = invalidDayMessage + PROMPT_DAY;

        String expectedResult = String.format("It is %s%n", expected);

        String input = String.join("\n", weekday, month, day);

        String expectedOutput = PROMPT_NEW_YEAR.repeat(countWeekdayValues) + PROMPT_MONTH.repeat(countMonthValues) +
                PROMPT_DAY.repeat(countDayValues) + expectedResult;
        String expectedError = WEEKDAY_WARNING.repeat(countWeekdayValues - 1) +
                MONTH_WARNING.repeat(countMonthValues - 1) + invalidDayMessage.repeat(countDayValues - 1);
        String expectedFullOutput = PROMPT_NEW_YEAR + WEEKDAY_ATTEMPT.repeat(countWeekdayValues - 1) +
                PROMPT_MONTH + MONTH_ATTEMPT.repeat(countMonthValues - 1) + PROMPT_DAY +
                dayAttempt.repeat(countDayValues - 1) + expectedResult;

        assertConsolePrint(input, expectedOutput, expectedError, expectedFullOutput, MAIN_METHOD);
    }

    /**
     * Method counts values in input string in which "\n" uses as separator
     *
     * @param stringInput string contains input values
     * @return count of values in input string
     */
    private static int getCount(String stringInput) {
        String[] values = stringInput.split("\n");
        return values.length;
    }

    /**
     * Generates a warning message for invalid day input based on the maximum days in the specified month.
     *
     * @param monthInput string contains month input values, where the last value is assumed to be valid
     * @return a formatted warning message indicating the valid day range for the given month
     */
    private static String getDayWarning(String monthInput) {
        String[] monthValues = monthInput.split("\n");
        String validMonth = monthValues[monthValues.length - 1];
        int numberMonth = Integer.parseInt(validMonth);

        int maxDaysInMont = Month.of(numberMonth).length(false);

        return String.format(DAY_WARNING, maxDaysInMont);
    }
}
