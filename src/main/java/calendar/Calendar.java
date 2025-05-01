package calendar;

import java.time.DayOfWeek;
import java.time.Month;
import java.util.Arrays;

import static java.lang.Character.toUpperCase;

/**
 * Class {@code Calendar} provides a utility method for working with calendars.
 *
 * <p>This class provides a method to determine the day of the week for a given date,
 * based on the starting day of the year, the specific day, and the month number.</p>
 *
 * <p>It validates the inputs, ensuring that the day, month, and start day of the year are within
 * acceptable ranges. If any input is invalid, an {@link IllegalArgumentException} is thrown.</p>
 */
public class Calendar {

    /**
     * Error message for an invalid day input in calendar calculations.
     */
    private final static String INVALID_VALUE_DAY_IN_MONTH_MESSAGE =
            "Invalid input number of day. Number from 1 to %d was expected, but '%d' was received.";

    /**
     * Number days in week
     */
    private final static int DAYS_IN_WEEK = 7;

    /**
     * Calculates the day of the week for a given date.
     *
     * <p>This method takes the starting day of the year, the specific day of the month, and the
     * month number to calculate which day of the week the given date falls on. The method uses
     * the number of days that have passed in the year and calculates the corresponding day of the week.</p>
     *
     * <p>If any input is invalid (e.g., an out-of-range day of month), an {@link IllegalArgumentException}
     * is thrown with a corresponding error message.</p>
     *
     * @param weekdayOfNewYear the day of the week on which the year starts
     * @param day              the specific day of the month
     * @param month            the specific month
     * @return the name of the day of the week (e.g., "Monday", "Tuesday", etc.)
     */
    public static String calendar(DayOfWeek weekdayOfNewYear, int day, Month month) {
        int monthNumber = month.getValue();
        int dayOfStart = weekdayOfNewYear.getValue();
        int daysInMonth = month.length(false);

        if (day > daysInMonth || day < 1) {
            throw new IllegalArgumentException(
                    String.format(INVALID_VALUE_DAY_IN_MONTH_MESSAGE, daysInMonth, day));
        }

        int days = Arrays.stream(Month.values())
                .filter(m -> m.getValue() < monthNumber)
                .mapToInt(m -> m.length(false))
                .sum() + day + dayOfStart;

        int dayIndex = (days - 1) % DAYS_IN_WEEK;

        if (dayIndex == 0) {
            dayIndex = DAYS_IN_WEEK;
        }

        DayOfWeek weekday = DayOfWeek.of(dayIndex);

        return formatDayOfWeek(weekday);
    }

    /**
     * Formats the day of the week as a capitalized string.
     *
     * <p>This method converts day of the week
     * into its corresponding {@link DayOfWeek} name, formats it in lowercase,
     * and then capitalizes the first letter.</p>
     *
     * @param dayOfWeek the day of the week (MONDAY, ..., SUNDAY)
     * @return the formatted name of the day with the first letter capitalized (e.g., "Monday", "Tuesday")
     */
    private static String formatDayOfWeek(DayOfWeek dayOfWeek) {
        String name = dayOfWeek.name().toLowerCase();
        return toUpperCase(name.charAt(0)) + name.substring(1);
    }
}
