import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class pageAdminPanel {



    By pathToAdminAvatar = By.id("employee_infos");
    public By getPathToAdminAvatar() {
        return pathToAdminAvatar;
    }

    By pathToExitButton = By.id("header_logout");
    public By getPathToExitButton() {
        return pathToExitButton;
    }

    By pathToDashboard = By.id("tab-AdminDashboard");
    public By getPathToDashboard() { return pathToDashboard; }

    By pathToOrders = By.id("subtab-AdminParentOrders");
    public By getPathToOrders() { return pathToOrders; }

    By pathToCatalog = By.id("subtab-AdminCatalog");
    public By getPathToCatalog() { return pathToCatalog; }

    By pathToClients = By.xpath("/html/body/nav/ul/li[5]");
    public By getPathToClients() { return pathToClients; }

    By pathToCusromerService = By.id("subtab-AdminParentCustomerThreads");
    public By getPathToCusromerService() { return pathToCusromerService; }

    By pathToStatistic = By.id("subtab-AdminStats");
    public By getPathToStatistic() { return pathToStatistic; }

    By pathToModules = By.id("subtab-AdminParentModulesSf");
    public By getPathToModules() { return pathToModules; }

    By pathToDesign = By.xpath("/html/body/nav/ul/li[10]");
    public By getPathToDesign() { return pathToDesign; }

    By pathToDelivery = By.id("subtab-AdminParentShipping");
    public By getPathToDelivery() { return pathToDelivery; }

    By pathToTypePayment = By.id("subtab-AdminParentPayment");
    public By getPathToTypePayment() { return pathToTypePayment; }

    By pathToInternational = By.id("subtab-AdminInternational");
    public By getPathToInternational() { return pathToInternational; }

    By pathToShopParameters = By.id("subtab-ShopParameters");
    public By getPathToShopParameters() { return pathToShopParameters; }

    By pathToConfiguration = By.id("subtab-AdminAdvancedParameters");
    public By getPathToConfiguration() { return pathToConfiguration; }


    By pathToPageHead = By.xpath("//*/h2"); // Имя страницы
    public By getPathToPageHead() { return pathToPageHead ; }

}
