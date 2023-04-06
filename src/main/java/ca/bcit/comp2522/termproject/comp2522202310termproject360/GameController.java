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

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.IOException;
/**
 * GameController.
 *
 * @author Joshua Chuah
 * @author Justin Oh
 * @version 2023
 */
public class GameController {
    /**
     * Hotdog passive value to increment by.
     */
    static final double HOTDOG_PASSIVE_VALUE = 1.25;
    /**
     * Fries passive value to increment by.
     */
    static final double FRIES_PASSIVE_VALUE = 5.00;
    /**
     * Pizza passive value to increment by.
     */
    static final double PIZZA_PASSIVE_VALUE = 18.00;
    /**
     * Poutine passive value to increment by.
     */
    static final double POUTINE_PASSIVE_VALUE = 36.00;
    /**
     * Chickenstrips passive value to increment by.
     */
    static final double CHICKEN_PASSIVE_VALUE = 99.00;
    /**
     * Icecream passive value to increment by.
     */
    static final double ICECREAM_PASSIVE_VALUE = 173.00;
    /**
     * Clicker initial value.
     */
    static final double CLICKER_VALUE = 0.5;
    /**
     * Icecream clicker value.
     */
    static final double ICECREAM_CLICKER_VALUE = 1.0;
    /**
     * Timeframe value for each frame to update.
     */
    static final int INCREMENT_TIMEFRAME = 1000;
    /**
     * Value to add to hotdog cost with each purchase.
     */
    static final int HOTDOG_INCREMENT = 5;
    /**
     * Value to add to fries cost with each purchase.
     */
    static final int FRIES_INCREMENT = 25;
    /**
     * Value to add to pizza cost with each purchase.
     */
    static final int PIZZA_INCREMENT = 250;
    /**
     * Value to add to poutine cost with each purchase.
     */
    static final int POUTINE_INCREMENT = 1300;
    /**
     * Value to add to chicken cost with each purchase.
     */
    static final int CHICKEN_INCREMENT = 2600;
    /**
     * Value to add to icecream cost with each purchase.
     */
    static final int ICECREAM_INCREMENT = 4500;
    /**
     * Initial hotdog price.
     */
    static final int INITIAL_HOTDOG_PRICE = 5;
    /**
     * Initial fries price.
     */
    static final int INITIAL_FRIES_PRICE = 50;
    /**
     * Initial pizza price.
     */
    static final int INITIAL_PIZZA_PRICE = 1000;
    /**
     * Initial poutine price.
     */
    static final int INITIAL_POUTINE_PRICE = 10000;
    /**
     * Initial chicken price.
     */
    static final int INITIAL_CHICKEN_PRICE = 100000;
    /**
     * Initial icecream price.
     */
    static final int INITIAL_ICECREAM_PRICE = 250000;
    private static GameController instance;

    /**
     * Hotdog upgrade button.
     */
    public Button hotdogUpgrade;

    /**
     * Fries upgrade button.
     */
    public Button friesUpgrade;

    /**
     * Poutine upgrade button.
     */
    public Button poutineUpgrade;

    /**
     * Pizza upgrade button.
     */
    public Button pizzaUpgrade;

    /**
     * Icecream upgrade button.
     */
    public Button icecreamUpgrade;

    /**
     * Chicken Strips upgrade button.
     */
    public Button chickenUpgrade;

    /**
     * Double type variable that represents the user's clicker value.
     */
    @FXML
    public double clickerValue;

    private final HotDog hotdog;

    private Player player;

    private final Fries fries;

    private final Pizza pizza;

    private final Poutine poutine;

    private final ChickenStrips chicken;

    private final Icecream icecream;

    /**
     * totalRevenue label.
     */
    @FXML
    private Label totalRevenue;

    /**
     * purchaseText label.
     */
    @FXML
    private Label purchaseText;

    /**
     * Hotdog button.
     */
    private Button hotdogButton;

