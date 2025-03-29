package tools;

public enum ExceptionMessagesTest {
    INVALID_TYPE_INPUT_SWAP_TEST("Invalid type of %s. Number from -2147483648 to 2147483647 was expected, but '%s' was received."),

    INVALID_VALUE_INPUT_FIBONACCI_TEST("Invalid value of index. Positive integer from 0 to 2147483647 was expected, but '%s' was received."),
    INVALID_TYPE_INPUT_FIBONACCI_TEST("Invalid type of %s. Number from 0 to 2147483647 was expected, but '%s' was received."),

    INVALID_TYPE_INPUT_GCD_TEST("Invalid type of %s. Number from -2147483648 to 2147483647 was expected, but '%s' was received."),

    INVALID_VALUE_FLOORS_INPUT_FLATS_TEST("Invalid input number of floors. Number from 1 to 2147483647 was expected, but '%s' was received."),
    INVALID_VALUE_FLATS_ON_FLOOR_INPUT_FLATS_TEST("Invalid input number of flats on floor. Number from 1 to 2147483647 was expected, but '%s' was received."),
    INVALID_VALUE_FLAT_NUMBER_INPUT_FLATS_TEST("Invalid input number of flat. Number from 1 to 2147483647 was expected, but '%s' was received."),
    INVALID_CALCULATIONS_FLATS_TEST("Task can't be calculated with input arguments: %d floors, %d flats on floor."),
    INVALID_TYPE_INPUT_FLATS_TEST("Invalid type of %s. Number from 1 to 2147483647 was expected, but '%s' was received."),

    INVALID_VALUE_DAY_OF_NEW_YEAR_INPUT_CALENDAR_TEST("Invalid input day of New Year. Name of day was expected, but '%s' was received."),
    INVALID_VALUE_MONTH_INPUT_CALENDAR_TEST("Invalid input number of month. Name of month was expected, but '%s' was received."),
    INVALID_VALUE_DAY_INPUT_CALENDAR_TEST("Invalid input number of day. Number from 1 to %d was expected, but '%d' was received."),
    INVALID_TYPE_INPUT_CALENDAR_TEST("Invalid type of %s. Number from 1 to 2147483647 was expected, but '%s' was received.");

    private final String testMessage;

    ExceptionMessagesTest(String testMessage){
        this.testMessage = testMessage;
    }

    public String getTestMessage(){
        return testMessage;
    }
}
