import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Date;

public class addCategoryTest extends baseScript {

    private static String login = "webinar.test@gmail.com";
    private static String password = "Xcg7299bnSmMuRLp9ITw";
    private static String categoryName;

    public static void main(String[] args) throws InterruptedException {

        Date date = new Date();
        categoryName =  date.toString();
        System.out.println("Дата = " + categoryName);

        WebDriver driver = getDriver();

        GeneralActions actions = new GeneralActions(driver);

        actions.login(login,password);

        actions.createCategory(categoryName);

    }
}
