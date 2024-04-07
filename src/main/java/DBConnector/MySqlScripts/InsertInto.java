package DBConnector.MySqlScripts;

import DBConnector.JDBConnector;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertInto {

    public static void insertInto(String str){

        Connection connector = JDBConnector.jDBConnector();

        String sqlQuery = "INSERT INTO sitelinks (link) VALUES ('" + str + "')";

        try {
            Statement statement =connector.createStatement();
            int rowAffected = statement.executeUpdate(sqlQuery);

            System.out.printf("%d row(s) inserted successfully", rowAffected);

            statement.close();
            connector.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
