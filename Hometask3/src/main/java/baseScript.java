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

                case "chrome":  System.setProperty(
                        "webdriver.chrome.driver",
                        new File(baseScript.class.getResource("/chromedriver.exe").getFile()).getPath());
                    return new ChromeDriver();

                case "firefox":  System.setProperty(
                        "webdriver.gecko.driver",
                        new File(baseScript.class.getResource("/geckodriver.exe").getFile()).getPath());
                    return new FirefoxDriver();

                //IE не захотел работать. Решение как это обойти через сам Selenium не нашел. Но нашел линк, что в реестре Windows надо изменить, чтоб тест пошел
                //Линк с проблемой с IE11: https://selenium2.ru/component/content/article.html?id=111
                case "internet explorer":  System.setProperty(
                        "webdriver.ie.driver",
                        new File(baseScript.class.getResource("/IEDriverServer.exe").getFile()).getPath());
                    return new InternetExplorerDriver();

                default:
                    System.setProperty(
                            "webdriver.chrome.driver",
                            new File(baseScript.class.getResource("/chromedriver.exe").getFile()).getPath());
                    return new ChromeDriver();
        }
    }
}
