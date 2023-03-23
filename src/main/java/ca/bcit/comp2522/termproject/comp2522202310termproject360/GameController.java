package ca.bcit.comp2522.termproject.comp2522202310termproject360;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class GameController {
    @FXML
    private Label welcomeText;

    // all of these are tests, will probably be removed or altered.
    @FXML
    public int num = 1;

    @FXML
    public int rev = num;
    @FXML
    private Label totalRevenue;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Total Hot dog Production: " + num);
        totalRevenue.setText("Total Revenue: " + rev);
        this.rev++;
        this.num++;
    }
    @FXML
    protected void Click() {
        this.rev = 0;
        totalRevenue.setText("Total Revenue: " + rev);
    }
}