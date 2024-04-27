package WebPages.NeSelenium;

import WebPages.ConfigProvider.ConfigProvider;
import WebPages.Core.BaseSeleniumPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static FileWriter.FileWriter.writeInFile;

public class PagesProceeder {
    protected static WebDriver driver;
    public static String username = ConfigProvider.USERNAME;
    public static String password = ConfigProvider.PASSWORD;
    public static String url = ConfigProvider.URL;

    public static void pagesProceeder() throws InterruptedException, IOException {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--start-maximized", "--window-size=1920,1080");
        options.addArguments("--headless", "--headless=new");
        options.addArguments("--headless=edge", "--ignore-certificate-errors");
        options.addArguments("--disable-site-isolation-trials", "--disable-extensions", "--disable-dev-shm-usage");
        options.addArguments("--log-level=3");
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        js.executeScript(" Object.defineProperty(navigator, 'webdriver', {get: () => false,});");
        js.executeScript("");
        js.executeScript("Object.defineProperty(navigator, 'userAgent', {get: () => 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.110 Safari/537.36',}); ");
        BaseSeleniumPage.setWebDriver(driver);

        driver.get(url);

        WebElement nameInput = driver.findElement(By.xpath("/html/body/div/div[1]/form/div[2]/input"));
        WebElement passwordInput = driver.findElement(By.xpath("/html/body/div/div[1]/form/div[3]/input"));
        nameInput.sendKeys(username);
        passwordInput.sendKeys(password, Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Actions action = new Actions(driver);
        String notifications = null;
        wait.until(WebDriver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
        action.moveByOffset(ConfigProvider.offSetX, ConfigProvider.OffSetY)
                .click()
                .build()
                .perform();
        Thread.sleep(3000);
        String linkValue = (String) js.executeScript("return document.getElementById('topbar-notifications').src");
        notifications = linkValue;

        if (!linkValue.isEmpty()) {
            Assert.assertTrue(true);
        } else {
            driver.close();
            driver.quit();
            pagesProceeder();
        }

        driver.get(notifications);

        List<String> newItemLinks = new ArrayList<>();
        while (true) {
            List<WebElement> divElements = driver.findElements(By.xpath("//*[@id=\"js-notifications-list\"]/div"));
            for (WebElement notificationUnit : divElements) {
                if (notificationUnit.getAttribute("class").contains("notifications-list__item is-unread")) {
                    newItemLinks.add(notificationUnit.findElement(By.tagName("a")).getAttribute("href"));
                    writeInFile(ConfigProvider.filePathNewLinks, notificationUnit.findElement(By.tagName("a")).getAttribute("href"));
                }
            }
            System.out.println(newItemLinks);
            Thread.sleep(10000);
            driver.navigate().refresh();
        }
    }
}
