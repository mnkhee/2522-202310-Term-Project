package ca.bcit.comp2522.termproject.comp2522202310termproject360;

public class ChickenStrips implements Item {
    private double cost;
    private double passiveValue;
    private int count;
    public ChickenStrips() {
        this.cost = 250000;
        this.passiveValue = 0;
        this.count = 0;
    }
    @Override
    public double getPassiveIncome() {
        return this.passiveValue;
    }

    @Override
    public void setPassiveValue(double passiveValue) {
        this.passiveValue = passiveValue;
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
        return this.count;
    }

    @Override
    public void incrementCount() {
        this.count++;
    }
}

