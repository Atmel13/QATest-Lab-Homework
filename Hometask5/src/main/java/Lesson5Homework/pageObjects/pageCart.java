package Lesson5Homework.pageObjects;

import org.openqa.selenium.By;

public class pageCart {

    By pathToProductNameCart = By.cssSelector("a.label:nth-child(1)");
    public By getPathToProductNameCart() {return pathToProductNameCart; }

    By pathToProductPriceCart = By.cssSelector("span.value:nth-child(1)");
    public By getPathToProductPriceCart() {return pathToProductPriceCart; }

    By pathToCreateOrder = By.cssSelector("a.btn");
    public By getPathToCreateOrder() {return pathToCreateOrder; }

    By pathToQuantityTypesOfProdoucts = By.className("cart-item");
    public By getPathToQuantityTypesOfProdoucts() {return pathToQuantityTypesOfProdoucts; }

    By pathToAddressField = By.name("address1");
    public By getPathToAddressField() {return pathToAddressField; }

    By pathToPostCodeField = By.name("postcode");
    public By getPathToCodeIndexField() {return pathToPostCodeField; }

    By pathToCityField = By.name("city");
    public By getPathToCityField() {return pathToCityField; }

    By pathToContinueButtonAddress = By.xpath("//*[@id='delivery-address']//button");
    public By getPathToContinueButtonAddress() {return pathToContinueButtonAddress; }

    By pathToContinueButtonDelivery = By.xpath("//*[@id='js-delivery']/button");
    public By getPathToContinueButtonDelivery() {return pathToContinueButtonDelivery; }

    By pathToPaymentType = By.id("payment-option-1");
    public By getPathToPaymentType() {return pathToPaymentType; }

    By pathToIAgreecheckbox = By.id("conditions_to_approve[terms-and-conditions]");
    public By getPathToIAgreecheckbox() {return pathToIAgreecheckbox; }

    By PathToCrateOrderWithPayment = By.xpath("//*[@id='payment-confirmation']//button");
    public By getPathToCrateOrderWithPayment() {return PathToCrateOrderWithPayment; }

}