    /**
     * totalPassiveIncome Label. Represents the user's passive income.
     */
    @FXML
    private Label totalPassiveIncome;

    /**
     * initialize Button.
     */
    @FXML
    private Button initialize;


    /**
     * Integer type variable that is set to 0.
     *
     * <p>
     * Its purpose is to only let the incrementRevenue() method run once.
     * The method will only run if the value of returnToGame is 0. Once
     * the method is called, the returnToGame value is incremented.
     * </p>
     */
    private int returnToGame = 0;

    /**
     * Constructor for GameController.
     */
    public GameController() {
        this.player = new Player(0, 1);
        this.clickerValue = player.getClickerValue(); // default = 1
        this.hotdog = new HotDog();
        this.fries = new Fries();
        this.pizza = new Pizza();
        this.poutine = new Poutine();
        this.chicken = new ChickenStrips();
        this.icecream = new Icecream();
    }

    /**
     * Method initializes as soon as program starts, which runs the
     * hideButtons() method, incrementRevenue() method and tooltips() method.
     */
    public void initialize() {
        initialize.fire();
    }

    /**
     * Hides upgrade buttons until the user has enough revenue to view it.
     */
    @FXML
    public void hideButtons() {
        incrementRevenue();
        initialize.setVisible(false);
        hotdogUpgrade.setVisible(false);
        friesUpgrade.setVisible(false);
        pizzaUpgrade.setVisible(false);
        poutineUpgrade.setVisible(false);
        chickenUpgrade.setVisible(false);
        icecreamUpgrade.setVisible(false);
        tooltips();
    }

    /**
     * Shows how much revenue each upgrade is earning when the user hovers their mouse over the
     * corresponding button.
     */
    public void tooltips() {
        double hotdogIncome = hotdog.getPassiveIncome();
        double friesIncome = fries.getPassiveIncome();
        double pizzaIncome = pizza.getPassiveIncome();
        double poutineIncome = poutine.getPassiveIncome();
        double chickenIncome = chicken.getPassiveIncome();
        double icecreamIncome = icecream.getPassiveIncome();
        hotdogUpgrade.setTooltip(new Tooltip("Hotdogs are producing $" + hotdogIncome + " per second"));
        friesUpgrade.setTooltip(new Tooltip("Fries are producing $" + friesIncome + " per second"));
        pizzaUpgrade.setTooltip(new Tooltip("Pizza is producing $" + pizzaIncome + " per second"));
        poutineUpgrade.setTooltip(new Tooltip("Poutine is producing $" + poutineIncome + " per second"));
        chickenUpgrade.setTooltip(new Tooltip("Chicken Strips are producing $" + chickenIncome + " per second"));
        icecreamUpgrade.setTooltip(new Tooltip("Ice cream is producing $" + icecreamIncome + " per second"));
    }

    /**
     * Increments totalRevenue by the clickerValue everytime the user clicks on the hot dog.
     */
    @FXML
    protected void incrementCounter() {
        player.receiveRevenue(player.getClickerValue());
        totalRevenue.setText("$" + player.totalRevenue());
        checkForUpgradability();
    }

