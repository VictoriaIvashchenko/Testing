package calendarTest;

import exceptions.InvalidInputException;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.Month;

import static calendar.Calendar.calendar;

import static java.time.DayOfWeek.*;
import static java.time.Month.*;
import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;
import static org.junit.jupiter.api.Assertions.*;

class CalendarTest {

    /** Error message for an invalid day input in calendar calculations. */
    protected final static String INVALID_VALUE_DAY_INPUT_CALENDAR_TEST =
            "Invalid input number of day. Number from 1 to %d was expected, but '%d' was received.";

    @Test
    void limitValuesTest() {
        //1 січня
        assertCalendar("Monday", MONDAY, 1, JANUARY);
        assertCalendar("Thursday", THURSDAY, 1, JANUARY);
        assertCalendar("Sunday", SUNDAY, 1, JANUARY);
        //сусідні точки
        assertCalendar("Tuesday",MONDAY, 2, JANUARY);
        assertCalendar("Tuesday", TUESDAY, 1, JANUARY);
        assertCalendar("Sunday", SUNDAY, 31, DECEMBER);

        assertCalendar("Friday", THURSDAY, 2, JANUARY);
        assertCalendar("Friday", FRIDAY, 1, JANUARY);
        assertCalendar("Wednesday", WEDNESDAY, 31, DECEMBER);

        assertCalendar("Monday", SUNDAY, 2, JANUARY);
        assertCalendar("Saturday", SATURDAY, 31, DECEMBER);

        //граничні значення кінця першого кварталу 30 квітня
        assertCalendar("Monday", MONDAY, 30, APRIL);
        assertCalendar("Thursday", THURSDAY, 30, APRIL);
        assertCalendar("Sunday", SUNDAY, 30, APRIL);

        //сусідні точки
        assertCalendar("Sunday", MONDAY, 29, APRIL);

        assertCalendar("Wednesday", THURSDAY, 29, APRIL);

        assertCalendar("Saturday", SUNDAY, 29, APRIL);

        //граничні значення початку 2-о кварталу 1 травня
        assertCalendar("Tuesday", MONDAY, 1, MAY);
        assertCalendar("Friday", THURSDAY, 1, MAY);
        assertCalendar("Monday", SUNDAY, 1, MAY);

        //сусідні точки
        assertCalendar("Wednesday", MONDAY, 2, MAY);

        assertCalendar("Saturday", THURSDAY, 2, MAY);

        assertCalendar("Tuesday", SUNDAY, 2, MAY);

        //граничні значення кінця 2-o кварталу 31 серпня
        assertCalendar("Friday", MONDAY, 31, AUGUST);
        assertCalendar("Monday", THURSDAY, 31, AUGUST);
        assertCalendar("Thursday", SUNDAY, 31, AUGUST);

        //сусідні точки
        assertCalendar("Thursday", MONDAY, 30, AUGUST);

        assertCalendar("Sunday", THURSDAY, 30, AUGUST);

        assertCalendar("Wednesday", SUNDAY, 30, AUGUST);

        //граничні значення початку 3-o кварталу - 1 вересня
        assertCalendar("Saturday", MONDAY, 1, SEPTEMBER);
        assertCalendar("Tuesday", THURSDAY, 1, SEPTEMBER);
        assertCalendar("Friday", SUNDAY, 1, SEPTEMBER);

        //сусідні точки
        assertCalendar("Sunday", MONDAY, 2, SEPTEMBER);

        assertCalendar("Wednesday", THURSDAY, 2, SEPTEMBER);

        assertCalendar("Saturday", SUNDAY, 2, SEPTEMBER);

        //31 грудня
        assertCalendar("Monday", MONDAY, 31, DECEMBER);
        assertCalendar("Thursday", THURSDAY, 31, DECEMBER);
        assertCalendar("Sunday", SUNDAY, 31, DECEMBER);

        //сусідні точки
        assertCalendar("Tuesday", TUESDAY, 1,JANUARY);
        assertCalendar("Saturday",SUNDAY, 30, DECEMBER);

        assertCalendar("Friday", FRIDAY, 1, JANUARY);
        assertCalendar("Wednesday", THURSDAY, 30, DECEMBER);

        assertCalendar("Saturday", SUNDAY, 30, DECEMBER);

    }

