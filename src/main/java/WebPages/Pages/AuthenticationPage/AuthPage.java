package WebPages.Pages.AuthenticationPage;

import WebPages.ConfigProvider.ConfigProvider;
import WebPages.Core.BaseSeleniumPage;
import WebPages.Pages.MainPage.MainPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthPage extends BaseSeleniumPage {
    @FindBy(xpath = "/html/body/div/div[1]/form/div[2]/input")
    WebElement nameInput;
    @FindBy(xpath = "/html/body/div/div[1]/form/div[3]/input")
    WebElement passwordInput;

    public AuthPage(){
        driver.get(ConfigProvider.URL);
        PageFactory.initElements(driver, this);
    }

    public AuthPage authenticate(String username, String password){
        nameInput.sendKeys(username);
        passwordInput.sendKeys(password);

        return this;
    }

    public MainPage mainPage(){return new MainPage();}
}
