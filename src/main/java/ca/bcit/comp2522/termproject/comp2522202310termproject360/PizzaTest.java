package ca.bcit.comp2522.termproject.comp2522202310termproject360;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Pizza Test Class.
 * @author Joshua Chuah & Justin Oh
 * @version 2023
 */
public class PizzaTest {
    /**
     * Tests getPassiveIncome() method.
     */
    @Test
    public void testGetPassiveIncome() {
        Pizza pizza = new Pizza();
        double expected = 0.0;
        double actual = pizza.getPassiveIncome();
        assertEquals(expected, actual, 0.0);
    }

    /**
     * Tests incrementPassiveValue() method.
     */
    @Test
    public void testIncrementPassiveValue() {
        Pizza pizza = new Pizza();
        pizza.incrementPassiveValue(18.0);
        double expected = 18.0;
        double actual = pizza.getPassiveIncome();
        assertEquals(expected, actual, 0.0);
    }

    /**
     * Tests setPassiveValue() method.
     */
    @Test
    public void testSetPassiveValue() {
        Pizza pizza = new Pizza();
        pizza.setPassiveValue(25.0);
        double expected = 25.0;
        double actual = pizza.getPassiveIncome();
        assertEquals(expected, actual, 0.0);
    }

    /**
     * Tests getCost() method.
     */
    @Test
    public void testGetCost() {
        Pizza pizza = new Pizza();
        double expected = 10000.0;
        double actual = pizza.getCost();
        assertEquals(expected, actual, 0.0);
    }

    /**
     * Tests setCost() method.
     */
    @Test
    public void testSetCost() {
        Pizza pizza = new Pizza();
        pizza.setCost(2000.0);
        double expected = 2000.0;
        double actual = pizza.getCost();
        assertEquals(expected, actual, 0.0);
    }

    /**
     * Tests getCount() method.
     */
    @Test
    public void testGetCount() {
        Pizza pizza = new Pizza();
        int expected = 0;
        int actual = pizza.getCount();
        assertEquals(expected, actual);
    }

    /**
     * Tests setCount() method.
     */
    @Test
    public void testSetCount() {
        Pizza pizza = new Pizza();
        pizza.setCount(5);
        int expected = 5;
        int actual = pizza.getCount();
        assertEquals(expected, actual);
    }

    /**
     * Tests incrementCount() method.
     */
    @Test
    public void testIncrementCount() {
        Pizza pizza = new Pizza();
        pizza.incrementCount();
        int expected = 1;
        int actual = pizza.getCount();
        assertEquals(expected, actual);
    }
}

