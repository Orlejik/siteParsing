//package WebPages.Pages.AuthenticationPage;
//
//import WebPages.ConfigProvider.ConfigProvider;
//import WebPages.Core.BaseSeleniumPage;
//import WebPages.Pages.MainPage.MainPage;
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.time.Duration;
//
//public class AuthPage extends BaseSeleniumPage {
//
//    WebElement nameInput = driver.findElement(By.xpath("/html/body/div/div[1]/form/div[2]/input"));
//    WebElement passwordInput = driver.findElement(By.xpath("/html/body/div/div[1]/form/div[3]/input"));
//    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//
//    public AuthPage(){
//        driver.get(ConfigProvider.URL);
//        PageFactory.initElements(driver, this);
//    }
//
//    public AuthPage authenticate(String username, String password){
//        wait.until(WebDriver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
//        nameInput.sendKeys(username);
//        passwordInput.sendKeys(password);
//
//        return this;
//    }
//
//    public MainPage mainPage(){return new MainPage();}
//}
