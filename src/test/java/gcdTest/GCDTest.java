package gcdTest;

import exceptions.CalculationException;
import org.junit.jupiter.api.Test;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;
import static gcd.GCD.gcdOfFour;

import static org.junit.jupiter.api.Assertions.*;

class GCDTest {

    /**
     * Error message when modulus of Integer.MIN_VALUE is attempted.
     */
    private static final String INVALID_RESULT_MESSAGE = "Absolut value of a -2147483648 can't be calculated.";

    @Test
    void limitValuesTest() {
        //вершини області визначення
        assertGCD(MAX_VALUE, MAX_VALUE, MAX_VALUE, MAX_VALUE, MAX_VALUE);
        assertGCD(1, MAX_VALUE, MIN_VALUE, MIN_VALUE, MIN_VALUE);
        assertGCD(1, MAX_VALUE, MAX_VALUE, MIN_VALUE, MIN_VALUE);
        assertGCD(1, MAX_VALUE, MAX_VALUE, MAX_VALUE, MIN_VALUE);

        //сусідні значення
        assertGCD(MAX_VALUE, MIN_VALUE + 1, MIN_VALUE + 1, MIN_VALUE + 1, MIN_VALUE + 1);
        assertGCD(1, MIN_VALUE + 2, MIN_VALUE + 1, MIN_VALUE + 1, MIN_VALUE + 1);
        assertGCD(1, MIN_VALUE + 2, MIN_VALUE + 2, MIN_VALUE + 1, MIN_VALUE + 1);
        assertGCD(1, MIN_VALUE + 2, MIN_VALUE + 2, MIN_VALUE + 2, MIN_VALUE + 1);
        assertGCD(MAX_VALUE - 1, MIN_VALUE + 2, MIN_VALUE + 2, MIN_VALUE + 2, MIN_VALUE + 2);

        assertGCD(1, MAX_VALUE - 1, MAX_VALUE, MAX_VALUE, MAX_VALUE);
        assertGCD(1, MAX_VALUE - 1, MAX_VALUE - 1, MAX_VALUE, MAX_VALUE);
        assertGCD(1, MAX_VALUE - 1, MAX_VALUE - 1, MAX_VALUE - 1, MAX_VALUE);
        assertGCD(MAX_VALUE - 1, MAX_VALUE - 1, MAX_VALUE - 1, MAX_VALUE - 1, MAX_VALUE - 1);

        assertGCD(1, MAX_VALUE, MIN_VALUE, MIN_VALUE, MIN_VALUE + 1);
        assertGCD(1, MAX_VALUE, MIN_VALUE, MIN_VALUE + 1, MIN_VALUE + 1);
        assertGCD(MAX_VALUE, MAX_VALUE, MIN_VALUE + 1, MIN_VALUE + 1, MIN_VALUE + 1);
        assertGCD(2, MAX_VALUE - 1, MIN_VALUE, MIN_VALUE, MIN_VALUE);
        assertGCD(1, MAX_VALUE - 1, MIN_VALUE, MIN_VALUE, MIN_VALUE + 1);
        assertGCD(1, MAX_VALUE - 1, MIN_VALUE, MIN_VALUE + 1, MIN_VALUE + 1);
        assertGCD(1, MAX_VALUE - 1, MIN_VALUE + 1, MIN_VALUE + 1, MIN_VALUE + 1);

        assertGCD(1, MAX_VALUE, MAX_VALUE, MIN_VALUE, MIN_VALUE + 1);
        assertGCD(MAX_VALUE, MAX_VALUE, MAX_VALUE, MIN_VALUE + 1, MIN_VALUE + 1);
        assertGCD(1, MAX_VALUE, MAX_VALUE - 1, MIN_VALUE, MIN_VALUE);
        assertGCD(1, MAX_VALUE, MAX_VALUE - 1, MIN_VALUE, MIN_VALUE + 1);
        assertGCD(1, MAX_VALUE, MAX_VALUE - 1, MIN_VALUE + 1, MIN_VALUE + 1);
        assertGCD(2, MAX_VALUE - 1, MAX_VALUE - 1, MIN_VALUE, MIN_VALUE);
        assertGCD(1, MAX_VALUE - 1, MAX_VALUE - 1, MIN_VALUE, MIN_VALUE + 1);
        assertGCD(1, MAX_VALUE - 1, MAX_VALUE - 1, MIN_VALUE + 1, MIN_VALUE + 1);

        assertGCD(MAX_VALUE, MAX_VALUE, MAX_VALUE, MAX_VALUE, MIN_VALUE + 1);
        assertGCD(1, MAX_VALUE, MAX_VALUE, MAX_VALUE - 1, MIN_VALUE);
        assertGCD(1, MAX_VALUE, MAX_VALUE, MAX_VALUE - 1, MIN_VALUE + 1);
        assertGCD(1, MAX_VALUE, MAX_VALUE - 1, MAX_VALUE - 1, MIN_VALUE);
        assertGCD(1, MAX_VALUE, MAX_VALUE - 1, MAX_VALUE - 1, MIN_VALUE + 1);
        assertGCD(2, MAX_VALUE - 1, MAX_VALUE - 1, MAX_VALUE - 1, MIN_VALUE);
        assertGCD(1, MAX_VALUE - 1, MAX_VALUE - 1, MAX_VALUE - 1, MIN_VALUE + 1);
    }

