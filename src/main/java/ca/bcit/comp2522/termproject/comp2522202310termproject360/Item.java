package ca.bcit.comp2522.termproject.comp2522202310termproject360;

public interface Item {

    double getPassiveIncome();

    void addToPassiveValue(double passiveValue);

    double getCost();

    void setCost(double cost);

    int getCount();

    void incrementCount();

}
