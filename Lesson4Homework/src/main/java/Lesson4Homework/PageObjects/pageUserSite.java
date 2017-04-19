package Lesson4Homework.PageObjects;

import org.openqa.selenium.By;

public class pageUserSite {

    By pathAllProductsButton = By.xpath("//*[@id='content']/section/a");

    public By getPathAllProductsButton() {
        return pathAllProductsButton;
    }

    By pathToPresenceBaseSite = By.id("wrapper");

    public By getPathToPresenceBaseSite() {
        return pathToPresenceBaseSite;
    }

}
