package ca.bcit.comp2522.termproject.comp2522202310termproject360;

public class Player {
    private double playerRevenue;

    public Player() {
        this.playerRevenue = 0;
    }

    double totalRevenue() {
        return this.playerRevenue;
    }

    void receiveRevenue(double receiveValue) {
        this.playerRevenue += receiveValue;
    }

    void decrementRevenue(double receiveValue) {
        this.playerRevenue -= receiveValue;
    }

}
