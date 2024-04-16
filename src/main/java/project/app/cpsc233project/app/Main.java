package project.app.cpsc233project.app;

/**
 * 
 * @author Yadwinder Singh Dhaliwal @tutorial T05
 * @author Jaspinder Singh Maan @tutorial T15
 * @author Navpreet Singh @tutorial T08
 * @created 2024-04-15
 * 
 */


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import project.app.cpsc233project.data;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/project/app/cpsc233project/fxml/Main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640,600);
        stage.setTitle("TFDL Occupency Tracker!");
        MainController controller = fxmlLoader.getController();
        controller.setStage(stage);
        stage.setScene(scene);
        stage.show();
    }

    @SuppressWarnings("unused")
    private String message = data.reader("ProjectDB.csv");


    public static void main(String[] args) {
        launch();
    }
    
}