    @Test
    void mondayTest() {
        assertAllDaysInMonth("Monday", MONDAY, 8, JANUARY);
        assertAllDaysInMonth("Monday", MONDAY, 5, FEBRUARY);
        assertAllDaysInMonth("Monday", MONDAY, 5, NOVEMBER);
        assertAllDaysInMonth("Monday", MONDAY, 3, DECEMBER);

        assertAllDaysInMonth("Monday", THURSDAY, 5, JANUARY);
        assertAllDaysInMonth("Monday", THURSDAY, 2, FEBRUARY);
        assertAllDaysInMonth("Monday", THURSDAY, 9, NOVEMBER);
        assertAllDaysInMonth("Monday", THURSDAY, 7, DECEMBER);

        assertAllDaysInMonth("Monday", SUNDAY, 9, JANUARY);
        assertAllDaysInMonth("Monday", SUNDAY, 6, FEBRUARY);
        assertAllDaysInMonth("Monday", SUNDAY, 6, NOVEMBER);
        assertAllDaysInMonth("Monday", SUNDAY, 4, DECEMBER);
    }

    @Test
    void tuesdayTest() {
        assertAllDaysInMonth("Tuesday",  MONDAY, 9, JANUARY);
        assertAllDaysInMonth("Tuesday",  MONDAY, 6, FEBRUARY);
        assertAllDaysInMonth("Tuesday",  MONDAY, 6, NOVEMBER);
        assertAllDaysInMonth("Tuesday",  MONDAY, 4, DECEMBER);

        assertAllDaysInMonth("Tuesday",  THURSDAY, 6, JANUARY);
        assertAllDaysInMonth("Tuesday",  THURSDAY, 3, FEBRUARY);
        assertAllDaysInMonth("Tuesday",  THURSDAY, 3, NOVEMBER);
        assertAllDaysInMonth("Tuesday",  THURSDAY, 8, DECEMBER);

        assertAllDaysInMonth("Tuesday",  SUNDAY, 3, JANUARY);
        assertAllDaysInMonth("Tuesday",  SUNDAY, 7, FEBRUARY);
        assertAllDaysInMonth("Tuesday",  SUNDAY, 7, NOVEMBER);
        assertAllDaysInMonth("Tuesday",  SUNDAY, 5, DECEMBER);
    }

    @Test
    void wednesdayTest() {
        assertAllDaysInMonth("Wednesday",  MONDAY, 3, JANUARY);
        assertAllDaysInMonth("Wednesday",  MONDAY, 7, FEBRUARY);
        assertAllDaysInMonth("Wednesday",  MONDAY, 7, NOVEMBER);
        assertAllDaysInMonth("Wednesday",  MONDAY, 5, DECEMBER);

        assertAllDaysInMonth("Wednesday",  THURSDAY, 7, JANUARY);
        assertAllDaysInMonth("Wednesday",  THURSDAY, 4, FEBRUARY);
        assertAllDaysInMonth("Wednesday",  THURSDAY, 4, NOVEMBER);
        assertAllDaysInMonth("Wednesday",  THURSDAY, 9, DECEMBER);

        assertAllDaysInMonth("Wednesday",  SUNDAY, 4, JANUARY);
        assertAllDaysInMonth("Wednesday",  SUNDAY, 1, FEBRUARY);
        assertAllDaysInMonth("Wednesday",  SUNDAY, 8, NOVEMBER);
        assertAllDaysInMonth("Wednesday",  SUNDAY, 6, DECEMBER);
    }

