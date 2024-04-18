package manager;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class TestManager {
    public String setProperty(String name) throws IOException {
        FileReader reader = new FileReader("src/main/java/config/config.properties");
        Properties properties = new Properties();
        properties.load(reader);
        switch (name){
            case "lock_username":
                return properties.getProperty("lock_username");
            case "username":
                return properties.getProperty("username");
            case "password":
                return properties.getProperty("password");
            case "url":
                return properties.getProperty("url");
            case "report":
                return properties.getProperty("report");
            default:
                return properties.getProperty("URL");
        }
    }
}
