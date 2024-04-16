package project.app.cpsc233project.app;

/**
 * 
 * @author Yadwinder Singh Dhaliwal @tutorial T05
 * @author Jaspinder Singh Maan @tutorial T15
 * @author Navpreet Singh @tutorial T08
 * @created 2024-04-15
 * 
 */

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import project.app.cpsc233project.data;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    private MenuItem back;
    @FXML
    private TextArea feedback;
    @FXML
    private MenuItem about;
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

    /**
     * we use this filename as a stering path when we need to remove the
     * object from the csv file
     */
    String filename="ProjectDB.csv";
    @FXML
    private void handleSubmit() {
        String input=UCID.getText();
        if (!input.matches("\\d+")) {
            showAlert("invalid input","UCID must contain only numbers.");
            return; // Stop processing since the UCID is not valid
        }
        int ucid = Integer.parseInt(UCID.getText()); // Get UCID from TextField
         if (ucid<=0) {

            showAlert("Invalid input", "Please enter a valid number for UCID.");

        }if (!input.matches("\\d+")) {
            showAlert("invalid input","UCID must contain only numbers.");
            return; // Stop processing since the UCID is not valid
        } else if (!data.ucidExists("ProjectDB.csv", ucid)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Sign Out Error");
            alert.setContentText("UCID does not exist. Please ensure you have signed in.");
            alert.showAndWait();
        } else {
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
                try {
                    removeUcidFromCsv(filename, ucid);
                } catch (IOException e) {
                    e.printStackTrace();
                    showAlert("Error", "Failed to update the database.");
                    return;
                }
            } else {
                // User chose NO or closed the dialog
                exitPage();
            }
        }
    }

    /**
     * this handles the sing out process and checks that the UCID entered is a positive integer
     * and it throws a pop up alert if it is not
     */

    private void signOutSuccess() {
        Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
        infoAlert.setTitle("Sign Out Successful");
        infoAlert.setHeaderText(null);
        infoAlert.setContentText("You have successfully signed out and released the space.");
        infoAlert.showAndWait();
        returnToHomepage();
    }// this is the method that is used to shows if the sign out process was successful

    private void exitPage() {
        Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
        infoAlert.setTitle("Sign Out Cancelled");
        infoAlert.setHeaderText(null);
        infoAlert.setContentText("Sign out cancelled. Returning to the homepage.");
        infoAlert.showAndWait();

        returnToHomepage();
    }
    private void removeUcidFromCsv(String filePath, int ucid) throws IOException {
        File inputFile = new File(filePath);
        List<String> lines = Files.readAllLines(inputFile.toPath());
        List<String> updatedLines = lines.stream()
                .filter(line -> !line.contains(String.valueOf(ucid)))
                .collect(Collectors.toList());
        Files.write(Paths.get(filePath), updatedLines);
    }// this removes object from the csv file
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
    @FXML
    private void backButton(){
        returnToHomepage();
    }
    @FXML
    private void showAboutDialog() {
        Alert aboutDialog = new Alert(Alert.AlertType.INFORMATION);
        aboutDialog.setTitle("About");
        aboutDialog.setHeaderText("About TFDL Occupancy Tracker");
        aboutDialog.setContentText("TFDL Occupancy Tracker v1.0\nDeveloped by: Jaspinder Singh, Navpreet Singh & Yadwinder Singh\n© 2024 All rights reserved.\n For any inquires please reach us \nout @ JaspinderSingh.maan@ucalgary.ca");

        aboutDialog.showAndWait();
    }

}
