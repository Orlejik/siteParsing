package DBConnector;

import org.bouncycastle.jcajce.provider.asymmetric.util.GOST3410Util;

import java.sql.*;

public class JDBConnector {

    static String connectionUrl = "jdbc:mysql://10.20.192.5:3306/siteparsing";

    public static Connection jDBConnector() {

        try {
            Connection conn = DriverManager.getConnection(connectionUrl, "root", "root");
            System.out.println("Connection established!");
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
