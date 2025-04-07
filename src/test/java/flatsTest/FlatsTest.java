package flatsTest;

import exceptions.CalculationException;
import exceptions.InvalidInputException;
import org.junit.jupiter.api.Test;

import static java.lang.Integer.MAX_VALUE;
import static flats.Flats.flatLocation;

import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.*;

class FlatsTest {

    /**
     * Error message for an invalid number of floors input in flat calculations.
     */
    final static String INVALID_FLOORS_INPUT_VALUE_MESSAGE =
            "Invalid input number of floors. Number from 1 to 2147483647 was expected, but '%s' was received.";

    /**
     * Error message for an invalid number of flats per floor in flat calculations.
     */
    final static String INVALID_FLATS_ON_FLOOR_INPUT_VALUE_MESSAGE =
            "Invalid input number of flats on floor. Number from 1 to 2147483647 was expected, but '%s' was received.";

    /**
     * Error message for an invalid flat number input.
     */
    final static String INVALID_FLAT_NUMBER_INPUT_VALUE_MESSAGE =
            "Invalid input number of flat. Number from 1 to 2147483647 was expected, but '%s' was received.";

    /**
     * Error message when calculations with the given flat parameters are not possible.
     */
    final static String INVALID_CALCULATIONS_MESSAGE =
            "Task can't be calculated with input arguments: %d floors, %d flats on floor.";

    @Test
    void limitValuesTest() {
        //граничні точки
        assertEqualsApart(1, 1, 1, 1, 1);
        assertEqualsApart(MAX_VALUE, 1, 1, 1, 1);
        assertEqualsApart(1, MAX_VALUE, 1, 1, 1);

        assertEqualsApart(MAX_VALUE, 1, MAX_VALUE, MAX_VALUE, 1);
        assertEqualsApart(1, 1, MAX_VALUE, 1, MAX_VALUE);
        assertEqualsApart(1, MAX_VALUE, MAX_VALUE, 1, 1);

        //сусідні точки
        assertEqualsApart(1, 1, 2, 1, 2);
        assertEqualsApart(1, 2, 1, 1, 1);
        assertEqualsApart(1, 2, 2, 1, 1);
        assertEqualsApart(2, 1, 1, 1, 1);
        assertEqualsApart(2, 1, 2, 2, 1);
        assertEqualsApart(2, 2, 1, 1, 1);
        assertEqualsApart(2, 2, 2, 1, 1);

        assertEqualsApart(MAX_VALUE, 1, 2, 2, 1);
        assertEqualsApart(MAX_VALUE - 1, 1, 1, 1, 1);
        assertEqualsApart(MAX_VALUE - 1, 1, 2, 2, 1);

        assertEqualsApart(1, MAX_VALUE, 2, 1, 1);
        assertEqualsApart(1, MAX_VALUE - 1, 1, 1, 1);
        assertEqualsApart(1, MAX_VALUE - 1, 2, 1, 1);

        assertEqualsApart(MAX_VALUE, 1, MAX_VALUE - 1, MAX_VALUE - 1, 1);
        assertEqualsApart(MAX_VALUE - 1, 1, MAX_VALUE, 1, 2);
        assertEqualsApart(MAX_VALUE - 1, 1, MAX_VALUE - 1, MAX_VALUE - 1, 1);

        assertEqualsApart(1, 1, MAX_VALUE - 1, 1, MAX_VALUE - 1);
        assertEqualsApart(1, 2, MAX_VALUE, 1, 1073741824);
        assertEqualsApart(1, 2, MAX_VALUE - 1, 1, 1073741823);
        assertEqualsApart(2, 1, MAX_VALUE, 1, 1073741824);
        assertEqualsApart(2, 1, MAX_VALUE - 1, 2, 1073741823);
        assertEqualsApart(2, 2, MAX_VALUE, 2, 536870912);
        assertEqualsApart(2, 2, MAX_VALUE - 1, 1, 536870912);

        assertEqualsApart(1, MAX_VALUE, MAX_VALUE - 1, 1, 1);
        assertEqualsApart(1, MAX_VALUE - 1, MAX_VALUE, 1, 2);
        assertEqualsApart(1, MAX_VALUE - 1, MAX_VALUE - 1, 1, 1);
    }

