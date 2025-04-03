package calendarTest;

import exceptions.InvalidInputException;
import org.junit.jupiter.api.Test;

import java.time.Month;

import static calendar.Calendar.calendar;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;
import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.*;
import static tools.ExceptionMessagesTest.*;

class CalendarTest {

    @Test
    void limitValuesTest() {
        //1 січня
        assertCalendar("Monday", 1, 1, 1);
        assertCalendar("Thursday", 4, 1, 1);
        assertCalendar("Sunday", 7, 1, 1);
        //сусідні точки
        assertCalendar("Tuesday",1, 2, 1);
        assertCalendar("Tuesday", 2, 1, 1);
        assertCalendar("Sunday", 7, 31, 12);

        assertCalendar("Friday", 4, 2, 1);
        assertCalendar("Friday", 5, 1, 1);
        assertCalendar("Wednesday", 3, 31, 12);

        assertCalendar("Monday", 7, 2, 1);
        assertCalendar("Saturday", 6, 31, 12);

        //граничні значення кінця першого кварталу 30 квітня
        assertCalendar("Monday", 1, 30, 4);
        assertCalendar("Thursday", 4, 30, 4);
        assertCalendar("Sunday", 7, 30, 4);

        //сусідні точки
        assertCalendar("Sunday", 1, 29, 4);

        assertCalendar("Wednesday", 4, 29, 4);

        assertCalendar("Saturday", 7, 29, 4);

        //граничні значення початку 2-о кварталу 1 травня
        assertCalendar("Tuesday", 1, 1, 5);
        assertCalendar("Friday", 4, 1, 5);
        assertCalendar("Monday", 7, 1, 5);

        //сусідні точки
        assertCalendar("Wednesday", 1, 2, 5);

        assertCalendar("Saturday", 4, 2, 5);

        assertCalendar("Tuesday", 7, 2, 5);

        //граничні значення кінця 2-o кварталу 31 серпня
        assertCalendar("Friday", 1, 31, 8);
        assertCalendar("Monday", 4, 31, 8);
        assertCalendar("Thursday", 7, 31, 8);

        //сусідні точки
        assertCalendar("Thursday", 1, 30, 8);

        assertCalendar("Sunday", 4, 30, 8);

        assertCalendar("Wednesday", 7, 30, 8);

        //граничні значення початку 3-o кварталу - 1 вересня
        assertCalendar("Saturday", 1, 1, 9);
        assertCalendar("Tuesday", 4, 1, 9);
        assertCalendar("Friday", 7, 1, 9);

        //сусідні точки
        assertCalendar("Sunday", 1, 2, 9);

        assertCalendar("Wednesday", 4, 2, 9);

        assertCalendar("Saturday", 7, 2, 9);

        //31 грудня
        assertCalendar("Monday", 1, 31, 12);
        assertCalendar("Thursday", 4, 31, 12);
        assertCalendar("Sunday", 7, 31, 12);

        //сусідні точки
        assertCalendar("Tuesday", 2, 1,1);
        assertCalendar("Saturday",7, 30, 12);

        assertCalendar("Friday", 5, 1, 1);
        assertCalendar("Wednesday", 4, 30, 12);

        assertCalendar("Saturday", 7, 30, 12);

    }

    @Test
    void mondayTest() {
        assertAllDaysInMonth("Monday", 1, 8, 1);
        assertAllDaysInMonth("Monday", 1, 5, 2);
        assertAllDaysInMonth("Monday", 1, 5, 11);
        assertAllDaysInMonth("Monday", 1, 3, 12);

        assertAllDaysInMonth("Monday", 4, 5, 1);
        assertAllDaysInMonth("Monday", 4, 2, 2);
        assertAllDaysInMonth("Monday", 4, 9, 11);
        assertAllDaysInMonth("Monday", 4, 7, 12);

        assertAllDaysInMonth("Monday", 7, 9, 1);
        assertAllDaysInMonth("Monday", 7, 6, 2);
        assertAllDaysInMonth("Monday", 7, 6, 11);
        assertAllDaysInMonth("Monday", 7, 4, 12);
    }