    @Test
    void primeNumbersTest(){
        //найбільші та найменші значення на обл. визначення
        assertGCD(1, 2147483647, 2147483641, 2147483629, 2147483613);
        assertGCD(1, 1, 2, 3, 5);

        //сусідні значення
        assertGCD(1, 2, 3,5, 7);
        assertGCD(1, 2147483607, 2147483601, 2147483593, 2147483587);

        //всередині класу
        assertGCD(1, 7, 13, 19, 23);
        assertGCD(1, 11, 17, 29, 31);
        assertGCD(1, 13, 29, 31, 37);
        assertGCD(1, 19, 41, 67, 83);
        assertGCD(1, 20011, 20021, 20023, 20029);
        assertGCD(1, 400009, 400031, 400037, 400039);
        assertGCD(1, 500009, 500029, 500041, 500051);
        assertGCD(1, 1200023, 1700021, 2300021, 800029);
    }

    @Test
    void mutuallyPrimeNumbersTest(){
        //границі класу
        assertGCD(1, 2147483647, 2147483646, 2147483645, 2147483644);

        //сусідні точки
        assertGCD(1, 2147483647, 2147483646, 2147483645, 2147483643);
        assertGCD(1, 2147483647, 2147483646, 2147483644, 2147483643);
        assertGCD(1, 2147483647, 2147483645, 2147483644, 2147483643);
        assertGCD(1, 2147483646, 2147483645, 2147483644, 2147483643);

        //всередині класу
        assertGCD(1, 9, 49, 25, 16);
        assertGCD(1, 25, 8, 9, 64);
        assertGCD(1, 16, 100, 25, 14);
        assertGCD(1, 123457, 234569, 345677, 456781);
        assertGCD(1, 999331, 888667, 777889, 666971);
        assertGCD(1, 1001211, 2023, 3307, 5009);
        assertGCD(1, 1456823, 11, 6856871, 598755);
    }

    @Test
    void nokEvenTwoTest(){
        //границі класу
        assertGCD(2, 2147483646, 2147483644, 2147483642, 2147483640);

        //сусідні точки
        assertGCD(2, 2147483646, 2147483644, 2147483642, 2147483638);
        assertGCD(2, 2147483646, 2147483644, 2147483640, 2147483638);
        assertGCD(2, 2147483646, 2147483642, 2147483640, 2147483638);
        assertGCD(2, 2147483644, 2147483642, 2147483640, 2147483638);

        //всередині класу
        assertGCD(2, 4, 20, 6, 8);
        assertGCD(4, 1496820, 4580956, 457776, 46956);
        assertGCD(8, 38896, 516120, 2426424, 2261880);
        assertGCD(64, 19066432, 46889024, 1622208, 227392);
        assertGCD(1024, 7332864, 182733824, 65881088, 9244672);
        assertGCD(128, 4977280, 2272128, 650624, 15159936);
        assertGCD(1456, 3204656, 6113744, 10467184, 52397072);
    }

