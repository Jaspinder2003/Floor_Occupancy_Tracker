package project.app.cpsc233project.app;



import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import project.app.cpsc233project.data;

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
    private Button submit;
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
String filename="C:\\Users\\jaspi\\OneDrive\\Desktop\\cpsc-233-group-proeject-w24-main\\ProjectDB.csv";
    @FXML
    private void handleSubmit() {
        int ucid = Integer.parseInt(UCID.getText()); // Get UCID from TextField
        String fileName = "path/to/ProjectDB.csv"; // Adjust path as necessary
        if (!data.ucidExists("C:\\Users\\jaspi\\OneDrive\\Desktop\\cpsc-233-group-proeject-w24-main\\ProjectDB.csv", ucid)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Sign Out Error");
            alert.setContentText("UCID does not exist. Please ensure you have signed in.");
            alert.showAndWait();
        } else {
            // UCID exists, proceed with other operations
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText("Sign Out Success");
            alert.setContentText("Proceeding with sign out.");
            alert.showAndWait();
            // Add additional actions after confirmation
        }
    }

}
