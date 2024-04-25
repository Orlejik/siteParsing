package FileWatcher;

import org.apache.commons.lang3.StringUtils;

import java.nio.file.WatchService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.*;

import static Helpers.WriteToFile.writeInFile;

public class FileWatcher {
    public static void watchFile(String directoryPath, String fileName) {
        try {
            WatchService watchService = FileSystems.getDefault().newWatchService();
            Path directory = Paths.get(directoryPath);
            directory.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);

            String previousContent = readContent(directory.resolve(fileName).toString());

            while (true) {
                WatchKey key = watchService.take();
                for (WatchEvent<?> event : key.pollEvents()) {
                    WatchEvent.Kind<?> kind = event.kind();
                    Path filePath = (Path) event.context();

                    if (kind == StandardWatchEventKinds.ENTRY_MODIFY && filePath.toString().equals(fileName)) {
                        String currentContent = readContent(directory.resolve(filePath).toString());
                        if (!currentContent.equals(previousContent)) {
                            String diff = findDifferences(previousContent, currentContent);
                            if (!diff.isEmpty()) {
                                Thread.sleep(1000);
                                System.out.print(diff);
                                writeInFile("C:\\Users\\artiom.oriol\\Documents\\JavaMITests\\newWebDriverTests\\src\\main\\resources\\newChangesFile.txt", diff);
                                previousContent = currentContent;
                            }
                        }
                    }
                }
                key.reset();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static String readContent(String filePath) throws IOException {

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            return content.toString();
        }
    }

    private static String findDifferences(String previousContent, String currentContent) {
        //TODO to implement the logic for comparing the current with previous content
        return StringUtils.difference(previousContent, currentContent);
    }
}
