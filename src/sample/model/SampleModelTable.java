package sample.model;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import sample.CNController2;
import sample.Controller;
import sample.CNController;

import java.awt.*;

public class SampleModelTable {
    String usn,doubt,answers;
    Button update;

    public SampleModelTable(String usn, String doubt, String answers, Button update) {
        this.usn = usn;
        this.doubt = doubt;
        this.answers = answers;
        this.update = update;
        update.setOnAction(e -> {
            ObservableList<SampleModelTable> samp = CNController2.table_info.getSelectionModel().getSelectedItems();

            for (SampleModelTable sam:samp ) {
                if(sam.getUpdate() == update){
                    System.out.println("Answer: " +sam.getAnswers());
                }
            }


        });
    }

    public SampleModelTable(String usn, String query) {
    }

    public SampleModelTable(String valueOf, String answers, Button update) {
    }

    public String getUsn() {
        return usn;
    }

    public void setUsn(String usn) {
        this.usn = usn;
    }

    public String getDoubt() {
        return doubt;
    }

    public void setDoubt(String doubt) {
        this.doubt = doubt;
    }

    public String getAnswers() {
        return answers;
    }

    public void setAnswers(String answers) {
        this.answers = answers;
    }

    public Button getUpdate() {
        return update;
    }

    public void setUpdate(Button update) {
        this.update = update;
    }
}