    @Test
    void floorConstTest() {
        //будинок 10-4
        //поверх=1
        assertEqualsApart(10, 4, 1, 1, 1);//перша квартира - 1 поверх 1 під'їзд
        assertEqualsApart(10, 4, 4, 1, 1);//остання квартира - 1 поверх 1 під'їзд
        //сусідні точки
        assertEqualsApart(10, 4, 2, 1, 1);
        assertEqualsApart(10, 4, 3, 1, 1);

        assertEqualsApart(10, 4, 1073741761, 1, 26843545);//перша квартира - 1 поверх 2 під'їзд
        assertEqualsApart(10, 4, 1073741764, 1, 26843545);//остання квартира - 1 поверх 2 під'їзд
        //сусідні точки
        assertEqualsApart(10, 4, 1073741762, 1, 26843545);
        assertEqualsApart(10, 4, 1073741763, 1, 26843545);

        //останній під'їзд для дому 10-4, 2 поверхи 53687092 під'їзд
        assertEqualsApart(10, 4, 2147483641, 1, 53687092);
        assertEqualsApart(10, 4, 2147483644, 1, 53687092);
        //сусідні точки
        assertEqualsApart(10, 4, 2147483642, 1, 53687092);
        assertEqualsApart(10, 4, 2147483643, 1, 53687092);

        //поверх=5
        assertEqualsApart(10, 4, 17, 5, 1);//перша квартира - 5 поверх 1 під'їзд
        assertEqualsApart(10, 4, 20, 5, 1);//остання квартира - 5 поверх 1 під'їзд
        //сусідні точки
        assertEqualsApart(10, 4, 18, 5, 1);
        assertEqualsApart(10, 4, 19, 5, 1);

        assertEqualsApart(10, 4, 1073741777, 5, 26843545);//перша квартира - 5 поверх 2 під'їзд
        assertEqualsApart(10, 4, 1073741780, 5, 26843545);//остання квартира - 5 поверх 2 під'їзд
        //сусідні точки
        assertEqualsApart(10, 4, 1073741778, 5, 26843545);
        assertEqualsApart(10, 4, 1073741779, 5, 26843545);

        assertEqualsApart(10, 4, 2147483617, 5, 53687091);//перша квартира - 5 поверх 53687091 під'їзд
        assertEqualsApart(10, 4, 2147483620, 5, 53687091);//остання квартира - 5 поверх 53687091 під'їзд
        //сусідні точки
        assertEqualsApart(10, 4, 2147483618, 5, 53687091);
        assertEqualsApart(10, 4, 2147483619, 5, 53687091);

        //межі множини поверх=10
        assertEqualsApart(10, 4, 37, 10, 1);//перша квартира - 10 поверх 1 під'їзд
        assertEqualsApart(10, 4, 40, 10, 1);//остання квартира - 10 поверх 1 під'їзд
        //сусідні точки
        assertEqualsApart(10, 4, 38, 10, 1);
        assertEqualsApart(10, 4, 39, 10, 1);

        assertEqualsApart(10, 4, 1073741797, 10, 26843545);//перша квартира - 10 поверх 26843545 під'їзд
        assertEqualsApart(10, 4, 1073741800, 10, 26843545);//остання квартира - 10 поверх 26843545 під'їзд

        //сусідні точки
        assertEqualsApart(10, 4, 1073741798, 10, 26843545);
        assertEqualsApart(10, 4, 1073741799, 10, 26843545);

        assertEqualsApart(10, 4, 2147483637, 10, 53687091);//перша квартира - 10 поверх 53687091 під'їзд
        assertEqualsApart(10, 4, 2147483640, 10, 53687091);//остання квартира - 10 поверх 53687091 під'їзд
        //сусідні точки
        assertEqualsApart(10, 4, 2147483638, 10, 53687091);
        assertEqualsApart(10, 4, 2147483639, 10, 53687091);

        //останній під'їзд для дому 10-4, 2 поверхи 53687092 під'їзд
        assertEqualsApart(10, 4, 2147483645, 2, 53687092);
        assertEqualsApart(10, 4, 2147483647, 2, 53687092);
        //сусідні точки
        assertEqualsApart(10, 4, 2147483646, 2, 53687092);

        //будинок 46339-5
        assertEqualsApart(46339, 5, 1, 1, 1);//перша квартира - 1 поверх 1 під'їзд
        assertEqualsApart(46339, 5, 5, 1, 1);//остання квартира - 1 поверх 1 під'їзд
        //сусідні точки
        assertEqualsApart(46339, 5, 2, 1, 1);
        assertEqualsApart(46339, 5, 4, 1, 1);

        assertEqualsApart(46339, 5, 1073442936, 1, 4634);//перша квартира - 1 поверх 1 під'їзд
        assertEqualsApart(46339, 5, 1073442940, 1, 4634);//остання квартира - 1 поверх 1 під'їзд
        //сусідні точки
        assertEqualsApart(46339, 5, 1073442937, 1, 4634);
        assertEqualsApart(46339, 5, 1073442939, 1, 4634);

        //останній під'їзд для будинку 46339-5
        assertEqualsApart(46339, 5, 2147349261, 1, 9269);
        assertEqualsApart(46339, 5, 2147349265, 1, 9269);

        //сусідні точки
        assertEqualsApart(46339, 5, 2147349262, 1, 9269);
        assertEqualsApart(46339, 5, 2147349264, 1, 9269);

        //поверх=26878
        assertEqualsApart(46339, 5, 134386, 26878, 1);
        assertEqualsApart(46339, 5, 134389, 26878, 1);
        //сусідні точки
        assertEqualsApart(46339, 5, 134387, 26878, 1);
        assertEqualsApart(46339, 5, 134388, 26878, 1);

        assertEqualsApart(46339, 5, 1073577321, 26878, 4634);
        assertEqualsApart(46339, 5, 1073577325, 26878, 4634);
        //сусідні точки
        assertEqualsApart(46339, 5, 1073577322, 26878, 4634);
        assertEqualsApart(46339, 5, 1073577324, 26878, 4634);

        assertEqualsApart(46339, 5, 2147483646, 26878, 9269);
        assertEqualsApart(46339, 5, 2147483647, 26878, 9269);
        //сусідні точки
        assertEqualsApart(46339, 5, 2147483642, 26877, 9269);
        assertEqualsApart(46339, 5, 2147483644, 26877, 9269);

        //поверх=46339
        assertEqualsApart(46339, 5, 231691, 46339, 1);//перша квартира - 46339 поверх 1 під'їзд
        assertEqualsApart(46339, 5, 231695, 46339, 1);//остання квартира - 46339 поверх 1 під'їзд
        //сусідні точки
        assertEqualsApart(46339, 5, 231692, 46339, 1);
        assertEqualsApart(46339, 5, 231694, 46339, 1);

        assertEqualsApart(46339, 5, 1073674626, 46339, 4634);//перша квартира - 1 поверх 1 під'їзд
        assertEqualsApart(46339, 5, 1073674630, 46339, 4634);//остання квартира - 1 поверх 1 під'їзд
        //сусідні точки
        assertEqualsApart(46339, 5, 1073674627, 46339, 4634);
        assertEqualsApart(46339, 5, 1073674629, 46339, 4634);

        assertEqualsApart(46339, 5, 2147349256, 46339, 9268);//перша квартира - 46339 поверх 9268 під'їзд
        assertEqualsApart(46339, 5, 2147349260, 46339, 9268);//остання квартира - 46339 поверх 9268 під'їзд
        //сусідні точки
        assertEqualsApart(46339, 5, 2147349257, 46339, 9268);
        assertEqualsApart(46339, 5, 2147349259, 46339, 9268);

    }

