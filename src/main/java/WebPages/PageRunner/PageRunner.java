package WebPages.PageRunner;

import WebPages.ConfigProvider.ConfigProvider;
import WebPages.Core.BaseSeleniumTest;
import WebPages.Pages.AuthenticationPage.AuthPage;
import WebPages.Pages.MainPage.MainPage;
import WebPages.Pages.NotificationsPage.NotificationsPage;

public class PageRunner extends BaseSeleniumTest {

    public String username = ConfigProvider.USERNAME;
    public String password = ConfigProvider.PASSWORD;

    AuthPage auth = new AuthPage();

    MainPage mainPage;

    {
        try {
            mainPage = auth
                    .authenticate(username, password)
                    .mainPage()
                    .checkNewAnn();
            NotificationsPage notificationPage = new NotificationsPage(mainPage.getNotifications());//TODO : uncomment the line for start the script from scratch;

            notificationPage.notificationsPage();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
