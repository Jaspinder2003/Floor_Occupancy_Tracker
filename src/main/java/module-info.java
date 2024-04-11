module project.app.cpsc233project {
    requires javafx.controls;
    requires javafx.fxml;


    opens project.app.cpsc233project to javafx.fxml;
    exports project.app.cpsc233project;
}