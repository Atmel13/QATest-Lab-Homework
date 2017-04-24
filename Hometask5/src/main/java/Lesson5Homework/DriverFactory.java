package Lesson5Homework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.SkipException;

import java.net.URL;

public class DriverFactory {

    public static WebDriver initDriver(String browser, String gridUrl) {
        WebDriver driver;
        URL url;

        try {
            url = new URL(gridUrl);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new SkipException("Unable to create RemoteDriver instance");
        }

        DesiredCapabilities capabilities;

        switch (browser){

            case "chrome":
                capabilities = DesiredCapabilities.chrome();
                break;

            case "firefox":
                capabilities = DesiredCapabilities.firefox();
                break;

            case "ie":
                capabilities = DesiredCapabilities.internetExplorer();
                break;

            default:
                capabilities = DesiredCapabilities.chrome();
                break;

        }

        driver = new RemoteWebDriver(url,capabilities);
        return driver;
    }
}