    @Test
    void tuesdayTest() {
        assertAllDaysInMonth("Tuesday",  1, 9, 1);
        assertAllDaysInMonth("Tuesday",  1, 6, 2);
        assertAllDaysInMonth("Tuesday",  1, 6, 11);
        assertAllDaysInMonth("Tuesday",  1, 4, 12);

        assertAllDaysInMonth("Tuesday",  4, 6, 1);
        assertAllDaysInMonth("Tuesday",  4, 3, 2);
        assertAllDaysInMonth("Tuesday",  4, 3, 11);
        assertAllDaysInMonth("Tuesday",  4, 8, 12);

        assertAllDaysInMonth("Tuesday",  7, 3, 1);
        assertAllDaysInMonth("Tuesday",  7, 7, 2);
        assertAllDaysInMonth("Tuesday",  7, 7, 11);
        assertAllDaysInMonth("Tuesday",  7, 5, 12);
    }

    @Test
    void wednesdayTest() {
        assertAllDaysInMonth("Wednesday",  1, 3, 1);
        assertAllDaysInMonth("Wednesday",  1, 7, 2);
        assertAllDaysInMonth("Wednesday",  1, 7, 11);
        assertAllDaysInMonth("Wednesday",  1, 5, 12);

        assertAllDaysInMonth("Wednesday",  4, 7, 1);
        assertAllDaysInMonth("Wednesday",  4, 4, 2);
        assertAllDaysInMonth("Wednesday",  4, 4, 11);
        assertAllDaysInMonth("Wednesday",  4, 9, 12);

        assertAllDaysInMonth("Wednesday",  7, 4, 1);
        assertAllDaysInMonth("Wednesday",  7, 1, 2);
        assertAllDaysInMonth("Wednesday",  7, 8, 11);
        assertAllDaysInMonth("Wednesday",  7, 6, 12);
    }

    @Test
    void thursdayTest() {
        assertAllDaysInMonth("Thursday",  1, 4, 1);
        assertAllDaysInMonth("Thursday",  1, 1, 2);
        assertAllDaysInMonth("Thursday",  1, 8, 11);
        assertAllDaysInMonth("Thursday",  1, 6, 12);

        assertAllDaysInMonth("Thursday",  4, 8, 1);
        assertAllDaysInMonth("Thursday",  4, 5, 2);
        assertAllDaysInMonth("Thursday",  4, 5, 11);
        assertAllDaysInMonth("Thursday",  4, 3, 12);

        assertAllDaysInMonth("Thursday",  7, 5, 1);
        assertAllDaysInMonth("Thursday",  7, 2, 2);
        assertAllDaysInMonth("Thursday",  7, 9, 11);
        assertAllDaysInMonth("Thursday",  7, 7, 12);
    }

    @Test
    void fridayTest() {
        assertAllDaysInMonth("Friday",  1, 5, 1);
        assertAllDaysInMonth("Friday",  1, 2, 2);
        assertAllDaysInMonth("Friday",  1, 9, 11);
        assertAllDaysInMonth("Friday",  1, 7, 12);

        assertAllDaysInMonth("Friday",  4, 9, 1);
        assertAllDaysInMonth("Friday",  4, 6, 2);
        assertAllDaysInMonth("Friday",  4, 6, 11);
        assertAllDaysInMonth("Friday",  4, 4, 12);

        assertAllDaysInMonth("Friday",  7, 6, 1);
        assertAllDaysInMonth("Friday",  7, 3, 2);
        assertAllDaysInMonth("Friday",  7, 3, 11);
        assertAllDaysInMonth("Friday",  7, 8, 12);
    }

