import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;

/**
 * Created by Atmel on 01.04.2017.
 */
public class testWorkingAdminPanel {

    public static void main (String[] args) throws InterruptedException {

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
        WebElement adminAvatar = (new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(adminPage.getPathToAdminAvatar()));
        System.out.println("Вход в админ панель выполнен!"  + "\n");

        List<By> element = new ArrayList();
        element.add(0, adminPage.getPathToDashboard());
        element.add(1, adminPage.getPathToOrders());
        element.add(2, adminPage.getPathToCatalog());
        element.add(3, adminPage.getPathToClients());
        element.add(4, adminPage.getPathToCusromerService());
        element.add(5, adminPage.getPathToStatistic());
        element.add(6, adminPage.getPathToModules());
        element.add(7, adminPage.getPathToDesign());
        element.add(8, adminPage.getPathToDelivery());
        element.add(9, adminPage.getPathToTypePayment());
        element.add(10, adminPage.getPathToInternational());
        element.add(11, adminPage.getPathToShopParameters());
        element.add(12, adminPage.getPathToConfiguration());

        for (int i = 0; i < element.size(); i++) {

            WebElement menuItem = driver.findElement(element.get(i));
            menuItem.click();
            WebElement pageTitle = (new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(adminPage.getPathToPageHead()));
            String pageName = pageTitle.getText();
            System.out.println("Имя открытой страницы: " + pageName);
            driver.navigate().refresh();
            WebElement pageTitleAfterRefresh = (new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(adminPage.getPathToPageHead()));
            String pageNameAfterRefresh = pageTitleAfterRefresh.getText();
            System.out.println("pageNameAfterRefresh = " + pageNameAfterRefresh);
            if (pageName.equals(pageNameAfterRefresh)) {
                System.out.println("Имена страниц совпадают" + "\n");
            } else System.out.println("Имена страниц НЕ совпадают");

        }

        driver.quit();
    }
}
