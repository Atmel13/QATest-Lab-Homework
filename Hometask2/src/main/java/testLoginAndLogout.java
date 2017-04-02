import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Properties;

public class testLoginAndLogout {

    public static void main (String[] args) throws InterruptedException  {

        pageSignIn login = new pageSignIn();
        pageAdminPanel adminPage = new pageAdminPanel();

        String driverPath = System.getProperty("user.dir") + "/driver/chromedriver.exe";
        //String driverPath = System.getProperty("driver.executable");
        System.setProperty("webdriver.chrome.driver", driverPath);

        ChromeOptions option = new ChromeOptions();
        option.addArguments("window-size=1350,850");

        WebDriver driver = new ChromeDriver(option);

        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");

        WebElement signInButton = (new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(login.getPathToSignInButton()));

        WebElement email = driver.findElement(login.getPathToEmailField());
        email.sendKeys("webinar.test@gmail.com"); //Ввод Email

        WebElement password = driver.findElement(login.getPathToPasswordField());
        password.sendKeys("Xcg7299bnSmMuRLp9ITw"); //Ввод Email

        signInButton.click();

        Thread.sleep(2000);

        List<WebElement> adminAvatar = driver.findElements(adminPage.getPathToAdminAvatar());

        if (adminAvatar.size() > 0) {
            System.out.println("Вход в админ панель выполнен!");

            adminAvatar.get(0).click();

            WebElement exitButton = (new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(adminPage.getPathToExitButton()));
            exitButton.click();

            Thread.sleep(2000);

            List<WebElement> signInPage = driver.findElements(login.getPathToSignInButton());

                if (signInPage.size() > 0) {
                System.out.println("Выход из админ панели выполнен!"); }

                else System.out.println("Выход из админ панели НЕ выполнен!");

        }
        else System.out.println("Вход в админ панель НЕ выполнен!");

        driver.quit();

    }

}