    @Test
    void saturdayTest() {
        assertAllDaysInMonth("Saturday",  1, 6, 1);
        assertAllDaysInMonth("Saturday",  1, 3, 2);
        assertAllDaysInMonth("Saturday",  1, 3, 11);
        assertAllDaysInMonth("Saturday",  1, 8, 12);

        assertAllDaysInMonth("Saturday",  4, 3, 1);
        assertAllDaysInMonth("Saturday",  4, 7, 2);
        assertAllDaysInMonth("Saturday",  4, 7, 11);
        assertAllDaysInMonth("Saturday",  4, 5, 12);

        assertAllDaysInMonth("Saturday",  7, 7, 1);
        assertAllDaysInMonth("Saturday",  7, 4, 2);
        assertAllDaysInMonth("Saturday",  7, 4, 11);
        assertAllDaysInMonth("Saturday",  7, 9, 12);
    }

    @Test
    void sundayTest() {
        assertAllDaysInMonth("Sunday",  1, 7, 1);
        assertAllDaysInMonth("Sunday",  1, 4, 2);
        assertAllDaysInMonth("Sunday",  1, 4, 11);
        assertAllDaysInMonth("Sunday",  1, 9, 12);

        assertAllDaysInMonth("Sunday",  4, 4, 1);
        assertAllDaysInMonth("Sunday",  4, 1, 2);
        assertAllDaysInMonth("Sunday",  4, 8, 11);
        assertAllDaysInMonth("Sunday",  4, 6, 12);

        assertAllDaysInMonth("Sunday",  7, 8, 1);
        assertAllDaysInMonth("Sunday",  7, 5, 2);
        assertAllDaysInMonth("Sunday",  7, 5, 11);
        assertAllDaysInMonth("Sunday",  7, 3, 12);
    }

    @Test
    void subjectArea() {
        assertCalendar("Saturday", 1, 6, 1);
        assertCalendar("Tuesday", 2, 22, 1);
        assertCalendar("Tuesday", 3, 25, 3);
        assertCalendar("Saturday", 5, 8, 5);
        assertCalendar("Friday", 6, 14, 10);
        assertCalendar("Tuesday", 7, 19, 12);
        assertCalendar("Wednesday", 2, 25, 12);
        assertCalendar("Thursday", 5, 14, 10);
        assertCalendar("Sunday", 3, 13, 4);
        assertCalendar("Friday", 2, 11, 10);
    }

    @Test
    void invalidInputDayTest(){
        assertInvalidDayInMonth(1, 32, 1);
        assertInvalidDayInMonth(1, 29, 2);
        assertInvalidDayInMonth(1, 32, 3);
        assertInvalidDayInMonth(1, 31, 4);
        assertInvalidDayInMonth(1, 32, 5);
        assertInvalidDayInMonth(1, 31, 6);
        assertInvalidDayInMonth(1, 32, 7);
        assertInvalidDayInMonth(1, 32, 8);
        assertInvalidDayInMonth(1, 31, 9);
        assertInvalidDayInMonth(1, 32, 10);
        assertInvalidDayInMonth(1, 31, 11);
        assertInvalidDayInMonth(1, 32, 12);
    }

    @Test
    void invalidDayOfNewYearTest(){
        assertThrowsIllegalDayOfNewYearValue(8, 1, 1);
        assertThrowsIllegalDayOfNewYearValue(9, 1, 1);
        assertThrowsIllegalDayOfNewYearValue(MAX_VALUE - 1, 1, 1);
        assertThrowsIllegalDayOfNewYearValue(MAX_VALUE, 1, 1);

        assertThrowsIllegalDayOfNewYearValue(0, 1, 1);
        assertThrowsIllegalDayOfNewYearValue(-1, 1, 1);
        assertThrowsIllegalDayOfNewYearValue(MIN_VALUE + 1, 1, 1);
        assertThrowsIllegalDayOfNewYearValue(MIN_VALUE, 1, 1);
    }

