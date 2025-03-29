package exceptions;

import java.time.DayOfWeek;
import java.time.Month;
import java.util.Scanner;

import static exceptions.ExceptionMessages.INVALID_VALUE_DAY_OF_NEW_YEAR_INPUT;
import static exceptions.ExceptionMessages.INVALID_VALUE_MONTH_INPUT_CALENDAR;
import static java.lang.Integer.parseInt;
import static java.lang.String.format;

public class CheckConsoleInput {
    /**
     * Reads an integer value from the input scanner and validates it.
     *
     * <p>This method reads a line of input, trims it, and attempts to parse it as an integer.
     * If the input is not a valid integer, an {@link InvalidInputException} is thrown
     * with a formatted error message.</p>
     *
     * @param in the {@link Scanner} object used for reading user input
     * @param varName the name of the variable being read (used for error messages)
     * @param message the error message format string in case of invalid input
     * @return the parsed integer value
     * @throws InvalidInputException if the input cannot be parsed as an integer
     */
    public static Integer readInteger(Scanner in, String varName, String message) throws InvalidInputException {
        String input = in.nextLine().trim();
        try {
            return parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidInputException(format(message, varName, input));
        }
    }

    /**
     * Reads the name of a month from user input and returns the corresponding {@link Month} enum value.
     *
     * <p>This method reads the user's input, trims leading and trailing spaces,
     * converts it to uppercase, and attempts to match it to a constant in the {@link Month} enum.
     * If the input does not match any valid month, an {@link InvalidInputException} is thrown.</p>
     *
     * @param in the {@link Scanner} used to read user input
     * @return the corresponding {@link Month} enum value
     * @throws InvalidInputException if the input is not a valid month name
     */
    public static Month readMonth(Scanner in) throws InvalidInputException {
        String input = in.nextLine().trim();
        try{
            return Month.valueOf(input.toUpperCase());
        } catch (IllegalArgumentException e){
            throw new InvalidInputException(format(INVALID_VALUE_MONTH_INPUT_CALENDAR.getMessage(), input));
        }
    }

    /**
     * Reads the name of a day of the week from user input and returns the corresponding {@link DayOfWeek} enum value.
     *
     * <p>This method reads the user's input, trims leading and trailing spaces,
     * converts it to uppercase, and attempts to match it to a constant in the {@link DayOfWeek} enum.
     * If the input does not match any valid day of the week, an {@link InvalidInputException} is thrown.</p>
     *
     * @param in the {@link Scanner} used to read user input
     * @return the corresponding {@link DayOfWeek} enum value
     * @throws InvalidInputException if the input is not a valid day of the week
     */
    public static DayOfWeek readDayOfWeek(Scanner in) throws InvalidInputException {
        String input = in.nextLine().trim();
        try{
            return DayOfWeek.valueOf(input.toUpperCase());
        }catch (IllegalArgumentException e){
            throw new InvalidInputException(format(INVALID_VALUE_DAY_OF_NEW_YEAR_INPUT.getMessage(), input));
        }
    }
}
