package project.app.cpsc233project.app;



import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import project.app.cpsc233project.Menu;

public class SignInController {

    @FXML
    private ComboBox<Menu.Floor> floorComboBox;

    @FXML
    private ComboBox<Enum<?>> areaCombobox;

    @FXML
    private ComboBox ComputerUsage;



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
}

