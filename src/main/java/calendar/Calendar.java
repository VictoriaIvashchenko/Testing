package calendar;

import exceptions.InvalidInputException;

import java.time.DayOfWeek;
import java.time.Month;
import java.util.Arrays;

import static java.lang.String.format;

/**
 * Class {@code Calendar} provides a utility method for working with calendars.
 *
 * <p>This class provides a method to determine the day of the week for a given date,
 * based on the starting day of the year, the specific day, and the month number.</p>
 *
 * <p>It validates the inputs, ensuring that the day, month, and start day of the year are within
 * acceptable ranges. If any input is invalid, an {@link InvalidInputException} is thrown.</p>
 */
public class Calendar {
    /**
     * Error message for an invalid day input in calendar calculations.
     */
    private final static String INVALID_VALUE_DAY_INPUT_CALENDAR =
            "Invalid input number of day. Number from 1 to %d was expected, but '%d' was received.";

    /**
     * Calculates the day of the week for a given date.
     *
     * <p>This method takes the starting day of the year, the specific day of the month, and the
     * month number to calculate which day of the week the given date falls on. The method uses
     * the number of days that have passed in the year and calculates the corresponding day of the week.</p>
     *
     * <p>If any input is invalid (e.g., an out-of-range day or month), an {@link InvalidInputException}
     * is thrown with a corresponding error message.</p>
     *
     * @param weekdayOfNewYear  the day of the week on which the year starts (1 for Monday, 7 for Sunday)
     * @param day         the specific day of the month
     * @param month the month number (1 for January, 12 for December)
     * @return the name of the day of the week (e.g., "MONDAY", "TUESDAY", etc.)
     * @throws InvalidInputException if any of the input values are invalid (e.g., day or month out of range)
     */
    public static String calendar(DayOfWeek weekdayOfNewYear, int day, Month month) throws InvalidInputException {
        int daysInWeek = DayOfWeek.values().length;

        int monthNumber = month.getValue();
        int dayOfStart = weekdayOfNewYear.getValue();
        int daysInMonth = month.length(false);

        if (day > daysInMonth || day < 1) {
            throw new InvalidInputException(format(INVALID_VALUE_DAY_INPUT_CALENDAR, daysInMonth, day));
        }

        int days = Arrays.stream(Month.values())
                .filter(m -> m.getValue() < monthNumber)
                .mapToInt(m -> m.length(false))
                .sum() + day;
        int dayIndex = (days + dayOfStart - 1) % daysInWeek;

        if (dayIndex == 0) {
            dayIndex = daysInWeek;
        }

        return formatDayOfWeek(dayIndex);
    }

    /**
     * Formats the day of the week as a capitalized string.
     *
     * <p>This method converts a numeric day of the week (1 = Monday, ..., 7 = Sunday)
     * into its corresponding {@link DayOfWeek} name, formats it in lowercase,
     * and then capitalizes the first letter.</p>
     *
     * @param dayOfWeek the numeric value representing the day of the week (1 for Monday, ..., 7 for Sunday)
     * @return the formatted name of the day with the first letter capitalized (e.g., "Monday", "Tuesday")
     */
    private static String formatDayOfWeek(int dayOfWeek) {
        DayOfWeek day = DayOfWeek.of(dayOfWeek);
        String name = day.name().toLowerCase();
        return Character.toUpperCase(name.charAt(0)) + name.substring(1);
    }

}
