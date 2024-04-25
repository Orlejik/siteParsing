package WebPages.ConfigProvider;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {

    Config config = readConfig();

    static Config readConfig(){
        return ConfigFactory.systemProperties().hasPath("TestProfile")
                ? ConfigFactory.load(ConfigFactory.systemProperties().getString("TestProfile"))
                : ConfigFactory.load("src/main/java/WebPages/Resources/app.conf");
    }

    final String URL = readConfig().getString("url");
    final String USERNAME = readConfig().getString("UserData.login");
    final String PASSWORD = readConfig().getString("UserData.passwd");

    final int offSetX = 1500;
    final int OffSetY = 30;
}
