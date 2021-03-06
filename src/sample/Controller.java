package sample;


import dbConnection.connectionClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Pattern;


public class Controller {


    @FXML
    private Button register_query_button,view_doubts_button,submit_query_button,enter_student,enter_teacher,OOPS_button,logout_button, teacher_login_button, student_login_button;
    @FXML
    private TextField USN_textbox, course_name, Username_textbox, TUsername_textbox;
    @FXML
    private TextArea query_detail;
    @FXML
    Label invalid=new Label("Incorrect credentials");


    @FXML
    private void goToStudentLogin(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) student_login_button.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("StudentLoginPage.fxml"));
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void goToTeacherLogin(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) teacher_login_button.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("TeacherLoginPage.fxml"));
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void goToTeacherHome(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        if(Pattern.matches(".*@rvce[.]edu[.]in",TUsername_textbox.getText())){
            stage = (Stage) enter_teacher.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("TeacherHome.fxml"));
            invalid.setVisible(false);
            Scene scene = new Scene(root, 600, 400);
            stage.setScene(scene);
            stage.show();
        }
        else{
            System.out.println("Invalid username");
            stage=(Stage) enter_teacher.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("TeacherLoginPage.fxml"));
            invalid.setVisible(true);
            root.getChildrenUnmodifiable().add(invalid);
            Scene scene = new Scene(root, 600, 400);
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    private void goToStudentHome(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        if(Pattern.matches("1RV[0-9]{2}[A-Z]{2}[0-9]{3}",Username_textbox.getText())){
            stage = (Stage) enter_student.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("StudentHome.fxml"));
            invalid.setVisible(false);
            Scene scene = new Scene(root, 600, 400);
            stage.setScene(scene);
            stage.show();
        }
        else{
            //System.out.println("Invalid username");
            stage=(Stage) enter_student.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("StudentLoginPage.fxml"));
            invalid.setVisible(true);
            root.getChildrenUnmodifiable().add(invalid);
            Scene scene = new Scene(root, 600, 400);
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    private void goToRegister(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        if (event.getSource() == register_query_button) {
            stage = (Stage) register_query_button.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("StudentDoubtView.fxml"));
        }
        else {
            stage = (Stage) view_doubts_button.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("StudentQueryDisplay.fxml"));
        }

        Scene scene = new Scene(root, 800, 400);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void goToOOPSDoubtsTeacher(ActionEvent event) throws IOException,SQLException {
        Stage stage;
        Parent root;

        stage = (Stage) OOPS_button.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("OOPSQueryDisplay.fxml"));

        Scene scene = new Scene(root, 800, 400);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void goToDAADoubtsTeacher(ActionEvent event) throws IOException,SQLException {
        Stage stage;
        Parent root;

        stage = (Stage) OOPS_button.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("DAAQueryDisplay.fxml"));

        Scene scene = new Scene(root, 800, 400);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void goToMCESDoubtsTeacher(ActionEvent event) throws IOException,SQLException {
        Stage stage;
        Parent root;

        stage = (Stage) OOPS_button.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("MCESQueryDisplay.fxml"));

        Scene scene = new Scene(root, 800, 400);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void goToCNDoubtsTeacher(ActionEvent event) throws IOException,SQLException {
        Stage stage;
        Parent root;

        stage = (Stage) OOPS_button.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("CNQueryDisplay.fxml"));

        Scene scene = new Scene(root, 800, 400);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void logout(ActionEvent event) throws IOException{
        Stage stage;
        Parent root;
        stage = (Stage) logout_button.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("LoginFirst.fxml"));
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void saveData(ActionEvent event) throws SQLException, IOException {

        Stage stage;
        Parent root;
        if (event.getSource() == submit_query_button) {
            System.out.println(USN_textbox.getText());
            System.out.println(query_detail.getText());
            System.out.println(course_name.getText());

            String usn = USN_textbox.getText().toString();
            String doubt = query_detail.getText().toString();
            String course = course_name.getText().toString();

            connectionClass connectionClass = new connectionClass();
            Connection connection = connectionClass.getConnection();

            Statement statement = connection.createStatement();
            String sql2 = "INSERT INTO `query` (`USN`, `query`,`Subject`) VALUES ('"+usn+"','"+doubt+"','"+course+"')";
            statement.executeUpdate(sql2);

            stage = (Stage) submit_query_button.getScene().getWindow();
            try {
                 root = FXMLLoader.load(getClass().getResource("StudentHome.fxml"));
                Scene scene = new Scene(root, 600, 400);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