    /**
     * Checks if the user has enough revenue to view the next upgrade available.
     */
    @FXML
    protected void checkForUpgradability() {
        if (player.totalRevenue() >= INITIAL_HOTDOG_PRICE) {
            hotdogUpgrade.setVisible(true);
            hotdogUpgrade.setText("Hot dog (" + hotdog.getCount() + ")\nPrice: $" + hotdog.getCost());
        }
        if (player.totalRevenue() >= INITIAL_FRIES_PRICE) {
            friesUpgrade.setVisible(true);
            friesUpgrade.setText("Fries (" + fries.getCount() + ")\nPrice: $" + fries.getCost());
        }
        if (player.totalRevenue() >= INITIAL_PIZZA_PRICE) {
            pizzaUpgrade.setVisible(true);
            pizzaUpgrade.setText("Pizza (" + pizza.getCount() + ")\nPrice: $" + pizza.getCost());
        }
        if (player.totalRevenue() >= INITIAL_POUTINE_PRICE) {
            poutineUpgrade.setVisible(true);
            poutineUpgrade.setText("Poutine (" + poutine.getCount() + ")\nPrice: $" + poutine.getCost());
        }
        if (player.totalRevenue() >= INITIAL_CHICKEN_PRICE) {
            chickenUpgrade.setVisible(true);
            chickenUpgrade.setText("Chicken Strips (" + chicken.getCount() + ")\nPrice: $" + chicken.getCost());
        }
        if (player.totalRevenue() >= INITIAL_ICECREAM_PRICE) {
            icecreamUpgrade.setVisible(true);
            icecreamUpgrade.setText("Ice cream (" + icecream.getCount() + ")\nPrice: $" + icecream.getCost());
        }
    }

    /**
     * Confirms if the user has enough revenue to buy a hot dog upgrade.
     * <p>
     * Checks if the user has enough revenue to buy an upgrade. If they do, then this method
     * increments passive revenue gain by 1.25 and removes the value of hotdog.getCost() from
     * totalRevenue. It then makes the price of hot dog $5 more and increments the hot dog count
     * by one. Finally, it increments the players click value by 0.5. (the click value is how much
     * revenue is gained with each click). If the user does not have enough revenue to buy a
     * hot dog upgrade, then the method does not allow the user to buy the hot dog.
     * </p>
     */
    @FXML
    protected void confirmHotdogAmount() {
        if (player.totalRevenue() < hotdog.getCost()) { // checks if player has enough revenue to purchase a hotdog
            purchaseText.setText("Not enough money to buy Hotdog"); // change, ofc
        } else {
            hotdog.incrementPassiveValue(HOTDOG_PASSIVE_VALUE);
            purchaseText.setText("Purchased hotdog");
            player.decrementRevenue(hotdog.getCost()); // decrements revenue by cost of hotdog
            player.receiveRevenue(hotdog.getPassiveIncome());
            hotdog.setCost(hotdog.getCost() + HOTDOG_INCREMENT);
            hotdog.incrementCount();
            hotdogUpgrade.setText("Hot dog (" + hotdog.getCount() + ")\nPrice: $" + hotdog.getCost());
            totalRevenue.setText("$" + player.totalRevenue());
            totalPassiveIncome.setText("Passive Income: $" + passiveIncome());
            player.setClickerValue(CLICKER_VALUE);
        }
    }

    /**
     * Confirms if the user has enough revenue to buy the fries upgrade.
     * <p>
     * Checks if the user has enough revenue to buy an upgrade. If they do, then this method
     * increments passive revenue gain by 5.00 and removes the value of fries.getCost() from
     * totalRevenue. It then makes the price of fries $25 more and increments the fries count
     * by one. Finally, it increments the players click value by 0.5. (the click value is how much
     * revenue is gained with each click). If the user does not have enough revenue to buy the
     * fries upgrade, then the method does not allow the user to buy fries.
     * </p>
     */
    @FXML
    protected void confirmFriesAmount() {
        if (player.totalRevenue() < fries.getCost()) {
            purchaseText.setText("Not enough money to buy fries");
        } else {
            fries.incrementPassiveValue(FRIES_PASSIVE_VALUE);
            purchaseText.setText("Purchased Fries");
            player.decrementRevenue(fries.getCost());
            fries.setCost(fries.getCost() + FRIES_INCREMENT);
            fries.incrementCount();
            friesUpgrade.setText("Fries (" + fries.getCount() + ")\nPrice: $" + fries.getCost());
            totalRevenue.setText("$" + player.totalRevenue());
            totalPassiveIncome.setText("Passive Income: $" + passiveIncome());
            player.setClickerValue(CLICKER_VALUE);
        }
    }

