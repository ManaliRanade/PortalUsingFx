package sample;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Query {

//    public IntegerProperty semProperty;
    public StringProperty nameProperty;
//    public StringProperty subjectProperty;
    public StringProperty queryProperty;

    public Query(){
//        this.semProperty = new SimpleIntegerProperty();
        this.nameProperty = new SimpleStringProperty();
//        this.subjectProperty = new SimpleStringProperty();
        this.queryProperty = new SimpleStringProperty();
    }
//
//    public int getStudentSem(){
//        return semProperty.get();
//    }
//
//    public void setStudentSem(int sem){
//        this.semProperty.set(sem);
//    }
//
//    public IntegerProperty getSem(){
//        return semProperty;
//    }


    public String getStudentName(){
        return nameProperty.get();
    }

    public void setStudentName(String name){
        this.nameProperty.set(name);
    }

    public StringProperty getName(){
        return nameProperty;
    }

    public String getStudentQuery(){
        return queryProperty.get();
    }

    public void setStudentQuery(String query){
        this.queryProperty.set(query);
    }

    public StringProperty getQuery(){
        return queryProperty;
    }


}
