package WebPages.Core;

import org.openqa.selenium.WebDriver;

abstract public class BaseSeleniumPage {
    protected static WebDriver driver;

    public static void setWebDriver(WebDriver webDriver){
        driver = webDriver;
    }
}