    @Test
    void nokEvenThreeTest(){
        //границі класу
        assertGCD(3, 2147483646, 2147483643, 2147483640, 2147483637);

        //сусідні точки
        assertGCD(3, 2147483646, 2147483643, 2147483640, 2147483634);
        assertGCD(3, 2147483646, 2147483643, 2147483637, 2147483634);
        assertGCD(3, 2147483646, 2147483640, 2147483637, 2147483634);
        assertGCD(3, 2147483643, 2147483640, 2147483637, 2147483634);

        //всередині класу
        assertGCD(3, 9, 18, 81, 102);
        assertGCD(33, 3461931, 227271, 443289, 42239109);
        assertGCD(123, 47355, 2105637, 1085721, 510204);
        assertGCD(81, 6136317, 601749, 7804107, 6912945);
        assertGCD(162, 30294, 3357126, 7935570, 48392154);
        assertGCD(93, 17391, 88040589, 5690019, 15560853);
        assertGCD(1416, 202488, 4577928, 11400216, 14730648);
    }

    @Test
    void nokEvenFiveTest(){
        //границі класу
        assertGCD(5, 2147483645, 2147483640, 2147483635, 2147483630);

        //сусідні точки
        assertGCD(5, 2147483645, 2147483640, 2147483635, 2147483625);
        assertGCD(5, 2147483645, 2147483640, 2147483630, 2147483625);
        assertGCD(5, 2147483645, 2147483635, 2147483630, 2147483625);
        assertGCD(5, 2147483640, 2147483635, 2147483630, 2147483625);

        //всередині класу
        assertGCD(5, 75, 1000, 115, 95);
        assertGCD(35, 2695, 321685, 13545, 4682055);
        assertGCD(1245, 178035, 486795, 3873195, 8043945);
        assertGCD(105, 45930255, 28731885, 23192505, 7948605);
        assertGCD(1265, 1956955, 30548485, 681835, 10184515);
        assertGCD(145, 20735, 521855, 1508435, 1227135);
        assertGCD(655, 93665, 10742655, 286235, 4432385);
    }

    @Test
    void nokEvenSevenTest(){
        //границі класу
        assertGCD(7, 2147483646, 2147483639, 2147483632, 2147483625);

        //сусідні точки
        assertGCD(7, 2147483646, 2147483639, 2147483632, 2147483618);
        assertGCD(7, 2147483646, 2147483639, 2147483625, 2147483618);
        assertGCD(7, 2147483646, 2147483632, 2147483625, 2147483618);
        assertGCD(7, 2147483639, 2147483632, 2147483625, 2147483618);

        //всередині класу
        assertGCD(7, 14, -49, 63, 105);
        assertGCD(91, 1001, 182, 273, 364);
        assertGCD(21007, 273091, 42014, 63021, 84028);
        assertGCD(49049, 637637, 98098, 147147, 196196);
        assertGCD(182, 26026, 58786, 712166, 3289286);
        assertGCD(364, 92092, 491036, 191828, 3566108);
        assertGCD(105, 15015, 380205, 2128665, 239295);
    }

    @Test
    void notMultipleToOneInputNumberTest(){
        //границі класу
        assertGCD(4, 2147483644, 2147483640, 2147483636, 2147483632);

        //сусідні точки
        assertGCD(6, 2147483646, 2147483640, 2147483634, 2147483628);
        assertGCD(8, 2147483640, 2147483632, 2147483624, 2147483616);
        assertGCD(9, 2147483646, 2147483637, 2147483628, 2147483619);

        //всередині класу
        assertGCD(17, 2431, 811801, -166549, 91307);
        assertGCD(83, 913, -26809, 460733, 182683);
        assertGCD(451, 4961, 99671, 3734731, 27511);
        assertGCD(653, 7183, 344131, 880897, -5764031);
        assertGCD(761, -145496351, 158288, 163812099, -6994351);
        assertGCD(983, 10813, -16711, 30473, 1019371);
        assertGCD(161, -1479751, 30601109, 2703029, -306367061);
        assertGCD(10009, 91992719,1902400621, 168041101, -1011919909);
    }

