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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * MenuController class implements Initializable.
 *
 * @author Joshua Chuah & Justin Oh
 * @version 2023
 */
public class MenuController implements Initializable {
    @FXML
    private VBox root;

    @FXML
    private Button startButton;

    @FXML
    private Button quitButton;

    /**
     * Initializes the controller.
     *
     * @param url location used to resolve relative path for the root object
     * @param resourceBundle resources used to localize root object
     */
    @Override
    public void initialize(final URL url, final ResourceBundle resourceBundle) {

    }
//    public void initializeGame(Player player, Fries fries, Pizza pizza,
//    ChickenStrips chickenStrips, HotDog hotdog, Icecream icecream, Poutine poutine) {
//        // Set the player
//        GameController.getInstance().setPlayer(player);
//
//        // Set the food items
//        GameController.getInstance().setFries(fries);
//        GameController.getInstance().setPizza(pizza);
//        GameController.getInstance().setChickenStrips(chickenStrips);
//        GameController.getInstance().setHotDog(hotdog);
//        GameController.getInstance().setIcecream(icecream);
//        GameController.getInstance().setPoutine(poutine);
//
//        // Start the game
//        GameController.getInstance().initialize();
//    }

    /**
     * Starts game and loads the game view.
     *
     * @param event event triggered by handler
     * @throws IOException if there is an error loading game view.
     */
    @FXML
    private void startGame(final ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("game-view.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Quits game and displays quit button for user confirmation.
     *
     * @param event event triggered by handler
     */
    @FXML
    public void quitGame(final ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to quit?");
        alert.setTitle("Quit");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.fireEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSE_REQUEST));
        }
    }
}

