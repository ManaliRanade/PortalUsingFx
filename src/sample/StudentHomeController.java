package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class StudentHomeController {

    @FXML
    private Button register_query_button,view_query_button;

    @FXML
    private void showStudentDoubt(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        if (event.getSource() == register_query_button) {
            stage = (Stage) register_query_button.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("StudentDoubtView.fxml"));
        } else {
            stage = (Stage) view_query_button.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("TeacherHome.fxml"));
        }

        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.show();
    }
}
