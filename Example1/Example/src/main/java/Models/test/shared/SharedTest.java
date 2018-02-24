package Models.test.shared;

import Models.Model;
import Models.test.Test;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class SharedTest extends Model {

    @SerializedName("test")
    @Expose
    private Test test;

    @SerializedName("shared")
    @Expose
    private boolean shared;

    public SharedTest() {

    }

    public SharedTest(Test test, boolean shared) {
        this.test = test;
        this.shared = shared;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public boolean isShared() {
        return shared;
    }

    public void setShared(boolean passed) {
        this.shared = passed;
    }
}
