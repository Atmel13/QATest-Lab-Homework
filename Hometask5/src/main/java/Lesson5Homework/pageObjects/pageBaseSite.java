package Lesson5Homework.pageObjects;

import org.openqa.selenium.By;

public class pageBaseSite {

    By pathToPresenceBaseSite = By.id("wrapper");
    public By getPathToPresenceBaseSite() {
        return pathToPresenceBaseSite;
    }

    By pathToMobileLogo = By.id("_mobile_logo");
    public By getPathToMobileLogo() {return pathToMobileLogo; }

    By pathAllProductsButton = By.xpath("//*[@id='content']/section/a");
    public By getPathAllProductsButton() {return pathAllProductsButton; }

    By pathToAllProductsOnPage = By.xpath("//*[@id='js-product-list']/div[1]/article");
    public By getPathToAllProductsOnPage() {return pathToAllProductsOnPage; }

    By pathToAddToCartButton = By.xpath("//*[@id='add-to-cart-or-refresh']/div[2]/div[1]/div[2]/button");
    public By getPathToAddToCartButton() {return pathToAddToCartButton; }

    By pathToContinueToRegister = By.cssSelector(".modal-body a");
    public By getPathToContinueToRegister() {return pathToContinueToRegister; }

    By pathToProductName = By.xpath("//*/h1"); // Имя товара
    public By getPathToProductName() {return pathToProductName; }

    By pathToPrice = By.className("current-price");
    public By getPathToPrice() {
        return pathToPrice;
    }

    By pathToProductDetailsTab = By.linkText("Подробнее о товаре");
    public By getPathToProductDetailsTab() {return pathToProductDetailsTab; }

    By pathToAvailableProducts = By.className("product-quantities>span");
    public By getPathToAvailableProducts() {return pathToAvailableProducts; }

}
