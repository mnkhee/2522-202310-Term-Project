package ca.bcit.comp2522.termproject.comp2522202310termproject360;

import javafx.animation.Animation;
import javafx.application.Platform;
import javafx.event.ActionEvent;

import javafx.animation.Timeline;
import javafx.animation.KeyFrame;

import javafx.util.Duration;

public class HotDog implements Item {
    GameController gameController;
    double cost = 1.25;
    double passiveValue = 0.5;
    private Timeline timeline;

    public HotDog() {
    }

    @Override
    public double getPassiveIncome() {
        return this.passiveValue;
    }

    public void setPassiveValue(double passiveValue) {
        this.passiveValue = passiveValue;
    }

    public void passiveIncrement() {
        timeline = new Timeline(new KeyFrame(Duration.seconds(0.5), actionEvent -> {
            gameController = new GameController();
            passiveValue += 0.5;
            setPassiveValue(this.passiveValue);
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

}
