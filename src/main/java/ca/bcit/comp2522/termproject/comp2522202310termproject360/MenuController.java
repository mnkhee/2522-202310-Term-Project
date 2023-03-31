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
            FileOutputStream fileOut = new FileOutputStream("game_data.ser");
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
            System.out.println("Game data saved.");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    @FXML
    public void loadGame(ActionEvent event) {
        try {
            FileInputStream fileIn = new FileInputStream("game_data.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);

            // Load player data
            Player player = new Player();
            player.receiveRevenue((Double) in.readObject());
            player.setClickerValue((Integer) in.readObject());

            // Load fries data
            Fries fries = new Fries();
            fries.setCost((Double) in.readObject());
            fries.setPassiveValue((Double) in.readObject());
            fries.incrementCount();

            // Load pizza data
            Pizza pizza = new Pizza();
            pizza.setCost((Double) in.readObject());
            pizza.setPassiveValue((Double) in.readObject());
            pizza.incrementCount();

            // Load chicken strip data
            ChickenStrips chickenStrips = new ChickenStrips();
            chickenStrips.setCost((Double) in.readObject());
            chickenStrips.setPassiveValue((Double) in.readObject());
            chickenStrips.incrementCount();

            // Load hotDog data
            HotDog hotdog = new HotDog();
            hotdog.setCost((Double) in.readObject());
            hotdog.setPassiveValue((Double) in.readObject());
            hotdog.incrementCount();

            // Load icecream data
            Icecream icecream = new Icecream();
            icecream.setCost((Double) in.readObject());
            icecream.setPassiveValue((Double) in.readObject());
            icecream.incrementCount();

            // Load poutine data
            Poutine poutine = new Poutine();
            poutine.setCost((Double) in.readObject());
            poutine.setPassiveValue((Double) in.readObject());
            poutine.incrementCount();


            in.close();
            fileIn.close();
            System.out.println("Game data loaded.");
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Game data class not found.");
            c.printStackTrace();
        }
    }



}

