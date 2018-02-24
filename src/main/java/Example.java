import Models.Career;
import Models.Company;
import Models.Credential;
import Models.test.Question;
import Models.test.Test;
import Models.test.shared.SharedTest;
import com.sun.org.apache.xpath.internal.SourceTree;
import okhttp3.ResponseBody;
import retrofit2.Response;
import sun.security.provider.SHA;

import java.awt.*;
import java.io.IOException;
import java.util.List;
//КЛАСС ДЛЯ СИНХРОННЫЙ ОПЕРАЦИЙ
public class Example {
    static ServiceApi serviceApi;
    public static void main(String[] args) {
        serviceApi =  ApiSingleton.getSetviceApi();

        Example example = new Example();

        Company company = new Company("title1", "login1", "password1");
        Credential credential = new Credential("login1", "password1");
        Career career = new Career(company, "career1");
        Test test = new Test(career, "test1");
        Question question = new Question(test,"sdfsdf", 80L);
        SharedTest sharedTest = new SharedTest(test, true);



//        System.out.println(example.addCompany(company).getLogin());
//        System.out.println(example.getCompany("login1", credential).getLogin());
//        System.out.println(example.addCareer("login1", career).getTitle());

//        List<Career> list = example.getAllCareerByCompany("login1");
//        for (int i=0; i < list.size(); i++)
//        {
//            System.out.println(list.get(i).getTitle());
//        }

//        System.out.println(example.addTest(1L, test).getId());

//        List<Test> list  = example.getAllTestByCareer(1L);
//        for (int i=0; i < list.size(); i++)
//        {
//            System.out.println(list.get(i).getTitle());
//        }

//метод не работает, пока Теймур не поправит параметры(см метод) System.out.println(example.addQuestion(1L, question));

//        System.out.println(example.getAllQuestionByTestId(0L));
//        example.deleteQuestion(0L);

//метод не работает, пока Теймур не поправит параметры(см метод) System.out.println(example.addSharedTest(0L, sharedTest));

//        List<SharedTest> list  = example.getAllSharedTestByTestId(0L);
//        for (int i=0; i < list.size(); i++)
//        {
//            System.out.println(list.get(i).getId());
//        }

//        System.out.println(example.getSharedTest(0L));

//        System.out.println(example.authenticateCompany(credential));

    }

    //company
    public Company getCompany(String loginCompany, Credential credential) {
        try {
            Response<Company> response = serviceApi.getCompany(loginCompany, credential).execute();
            return response.body();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Company addCompany(Company company) {
        Response<Company> response = null;
        try {
            response = serviceApi.addCompany(company).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response.body();
    }

    //Career
    public Career addCareer(String loginCompany, Career career) {
        Response<Career> response = null;
        try {
            response = serviceApi.addCareer(loginCompany, career).execute();
            return response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response.body();
    }

    public List<Career> getAllCareerByCompany(String loginCompany) {
        Response<List<Career>> response = null;
        try {
            response = serviceApi.getAllCareerByCompany(loginCompany).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response.body();
    }

    //Test
    public Test addTest(Long idCareer, Test test) {
        Response<Test> response = null;
        try {
            response = serviceApi.addTest(idCareer, test).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response.body();
    }

    public List<Test> getAllTestByCareer(Long idCareer) {
        try {
            Response<List<Test>> response = serviceApi.getAllTestByCareer(idCareer).execute();
            return response.body();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    //Question
    public Question addQuestion(Long careerId, Question question) { //ПОЛАГАЮ ЧТО ТЕЙМУР ИЗМЕНИТ МЕТОД У СЕБЯ, ЧТОБЫ ТУДА НАДО БЫЛО ПЕРЕДАВАТЬ CAREERID,
                                                                    // или вовсе изменит, чтобы нигде не надо было передавать id, а они брались из объектов,
                                                                    //которые мы передаем. Ведь каждый следующий обхект содержит в себе предыдущий
                                                                    // (вопрос содержит тест, который содержит професию, которая содержит компанию)
        try {
            Response<Question> response = serviceApi.addQuestion(careerId, question).execute();
            return response.body();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Question> getAllQuestionByTestId(Long testId) {
        try {
            Response<List<Question>> response = serviceApi.getAllQuestionByTestId(testId).execute();
            return response.body();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deleteQuestion(Long questionId) {
        try {
            Response<ResponseBody>  response =  serviceApi.deleteQuestion(questionId).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //SharedTest
    public SharedTest addSharedTest(Long testId, SharedTest sharedTest) {//ПОЛАГАЮ ЧТО ТЕЙМУР ИЗМЕНИТ МЕТОД У СЕБЯ, ЧТОБЫ ТУДА НАДО БЫЛО ПЕРЕДАВАТЬ testId,
        // или вовсе изменит, чтобы нигде не надо было передавать id, а они брались из объектов,
        //которые мы передаем. Ведь каждый следующий обхект содержит в себе предыдущий
        // (вопрос содержит тест, который содержит професию, которая содержит компанию)
        try {
            Response<SharedTest> response = serviceApi.addSharedTest(testId, sharedTest).execute();
            return response.body();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<SharedTest> getAllSharedTestByTestId(Long testId) {
        try {
            Response<List<SharedTest>> response = serviceApi.getAllShareTestByTestId(testId).execute();
            return response.body();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public SharedTest getSharedTest(Long sharedId) {
        try {
            Response<SharedTest> response = serviceApi.getSharedTest(sharedId).execute();
            return response.body();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public javax.ws.rs.core.Response authenticateCompany(Credential credential) {
        try {
            Response<javax.ws.rs.core.Response> response = serviceApi.authenticateCompany(credential).execute();
            return response.body();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
