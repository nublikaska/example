import Models.Career;
import Models.Company;
import Models.Credential;
import Models.test.Test;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.util.List;

public interface ServiceApi {
    //company
    @POST("company/{loginCompany}")
    Call<Company> getCompany(@Path("loginCompany") String title, @Body Credential credential);

    @POST("company")
    Call<Company> addCompany(@Body Company company);

    //career
    @POST("company/{loginCompany}/career")
    Call<Career> addCareer(@Path("loginCompany") String loginCompany, @Body Career career);

    @GET("company/{loginCompany}/career")
    Call<List<Career>> getAllCareerByCompany(@Path("loginCompany") String loginCompany);

    //test
    @POST("company/{loginCompany}/career/{id}/test")
    Call<Test> addTest(@Path("loginCompany") String loginCompany, @Path("id") Long id, @Body Test test);

    @GET("company/{title}/career/{id}/test")
    Call<List<Test>> getAllTestByCareer(@Path("id") Long id);
}
