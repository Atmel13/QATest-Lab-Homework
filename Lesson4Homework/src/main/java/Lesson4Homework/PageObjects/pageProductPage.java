package Lesson4Homework.PageObjects;

import org.openqa.selenium.By;

public class pageProductPage {

    By pathInfoAboutProduct = By.id("main");

    public By getPathInfoAboutProduct() {
        return pathInfoAboutProduct;
    }

    By pathToProductName = By.xpath("//*/h1"); // Имя товара

    public By getPathToProductName() {
        return pathToProductName;
    }

    By pathToPrice = By.className("current-price");

    public By getPathToPrice() {
        return pathToPrice;
    }

    By pathToQuantity = By.xpath("//*[@id='product-details']//span");

    public By getPathToQuantity() {
        return pathToQuantity;
    }

}
