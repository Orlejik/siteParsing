
package Helpers;

import java.io.*;

public class WriteToFile {
    public static void writeInFile(String filePath, String lineToWriteInFile) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
            newFile(file, lineToWriteInFile);
        }
    }

    protected static void newFile(File file, String content) throws IOException {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(content);
            writer.flush();
        }
    }
}
