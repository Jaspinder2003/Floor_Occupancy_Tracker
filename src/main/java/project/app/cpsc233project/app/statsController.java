package project.app.cpsc233project.app;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import project.app.cpsc233project.data;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;


public class statsController {

    @FXML
    private ComboBox<String> statsChoice;

    @FXML
    private Button busyButton;

    @FXML
    private Button generalUsage;

    @FXML
    private Button userList;

    private Stage stage;
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void initialize() {
        // Populate the ComboBox items
        statsChoice.setItems(FXCollections.observableArrayList("General Usage", "Busiest floor", "Least busiest floor", "Computer Usage"));
    }

    @FXML
    private void userListButton() {
        // Create a new stage (window) for the pop-up
        Stage popUpStage = new Stage();
        popUpStage.initModality(Modality.APPLICATION_MODAL);
        popUpStage.setTitle("Busy Button Clicked");

        // Set up the content of the pop-up
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        Label messageLabel = new Label("Choose an option to view list of users.");
        Label displayUser = new Label(data.reader("/Users/yadi/Desktop/UCalgary/1Y2S/CPSC-233/GroupProject/cpsc-233-group-proeject-w24/src/main/java/project/app/cpsc233project/ProjectDB.csv"));
        System.out.println(data.reader("/Users/yadi/Desktop/UCalgary/1Y2S/CPSC-233/GroupProject/cpsc-233-group-proeject-w24/src/main/java/project/app/cpsc233project/ProjectDB.csv"));
        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> popUpStage.close());

        // Add bar chart and other components to the layout
        layout.getChildren().addAll(messageLabel, displayUser, closeButton);
        layout.setPadding(new Insets(10));

        // Displaying the pop-up window
        Scene scene = new Scene(layout, 400, 300);
        popUpStage.setScene(scene);
        popUpStage.showAndWait();
    }

    @FXML
    private void statsChoice() {
        String selected = statsChoice.getSelectionModel().getSelectedItem();

        if (selected.equals("General Usage")) {
            // Create axes for the bar chart
            CategoryAxis xAxis = new CategoryAxis();
            xAxis.setLabel("Floors");

            NumberAxis yAxis = new NumberAxis();
            yAxis.setLabel("No. of Seats");

            // Create the bar chart
            BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
            barChart.setTitle("TFDL Floor Vacancy Bar Chart");

            // Add data to the bar chart
            XYChart.Series<String, Number> series1 = new XYChart.Series<>();
            series1.setName("Vacancy"); // Name the series
            // Add data points
            series1.getData().add(new XYChart.Data<>("Floor 1", data.floor_vacancy.get(1)));
            series1.getData().add(new XYChart.Data<>("Floor 2", data.floor_vacancy.get(2)));
            series1.getData().add(new XYChart.Data<>("Floor 3", data.floor_vacancy.get(3)));

            barChart.getData().add(series1);

            // Create a new stage (window) for the pop-up
            Stage popUpStage = new Stage();
            popUpStage.initModality(Modality.APPLICATION_MODAL);
            popUpStage.setTitle("Busy Button Clicked");

            // Set up the content of the pop-up
            VBox layout = new VBox(20);
            layout.setAlignment(Pos.CENTER);
            Label messageLabel = new Label("The Busy Button has been clicked!");
            Button closeButton = new Button("Close");
            closeButton.setOnAction(e -> popUpStage.close());

            // Add bar chart and other components to the layout
            layout.getChildren().addAll(messageLabel, barChart, closeButton);
            layout.setPadding(new Insets(10));

            // Displaying the pop-up window
            Scene scene = new Scene(layout, 300, 300);
            popUpStage.setScene(scene);
            popUpStage.showAndWait();
        }

    }

 
}