    @Test
    void floorEqualEntranceTest() {
        //будинок 100-5
        //1-1
        assertEqualsApart(10, 5, 1, 1, 1);
        assertEqualsApart(10, 5, 5, 1, 1);
        //сусідні точки
        assertEqualsApart(10, 5, 4, 1, 1);
        assertEqualsApart(10, 5, 6, 2, 1);

        //5-21474836
        assertEqualsApart(10, 5, 1073741771, 5, 21474836);
        assertEqualsApart(10, 5, 1073741775, 5, 21474836);
        //сусідні точки
        assertEqualsApart(10, 5, 1073741770, 4, 21474836);
        assertEqualsApart(10, 5, 1073741774, 5, 21474836);
        assertEqualsApart(10, 5, 1073741776, 6, 21474836);

        //10-21474836
        assertEqualsApart(10, 5, 1073741796, 10, 21474836);
        assertEqualsApart(10, 5, 1073741800, 10, 21474836);
        //сусідні точки
        assertEqualsApart(10, 5, 1073741795, 9, 21474836);
        assertEqualsApart(10, 5, 1073741799, 10, 21474836);
        assertEqualsApart(10, 5, 1073741801, 1, 21474837);

        //10-42949673
        assertEqualsApart(10, 5, 2147483646, 10, 42949673);
        assertEqualsApart(10, 5, 2147483647, 10, 42949673);
        //сусідні точки
        assertEqualsApart(10, 5, 2147483645, 9, 42949673);

        //будинок 46340-4
        //1-1
        assertEqualsApart(46340, 4, 1, 1, 1);
        assertEqualsApart(46340, 4, 4, 1, 1);
        //сусідні точки
        assertEqualsApart(46340, 4, 3, 1, 1);
        assertEqualsApart(46340, 4, 5, 2, 1);

        //5793-5793
        assertEqualsApart(46340, 4, 1073697797, 23170, 5793);
        assertEqualsApart(46340, 4, 1073697800, 23170, 5793);
        //сусідні точки
        assertEqualsApart(46340, 4, 1073697796, 23169, 5793);
        assertEqualsApart(46340, 4, 1073697799, 23170, 5793);
        assertEqualsApart(46340, 4, 1073697801, 23171, 5793);

        //11585-11585
        assertEqualsApart(46340, 4, 2147483645, 22012, 11586);
        assertEqualsApart(46340, 4, 2147483647, 22012, 11586);
        //сусідні точки
        assertEqualsApart(46340, 4, 2147483644, 22011, 11586);
        assertEqualsApart(46340, 4, 2147483646, 22012, 11586);
    }

