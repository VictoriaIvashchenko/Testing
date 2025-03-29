package calendar;

import exceptions.InvalidInputException;

import java.time.DayOfWeek;
import java.time.Month;
import java.util.Arrays;

import static exceptions.ExceptionMessages.*;
import static java.lang.String.format;

public class Calendar{
    /**
     * Calculates the day of the week for a specific date based on the day of the week for January 1st.
     *
     * <p>This method determines the day of the week for the given date by first validating the input day
     * against the number of days in the given month. It then calculates the total number of days from the beginning
     * of the year up to the specified date, and uses this to compute the day of the week.</p>
     *
     * @param dayOfWeek the {@link DayOfWeek} representing the day of the week for January 1st
     * @param day the day of the month to calculate for
     * @param month the {@link Month} of the date to calculate
     * @return the name of the day of the week corresponding to the specified date
     * @throws InvalidInputException if the provided day is out of range for the given month
     */
    public static String calendar(DayOfWeek dayOfWeek, int day, Month month) throws InvalidInputException{
        int dayOfStart = dayOfWeek.getValue();

        int monthNumber = month.getValue();

        if(day > month.length(false) || day < 1){
            throw new InvalidInputException(format(INVALID_VALUE_DAY_INPUT_CALENDAR.getMessage(), month.length(false), day));
        }
        int days = Arrays.stream(Month.values())
                .filter(m -> m.getValue() < monthNumber)
                .mapToInt(m -> m.length(false))
                .sum() + day;

        int dayOFWeek = (days + dayOfStart - 1) % 7;

        return switch (dayOFWeek) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            default -> "Sunday";
        };
    }

}
