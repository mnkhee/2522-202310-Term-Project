package ca.bcit.comp2522.termproject.comp2522202310termproject360;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class GameDriver extends Application {
//    @Override
//    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(GameDriver.class.getResource("game-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
//        stage.setTitle("Costco Clicker");
//        stage.setScene(scene);
//        stage.show();
//    }
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GameDriver.class.getResource("menu-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setTitle("Game Menu");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
    public void quitGame() {
        Platform.exit();
        System.exit(0);
    }
}