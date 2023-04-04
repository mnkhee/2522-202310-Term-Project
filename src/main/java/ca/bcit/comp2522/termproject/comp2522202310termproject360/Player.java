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

    public Player(double playerRevenue, double playerClicker) {
        this.playerRevenue = playerRevenue;
        this.playerClicker = playerClicker;
    }

    double totalRevenue() {
        return this.playerRevenue;
    }

    double getClickerValue() {
        return this.playerClicker;
    }

    void setClickerValue(double clickerValue) {
        this.playerClicker += clickerValue;
    }

    void receiveRevenue(double receiveValue) {
        this.playerRevenue += receiveValue;
    }

    void decrementRevenue(double receiveValue) {
        this.playerRevenue -= receiveValue;
    }

}
