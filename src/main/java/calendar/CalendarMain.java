package calendar;

import exceptions.InvalidInputException;

import java.time.DayOfWeek;
import java.time.Month;
import java.util.Scanner;

import static tools.CheckConsoleInput.*;
import static calendar.Calendar.calendar;

/**
 * Class {@code CalendarMain} provides calculating the day of the week based on a given date util.
 *
 * <p>This class provides the entry point for the application. It prompts the user to input the starting
 * day of the year, a specific day, and the month number. It then calculates the day of the week for the
 * specified date using the {@link Calendar#calendar(DayOfWeek, int, Month)} method.</p>
 *
 * <p>If any input is invalid (e.g., an invalid day, month, or starting day of the year), the program will
 * catch an {@link InvalidInputException} and display an error message.</p>
 */
public class CalendarMain {

    /**
     * Number days in week
     */
    private final static int DAYS_IN_WEEK = 7;
    /**
     * Number months in year
     */
    private final static int MONTHS_IN_YEAR = 12;
    /**
     * Error message for an invalid weekday value input.
     */
    private final static String INVALID_NUMBER_WEEKDAY_VALUE_MESSAGE =
            "Invalid input day of New Year. Number of weekday was expected, but '%d' was received.";
    /**
     * Error message for an invalid month value input.
     */
    private final static String INVALID_NUMBER_MONTH_VALUE_MESSAGE =
            "Invalid input number of month. Number of month was expected, but '%d' was received.";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Task 5. Enter number day of New Year, day and month of searching day:");
        try {
            int dayOfStart = readInteger(in);
            int day = readInteger(in);
            int monthNumber = readInteger(in);

            DayOfWeek weekdayOfNewYear = checkWeekday(dayOfStart);
            Month month = checkMonth(monthNumber);

            String weekday = calendar(weekdayOfNewYear, day, month);

            printResult(weekday);

        } catch (InvalidInputException e) {
            System.err.print(e.getMessage());
        }
    }

    /**
     * Checks the day of the week and returns the corresponding {@link DayOfWeek}.
     *
     * <p>The method checks if the input value is in the range from 1 to 7 (inclusive),
     * and, if so, returns the corresponding value of the {@link DayOfWeek} list. If the value.
     * is not in the valid range thrown {@link InvalidInputException} with
     * the corresponding error message.
     *
     * @param value the numeric value of the day of the week (1-7)
     * @return the corresponding value {@link DayOfWeek}
     * @throws InvalidInputException if the value is not in the valid range
     */
    private static DayOfWeek checkWeekday(int value) throws InvalidInputException {
        if (value <= DAYS_IN_WEEK && value >= 1) {
            return DayOfWeek.of(value);
        } else {
            throw new InvalidInputException(
                    String.format(INVALID_NUMBER_WEEKDAY_VALUE_MESSAGE, value));
        }
    }

    /**
     * Checks the value of the month number and returns the corresponding {@link Month}.
     *
     * <p>The method checks if the input value is in the range from 1 to 12 (inclusive),
     * and, if so, returns the corresponding value of the {@link Month} list. If the value
     * is not in the valid range, thrown {@link InvalidInputException} with
     * the corresponding error message.
     *
     * @param value the numeric value of the month (1-12)
     * @return the corresponding value {@link Month}
     * @throws InvalidInputException if the value is not in the valid range
     */
    private static Month checkMonth(int value) throws InvalidInputException {
        if (value <= MONTHS_IN_YEAR && value >= 1) {
            return Month.of(value);
        } else {
            throw new InvalidInputException(
                    String.format(INVALID_NUMBER_MONTH_VALUE_MESSAGE, value));
        }
    }

    private static void printResult(String result) {
        System.out.println("It is " + result);
    }
}
