//package WebPages.Core;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.junit.Before;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.edge.EdgeOptions;
//
//abstract public class BaseSeleniumTest {
//    protected static WebDriver driver;
//
////    @Before
//    public static void setup(){
//        EdgeOptions options = new EdgeOptions();
//        options.addArguments("--start-maximized","--window-size=1920,1080");
//        options.addArguments("--headless","--headless=new");
//        options.addArguments("--headless=edge","--ignore-certificate-errors");
//        options.addArguments("--disable-site-isolation-trials","--disable-extensions","--disable-dev-shm-usage");
//        options.addArguments("--log-level=3");
//        WebDriverManager.edgedriver().setup();
//        driver = new EdgeDriver();
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        driver.manage().window().maximize();
//        driver.manage().deleteAllCookies();
//        js.executeScript(" Object.defineProperty(navigator, 'webdriver', {get: () => false,});");
//        js.executeScript("");
//        js.executeScript("Object.defineProperty(navigator, 'userAgent', {get: () => 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.110 Safari/537.36',}); ");
//        BaseSeleniumPage.setWebDriver(driver);
//    }
//}