    @Test
    void thursdayTest() {
        assertAllDaysInMonth("Thursday",  MONDAY, 4, JANUARY);
        assertAllDaysInMonth("Thursday",  MONDAY, 1, FEBRUARY);
        assertAllDaysInMonth("Thursday",  MONDAY, 8, NOVEMBER);
        assertAllDaysInMonth("Thursday",  MONDAY, 6, DECEMBER);

        assertAllDaysInMonth("Thursday",  THURSDAY, 8, JANUARY);
        assertAllDaysInMonth("Thursday",  THURSDAY, 5, FEBRUARY);
        assertAllDaysInMonth("Thursday",  THURSDAY, 5, NOVEMBER);
        assertAllDaysInMonth("Thursday",  THURSDAY, 3, DECEMBER);

        assertAllDaysInMonth("Thursday",  SUNDAY, 5, JANUARY);
        assertAllDaysInMonth("Thursday",  SUNDAY, 2, FEBRUARY);
        assertAllDaysInMonth("Thursday",  SUNDAY, 9, NOVEMBER);
        assertAllDaysInMonth("Thursday",  SUNDAY, 7, DECEMBER);
    }

    @Test
    void fridayTest() {
        assertAllDaysInMonth("Friday",  MONDAY, 5, JANUARY);
        assertAllDaysInMonth("Friday",  MONDAY, 2, FEBRUARY);
        assertAllDaysInMonth("Friday",  MONDAY, 9, NOVEMBER);
        assertAllDaysInMonth("Friday",  MONDAY, 7, DECEMBER);

        assertAllDaysInMonth("Friday",  THURSDAY, 9, JANUARY);
        assertAllDaysInMonth("Friday",  THURSDAY, 6, FEBRUARY);
        assertAllDaysInMonth("Friday",  THURSDAY, 6, NOVEMBER);
        assertAllDaysInMonth("Friday",  THURSDAY, 4, DECEMBER);

        assertAllDaysInMonth("Friday",  SUNDAY, 6, JANUARY);
        assertAllDaysInMonth("Friday",  SUNDAY, 3, FEBRUARY);
        assertAllDaysInMonth("Friday",  SUNDAY, 3, NOVEMBER);
        assertAllDaysInMonth("Friday",  SUNDAY, 8, DECEMBER);
    }

    @Test
    void saturdayTest() {
        assertAllDaysInMonth("Saturday",  MONDAY, 6, JANUARY);
        assertAllDaysInMonth("Saturday",  MONDAY, 3, FEBRUARY);
        assertAllDaysInMonth("Saturday",  MONDAY, 3, NOVEMBER);
        assertAllDaysInMonth("Saturday",  MONDAY, 8, DECEMBER);

        assertAllDaysInMonth("Saturday",  THURSDAY, 3, JANUARY);
        assertAllDaysInMonth("Saturday",  THURSDAY, 7, FEBRUARY);
        assertAllDaysInMonth("Saturday",  THURSDAY, 7, NOVEMBER);
        assertAllDaysInMonth("Saturday",  THURSDAY, 5, DECEMBER);

        assertAllDaysInMonth("Saturday",  SUNDAY, 7, JANUARY);
        assertAllDaysInMonth("Saturday",  SUNDAY, 4, FEBRUARY);
        assertAllDaysInMonth("Saturday",  SUNDAY, 4, NOVEMBER);
        assertAllDaysInMonth("Saturday",  SUNDAY, 9, DECEMBER);
    }

    @Test
    void sundayTest() {
        assertAllDaysInMonth("Sunday",  MONDAY, 7, JANUARY);
        assertAllDaysInMonth("Sunday",  MONDAY, 4, FEBRUARY);
        assertAllDaysInMonth("Sunday",  MONDAY, 4, NOVEMBER);
        assertAllDaysInMonth("Sunday",  MONDAY, 9, DECEMBER);

        assertAllDaysInMonth("Sunday",  THURSDAY, 4, JANUARY);
        assertAllDaysInMonth("Sunday",  THURSDAY, 1, FEBRUARY);
        assertAllDaysInMonth("Sunday",  THURSDAY, 8, NOVEMBER);
        assertAllDaysInMonth("Sunday",  THURSDAY, 6, DECEMBER);

        assertAllDaysInMonth("Sunday",  SUNDAY, 8, JANUARY);
        assertAllDaysInMonth("Sunday",  SUNDAY, 5, FEBRUARY);
        assertAllDaysInMonth("Sunday",  SUNDAY, 5, NOVEMBER);
        assertAllDaysInMonth("Sunday",  SUNDAY, 3, DECEMBER);
    }

