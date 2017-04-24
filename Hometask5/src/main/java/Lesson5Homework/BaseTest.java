package Lesson5Homework;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    protected WebDriver driver;
    protected GeneralActions actions;
    protected boolean isMobileTesting;

    @BeforeClass
    @Parameters({"selenium.browser", "selenium.grid"})
    public void setUp(String browser, String gridUrl) {

        driver = DriverFactory.initDriver(browser, gridUrl);

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        // unable to maximize window in mobile mode
        if (!isMobileTesting(browser))
            driver.manage().window().maximize();

        isMobileTesting = isMobileTesting(browser);

        actions = new GeneralActions(driver);
    }

    @AfterClass (enabled = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private boolean isMobileTesting(String browser) {
        switch (browser) {
            case "android":
                return true;
            case "firefox":
            case "ie":
            case "internet explorer":
            case "chrome":
            case "phantomjs":
            default:
                return false;
        }
    }
}
