package calendar;

import java.time.DayOfWeek;
import java.time.Month;
import java.util.Scanner;

import static tools.GetConsoleInput.*;
import static calendar.Calendar.calendar;

/**
 * Class {@code CalendarMain} provides calculating the day of the week based on a given date util.
 *
 * <p>This class provides the entry point for the application. It prompts the user to input the starting
 * day of the year, a specific day, and the month number. It then calculates the day of the week for the
 * specified date using the {@link Calendar#calendar(DayOfWeek, int, Month)} method.</p>
 */
public class CalendarMain {
    /**
     * Value that represent max count days in week.
     */
    private final static int MAX_DAYS_IN_WEEK = 7;

    /**
     * Value that represent max count months in year.
     */
    private final static int MAX_MONTH_IN_YEAR = 12;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int dayOfStart = readInteger(in, 1, MAX_DAYS_IN_WEEK, "weekday of New Year");
        DayOfWeek weekdayOfNewYear = DayOfWeek.of(dayOfStart);

        int monthNumber = readInteger(in, 1, MAX_MONTH_IN_YEAR, "month");
        Month month = Month.of(monthNumber);
        int maxDayInMonth = month.length(false);

        int day = readInteger(in, 1, maxDayInMonth, "day");

        String weekday = calendar(weekdayOfNewYear, day, month);

        printResult(weekday);
    }

    /**
     * Method prints result of calculations from method {@link Calendar#calendar(DayOfWeek, int, Month)}
     *
     * @param result name day of week("Monday", "Tuesday", etc.)
     */
    private static void printResult(String result) {
        System.out.println("It is " + result);
    }
}