    @Test
    void entrancesConstTest() {
        //будинок 7-4
        //під'їзд=1
        assertEqualsApart(7, 4, 1, 1, 1);
        assertEqualsApart(7, 4, 28, 7, 1);
        assertEqualsApart(7, 4, 5, 2, 1);
        assertEqualsApart(7, 4, 24, 6, 1);
        //сусідні точки
        assertEqualsApart(7, 4, 2, 1, 1);
        assertEqualsApart(7, 4, 27, 7, 1);
        assertEqualsApart(7, 4, 6, 2, 1);
        assertEqualsApart(7, 4, 4, 1, 1);
        assertEqualsApart(7, 4, 25, 7, 1);
        assertEqualsApart(7, 4, 23, 6, 1);
        assertEqualsApart(7, 4, 29, 1, 2);

        //під'їзд=76695845
        assertEqualsApart(7, 4, 2147483633, 1, 76695845);
        assertEqualsApart(7, 4, 2147483647, 4, 76695845);
        assertEqualsApart(7, 4, 2147483637, 2, 76695845);
        assertEqualsApart(7, 4, 2147483644, 3, 76695845);
        //сусідні точки
        assertEqualsApart(7, 4, 2147483634, 1, 76695845);
        assertEqualsApart(7, 4, 2147483636, 1, 76695845);
        assertEqualsApart(7, 4, 2147483646, 4, 76695845);
        assertEqualsApart(7, 4, 2147483637, 2, 76695845);
        assertEqualsApart(7, 4, 2147483645, 4, 76695845);
        assertEqualsApart(7, 4, 2147483643, 3, 76695845);
        assertEqualsApart(7, 4, 2147483632, 7, 76695844);

        //будинок 46342-5
        assertEqualsApart(46342, 5, 1, 1, 1);
        assertEqualsApart(46342, 5, 231710, 46342, 1);
        assertEqualsApart(46342, 5, 6, 2, 1);
        assertEqualsApart(46342, 5, 231705, 46341, 1);
        //сусідні точки
        assertEqualsApart(46342, 5, 2, 1, 1);
        assertEqualsApart(46342, 5, 231709, 46342, 1);
        assertEqualsApart(46342, 5, 7, 2, 1);
        assertEqualsApart(46342, 5, 5, 1, 1);
        assertEqualsApart(46342, 5, 231706, 46342, 1);
        assertEqualsApart(46342, 5, 231704, 46341, 1);
        assertEqualsApart(46342, 5, 231711, 1, 2);

        //під'їзд=9268
        assertEqualsApart(46342, 5, 2147256571, 1, 9268);
        assertEqualsApart(46342, 5, 2147483647, 45416, 9268);
        assertEqualsApart(46342, 5, 2147256576, 2, 9268);
        assertEqualsApart(46342, 5, 2147483645, 45415, 9268);
        //сусідні точки
        assertEqualsApart(46342, 5, 2147256572, 1, 9268);
        assertEqualsApart(46342, 5, 2147483646, 45416, 9268);
        assertEqualsApart(46342, 5, 2147256577, 2, 9268);
        assertEqualsApart(46342, 5, 2147256575, 1, 9268);
        assertEqualsApart(46342, 5, 2147483644, 45415, 9268);
    }

