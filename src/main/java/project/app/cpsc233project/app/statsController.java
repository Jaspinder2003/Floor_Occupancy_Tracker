package project.app.cpsc233project.app;

import java.net.URL;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
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

    @FXML
    private Button returnHome;

    private Stage stage;
    @SuppressWarnings("exports")
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void initialize() {
        // Populate the ComboBox items
        statsChoice.setItems(FXCollections.observableArrayList("General Usage and Busy Floors", "Computer Usage Distribution"));
    }

    private String message = data.reader("/Users/yadi/Desktop/cpsc-233-group-proeject-w24-master/ProjectDB.csv");

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
        Label displayUser = new Label(message);
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

        if (selected.equals("General Usage and Busy Floors")) {
            // Create axes for the bar chart
            CategoryAxis xAxis = new CategoryAxis();
            xAxis.setLabel("Floors");

            NumberAxis yAxis = new NumberAxis();
            yAxis.setLabel("No. of Seats");

            // Create the bar chart
            BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
            String message = "TFDL Floor Vacancy Bar Chart";

            // Add data to the bar chart
            XYChart.Series<String, Number> series1 = new XYChart.Series<>();
            series1.setName("Vacancy"); // Name the series

            // Add data points
            series1.getData().add(new XYChart.Data<>("Floor 1\n" + data.floor_vacancy.get(1), data.floor_vacancy.get(1)));
            series1.getData().add(new XYChart.Data<>("Floor 2\n" + data.floor_vacancy.get(2), data.floor_vacancy.get(2)));
            series1.getData().add(new XYChart.Data<>("Floor 3\n" + data.floor_vacancy.get(3), data.floor_vacancy.get(3)));

            barChart.getData().add(series1);

            double busy_percentage = stats.max_min("floors")[0];
            double busy = stats.max_min("floors")[2];
            double least = stats.max_min("floors")[3];

            if (busy_percentage == 0) {
                message += "\n\nCurrent all floors are empty!";
            } else {
                message += "\n\nBusiest floor: " + busy + "\nLeast busiest floor: " + least;
            }

            barChart.setTitle(message);

            // Create a new stage (window) for the pop-up
            Stage popUpStage = new Stage();
            popUpStage.initModality(Modality.APPLICATION_MODAL);
            popUpStage.setTitle("Busy Button Clicked");

            // Set up the content of the pop-up
            VBox layout = new VBox(20);
            layout.setAlignment(Pos.CENTER);
            Label messageLabel = new Label("Per floor data of TFDL");
            Button closeButton = new Button("Close");
            closeButton.setOnAction(e -> popUpStage.close());

            // Add bar chart and other components to the layout
            layout.getChildren().addAll(messageLabel, barChart, closeButton);
            layout.setPadding(new Insets(10));

            // Displaying the pop-up window
            Scene scene = new Scene(layout, 400, 500);
            popUpStage.setScene(scene);
            popUpStage.showAndWait();
        } else if (selected.equals("Computer Usage Distribution")) {
            // Create a new stage (window) for the pop-up
            Stage popUpStage = new Stage();
            popUpStage.initModality(Modality.APPLICATION_MODAL);
            popUpStage.setTitle("Computer Usage Distribution");

            // Set up the content of the pop-up
            VBox layout = new VBox(20);
            layout.setAlignment(Pos.CENTER);
            Label messageLabel = new Label("Computer usage distribution in TFDL.");

            double busy_percentage = stats.max_min("floors")[0];
            double busy = stats.max_min("floors")[2];
            double least = stats.max_min("floors")[3];

            String messageString = "";
            PieChart pieChart = new PieChart();

            if (busy_percentage == 0) {
                messageString = "Current all floors are empty!";
            } else {
                messageString = "Busiest floor: " + busy + "\nLeast busiest floor: " + least;

                double compUsers = 165 - (data.computer_vacancy.get(1) + data.computer_vacancy.get(2) + data.computer_vacancy.get(3));
                double compUsers_percent = (compUsers/165) * 100;
                double non_compUsers = (421 - (data.floor_vacancy.get(1) + data.floor_vacancy.get(2) + data.floor_vacancy.get(3))) - compUsers;
                double non_compUsers_percent = (non_compUsers/165)*100;

                // Create a PieChart and add some data
                pieChart.getData().add(new PieChart.Data("Computer users", compUsers_percent));
                pieChart.getData().add(new PieChart.Data("Non-computer users", non_compUsers_percent));
                pieChart.getData().add(new PieChart.Data("Empty computers", (100 - (compUsers + non_compUsers_percent))));

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

    public void returnToHomepage() {
        Platform.runLater(() -> {
            try {
                URL url = getClass().getResource("/project/app/cpsc233project/fxml/Main.fxml");
                FXMLLoader loader = new FXMLLoader(url);
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage stage = (Stage) statsChoice.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}