    @Test
    void multipleToOneNumberTest(){
        //границі класу
        assertGCD(357913941, 357913941, 715827882, 1073741823, 2147483646);

        //сусідні значення
        assertGCD(268435455, 268435455, 536870910, 1073741820, 2147483640);
        assertGCD(79536431, 79536431, 238609293, 715827879, 2147483637);

        //всередині класу
        assertGCD(10, 10, 20, 30, 100);
        assertGCD(15, 15, 75, 45, 105);
        assertGCD(25, -125, 25, 75, -250);
        assertGCD(43, 25800, 43, 86, 5160);
        assertGCD(101, 202, 101, 30300, 404);
        assertGCD(12768, 12768, 140448, 268128, 242592);
        assertGCD(16823, 16823, 319637, 1699123, 1329017);
        assertGCD(964, 2208524, 964, 1707244, 463684);
        assertGCD(49049, 49049, 98098, 147147, 196196);
    }

    @Test
    void sameNumbersTest(){
        //межі класу
        assertGCD(2147483645, 2147483645, 2147483645, 2147483645, 2147483645);

        //сусідні значення
        assertGCD(2147483644, 2147483644, 2147483644, 2147483644, 2147483644);
        assertGCD(2147483643, 2147483643, 2147483643, 2147483643, 2147483643);

        //всередині класу
        assertGCD(1, -1, -1, -1, -1);
        assertGCD(86952, 86952, 86952, 86952, 86952);
        assertGCD(1789966563, -1789966563, -1789966563, -1789966563, -1789966563);
        assertGCD(2112356, 2112356, 2112356, 2112356, 2112356);
        assertGCD(145987656, 145987656, 145987656, 145987656, 145987656);
        assertGCD(2145683598, -2145683598, -2145683598, -2145683598, -2145683598);
        assertGCD(4561, -4561, -4561, -4561, -4561);
        assertGCD(31459, 31459, 31459, 31459, 31459);
        assertGCD(7345, -7345, -7345, -7345, -7345);

    }

    @Test
    void zeroInInputTest(){
        assertGCD(0, 0, 0, 0, 0);

        //границі класу
        assertGCD(2147483647, 0, 2147483647, 2147483647, 2147483647);

        //сусідні значення
        assertGCD(1, 0, 2147483647, 2147483647, 2147483646);
        assertGCD(1, 0, 2147483647, 2147483646, 2147483646);
        assertGCD(2147483646, 0, 2147483646, 2147483646, 2147483646);

        //всередині класу
        assertGCD(10, 0, 10, 20, 50);
        assertGCD(13, 0, 0, 1729, 169);
        assertGCD(63, 0, 0, 0, 63);
        assertGCD(78923, 0, 0, 0, 78923);
    }

    @Test
    void invalidInputDataOverLimit(){
        assertGCDThrowsCalculationException(MIN_VALUE, 0, 0, 0);
        assertGCDThrowsCalculationException(MIN_VALUE, MIN_VALUE, 0, 0);
        assertGCDThrowsCalculationException(MIN_VALUE, MIN_VALUE, MIN_VALUE, 0);
        assertGCDThrowsCalculationException(MIN_VALUE, MIN_VALUE, MIN_VALUE, MIN_VALUE);
    }

    @Test
    void subjectArea(){
        assertGCD(1, 2147483643, 2147483642, 214748641, 2147483640);

        assertGCD(2, 2147483640, 2147483638, 2147483636, 2147483634);
        assertGCD(3, 2147483640, 2147483637, 2147483634, 2147483631);
        assertGCD(4, 2147483640, 2147483620, 16, 8);
        assertGCD(5, 2147483645, 2147483640, 2147483635, 2147483630);
        assertGCD(167, 1886599, 2540070, 9175815, 24454311);
        assertGCD(14, 2187458, 19837818, 618310, 1596);
        assertGCD(11, 101101, 2090759, 1798379, 11154143);
        assertGCD(12, 36, 144, 24, 108);
        assertGCD(3, 11442, 360, 81, 1203);
        assertGCD(15, 135, 165, 195, 255);
        assertGCD(36, 324, 2016, 468, 720);
        assertGCD(16, 144, 896, 208, 3360);
        assertGCD(30, 2700, 990, 60, 1260);
    }

