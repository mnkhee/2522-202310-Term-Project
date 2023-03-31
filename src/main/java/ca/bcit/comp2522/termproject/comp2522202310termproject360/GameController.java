package ca.bcit.comp2522.termproject.comp2522202310termproject360;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;

import javafx.util.Duration;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class GameController {
    HotDog hotdog = new HotDog();
    Player player = new Player();
    Fries fries = new Fries();
    Pizza pizza = new Pizza();
    Poutine poutine = new Poutine();
    ChickenStrips chicken = new ChickenStrips();
    Icecream icecream = new Icecream();
    Timeline timeline;
    @FXML
    private Label totalRevenue;
    @FXML
    private Label purchaseText;
    public Button hotdogButton;
    @FXML
    private Button initialize;
    private static GameController instance;


    // upgradables
    public Button hotdogUpgrade;
    public Button friesUpgrade;
    public Button poutineUpgrade;
    public Button pizzaUpgrade;
    public Button icecreamUpgrade;
    public Button chickenUpgrade;
    @FXML
    public double clickerValue;



    public GameController() {
        this.clickerValue = player.getClickerValue(); // default = 1
    }
    public static GameController getInstance() {
            if (instance == null) {
            instance = new GameController();
            }
            return instance;
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
        pizzaUpgrade.setVisible(false);
        poutineUpgrade.setVisible(false);
        chickenUpgrade.setVisible(false);
        icecreamUpgrade.setVisible(false);
        tooltips();
    }

    // method for tooltips (hovering over buttons will display a message. not sure what to do with this tbh)
    public void tooltips() {
        double hotdogIncome = (hotdog.getPassiveIncome() * hotdog.getCount());
        double friesIncome = (fries.getPassiveIncome() * fries.getCount());
        double pizzaIncome = (pizza.getPassiveIncome() * pizza.getCount());
        double poutineIncome = (poutine.getPassiveIncome() * poutine.getCount());
        double chickenIncome = (chicken.getPassiveIncome() * chicken.getCount());
        double icecreamIncome = (icecream.getPassiveIncome() * icecream.getCount());
        hotdogUpgrade.setTooltip(new Tooltip("Hotdogs are producing $" + hotdogIncome + " per second"));
        friesUpgrade.setTooltip(new Tooltip("Fries are producing $" + friesIncome + " per second"));
        pizzaUpgrade.setTooltip(new Tooltip("Pizza is producing $" + pizzaIncome + " per second"));
        poutineUpgrade.setTooltip(new Tooltip("Poutine is producing $" + poutineIncome + " per second"));
        chickenUpgrade.setTooltip(new Tooltip("Chicken Strips are producing $" + chickenIncome + " per second"));
        icecreamUpgrade.setTooltip(new Tooltip("Ice cream is producing $" + icecreamIncome + " per second"));
    }

    // increments total revenue by clicker value
    @FXML
    protected void incrementCounter() {
        player.receiveRevenue(clickerValue);
        totalRevenue.setText("$"+player.totalRevenue());
        checkForUpgradability();
    }

    // checks if user has enough revenue to buy an upgrade
    @FXML
    protected void checkForUpgradability() {
        if (player.totalRevenue() >= 5) {
            hotdogUpgrade.setVisible(true);
            hotdogUpgrade.setText("Hot dog (" + hotdog.getCount() + ")\nPrice: $" + hotdog.getCost());
        }
        if (player.totalRevenue() >= 50) {
            friesUpgrade.setVisible(true);
            friesUpgrade.setText("Fries (" + fries.getCount() + ")\nPrice: $" + fries.getCost());
        }
        if (player.totalRevenue() >= 1000) {
            pizzaUpgrade.setVisible(true);
            pizzaUpgrade.setText("Pizza (" + pizza.getCount() + ")\nPrice: $" + pizza.getCost());
        }
        if (player.totalRevenue() >= 10000) {
            poutineUpgrade.setVisible(true);
            poutineUpgrade.setText("Poutine (" + poutine.getCount() + ")\nPrice: $" + poutine.getCost());
        }
        if (player.totalRevenue() >= 100000) {
            chickenUpgrade.setVisible(true);
            chickenUpgrade.setText("Chicken Strips (" + chicken.getCount() + ")\nPrice: $" + chicken.getCost());
        }
        if (player.totalRevenue() >= 250000) {
            icecreamUpgrade.setVisible(true);
            icecreamUpgrade.setText("Ice cream (" + icecream.getCount() + ")\nPrice: $" + icecream.getCost());
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
            totalRevenue.setText("$" + player.totalRevenue());
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
            fries.setCost(fries.getCost() + 25);
            fries.incrementCount();
            friesUpgrade.setText("Fries (" + fries.getCount() + ")\nPrice: $" + fries.getCost());
            totalRevenue.setText("$" + player.totalRevenue());
            incrementRevenue();
        }
    }

    @FXML
    protected void confirmPizzaAmount() {
        if (player.totalRevenue() < pizza.getCost()) {
            purchaseText.setText("Not enough money to buy pizza");
        } else {
            pizza.setPassiveValue(18.00);
            purchaseText.setText("Purchased Pizza");
            player.decrementRevenue(pizza.getCost());
            pizza.setCost(pizza.getCost() + 250);
            pizza.incrementCount();
            pizzaUpgrade.setText("Pizza (" + pizza.getCount() + ")\nPrice: $" + pizza.getCost());
            totalRevenue.setText("$" + player.totalRevenue());
            incrementRevenue();
        }
    }

    @FXML
    protected void confirmPoutineAmount() {
        if (player.totalRevenue() < poutine.getCost()) {
            purchaseText.setText("Not enough money to buy poutine");
        } else {
            poutine.setPassiveValue(36.00);
            purchaseText.setText("Purchased Poutine");
            player.decrementRevenue(poutine.getCost());
            poutine.setCost(poutine.getCost() + 1300);
            poutine.incrementCount();
            poutineUpgrade.setText("Poutine (" + poutine.getCount() + ")\nPrice: $" + poutine.getCost());
            totalRevenue.setText("$" + player.totalRevenue());
            incrementRevenue();
        }
    }

    @FXML
    protected void confirmChickenAmount() {
        if (player.totalRevenue() < chicken.getCost()) {
            purchaseText.setText("Not enough money to buy chicken strips");
        } else {
            chicken.setPassiveValue(99.00);
            purchaseText.setText("Purchased Chicken Strips");
            player.decrementRevenue(chicken.getCost());
            chicken.setCost(chicken.getCost() + 2600);
            chicken.incrementCount();
            chickenUpgrade.setText("Chicken Strips (" + chicken.getCount() + ")\nPrice: $" + chicken.getCost());
            totalRevenue.setText("$" + player.totalRevenue());
            incrementRevenue();
        }
    }

    @FXML
    protected void confirmIcecreamAmount() {
        if (player.totalRevenue() < icecream.getCost()) {
            purchaseText.setText("Not enough money to buy ice cream");
        } else {
            icecream.setPassiveValue(173.00);
            purchaseText.setText("Purchased Ice Cream");
            player.decrementRevenue(icecream.getCost());
            icecream.setCost(icecream.getCost() + 4500);
            icecream.incrementCount();
            icecreamUpgrade.setText("Ice Cream (" + icecream.getCount() + ")\nPrice: $" + icecream.getCost());
            totalRevenue.setText("$" + player.totalRevenue());
            incrementRevenue();
        }
    }

    public double passiveIncome() {
        double hotdogIncome = (hotdog.getPassiveIncome() * hotdog.getCount());
        double friesIncome = (fries.getPassiveIncome() * fries.getCount());
        double pizzaIncome = (pizza.getPassiveIncome() * pizza.getCount());
        double poutineIncome = (poutine.getPassiveIncome() * poutine.getCount());
        double chickenIncome = (chicken.getPassiveIncome() * chicken.getCount());
        double icecreamIncome = (icecream.getPassiveIncome() * icecream.getCount());
        return hotdogIncome + friesIncome + pizzaIncome + poutineIncome
                + chickenIncome + icecreamIncome;
    }

    // increments total revenue automatically
    @FXML
    protected void incrementRevenue() {
        tooltips();
        timeline = new Timeline(new KeyFrame(Duration.millis(1000), actionEvent -> {
            checkForUpgradability();
            player.receiveRevenue(hotdog.getPassiveIncome());
            player.receiveRevenue(fries.getPassiveIncome());
            player.receiveRevenue(pizza.getPassiveIncome());
            player.receiveRevenue(poutine.getPassiveIncome());
            player.receiveRevenue(chicken.getPassiveIncome());
            player.receiveRevenue(icecream.getPassiveIncome());
            System.out.println(player.totalRevenue());
            totalRevenue.setText("$" + player.totalRevenue());
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
    @FXML
    public void saveGame(ActionEvent event) {
        try {
            File file = new File("game_data.ser");
            FileOutputStream fileOut = new FileOutputStream(file);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            // Save player data
            Player player = new Player();
            out.writeObject(player.totalRevenue());
            out.writeObject(player.getClickerValue());

            // Save fries data
            Fries fries = new Fries();
            out.writeObject(fries.getCount());

            // Save pizza data
            Pizza pizza = new Pizza();
            out.writeObject(pizza.getCount());

            // Save chicken strip data
            ChickenStrips chickenStrips = new ChickenStrips();
            out.writeObject(chickenStrips.getCount());

            // Save hotdog data
            HotDog hotdog = new HotDog();
            out.writeObject(hotdog.getCount());

            // Save icecream data
            Icecream icecream = new Icecream();
            out.writeObject(icecream.getCount());

            // Save poutine data
            Poutine poutine = new Poutine();
            out.writeObject(poutine.getCount());

            out.close();
            fileOut.close();
            System.out.println("Game data saved to " + file.getAbsolutePath());
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public void setHotDog(HotDog hotdog) {
        this.hotdog = hotdog;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setFries(Fries fries) {
        this.fries = fries;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public void setPoutine(Poutine poutine) {
        this.poutine = poutine;
    }

    public void setChickenStrips(ChickenStrips chicken) {
        this.chicken = chicken;
    }

    public void setIcecream(Icecream icecream) {
        this.icecream = icecream;
    }
}