    @Test
    void subjectArea() {
        //будинок 163-10
        assertEqualsApart(163, 10, 1, 1, 1);
        assertEqualsApart(163, 10, 9, 1, 1);
        assertEqualsApart(163, 10, 10, 1, 1);
        assertEqualsApart(163, 10, 11, 2, 1);
        assertEqualsApart(163, 10, 12, 2, 1);

        assertEqualsApart(163, 10, 800, 80, 1);
        assertEqualsApart(163, 10, 802, 81, 1);
        assertEqualsApart(163, 10, 809, 81, 1);
        assertEqualsApart(163, 10, 810, 81, 1);
        assertEqualsApart(163, 10, 811, 82, 1);

        assertEqualsApart(163, 10, 1620, 162, 1);
        assertEqualsApart(163, 10, 1621, 163, 1);
        assertEqualsApart(163, 10, 1622, 163, 1);
        assertEqualsApart(163, 10, 1629, 163, 1);
        assertEqualsApart(163, 10, 1630, 163, 1);

        //будинок 5-4
        assertEqualsApart(5, 4, 1, 1, 1);
        assertEqualsApart(5, 4, 2, 1, 1);
        assertEqualsApart(5, 4, 4, 1, 1);
        assertEqualsApart(5, 4, 5, 2, 1);

        assertEqualsApart(5, 4, 16, 4, 1);
        assertEqualsApart(5, 4, 17, 5, 1);
        assertEqualsApart(5, 4, 18, 5, 1);
        assertEqualsApart(5, 4, 20, 5, 1);
        assertEqualsApart(5, 4, 21, 1, 2);

        assertEqualsApart(5, 4, 48, 2, 3);
        assertEqualsApart(5, 4, 49, 3, 3);
        assertEqualsApart(5, 4, 50, 3, 3);
        assertEqualsApart(5, 4, 52, 3, 3);
        assertEqualsApart(5, 4, 53, 4, 3);

        assertEqualsApart(5, 4, 96, 4, 5);
        assertEqualsApart(5, 4, 97, 5, 5);
        assertEqualsApart(5, 4, 98, 5, 5);
        assertEqualsApart(5, 4, 100, 5, 5);
        assertEqualsApart(5, 4, 101, 1, 6);

        assertEqualsApart(5, 4, 3381, 1, 170);
        assertEqualsApart(5, 4, 3382, 1, 170);
        assertEqualsApart(5, 4, 3384, 1, 170);
        assertEqualsApart(5, 4, 3385, 2, 170);

        assertEqualsApart(5, 4, 3396, 4, 170);
        assertEqualsApart(5, 4, 3397, 5, 170);
        assertEqualsApart(5, 4, 3398, 5, 170);
        assertEqualsApart(5, 4, 3400, 5, 170);

        assertEqualsApart(3, 4, 1, 1, 1);
        assertEqualsApart(3, 4, 2, 1, 1);
        assertEqualsApart(3, 4, 4, 1, 1);
        assertEqualsApart(3, 4, 5, 2, 1);

        assertEqualsApart(3, 4, 8, 2, 1);
        assertEqualsApart(3, 4, 9, 3, 1);
        assertEqualsApart(3, 4, 11, 3, 1);
        assertEqualsApart(3, 4, 12, 3, 1);

        assertEqualsApart(3, 4, 16, 1, 2);
        assertEqualsApart(3, 4, 17, 2, 2);
        assertEqualsApart(3, 4, 18, 2, 2);
        assertEqualsApart(3, 4, 20, 2, 2);
        assertEqualsApart(3, 4, 21, 3, 2);

        assertEqualsApart(3, 4, 25, 1, 3);
        assertEqualsApart(3, 4, 26, 1, 3);
        assertEqualsApart(3, 4, 28, 1, 3);
        assertEqualsApart(3, 4, 29, 2, 3);

        assertEqualsApart(3, 4, 31, 2, 3);
        assertEqualsApart(3, 4, 33, 3, 3);
        assertEqualsApart(3, 4, 34, 3, 3);
        assertEqualsApart(3, 4, 36, 3, 3);

        assertEqualsApart(9, 4, 1, 1, 1);
        assertEqualsApart(9, 4, 2, 1, 1);
        assertEqualsApart(9, 4, 4, 1, 1);
        assertEqualsApart(9, 4, 5, 2, 1);

        assertEqualsApart(9, 4, 32, 8, 1);
        assertEqualsApart(9, 4, 33, 9, 1);
        assertEqualsApart(9, 4, 34, 9, 1);
        assertEqualsApart(9, 4, 36, 9, 1);

        assertEqualsApart(9, 4, 73, 1, 3);
        assertEqualsApart(9, 4, 74, 1, 3);
        assertEqualsApart(9, 4, 76, 1, 3);
        assertEqualsApart(9, 4, 77, 2, 3);

        assertEqualsApart(9, 4, 80, 2, 3);
        assertEqualsApart(9, 4, 81, 3, 3);
        assertEqualsApart(9, 4, 82, 3, 3);
        assertEqualsApart(9, 4, 84, 3, 3);
        assertEqualsApart(9, 4, 85, 4, 3);

        assertEqualsApart(9, 4, 104, 8, 3);
        assertEqualsApart(9, 4, 105, 9, 3);
        assertEqualsApart(9, 4, 107, 9, 3);
        assertEqualsApart(9, 4, 108, 9, 3);

    }

