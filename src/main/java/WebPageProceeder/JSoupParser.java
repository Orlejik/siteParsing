package WebPageProceeder;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import Helpers.CheckString;
import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

public class JSoupParser {

    public static Map<String, Object> parseWebPage(String linkToParse) throws IOException {

        Map<String, Object> webPageInfo = new HashMap<>();

        String regEx = "^.*tel:+373.*$";

        Document doc = Jsoup.connect(linkToParse)
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36 Edg/123.0.0.0")
                .get();
        Elements phoneNumber = doc.selectXpath("//div[@class='col1']/p");
        Elements onSiteFrom = doc.selectXpath("someXpath");
        Elements ownerName = doc.selectXpath("someXpath");
        Elements goodsPrice = doc.selectXpath("someXpath");
        Elements goodsTitle = doc.selectXpath("someXpath");
        Elements announcRegion = doc.selectXpath("someXpath");
        Elements announcUpdeted = doc.selectXpath("someXpath");
        Elements announcGroup = doc.selectXpath("someXpath");
        Elements announcSubGroup = doc.selectXpath("someXpath");
        Elements announcType = doc.selectXpath("someXpath");

        Elements announcNotAvailableMSG = doc.selectXpath("//*[@id=\"container\"]/div/div[2]");

        if(announcNotAvailableMSG.text().contains("Anunț șters.")){
            webPageInfo.put("Announcement is Available", false);
            webPageInfo.put("announce_available", false);
        }




        return webPageInfo;

    }


}
