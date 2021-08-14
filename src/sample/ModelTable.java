package sample;

public class ModelTable {
    String usn,doubt;
    String answers;

    public ModelTable(String usn,String doubt){
        this.usn = usn;
        this.doubt = doubt;
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

    public void setAnswers(String answers) {

        this.answers = answers;
    }

    public String getAnswers() {
        return answers;
    }
}
