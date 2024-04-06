
package Helpers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteToFile {
    public static void writeToFile(String str) throws IOException {
        String filePath = "C:\\Users\\artiom.oriol\\Documents\\JavaMITests\\siteParsing\\src\\main\\java\\Files\\links.txt";

//       if(!filePath.)
//        file = new File("C:\\Users\\artiom.oriol\\Documents\\JavaMITests\\siteParsing\\src\\main\\java\\Files\\links.txt");
        String writtenString = str + "\n";
        FileOutputStream fileOS = new FileOutputStream(filePath, true);
        fileOS.write(writtenString.getBytes());

        fileOS.close();

    }
}
