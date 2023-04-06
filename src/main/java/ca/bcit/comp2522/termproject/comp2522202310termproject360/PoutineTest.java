package ca.bcit.comp2522.termproject.comp2522202310termproject360;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Poutine Test Class.
 * @author Joshua Chuah & Justin Oh
 * @version 2023
 */
public class PoutineTest {
    /**
     * Tests getPassiveIncome() method.
     */
    @Test
    public void testGetPassiveIncome() {
        Poutine poutine = new Poutine();
        double expected = 0.0;
        double actual = poutine.getPassiveIncome();
        assertEquals(expected, actual, 0.0);
    }

    /**
     * Tests incrementPassiveValue() method.
     */
    @Test
    public void testIncrementPassiveValue() {
        Poutine poutine = new Poutine();
        poutine.incrementPassiveValue(36.0);
        double expected = 36.0;
        double actual = poutine.getPassiveIncome();
        assertEquals(expected, actual, 0.0);
    }

    /**
     * Tests setPassiveValue() method.
     */
    @Test
    public void testSetPassiveValue() {
        Poutine poutine = new Poutine();
        poutine.setPassiveValue(25.0);
        double expected = 25.0;
        double actual = poutine.getPassiveIncome();
        assertEquals(expected, actual, 0.0);
    }

    /**
     * Tests getCost() method.
     */
    @Test
    public void testGetCost() {
        Poutine poutine = new Poutine();
        double expected = 100000.0;
        double actual = poutine.getCost();
        assertEquals(expected, actual, 0.0);
    }

    /**
     * Tests setCost() method.
     */
    @Test
    public void testSetCost() {
        Poutine poutine = new Poutine();
        poutine.setCost(2000.0);
        double expected = 2000.0;
        double actual = poutine.getCost();
        assertEquals(expected, actual, 0.0);
    }

    /**
     * Tests getCount() method.
     */
    @Test
    public void testGetCount() {
        Poutine poutine = new Poutine();
        int expected = 0;
        int actual = poutine.getCount();
        assertEquals(expected, actual);
    }

    /**
     * Tests setCount() method.
     */
    @Test
    public void testSetCount() {
        Poutine poutine = new Poutine();
        poutine.setCount(5);
        int expected = 5;
        int actual = poutine.getCount();
        assertEquals(expected, actual);
    }

    /**
     * Tests incrementCount() method.
     */
    @Test
    public void testIncrementCount() {
        Poutine poutine = new Poutine();
        poutine.incrementCount();
        int expected = 1;
        int actual = poutine.getCount();
        assertEquals(expected, actual);
    }
}
