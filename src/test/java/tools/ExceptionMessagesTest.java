package tools;

/**
 * Enum representing predefined test exception messages for input validation errors.
 *
 * <p>This enum contains formatted error messages specifically used for unit tests
 * when validating input handling in various scenarios, such as Fibonacci calculations,
 * GCD calculations, flat number calculations, and calendar-related errors.</p>
 *
 * <p>Each constant in this enum holds a test-specific error message template that
 * can be formatted using {@link String#format(String, Object...)} to provide detailed error information
 * during assertions.</p>
 *
 * <p>Usage Example:</p>
 * <pre>{@code
 *  String errorMessage = String.format(
 *  ExceptionMessagesTest.INVALID_TYPE_INPUT_FIBONACCI_TEST.getTestMessage(), "n", "abc");
 *
 *  assertEquals("Invalid type of n. Number from 0 to 2147483647 was expected, but 'abc' was received.", errorMessage);
 * }
 * </pre>
 *
 */
public enum ExceptionMessagesTest {
    /** Error message for an invalid type input in swap operations. */
    INVALID_TYPE_INPUT_SWAP_TEST("Invalid type of %s. Number from -2147483648 to 2147483647 was expected, but '%s' was received."),

    /** Error message for an invalid Fibonacci index input. */
    INVALID_VALUE_INPUT_FIBONACCI_TEST("Invalid value of index. Positive integer from 0 to 2147483647 was expected, but '%s' was received."),
    /** Error message for an invalid type input in Fibonacci calculations. */
    INVALID_TYPE_INPUT_FIBONACCI_TEST("Invalid type of %s. Number from 0 to 2147483647 was expected, but '%s' was received."),

    /** Error message for an invalid type input in GCD calculations. */
    INVALID_TYPE_INPUT_GCD_TEST("Invalid type of %s. Number from -2147483648 to 2147483647 was expected, but '%s' was received."),

    /** Error message for an invalid number of floors input in flat calculations. */
    INVALID_VALUE_FLOORS_INPUT_FLATS_TEST("Invalid input number of floors. Number from 1 to 2147483647 was expected, but '%s' was received."),
    /** Error message for an invalid number of flats per floor in flat calculations. */
    INVALID_VALUE_FLATS_ON_FLOOR_INPUT_FLATS_TEST("Invalid input number of flats on floor. Number from 1 to 2147483647 was expected, but '%s' was received."),
    /** Error message for an invalid flat number input. */
    INVALID_VALUE_FLAT_NUMBER_INPUT_FLATS_TEST("Invalid input number of flat. Number from 1 to 2147483647 was expected, but '%s' was received."),
    /** Error message when calculations with the given flat parameters are not possible. */
    INVALID_CALCULATIONS_FLATS_TEST("Task can't be calculated with input arguments: %d floors, %d flats on floor."),
    /** Error message for an invalid type input in flat calculations. */
    INVALID_TYPE_INPUT_FLATS_TEST("Invalid type of %s. Number from 1 to 2147483647 was expected, but '%s' was received."),

    /** Error message for an invalid New Year's starting day input in calendar calculations. */
    INVALID_VALUE_DAY_OF_NEW_YEAR_INPUT_CALENDAR_TEST("Invalid input day of New Year. Number of day was expected, but '%d' was received."),
    /** Error message for an invalid month input in calendar calculations. */
    INVALID_VALUE_MONTH_INPUT_CALENDAR_TEST("Invalid input number of month. Number of month was expected, but '%d' was received."),
    /** Error message for an invalid day input in calendar calculations. */
    INVALID_VALUE_DAY_INPUT_CALENDAR_TEST("Invalid input number of day. Number from 1 to %d was expected, but '%d' was received."),
    /** Error message for an invalid type input in calendar calculations. */
    INVALID_TYPE_INPUT_CALENDAR_TEST("Invalid type of %s. Number from 1 to 2147483647 was expected, but '%s' was received.");

    /** The formatted test message template for the exception. */
    private final String testMessage;

    /**
     * Constructs an {@code ExceptionMessagesTest} constant with a predefined message template.
     *
     * @param testMessage the error message template for testing
     */
    ExceptionMessagesTest(String testMessage){
        this.testMessage = testMessage;
    }

    /**
     * Retrieves the formatted test exception message.
     *
     * @return the test error message template as a {@code String}
     */
    public String getTestMessage(){
        return testMessage;
    }
}
