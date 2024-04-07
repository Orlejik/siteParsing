package DBConnector.MySqlScripts;

import DBConnector.JDBConnector;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

    Connection connection = null;

    public void createTableinDB(String tablename){
        connection = JDBConnector.jDBConnector();

        String createTableQuery = "CREATE TABLE IF NOT EXISTS "+tablename+" (\n" +
                "    siteID NOT NULL AUTO_INCREMENT,\n" +
                "    announc_type VARCHAR(255),\n" +
                "    announc_group VARCHAR(255),\n" +
                "    announc_sub_group VARCHAR(255),\n" +
                "    announc_available BOOLEAN,\n" +
                "    announc_date VARCHAR(255),\n" +
                "    announce_title VARCHAR(255)\n" +
                "    announce_price VARCHAR(255)\n" +
                "    announce_region VARCHAR(255)\n" +
                "    announce_owner VARCHAR(255)\n" +
                "    owner_on_site_from VARCHAR(255)\n" +
                "    owner_phone VARCHAR(255)\n" +
                "    PRIMARY KEY (siteID)\n"+
                ");";
        try {
            Statement statement = connection.createStatement();
            statement.executeQuery(createTableQuery);

            System.out.println("======== Table Created =======");

            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
