package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    @FXML
    private Button student_login_button,teacher_login_button;

    @FXML
    private void showHome(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        if (event.getSource() == student_login_button) {
            stage = (Stage) student_login_button.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("StudentHome.fxml"));
        } else {
            stage = (Stage) teacher_login_button.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("TeacherHome.fxml"));
        }

        Scene scene = new Scene(root, 600, 275);
        stage.setScene(scene);
        stage.show();
    }
}
