package viewmodel;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.UserSession;
import service.InputValidator;

public class SignUpController {
    @FXML
    private TextField usernameField; // This is the field for entering username

    @FXML
    private TextField passwordField; // This is the field for entering password

    // This creates a new account if the input is right
    public void createNewAccount(ActionEvent actionEvent) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (!InputValidator.isValidEmail(username)) {
            showError("Invalid email format.");
            return;
        }

        if (!InputValidator.isValidPassword(password)) {
            showError("Password must be at least 8 characters long, contain 1 uppercase letter, 1 lowercase letter, and 1 number.");
            return;
        }

        UserSession session = UserSession.getInstance(username, password, "USER");
        showInfo("Account created successfully! Username: " + session.getUserName());
        goToLoginPage(actionEvent);
    }

    // This returns to the login page
    public void goBack(ActionEvent actionEvent) {
        goToLoginPage(actionEvent);
    }

    // This switches to the login page
    private void goToLoginPage(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/login.fxml"));
            Scene scene = new Scene(root, 900, 600);
            scene.getStylesheets().add(getClass().getResource("/css/lightTheme.css").toExternalForm());
            Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // This shows an error with a message
    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // This shows an info with a message
    private void showInfo(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
