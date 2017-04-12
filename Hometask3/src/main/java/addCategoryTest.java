import org.openqa.selenium.WebDriver;
import java.util.Date;

public class addCategoryTest extends baseScript {

    private static String login = "webinar.test@gmail.com";
    private static String password = "Xcg7299bnSmMuRLp9ITw";
    private static String categoryName;

    public static void main(String[] args) throws InterruptedException {

        Date date = new Date();
        categoryName =  date.toString();

        WebDriver driver = getDriver();

        GeneralActions actions = new GeneralActions(driver);

        actions.login(login,password);

        actions.createCategory(categoryName);

        driver.quit();

        //после этого теста, можно б было еще добавить очистку созданной категории (или всех категорий) через UI или API

    }
}
