package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.regex.Pattern;

public class goToTeacherHomeAll {
    @FXML
    Button back_button;

    @FXML
    public void goToTeacherHomeTable(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
            stage = (Stage) back_button.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("TeacherHome.fxml"));
            Scene scene = new Scene(root, 600, 400);
            stage.setScene(scene);
            stage.show();
    }

}