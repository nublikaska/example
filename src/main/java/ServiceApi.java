import Models.Career;
import Models.Company;
import Models.Credential;
import Models.test.Question;
import Models.test.Test;
import Models.test.shared.SharedTest;
import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;
import javax.ws.rs.core.Response;

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
    Call<Test> addTest(@Path("id") Long id, @Body Test test);

    @GET("company/{loginCompany}/career/{idCareer}/test")
    Call<List<Test>> getAllTestByCareer(@Path("idCareer") Long id);

    //question
    @POST("company/{title}/career/{careerId}/test/{testId}/questions")
    Call<Question> addQuestion(@Path("testId") Long testId, @Body Question question);

    @GET("company/{title}/career/{careerId}/test/{testId}/questions")
    Call<List<Question>> getAllQuestionByTestId(@Path("testId") Long testId);

    @DELETE("company/{title}/career/{careerId}/test/{testId}/questions")
    Call<ResponseBody> deleteQuestion(@Body Long questionId);

    //SharedTest
    @POST("company/{title}/career/{id}/test/{testId}/shared/")
    Call<SharedTest> addSharedTest(@Path("testId") Long testId, @Body SharedTest sharedTest);

    @POST("company/{title}/career/{id}/test/{testId}/shared/")
    Call<List<SharedTest>> getAllShareTestByTestId(@Path("testId") Long testId);

    @GET("company/{title}/career/{id}/test/{testId}/shared/{sharedId}")
    Call<SharedTest> getSharedTest(@Path("sharedId") Long sharedId);

    //Authentication
    @POST("authentication")
    Call<Response> authenticateCompany(@Body Credential credential);
}
