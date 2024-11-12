package viewmodel;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SpalshScreenController {
    @FXML
    private Label welcomeText; // This is to show the welcome page

    @FXML
    protected void onButtonClick() {

        welcomeText.setText("Welcome to JavaFX Application!");
    }
}