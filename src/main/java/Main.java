
import FileWatcher.FileWatcher;

import java.io.IOException;
import java.util.ArrayList;


import static Helpers.CutString.clearString;
import static WebPageProceeder.JSoupParser.parseWebPage;
import static WebPages.NeSelenium.PagesProceeder.pagesProceeder;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
//        pagesProceeder();
//        ArrayList<String> linksList = new ArrayList<>();
//        linksList = (ArrayList<String>) FileWatcher.watchFile("C:\\Users\\artiom.oriol\\Documents\\JavaMITests\\siteParsing\\src\\main\\resources", "newLinks.xtx");
//
//        for(String link : linksList){
//
//        }

        parseWebPage("https://999.md/ro/86929198");

//        Thread newAnnouncementsThrad = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    pagesProceeder();
//                } catch (InterruptedException | IOException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        });
//        Thread watchFileChangesThread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                ArrayList<String> linksList = new ArrayList<>();
//                linksList = (ArrayList<String>) FileWatcher.watchFile("C:\\Users\\artiom.oriol\\Documents\\JavaMITests\\siteParsing\\src\\main\\resources","newLinks.xtx");
//            }
//        });
//
//        try{
//            newAnnouncementsThrad.join();
//            watchFileChangesThread.join();
//        }catch(InterruptedException e){
//            e.printStackTrace();
//        }


//        try {
//            Map<String, Object> parsedPage = JSoupParser.parseWebPage("https://999.md/ru/89525111");
//
//
//            for (Map.Entry<String, Object> entry : parsedPage.entrySet()) {
//                System.out.println(entry.getKey() + " : " + entry.getValue());
//            }
//
//        } catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }


    }
}
