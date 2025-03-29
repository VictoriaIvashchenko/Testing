package calendar;

import exceptions.InvalidInputException;

import java.time.DayOfWeek;
import java.time.Month;
import java.util.Scanner;

import static exceptions.CheckConsoleInput.*;
import static exceptions.ExceptionMessages.INVALID_TYPE_INPUT_CALENDAR;
import static calendar.Calendar.calendar;

public class CalendarMain {
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Task 5. Enter number day of New Year, day and month of searching day:");

        try {
            String message = INVALID_TYPE_INPUT_CALENDAR.getMessage();

            DayOfWeek dayOfStart = readDayOfWeek(in);

            Integer day = readInteger(in, "day", message);

            Month month = readMonth(in);

            System.out.println("It is " + calendar(dayOfStart, day, month));
        }catch (InvalidInputException e){
            System.out.print(e.getMessage());
        }
    }

}