    @Test
    void checkArithmeticsException() {
        assertThrowsCalculationException(1073741824, 2, 2147483647);
        assertThrowsCalculationException(9, 1073741823, 2147483647);
        assertThrowsCalculationException(1073741823, 3, 2147483647);
        assertThrowsCalculationException(6, 429496729, 2147483647);
        assertThrowsCalculationException(536870912, 5, 2147483647);
        assertThrowsCalculationException(4, 536870912, 2147483647);
        assertThrowsCalculationException(429496729, 7, 2147483647);
        assertThrowsCalculationException(2147483647, 2147483647, 2147483647);
    }

    @Test
    void invalidFloorsInputTest() {
        assertThrowsIllegalFloorsException(0, 4, 1);
        assertThrowsIllegalFloorsException(-1, 4, 1);
        assertThrowsIllegalFloorsException(-1073741824, 4, 1);
        assertThrowsIllegalFloorsException(-2147483647, 4, 1);
        assertThrowsIllegalFloorsException(-2147483648, 4, 1);
    }

    @Test
    void invalidFlatLocationOnFloorInputTest() {
        assertThrowsIllegalFlatLocationOnFloorException(9, 0, 4);
        assertThrowsIllegalFlatLocationOnFloorException(9, -1, 4);
        assertThrowsIllegalFlatLocationOnFloorException(9, -1073741824, 4);
        assertThrowsIllegalFlatLocationOnFloorException(9, -2147483647, 4);
        assertThrowsIllegalFlatLocationOnFloorException(9, -2147483648, 4);
    }