    /**
     * Confirms if the user has enough revenue to buy the pizza upgrade.
     * <p>
     * Checks if the user has enough revenue to buy an upgrade. If they do, then this method
     * increments passive revenue gain by 18.00 and removes the value of pizza.getCost() from
     * totalRevenue. It then makes the price of pizza $250 more and increments the pizza count
     * by one. Finally, it increments the players click value by 0.5. (the click value is how much
     * revenue is gained with each click). If the user does not have enough revenue to buy a
     * pizza upgrade, then the method does not allow the user to buy the upgrade.
     * </p>
     */
    @FXML
    protected void confirmPizzaAmount() {
        if (player.totalRevenue() < pizza.getCost()) {
            purchaseText.setText("Not enough money to buy pizza");
        } else {
            pizza.incrementPassiveValue(PIZZA_PASSIVE_VALUE);
            purchaseText.setText("Purchased Pizza");
            player.decrementRevenue(pizza.getCost());
            pizza.setCost(pizza.getCost() + PIZZA_INCREMENT);
            pizza.incrementCount();
            pizzaUpgrade.setText("Pizza (" + pizza.getCount() + ")\nPrice: $" + pizza.getCost());
            totalRevenue.setText("$" + player.totalRevenue());
            totalPassiveIncome.setText("Passive Income: $" + passiveIncome());
            player.setClickerValue(CLICKER_VALUE);
        }
    }

    /**
     * Confirms if the user has enough revenue to buy the poutine upgrade.
     * <p>
     * Checks if the user has enough revenue to buy an upgrade. If they do, then this method
     * increments passive revenue gain by 36.00 and removes the value of poutine.getCost() from
     * totalRevenue. It then makes the price of poutine $1300 more and increments the poutine count
     * by one. Finally, it increments the players click value by 0.5. (the click value is how much
     * revenue is gained with each click). If the user does not have enough revenue to buy a
     * poutine upgrade, then the method does not allow the user to buy the upgrade.
     * </p>
     */
    @FXML
    protected void confirmPoutineAmount() {
        if (player.totalRevenue() < poutine.getCost()) {
            purchaseText.setText("Not enough money to buy poutine");
        } else {
            poutine.incrementPassiveValue(POUTINE_PASSIVE_VALUE);
            purchaseText.setText("Purchased Poutine");
            player.decrementRevenue(poutine.getCost());
            poutine.setCost(poutine.getCost() + POUTINE_INCREMENT);
            poutine.incrementCount();
            poutineUpgrade.setText("Poutine (" + poutine.getCount() + ")\nPrice: $" + poutine.getCost());
            totalRevenue.setText("$" + player.totalRevenue());
            totalPassiveIncome.setText("Passive Income: $" + passiveIncome());
            player.setClickerValue(CLICKER_VALUE);
        }
    }

    /**
     * Confirms if the user has enough revenue to buy the Chicken Strips upgrade.
     * <p>
     * Checks if the user has enough revenue to buy an upgrade. If they do, then this method
     * increments passive revenue gain by 99.00 and removes the value of chicken.getCost() from
     * totalRevenue. It then makes the price of chicken strips $2600 more and increments the chicken count
     * by one. Finally, it increments the players click value by 0.5. (the click value is how much
     * revenue is gained with each click). If the user does not have enough revenue to buy the
     * chicken strips upgrade, then the method does not allow the user to buy the upgrade.
     * </p>
     */
    @FXML
    protected void confirmChickenAmount() {
        if (player.totalRevenue() < chicken.getCost()) {
            purchaseText.setText("Not enough money to buy chicken strips");
        } else {
            chicken.incrementPassiveValue(CHICKEN_PASSIVE_VALUE);
            purchaseText.setText("Purchased Chicken Strips");
            player.decrementRevenue(chicken.getCost());
            chicken.setCost(chicken.getCost() + CHICKEN_INCREMENT);
            chicken.incrementCount();
            chickenUpgrade.setText("Chicken Strips (" + chicken.getCount() + ")\nPrice: $" + chicken.getCost());
            totalRevenue.setText("$" + player.totalRevenue());
            totalPassiveIncome.setText("Passive Income: $" + passiveIncome());
            player.setClickerValue(CLICKER_VALUE);
        }
    }

