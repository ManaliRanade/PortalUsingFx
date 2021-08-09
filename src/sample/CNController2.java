package sample;

import dbConnection.connectionClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import sample.model.SampleModelTable;

import javax.swing.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class CNController2 implements Initializable {

    public static TableView<SampleModelTable> table_info;
    @FXML
    private TableView<SampleModelTable> queryTable;
    @FXML
    private TableColumn<SampleModelTable,String> queryUSN;
    @FXML
    private TableColumn<SampleModelTable,String> queryCol;
    @FXML
    private TableColumn<SampleModelTable,String> queryAns;
    @FXML
    private TableColumn<SampleModelTable,Button> update;
//    @FXML
//    private Button back_button;


    ObservableList<SampleModelTable> oblist = FXCollections.observableArrayList();

    //    @Override
    public  void initialize(URL url, ResourceBundle resourceBundle)  {

//        initTable();
        try{
            connectionClass connectionClass = new connectionClass();
            Connection con = connectionClass.getConnection();

            ResultSet rs = con.createStatement().executeQuery("select * from query where Subject = 'CN'");

            while (rs.next()){
                oblist.add(new SampleModelTable(rs.getString("USN"),rs.getString("query")));
            }
            for(int i=0; i<1; i++){
            oblist.add(new SampleModelTable(String.valueOf(i),"answers" + i,new Button("update")));
            }

        }
        catch (SQLException e){
            System.out.println(e);
        }


//
        queryUSN.setCellValueFactory(new PropertyValueFactory<>("usn"));
        queryCol.setCellValueFactory(new PropertyValueFactory<>("doubt"));


        queryTable.setItems(oblist);

        queryAns.setCellFactory(TextFieldTableCell.forTableColumn());

        queryAns.setOnEditCommit(e->{
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setAnswers(e.getNewValue());
        });

        queryTable.setEditable(true);

    }

//    private void initTable(){
//        initCols();
//    }
//    private void initCols(){
//        queryUSN.setCellValueFactory(new PropertyValueFactory<>("usn"));
//        queryCol.setCellValueFactory(new PropertyValueFactory<>("doubt"));
//        queryAns.setCellValueFactory(new PropertyValueFactory<>("answers"));
//        update.setCellValueFactory(new PropertyValueFactory<>("update"));

//        editableCols();
//    }
//    private void editableCols(){
//        queryAns.setCellFactory(TextFieldTableCell.forTableColumn());
//
//        queryAns.setOnEditCommit(e->{
//            e.getTableView().getItems().get(e.getTablePosition().getRow()).setAnswers(e.getNewValue());
//        });
//
//        queryTable.setEditable(true);
//    }

//    private void loadData(){
//
//    }

}
