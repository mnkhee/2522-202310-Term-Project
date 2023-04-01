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

import java.io.*;

public class GameController {
    HotDog hotdog = new HotDog();
    Player player = new Player(0,1);
    Fries fries = new Fries();
    Pizza pizza = new Pizza();
    Poutine poutine = new Poutine();
    ChickenStrips chicken = new ChickenStrips();
    Icecream icecream = new Icecream();
    Timeline timeline;
    @FXML
    public Label totalRevenue;
    @FXML
    private Label purchaseText;
    public Button hotdogButton;

    @FXML
    public Label totalPassiveIncome;
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
    int test = 0;



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

    // method for tooltips (hovering over buttons will display a message. not sure what to do with this tbh)
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
            hotdog.incrementPassiveValue(1.25);
            purchaseText.setText("Purchased hotdog");
            player.decrementRevenue(hotdog.getCost()); // decrements revenue by cost of hotdog
            player.receiveRevenue(hotdog.getPassiveIncome());
            hotdog.setCost(hotdog.getCost() + 5);
            hotdog.incrementCount();
            hotdogUpgrade.setText("Hot dog (" + hotdog.getCount() + ")\nPrice: $" + hotdog.getCost());
            totalRevenue.setText("$" + player.totalRevenue());
            totalPassiveIncome.setText("Passive Income: $" + passiveIncome());
            //incrementRevenue();
        }
    }

    @FXML
    protected void confirmFriesAmount() {
        if (player.totalRevenue() < fries.getCost()) {
            purchaseText.setText("Not enough money to buy fries");
        } else {
            fries.incrementPassiveValue(5.00);
            purchaseText.setText("Purchased Fries");
            player.decrementRevenue(fries.getCost());
            fries.setCost(fries.getCost() + 25);
            fries.incrementCount();
            friesUpgrade.setText("Fries (" + fries.getCount() + ")\nPrice: $" + fries.getCost());
            totalRevenue.setText("$" + player.totalRevenue());
            totalPassiveIncome.setText("Passive Income: $" + passiveIncome());
            //incrementRevenue();
        }
    }

    @FXML
    protected void confirmPizzaAmount() {
        if (player.totalRevenue() < pizza.getCost()) {
            purchaseText.setText("Not enough money to buy pizza");
        } else {
            pizza.incrementPassiveValue(18.00);
            purchaseText.setText("Purchased Pizza");
            player.decrementRevenue(pizza.getCost());
            pizza.setCost(pizza.getCost() + 250);
            pizza.incrementCount();
            pizzaUpgrade.setText("Pizza (" + pizza.getCount() + ")\nPrice: $" + pizza.getCost());
            totalRevenue.setText("$" + player.totalRevenue());
            totalPassiveIncome.setText("Passive Income: $" + passiveIncome());
            //incrementRevenue();
        }
    }

    @FXML
    protected void confirmPoutineAmount() {
        if (player.totalRevenue() < poutine.getCost()) {
            purchaseText.setText("Not enough money to buy poutine");
        } else {
            poutine.incrementPassiveValue(36.00);
            purchaseText.setText("Purchased Poutine");
            player.decrementRevenue(poutine.getCost());
            poutine.setCost(poutine.getCost() + 1300);
            poutine.incrementCount();
            poutineUpgrade.setText("Poutine (" + poutine.getCount() + ")\nPrice: $" + poutine.getCost());
            totalRevenue.setText("$" + player.totalRevenue());
            totalPassiveIncome.setText("Passive Income: $" + passiveIncome());
            //incrementRevenue();
        }
    }

    @FXML
    protected void confirmChickenAmount() {
        if (player.totalRevenue() < chicken.getCost()) {
            purchaseText.setText("Not enough money to buy chicken strips");
        } else {
            chicken.incrementPassiveValue(99.00);
            purchaseText.setText("Purchased Chicken Strips");
            player.decrementRevenue(chicken.getCost());
            chicken.setCost(chicken.getCost() + 2600);
            chicken.incrementCount();
            chickenUpgrade.setText("Chicken Strips (" + chicken.getCount() + ")\nPrice: $" + chicken.getCost());
            totalRevenue.setText("$" + player.totalRevenue());
            totalPassiveIncome.setText("Passive Income: $" + passiveIncome());
            //incrementRevenue();
        }
    }

    @FXML
    protected void confirmIcecreamAmount() {
        if (player.totalRevenue() < icecream.getCost()) {
            purchaseText.setText("Not enough money to buy ice cream");
        } else {
            icecream.incrementPassiveValue(173.00);
            purchaseText.setText("Purchased Ice Cream");
            player.decrementRevenue(icecream.getCost());
            icecream.setCost(icecream.getCost() + 4500);
            icecream.incrementCount();
            icecreamUpgrade.setText("Ice Cream (" + icecream.getCount() + ")\nPrice: $" + icecream.getCost());
            totalRevenue.setText("$" + player.totalRevenue());
            totalPassiveIncome.setText("Passive Income: $" + passiveIncome());
            //incrementRevenue();
        }
    }

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

    // increments total revenue automatically
    @FXML
    protected void incrementRevenue() {
        if (test == 0) {
            test++;
            totalPassiveIncome.setText("Passive Income: $" + passiveIncome());
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
    }

    @FXML
    public void saveGame(ActionEvent event) {
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
    public void reset() {
        initialize();
        totalRevenue.setText("$" +player.totalRevenue());
        totalPassiveIncome.setText("Passive Income: $" + passiveIncome());
    }
    @FXML
    public void loadGame(ActionEvent event) {
        try {
            File file = new File("game_data.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // Load player data
            String playerRevenueString = bufferedReader.readLine();
            double playerRevenue = Double.parseDouble(playerRevenueString);
            String clickerValueString = bufferedReader.readLine();
            int clickerValue = Integer.parseInt(clickerValueString);
            player = new Player(playerRevenue, clickerValue);

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
            hotdog.setPassiveValue(1.25 * hotdogCount);

            fries.setCount(friesCount);
            fries.setCost(friesCost);
            fries.setPassiveValue(5.00 * friesCount);

            pizza.setCount(pizzaCount);
            pizza.setCost(pizzaCost);
            pizza.setPassiveValue(18.00 * pizzaCount);

            poutine.setCount(poutineCount);
            poutine.setCost(poutineCost);
            poutine.setPassiveValue(36.00 * poutineCount);

            chicken.setCount(chickenCount);
            chicken.setCost(chickenCost);
            chicken.setPassiveValue(99.00 * chickenCount);

            icecream.setCount(icecreamCount);
            icecream.setCost(icecreamCost);
            icecream.setPassiveValue(173.00 * icecreamCount);

            reset();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void setHotDog(HotDog hotdog) {
        this.hotdog = hotdog;
    }

    public void setPlayer(Player player) {
        this.player = player;
        System.out.println("Player clicker value set to: " + player.getClickerValue());
        System.out.println("Player revenue set to: " + player.totalRevenue());


    }

    public void setFries(Fries fries) {
        this.fries = fries;
        System.out.println("Fries count set to: " + fries.getCount());

    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
        System.out.println("pizza count set to: " + pizza.getCount());

    }

    public void setPoutine(Poutine poutine) {

        this.poutine = poutine;
        System.out.println("Poutine count set to: " + poutine.getCount());

    }

    public void setChickenStrips(ChickenStrips chicken) {
        this.chicken = chicken;
        System.out.println("Chicken strip count set to: " + chicken.getCount());

    }

    public void setIcecream(Icecream icecream) {
        this.icecream = icecream;
        System.out.println("Icecream count set to: " + icecream.getCount());

    }

    public HotDog getHotDog() {
        return hotdog;
    }

    public Player getPlayer() {
        return player;
    }

    public Fries getFries() {
        return fries;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public Poutine getPoutine() {
        return poutine;
    }

    public ChickenStrips getChickenStrips() {
        return chicken;
    }

    public Icecream getIcecream() {
        return icecream;
    }
}