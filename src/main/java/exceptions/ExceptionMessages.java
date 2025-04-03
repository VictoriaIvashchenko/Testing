package exceptions;

/**
 * Enum representing predefined exception messages for various input validation errors.
 *
 * <p>This enum contains formatted error messages for different types of invalid inputs,
 * including Fibonacci calculations, swapping numbers, GCD calculations, flat number calculations,
 * and calendar-related errors.</p>
 *
 * <p>Each constant in this enum holds a specific error message template that can be formatted
 * using {@link String#format(String, Object...)} to provide detailed error information.</p>
 *
 * <p>Usage Example:</p>
 * <pre>
 *     {@code
 *     String errorMessage = String.format(ExceptionMessages.INVALID_TYPE_INPUT_FIBONACCI.getMessage(), "n", "abc");
 *
 *     System.err.println(errorMessage);
 *
 *     // Output: Invalid type of n. Number from 0 to 2147483647 was expected, but 'abc' was received.}
 * </pre>
 *
 *
 *
 */
public enum ExceptionMessages {
    /** Error message for an invalid Fibonacci index input. */
    INVALID_VALUE_INPUT_FIBONACCI("Invalid value of index. Positive integer from 0 to 2147483647 was expected, but '%d' was received."),
    /** Error message for an invalid type input in Fibonacci calculations. */
    INVALID_TYPE_INPUT_FIBONACCI("Invalid type of %s. Number from 0 to 2147483647 was expected, but '%s' was received."),

    /** Error message for an invalid type input in swap operations. */
    INVALID_TYPE_INPUT_SWAP("Invalid type of %s. Number from -2147483648 to 2147483647 was expected, but '%s' was received."),


    /** Error message for an invalid type input in GCD calculations. */
    INVALID_TYPE_INPUT_GCD("Invalid type of %s. Number from -2147483648 to 2147483647 was expected, but '%s' was received."),
    /** Error message when modulus of Integer.MIN_VALUE is attempted. */
    INVALID_RESULT_GCD("Modulus of a -2147483648 can't be calculated."),


    /** Error message for an invalid number of floors input in flat calculations. */
    INVALID_VALUE_FLOORS_INPUT_FLATS("Invalid input number of floors. Number from 1 to 2147483647 was expected, but '%s' was received."),
    /** Error message for an invalid number of flats per floor in flat calculations. */
    INVALID_VALUE_FLATS_ON_FLOOR_INPUT_FLATS("Invalid input number of flats on floor. Number from 1 to 2147483647 was expected, but '%s' was received."),
    /** Error message for an invalid flat number input. */
    INVALID_VALUE_FLAT_NUMBER_INPUT_FLATS("Invalid input number of flat. Number from 1 to 2147483647 was expected, but '%s' was received."),
    /** Error message when calculations with the given flat parameters are not possible. */
    INVALID_CALCULATIONS_FLATS("Task can't be calculated with input arguments: %d floors, %d flats on floor."),
    /** Error message for an invalid type input in flat calculations. */
    INVALID_TYPE_INPUT_FLATS("Invalid type of %s. Number from 1 to 2147483647 was expected, but '%s' was received."),

    /** Error message for an invalid New Year's starting day input. */
    INVALID_VALUE_DAY_OF_NEW_YEAR_INPUT("Invalid input day of New Year. Number of day was expected, but '%d' was received."),
    /** Error message for an invalid month input in calendar calculations. */
    INVALID_VALUE_MONTH_INPUT_CALENDAR("Invalid input number of month. Number of month was expected, but '%d' was received."),
    /** Error message for an invalid day input in calendar calculations. */
    INVALID_VALUE_DAY_INPUT_CALENDAR("Invalid input number of day. Number from 1 to %d was expected, but '%d' was received."),
    /** Error message for an invalid type input in calendar calculations. */
    INVALID_TYPE_INPUT_CALENDAR("Invalid type of %s. Number from 1 to 2147483647 was expected, but '%s' was received.");

    /** The formatted message template for the exception. */
    private final String message;

    /**
     * Constructs an {@code ExceptionMessages} constant with a predefined message template.
     *
     * @param message the error message template
     */
    ExceptionMessages(String message) {
        this.message = message;
    }

    /**
     * Retrieves the formatted exception message.
     *
     * @return the error message template as a {@link String}
     */
    public String getMessage() {
        return message;
    }

}
