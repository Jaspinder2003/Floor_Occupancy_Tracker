package project.app.cpsc233project.app;



import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import project.app.cpsc233project.Menu;
import project.app.cpsc233project.SignIn;

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

        // Check if both fields have been filled
        if (floorComboBoxValue != null && AreaComboBoxValue != null && !NametextFieldValue.trim().isEmpty() && !UcidtextFieldValue.trim().isEmpty()) {
            // Data is valid, process the submission
            SignIn signin = new SignIn();

            signin.execute(NametextFieldValue, Integer.parseInt(UcidtextFieldValue), stringToBoolean(ComputerComboBoxValue), floorComboBoxValue, AreaComboBoxValue);
            errorLabel.setVisible(true);

        } else {
            // Data is invalid, show error message
            showErrorDialog("Please enter all data before submitting.");

            // Alternatively, you could set an error message in a label on the screen
            errorLabel.setText("Please fill in all fields.");
            errorLabel.setVisible(true);
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



}


