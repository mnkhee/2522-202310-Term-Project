package ca.bcit.comp2522.termproject.comp2522202310termproject360;

import java.io.Serializable;

public class GameData implements Serializable {
    private double playerRevenue;
    private int clickerValue;
    private int friesCount;
    private int pizzaCount;

    public GameData(double playerRevenue, int clickerValue, int friesCount, int pizzaCount) {
        this.playerRevenue = playerRevenue;
        this.clickerValue = clickerValue;
        this.friesCount = friesCount;
        this.pizzaCount = pizzaCount;
    }

    public double getPlayerRevenue() {
        return playerRevenue;
    }
    public void setPlayerRevenue(double playerRevenue) {
        this.playerRevenue = playerRevenue;
    }
    public int getClickerValue() {
        return clickerValue;
    }

    public void setClickerValue(int clickerValue) {
        this.clickerValue = clickerValue;
    }

    public int getFriesCount() {
        return friesCount;
    }
    public void setFriesCount(int friesCount) {
        this.friesCount = friesCount;
    }
    public int getPizzaCount() {
        return pizzaCount;
    }
}
