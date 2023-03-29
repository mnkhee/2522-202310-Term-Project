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
    public Button hotdogUpgrade;
    @FXML
    public double clickerValue;
    @FXML
    private Label totalRevenue;

    @FXML
    private Button initialize;


    public GameController() {
        this.clickerValue = player.getClickerValue();
    }

    public void initialize() {
        initialize.fire();
    }

    @FXML
    public void hideButtons() {
        initialize.setVisible(false);
        hotdogUpgrade.setVisible(false);
    }

    @FXML
    protected void incrementCounter() {
        player.receiveRevenue(clickerValue);
        totalRevenue.setText("Total Revenue: $" + player.totalRevenue());
        checkForUpgradability();
    }
    @FXML
    protected void checkForUpgradability() {
        if (player.totalRevenue() < 50 && hotdog.getCount() <= 1) {
            hotdogUpgrade.setVisible(false);
        } else {
            hotdogUpgrade.setVisible(true);
            hotdogUpgrade.setText("Hot dog\nPrice: $" + hotdog.getCost());
        }
    }

    @FXML
    protected void confirmAmount() {
        if (player.totalRevenue() < hotdog.getCost()) { // checks if player has enough revenue to purchase a hotdog
            purchaseText.setText("no"); // change, ofc
        } else {
            purchaseText.setText("Purchased hotdog");
            player.decrementRevenue(hotdog.getCost()); // decrements revenue by cost of hotdog
            totalRevenue.setText("Total Revenue: $" + player.totalRevenue());
            hotdogUpgrade.setText("Hot dog (" + hotdog.getCount() + ")\nPrice: $" + hotdog.getCost());
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