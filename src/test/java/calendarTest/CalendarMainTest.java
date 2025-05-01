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
        assertInvalidArguments("8|1", "32|1", "13|1", "Monday");
        assertInvalidArguments("8|9|1", "29|30|1", "13|14|2", "Thursday");
        assertInvalidArguments("8|9|10|1", "31|32|33|1", "13|14|15|4", "Sunday");
        assertInvalidArguments("8|9|10|11|1", "32|33|34|35|1", "13|14|15|16|1", "Monday");

        assertInvalidArguments("2147483648|1", "2147483648|1", "2147483648|1", "Monday");
        assertInvalidArguments("2147483648|2147483649|1", "2147483648|2147483649|1", "2147483648|2147483649|1", "Monday");
        assertInvalidArguments("2147483648|2147483649|2147483650|1", "2147483648|2147483649|2147483650|1", "2147483648|2147483649|2147483650|1", "Monday");
        assertInvalidArguments("2147483648|2147483649|2147483650|2147483651|1", "2147483648|2147483649|2147483650|2147483651|1", "2147483648|2147483649|2147483650|2147483651|1", "Monday");

        assertInvalidArguments("0|1", "0|1", "0|1", "Monday");
        assertInvalidArguments("0|-1|1", "0|-1|1", "0|-1|1", "Monday");
        assertInvalidArguments("0|-1|-2|1", "0|-1|-2|1", "0|-1|-2|1", "Monday");
        assertInvalidArguments("0|-1|-2|-3|1", "0|-1|-2|-3|1", "0|-1|-2|-3|1", "Monday");

        assertInvalidArguments("-2147483649|1", "-2147483649|1", "-2147483649|1", "Monday");
        assertInvalidArguments("-2147483649|-2147483650|1", "-2147483649|-2147483650|1", "-2147483649|-2147483650|1", "Monday");
        assertInvalidArguments("-2147483649|-2147483650|-2147483651|1", "-2147483649|-2147483650|-2147483651|1", "-2147483649|-2147483650|-2147483651|1", "Monday");
        assertInvalidArguments("-2147483649|-2147483650|-2147483651|-2147483652|1", "-2147483649|-2147483650|-2147483651|-2147483652|1", "-2147483649|-2147483650|-2147483651|-2147483652|1", "Monday");
    }

    @Test
    void characterInputTest() {
        assertInvalidArguments("a|1", "a|1", "a|1", "Monday");
        assertInvalidArguments("z|1", "z|1", "z|1", "Monday");

        assertInvalidArguments("a|b|1", "a|b|1", "a|b|1", "Monday");
        assertInvalidArguments("a|b|c|1", "a|b|c|1", "a|b|c|1", "Monday");
        assertInvalidArguments("a|b|c|d|1", "a|b|c|d|1", "a|b|c|d|1", "Monday");

        assertInvalidArguments("z|y|1", "z|y|1", "z|y|1", "Monday");
        assertInvalidArguments("z|y|x|1", "z|y|x|1", "z|y|x|1", "Monday");
        assertInvalidArguments("z|y|x|w|1", "z|y|x|w|1", "z|y|x|w|1", "Monday");

        assertInvalidArguments("A|1", "A|1", "A|1", "Monday");
        assertInvalidArguments("Z|1", "Z|1", "Z|1", "Monday");

        assertInvalidArguments("A|B|1", "A|B|1", "A|B|1", "Monday");
        assertInvalidArguments("A|B|C|1", "A|B|C|1", "A|B|C|1", "Monday");
        assertInvalidArguments("A|B|C|D|1", "A|B|C|D|1", "A|B|C|D|1", "Monday");

        assertInvalidArguments("Z|Y|1", "Z|Y|1", "Z|Y|1", "Monday");
        assertInvalidArguments("Z|Y|X|1", "Z|Y|X|1", "Z|Y|X|1", "Monday");
        assertInvalidArguments("Z|Y|X|W|1", "Z|Y|X|W|1", "Z|Y|X|W|1", "Monday");

        assertInvalidArguments("a 1|1", "3 f|1", "4 f|1", "Monday");
        assertInvalidArguments("b 1|2 f|1", "3 f|zero 2|1", "4 f|one 1|1", "Monday");

        assertInvalidArguments("!|1", "!|1", "!|1", "Monday");
        assertInvalidArguments("@|!|1", "@|!|1", "@|!|1", "Monday");
        assertInvalidArguments("!|@|#|1", "!|@|#|1", "!|@|#|1", "Monday");

        assertInvalidArguments("3%|1", "5$|1", "2^2|1", "Monday");
        assertInvalidArguments("2@ 3|4$|5+1|1", "4$ 6|7^ 1|1", "13 1|1", "Monday");
    }

    @Test
    void invalidNumericTypeTest() {
        assertInvalidArguments("1.3|1", "34.5|1", "21.4|1", "Monday");
        assertInvalidArguments("587.57|0.56|1", "34.5|0.46|1", "21.4|0.48|1", "Monday");
        assertInvalidArguments("57.39|0.4|-15.22|1", "34.5|0.465|-464.2|1", "21.4|0.26|-12.5|1", "Monday");
        assertInvalidArguments("1.3|0.45|-5.23|.45|1", "34.5|0.45|-5.23|.45|1", "21.4|0.45|-5.23|.45|1", "Monday");

        assertInvalidArguments("1.3 1|1", "45.56 2|1", "5.5 5|1", "Monday");
        assertInvalidArguments("1L 1|45.5|1", "-411.4 2|1", "-0.12 5|455.1|1", "Monday");
        assertInvalidArguments("1.3 1|584.45 5|1", "45.56 2|430.1 12|1", "5.5 5|54.5|1", "Monday");

        assertInvalidArguments("#456236|1", "#596345|1", "#569812|1", "Monday");
        assertInvalidArguments("#786215|#125621|1", "#786215|#125621|1", "#786215|#125621|1", "Monday");
        assertInvalidArguments("#786215|#125621|#896546|1", "#786215|#125621|#786512|1", "#783236|#786215|#125621|1", "Monday");

        assertInvalidArguments("#456236 5|1", "#596345 1|1", "#569812 5|1", "Monday");
        assertInvalidArguments("#456236 7|1", "#596345 9|1", "#569812 7|1", "Monday");

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
     * @return a string containing the weekday value, month value, and day, separated by line breaks
     */
    private static String getInput(DayOfWeek dayOfStart, int day, Month month) {
        return dayOfStart.getValue() + LINE_BREAK + month.getValue() + LINE_BREAK + day;
    }

    /**
     * Asserts that the console output and error messages match the expected results for a sequence of invalid and valid
     * inputs for weekday, day, and month, simulating user interaction and validating the final result.
     *
     * @param weekday  a string of pipe-separated weekday inputs (e.g., "8|0|1"), where the last value is valid
     * @param day      a string of pipe-separated day inputs (e.g., "32|0|15"), where the last value is valid
     * @param month    a string of pipe-separated month inputs (e.g., "13|0|6"), where the last value is valid
     * @param expected the expected final output message (e.g., the computed day of the week)
     */
    public void assertInvalidArguments(String weekday, String day, String month, String expected) {
        String[] weekdayInput = weekday.split("\\|");
        String[] monthInput = month.split("\\|");
        String[] dayInput = day.split("\\|");

        int countWeekdayValues = weekdayInput.length;
        int countMonthValues = monthInput.length;
        int countDayValues = dayInput.length;

        String invalidDayMessage = getDayWarning(monthInput);
        String dayAttempt = invalidDayMessage + PROMPT_DAY;

        String expectedResult = String.format("It is %s%n", expected);

        String input = getInput(weekdayInput, dayInput, monthInput);

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
     * Constructs a single input string by combining arrays of weekday, day, and month inputs, separated by line breaks.
     *
     * @param weekdayInput array of weekday input values
     * @param dayInput     array of day input values
     * @param monthInput   array of month input values
     * @return a string containing all input values concatenated with line breaks
     */
    private static String getInput(String[] weekdayInput, String[] dayInput, String[] monthInput) {
        String weekdayValues = String.join(LINE_BREAK, weekdayInput);
        String monthValues = String.join(LINE_BREAK, monthInput);
        String dayValues = String.join(LINE_BREAK, dayInput);

        return weekdayValues + LINE_BREAK + monthValues + LINE_BREAK + dayValues;
    }

    /**
     * Generates a warning message for invalid day input based on the maximum days in the specified month.
     *
     * @param monthInput array of month input values, where the last value is assumed to be valid
     * @return a formatted warning message indicating the valid day range for the given month
     */
    private static String getDayWarning(String[] monthInput) {
        String validMonth = monthInput[monthInput.length - 1];
        int numberMonth = Integer.parseInt(validMonth);

        int maxDaysInMont = Month.of(numberMonth).length(false);

        return String.format(DAY_WARNING, maxDaysInMont);
    }
}
