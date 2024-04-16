package project.app.cpsc233project.app;
import project.app.cpsc233project.stats;

/**
 * 
 * @author Yadwinder Singh Dhaliwal @tutorial T05
 * @author Jaspinder Singh Maan @tutorial T15
 * @author Navpreet Singh @tutorial T08
 * @created 2024-04-15
 * 
 */


import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import project.app.cpsc233project.Menu;
import project.app.cpsc233project.SignIn;

import java.net.URL;

/**
 * Controller for the Sign-In view of the application.
 * Manages the user input, sign-in process, and navigation within the sign-in scene.
 */
public class SignInController {

    @FXML
    private ComboBox<Menu.Floor> floorComboBox; // Dropdown for selecting the floor

    @FXML
    private ComboBox<Enum<?>> areaCombobox; // Dropdown for selecting the area on a floor

    @FXML
    private ComboBox ComputerUsage; // Dropdown to indicate if computer usage is required

    @FXML
    private TextField name; // TextField for user name input

    @FXML
    private TextField ucid; // TextField for user UCID input

    @FXML
    private Button submitB; // Button to submit the sign-in form

    @FXML
    private Label errorLabel; // Label to display error messages

    @FXML
    private Label floorVacancyLabel; // Label to display floor vacancy info

    @FXML
    private Label computerVacancyLabel; // Label to display computer vacancy info

    @FXML
    private MenuItem quit; // Menu item to quit the application

    @FXML
    private MenuItem about; // Menu item to show about information

    /**
     * Initializes the controller class.
     * This method is automatically called after the FXML file has been loaded.
     */
    @FXML
    public void initialize() {
        // Populate floorComboBox with floors and set up listeners for selection changes
        floorComboBox.setItems(FXCollections.observableArrayList(Menu.Floor.values()));
        ComputerUsage.setItems(FXCollections.observableArrayList("Yes", "No"));
        floorComboBox.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                // Update areaCombobox items based on selected floor
                switch (newVal) {
                    case GROUND_FLOOR:
                        areaCombobox.setItems(FXCollections.observableArrayList(Menu.Area_GROUND_FLOOR.values()));
                        break;
                    case SECOND_FLOOR:
                        areaCombobox.setItems(FXCollections.observableArrayList(Menu.Area_SECOND_FLOOR.values()));
                        break;
                    case THIRD_FLOOR:
                        areaCombobox.setItems(FXCollections.observableArrayList(Menu.Area_THIRD_FLOOR.values()));
                        break;
                }
            }
        });
        // Update labels to show current vacancy information
        updateVacancyLabels();
    }

    /**
     * Updates the labels to display the current vacancy information on floors and computers.
     */
    private void updateVacancyLabels() {
        // Retrieve vacancy information
        String floorVacancy = stats.show_vacancy("all floors");
        String computerVacancy = stats.show_vacancy("all comps");

        // Update labels on the JavaFX application thread
        Platform.runLater(() -> {
            floorVacancyLabel.setText(floorVacancy);
            computerVacancyLabel.setText(computerVacancy);
        });
    }

    /**
     * Handles the submit button action.
     * Validates and processes user input.
     * @param event the action event that triggered the method
     */
    @FXML
    private void handleSubmit(ActionEvent event) {
        // Clear previous error messages
        errorLabel.setText("");

        // Validate and collect input from the UI
        String floorComboBoxValue = String.valueOf(floorComboBox.getSelectionModel().getSelectedItem());
        String AreaComboBoxValue = String.valueOf(areaCombobox.getSelectionModel().getSelectedItem());
        String ComputerComboBoxValue = (String) ComputerUsage.getSelectionModel().getSelectedItem();
        String NametextFieldValue = name.getText();
        String UcidtextFieldValue = ucid.getText();

        // Validate UCID as numeric input
        if (!UcidtextFieldValue.matches("\\d+")) {
            showErrorDialog("UCID must contain only numbers.");
            return;
        }

        // Check for complete form submission
        if (floorComboBoxValue != null && AreaComboBoxValue != null && !NametextFieldValue.trim().isEmpty() && !UcidtextFieldValue.trim().isEmpty()) {
            try {
                // Convert UCID to integer
                int ucidNumber = Integer.parseInt(UcidtextFieldValue.trim());

                // Process the sign-in with validated data
                SignIn signin = new SignIn();
                signin.execute(NametextFieldValue, ucidNumber, stringToBoolean(ComputerComboBoxValue), floorComboBoxValue, AreaComboBoxValue);
                exitPage(); // Exit after successful sign-in
            } catch (NumberFormatException e) {
                showErrorDialog("UCID must be a valid number.");
            }
        } else {
            showErrorDialog("Please enter all data before submitting.");
        }
    }

    /**
     * Converts a string to a boolean based on user input.
     * @param str the string to convert
     * @return boolean value represented by the string
     * @throws IllegalArgumentException if the string does not represent a valid boolean
     */
    public static boolean stringToBoolean(String str) {
        if (str == null) {
            return false;
        }
        switch (str.trim().toLowerCase()) {
            case "yes":
                return true;
            case "no":
                return false;
            default:
                throw new IllegalArgumentException("Invalid input for boolean conversion: " + str);
        }
    }

    /**
     * Displays an error dialog with a specified message.
     * @param message the message to display in the error dialog
     */
    private void showErrorDialog(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    /**
     * Handles the successful sign-in by showing a confirmation dialog and then returning to the homepage.
     */
    private void exitPage() {
        Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
        infoAlert.setTitle("Sign In Successful");
        infoAlert.setHeaderText(null);
        infoAlert.setContentText("Sign In Was successful. Returning to the homepage.");
        infoAlert.showAndWait();

        returnToHomepage();
    }

    /**
     * Navigates back to the main homepage of the application.
     */
    @FXML
    private void returnToHomepage() {
        // Load and display the main application scene
        Platform.runLater(() -> {
            try {
                URL url = getClass().getResource("/project/app/cpsc233project/fxml/Main.fxml");
                FXMLLoader loader = new FXMLLoader(url);
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage stage = (Stage) name.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Displays an informational dialog about the application.
     */
    @FXML
    private void showAboutDialog() {
        Alert aboutDialog = new Alert(Alert.AlertType.INFORMATION);
        aboutDialog.setTitle("About");
        aboutDialog.setHeaderText("About TFDL Occupancy Tracker");
        aboutDialog.setContentText("TFDL Occupancy Tracker v1.0\nDeveloped by: Jaspinder Singh, Navpreet Singh & Yadwinder Singh\n© 2024 All rights reserved.\n For any inquires please reach us out \n@ JaspinderSingh.maan@ucalgary.ca");

        aboutDialog.showAndWait();
    }

    /**
     * Quits the application.
     */
    @FXML
    private void handleQuit() {
        Platform.exit();
    }
}
