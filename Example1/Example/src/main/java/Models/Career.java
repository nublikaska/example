package Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Career extends Model{

    @SerializedName("company")
    @Expose
    private Company company;

    @SerializedName("title")
    @Expose
    private String title;

    public Career() {

    }

    public Career(Company company, String title) {
        this.company = company;
        this.title = title;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
