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
        welcomeText.setText("Total Hot dog Production: " + num);
        totalRevenue.setText("Total Revenue: " + player.totalRevenue());
        player.receiveRevenue(rev);
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

//    @FXML
//    protected void Click() {
//        this.rev = 0;
//        totalRevenue.setText("Total Revenue: " + rev);
//    }
}