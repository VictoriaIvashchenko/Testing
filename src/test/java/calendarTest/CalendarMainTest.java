package calendarTest;

import org.junit.jupiter.api.Test;
import calendar.CalendarMain;

import java.time.DayOfWeek;
import java.time.Month;

import static java.lang.String.format;
import static tools.ConsolePrintCheck.assertValidConsolePrint;
import static tools.ExceptionMessagesTest.*;

public class CalendarMainTest extends CalendarTest {

    String SEPARATOR = System.lineSeparator();

    @Test
    void overRangeInputTest(){
        assertInvalidDayInput("Monday", "-2147483649", "January");
        assertInvalidDayInput("Thursday", "-2147483649", "January");
        assertInvalidDayInput("Sunday", "-2147483649", "January");

        assertInvalidDayInput("Monday", "-2147483649", "June");
        assertInvalidDayInput("Thursday", "-2147483649", "June");
        assertInvalidDayInput("Sunday", "-2147483649", "June");

        assertInvalidDayInput("Monday", "-2147483649", "December");
        assertInvalidDayInput("Thursday", "-2147483649", "December");
        assertInvalidDayInput("Sunday", "-2147483649", "December");

        assertInvalidDayInput("Monday", "-2147483650", "January");
        assertInvalidDayInput("Thursday", "-2147483650", "January");
        assertInvalidDayInput("Sunday", "-2147483650", "January");

        assertInvalidDayInput("Monday", "-2147483650", "June");
        assertInvalidDayInput("Thursday", "-2147483650", "June");
        assertInvalidDayInput("Sunday", "-2147483650", "June");

        assertInvalidDayInput("Monday", "-2147483650", "December");
        assertInvalidDayInput("Thursday", "-2147483650", "December");
        assertInvalidDayInput("Sunday", "-2147483650", "December");

        assertInvalidDayInput("Monday", "2147483648", "January");
        assertInvalidDayInput("Thursday", "2147483648", "January");
        assertInvalidDayInput("Sunday", "2147483648", "January");

        assertInvalidDayInput("Monday", "2147483648", "June");
        assertInvalidDayInput("Thursday", "2147483648", "June");
        assertInvalidDayInput("Sunday", "2147483648", "June");

        assertInvalidDayInput("Monday", "2147483648", "December");
        assertInvalidDayInput("Thursday", "2147483648", "December");
        assertInvalidDayInput("Sunday", "2147483648", "December");

        assertInvalidDayInput("Monday", "2147483649", "January");
        assertInvalidDayInput("Thursday", "2147483649", "January");
        assertInvalidDayInput("Sunday", "2147483649", "January");

        assertInvalidDayInput("Monday", "2147483649", "June");
        assertInvalidDayInput("Thursday", "2147483649", "June");
        assertInvalidDayInput("Sunday", "2147483649", "June");

        assertInvalidDayInput("Monday", "2147483649", "December");
        assertInvalidDayInput("Thursday", "2147483649", "December");
        assertInvalidDayInput("Sunday", "2147483649", "December");

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
        assertInvalidDayInput("Monday", "a", "a");
        assertInvalidDayInput("Monday", "z", "z");

        assertInvalidDayInput("Monday", "A", "A");
        assertInvalidDayInput("Monday", "Z", "Z");

        assertInvalidDayInput("Monday", "a", "26");
        assertInvalidDayInput("Monday", "z", "68");

        assertInvalidDayInput("Monday", "D", "123");
        assertInvalidDayInput("Monday", "Z", "895");

        assertInvalidDayInput("Monday", "!", "!");
        assertInvalidDayInput("Monday", "#", "$");
        assertInvalidDayInput("Monday", "@", "@");

        assertInvalidDayInput("Monday", "!", "45");
        assertInvalidDayInput("Monday", "?", "88");
        assertInvalidDayInput("Monday", "@", "89");

        assertInvalidDayInput("Monday", "#364977", "#259689");
        assertInvalidDayInput("Monday", "#562111", "#136569");
        assertInvalidDayInput("Monday", "#562236", "#566846");

        assertInvalidDayInput("Monday", "#862669", "45");
        assertInvalidDayInput("Monday", "#566224", "88");
        assertInvalidDayInput("Monday", "#466256", "89");

        assertInvalidDayInput("Monday", "1 1", "71");
        assertInvalidDayInput("Monday", "e 1", "71");
        assertInvalidDayInput("Monday", "$ 1", "71");
        assertInvalidDayInput("Monday", "#111111 1", "71");
        assertInvalidDayInput("Monday", "18.23 1", "71");

    }