    /**
     * Confirms if the user has enough revenue to buy the ice cream upgrade.
     * <p>
     * Checks if the user has enough revenue to buy an upgrade. If they do, then this method
     * increments passive revenue gain by 173.00 and removes the value of icecream.getCost() from
     * totalRevenue. It then makes the price of ice cream $4500 more and increments the icecream count
     * by one. Finally, it increments the players click value by 1. (the click value is how much
     * revenue is gained with each click). If the user does not have enough revenue to buy a
     * ice cream upgrade, then the method does not allow the user to buy the upgrade.
     * </p>
     */
    @FXML
    protected void confirmIcecreamAmount() {
        if (player.totalRevenue() < icecream.getCost()) {
            purchaseText.setText("Not enough money to buy ice cream");
        } else {
            icecream.incrementPassiveValue(ICECREAM_PASSIVE_VALUE);
            purchaseText.setText("Purchased Ice Cream");
            player.decrementRevenue(icecream.getCost());
            icecream.setCost(icecream.getCost() + ICECREAM_INCREMENT);
            icecream.incrementCount();
            icecreamUpgrade.setText("Ice Cream (" + icecream.getCount() + ")\nPrice: $" + icecream.getCost());
            totalRevenue.setText("$" + player.totalRevenue());
            totalPassiveIncome.setText("Passive Income: $" + passiveIncome());
            player.setClickerValue(ICECREAM_CLICKER_VALUE);
        }
    }

    /**
     * Adds the passiveIncome from all upgrades and return's the total passive income.
     *
     * @return total passive income.
     */
    public double passiveIncome() {
        double hotdogIncome = hotdog.getPassiveIncome();
        double friesIncome = fries.getPassiveIncome();
        double pizzaIncome = pizza.getPassiveIncome();
        double poutineIncome = poutine.getPassiveIncome();
        double chickenIncome = chicken.getPassiveIncome();
        double icecreamIncome = icecream.getPassiveIncome();
        return hotdogIncome + friesIncome + pizzaIncome + poutineIncome
                + chickenIncome + icecreamIncome;
    }

