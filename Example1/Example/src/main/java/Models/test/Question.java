package Models.test;

import Models.Model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Question extends Model {

    @SerializedName("test")
    @Expose
    private Test test;

    @SerializedName("question")
    @Expose
    private String question;

    @SerializedName("time")
    @Expose
    private long time;

    public Question() {

    }

    public Question(Test test, String question, long time) {
        this.test = test;
        this.question = question;
        this.time = time;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
