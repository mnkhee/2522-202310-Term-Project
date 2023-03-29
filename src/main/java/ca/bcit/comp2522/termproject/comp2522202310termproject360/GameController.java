package ca.bcit.comp2522.termproject.comp2522202310termproject360;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;

import javafx.util.Duration;
import java.util.Timer;
import java.util.TimerTask;

public class GameController {
    HotDog hotdog = new HotDog();
    Player player = new Player();
    Timeline timeline;
    @FXML
    private Label totalRevenue;
    @FXML
    private Label purchaseText;
    public Button hotdogButton;
    @FXML
    private Button initialize;

    // upgradables
    public Button hotdogUpgrade;
    public Button friesUpgrade;
    public Button poutineUpgrade;
    public Button pizzaUpgrade;
    public Button icecreamUpgrade;
    @FXML
    public double clickerValue;



    public GameController() {
        this.clickerValue = player.getClickerValue();
    }

    // method runs as soon as program runs
    public void initialize() {
        initialize.fire();
    }

    // hides upgrade buttons
    @FXML
    public void hideButtons() {
        initialize.setVisible(false);
        hotdogUpgrade.setVisible(false);
        friesUpgrade.setVisible(false);
        tooltips();
    }

    // method for tooltips (hovering over buttons will display a message. not sure what to do with this tbh)
    public void tooltips() {
        double hotdogIncome = (hotdog.getPassiveIncome() * hotdog.getCount() - 1.25);
        hotdogUpgrade.setTooltip(new Tooltip("Hotdogs are producing $" + hotdogIncome + " per second"));
    }

    // increments total revenue by clicker value
    @FXML
    protected void incrementCounter() {
        player.receiveRevenue(clickerValue);
        totalRevenue.setText("Total Revenue: $" + player.totalRevenue());
        checkForUpgradability();
    }

    // checks if user has enough revenue to buy an upgrade
    @FXML
    protected void checkForUpgradability() {
        if (player.totalRevenue() == 50) {
            hotdogUpgrade.setVisible(true);
            hotdogUpgrade.setText("Hot dog\nPrice: $" + hotdog.getCost());
        } else if (player.totalRevenue() == 1000) {
            friesUpgrade.setVisible(true);
            friesUpgrade.setText("Fries\nPrice: $N/A");
        }
    }

    // confirms purchase
    @FXML
    protected void confirmHotdogAmount() {
        if (player.totalRevenue() < hotdog.getCost()) { // checks if player has enough revenue to purchase a hotdog
            purchaseText.setText("no"); // change, ofc
        } else {
            purchaseText.setText("Purchased hotdog");
            player.decrementRevenue(hotdog.getCost()); // decrements revenue by cost of hotdog
            hotdog.setCost(hotdog.getCost() + 5);
            totalRevenue.setText("Total Revenue: $" + player.totalRevenue());
            hotdogUpgrade.setText("Hot dog (" + hotdog.getCount() + ")\nPrice: $" + hotdog.getCost());
            incrementHotDog();
        }
    }

    // increments total revenue automatically
    @FXML
    protected void incrementHotDog() {
        hotdog.incrementCount();
        tooltips();
        timeline = new Timeline(new KeyFrame(Duration.millis(1000), actionEvent -> {
            System.out.println(player.totalRevenue());
            player.receiveRevenue(hotdog.getPassiveIncome());
            totalRevenue.setText("Total Revenue: $" + player.totalRevenue());
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

}