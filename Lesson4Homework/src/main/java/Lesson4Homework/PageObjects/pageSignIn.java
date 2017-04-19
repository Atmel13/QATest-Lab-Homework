package Lesson4Homework.PageObjects;

import org.openqa.selenium.By;

public class pageSignIn {

    By pathToEmailField = By.id("email");

    public By getPathToEmailField() {
        return pathToEmailField;
    }

    By pathToPasswordField = By.id("passwd");

    public By getPathToPasswordField() {
        return pathToPasswordField;
    }

    By pathToSignInButton = By.name("submitLogin");

    public By getPathToSignInButton() {
        return pathToSignInButton;
    }
}