    @Test
    void subjectArea() {
        assertCalendar("Saturday", MONDAY, 6, JANUARY);
        assertCalendar("Tuesday", TUESDAY, 22, JANUARY);
        assertCalendar("Tuesday", WEDNESDAY, 25, MARCH);
        assertCalendar("Saturday", FRIDAY, 8, MAY);
        assertCalendar("Friday", SATURDAY, 14, OCTOBER);
        assertCalendar("Tuesday", SUNDAY, 19, DECEMBER);
        assertCalendar("Wednesday", TUESDAY, 25, DECEMBER);
        assertCalendar("Thursday", FRIDAY, 14, OCTOBER);
        assertCalendar("Sunday", WEDNESDAY, 13, APRIL);
        assertCalendar("Friday", TUESDAY, 11, OCTOBER);
    }

    @Test
    void invalidInputDayTest(){
        assertInvalidDayInMonth(MONDAY, 32, JANUARY);
        assertInvalidDayInMonth(MONDAY, 29, FEBRUARY);
        assertInvalidDayInMonth(MONDAY, 32, MARCH);
        assertInvalidDayInMonth(MONDAY, 31, APRIL);
        assertInvalidDayInMonth(MONDAY, 32, MAY);
        assertInvalidDayInMonth(MONDAY, 31, JUNE);
        assertInvalidDayInMonth(MONDAY, 32, JULY);
        assertInvalidDayInMonth(MONDAY, 32, AUGUST);
        assertInvalidDayInMonth(MONDAY, 31, SEPTEMBER);
        assertInvalidDayInMonth(MONDAY, 32, OCTOBER);
        assertInvalidDayInMonth(MONDAY, 31, NOVEMBER);
        assertInvalidDayInMonth(MONDAY, 32, DECEMBER);
    }

    @Test
    void specialValues() {
        assertCalendar("Sunday", WEDNESDAY, 20, JULY);
        assertCalendar("Monday", THURSDAY, 13, JULY);
        assertCalendar("Monday", TUESDAY, 18, NOVEMBER);
        assertCalendar("Friday", THURSDAY, 15, MAY);
        assertCalendar("Wednesday", TUESDAY, 21, AUGUST);
        assertCalendar("Monday", FRIDAY, 21, JUNE);
        assertCalendar("Sunday", MONDAY, 20, MAY);
        assertCalendar("Tuesday", TUESDAY, 13, AUGUST);
        assertCalendar("Saturday", WEDNESDAY, 11, OCTOBER);
        assertCalendar("Wednesday", THURSDAY, 14, JANUARY);
        assertCalendar("Friday", SUNDAY, 21, JULY);
        assertCalendar("Saturday", SUNDAY, 14, OCTOBER);
    }