    @Test
    void invalidFlatNumberInputTest() {
        assertThrowsIllegalFlatNumberException(5, 4, 0);
        assertThrowsIllegalFlatNumberException(5, 4, -1);
        assertThrowsIllegalFlatNumberException(5, 4, -1073741824);
        assertThrowsIllegalFlatNumberException(5, 4, -2147483647);
        assertThrowsIllegalFlatNumberException(5, 4, -2147483648);
    }

    @Test
    void randomInputValuesTest() {
        assertEqualsApart(28331, 4671, 19647, 5, 1);
        assertEqualsApart(12230, 137, 21956, 161, 1);
        assertEqualsApart(32166, 3897, 33949, 9, 1);
        assertEqualsApart(947606188, 2, 242678415, 121339208, 1);
        assertEqualsApart(1149970714, 1, 344003267, 344003267, 1);
        assertEqualsApart(1966868838, 1, 1148872291, 1148872291, 1);
        assertEqualsApart(903921825, 2, 1408217267, 704108634, 1);
        assertEqualsApart(86753, 6, 19825555, 7646, 39);
        assertEqualsApart(6466568, 2, 712615615, 646568, 56);
        assertEqualsApart(3654686, 5, 551436116, 646644, 31);
    }

    @Test
    void specialValuesTest() {
        assertEqualsApart(9, 4, 51, 4, 2);
        assertEqualsApart(9, 4, 50, 4, 2);
        assertEqualsApart(9, 4, 74, 1, 3);
        assertEqualsApart(9, 4, 106, 9, 3);
        assertEqualsApart(9, 4, 61, 7, 2);
        assertEqualsApart(26, 4, 144, 10, 2);
        assertEqualsApart(20, 2, 7, 4, 1);
        assertEqualsApart(14, 6, 301, 9, 4);
        assertEqualsApart(20, 2, 280, 20, 7);
        assertEqualsApart(20, 19, 1502, 20, 4);
    }

    /**
     * Asserts that the method {@link flats.Flats#flatLocation(int, int, int)} correctly calculates the floor and entrance for the given apartment number.
     * It compares the actual result with the expected floor and entrance values, and fails the test if an exception is thrown.
     *
     * @param floors           the total number of floors in the apartment building
     * @param flatsOnFloor     the number of flats on each floor
     * @param flatNumber       the specific flat number for which the floor and entrance are being calculated
     * @param expectedFloor    the expected floor number for the given flat number
     * @param expectedEntrance the expected entrance number for the given flat number
     */
    public void assertEqualsApart(int floors, int flatsOnFloor, int flatNumber, int expectedFloor, int expectedEntrance) {
        try {
            assertArrayEquals(new int[]{expectedFloor, expectedEntrance}, flatLocation(floors, flatsOnFloor, flatNumber));
        } catch (InvalidInputException | CalculationException e) {
            fail("Expected no InvalidInputException or CalculationException, but got one.");
        }
    }

