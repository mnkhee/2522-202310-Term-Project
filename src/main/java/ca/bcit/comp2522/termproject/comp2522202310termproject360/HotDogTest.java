package ca.bcit.comp2522.termproject.comp2522202310termproject360;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * HotDog Test Class.
 * @author Joshua Chuah & Justin Oh
 * @version 2023
 */
public class HotDogTest {
    /**
     * Tests getPassiveIncome() method.
     */
    @Test
    public void testGetPassiveIncome() {
        HotDog hotdog = new HotDog();
        double expected = 0.0;
        double actual = hotdog.getPassiveIncome();
        assertEquals(expected, actual, 0.0);
    }

    /**
     * Tests incrementPassiveValue() method.
     */
    @Test
    public void testIncrementPassiveValue() {
        HotDog hotdog = new HotDog();
        hotdog.incrementPassiveValue(1.25);
        double expected = 1.25;
        double actual = hotdog.getPassiveIncome();
        assertEquals(expected, actual, 0.0);
    }

    /**
     * Tests setPassiveValue() method.
     */
    @Test
    public void testSetPassiveValue() {
        HotDog hotdog = new HotDog();
        hotdog.setPassiveValue(0.7);
        double expected = 0.7;
        double actual = hotdog.getPassiveIncome();
        assertEquals(expected, actual, 0.0);
    }

    /**
     * Tests getCost() method.
     */
    @Test
    public void testGetCost() {
        HotDog hotdog = new HotDog();
        double expected = 50.0;
        double actual = hotdog.getCost();
        assertEquals(expected, actual, 0.0);
    }

    /**
     * Tests setCost() method.
     */
    @Test
    public void testSetCost() {
        HotDog hotdog = new HotDog();
        hotdog.setCost(100.0);
        double expected = 100.0;
        double actual = hotdog.getCost();
        assertEquals(expected, actual, 0.0);
    }

    /**
     * Tests getCount() method.
     */
    @Test
    public void testGetCount() {
        HotDog hotdog = new HotDog();
        int expected = 0;
        int actual = hotdog.getCount();
        assertEquals(expected, actual);
    }

    /**
     * Tests setCount() method.
     */
    @Test
    public void testSetCount() {
        HotDog hotdog = new HotDog();
        hotdog.setCount(5);
        int expected = 5;
        int actual = hotdog.getCount();
        assertEquals(expected, actual);
    }

    /**
     * Tests incrementCount() method.
     */
    @Test
    public void testIncrementCount() {
        HotDog hotdog = new HotDog();
        hotdog.incrementCount();
        int expected = 1;
        int actual = hotdog.getCount();
        assertEquals(expected, actual);
    }
}
