package swapTest;

import org.junit.jupiter.api.Test;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;
import static swap.Swap.swap;

import static org.junit.jupiter.api.Assertions.*;

class SwapTest {

    @Test
    void swapLimitTest() {
        //граничні значення
        assertSwap(MAX_VALUE, MAX_VALUE);
        assertSwap(MAX_VALUE, MIN_VALUE);
        assertSwap(MIN_VALUE, MAX_VALUE);
        assertSwap(MIN_VALUE, MIN_VALUE);

        //сусідні значення
        assertSwap(MAX_VALUE - 1, MAX_VALUE);
        assertSwap(MAX_VALUE - 1, MAX_VALUE - 1);
        assertSwap(MAX_VALUE, MAX_VALUE - 1);

        assertSwap(MAX_VALUE - 1, MIN_VALUE);
        assertSwap(MAX_VALUE - 1, MIN_VALUE + 1);
        assertSwap(MAX_VALUE, MIN_VALUE + 1);

        assertSwap(MIN_VALUE, MIN_VALUE + 1);
        assertSwap(MIN_VALUE + 1, MIN_VALUE + 1);
        assertSwap(MIN_VALUE + 1, MIN_VALUE);

        assertSwap(MIN_VALUE + 1, MAX_VALUE);
        assertSwap(MIN_VALUE + 1, MAX_VALUE - 1);
        assertSwap(MIN_VALUE, MAX_VALUE - 1);
    }

    @Test
    void swapPositiveNumbersTest() {
        //межі класу
        assertSwap(1, 1);
        assertSwap(1, MAX_VALUE);
        assertSwap(MAX_VALUE, 1);

        //сусідні точки
        assertSwap(1, 2);
        assertSwap(2, 1);
        assertSwap(2, 2);

        assertSwap(1, MAX_VALUE - 1);
        assertSwap(2, MAX_VALUE - 1);
        assertSwap(2, MAX_VALUE);

        assertSwap(MAX_VALUE - 1, 1);
        assertSwap(MAX_VALUE - 1, 2);
        assertSwap(MAX_VALUE, 2);

        //значення в середині класу
        assertSwap(4, 1);
        assertSwap(27, 55);
        assertSwap(405, 564);
        assertSwap(4264, 1695);
        assertSwap(44665, 17456);
        assertSwap(963686, 466675);
        assertSwap(4435660, 7965666);
        assertSwap(67772825, 604625259);
        assertSwap(299893657, 1659479318);
        assertSwap(2048982877, 2045403970);
    }

    @Test
    void swapPositiveNegativeTest() {
        //межі класу
        assertSwap(1, -1);
        assertSwap(MAX_VALUE, -1);
        assertSwap(1, MIN_VALUE);

        //сусідні значення
        assertSwap(2, -1);
        assertSwap(2, -2);
        assertSwap(1, -2);

        assertSwap(MAX_VALUE - 1, -1);
        assertSwap(MAX_VALUE - 1, -2);
        assertSwap(MAX_VALUE, -2);

        assertSwap(2, MIN_VALUE);
        assertSwap(2, MIN_VALUE + 1);
        assertSwap(1, MIN_VALUE + 1);

        //значення в середині класу
        assertSwap(2, -8);
        assertSwap(75, -96);
        assertSwap(234, -124);
        assertSwap(3669, -9006);
        assertSwap(27892, -56236);
        assertSwap(567863, -705960);
        assertSwap(1269434, -7965961);
        assertSwap(13673630, -96522632);
        assertSwap(201469862, -102653698);
        assertSwap(2147483642, -1797485302);
    }

