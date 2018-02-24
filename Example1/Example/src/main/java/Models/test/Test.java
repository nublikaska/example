package Models.test;

import Models.Career;
import Models.Model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Test extends Model {

    @SerializedName("career")
    @Expose
    private Career career;

    @SerializedName("title")
    @Expose
    private String title;

    public Test() {

    }

    public Test(Career career, String title) {
        this.career = career;
        this.title = title;
    }

    public Career getCareer() {
        return career;
    }

    public void setCareer(Career career) {
        this.career = career;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
