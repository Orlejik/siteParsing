package WebPages.Pages.NotificationsPage;

import WebPages.Core.BaseSeleniumPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class NotificationsPage extends BaseSeleniumPage {

    public NotificationsPage(String notificationValue) {
        driver.get(notificationValue);
        PageFactory.initElements(driver, this);
    }

    public static List<WebElement> webElementList() {
        return driver.findElements(By.xpath("//*[@id=\"js-notifications-list\"]/div"));
    }

    List<String> newItemLinks = new ArrayList<>();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));


    public void notificationsPage() throws InterruptedException{
        while(true){
            driver.navigate().refresh();
            ((JavascriptExecutor) driver).executeScript("location.reload()");
            List<WebElement> divElements = driver.findElements(By.xpath("//*[@id=\"js-notifications-list\"]/div"));
            for (WebElement notificationUnit : divElements) {
                if (notificationUnit.getAttribute("class").contains("notifications-list__item is-unread")) {
                    newItemLinks.add(notificationUnit.findElement(By.tagName("a")).getAttribute("href"));
                }
                System.out.println(notificationUnit.getAttribute("class"));
            }
            System.out.println(newItemLinks);

            Thread.sleep(10000);
        }
    }

    public List<String> getNewItemLinks() {
        return newItemLinks;
    }
}
