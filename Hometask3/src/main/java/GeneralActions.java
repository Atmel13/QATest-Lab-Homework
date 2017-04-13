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
    private By categoryLink = By.xpath("//*[@id=\"subtab-AdminCategories\"]/a"); // локатор, который содержит ссылку, по которой открывается страница "Категории"
    private By pathToEmailField = By.name("email");
    private By pathToPasswordField = By.name("passwd");
    private By pathToSignInButton = By.name("submitLogin");
    private By pathCreateNewCategoryButton = By.id("page-header-desc-category-new_category");
    private By pathEnterCategoryName = By.id("name_1");
    private By pathToSaveButton = By.id("category_form_submit_btn");
    private By pathSuccessCreateCategoryMessage = By.xpath("//*[@id=\"content\"]/div[3]/div"); // Сообщение о том, что категория успешно создана
    private By pathFilter = By.xpath("//*[@id=\"table-category\"]//tr[1]/th[3]/span/a[1]");
    private By pathTableCategory = By.id("table-category");

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

        WebElement categoryLink = (new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(this.categoryLink));

/* класс Actions НЕ работает в Firefox. Вот нашел описанную кем то проблему: https://github.com/SeleniumHQ/selenium/issues/2581
Поэтому, чтоб нормально проходил скрипт в Хроме и Мозиле сделал ниже без применения Actions.

// вот пример как реализовал с помощью Actions:

        WebElement categoryLink = (new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(this.categoryLink));

        Actions action = new Actions(driver);
        action.moveToElement(catalogLink);
        action.perform();
// вместе собранная конструкция не заработала в Chrome (как показывали в лекции), поэтому сделал по отдельности.
        WebElement categoryUrl = (new WebDriverWait(driver, 2)).until(ExpectedConditions.presenceOfElementLocated(categoryLink));
        categoryUrl.click();
*/



// Пробовал нажать с помощью JS, но код не сработал. Ниже два опробованных варианта
/* //1 вариант
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", categoryLink);
*/

/* //2 вариант
        String script = "var object = arguments[0];"
                + "var theEvent = document.createEvent(\"MouseEvent\");"
                + "theEvent.initMouseEvent(\"click\", true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
                + "object.dispatchEvent(theEvent);"
                ;

        ((JavascriptExecutor)driver).executeScript(script, categoryLink);
*/


        //Достаю ссылку из соотв. локатора которая ведет на страницу "Категории"
        String linkToCategories = categoryLink.getAttribute("href"); // ссылка, по которой открывается страница "Категории"
        driver.navigate().to(linkToCategories);

        WebElement addNewCategoryButton = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(pathCreateNewCategoryButton));
        addNewCategoryButton.click();

        WebElement fillInCategoryName = (new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(pathEnterCategoryName));
        fillInCategoryName.sendKeys(categoryName);

        WebElement saveButton = driver.findElement(pathToSaveButton);
        saveButton.click();

        //сообщение о том, что категория создана
        WebElement createSuccessCategory = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(pathSuccessCreateCategoryMessage));

        By pathToCategoryItem = By.xpath("//*[@id=\"table-category\"]//td[contains(text(),'" + categoryName + "')]");
        List<WebElement> ifCategoryCreated = driver.findElements(pathToCategoryItem);

        if (ifCategoryCreated.size() != 0)  System.out.println("\n" + "Категория создана. Имя категории = " + categoryName + "\n");
        else System.out.println("\n" + "Категория НЕ создана" + "\n");
    }

    public void filterByName (String categoryName) {

        WebElement filterButton = driver.findElement(pathFilter);
        filterButton.click();
        WebElement tableCategory = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(pathTableCategory));

        By pathToCategoryItem = By.xpath("//*[@id=\"table-category\"]//td[contains(text(),'" + categoryName + "')]");
        List<WebElement> ifCategoryCreated = driver.findElements(pathToCategoryItem);

        if (ifCategoryCreated.size() != 0)  System.out.println("\n" + "Категория по прежнему видима на странице = " + categoryName  + "\n");
        else System.out.println("\n" + "Категория на странице не обнаружена после фильтрации" + "\n");

    }

}
