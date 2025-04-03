package calendar;

import exceptions.InvalidInputException;

import java.util.Scanner;

import static exceptions.CheckConsoleInput.*;
import static calendar.Calendar.calendar;
import static exceptions.ExceptionMessages.*;

/**
 * Class {@code CalendarMain} provides calculating the day of the week based on a given date util.
 *
 * <p>This class provides the entry point for the application. It prompts the user to input the starting
 * day of the year, a specific day, and the month number. It then calculates the day of the week for the
 * specified date using the {@link Calendar#calendar(int, int, int)} method.</p>
 *
 * <p>If any input is invalid (e.g., an invalid day, month, or starting day of the year), the program will
 * catch an {@link InvalidInputException} and display an error message.</p>
 */
public class CalendarMain {
    /**
     * The main method for calculating the day of the week for a given date.
     *
     * <p>This method prompts the user to enter the starting day of the year, a specific day, and the
     * month number, then calculates which day of the week the specified date falls on. It uses the
     * {@link Calendar#calendar(int, int, int)} method to perform the calculation.</p>
     *
     * <p>If the user enters invalid input (e.g., a day or month outside the valid range), an
     * {@link InvalidInputException} is caught, and an error message is displayed.</p>
     *
     * @param args command-line arguments (not used in this program)
     */
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);

        System.out.println("Task 5. Enter number day of New Year, day and month of searching day:");

        String message = INVALID_TYPE_INPUT_CALENDAR.getMessage();

        try {
            Integer dayOfStart = readInteger(in, "day of New Year", message);

            Integer day = readInteger(in, "day", message);

            Integer month = readInteger(in, "month", message);

            System.out.println("It is " + calendar(dayOfStart, day, month));
        }catch (InvalidInputException e){
            System.err.print(e.getMessage());
        }
    }

}
