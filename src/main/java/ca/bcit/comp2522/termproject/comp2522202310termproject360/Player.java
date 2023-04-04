package ca.bcit.comp2522.termproject.comp2522202310termproject360;
/**
 * Player class.
 *
 * @author Joshua Chuah & Justin Oh
 * @version 2023
 */
public class Player {
    private double playerRevenue;
    private final int playerClicker;

    /**
     * Constructs an object of type Player.
     * @param playerRevenue initial revenue of player
     * @param playerClicker initial clicker value of player
     */

    public Player(final double playerRevenue, final int playerClicker) {
        this.playerRevenue = playerRevenue;
        this.playerClicker = 1;
    }

    /**
     * Returns total revenue earned by the player.
     *
     * @return total revenue earned by the player
     */
    double totalRevenue() {
        return this.playerRevenue;
    }

    /**
     * Returns clicker value of the player.
     *
     * @return clicker value of the player
     */
    int getClickerValue() {
        return this.playerClicker;
    }

    /**
     * Adds revenue to the player's total revenue.
     *
     * @param receiveValue amount of revenue to add
     */
    void receiveRevenue(final double receiveValue) {
        this.playerRevenue += receiveValue;
    }

    /**
     * Subtracts revenue from player's total revenue.
     *
     * @param receiveValue amount of revenue to subtract
     */
    void decrementRevenue(final double receiveValue) {
        this.playerRevenue -= receiveValue;
    }

}