    @Test
    void invalidMonthTest(){
        assertThrowsIllegalMonthValue(1, 1, 13);
        assertThrowsIllegalMonthValue(1, 1, 14);
        assertThrowsIllegalMonthValue(1, 1, MAX_VALUE - 1);
        assertThrowsIllegalMonthValue(1, 1, MAX_VALUE);

        assertThrowsIllegalMonthValue(1, 1, 0);
        assertThrowsIllegalMonthValue(1, 1, -1);
        assertThrowsIllegalMonthValue(1, 1, MIN_VALUE + 1);
        assertThrowsIllegalMonthValue(1, 1, MIN_VALUE);
    }

    @Test
    void specialValues() {
        assertCalendar("Sunday", 3, 20, 7);
        assertCalendar("Monday", 4, 13, 7);
        assertCalendar("Monday", 2, 18, 11);
        assertCalendar("Friday", 4, 15, 5);
        assertCalendar("Wednesday", 2, 21, 8);
        assertCalendar("Monday", 5, 21, 6);
        assertCalendar("Sunday", 1, 20, 5);
        assertCalendar("Tuesday", 2, 13, 8);
        assertCalendar("Saturday", 3, 11, 10);
        assertCalendar("Wednesday", 4, 14, 1);
        assertCalendar("Friday", 7, 21, 7);
        assertCalendar("Saturday", 7, 14, 10);
    }

    @Test
    void randomValues() {
        assertCalendar("Tuesday", 3, 15, 4);
        assertCalendar("Thursday", 7, 16, 11);
        assertCalendar("Tuesday", 6, 20, 9);
        assertCalendar("Wednesday", 3, 10, 12);
        assertCalendar("Sunday", 5, 14, 2);
        assertCalendar("Friday", 4, 11, 9);
        assertCalendar("Saturday", 6, 22, 10);
        assertCalendar("Sunday", 1, 17, 6);
        assertCalendar("Wednesday", 3, 16, 4);
        assertCalendar("Monday", 2, 18, 2);
    }

    /**
     * Asserts that the method {@link calendar} correctly calculates the day of the week for all occurrences of a particular day
     * in a month, starting from a given day.
     *
     * <p>This method tests the behavior of the {@link calendar} method for multiple days within the same month. It checks
     * if the method returns the correct weekday for the given day and subsequent days in the same month (e.g., 7 days apart).</p>
     *
     * @param expected the expected weekday name (e.g., "Monday", "Tuesday", etc.)
     * @param dayOfStart the starting day of the week for the given date
     * @param day the starting day of the month
     * @param month the month in which the days are being checked
     */
    public void assertAllDaysInMonth(String expected, int dayOfStart, int day, int month){
        assertCalendar(expected, dayOfStart, day, month);
        assertCalendar(expected, dayOfStart, day + 7, month);
        assertCalendar(expected, dayOfStart, day + 14, month);
        assertCalendar(expected, dayOfStart, day + 21, month);
    }

    /**
     * Asserts that the method {@link calendar} correctly calculates the day of the week for a given day in a specific month.
     *
     * <p>This method tests the behavior of the {@link calendar} method by comparing its output to the expected weekday for a
     * specific day in a month. It ensures that the {@link calendar} method returns the correct weekday name based on the
     * provided start day and date.</p>
     *
     * @param expected the expected weekday name (e.g., "Monday", "Tuesday", etc.)
     * @param dayOfStart the starting day of the week for the given date
     * @param day the specific day of the month to check
     * @param month the month in which the day is located
     */
    public void assertCalendar(String expected, int dayOfStart, int day, int month) {
        try{
            assertEquals(expected, calendar(dayOfStart, day, month));
        }catch (InvalidInputException e){
            fail("Expected no InvalidInputException, but got one.");
        }
    }

