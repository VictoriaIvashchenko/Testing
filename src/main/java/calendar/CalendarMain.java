package calendar;

import exceptions.InvalidInputException;

import java.time.DayOfWeek;
import java.time.Month;
import java.util.Scanner;

import static exceptions.CheckConsoleInput.*;
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

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String message = "Invalid type of %s. Number from 1 to 2147483647 was expected, but '%s' was received.";

        System.out.println("Task 5. Enter number day of New Year, day and month of searching day:");
        try {
            int dayOfStart = readInteger(in, "day of New Year", message);
            int day = readInteger(in, "day", message);
            int monthNumber = readInteger(in, "month", message);

            DayOfWeek weekdayOfNewYear = checkWeekday(dayOfStart);
            Month month = checkMonth(monthNumber);
            
            String result = calendar(weekdayOfNewYear, day, month);

            printResult(result);

        } catch (InvalidInputException e) {
            System.err.print(e.getMessage());
        }
    }

    private static DayOfWeek checkWeekday(int value) throws InvalidInputException {
        if (value <= 7 & value >= 1) {
            return DayOfWeek.of(value);
        }else {
            throw new InvalidInputException(
                    String.format("Invalid input day of New Year. Number of weekday was expected, but '%d' was received.", value));
        }
    }

    private static Month checkMonth(int value) throws InvalidInputException {
        if (value <= 12 & value >= 1) {
            return Month.of(value);
        }else {
            throw new InvalidInputException(
                    String.format("Invalid input number of month. Number of month was expected, but '%d' was received.", value));
        }
    }

    private static void printResult(String result){
        System.out.println("It is " + result);
    }


}
