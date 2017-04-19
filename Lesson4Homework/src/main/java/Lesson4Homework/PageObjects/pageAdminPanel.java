package Lesson4Homework.PageObjects;

import org.openqa.selenium.By;

public class pageAdminPanel {

    By pathToAdminPanel = By.id("nav-sidebar");

    public By getPathToAdminPanel() {
        return pathToAdminPanel;
    }

    By pathToCatalog = By.id("subtab-AdminCatalog");

    public By getPathToCatalog() {
        return pathToCatalog;
    }

    By pathToCatalogGoods = By.xpath("//*[@id='product_catalog_list']/div[2]/div/table/tbody");

    public By getPathToCatalogGoods() {
        return pathToCatalogGoods;
    }

    By pathToCreateNewGood = By.xpath("//*[@id='page-header-desc-configuration-add']/span[contains(text(),'Новый товар')]");

    public By getPathToCreateNewGood() {
        return pathToCreateNewGood;
    }

    By pathToCreationForm = By.id("form");

    public By getPathToCreationForm() {
        return pathToCreationForm;
    }

    By pathToProductNameTextField = By.id("form_step1_name_1");

    public By getPathToProductNameTextField() {
        return pathToProductNameTextField;
    }

    By pathToProductQuantityTextField = By.id("form_step1_qty_0_shortcut");

    public By getPathToProductQuantityTextField() {
        return pathToProductQuantityTextField;
    }

    By pathToProductPriceTextField = By.id("form_step1_price_shortcut");

    public By getPathToProductPriceTextField() {
        return pathToProductPriceTextField;
    }

    By pathToSwitcher = By.className("switch-input");

    public By getPathToSwitcher() {
        return pathToSwitcher;
    }

    By pathToPopUpMessage = By.className("growl-message");

    public By getPathToPopUpMessage() {
        return pathToPopUpMessage;
    }

    By pathToClosePopUpMessage = By.className("growl-close");

    public By getPathToClosePopUpMessage() {
        return pathToClosePopUpMessage;
    }

    By pathToSaveProduct = By.id("submit");

    public By getPathToSaveProduct() {
        return pathToSaveProduct;
    }

}
