package Lesson5Homework;

import Lesson5Homework.pageObjects.pageBaseSite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class GeneralActions {
    private WebDriver driver;
    public WebDriverWait wait;
    pageBaseSite baseSite = new pageBaseSite();

    public GeneralActions(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    public void openRandomProduct() {
        //сколько всего товаров на странице.
        List<WebElement> products = driver.findElements(baseSite.getPathToAllProductsOnPage());

        int firstProduct = 1;
        int lastProduct = products.size();
        int range = (lastProduct - firstProduct) + 1;
        int randomProduct = (int) (Math.random() * range + firstProduct); // номер случайного продукта.

        WebElement randomProductItem = driver.findElement(By.xpath("//*[@id=\"js-product-list\"]/div[1]/article[" +
                randomProduct + "]/div/div[1]/h1/a"));
        randomProductItem.click();
    }

    public void waitForContentLoad(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public String neededValue(String actual) {
        String[] parts = actual.split(" ");
        String neededValue = parts[0];
        return neededValue;
    }

    public String UniqueEmail() { //создаем уникальный Email
        String EmailDomainPart = "@mailinator.com";
        String StaticPartEmail = "QATL";
        String uniqueEmail = StaticPartEmail + System.currentTimeMillis() + EmailDomainPart;
        return uniqueEmail;
    }

    public String neededName(String actual) {
        String[] parts = actual.split(" - Size");
        String neededName = parts[0];
        return neededName;
    }

}
