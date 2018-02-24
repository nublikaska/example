import Models.Career;
import Models.Company;
import Models.Credential;
import Models.test.Test;
import retrofit2.Response;

import java.awt.*;
import java.io.IOException;
import java.util.List;

public class Example {
    static ServiceApi serviceApi;
    public static void main(String[] args) {
        serviceApi =  ApiSingleton.getSetviceApi();

        Example example = new Example();

        Company company = new Company("title1", "login1", "password1");
        Credential credential = new Credential("login1", "password1");
        Career career = new Career(company, "career2");
        Test test = new Test(career, "test2");



//        System.out.println(example.addCompany(company).getLogin());
//        System.out.println(example.getCompany("login1", credential).getLogin());
//        System.out.println(example.addCareer("login1", career).getTitle());

//        List<Career> list = example.getAllCareerByCompany("login1");
//        for (int i=0; i < list.size(); i++)
//        {
//            System.out.println(list.get(i).getTitle());
//        }

//        System.out.println(example.addTest("login1", 1L, test).getId());

        List<Test> list  = example.getAllTestByCareer(1L);
        for (int i=0; i < list.size(); i++)
        {
            System.out.println(list.get(i).getTitle());
        }

    }

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

    public Test addTest(String loginCompany, Long idCareer, Test test) {
        Response<Test> response = null;
        try {
            response = serviceApi.addTest(loginCompany, idCareer, test).execute();
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
}
