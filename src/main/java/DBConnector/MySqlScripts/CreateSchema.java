package DBConnector.MySqlScripts;

import DBConnector.JDBConnector;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateSchema {
    private  Connection connection = JDBConnector.jDBConnector();

    public Connection getConnection() {
        return connection;
    }

    public void createDBandTable(String dbName){

        String createDBQuery = "CREATE DATABASE IF NOT EXISTS "+dbName;

        try {
            Statement statement =getConnection().createStatement();
            statement.executeQuery(createDBQuery);

            System.out.println("======== DataBase Created =======");

            statement.close();
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
