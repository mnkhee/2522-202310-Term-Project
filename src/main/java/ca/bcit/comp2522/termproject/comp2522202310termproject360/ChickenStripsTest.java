package ca.bcit.comp2522.termproject.comp2522202310termproject360;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * ChickenStrips Test Class.
 * @author Joshua Chuah & Justin Oh
 * @version 2023
 */
public class ChickenStripsTest {
    /**
     * Tests getPassiveIncome() method.
     */
    @Test
    public void testGetPassiveIncome() {
        ChickenStrips strips = new ChickenStrips();
        double expected = 0.0;
        double actual = strips.getPassiveIncome();
        assertEquals(expected, actual, 0.0);
    }

    /**
     * Tests incrementPassiveValue() method.
     */
    @Test
    public void testIncrementPassiveValue() {
        ChickenStrips strips = new ChickenStrips();
        strips.incrementPassiveValue(100.0);
        double expected = 100.0;
        double actual = strips.getPassiveIncome();
        assertEquals(expected, actual, 0.0);
    }

    /**
     * Tests setPassiveValue() method.
     */
    @Test
    public void testSetPassiveValue() {
        ChickenStrips strips = new ChickenStrips();
        strips.setPassiveValue(50.0);
        double expected = 50.0;
        double actual = strips.getPassiveIncome();
        assertEquals(expected, actual, 0.0);
    }

    /**
     * Tests getCost() method.
     */
    @Test
    public void testGetCost() {
        ChickenStrips strips = new ChickenStrips();
        double expected = 100000.0;
        double actual = strips.getCost();
        assertEquals(expected, actual, 0.0);
    }

    /**
     * Tests setCost() method.
     */
    @Test
    public void testSetCost() {
        ChickenStrips strips = new ChickenStrips();
        strips.setCost(300000.0);
        double expected = 300000.0;
        double actual = strips.getCost();
        assertEquals(expected, actual, 0.0);
    }

    /**
     * Tests getCount() method.
     */
    @Test
    public void testGetCount() {
        ChickenStrips strips = new ChickenStrips();
        int expected = 0;
        int actual = strips.getCount();
        assertEquals(expected, actual);
    }

    /**
     * Tests setCount() method.
     */
    @Test
    public void testSetCount() {
        ChickenStrips strips = new ChickenStrips();
        strips.setCount(5);
        int expected = 5;
        int actual = strips.getCount();
        assertEquals(expected, actual);
    }

    /**
     * Tests incrementCount() method.
     */
    @Test
    public void testIncrementCount() {
        ChickenStrips strips = new ChickenStrips();
        strips.incrementCount();
        int expected = 1;
        int actual = strips.getCount();
        assertEquals(expected, actual);
    }
}
