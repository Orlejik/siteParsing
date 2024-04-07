import DBConnector.JDBConnector;
import DBConnector.MySqlScripts.InsertInto;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        for (int i = 10000000; i <= 99999999; i++) {
            InsertInto.insertInto("https://999.md/ro/" + i);
        }


        new JDBConnector();


    }
}
