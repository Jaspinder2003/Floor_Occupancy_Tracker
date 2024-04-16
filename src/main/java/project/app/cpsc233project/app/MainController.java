package project.app.cpsc233project.app;

/**
 * 
 * @author Yadwinder Singh Dhaliwal @tutorial T05
 * @author Jaspinder Singh Maan @tutorial T15
 * @author Navpreet Singh @tutorial T08
 * @created 2024-04-15
 * 
 */


// Import necessary JavaFX and Java classes
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import project.app.cpsc233project.data;

import java.io.File;
import java.io.IOException;

// Import a static method from the data class
import static project.app.cpsc233project.data.reader;

/**
 * Controller class for the main application window.
 * Handles user interactions with the GUI and manages transitions between different scenes.
 */
public class MainController {
    // FXML injected components
    @FXML
    private VBox mainContainer;

    @FXML
    private VBox contentBox;

    @FXML
    private Button welcomePageSignOut;

    @FXML
    private Button welcomePageSignIn;

    @FXML
    private MenuItem open;

    private Stage stage; // Stage variable to keep track of the application window

    @FXML
    private Pane splitBackgroundPane;

    @FXML
    private AnchorPane welcomePage; // This field corresponds to an AnchorPane in the FXML file

    @FXML
    private ImageView backgroundImage;

    @FXML
    private MenuItem quit;

    @FXML
    private MenuItem about;

    /**
     * Sets the main stage of the application.
     * @param stage the primary stage of the application
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    /**
     * Handles the action for the sign-in button click.
     * Loads and displays the sign-in scene.
     * @param event the event triggered by clicking the sign-in button
     */
    @FXML
    private void SignInButton(ActionEvent event) {
        try {
            Parent signInParent = FXMLLoader.load(getClass().getResource("/project/app/cpsc233project/fxml/SignIn.fxml"));
            Scene signInScene = new Scene(signInParent);

            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(signInScene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace(); // Print stack trace in case of IOException
        }
    }

    /**
     * Handles the action for the sign-out button click.
     * Loads and displays the sign-out scene.
     * @param event the event triggered by clicking the sign-out button
     */
    @FXML
    private void SignOutButton(ActionEvent event) {
        try {
            Parent signOutParent = FXMLLoader.load(getClass().getResource("/project/app/cpsc233project/fxml/SignOut.fxml"));
            Scene signOutScene = new Scene(signOutParent);

            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(signOutScene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace(); // Print stack trace in case of IOException
        }
    }

    /**
     * Handles the action for the statistics button click.
     * Loads and displays the statistics scene.
     * @param event the event triggered by clicking the statistics button
     */
    @FXML
    private void statsButton(ActionEvent event) {
        try {
            Parent statsParent = FXMLLoader.load(getClass().getResource("/project/app/cpsc233project/fxml/stats.fxml"));
            Scene statsScene = new Scene(statsParent);

            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(statsScene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace(); // Print stack trace in case of IOException
        }
    }

    /**
     * Handles the action to open a file through the menu.
     * Opens a FileChooser to select and read a CSV file, displaying its contents in a non-editable text area.
     * @param event the event triggered by selecting 'Open' from the menu
     */
    @FXML
    private void MenuOpen(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open CSV File"); // Set the title of the FileChooser window
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("CSV Files", "*.csv"),
                new FileChooser.ExtensionFilter("All Files", "*.*"));
        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            String fileContent = reader(selectedFile.getAbsolutePath());
            TextArea textArea = new TextArea(fileContent);
            textArea.setEditable(false);
            textArea.setWrapText(true);

            Stage stage = new Stage(); // Create a new stage for displaying the file content
            stage.setTitle("CSV File Content");
            Scene scene = new Scene(textArea, 645, 600);
            stage.setScene(scene);
            stage.show();
        } 
    }

    /**
     * Displays an about dialog containing application information.
     */
    @FXML
    private void showAboutDialog() {
        Alert aboutDialog = new Alert(Alert.AlertType.INFORMATION);
        aboutDialog.setTitle("About");
        aboutDialog.setHeaderText("About TFDL Occupancy Tracker");
        aboutDialog.setContentText("TFDL Occupancy Tracker v1.0\nDeveloped by: Jaspinder Singh, Navpreet Singh & Yadwinder Singh\n© 2024 All rights reserved.\n For any inquires please reach us \nout @ JaspinderSingh.maan@ucalgary.ca");


        aboutDialog.showAndWait();
    }

    /**
     * Handles the action to quit the application from the menu.
     */
    @FXML
    private void handleQuit() {
        Platform.exit();
    }

}
