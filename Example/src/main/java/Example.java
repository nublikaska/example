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

        Company company = new Company("title8", "login8", "password8");
        Credential credential = new Credential("login8", "password8");
        Career career = new Career(company, "career2");
        Test test = new Test(career, "test10");



        //System.out.println(example.addCompany(company).getLogin());
        //System.out.println(example.getCompany("login8", credential).getLogin());//не работает
        //System.out.println(example.addCareer(career.getCompany().getLogin(), career).getTitle());
        //System.out.println(example.getAllCareerByCompany("login7").get(6).getTitle());
        //System.out.println(example.addTest("login7", 0L, test).getId());
        //System.out.println(example.getAllTestByCareer(0L).get(6).getTitle());//не работает

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

    public List<Test> getAllTestByCareer(Long id) {
        try {
            Response<List<Test>> response = serviceApi.getAllTestByCareer(id).execute();
            return response.body();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
