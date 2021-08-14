package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import dbConnection.connectionClass;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class DAAController implements Initializable {

    @FXML
    private TableView<ModelTable> queryTable;
    @FXML
    private TableColumn<ModelTable,String> queryUSN;
    @FXML
    private TableColumn<ModelTable,String> queryCol;
    @FXML
    private Button back_button;


    ObservableList<ModelTable> oblist = FXCollections.observableArrayList();

    //    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)  {
        try{
            connectionClass connectionClass = new connectionClass();
            Connection con = connectionClass.getConnection();

            ResultSet rs = con.createStatement().executeQuery("select * from query where Subject = 'DAA'");

            while (rs.next()){
                oblist.add(new ModelTable(rs.getString("USN"),rs.getString("query")));
            }
        }
        catch (SQLException e){
            System.out.println(e);
        }


        queryUSN.setCellValueFactory(new PropertyValueFactory<>("usn"));
        queryCol.setCellValueFactory(new PropertyValueFactory<>("doubt"));

        queryTable.setItems(oblist);


    }
}
