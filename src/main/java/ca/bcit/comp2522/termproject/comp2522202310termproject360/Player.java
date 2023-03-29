package ca.bcit.comp2522.termproject.comp2522202310termproject360;

public class Player {
    private double playerRevenue;
    private int playerClicker;

    public Player() {
        this.playerRevenue = 0;
        this.playerClicker = 1;
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
