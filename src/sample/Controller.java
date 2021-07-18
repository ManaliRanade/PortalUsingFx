package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import javax.management.Query;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Controller {
    /*
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("LoginFirst.fxml"));

        Scene scene = new Scene(root, 300, 275);

        stage.setTitle("FXML Welcome");
        stage.setScene(scene);
        stage.show();
    }
     */


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
