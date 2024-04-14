package project.app.cpsc233project.app;
import project.app.cpsc233project.stats;




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

public class SignInController {

    @FXML
    private ComboBox<Menu.Floor> floorComboBox;

    @FXML
    private ComboBox<Enum<?>> areaCombobox;

    @FXML
    private ComboBox ComputerUsage;

    @FXML
    private TextField name;
    @FXML
    private TextField ucid;

    @FXML
    private Button submitB;

    @FXML
    private Label errorLabel;

    @FXML
    private Label floorVacancyLabel; // Label to display floor vacancy info

    @FXML
    private Label computerVacancyLabel; // Label to display computer vacancy info

    @FXML
    private MenuItem quit;

    @FXML
    private MenuItem about;






    @FXML
    public void initialize() {
        // Populate the ComboBox with enum values
        floorComboBox.setItems(FXCollections.observableArrayList(Menu.Floor.values()));
        ComputerUsage.setItems(FXCollections.observableArrayList("Yes", "No"));
        floorComboBox.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
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
        updateVacancyLabels();

    }

    private void updateVacancyLabels() {
        // Call stats methods to get the vacancy information
        String floorVacancy = stats.show_vacancy("all floors");
        String computerVacancy = stats.show_vacancy("all comps");

        // Update the labels on the JavaFX Application Thread
        Platform.runLater(() -> {
            floorVacancyLabel.setText(floorVacancy);
            computerVacancyLabel.setText(computerVacancy);
        });
    }


    @FXML
    private void handleSubmit(ActionEvent event) {
        // Clear previous error message
        errorLabel.setText("");

        // Validate the ComboBox selection
        String floorComboBoxValue = String.valueOf(floorComboBox.getSelectionModel().getSelectedItem());
        String AreaComboBoxValue = String.valueOf(areaCombobox.getSelectionModel().getSelectedItem());
        String ComputerComboBoxValue = (String) ComputerUsage.getSelectionModel().getSelectedItem();

        // Validate the TextField input
        String NametextFieldValue = name.getText();
        String UcidtextFieldValue = ucid.getText();

        // Check if UCID contains only digits
        if (!UcidtextFieldValue.matches("\\d+")) {
            showErrorDialog("UCID must contain only numbers.");
            return; // Stop processing since the UCID is not valid
        }

        // Check if both fields have been filled
        if (floorComboBoxValue != null && AreaComboBoxValue != null && !NametextFieldValue.trim().isEmpty() && !UcidtextFieldValue.trim().isEmpty()) {
            try {
                // Attempt to parse UCID as integer
                int ucidNumber = Integer.parseInt(UcidtextFieldValue.trim());

                // Data is valid, process the submission
                SignIn signin = new SignIn();
                signin.execute(NametextFieldValue, ucidNumber, stringToBoolean(ComputerComboBoxValue), floorComboBoxValue, AreaComboBoxValue);
                exitPage();
            } catch (NumberFormatException e) {
                showErrorDialog("UCID must be a valid number.");
            }
        } else {
            // Data is invalid, show error message
            showErrorDialog("Please enter all data before submitting.");
        }
    }



    public static boolean stringToBoolean(String str) {
        if (str == null) {
            return false; // or throw IllegalArgumentException if null is unexpected
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




    private void showErrorDialog(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void exitPage() {
        Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
        infoAlert.setTitle("Sign In Successful");
        infoAlert.setHeaderText(null);
        infoAlert.setContentText("Sign In Was successful. Returning to the homepage.");
        infoAlert.showAndWait();

        returnToHomepage();
    }

    @FXML
    private void returnToHomepage() {
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

    @FXML
    private void showAboutDialog() {
        Alert aboutDialog = new Alert(Alert.AlertType.INFORMATION);
        aboutDialog.setTitle("About");
        aboutDialog.setHeaderText("About TFDL Occupancy Tracker");
        aboutDialog.setContentText("TFDL Occupancy Tracker v1.0\nDeveloped by: Jaspinder Singh, Navpreet Singh & Yadwinder Singh\n© 2024 All rights reserved.\n For any inquires please reach us out \n@ JaspinderSingh.maan@ucalgary.ca");


        aboutDialog.showAndWait();
    }

    @FXML
    private void handleQuit() {
        Platform.exit();
    }



}
