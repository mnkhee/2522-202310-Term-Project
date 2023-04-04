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
    private int playerClicker;

    public Player(double playerRevenue, double playerClicker) {
        this.playerRevenue = playerRevenue;
        this.playerClicker = playerClicker;
    }

    double totalRevenue() {
        return this.playerRevenue;
    }

    int getClickerValue() {
        return this.playerClicker;
    }

    void setClickerValue(int clickerValue) {
        this.playerClicker = clickerValue;
    }

    void receiveRevenue(double receiveValue) {
        this.playerRevenue += receiveValue;
    }

    void decrementRevenue(double receiveValue) {
        this.playerRevenue -= receiveValue;
    }

}