    @Test
    void swapNegativePositiveTest(){
        //межі класу
        assertSwap(-1, 1);
        assertSwap(-1, MAX_VALUE);
        assertSwap(MIN_VALUE, 1);

        //сусідні значення
        assertSwap(-2, 1);
        assertSwap(-2, 2);
        assertSwap(-1, 2);

        assertSwap(MIN_VALUE + 1, 1);
        assertSwap(MIN_VALUE + 1, 2);
        assertSwap(MIN_VALUE, 2);

        assertSwap(-2, MAX_VALUE);
        assertSwap(-2, MAX_VALUE - 1);
        assertSwap(-1, MAX_VALUE - 1);

        //значення в середині класу
        assertSwap(-4, 1);
        assertSwap(-12, 28);
        assertSwap(-329, 365);
        assertSwap(-2353, 5364);
        assertSwap(-36652, 65542);
        assertSwap(-138509, 325335);
        assertSwap(-2614498, 3413009);
        assertSwap(-22870607, 35187167);
        assertSwap(-424158021, 264468739);
        assertSwap(-1228713113, 1135311823);
    }

    @Test
    void swapNegativeNumbersTest() {
        //межі класу
        assertSwap(-1, -1);
        assertSwap(-1, MIN_VALUE);
        assertSwap(MIN_VALUE, -1);

        //сусідні точки
        assertSwap(-2, -1);
        assertSwap(-1, -2);
        assertSwap(2, 2);

        assertSwap(-1, MIN_VALUE + 1);
        assertSwap(-2, MIN_VALUE + 1);
        assertSwap(-2, MIN_VALUE);

        assertSwap(MIN_VALUE, -2);
        assertSwap(MIN_VALUE, -2);
        assertSwap(MIN_VALUE + 1, -1);

        //значення всередині класу
        assertSwap(-1, -2);
        assertSwap(-34, -13);
        assertSwap(-788, -285);
        assertSwap(-4585, -8362);
        assertSwap(-12208, -79663);
        assertSwap(-755628, -456256);
        assertSwap(-5254578, -1233489);
        assertSwap(-97405669, -21709685);
        assertSwap(-258063798, -252631477);
        assertSwap(-1189153935, -1399152132);
    }

    @Test
    void swapOneZeroTest() {
        //межі класу
        assertSwap(MIN_VALUE, 0);
        assertSwap(0, MIN_VALUE);
        assertSwap(MAX_VALUE, 0);
        assertSwap(0, MAX_VALUE);

        //сусідні точки
        assertSwap(MIN_VALUE + 1, 0);
        assertSwap(0, MIN_VALUE + 1);

        assertSwap(MAX_VALUE - 1, 0);
        assertSwap(0, MAX_VALUE - 1);

        //значення в середині класу
        assertSwap(0, 0);
        assertSwap(0, 7);
        assertSwap(55, 0);
        assertSwap(0, -56);
        assertSwap(-1, 0);
        assertSwap(2073829416, 0);
        assertSwap(0, 640075121);
        assertSwap(-1392560475, 0);
        assertSwap(0, -2025170717);
        assertSwap(-471159770, 0);
        assertSwap(0, 6395222);
        assertSwap(5526474, 0);
        assertSwap(0, -1847594711);
    }

    @Test
    void subjectArea(){
        //граничні значення
        assertSwap(1_000_000, 1_000_000);
        assertSwap(1_000_000, -1_000_000);
        assertSwap(-1_000_000, 1_000_000);
        assertSwap(-1_000_000, -1_000_000);

        //сусідні значення
        assertSwap(1_000_000, 999_999);
        assertSwap(999_999, 1_000_000);

        assertSwap(-999_999, 1_000_000);
        assertSwap(1_000_000, -999_999);

        assertSwap(-1_000_000, 999_999);
        assertSwap(-999_999, 1_000_000);

        assertSwap(-1_000_000, -999_999);
        assertSwap(-999_999, -1_000_000);

        //значення в середині класу
        assertSwap(1, 4);
        assertSwap(98, 43);
        assertSwap(186, 789);
        assertSwap(6589, 5482);
        assertSwap(55686, 91007);
        assertSwap(189981, 186650);
        assertSwap(-479687, 45450);
        assertSwap(-46346, 55365);
        assertSwap(-146335, 566846);
        assertSwap(-698456, 1896450);
        assertSwap(-56910, 78566);
        assertSwap(-8179, 7826);
        assertSwap(-713, 854);
        assertSwap(-26, 23);
        assertSwap(-5, 7);
    }