    @Test
    void randomValues(){
        assertGCD(1, -515929210, -692535889, 882746751, 956640265);
        assertGCD(1, 1762580508, -940939479, 1647930514, 34152306);
        assertGCD(2, 205932132, -1424928680, 1566354896, -574358490);
        assertGCD(1, 1596790640, -1494637655, 1608692106, -1340011645);
        assertGCD(3, 3063, 606060, 909090, 1212120);
        assertGCD(1, -1070333028, 1136690514, 679900937,-746967096);
        assertGCD(3, 63003, 84006, 105009, 126012);
        assertGCD(1, -931114359, -1608922582, 521190676, -1341787339);
        assertGCD(2, -16580504, 900253588, 262230514, 45664026);
        assertGCD(3, 1500033, 210006, 270009, 330012);

    }

    @Test
    void specialValues(){
        assertGCD(4, 12, 4, 16, 8);
        assertGCD(1, 20, 7, 20, 2);
        assertGCD(1, 13, 7, 19, 70);
        assertGCD(1, 6, 12, 19, 38);
        assertGCD(2, 172, 2, 50, 4);
        assertGCD(5, 25, 5, 35, 15);
        assertGCD(4, 2012, 12, 4, 36);
        assertGCD(1, 380, 638, 223, 875);
        assertGCD(1, 7, 30, 31, 9);
        assertGCD(2, 2, 30, 24, 8);
    }

    /**
     * Asserts that the method {@link gcd.GCD#gcdOfFour(int, int, int, int)} correctly calculates the GCD of four integers for various permutations
     * and sign variations of the inputs.
     *
     * @param expected the expected GCD result
     * @param a the first integer input
     * @param b the second integer input
     * @param c the third integer input
     * @param d the fourth integer input
     */
    public void assertGCD(int expected, int a, int b, int c, int d) {
        assertGCDDifferentSigns(expected, a, b, c, d);
        assertGCDDifferentSigns(expected, a, b, d, c);
        assertGCDDifferentSigns(expected, a, c, d, b);
        assertGCDDifferentSigns(expected, a, d, b, c);
        assertGCDDifferentSigns(expected, a, d, c, b);
        assertGCDDifferentSigns(expected, b, a, c, d);
        assertGCDDifferentSigns(expected, b, a, d, c);
        assertGCDDifferentSigns(expected, b, c, a, d);
        assertGCDDifferentSigns(expected, b, c, d, a);
        assertGCDDifferentSigns(expected, b, d, a, c);
        assertGCDDifferentSigns(expected, b, d, c, a);
        assertGCDDifferentSigns(expected, c, a, b, d);
        assertGCDDifferentSigns(expected, c, a, d, b);
        assertGCDDifferentSigns(expected, c, b, a, d);
        assertGCDDifferentSigns(expected, c, b, d, a);
        assertGCDDifferentSigns(expected, c, d, a, b);
        assertGCDDifferentSigns(expected, c, d, b, a);
        assertGCDDifferentSigns(expected, d, a, b, c);
        assertGCDDifferentSigns(expected, d, a, c, b);
        assertGCDDifferentSigns(expected, d, b, a, c);
        assertGCDDifferentSigns(expected, d, b, c, a);
        assertGCDDifferentSigns(expected, d, c, a, b);
        assertGCDDifferentSigns(expected, d, c, b, a);
        assertGCDDifferentSigns(expected, a, c, b, d);

    }