    /**
     * Asserts that the method {@link calendar} correctly throws an {@link InvalidInputException} for illegal day values
     * in a given month.
     *
     * <p>This method tests various boundary cases and invalid day values to ensure that the {@link calendar} method correctly
     * handles cases where the day value is out of range (either too large or too small) for the given month.</p>
     *
     * @param dayOfStart the starting day of the week for the given date
     * @param day the specific day of the month to check
     * @param month the month in which the day is located
     */
    public void assertInvalidDayInMonth(int dayOfStart, int day, int month){
        assertThrowsIllegalDayValue(dayOfStart, day, month);
        assertThrowsIllegalDayValue(dayOfStart, day + 1, month);
        assertThrowsIllegalDayValue(dayOfStart, MAX_VALUE - 1, month);
        assertThrowsIllegalDayValue(dayOfStart, MAX_VALUE, month);

        assertThrowsIllegalDayValue(dayOfStart, 0, month);
        assertThrowsIllegalDayValue(dayOfStart, -1, month);
        assertThrowsIllegalDayValue(dayOfStart, MIN_VALUE + 1, month);
        assertThrowsIllegalDayValue(dayOfStart, MIN_VALUE, month);
    }
    /**
     * Asserts that the method {@link calendar} throws an {@link InvalidInputException} with the correct message for
     * a given invalid day value in a specific month.
     *
     * <p>This method tests that the program throws an exception when provided with an out-of-range day value for the
     * specified month. It checks if the exception message matches the expected format, which includes the maximum allowed
     * day value for the month.</p>
     *
     * @param dayOfStart the starting day of the week for the given date
     * @param day the specific day of the month (invalid)
     * @param month the month in which the day is located
     */
    public void assertThrowsIllegalDayValue(int dayOfStart, int day, int month){
        int daysInMonth = Month.of(month).length(false);
        String expectedMessage = format(INVALID_VALUE_DAY_INPUT_CALENDAR_TEST.getTestMessage(),
                daysInMonth, day);

        assertThrowsInvalidArgument(dayOfStart, day, month, expectedMessage);
    }
    /**
     * Asserts that the method {@link calendar} throws an {@link InvalidInputException} with the correct message for
     * a given invalid value of weekday of New Year.
     *
     * <p>This method tests that the program throws an exception when provided with an out-of-range day of week value.
     * It checks if the exception message matches the expected format, which includes user's invalid input.</p>
     *
     * @param dayOfStart the starting day of the week for the given date (invalid)
     * @param day the specific day of the month
     * @param month the month in which the day is located
     */
    public void assertThrowsIllegalDayOfNewYearValue(int dayOfStart, int day, int month){
        String expectedMessage = format(INVALID_VALUE_DAY_OF_NEW_YEAR_INPUT_CALENDAR_TEST.getTestMessage(), dayOfStart);

        assertThrowsInvalidArgument(dayOfStart, day, month, expectedMessage);
    }

    /**
     * Asserts that the method {@link calendar} throws an {@link InvalidInputException} with the correct message for
     * a given invalid number of month value.
     *
     * <p>This method tests that the program throws an exception when provided with an out-of-range month value.
     * It checks if the exception message matches the expected format, which includes user's invalid input.</p>
     *
     * @param dayOfStart the starting day of the week for the given date
     * @param day the specific day of the month
     * @param month the month in which the day is located (invalid)
     */
    public void assertThrowsIllegalMonthValue(int dayOfStart, int day, int month){
        String expectedMessage = format(INVALID_VALUE_MONTH_INPUT_CALENDAR_TEST.getTestMessage(), month);

        assertThrowsInvalidArgument(dayOfStart, day, month, expectedMessage);
    }

    /**
     * Asserts that the method {@link calendar} throws an {@link InvalidInputException} with the expected message for
     * an invalid day value in the given month.
     *
     * <p>This method checks that when the program encounters an invalid day of the month, it throws an exception with
     * the correct message. The message is verified to ensure that it accurately reflects the invalid day input.</p>
     *
     * @param dayOfStart the starting day of the week for the given date
     * @param day the specific day of the month to check
     * @param month the month in which the day is located
     * @param expectedMessage the expected exception message
     */
    public void assertThrowsInvalidArgument(int dayOfStart, int day, int month, String expectedMessage){
        try{
            calendar(dayOfStart, day, month);
            fail("Expected InvalidInputException to be thrown.");
        }catch (InvalidInputException e){
            assertEquals(expectedMessage, e.getMessage());
        }
    }

}