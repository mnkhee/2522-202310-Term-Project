package ca.bcit.comp2522.termproject.comp2522202310termproject360;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    /**
     Tests totalRevenue() method.
     */
    @Test
    public void testTotalRevenue() {
        Player player = new Player(100.0, 5.0);
        double expected = 100.0;
        double actual = player.totalRevenue();
        assertEquals(expected, actual, 0.0);
    }
    /**
     Tests getClickerValue() method.
     */
    @Test
    public void testGetClickerValue() {
        Player player = new Player(100.0, 5.0);
        double expected = 5.0;
        double actual = player.getClickerValue();
        assertEquals(expected, actual, 0.0);
    }
    /**
     Tests setClickerValue() method.
     */
    @Test
    public void testSetClickerValue() {
        Player player = new Player(100.0, 5.0);
        player.setClickerValue(2.5);
        double expected = 7.5;
        double actual = player.getClickerValue();
        assertEquals(expected, actual, 0.0);
    }
    /**
     Tests receiveRevenue() method.
     */
    @Test
    public void testReceiveRevenue() {
        Player player = new Player(100.0, 5.0);
        player.receiveRevenue(50.0);
        double expected = 150.0;
        double actual = player.totalRevenue();
        assertEquals(expected, actual, 0.0);
    }
    /**
     Tests decrementRevenue() method.
     */
    @Test
    public void testDecrementRevenue() {
        Player player = new Player(100.0, 5.0);
        player.decrementRevenue(25.0);
        double expected = 75.0;
        double actual = player.totalRevenue();
        assertEquals(expected, actual, 0.0);
    }
}