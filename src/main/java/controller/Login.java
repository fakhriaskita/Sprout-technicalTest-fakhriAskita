package controller;

import org.openqa.selenium.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.ExtentTest;

import manager.*;

public class Login extends Base {
    public Login() {
        super();
    }

    TestManager testManager = new TestManager();;
    ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(getReportPath()+"Login"+getDateTime()+".html");
    ExtentHtmlReporter htmlReporter1 = new ExtentHtmlReporter(getReportPath()+"Regression"+getDateTime()+".html");
    ExtentHtmlReporter htmlReporter2 = new ExtentHtmlReporter(getReportPath()+"Sanity"+getDateTime()+".html");

    ExtentReports extent = new ExtentReports();

    String username="";

    public String getUsername() {
        try {
            username = testManager.setProperty("username");
        } catch (Exception e){};
        return username;
    }

    String password="";

    public String getPassword() {
        try {
            password = testManager.setProperty("password");
        } catch (Exception e){};
        return password;
    }

    public void LoginSuccess(String browser, Integer testInt) {
        switch (testInt){
            case 0:
                extent.attachReporter(htmlReporter);break;
            case 1:
                extent.attachReporter(htmlReporter1);break;
            case 2:
                extent.attachReporter(htmlReporter2);break;
        }
        ExtentTest test = extent.createTest("Open Sauce Demo"+browser,"Test Open Web Sauce Demo");
            // Open Browser
            try {
                testBrowser(browser);
                wait.For(2);
                test.pass("Open Web Browser");
            }catch(Exception e){
                test.fail("Could not open the web app"+e);
            } extent.flush();

            //Input username
            try {
                enterText("Login_Username", getUsername());
                test.pass("success input username");
            }catch (NoSuchElementException e){
                test.fail("failed");
            }extent.flush();

            //Input password
            try {
                enterText("Login_Password", getPassword());
                test.pass("success input password");
            }catch (NoSuchElementException e){
                test.fail("failed");
            }extent.flush();

            //Click button Login
            try {
                clickButton2("Login_Submit");
                test.pass("success Login");
            }catch (NoSuchElementException e){
                test.fail("failed to Login");
            }extent.flush();

//        BrowserClose();
    }
}
