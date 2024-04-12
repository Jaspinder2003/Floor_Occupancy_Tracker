package project.app.cpsc233project.app;



import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import project.app.cpsc233project.data;

import java.net.URL;
import java.util.Optional;

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
        }else {
            // UCID exists, ask for confirmation to release space
            Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
            confirmAlert.setTitle("Confirm Sign Out");
            confirmAlert.setHeaderText("Release Reserved Space");
            confirmAlert.setContentText("Do you want to release the reserved space and sign out?");

            ButtonType buttonTypeYes = new ButtonType("Yes");
            ButtonType buttonTypeNo = new ButtonType("No");

            confirmAlert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);

            Optional<ButtonType> result = confirmAlert.showAndWait();
            if (result.isPresent() && result.get() == buttonTypeYes) {
                // User chose YES
                signOutSuccess();
            } else {
                // User chose NO or closed the dialog
                exitPage();
            }
        }
    }

    private void signOutSuccess() {
        Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
        infoAlert.setTitle("Sign Out Successful");
        infoAlert.setHeaderText(null);
        infoAlert.setContentText("You have successfully signed out and released the space.");
        infoAlert.showAndWait();
        returnToHomepage();
        // Additional logic to clear data, redirect user, etc.
    }

    private void exitPage() {
        Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
        infoAlert.setTitle("Sign Out Cancelled");
        infoAlert.setHeaderText(null);
        infoAlert.setContentText("Sign out cancelled. Returning to the homepage.");
        infoAlert.showAndWait();

        returnToHomepage();
    }
    private void returnToHomepage(){
        Platform.runLater(() -> {
            try {
                URL url = getClass().getResource("/project/app/cpsc233project/fxml/Main.fxml");
                System.out.println("Resource URL: " + url); // Check the URL
                if (url == null) {
                    System.out.println("Check if Main.fxml is placed in src/main/resources and path is correct.");
                    throw new RuntimeException("Cannot find FXML file");
                }
                FXMLLoader loader = new FXMLLoader(url);
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage stage = (Stage) UCID.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }


}
