package controller;

import manager.TestManager;
import manager.UIManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import webelement.PageObject;
import java.io.FileReader;
import util.Load;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import org.openqa.selenium.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import manager.*;
import org.openqa.selenium.support.ui.Select;
import util.*;
import webelement.PageObject;
import static org.openqa.selenium.By.*;

import static org.openqa.selenium.By.xpath;

public class Base {
    private WebDriver driver; private String webElement="";
    public Base() {
        super();
    }

    TestManager testManager = new TestManager();
    UIManager uiManager = new UIManager();
    PageObject pg = new PageObject();
    Load wait =new Load();


    protected void testBrowser(String bs) throws MalformedURLException, InterruptedException {
        String browser="";
        switch(bs){
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*"); options.addArguments("--remote-debugging-port=9999");
                driver = new ChromeDriver(options); break;
            default:
                SafariOptions optionsS = new SafariOptions();
                driver = new SafariDriver(optionsS);break;
        }

        String baseUrl = "";
        try{
            baseUrl=testManager.setProperty("url");
        }catch(Exception e){
            System.err.print(e);
        }
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get(baseUrl); driver.manage().window().maximize();wait.For(2);
    }

    protected void clickButton(String w, String txt ){
        if(driver.findElement(xpath(uiManager.FindElement(w))).getText().equals(txt))
        {
            driver.findElement(xpath(uiManager.FindElement(w))).click();
        }
        else {System.err.println("Could not find the button");}
    }
    protected void clickButton2(String w){
        driver.findElement(xpath(uiManager.FindElement(w))).click();
    }
    protected void enterText(String w, String txt){
        driver.findElement(xpath(uiManager.FindElement(w))).clear();
        driver.findElement(xpath(uiManager.FindElement(w))).sendKeys(txt);
    }
    protected String verifyTitleText(String page, Integer i){
        String[]Text = pg.Table(page, i).split(";");
        String r="";
        if(Text[0].equalsIgnoreCase(driver.findElement(xpath(Text[1])).getText()))
            r="true";
        else{ r="false";
            Actions action=new Actions(driver);
            WebElement web =driver.findElement(xpath(Text[1]));
            action.moveToElement(web).build().perform();
        }
        return r;
    }

    protected void BrowserClose(){
        driver.quit();
    }

    protected WebDriver getdriver(){
        return driver=this.driver;
    }

    String DataTime="";
    public String getDateTime(){
        return DataTime = new SimpleDateFormat("yyyyMMddhhmm").format(new Date());
    }

    String rpLocation ="";
    public String getReportPath(){
        try{
            rpLocation = testManager.setProperty("report");
        } catch(Exception e){};
        return rpLocation;
    }

    public void clickLink(String lText){
        try{ driver.findElement(By.linkText(lText)).click();}catch(NoSuchElementException e){System.err.println(e);}
    }
    public String getText(String w){
        return driver.findElement(By.xpath(uiManager.FindElement(w))).getText();
    }
}
