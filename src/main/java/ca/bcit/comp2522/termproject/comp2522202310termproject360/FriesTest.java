package ca.bcit.comp2522.termproject.comp2522202310termproject360;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Fries Test Class.
 * @author Joshua Chuah & Justin Oh
 * @version 2023
 */
public class FriesTest {
    /**
     * Tests getPassiveIncome() method.
     */
    @Test
    public void testGetPassiveIncome() {
        Fries fries = new Fries();
        double expected = 0.0;
        double actual = fries.getPassiveIncome();
        assertEquals(expected, actual, 0.0);
    }

    /**
     * Tests incrementPassiveValue() method.
     */
    @Test
    public void testIncrementPassiveValue() {
        Fries fries = new Fries();
        fries.incrementPassiveValue(5.0);
        double expected = 5.0;
        double actual = fries.getPassiveIncome();
        assertEquals(expected, actual, 0.0);
    }

    /**
     * Tests setPassiveValue() method.
     */
    @Test
    public void testSetPassiveValue() {
        Fries fries = new Fries();
        fries.setPassiveValue(2.5);
        double expected = 2.5;
        double actual = fries.getPassiveIncome();
        assertEquals(expected, actual, 0.0);
    }

    /**
     * Tests getCost() method.
     */
    @Test
    public void testGetCost() {
        Fries fries = new Fries();
        double expected = 1000.0;
        double actual = fries.getCost();
        assertEquals(expected, actual, 0.0);
    }

    /**
     * Tests setCost() method.
     */
    @Test
    public void testSetCost() {
        Fries fries = new Fries();
        fries.setCost(1500.0);
        double expected = 1500.0;
        double actual = fries.getCost();
        assertEquals(expected, actual, 0.0);
    }

    /**
     * Tests getCount() method.
     */
    @Test
    public void testGetCount() {
        Fries fries = new Fries();
        int expected = 0;
        int actual = fries.getCount();
        assertEquals(expected, actual);
    }

    /**
     * Tests setCount() method.
     */
    @Test
    public void testSetCount() {
        Fries fries = new Fries();
        fries.setCount(5);
        int expected = 5;
        int actual = fries.getCount();
        assertEquals(expected, actual);
    }

    /**
     * Tests incrementCount() method.
     */
    @Test
    public void testIncrementCount() {
        Fries fries = new Fries();
        fries.incrementCount();
        int expected = 1;
        int actual = fries.getCount();
        assertEquals(expected, actual);
    }
}
