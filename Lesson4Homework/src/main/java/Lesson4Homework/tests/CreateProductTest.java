package Lesson4Homework.tests;

import Lesson4Homework.BaseTest;
import Lesson4Homework.PageObjects.pageAdminPanel;
import Lesson4Homework.PageObjects.pageProductPage;
import Lesson4Homework.PageObjects.pageUserSite;
import Lesson4Homework.model.ProductData;
import Lesson4Homework.utils.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateProductTest extends BaseTest {

    pageAdminPanel adminPage = new pageAdminPanel();
    pageUserSite userSite = new pageUserSite();
    pageProductPage productPage = new pageProductPage();

    @DataProvider(name = "credentials")
    public Object[][] provideData() {
        return new Object[][]{{"webinar.test@gmail.com", "Xcg7299bnSmMuRLp9ITw"}};
    }

    @Test(dataProvider = "credentials")
    public void createNewProduct(String email, String password) throws InterruptedException {
        actions.login(email, password);

        WebElement catalogMenu = driver.findElement(adminPage.getPathToCatalog());
        catalogMenu.click();

        actions.waitForContentLoad(adminPage.getPathToCatalogGoods());

        actions.createProduct(ProductData.generate().getName(), ProductData.generate().
                getQty(), ProductData.generate().getPrice());

    }

    @Test(dependsOnMethods = "createNewProduct", enabled = true)
    public void checkProduct() throws InterruptedException {

        driver.navigate().to(Properties.getBaseUrl());
        actions.waitForContentLoad(userSite.getPathToPresenceBaseSite());

        //Жмем на кнопку "Все товары"
        WebElement allProductsButton = driver.findElement(userSite.getPathAllProductsButton());
        allProductsButton.click();

        actions.waitForContentLoad(userSite.getPathToPresenceBaseSite());

        String productName = actions.getProductName();
        System.out.println("Имя продукта = " + productName);

        By newlyCreatedProduct = By.linkText(productName);

        boolean bool = actions.isElementPresent(newlyCreatedProduct);
        Assert.assertEquals(bool, true, "Товар НЕ найден.");

        actions.waitForContentLoad(newlyCreatedProduct);
        WebElement newlyCreatedProductLink = driver.findElement(newlyCreatedProduct);

        String productURL = newlyCreatedProductLink.getAttribute("href");
        driver.navigate().to(productURL);

        //В Firefox клик не срабатывает (пробовал также два варината JS - в FireFox не работают).
        // Вот баг-репорт, который я нашел: https://github.com/mozilla/geckodriver/issues/322
        // newlyCreatedProductLink.click();

        actions.waitForContentLoad(productPage.getPathInfoAboutProduct());

        WebElement name = driver.findElement(productPage.getPathToProductName());
        WebElement price = driver.findElement(productPage.getPathToPrice());
        WebElement quantity = driver.findElement(productPage.getPathToQuantity());

        String nameString = name.getText();
        String priceString = actions.neededValue(price.getText());

        String quantityString = actions.neededValue(quantity.getText());

        System.out.println("Имя = " + nameString + ", " + "Цена = " + priceString + ", " + "Кол-во = " + quantityString);

        Assert.assertEquals(nameString.toLowerCase(), productName.toLowerCase(), "Имена товаров НЕ совпадают");
        Assert.assertEquals(priceString, actions.getPrice(), "Цены НЕ совпадают");
        Assert.assertEquals(quantityString, actions.getQuantity(), "Количества НЕ совпадают");

    }
}
