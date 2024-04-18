import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.logging.Level;
import java.util.logging.Logger;

public class login {
    public static void main(String[] args) {
        Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
        System.setProperty("webdriver.chrome.driver", "/Users/askita/NetBeansProjects/qaAutomationFakhri/SproutQaAutomationFakhri/chromedriver");

        ChromeOptions options = new ChromeOptions();
        ChromeDriver driver = new ChromeDriver(options);

        driver.get("https://www.saucedemo.com/");

    }
}
