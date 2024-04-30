package WebPages.ConfigProvider;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {

    Config config = readConfig();

    static Config readConfig(){
        return ConfigFactory.systemProperties().hasPath("TestProfile")
                ? ConfigFactory.load(ConfigFactory.systemProperties().getString("TestProfile"))
                : ConfigFactory.load("application.conf");
    }

    final String URL = readConfig().getString("url");
    final String USERNAME = readConfig().getString("UserData.login");
    final String PASSWORD = readConfig().getString("UserData.passwd");

    final int offSetX = readConfig().getInt("Coordinates.offSetX");
    final int OffSetY = readConfig().getInt("Coordinates.offSetY");

    final String filePathNewLinks = readConfig().getString("Files.filePathToWrite");
    final String excelFileForData = readConfig().getString("Files.ExcelFileToWrite");
    final String jsonFoleForData = readConfig().getString("Files.JSONFileToWrite");
}