    /**
     * Passively increments the total revenue by passive incomes of each upgrade
     * (if the user bought them).
     */
    @FXML
    protected void incrementRevenue() {
        if (returnToGame == 0) {
            returnToGame++;
            totalPassiveIncome.setText("Passive Income: $" + passiveIncome());
            tooltips();
            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(INCREMENT_TIMEFRAME), actionEvent -> {
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
    }

    /**
     * Saves game to text file with required data.
     *
     * @param event triggered by handler
     */
    @FXML
    public void saveGame(final ActionEvent event) {
        try {
            File file = new File("game_data.txt");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Save player data
            bufferedWriter.write(player.totalRevenue() + "\n");
            System.out.println("Writing to file: " + player.totalRevenue());
            bufferedWriter.write(player.getClickerValue() + "\n");
            System.out.println("Player revenue set to: " + player.totalRevenue());

            // Save hotdog data
            bufferedWriter.write(hotdog.getCount() + "\n");
            System.out.println("Writing to file: " + hotdog.getCount());
            bufferedWriter.write(hotdog.getCost() + "\n");
            System.out.println("Hotdog count set to: " + hotdog.getCount());

            // Save fries data
            bufferedWriter.write(fries.getCount() + "\n");
            bufferedWriter.write(fries.getCost() + "\n");

            // Save pizza data
            bufferedWriter.write(pizza.getCount() + "\n");
            bufferedWriter.write(pizza.getCost() + "\n");

            // Save poutine data
            bufferedWriter.write(poutine.getCount() + "\n");
            bufferedWriter.write(poutine.getCost() + "\n");

            // Save chicken strips data
            bufferedWriter.write(chicken.getCount() + "\n");
            bufferedWriter.write(chicken.getCost() + "\n");

            // Save ice cream data
            bufferedWriter.write(icecream.getCount() + "\n");
            bufferedWriter.write(icecream.getCost() + "\n");

            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
            System.out.println("Game data saved to " + file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Resets game state so that save values can populate the current scene.
     */
    public void reset() {
        initialize();
        totalRevenue.setText("$" + player.totalRevenue());
        totalPassiveIncome.setText("Passive Income: $" + passiveIncome());
    }

    /**
     * Loads game from text file to current scene with relevant data.
     *
     * @param event triggered by handler
     */
    @FXML
    public void loadGame(final ActionEvent event) {
        try {
            File file = new File("game_data.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // Load player data
            String playerRevenueString = bufferedReader.readLine();
            double playerRevenue = Double.parseDouble(playerRevenueString);
            String clickerValueString = bufferedReader.readLine();
            double clickerVal = Double.parseDouble(clickerValueString);
            player = new Player(playerRevenue, clickerVal);

            // Load hotdog data
            String hotdogCountString = bufferedReader.readLine();
            int hotdogCount = Integer.parseInt(hotdogCountString);
            String hotdogCostString = bufferedReader.readLine();
            double hotdogCost = Double.parseDouble(hotdogCostString);

            // Load fries data
            String friesCountString = bufferedReader.readLine();
            int friesCount = Integer.parseInt(friesCountString);
            String friesCostString = bufferedReader.readLine();
            double friesCost = Double.parseDouble(friesCostString);

            // Load pizza data
            String pizzaCountString = bufferedReader.readLine();
            int pizzaCount = Integer.parseInt(pizzaCountString);
            String pizzaCostString = bufferedReader.readLine();
            double pizzaCost = Double.parseDouble(pizzaCostString);

            // Load poutine data
            String poutineCountString = bufferedReader.readLine();
            int poutineCount = Integer.parseInt(poutineCountString);
            String poutineCostString = bufferedReader.readLine();
            double poutineCost = Double.parseDouble(poutineCostString);

            // Load chicken strips data
            String chickenCountString = bufferedReader.readLine();
            int chickenCount = Integer.parseInt(chickenCountString);
            String chickenCostString = bufferedReader.readLine();
            double chickenCost = Double.parseDouble(chickenCostString);

            // Load ice cream data
            String icecreamCountString = bufferedReader.readLine();
            int icecreamCount = Integer.parseInt(icecreamCountString);
            String icecreamCostString = bufferedReader.readLine();
            double icecreamCost = Double.parseDouble(icecreamCostString);

            bufferedReader.close();
            fileReader.close();
            System.out.println("Game data loaded from " + file.getAbsolutePath());

            hotdog.setCount(hotdogCount);
            hotdog.setCost(hotdogCost);
            hotdog.setPassiveValue(HOTDOG_PASSIVE_VALUE * hotdogCount);

            fries.setCount(friesCount);
            fries.setCost(friesCost);
            fries.setPassiveValue(FRIES_PASSIVE_VALUE * friesCount);

            pizza.setCount(pizzaCount);
            pizza.setCost(pizzaCost);
            pizza.setPassiveValue(PIZZA_PASSIVE_VALUE * pizzaCount);

            poutine.setCount(poutineCount);
            poutine.setCost(poutineCost);
            poutine.setPassiveValue(POUTINE_PASSIVE_VALUE * poutineCount);

            chicken.setCount(chickenCount);
            chicken.setCost(chickenCost);
            chicken.setPassiveValue(CHICKEN_PASSIVE_VALUE * chickenCount);

            icecream.setCount(icecreamCount);
            icecream.setCost(icecreamCost);
            icecream.setPassiveValue(ICECREAM_PASSIVE_VALUE * icecreamCount);

            reset();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
