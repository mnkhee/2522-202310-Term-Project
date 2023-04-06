package ca.bcit.comp2522.termproject.comp2522202310termproject360;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Icecream Test Class.
 * @author Joshua Chuah & Justin Oh
 * @version 2023
 */
public class IcecreamTest {
    /**
     * Tests getPassiveIncome() method.
     */
    @Test
    public void testGetPassiveIncome() {
        Icecream icecream = new Icecream();
        double expected = 0.0;
        double actual = icecream.getPassiveIncome();
        assertEquals(expected, actual, 0.0);
    }

    /**
     * Tests incrementPassiveValue() method.
     */
    @Test
    public void testIncrementPassiveValue() {
        Icecream icecream = new Icecream();
        icecream.incrementPassiveValue(99.0);
        double expected = 99.0;
        double actual = icecream.getPassiveIncome();
        assertEquals(expected, actual, 0.0);
    }

    /**
     * Tests setPassiveValue() method.
     */
    @Test
    public void testSetPassiveValue() {
        Icecream icecream = new Icecream();
        icecream.setPassiveValue(45.0);
        double expected = 45.0;
        double actual = icecream.getPassiveIncome();
        assertEquals(expected, actual, 0.0);
    }

    /**
     * Tests getCost() method.
     */
    @Test
    public void testGetCost() {
        Icecream icecream = new Icecream();
        double expected = 250000.0;
        double actual = icecream.getCost();
        assertEquals(expected, actual, 0.0);
    }

    /**
     * Tests setCost() method.
     */
    @Test
    public void testSetCost() {
        Icecream icecream = new Icecream();
        icecream.setCost(270000.0);
        double expected = 270000.0;
        double actual = icecream.getCost();
        assertEquals(expected, actual, 0.0);
    }

    /**
     * Tests getCount() method.
     */
    @Test
    public void testGetCount() {
        Icecream icecream = new Icecream();
        int expected = 0;
        int actual = icecream.getCount();
        assertEquals(expected, actual);
    }

    /**
     * Tests setCount() method.
     */
    @Test
    public void testSetCount() {
        Icecream icecream = new Icecream();
        icecream.setCount(5);
        int expected = 5;
        int actual = icecream.getCount();
        assertEquals(expected, actual);
    }

    /**
     * Tests incrementCount() method.
     */
    @Test
    public void testIncrementCount() {
        Icecream icecream = new Icecream();
        icecream.incrementCount();
        int expected = 1;
        int actual = icecream.getCount();
        assertEquals(expected, actual);
    }
}
