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
    private Label purchaseText;
    @FXML
    private Label hotdogCount;

    public Button hotdogUpgrade;

    @FXML
    public double rev = player.getClickerValue(); // probably make a clicker class?
    @FXML
    private Label totalRevenue;

    @FXML
    protected void incrementCounter() {
        player.receiveRevenue(rev);
        totalRevenue.setText("Total Revenue: $" + player.totalRevenue());
    }

    @FXML
    protected void confirmAmount() {
        if (player.totalRevenue() < hotdog.getCost()) { // checks if player has enough revenue to purchase a hotdog
            purchaseText.setText("no"); // change, ofc
        } else {
            purchaseText.setText("Purchased hotdog");
            player.decrementRevenue(hotdog.getCost()); // decrements revenue by cost of hotdog
            totalRevenue.setText("Total Revenue: $" + player.totalRevenue());
            hotdog.incrementHotdogsOwned();
            hotdogUpgrade.setText("Hot dog (" + hotdog.getCount() + ")");
            incrementHotDog();
        }
    }

    @FXML
    protected void incrementHotDog() {
        hotdog.incrementCount();
        timeline = new Timeline(new KeyFrame(Duration.millis(1000), actionEvent -> {
            System.out.println(player.totalRevenue());
            player.receiveRevenue(hotdog.getPassiveIncome());
            totalRevenue.setText("Total Revenue: $" + player.totalRevenue());
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

}