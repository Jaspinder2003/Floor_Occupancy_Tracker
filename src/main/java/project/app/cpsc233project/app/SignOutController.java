package project.app.cpsc233project.app;



import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SignOutController {
    @FXML
    private Button welcomePageSignOut;

    @FXML
    private Button welcomePageSignIn;

    @FXML
    private TextField UCID;
    @FXML
    private TextArea Feedback;
    @FXML
    private void validateAndProcess() {
        try {
            int ucid = Integer.parseInt(UCID.getText());
            if (ucid <= 0) {
                throw new IllegalArgumentException("UCID must be a positive number.");
            }
            // Proceed with processing if UCID is valid
        } catch (NumberFormatException e) {
            showAlert("Invalid input", "Please enter a valid number for UCID.");
        } catch (IllegalArgumentException e) {
            showAlert("Invalid UCID", e.getMessage());
        }
    }

    private void showAlert(String header, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

}
