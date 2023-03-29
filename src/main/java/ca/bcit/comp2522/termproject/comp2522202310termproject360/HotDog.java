package ca.bcit.comp2522.termproject.comp2522202310termproject360;

import javafx.animation.Animation;

import javafx.animation.Timeline;
import javafx.animation.KeyFrame;

import javafx.util.Duration;

public class HotDog implements Item {
    private double cost;
    private double passiveValue;

    private double hotdogsOwned;
    Player player;
    private int count = 0;

    public HotDog() {
        this.cost = 50;
        this.passiveValue = 1.25;
    }

    @Override
    public double getPassiveIncome() {
        return this.passiveValue;
    }

    public void addToPassiveValue(double passiveValue) {
        this.passiveValue += passiveValue;
    }

    public double getCost() {
        return this.cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double hotdogsOwned() {
        return this.hotdogsOwned;
    }

    public void incrementHotdogsOwned() {
        this.hotdogsOwned++;
    }

    public void passiveIncrement() {
//        timeline = new Timeline(new KeyFrame(Duration.seconds(1), actionEvent -> {
//            //passiveValue += 0.5;
//            //setPassiveValue(this.passiveValue);
//        }));
//        timeline.setCycleCount(Animation.INDEFINITE);
//        timeline.play();
    }
    public int getCount() {
        return this.count + 1;
    }

    public void incrementCount() {
        this.count++;
    }
}
