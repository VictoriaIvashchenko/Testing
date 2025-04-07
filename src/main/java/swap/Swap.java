package swap;

/**
 * Class {@code Swap} provides a utility method to swap two integers without using a temporary variable.
 *
 * <p>This class contains a static method {@link swap} that demonstrates swapping two integer values
 * using arithmetic operations.</p>
 */
public class Swap {
    /**
     * Swaps the values of two integers without using a temporary variable.
     *
     * <p>This method prints the values of x and y before and after swapping.
     * It uses arithmetic operations to swap the values in place.</p>
     *
     * @param x the first integer
     * @param y the second integer
     * @return an array containing the swapped values, where the first element is the new value of x and the second element is the new value of y
     */
    public static int[] swap(int x, int y) {
        x = x + y;
        y = x - y;
        x = x - y;
        return new int[]{x, y};
    }
}