    /**
     * Asserts that the method {@link flats.Flats#flatLocation(int, int, int)} throws {@link InvalidInputException}
     * with the correct error message when an invalid floor number is provided.
     *
     * @param floor        the floor number that is being validated
     * @param flatsOnFloor the number of flats on each floor
     * @param flatNumber   the flat number whose validity is being checked
     */
    public void assertThrowsIllegalFloorsException(int floor, int flatsOnFloor, int flatNumber) {
        String expectedMessage = format(INVALID_FLOORS_INPUT_VALUE_MESSAGE, floor);

        assertThrowsInvalidArgument(floor, flatsOnFloor, flatNumber, expectedMessage);
    }

    /**
     * Asserts that the method {@link flats.Flats#flatLocation(int, int, int)} throws {@link InvalidInputException} is thrown when an invalid number of flats on a floor is provided.
     *
     * @param floor        the total number of floors in the building
     * @param flatsOnFloor the number of flats on each floor
     * @param flatNumber   the flat number for which the floor and entrance are being calculated
     */
    public void assertThrowsIllegalFlatLocationOnFloorException(int floor, int flatsOnFloor, int flatNumber) {
        String expectedMessage = format(INVALID_FLATS_ON_FLOOR_INPUT_VALUE_MESSAGE, flatsOnFloor);

        assertThrowsInvalidArgument(floor, flatsOnFloor, flatNumber, expectedMessage);
    }

    /**
     * Asserts that the method {@link flats.Flats#flatLocation(int, int, int)} throws {@link InvalidInputException} is thrown when an invalid flat number is provided.
     *
     * @param floor        the total number of floors in the building
     * @param flatsOnFloor the number of flats on each floor
     * @param flatNumber   the flat number for which the floor and entrance are being calculated
     */
    public void assertThrowsIllegalFlatNumberException(int floor, int flatsOnFloor, int flatNumber) {
        String expectedMessage = format(INVALID_FLAT_NUMBER_INPUT_VALUE_MESSAGE, flatNumber);

        assertThrowsInvalidArgument(floor, flatsOnFloor, flatNumber, expectedMessage);
    }

    /**
     * Asserts that the method {@link flats.Flats#flatLocation(int, int, int)} throws {@link InvalidInputException} is thrown when invalid input is provided (e.g., invalid floor, flats on floor, or flat number).
     *
     * @param floor           the total number of floors in the building
     * @param flatsOnFloor    the number of flats on each floor
     * @param flatNumber      the flat number for which the floor and entrance are being calculated
     * @param expectedMessage the expected error message to be thrown
     */
    public void assertThrowsInvalidArgument(int floor, int flatsOnFloor, int flatNumber, String expectedMessage) {
        try {
            flatLocation(floor, flatsOnFloor, flatNumber);

            fail("Expected InvalidInputException to be thrown.");

        } catch (InvalidInputException e) {
            assertEquals(expectedMessage, e.getMessage());

        } catch (CalculationException e) {
            fail("Expected InvalidInputException to be thrown, but got CalculationException.");
        }
    }

    /**
     * Asserts that a {@link CalculationException} is thrown when the provided input values are invalid
     * for calculating the floor and entrance for a flat.
     *
     * @param floor        the total number of floors in the building
     * @param flatsOnFloor the number of flats on each floor
     * @param flatNumber   the flat number for which the floor and entrance are being calculated
     */
    public void assertThrowsCalculationException(int floor, int flatsOnFloor, int flatNumber) {
        try {
            flatLocation(floor, flatsOnFloor, flatNumber);

            fail("Expected InvalidInputException to be thrown.");

        } catch (CalculationException e) {
            String expectedMessage = String.format(INVALID_CALCULATIONS_MESSAGE, floor, flatsOnFloor);

            assertEquals(expectedMessage, e.getMessage());

        } catch (InvalidInputException e) {
            fail("Expected CalculationException to be thrown, but got InvalidInputException.");
        }
    }

}