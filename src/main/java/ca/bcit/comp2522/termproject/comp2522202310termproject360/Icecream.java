package ca.bcit.comp2522.termproject.comp2522202310termproject360;

public class Icecream implements Item {
    private double cost;
    private double passiveValue;
    private int count;
    public Icecream() {
        this.cost = 1000000;
        this.passiveValue = 0;
        this.count = 0;
    }
    @Override
    public double getPassiveIncome() {
        return this.passiveValue;
    }

    @Override
    public void incrementPassiveValue(double passiveValue) {
        this.passiveValue += passiveValue;
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
    public void setCount(int count) {this.count = count;}
    @Override
    public void incrementCount() {
        this.count++;
    }
}

