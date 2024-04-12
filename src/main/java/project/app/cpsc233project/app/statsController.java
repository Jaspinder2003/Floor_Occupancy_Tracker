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
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import project.app.cpsc233project.data;
import project.app.cpsc233project.stats;
import javafx.scene.chart.BarChart;


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
        statsChoice.setItems(FXCollections.observableArrayList("General Usage", "Busy floors"));
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
        Label displayUser = new Label(data.reader("/Users/yadi/Desktop/gp/cpsc-233-group-proeject-w24-master/ProjectDB.csv"));
        //System.out.println(data.reader("/Users/yadi/Desktop/gp/cpsc-233-group-proeject-w24-master/src/main/java/project/app/cpsc233project/ProjectDB.csv"));
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

            int floor1_occupants = stats.floor1_occupant_size();
            int floor2_occupants = stats.floor2_occupant_size();
            int floor3_occupants = stats.floor3_occupant_size();


            // Add data points
            series1.getData().add(new XYChart.Data<>("Floor 1", 87 - floor1_occupants));
            series1.getData().add(new XYChart.Data<>("Floor 2", 134 - floor2_occupants));
            series1.getData().add(new XYChart.Data<>("Floor 3", 200 - floor3_occupants));

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
        } else if (selected.equals("Busy floors")) {
            // Create a new stage (window) for the pop-up
            Stage popUpStage = new Stage();
            popUpStage.initModality(Modality.APPLICATION_MODAL);
            popUpStage.setTitle("Busy floors Clicked");

            // Set up the content of the pop-up
            VBox layout = new VBox(20);
            layout.setAlignment(Pos.CENTER);
            Label messageLabel = new Label("Busiest and the least busiesty floors.");

            double busy_percentage = stats.max_min("floors")[0];
            double least_percentage = stats.max_min("floors")[1];
            double busy = stats.max_min("floors")[2];
            double least = stats.max_min("floors")[3];

            String messageString = "";
            PieChart pieChart = new PieChart();

            if (busy_percentage == 0) {
                messageString = "Current all floors are empty!";
            } else {
                messageString = "Busiest floor: " + busy + "\nLeast busiest floor: " + least;


                double compUsers = stats.num_comp_user();

                // Create a PieChart and add some data
                pieChart.getData().add(new PieChart.Data("Computer users", compUsers));
                pieChart.getData().add(new PieChart.Data("Non-computer users", 25.0));
                pieChart.getData().add(new PieChart.Data("Empty computers", 45.0));

                // Optional: customize chart properties
                pieChart.setTitle("Computer Usage distribution");

                // Create a layout, add the chart to it
                BorderPane root = new BorderPane();
                root.setCenter(pieChart);
            }
            Label displayUser = new Label(messageString);

            Button closeButton = new Button("Close");
                closeButton.setOnAction(e -> popUpStage.close());

                // Add bar chart and other components to the layout
                layout.getChildren().addAll(messageLabel, displayUser, pieChart, closeButton);
                layout.setPadding(new Insets(10));

            // Displaying the pop-up window
            Scene scene = new Scene(layout, 400, 300);
            popUpStage.setScene(scene);
            popUpStage.showAndWait();
        }

    }
}