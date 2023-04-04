package ca.bcit.comp2522.termproject.comp2522202310termproject360;

public class Player {
    private double playerRevenue;
    private double playerClicker;

    public Player(double playerRevenue, int playerClicker) {
        this.playerRevenue = playerRevenue;
        this.playerClicker = 1;
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