    @Test
    void randomValues() {
        assertCalendar("Tuesday", WEDNESDAY, 15, APRIL);
        assertCalendar("Thursday", SUNDAY, 16, NOVEMBER);
        assertCalendar("Tuesday", SATURDAY, 20, SEPTEMBER);
        assertCalendar("Wednesday", WEDNESDAY, 10, DECEMBER);
        assertCalendar("Sunday", FRIDAY, 14, FEBRUARY);
        assertCalendar("Friday", THURSDAY, 11, SEPTEMBER);
        assertCalendar("Saturday", SATURDAY, 22, OCTOBER);
        assertCalendar("Sunday", MONDAY, 17, JUNE);
        assertCalendar("Wednesday", WEDNESDAY, 16, APRIL);
        assertCalendar("Monday", TUESDAY, 18, FEBRUARY);
    }
    /**
     * Asserts that the method {@code calendar} correctly calculates the day of the week for all occurrences of a particular day
     * in a month, starting from a given day.
     *
     * <p>This method tests the behavior of the {@code calendar} method for multiple days within the same month. It checks
     * if the method returns the correct weekday for the given day and subsequent days in the same month (e.g., 7 days apart).</p>
     *
     * @param expected the expected weekday name (e.g., "Monday", "Tuesday", etc.)
     * @param dayOfStart the starting day of the week for the given date
     * @param day the starting day of the month
     * @param month the month in which the days are being checked
     */
    public void assertAllDaysInMonth(String expected, DayOfWeek dayOfStart, int day, Month month){
        assertCalendar(expected, dayOfStart, day, month);
        assertCalendar(expected, dayOfStart, day + 7, month);
        assertCalendar(expected, dayOfStart, day + 14, month);
        assertCalendar(expected, dayOfStart, day + 21, month);
    }

    /**
     * Asserts that the method {@link calendar.Calendar#calendar(DayOfWeek, int, Month)} correctly calculates the day of the week for a given day in a specific month.
     *
     * <p>This method tests the behavior of method by comparing its output to the expected weekday for a
     * specific day in a month. It ensures that method returns the correct weekday name based on the
     * provided start day and date.</p>
     *
     * @param expected the expected weekday name (e.g., "Monday", "Tuesday", etc.)
     * @param dayOfStart the starting day of the week for the given date
     * @param day the specific day of the month to check
     * @param month the month in which the day is located
     */
    public void assertCalendar(String expected, DayOfWeek dayOfStart, int day, Month month) {
        try{
            assertEquals(expected, calendar(dayOfStart, day, month));
        }catch (InvalidInputException e){
            fail("Expected no InvalidInputException, but got one.");
        }
    }

    /**
     * Asserts that the method {@link calendar.Calendar#calendar(DayOfWeek, int, Month)} correctly throws an {@link InvalidInputException} for illegal day values
     * in a given month.
     *
     * <p>This method tests various boundary cases and invalid day values to ensure that the {@link calendar.Calendar#calendar(DayOfWeek, int, Month)} method correctly
     * handles cases where the day value is out of range (either too large or too small) for the given month.</p>
     *
     * @param dayOfStart the starting day of the week for the given date
     * @param day the specific day of the month to check
     * @param month the month in which the day is located
     */
    public void assertInvalidDayInMonth(DayOfWeek dayOfStart, int day, Month month){
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
     * Asserts that the method {@link calendar.Calendar#calendar(DayOfWeek, int, Month)} throws an {@link InvalidInputException} with the correct message for
     * a given invalid day value in a specific month.
     *
     * <p>This method tests that the program throws an exception when provided with an out-of-range day value for the
     * specified month. It checks if the exception message matches the expected format, which includes the maximum allowed
     * day value for the month.</p>
     *
     * @param dayOfStart the starting day of the week for the given date
     * @param day the specific day of the month to check
     * @param month the month in which the day is located
     */
    public void assertThrowsIllegalDayValue(DayOfWeek dayOfStart, int day, Month month){
        String expectedMessage = String.format(INVALID_VALUE_DAY_INPUT_CALENDAR_TEST, month.length(false), day);

        assertThrowsInvalidArgument(dayOfStart, day, month, expectedMessage);
    }

    /**
     * Asserts that the method {@link calendar.Calendar#calendar(DayOfWeek, int, Month)} throws an {@link InvalidInputException} with the expected message for
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
    public void assertThrowsInvalidArgument(DayOfWeek dayOfStart, int day, Month month, String expectedMessage){
        try{
            calendar(dayOfStart, day, month);
            fail("Expected InvalidInputException to be thrown.");
        }catch (InvalidInputException e){
            assertEquals(expectedMessage, e.getMessage());
        }
    }

}