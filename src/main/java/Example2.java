import Models.Career;
import Models.Company;
import Models.Credential;
import Models.test.Question;
import Models.test.Test;
import Models.test.shared.SharedTest;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;
//КЛАСС ДЛЯ АСИНХРОННЫХ ОПЕРАЦИЙ, В МЕТОД НЕОБХОДИМО ПЕРЕДАТЬ CALLBACK - в нем определить, что сделать, после операции.
public class Example2 {
    static ServiceApi serviceApi;
    public static void main(String[] args) {
        serviceApi =  ApiSingleton.getSetviceApi();

        Example2 example2 = new Example2();

        Company company = new Company("title1", "login2", "password3");
        Credential credential = new Credential("login1", "password1");
        Career career = new Career(company, "career1");
        Test test = new Test(career, "test1");
        Question question = new Question(test,"sdfsdf", 80L);
        SharedTest sharedTest = new SharedTest(test, true);

        example2.addCompany(new Callback<Company>() {
            public void onResponse(Call<Company> call, Response<Company> response) {
                if (!response.body().equals(null))
                    System.out.println(response.body().getLogin());
            }

            public void onFailure(Call<Company> call, Throwable throwable) {
            }
        }, company);

//        example2.addCareer(new Callback<Career>() {
//            public void onResponse(Call<Career> call, Response<Career> response) {
//                //
//            }
//
//            public void onFailure(Call<Career> call, Throwable throwable) {
//
//            }
//        }, "login1", career);
    }

    //company
    public void getCompany(Callback<Company> callback, String loginCompany, Credential credential) {
        //serviceApi.getCompany(loginCompany, credential).enqueue(callback);
        serviceApi.getCompany(loginCompany, credential);
    }

    public void addCompany(Callback<Company> callback, Company company) {
        serviceApi.addCompany(company).enqueue(callback);
    }

    //Career
    public void addCareer(Callback<Career> callback, String loginCompany, Career career) {
        serviceApi.addCareer(loginCompany, career).enqueue(callback);
    }

    public void getAllCareerByCompany(Callback<List<Career>> callback, String loginCompany) {
        serviceApi.getAllCareerByCompany(loginCompany).enqueue(callback);
    }

    //Test
    public void addTest(Callback<Test> callback, Long idCareer, Test test) {
        serviceApi.addTest(idCareer, test).enqueue(callback);
    }

    public void getAllTestByCareer(Callback<List<Test>> callback, Long idCareer) {
        serviceApi.getAllTestByCareer(idCareer).enqueue(callback);
    }

    //Question
    public void addQuestion(Callback<Question> callback, Long careerId, Question question) { //ПОЛАГАЮ ЧТО ТЕЙМУР ИЗМЕНИТ МЕТОД У СЕБЯ, ЧТОБЫ ТУДА НАДО БЫЛО ПЕРЕДАВАТЬ CAREERID,
        // или вовсе изменит, чтобы нигде не надо было передавать id, а они брались из объектов,
        //которые мы передаем. Ведь каждый следующий обхект содержит в себе предыдущий
        // (вопрос содержит тест, который содержит професию, которая содержит компанию)
        serviceApi.addQuestion(careerId, question).enqueue(callback);
    }

    public void getAllQuestionByTestId(Callback<List<Question>> callback, Long testId) {
        serviceApi.getAllQuestionByTestId(testId).enqueue(callback);
    }

    public void deleteQuestion(Callback<ResponseBody> callback, Long questionId) {
        serviceApi.deleteQuestion(questionId).enqueue(callback);
    }

    //SharedTest
    public void addSharedTest(Callback<SharedTest> callback, Long testId, SharedTest sharedTest) {//ПОЛАГАЮ ЧТО ТЕЙМУР ИЗМЕНИТ МЕТОД У СЕБЯ, ЧТОБЫ ТУДА НАДО БЫЛО ПЕРЕДАВАТЬ testId,
        // или вовсе изменит, чтобы нигде не надо было передавать id, а они брались из объектов,
        //которые мы передаем. Ведь каждый следующий обхект содержит в себе предыдущий
        // (вопрос содержит тест, который содержит професию, которая содержит компанию)
        serviceApi.addSharedTest(testId, sharedTest).enqueue(callback);
    }

    public void getAllSharedTestByTestId(Callback<List<SharedTest>> callback, Long testId) {
        serviceApi.getAllShareTestByTestId(testId).enqueue(callback);
    }

    public void getSharedTest(Callback<SharedTest> callback, Long sharedId) {
        serviceApi.getSharedTest(sharedId).enqueue(callback);
    }

    public void authenticateCompany(Callback<javax.ws.rs.core.Response> callback, Credential credential) {
        serviceApi.authenticateCompany(credential).enqueue(callback);
    }
}