    @Test
    void swapEqualModuloTest() {
        assertSwap(1, -1);
        assertSwap(12, -12);
        assertSwap(456, -456);
        assertSwap(2246, -2246);
        assertSwap(56658, -56658);
        assertSwap(136846, -136846);
        assertSwap(3666595, -3666595);
        assertSwap(13280271, -13280271);
        assertSwap(240751134, -2103751134);
        assertSwap(214406588, -214406588);
    }

    @Test
    void swapOverloadTest(){
        assertSwap(MAX_VALUE, 1);
        assertSwap(1, MAX_VALUE);
        assertSwap(MIN_VALUE, -1);
        assertSwap(-1, MIN_VALUE);

        assertSwap(MAX_VALUE, 2);
        assertSwap(2, MAX_VALUE);
        assertSwap(MIN_VALUE, -2);
        assertSwap(-2, MIN_VALUE);

        assertSwap(2147483647, 808);
        assertSwap(2147083647, 778808);
        assertSwap(-809, -2147483648);
        assertSwap(-476464, -2147483648);
        assertSwap(2147483647, 2147483647);
        assertSwap(2147483647, -2147483648);
        assertSwap(-2147483648, -2147483648);
        assertSwap(-2147083648, -2147483648);
        assertSwap(-147483648, -2147483648);
        assertSwap(2147483647, 2147483647);

    }

    @Test
    void swapRandomDataTest(){
        assertSwap(353851604, 1276041920);
        assertSwap(721411601, 1431759193);
        assertSwap(1286380921, 391044354);
        assertSwap(799073754, 384887912);
        assertSwap(367606577, -747794037);
        assertSwap(1653353400, -263327821);
        assertSwap(243317264, -899812445);
        assertSwap(-1824162098, 913867164);
        assertSwap(-518402351, 265193048);
        assertSwap(-4436602, -310334831);
}

    @Test
    void swapSpecialValuesTest(){
        assertSwap(30011965, 13071970);
        assertSwap(11012016, 20072002);
        assertSwap(18111993, 2111989);
        assertSwap(25092000, 26012002);
        assertSwap(21082001, 1081999);
        assertSwap(5092002, 25011998);
        assertSwap(740301,510104);
        assertSwap(20190804, 20241230);
        assertSwap(20200145, 2024789);
        assertSwap(1040202, 795136210);
    }

    /**
     * Asserts the correctness of a number-swapping method with two input values by
     * testing them in both direct and reversed order using various sign combinations.
     *
     * @param num1 the first number to test
     * @param num2 the second number to test
     */
    public void assertSwap(int num1, int num2){
        assertSwapDifferentSign(num1, num2);
        assertSwapDifferentSign(num2, num1);
    }

    /**
     * Asserts the correctness of a number-swapping method with the given numbers
     * and all possible sign variations (positive and negative).
     *
     * @param num1 the first number to test (in multiple sign variations)
     * @param num2 the second number to test (in multiple sign variations)
     */
    public void assertSwapDifferentSign(int num1, int num2){
        assertSwapTwoNumbers(num1, num2);
        assertSwapTwoNumbers(-num1, num2);
        assertSwapTwoNumbers(num1,- num2);
        assertSwapTwoNumbers(-num1, -num2);
    }

    /**
     * Asserts that the {@code swap} method correctly swaps the two given integers.
     *
     * <p>It compares the result of {@code swap(num1, num2)} with the expected array {@code [num2, num1]}.</p>
     *
     * @param num1 the first number to be swapped
     * @param num2 the second number to be swapped
     */
    public void assertSwapTwoNumbers(int num1, int num2){
        assertArrayEquals(new int [] {num2, num1}, swap(num1, num2));
    }

}