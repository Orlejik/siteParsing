//package WebPages.Pages.MainPage;
//
//import WebPages.ConfigProvider.ConfigProvider;
//import WebPages.Core.BaseSeleniumPage;
//import WebPages.Pages.NotificationsPage.NotificationsPage;
//import org.junit.Assert;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.time.Duration;
//
//public class MainPage extends BaseSeleniumPage {
//
//    JavascriptExecutor js = (JavascriptExecutor) driver;
//
//    public MainPage() {
//        PageFactory.initElements(driver, this);
//    }
//
//    Actions action = new Actions(driver);
//    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//    String notifications = null;
//
//    public MainPage checkNewAnn() throws InterruptedException {
//        wait.until(WebDriver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
//        action.moveByOffset(ConfigProvider.offSetX, ConfigProvider.OffSetY)
//                .click()
//                .build()
//                .perform();
//
//        Thread.sleep(3000);
//        String linkValue = (String) js.executeScript("return document.getElementById('topbar-notifications').src");
//        notifications = linkValue;
//
//        if (!linkValue.isEmpty()) {
//            Assert.assertTrue(true);
//        } else {
//            checkNewAnn();
//        }
//
//        return this;
//    }
//
//    public String getNotifications(){return notifications;}
//
//    public NotificationsPage notificationsPage(){
//        System.out.printf("this is from notification page : %s",notifications);
//        return new NotificationsPage(notifications);
//    }
//}
