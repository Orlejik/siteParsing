import DBConnector.JDBConnector;
import DBConnector.MySqlScripts.InsertInto;
import WebPageProceeder.JSoupParser;

import java.io.IOException;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

//        for (int i = 10000000; i <= 99999999; i++) {
//            InsertInto.insertInto("https://999.md/ro/" + i);
//        }


//        new JDBConnector();


try{
    Map<String, Object> parsedPage = JSoupParser.parseWebPage("https://999.md/ru/89525111");


    for(Map.Entry<String, Object> entry : parsedPage.entrySet()){
        System.out.println(entry.getKey()+" : "+ entry.getValue());
    }

}catch(IOException ex){
    System.out.println(ex.getMessage());
}



    }
}
