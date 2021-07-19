package sample;


import dbConnection.connectionClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;



public class Controller {

    @FXML
    private Button student_login_button,teacher_login_button,register_query_button,view_doubts_button,submit_query_button;
    @FXML
    private TextField USN_textbox, course_name;
    @FXML
    private TextArea query_detail;
//    @FXML
//    private ComboBox course_name_list;


    @FXML
    private void showHome(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        if (event.getSource() == student_login_button) {
            stage = (Stage) student_login_button.getScene().getWindow();
//            root = FXMLLoader.load(getClass().getResource("StudentHome.fxml"));
            root = FXMLLoader.load(getClass().getResource("StudentHome.fxml"));
        } else {
            stage = (Stage) teacher_login_button.getScene().getWindow();
//            root = FXMLLoader.load(getClass().getResource("TeacherHome.fxml"));
            root = FXMLLoader.load(getClass().getResource("TeacherHome.fxml"));
        }

        Scene scene = new Scene(root, 600, 275);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void goToRegister(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        if (event.getSource() == register_query_button) {
            stage = (Stage) register_query_button.getScene().getWindow();
//            root = FXMLLoader.load(getClass().getResource("StudentHome.fxml"));
            root = FXMLLoader.load(getClass().getResource("StudentDoubtView.fxml"));
        }
        else {
            stage = (Stage) view_doubts_button.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("QueryDisplay.fxml"));
        }

        Scene scene = new Scene(root, 800, 400);
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
//        statement.executeUpdate(sql);
            String sql2 = "INSERT INTO `query` (`USN`, `query`,`Subject`) VALUES ('"+usn+"','"+doubt+"','"+course+"')";
            statement.executeUpdate(sql2);

            stage = (Stage) submit_query_button.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("StudentHome.fxml"));
            Scene scene = new Scene(root, 800, 400);
            stage.setScene(scene);
            stage.show();
        }

    }





//    public static ObservableList<Query> getAllRecords() throws ClassNotFoundException,SQLException {
//        String dbName = "Students";
//        String userName = "root";
//        String password = "";
//        String dburl = "jdbc:mysql://localhost:3306/Students?useSSL=false";
//        String sqlq = "select * from users";
//        try{
//
//        }
//        catch (SQLException e){
//            System.out.println("sql Error Occurred");
//            e.printStackTrace();
////            throw e;
////        }
//    }


}
