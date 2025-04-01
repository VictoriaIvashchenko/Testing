package exceptions;

public enum ExceptionMessages {
    INVALID_VALUE_INPUT_FIBONACCI("Invalid value of index. Positive integer from 0 to 2147483647 was expected, but '%d' was received."),
    INVALID_TYPE_INPUT_FIBONACCI("Invalid type of %s. Number from 0 to 2147483647 was expected, but '%s' was received."),

    INVALID_TYPE_INPUT_SWAP("Invalid type of %s. Number from -2147483648 to 2147483647 was expected, but '%s' was received."),

    INVALID_TYPE_INPUT_GCD("Invalid type of %s. Number from -2147483648 to 2147483647 was expected, but '%s' was received."),
    INVALID_RESULT_GCD("Modulus of a -2147483648 can't be calculated."),

    INVALID_VALUE_FLOORS_INPUT_FLATS("Invalid input number of floors. Number from 1 to 2147483647 was expected, but '%s' was received."),
    INVALID_VALUE_FLATS_ON_FLOOR_INPUT_FLATS("Invalid input number of flats on floor. Number from 1 to 2147483647 was expected, but '%s' was received."),
    INVALID_VALUE_FLAT_NUMBER_INPUT_FLATS("Invalid input number of flat. Number from 1 to 2147483647 was expected, but '%s' was received."),
    INVALID_CALCULATIONS_FLATS("Task can't be calculated with input arguments: %d floors, %d flats on floor."),
    INVALID_TYPE_INPUT_FLATS("Invalid type of %s. Number from 1 to 2147483647 was expected, but '%s' was received."),

    INVALID_VALUE_DAY_OF_NEW_YEAR_INPUT("Invalid input day of New Year. Number of day was expected, but '%d' was received."),
    INVALID_VALUE_MONTH_INPUT_CALENDAR("Invalid input number of month. Number of month was expected, but '%d' was received."),
    INVALID_VALUE_DAY_INPUT_CALENDAR("Invalid input number of day. Number from 1 to %d was expected, but '%d' was received."),
    INVALID_TYPE_INPUT_CALENDAR("Invalid type of %s. Number from 1 to 2147483647 was expected, but '%s' was received.");

    private final String message;

    ExceptionMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
