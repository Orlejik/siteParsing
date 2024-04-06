package Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chromium.HasCdp;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class SeleniumOpenPage {

    public static void openPage() throws InterruptedException {


        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--disable-blink-features=AutomationControlled");
        edgeOptions.setExperimentalOption("excludeSwitches", "enable-automation");
        edgeOptions.setExperimentalOption("useAutomationExtension", false);

        Map<String, Object> cdpOptions = new HashMap<String, Object>();
        cdpOptions.put("source", "const newProto = navigator.__proto__\ndelete newProto.webdriver\nnavigator.__proto__ = newProto");

        WebDriver driver = new EdgeDriver();

        String userAgent = (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;");
        System.out.println(userAgent);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        ((HasCdp) driver).executeCdpCommand("Page.addScriptToEvaluateOnNewDocument", cdpOptions);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        //driver.manage().deleteAllCookies();

        //driver.get("https://bot.sannysoft.com/");
        driver.get("https://999.md/ro/86653765");

        if (driver.toString().contains("(null)")) {
            System.out.println("Detected!");
        } else {
            System.out.println("NOT Detected!");
        }


        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        js.executeScript("let elem = document.evaluate(\"//*[@id='container']/div/section/aside/div[1]/div/div[4]/div[2]/div/div/div\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue; elem.click();");
        Thread.sleep(3000);

        String numb = driver.findElement(By.xpath("//*[@id=\"container\"]/div/section/aside/div[1]/div/div[4]/div[2]/div/dl/dd/ul/li/a/strong")).getText();
        String announcementHeader = driver.findElement(By.xpath("//*[@id=\"container\"]/div/section/header/h1")).getText();
        String onSiteFrom = driver.findElement(By.xpath("//*[@id=\"container\"]/div/section/aside/div[1]/div/dl/dd/span")).getText();
        String announcementOwner = driver.findElement(By.xpath("//*[@id=\"container\"]/div/section/aside/div[1]/div/dl/dd/a")).getText();
        String priceInAnnouncement = driver.findElement(By.xpath("//*[@id=\"container\"]/div/section/aside/div[1]/div/div[4]/div[1]/ul[1]/li/span[1]")).getText();
        String announcementRegion = driver.findElement(By.xpath("//*[@id=\"js-item-page\"]/div[1]/div[7]/div/div/dl[1]/dd[2]")).getText();

        System.out.println(numb);
        System.out.println(announcementHeader);
        System.out.println(onSiteFrom);
        System.out.println(announcementOwner);
        System.out.println(priceInAnnouncement);
        System.out.println(announcementRegion);

        driver.quit();
    }
}
