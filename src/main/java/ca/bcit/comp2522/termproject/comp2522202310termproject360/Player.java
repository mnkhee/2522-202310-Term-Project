package ca.bcit.comp2522.termproject.comp2522202310termproject360;

/**
 * Player.
 *
 * @author Joshua Chuah
 * @author Justin Oh
 * @version 2023
 */
public class Player {
    private double playerRevenue;
    private double playerClicker;

    /**
     * Constructor for Player.
     * @param playerRevenue double type variable that represents the player's revenue.
     * @param playerClicker double type variable that represents the player's clicker value.
     */
    public Player(final double playerRevenue, final double playerClicker) {
        this.playerRevenue = playerRevenue;
        this.playerClicker = playerClicker;
    }

    /**
     * Returns the players total revenue.
     * @return total revenue.
     */
    public double totalRevenue() {
        return this.playerRevenue;
    }

    /**
     * Returns the players clicker value.
     * @return clicker value.
     */
    public double getClickerValue() {
        return this.playerClicker;
    }

    /**
     * Increments the players clickerValue by the inputted value.
     * @param clickerValue double type variable that represents the players updated clickerValue.
     */
    public void setClickerValue(final double clickerValue) {
        this.playerClicker += clickerValue;
    }

    /**
     * Adds the input value recieveValue to the player's revenue.
     * @param receiveValue double type value that represents the player's revenue.
     */
    public void receiveRevenue(final double receiveValue) {
        this.playerRevenue += receiveValue;
    }

    /**
     * Decrements the input value recieveValue to the player's revenue.
     * @param receiveValue double type value that represents the player's revenue.
     */
    public void decrementRevenue(final double receiveValue) {
        this.playerRevenue -= receiveValue;
    }

}
