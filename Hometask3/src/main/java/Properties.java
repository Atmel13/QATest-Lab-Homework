import org.openqa.selenium.remote.BrowserType;

public class Properties {

    private static final String DEFAULT_BASE_URL = "http://prestashop-automation.qatestlab.com.ua/";
    private static final String DEFAULT_BASE_ADMIN_URL = "http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/";
    private static final String DEFAULT_BROWSER = BrowserType.CHROME;

    public static String getBaseUrl() {
        return System.getProperty(environmentVariables.BASE_URL.toString(), DEFAULT_BASE_URL);
    }

    public static String getBaseAdminUrl() {
        return System.getProperty(environmentVariables.BASE_ADMIN_URL.toString(), DEFAULT_BASE_ADMIN_URL);
    }

    public static String getBrowser() {
        return System.getProperty(environmentVariables.BROWSER.toString(), DEFAULT_BROWSER);
    }
}

enum environmentVariables {

    BASE_URL("env.url"),
    BASE_ADMIN_URL("env.admin.url"),
    BROWSER("browser");

    private String value;
    environmentVariables(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}