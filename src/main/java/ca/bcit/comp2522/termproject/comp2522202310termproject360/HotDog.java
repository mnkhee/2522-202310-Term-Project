package ca.bcit.comp2522.termproject.comp2522202310termproject360;

public class HotDog implements Item {

    double cost = 1.25;

    public HotDog() {
    }

    @Override
    public double getPassiveIncome() {
        return this.cost;
    }


}
