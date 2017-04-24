package Lesson5Homework.pageObjects;

import org.openqa.selenium.By;

public class pagePersonalData {

    By pathToPersonalDataForm = By.className("content");
    public By getPathToPersonalDataForm() {return pathToPersonalDataForm; }

    By pathToNameField = By.name("firstname");
    public By getPathToNameField() {return pathToNameField; }

    By pathToSurnameField = By.name("lastname");
    public By getPathToSurnameField() {return pathToSurnameField; }

    By pathToEmailField = By.name("email");
    public By getPathToEmailField() {return pathToEmailField; }

    By pathToContinueButton = By.cssSelector("#customer-form > footer > button");
    public By getPathToContinueButton() {return pathToContinueButton; }
}
