package ca.bcit.comp2522.termproject.comp2522202310termproject360;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;

import javafx.util.Duration;

public class GameController {
    HotDog hotdog = new HotDog();
    Player player = new Player();
    Fries fries = new Fries();
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
        this.clickerValue = player.getClickerValue(); // default = 1
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
        double hotdogIncome = (hotdog.getPassiveIncome() * hotdog.getCount());
        double friesIncome = (fries.getPassiveIncome() * fries.getCount());
        hotdogUpgrade.setTooltip(new Tooltip("Hotdogs are producing $" + hotdogIncome + " per second"));
        friesUpgrade.setTooltip(new Tooltip("Fries are producing $" + friesIncome + " per second"));
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
        if (player.totalRevenue() >= 50) {
            hotdogUpgrade.setVisible(true);
            hotdogUpgrade.setText("Hot dog (" + hotdog.getCount() + ")\nPrice: $" + hotdog.getCost());
        }
        if (player.totalRevenue() >= 1000) {
            friesUpgrade.setVisible(true);
            friesUpgrade.setText("Fries\nPrice: $" + fries.getCost());
        }
    }

    // confirms purchase
    @FXML
    protected void confirmHotdogAmount() {
        if (player.totalRevenue() < hotdog.getCost()) { // checks if player has enough revenue to purchase a hotdog
            purchaseText.setText("Not enough money to buy Hotdog"); // change, ofc
        } else {
            hotdog.setPassiveValue(1.25);
            purchaseText.setText("Purchased hotdog");
            player.decrementRevenue(hotdog.getCost()); // decrements revenue by cost of hotdog
            hotdog.setCost(hotdog.getCost() + 5);
            hotdog.incrementCount();
            hotdogUpgrade.setText("Hot dog (" + hotdog.getCount() + ")\nPrice: $" + hotdog.getCost());
            incrementRevenue();
        }
    }

    @FXML
    protected void confirmFriesAmount() {
        if (player.totalRevenue() < fries.getCost()) {
            purchaseText.setText("Not enough money to buy fries");
        } else {
            fries.setPassiveValue(5.00);
            purchaseText.setText("Purchased Fries");
            player.decrementRevenue(fries.getCost());
            fries.setCost(fries.getCost() + 250);
            fries.incrementCount();
            friesUpgrade.setText("Fries (" + fries.getCount() + ")\nPrice: $" + fries.getCost());
            incrementRevenue();
        }
    }

    // increments total revenue automatically
    @FXML
    protected void incrementRevenue() {
        tooltips();
        timeline = new Timeline(new KeyFrame(Duration.millis(1000), actionEvent -> {
            player.receiveRevenue(hotdog.getPassiveIncome());
            player.receiveRevenue(fries.getPassiveIncome());
            System.out.println(player.totalRevenue());
            totalRevenue.setText("Total Revenue: $" + player.totalRevenue());
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
}