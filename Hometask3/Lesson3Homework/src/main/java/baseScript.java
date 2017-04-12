import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;

public abstract class baseScript {

    public static WebDriver getDriver() {

        String browser = Properties.getBrowser();

        System.out.println("Строка browser = " + browser);

            switch (browser) {
                /*
                case "chrome":  System.setProperty(
                        "webdriver.chrome.driver",
                        new File(baseScript.class.getResource("/chromedriver.exe").getFile()).getPath());
                    return new ChromeDriver();

                case "firefox":  System.setProperty(
                        "webdriver.gecko.driver",
                        new File(baseScript.class.getResource("/geckodriver.exe").getFile()).getPath());
                    return new FirefoxDriver();

                case "ie":  System.setProperty(
                        "webdriver.ie.driver",
                        new File(baseScript.class.getResource("/IEDriverServer.exe").getFile()).getPath());
                    return new InternetExplorerDriver();
*/
                default:
                    System.setProperty(
                            "webdriver.chrome.driver",
                            new File(baseScript.class.getResource("/chromedriver.exe").getFile()).getPath());
                    return new ChromeDriver();
        }
    }
}
