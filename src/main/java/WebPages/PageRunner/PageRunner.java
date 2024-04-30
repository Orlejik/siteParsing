//package WebPages.PageRunner;
//
//import WebPages.ConfigProvider.ConfigProvider;
//import WebPages.Core.BaseSeleniumTest;
//import WebPages.Pages.AuthenticationPage.AuthPage;
//import WebPages.Pages.MainPage.MainPage;
//import WebPages.Pages.NotificationsPage.NotificationsPage;
//import org.junit.Test;
//
//import java.io.IOException;
//
//
////public class PageRunner extends BaseSeleniumTest implements Runnable {
//public class PageRunner extends BaseSeleniumTest {
//
//    public static String username = ConfigProvider.USERNAME;
//    public static String password = ConfigProvider.PASSWORD;
//
//
////    @Override
////@Test
//    public static void run() throws InterruptedException {
//
//        BaseSeleniumTest.setup();
//        Thread.sleep(5000);
//        AuthPage auth = new AuthPage();
//
//        MainPage mainPage;
//
//        try {
//            mainPage = auth
//                    .authenticate(username, password)
//                    .mainPage()
//                    .checkNewAnn();
//            NotificationsPage notificationPage = new NotificationsPage(mainPage.getNotifications());//TODO : uncomment the line for start the script from scratch;
//
//            notificationPage.notificationsPage();
//        } catch (InterruptedException | IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