    @Test
    void invalidMonthTypeTest(){
        assertThrowsIllegalMonth("Monday", 1, "a");
        assertThrowsIllegalMonth("Monday", 8, "z");

        assertThrowsIllegalMonth("Monday", 1, "!");
        assertThrowsIllegalMonth("Monday", 3, "$");
        assertThrowsIllegalMonth("Monday", 4, "@");

        assertThrowsIllegalMonth("Monday", 4, "#259689");
        assertThrowsIllegalMonth("Monday", 5, "#136569");
        assertThrowsIllegalMonth("Monday", 5, "#566846");

        assertThrowsIllegalMonth("Monday", 1, "1 1");
        assertThrowsIllegalMonth("Monday", 2, "e 1");
        assertThrowsIllegalMonth("Monday", 4, "$ 1");
        assertThrowsIllegalMonth("Monday", 5, "#111111 1");
        assertThrowsIllegalMonth("Monday", 6, "18.23 1");
    }

    /**
     * Asserts that the method {@code calendar} produces the correct output when given valid input for day of the week,
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
    public void assertCalendar(String expected, DayOfWeek dayOfStart, int day, Month month){
        String input = dayOfStart + SEPARATOR + day + SEPARATOR + month;

        String expectedOutput = format(
                "Task 5. Enter number day of New Year, day and month of searching day:" + SEPARATOR +
                "It is %s" + SEPARATOR, expected);

        assertValidConsolePrint(input, expectedOutput, ()->CalendarMain.main(new String[]{}));
    }
    /**
     * Asserts that the method {@code calendar} correctly handles invalid day values by throwing an appropriate exception
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
    public void assertThrowsIllegalDayValue(DayOfWeek dayOfStart, int day, Month month){
        String input = dayOfStart + SEPARATOR + day + SEPARATOR + month;

        String expectedOutput = format(
                "Task 5. Enter number day of New Year, day and month of searching day:" + SEPARATOR +
                INVALID_VALUE_DAY_INPUT_CALENDAR_TEST.getTestMessage(), month.length(false), day);

        assertValidConsolePrint(input, expectedOutput, ()->CalendarMain.main(new String[]{}));
    }
    /**
     * Asserts that the method {@code calendar} correctly handles invalid month input by throwing an appropriate exception
     * with a message indicating the invalid month.
     *
     * <p>This method simulates user input with an invalid month and checks whether the correct error message is produced.
     * The message should indicate the invalid month input provided by the user.</p>
     *
     * @param dayOfStart the starting day of the week for the given date
     * @param day the specific day of the month to check
     * @param month the invalid month input to be tested
     */
    public void assertThrowsIllegalMonth(String dayOfStart, int day, String month){
        String input = dayOfStart + SEPARATOR + day + SEPARATOR + month;

        String expectedOutput = format(
                "Task 5. Enter number day of New Year, day and month of searching day:" + SEPARATOR +
                INVALID_VALUE_MONTH_INPUT_CALENDAR_TEST.getTestMessage(), month);

        assertValidConsolePrint(input, expectedOutput, ()->CalendarMain.main(new String[]{}));
    }
    /**
     * Asserts that the method {@code calendar} correctly handles invalid New Year input by throwing an appropriate exception
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
        String expectedOutput = format(
                "Task 5. Enter number day of New Year, day and month of searching day:" + SEPARATOR +
                INVALID_VALUE_DAY_OF_NEW_YEAR_INPUT_CALENDAR_TEST.getTestMessage(), dayOfStart);

        assertValidConsolePrint(input, expectedOutput, ()->CalendarMain.main(new String[]{}));
    }
    /**
     * Asserts that the method {@code calendar} correctly handles invalid day input by throwing an appropriate exception
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
        String expectedOutput = format(
                "Task 5. Enter number day of New Year, day and month of searching day:" + SEPARATOR +
                INVALID_TYPE_INPUT_CALENDAR_TEST.getTestMessage(), "day", day);

        assertValidConsolePrint(input, expectedOutput, ()->CalendarMain.main(new String[]{}));
    }

}
