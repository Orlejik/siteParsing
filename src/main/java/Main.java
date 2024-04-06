import Helpers.WriteToFile;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        for (int i = 34254607; i <= 99999999; i++) {
            WriteToFile.writeToFile("https://999.md/ro/" + i);
        }
        System.out.println("Finished!");

//        SeleniumOpenPage.openPage();

//        String regEx = "^.*tel:+373.*$";
//
//        Document doc = Jsoup.connect("https://999.md/ro/86367818")
//                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36 Edg/123.0.0.0")
//                .get();
//        Elements aElems = doc.getElementsByTag("a");
//
//        for(Element elem : aElems){
//            if(CheckString.check(elem.attr("href"), "tel:+373")){
//                System.out.println(elem);
//            }
//        }


    }
}
