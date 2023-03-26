package ca.bcit.comp2522.termproject.comp2522202310termproject360;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class GameController {
    HotDog hotdog = new HotDog();
    Player player = new Player();

    Timeline timeline;
    public Button hotdogButton;
    @FXML
    private Label welcomeText;

    // all of these are tests, will probably be removed or altered.
    @FXML
    public double num = hotdog.getPassiveIncome();

    @FXML
    public double rev = 1;
    @FXML
    private Label totalRevenue;

    @FXML
    protected void incrementCounter() {
        player.receiveRevenue(rev);
        totalRevenue.setText("Total Revenue: " + player.totalRevenue());
    }

    @FXML
    protected void confirmAmount() {
        if (player.totalRevenue() < 50) {
            welcomeText.setText("no");
        } else {
            welcomeText.setText("Purchased hotdog");
            player.decrementRevenue(50);
            totalRevenue.setText("Total Revenue: " + player.totalRevenue());
            incrementHotDog();
        }
    }

    @FXML
    protected void incrementHotDog() {
        hotdog.passiveIncrement();
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), actionEvent -> {
            player.receiveRevenue(hotdog.getPassiveIncome());
            totalRevenue.setText("Total Revenue: " + player.totalRevenue());
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

}