package Lesson5Homework.pageObjects;

import org.openqa.selenium.By;

public class pageOrderDone {

    By pathToOrderIsApproved = By.cssSelector(".h1.card-title");
    public By getPathToOrderIsApproved() {return pathToOrderIsApproved; }

    By pathToPrice = By.cssSelector(".col-xs-5.text-sm-right.text-xs-left");
    public By getPathToPrice() {return pathToPrice; }

    By pathToProductName = By.cssSelector(".col-sm-4.col-xs-9.details>span");
    public By getPathToProductName() {return pathToProductName; }

    By ptahToQuantityOfItems = By.cssSelector("");
    public By getPtahToQuantityOfItems() {return ptahToQuantityOfItems; }

    By pathToQuantityTypesOfProducts = By.className("order-line");
    public By getPathToQuantityTypesOfProducts() {return pathToQuantityTypesOfProducts; }
}
