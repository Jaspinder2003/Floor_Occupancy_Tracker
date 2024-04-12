package project.app.cpsc233project.app;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    @FXML
    private Button welcomePageSignOut;

    @FXML
    private Button welcomePageSignIn;

    private Stage stage;
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
}