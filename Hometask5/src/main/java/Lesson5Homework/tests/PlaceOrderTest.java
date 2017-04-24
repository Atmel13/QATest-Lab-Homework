package Lesson5Homework.tests;

import Lesson5Homework.BaseTest;
import Lesson5Homework.pageObjects.pageBaseSite;
import Lesson5Homework.pageObjects.pageCart;
import Lesson5Homework.pageObjects.pageOrderDone;
import Lesson5Homework.pageObjects.pagePersonalData;
import Lesson5Homework.Properties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class PlaceOrderTest extends BaseTest {

    pageBaseSite baseSite = new pageBaseSite();
    pageCart cart = new pageCart();
    pagePersonalData personalData = new pagePersonalData();
    pageOrderDone orderDone = new pageOrderDone();

    @Test
    public void checkSiteVersion() {
        driver.navigate().to(Properties.getBaseUrl());
        actions.waitForContentLoad(baseSite.getPathToPresenceBaseSite());

        WebElement mobileLogo = driver.findElement(baseSite.getPathToMobileLogo());

        Boolean ifMobileLogoVisible = mobileLogo.isDisplayed();

        if (!ifMobileLogoVisible) {
            System.out.println("Отображена Десктопная версия сайта");
        }
        else {System.out.println("Отображена Мобильная версия сайта");
        }
    }

    @Test (dependsOnMethods = "checkSiteVersion")
    public void createNewOrder() throws InterruptedException {

        WebElement allProducts = driver.findElement(baseSite.getPathAllProductsButton());
        allProducts.click(); //кликаем на "Все продукты"
        actions.waitForContentLoad(baseSite.getPathToPresenceBaseSite());
        actions.openRandomProduct(); // открываем случайный продукт

        WebElement name = driver.findElement(baseSite.getPathToProductName());
        WebElement price = driver.findElement(baseSite.getPathToPrice());

        String nameString = name.getText(); // получаем имя продукта
        String priceString = actions.neededValue(price.getText()); //получаем цену продукта
        String productURL = driver.getCurrentUrl(); //получаем URL продукта

        WebElement productDetailsTab = actions.wait.until(ExpectedConditions.
                visibilityOfElementLocated(baseSite.getPathToProductDetailsTab()));
        productDetailsTab.click(); //открывает детали продукта, чтобы узнать количество

        WebElement availableQuantity = actions.wait.until(ExpectedConditions.
                visibilityOfElementLocated(baseSite.getPathToAvailableProducts()));
        String availQuantity = actions.neededValue(availableQuantity.getText());
        int intAvailQuantity = Integer.parseInt(availQuantity);
        System.out.println("Колво доступного товара = " + intAvailQuantity);

        WebElement toCart = driver.findElement(baseSite.getPathToAddToCartButton());
        toCart.click(); //добавляем в корзину

        WebElement continueToRegisterButton = actions.wait.until(ExpectedConditions.
                elementToBeClickable(baseSite.getPathToContinueToRegister()));
        continueToRegisterButton.click();

        WebElement nameProductInCart = actions.wait.until(ExpectedConditions.
                visibilityOfElementLocated(cart.getPathToProductNameCart()));

        WebElement priceProductInCart = driver.findElement(cart.getPathToProductPriceCart());

        String productName = nameProductInCart.getText(); // имя товара в корзине
        String productPrice = actions.neededValue(priceProductInCart.getText()); //цена товара в корзине

        Assert.assertEquals(nameString.toLowerCase(),productName.toLowerCase(),"Названия товаров не совпадают");
        Assert.assertEquals(priceString,productPrice,"Цены не совпадают");

        //количесвто позиций в корзине
        List<WebElement> quantityProductTypes = driver.findElements(cart.getPathToQuantityTypesOfProdoucts());
        System.out.println("Кол-во позиций = " + quantityProductTypes.size());

        Assert.assertEquals(quantityProductTypes.size(),1, "В корзине больше, чем 1 позиция или ноль");

        WebElement createOrferButton = driver.findElement(cart.getPathToCreateOrder());
        createOrferButton.click();

        actions.waitForContentLoad(personalData.getPathToPersonalDataForm());

        WebElement nameField = driver.findElement(personalData.getPathToNameField());
        WebElement surnameField = driver.findElement(personalData.getPathToSurnameField());
        WebElement emailField = driver.findElement(personalData.getPathToEmailField());

        nameField.click();
        nameField.sendKeys("James");
        surnameField.click();
        surnameField.sendKeys("Bond");
        emailField.click();
        emailField.sendKeys(actions.UniqueEmail());

        WebElement continueButtonPersData = driver.findElement(personalData.getPathToContinueButton());
        continueButtonPersData.click();

        WebElement addressField = driver.findElement(cart.getPathToAddressField());
        WebElement postCodeField = driver.findElement(cart.getPathToCodeIndexField());
        WebElement cityField = driver.findElement(cart.getPathToCityField());

        addressField.click();
        addressField.sendKeys("Some address");
        postCodeField.click();
        postCodeField.sendKeys("12345");
        cityField.sendKeys("Antananarivu");

        WebElement continueButtonAddress = driver.findElement(cart.getPathToContinueButtonAddress());
        continueButtonAddress.click();

        WebElement continueButtonDelivery = actions.wait.until(ExpectedConditions.
                elementToBeClickable(cart.getPathToContinueButtonDelivery()));

        continueButtonDelivery.click();

        WebElement createOrderWithNecessaryPayment = actions.wait.until(ExpectedConditions.
                visibilityOfElementLocated(cart.getPathToCrateOrderWithPayment()));
        WebElement paymentType = driver.findElement(cart.getPathToPaymentType());
        WebElement iAgreeCheckbox = driver.findElement(cart.getPathToIAgreecheckbox());

        paymentType.click();
        iAgreeCheckbox.click();
        createOrderWithNecessaryPayment.click();

        WebElement infoAboutOrder = actions.wait.until(ExpectedConditions.
                visibilityOfElementLocated(orderDone.getPathToOrderIsApproved()));
        String g = infoAboutOrder.getText();

        Boolean successOrderText = infoAboutOrder.getText().toLowerCase().contains("ваш заказ подтверждён");

        Assert.assertTrue(successOrderText);

        List<WebElement> quantityOrders = driver.findElements(orderDone.getPathToQuantityTypesOfProducts());
        Assert.assertEquals(quantityOrders.size(),1, "В корзине больше, чем 1 товар или ноль");

        WebElement productNameInDoneOrder = driver.findElement(orderDone.getPathToProductName());
        WebElement productPriceInDoneOrder = driver.findElement(orderDone.getPathToPrice());

        String productNameInDoneOrderValue = actions.neededName(productNameInDoneOrder.getText());
        String productPriceInDoneOrderValue = actions.neededValue(productPriceInDoneOrder.getText());

        Assert.assertEquals(nameString.toLowerCase(),productNameInDoneOrderValue.
                toLowerCase(),"Названия товаров не совпадают");
        Assert.assertEquals(priceString,productPriceInDoneOrderValue,"Цены не совпадают");

        driver.navigate().to(productURL);

        productDetailsTab = actions.wait.until(ExpectedConditions.
                visibilityOfElementLocated(baseSite.getPathToProductDetailsTab()));
        productDetailsTab.click();

        WebElement availableQuantityAfterPurchase = actions.wait.until(ExpectedConditions.
                visibilityOfElementLocated(baseSite.getPathToAvailableProducts()));
        String availQuantityAfterPurchase = actions.neededValue(availableQuantityAfterPurchase.getText());
        int intAvailQuantityAfterPurchase = Integer.parseInt(availQuantityAfterPurchase);

        Assert.assertEquals(intAvailQuantity,intAvailQuantityAfterPurchase + 1,
                "Количество оставшегося товара не верно");

        System.out.println("Колво доступного товара после оформления заказа = " + availQuantityAfterPurchase);

    }
}
