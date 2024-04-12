package project.app.cpsc233project.app;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import project.app.cpsc233project.data;

import java.io.File;
import java.io.IOException;

import static project.app.cpsc233project.data.reader;

public class MainController {
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

    private Stage stage;

    @FXML
    private Pane splitBackgroundPane;

    @FXML
    private AnchorPane welcomePage; // This field name should match the fx:id in FXML

    @FXML
    private ImageView imageView;



    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private void SignInButton(ActionEvent event) {
        try {

            Parent signInParent = FXMLLoader.load(getClass().getResource("/project/app/cpsc233project/fxml/SignIn.fxml"));
            Scene signInScene = new Scene(signInParent);

            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(signInScene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception here (maybe show an error dialog)
        }
    }

    @FXML
    private void SignOutButton(ActionEvent event) {
        try {
            Parent signOutParent = FXMLLoader.load(getClass().getResource("/project/app/cpsc233project/fxml/SignOut.fxml"));
            Scene signOutScene = new Scene(signOutParent);

            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(signOutScene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception here
        }
    }

    @FXML
    private void statsButton(ActionEvent event) {
        try {
            Parent statsParent = FXMLLoader.load(getClass().getResource("/project/app/cpsc233project/fxml/stats.fxml"));
            Scene statsScene = new Scene(statsParent);

            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(statsScene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception here
        }
    }

    @FXML
    private void MenuOpen(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open CSV File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("CSV Files", "*.csv"),
                new FileChooser.ExtensionFilter("All Files", "*.*"));
        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            // Read the content of the file

            String fileContent = reader(selectedFile.getAbsolutePath());

            // Create and display the content in a TextArea within an Alert or a new Stage
            TextArea textArea = new TextArea(fileContent);
            textArea.setEditable(false); // Make it read-only
            textArea.setWrapText(true);

            Stage stage = new Stage(); // Create a new stage for the popup
            stage.setTitle("CSV File Content");

            // Create a scene with the text area and set it on the stage
            Scene scene = new Scene(textArea, 600, 400);
            stage.setScene(scene);
            stage.show();
        } else {
            // No file was selected, handle this case if needed
        }
    }

}