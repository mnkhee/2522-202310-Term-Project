package ca.bcit.comp2522.termproject.comp2522202310termproject360;

public class HotDog implements Item {
    private double cost;
    private double passiveValue;
    Player player;
    private int count;

    public HotDog() {
        this.count = 0;
        this.cost = 50;
        this.passiveValue = 1.25;
    }

    @Override
    public double getPassiveIncome() {
        return this.passiveValue;
    }

    @Override
    public void addToPassiveValue(double passiveValue) {
        this.passiveValue += passiveValue;
    }

    @Override
    public double getCost() {
        return this.cost;
    }

    @Override
    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public int getCount() {
        return this.count + 1;
    }

    @Override
    public void incrementCount() {
        this.count++;
    }
}
