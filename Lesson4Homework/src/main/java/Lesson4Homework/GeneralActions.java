package Lesson4Homework;

import Lesson4Homework.PageObjects.pageAdminPanel;
import Lesson4Homework.PageObjects.pageSignIn;
import Lesson4Homework.utils.Properties;
import Lesson4Homework.utils.logging.CustomReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GeneralActions {
    private WebDriver driver;
    private WebDriverWait wait;
    pageAdminPanel adminPage = new pageAdminPanel();
    pageSignIn loginPage = new pageSignIn();

    String productName;

    public String getProductName() {
        return productName;
    }

    String price;

    public String getPrice() {
        return price;
    }

    String quantity;

    public String getQuantity() {
        return quantity;
    }

    public GeneralActions(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    /**
     * Logs in to Admin Panel.
     *
     * @param login
     * @param password
     */
    public void login(String login, String password) {

        CustomReporter.log("Login as user - " + login);

        driver.navigate().to(Properties.getBaseAdminUrl());
        waitForContentLoad(loginPage.getPathToSignInButton());

        WebElement emailField = driver.findElement(loginPage.getPathToEmailField());
        emailField.sendKeys(login); //Ввод Email

        WebElement passwordField = driver.findElement(loginPage.getPathToPasswordField());
        passwordField.sendKeys(password); //Ввод Пароль

        WebElement signInButton = driver.findElement(loginPage.getPathToSignInButton());
        signInButton.click();

        waitForContentLoad(adminPage.getPathToAdminPanel());
    }

    public void createProduct(String name, Integer qty, String price)  {

        //Жмем на кнопку "Новый товар"
        WebElement createNewProduct = driver.findElement(adminPage.getPathToCreateNewGood());
        createNewProduct.click();

        waitForContentLoad(adminPage.getPathToProductNameTextField());

        //Вводим имя
        waitForContentLoad(adminPage.getPathToProductNameTextField());
        WebElement productNameTextField = driver.findElement(adminPage.getPathToProductNameTextField());
        productNameTextField.click();
        productName = name;
        productNameTextField.sendKeys(productName);

        //Вводим количество
        WebElement productQuantityTextField = driver.findElement(adminPage.getPathToProductQuantityTextField());
        productQuantityTextField.click();
        this.quantity = qty.toString();
        productQuantityTextField.sendKeys(this.quantity);

        //Вводим цену
        WebElement productPriceTextField = driver.findElement(adminPage.getPathToProductPriceTextField());
        int numberOfSymbols = quantityOfSymbols();
        for (; numberOfSymbols > 0; numberOfSymbols--) {
            productPriceTextField.sendKeys("\ue003");
        }

        this.price = price;
        productPriceTextField.sendKeys(this.price);

        //Активируем товар переключателем
        WebElement switcher = driver.findElement(adminPage.getPathToSwitcher());
        switcher.click();

        //Ждем когда появится Pop-Up и закрываем его
        waitForContentLoad(adminPage.getPathToPopUpMessage());
        WebElement closePopUpButton = driver.findElement(adminPage.getPathToClosePopUpMessage());
        closePopUpButton.click();
        wait.until(ExpectedConditions.stalenessOf(driver.findElement(adminPage.getPathToPopUpMessage())));

        //Сохраняем товар. Жмем кнопку "Сохранить"
        WebElement saveProductButton = wait.until(ExpectedConditions.
                elementToBeClickable(adminPage.getPathToSaveProduct()));
        saveProductButton.click();

        //Ждем когда появится Pop-Up и закрываем его
        waitForContentLoad(adminPage.getPathToPopUpMessage());
        WebElement closePopUpButtonAfterSubmit = driver.findElement(adminPage.getPathToClosePopUpMessage());
        closePopUpButtonAfterSubmit.click();

    }

    public int quantityOfSymbols() {

        WebElement productPriceTextField = driver.findElement(adminPage.getPathToProductPriceTextField());
        String quantitySymbols = productPriceTextField.getAttribute("value");
        int numberOfSymbols = quantitySymbols.length();
        System.out.println("Кол-во = " + numberOfSymbols);
        return numberOfSymbols;
    }

    public void waitForContentLoad(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String neededValue(String actual) {
        String[] parts = actual.split(" ");
        String neededValue = parts[0];
        return neededValue;
    }
}