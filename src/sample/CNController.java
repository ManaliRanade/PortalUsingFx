package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import dbConnection.connectionClass;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
//import sample.model.SampleModelTable;

public class CNController implements Initializable {

    @FXML
    private TableView<ModelTable> queryTable;
    @FXML
    private TableColumn<ModelTable,String> queryUSN;
    @FXML
    private TableColumn<ModelTable,String> queryCol;
    @FXML
    private TableColumn<ModelTable,String> queryAns;
    @FXML
    private TableColumn<ModelTable,Button> save;
    @FXML
    private Button back_button_cn;

//    public void answerEvent() throws SQLException {
//            String answer = queryAns.getText();
//
//            connectionClass connectionClass = new connectionClass();
//            Connection connection = connectionClass.getConnection();
//            Statement statement = connection.createStatement();
//            String sql2 = "INSERT INTO `answer` (Answer) VALUES ('" + answer + "')";
//            statement.executeUpdate(sql2);
//
//
//
//    }

//    private void loadData() throws SQLException{
//        connectionClass connectionClass = new connectionClass();
//            Connection connection = connectionClass.getConnection();
//            Statement statement = connection.createStatement();
//        queryAns.setCellValueFactory(new PropertyValueFactory<>("answers"));
//    }

    public void updateData() {
        String answer = queryAns.getText();
        try{
            connectionClass connectionClass = new connectionClass();
            Connection connection = connectionClass.getConnection();
            Statement statement = connection.createStatement();
            String sql2 = "INSERT INTO `answer` (Answer) VALUES ('" + answer + "')";
            statement.executeUpdate(sql2);
        }
        catch (SQLException e){
            System.out.println(e);
        }

    }


    ObservableList<ModelTable> oblist = FXCollections.observableArrayList();

    //    @Override
    public  void initialize(URL url, ResourceBundle resourceBundle)  {


        try{
            connectionClass connectionClass = new connectionClass();
            Connection con = connectionClass.getConnection();

            ResultSet rs = con.createStatement().executeQuery("select * from query where Subject = 'CN'");

            while (rs.next()){
                oblist.add(new ModelTable(rs.getString("USN"),rs.getString("query")));
            }
        }
        catch (SQLException e){
            System.out.println(e);
        }



        queryUSN.setCellValueFactory(new PropertyValueFactory<>("usn"));
        queryCol.setCellValueFactory(new PropertyValueFactory<>("doubt"));
//        queryAns.setCellValueFactory(new PropertyValueFactory<>("answers"));

        queryTable.setItems(oblist);
        queryAns.setCellFactory(TextFieldTableCell.forTableColumn());

//        queryAns.setOnEditCommit(e->{
//            e.getTableView().getItems().get(e.getTablePosition().getRow()).setAnswers(e.getNewValue());
//        });

        queryAns.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<ModelTable, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<ModelTable, String> modelTableStringCellEditEvent) {
//                ModelTable mt = modelTableStringCellEditEvent.getRowValue();
//                mt.setAnswers(modelTableStringCellEditEvent.getNewValue());
                updateData();
            }
        });

        queryTable.setEditable(true);

//        loadData();

        back_button_cn.setOnAction((event) -> {
            final Stage stage = (Stage) back_button_cn.getScene().getWindow();
            try {
                Parent root = FXMLLoader.load(getClass().getResource("TeacherHome.fxml"));
                Scene scene = new Scene(root, 800, 400);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });



    }


}
