import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class GeneralActions {
    private WebDriver driver;
    private WebDriverWait wait;
    private By catalogLink = By.id("subtab-AdminCatalog");
    private By categoryLink = By.id("subtab-AdminCategories");
    private By pathToEmailField = By.id("email");
    private By pathToPasswordField = By.id("passwd");
    private By pathToSignInButton = By.id("submitLogin");
    private By pathCreateNewCategoryButton = By.id("page-header-desc-category-new_category");
    private By pathEnterCategoryName = By.id("name_1");
    private By pathToSaveButton = By.id("category_form_submit_btn");
    private By pathSuccessCreateCategoryMessage = By.xpath("//*[@id=\"content\"]/div[3]/div"); // Сообщение о том, что категория успешно создана

    public GeneralActions(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
    }

    public void login(String login, String password) {

        driver.navigate().to(Properties.getBaseAdminUrl());
        WebElement signInButton = (new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(pathToSignInButton));

        WebElement emailField = driver.findElement(pathToEmailField);
        emailField.sendKeys(login); //Ввод Email

        WebElement passwordField = driver.findElement(pathToPasswordField);
        passwordField.sendKeys(password); //Ввод Пароль

        signInButton.click();
    }

    public void createCategory(String categoryName) {

        WebElement catalogLink = (new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(this.catalogLink));

        Actions action = new Actions(driver);
        action.moveToElement(catalogLink);
        action.perform();
        WebElement categoryUrl = (new WebDriverWait(driver, 2)).until(ExpectedConditions.presenceOfElementLocated(categoryLink));
        categoryUrl.click();
        WebElement addNewCategoryButton = (new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(pathCreateNewCategoryButton));
        addNewCategoryButton.click();

        WebElement fillInCategoryName = (new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(pathEnterCategoryName));
        fillInCategoryName.sendKeys(categoryName);

        WebElement saveButton = driver.findElement(pathToSaveButton);
        saveButton.click();

        WebElement createSuccessCategory = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(pathSuccessCreateCategoryMessage));

        By pathToCategoryItem = By.xpath("//*[@id=\"table-category\"]//td[contains(text(),'" + categoryName + "')]");
        List<WebElement> ifCategoryCreated = driver.findElements(pathToCategoryItem);

        if (ifCategoryCreated.size() != 0)  System.out.println("Категория создана. Имя категории = " + categoryName);
        else System.out.println("Категория НЕ создана");
    }
}
