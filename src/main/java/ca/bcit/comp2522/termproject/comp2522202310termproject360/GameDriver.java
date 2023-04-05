package ca.bcit.comp2522.termproject.comp2522202310termproject360;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Application class. Sets stage and initializes application.
 *
 * @author Joshua Chuah & Justin Oh
 * @version 2023
 */
public class GameDriver extends Application {
    /**
     * Width of game.
     */
    static final int GAME_WIDTH = 1280;
    /**
     * Height of game.
     */
    static final int GAME_HEIGHT = 720;

    /**
     * Starts the application with the initial screen, which is the menu.
     *
     * @param stage the stage that will be launched in the application window
     * @throws IOException if game fails to launch
     */
    @Override
    public void start(final Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GameDriver.class.getResource("menu-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), GAME_WIDTH, GAME_HEIGHT);
        stage.setTitle("Game Menu");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Launches application, main method.
     *
     * @param args arguments to pass main method
     */
    public static void main(final String[] args) {
        launch();
    }
}
