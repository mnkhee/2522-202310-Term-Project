package ca.bcit.comp2522.termproject.comp2522202310termproject360;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class GameController {
    public Button hotdogButton;
    HotDog hotdog = new HotDog();
    @FXML
    private Label welcomeText;

    // all of these are tests, will probably be removed or altered.
    @FXML
    public double num = hotdog.getPassiveIncome();

    @FXML
    public double rev = num;
    @FXML
    private Label totalRevenue;

    @FXML
    protected void incrementCounter() {
        welcomeText.setText("Total Hot dog Production: " + num);
        totalRevenue.setText("Total Revenue: " + rev);
        this.rev += this.num;
    }
    @FXML
    protected void Click() {
        this.rev = 0;
        totalRevenue.setText("Total Revenue: " + rev);
    }
}