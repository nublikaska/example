package Models.test.shared;

import Models.Model;
import Models.test.Question;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Answer extends Model {

    @SerializedName("sharedTest")
    @Expose
    private SharedTest sharedTest;

    @SerializedName("question")
    @Expose
    private Question question;

    @SerializedName("answer")
    @Expose
    private String answer;

    public Answer() {

    }

    public Answer(SharedTest sharedTest, Question question, String answer) {
        this.sharedTest = sharedTest;
        this.question = question;
        this.answer = answer;
    }

    public SharedTest getSharedTest() {
        return sharedTest;
    }

    public void setSharedTest(SharedTest sharedTest) {
        this.sharedTest = sharedTest;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
