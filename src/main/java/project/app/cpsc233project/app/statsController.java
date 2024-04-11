package project.app.cpsc233project.app;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class statsController {

    private Stage stage;
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private void SignInButton(ActionEvent event) {
        try {

            Parent signInParent = FXMLLoader.load(getClass().getResource("/project/app/cpsc233project/fxml/stats.fxml"));
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
            Parent signOutParent = FXMLLoader.load(getClass().getResource("/project/app/cpsc233project/fxml/stats.fxml"));
            Scene signOutScene = new Scene(signOutParent);

            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(signOutScene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception here
        }
    }





}