    /**
     * Asserts that the method {@link gcd.GCD#gcdOfFour(int, int, int, int)} correctly calculates the GCD of four
     * integers for different sign combinations.
     *
     * @param expected the expected GCD result
     * @param a the first integer input
     * @param b the second integer input
     * @param c the third integer input
     * @param d the fourth integer input
     */
    public void assertGCDDifferentSigns(int expected, int a, int b, int c, int d){
        assertGCDResult(expected, a, b, c, d);
        assertGCDResult(expected, a, b, c, -d);
        assertGCDResult(expected, a, b, -c, d);
        assertGCDResult(expected, a, b, -c, -d);
        assertGCDResult(expected, a, -b, c, d);
        assertGCDResult(expected, a, -b, c, -d);
        assertGCDResult(expected, a, -b, -c, d);
        assertGCDResult(expected, a, -b, -c, -d);
        assertGCDResult(expected, -a, b, c, d);
        assertGCDResult(expected, -a, b, c, -d);
        assertGCDResult(expected, -a, b, -c, d);
        assertGCDResult(expected, -a, b, -c, -d);
        assertGCDResult(expected, -a, -b, c, d);
        assertGCDResult(expected, -a, -b, c, -d);
        assertGCDResult(expected, -a, -b, -c, d);
        assertGCDResult(expected, -a, -b, -c, -d);
    }

    /**
     * Asserts that the method {@link gcd.GCD#gcdOfFour(int, int, int, int)} correctly calculates the GCD of four integers.
     *
     * <p>This method checks whether the GCD of the input integers is calculated correctly and compares the result with the
     * expected value. If an exception occurs during the calculation, it fails the test.</p>
     *
     * @param expected the expected GCD result
     * @param a the first integer input
     * @param b the second integer input
     * @param c the third integer input
     * @param d the fourth integer input
     */
    public void assertGCDResult(int expected, int a, int b, int c, int d){
        try{
            assertEquals(expected, gcdOfFour(a, b, c, d));
        }catch (CalculationException e){
            fail("Expected no CalculationException, but got one.");
        }
    }

    /**
     * Asserts that the {@link gcd.GCD#gcdOfFour(int, int, int, int)} method throws a {@link CalculationException}
     * for various permutations of four integer values.
     *
     * <p>This method tests all possible permutations of four input integers to ensure that the
     * {@link gcd.GCD#gcdOfFour(int, int, int, int)} method correctly throws a {@link CalculationException} for invalid
     * or edge case inputs.</p>
     *
     * @param a the first integer input
     * @param b the second integer input
     * @param c the third integer input
     * @param d the fourth integer input
     */
    public void assertGCDThrowsCalculationException(int a, int b, int c, int d){
        assertThrowsCalculationException(a, b, c, d);
        assertThrowsCalculationException(a, b, d, c);
        assertThrowsCalculationException(a, c, d, b);
        assertThrowsCalculationException(a, d, b, c);
        assertThrowsCalculationException(a, d, c, b);
        assertThrowsCalculationException(b, a, c, d);
        assertThrowsCalculationException(b, a, d, c);
        assertThrowsCalculationException(b, c, a, d);
        assertThrowsCalculationException(b, c, d, a);
        assertThrowsCalculationException(b, d, a, c);
        assertThrowsCalculationException(b, d, c, a);
        assertThrowsCalculationException(c, a, b, d);
        assertThrowsCalculationException(c, a, d, b);
        assertThrowsCalculationException(c, b, a, d);
        assertThrowsCalculationException(c, b, d, a);
        assertThrowsCalculationException(c, d, a, b);
        assertThrowsCalculationException(c, d, b, a);
        assertThrowsCalculationException(d, a, b, c);
        assertThrowsCalculationException(d, a, c, b);
        assertThrowsCalculationException(d, b, a, c);
        assertThrowsCalculationException(d, b, c, a);
        assertThrowsCalculationException(d, c, a, b);
        assertThrowsCalculationException(d, c, b, a);
        assertThrowsCalculationException(a, c, b, d);


    }

    /**
     * Asserts that the {@link gcd.GCD#gcdOfFour(int, int, int, int)} method throws a {@link CalculationException} for the given set of four integer values.
     *
     * @param a the first integer input
     * @param b the second integer input
     * @param c the third integer input
     * @param d the fourth integer input
     */
    public void assertThrowsCalculationException(int a, int b, int c, int d) {
        try{
            gcdOfFour(a, b, c, d);
            fail("Expected CalculationException to be thrown");
        }catch (CalculationException e){
            assertEquals(INVALID_RESULT_MESSAGE, e.getMessage());
        }
    }

    }