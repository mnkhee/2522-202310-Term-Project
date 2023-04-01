package ca.bcit.comp2522.termproject.comp2522202310termproject360;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;

public class MenuController implements Initializable {
    @FXML
    private VBox root;

    @FXML
    private Button startButton;

    @FXML
    private Button quitButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void initializeGame(Player player, Fries fries, Pizza pizza, ChickenStrips chickenStrips, HotDog hotdog, Icecream icecream, Poutine poutine) {
        // Set the player
        GameController.getInstance().setPlayer(player);

        // Set the food items
        GameController.getInstance().setFries(fries);
        GameController.getInstance().setPizza(pizza);
        GameController.getInstance().setChickenStrips(chickenStrips);
        GameController.getInstance().setHotDog(hotdog);
        GameController.getInstance().setIcecream(icecream);
        GameController.getInstance().setPoutine(poutine);

        // Start the game
        GameController.getInstance().initialize();
    }


    @FXML
    private void startGame(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("game-view.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void quitGame(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to quit?");
        alert.setTitle("Quit");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.fireEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSE_REQUEST));
        }
    }
    @FXML
    public void saveGame(ActionEvent event) {
        try {
            File file = new File("game_data.txt");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Save player data
            Player player = GameController.getInstance().getPlayer();
            bufferedWriter.write(player.totalRevenue() + "\n");
            bufferedWriter.write(player.getClickerValue() + "\n");

            // Save fries data
            Fries fries = GameController.getInstance().getFries();
            bufferedWriter.write(fries.getCount() + "\n");
            bufferedWriter.write(fries.getCost() + "\n");

            // Save pizza data
            Pizza pizza = GameController.getInstance().getPizza();
            bufferedWriter.write(pizza.getCount() + "\n");
            bufferedWriter.write(pizza.getCost() + "\n");


            // Save chicken strip data
            ChickenStrips chickenStrips = GameController.getInstance().getChickenStrips();
            bufferedWriter.write(chickenStrips.getCount() + "\n");
            bufferedWriter.write(chickenStrips.getCost() + "\n");

            // Save hotdog data
            HotDog hotdog = GameController.getInstance().getHotDog();
            bufferedWriter.write(hotdog.getCount() + "\n");
            bufferedWriter.write(hotdog.getCost() + "\n");

            // Save ice cream data
            Icecream icecream = GameController.getInstance().getIcecream();
            bufferedWriter.write(icecream.getCount() + "\n");
            bufferedWriter.write(icecream.getCost() + "\n");


            // Save poutine data
            Poutine poutine = GameController.getInstance().getPoutine();
            bufferedWriter.write(poutine.getCount() + "\n");
            bufferedWriter.write(poutine.getCost() + "\n");

            bufferedWriter.close();
            System.out.println("Game data saved to " + file.getAbsolutePath());
        } catch (IOException i) {
            i.printStackTrace();
        }
    }




//    @FXML
//    public void loadGame(ActionEvent event) {
//        try {
//            FileInputStream fileIn = new FileInputStream("game_data.ser");
//            ObjectInputStream in = new ObjectInputStream(fileIn);
//
//            // Load player data
//            Player player = new Player();
//            player.receiveRevenue((Double) in.readObject());
//            player.setClickerValue((Integer) in.readObject());
//
//            // Load fries data
//            Fries fries = new Fries();
//            fries.setCost((Double) in.readObject());
//            fries.setPassiveValue((Double) in.readObject());
//            fries.incrementCount();
//
//            // Load pizza data
//            Pizza pizza = new Pizza();
//            pizza.setCost((Double) in.readObject());
//            pizza.setPassiveValue((Double) in.readObject());
//            pizza.incrementCount();
//
//            // Load chicken strip data
//            ChickenStrips chickenStrips = new ChickenStrips();
//            chickenStrips.setCost((Double) in.readObject());
//            chickenStrips.setPassiveValue((Double) in.readObject());
//            chickenStrips.incrementCount();
//
//            // Load hotDog data
//            HotDog hotdog = new HotDog();
//            hotdog.setCost((Double) in.readObject());
//            hotdog.setPassiveValue((Double) in.readObject());
//            hotdog.incrementCount();
//
//            // Load icecream data
//            Icecream icecream = new Icecream();
//            icecream.setCost((Double) in.readObject());
//            icecream.setPassiveValue((Double) in.readObject());
//            icecream.incrementCount();
//
//            // Load poutine data
//            Poutine poutine = new Poutine();
//            poutine.setCost((Double) in.readObject());
//            poutine.setPassiveValue((Double) in.readObject());
//            poutine.incrementCount();
//
//            in.close();
//            fileIn.close();
//
//            // Initialize the game with the loaded data
//            initializeGame(player, fries, pizza, chickenStrips, hotdog, icecream, poutine);
//
//            System.out.println("Game data loaded.");
//        } catch (IOException i) {
//            i.printStackTrace();
//        } catch (ClassNotFoundException c) {
//            System.out.println("Game data class not found.");
//            c.printStackTrace();
//        }
//    }

    @FXML
    public void loadGame(ActionEvent event) {
        try {
            FileInputStream fileIn = new FileInputStream("game_data.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);

            // Load player data
            Double revenue = (Double) in.readObject();
            Integer clickerValue = (Integer) in.readObject();

            // Load fries data
            Integer friesCount = (Integer) in.readObject();
            Double friesCost = (Double) in.readObject();


            // Load pizza data
            Integer pizzaCount = (Integer) in.readObject();
            Double pizzaCost = (Double) in.readObject();


            // Load chicken strip data
            Integer chickenStripsCount = (Integer) in.readObject();
            Double chickenStripsCost = (Double) in.readObject();


            // Load hotDog data
            Integer hotDogCount = (Integer) in.readObject();
            Double hotDogCost = (Double) in.readObject();


            // Load icecream data
            Integer iceCreamCount = (Integer) in.readObject();
            Double iceCreamCost = (Double) in.readObject();


            // Load poutine data
            Integer poutineCount = (Integer) in.readObject();
            Double poutineCost = (Double) in.readObject();


            in.close();
            fileIn.close();

            // Initialize the game with the loaded data
            Player player = new Player(0, 1);
            player.receiveRevenue(revenue);
            player.setClickerValue(clickerValue);

            Fries fries = new Fries();
            fries.setCount(friesCount);
            fries.setCost(friesCost);

            Pizza pizza = new Pizza();
            pizza.setCount(pizzaCount);
            pizza.setCost(pizzaCost);


            ChickenStrips chickenStrips = new ChickenStrips();
            chickenStrips.setCount(chickenStripsCount);
            chickenStrips.setCost(chickenStripsCost);


            HotDog hotdog = new HotDog();
            hotdog.setCount(hotDogCount);
            hotdog.setCost(hotDogCost);

            Icecream icecream = new Icecream();
            icecream.setCount(iceCreamCount);
            icecream.setCost(iceCreamCost);

            Poutine poutine = new Poutine();
            poutine.setCount(poutineCount);
            poutine.setCost(poutineCost);

            initializeGame(player, fries, pizza, chickenStrips, hotdog, icecream, poutine);

            System.out.println("Game data loaded.");
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Game data class not found.");
            c.printStackTrace();
        }
    }
}

