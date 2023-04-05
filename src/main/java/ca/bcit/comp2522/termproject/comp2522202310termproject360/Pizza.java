package ca.bcit.comp2522.termproject.comp2522202310termproject360;
/**
 * Pizza class implements Item interface.
 *
 * @author Joshua Chuah & Justin Oh
 * @version 2023
 */
public class Pizza implements Item {
    /**
     * Initial cost of Pizza.
     */
    static final int INITIAL_COST = 10000;
    private double cost;
    private double passiveValue;
    private int count;

    /**
     * Constructs an object of type Pizza.
     */
    public Pizza() {
        this.cost = INITIAL_COST;
        this.passiveValue = 0;
        this.count = 0;
    }

    /**
     * Gets the passive income generated by Pizza.
     *
     * @return passive income generated by Pizza
     */
    @Override
    public double getPassiveIncome() {
        return this.passiveValue;
    }

    /**
     * Increments passive value of Pizza.
     *
     * @param passive amount to increment passive value by
     */
    @Override
    public void incrementPassiveValue(final double passive) {
        this.passiveValue += passive;
    }

    /**
     * Sets the passive value of Pizza.
     *
     * @param passiveValue new passive value of Pizza
     */
    @Override
    public void setPassiveValue(final double passiveValue) {
        this.passiveValue = passiveValue;
    }

    /**
     * Gets cost of Pizza.
     *
     * @return cost of Pizza
     */
    @Override
    public double getCost() {
        return this.cost;
    }

    /**
     * Sets cost of Pizza.
     *
     * @param cost new cost of Pizza
     */
    @Override
    public void setCost(final double cost) {
        this.cost = cost;
    }

    /**
     * Gets number of Pizza.
     *
     * @return number of Pizza
     */
    @Override
    public int getCount() {
        return this.count;
    }

    /**
     * Sets count of Pizza.
     *
     * @param count new number of Pizza owned
     */
    @Override
    public void setCount(final int count) {
        this.count = count; }

    /**
     * Increments Pizza count by one.
     */
    @Override
    public void incrementCount() {
        this.count++;
    }
}
