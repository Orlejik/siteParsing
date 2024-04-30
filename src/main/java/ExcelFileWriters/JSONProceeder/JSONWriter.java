package ExcelFileWriters.JSONProceeder;

import WebPages.ConfigProvider.ConfigProvider;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.core.JsonParser.Feature;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import static ExcelFileWriters.JSONProceeder.ReadJsonFile.readJsonFile;

public class JSONWriter {

    public static void writeMapToJSON(Map<String, Map<String, String>> hasmap, String filePath){
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(Feature.AUTO_CLOSE_SOURCE, true);
        ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();
        File file = new File(filePath);
        try {

            if(!file.exists()){
                file.createNewFile();
                writeMapToJSON(hasmap, filePath);
            }else{
                Map<String, Map<String, String>> existingJSONContent = readJsonFile(ConfigProvider.jsonFoleForData);
                if(!isConflictPersists(existingJSONContent, hasmap)){
                    existingJSONContent.putAll(hasmap);
                    writer.writeValue(file, existingJSONContent);
                }else{
                    writer.writeValue(file, existingJSONContent);
                }

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private static boolean isConflictPersists(Map<String, Map<String, String>> existingMap,Map<String, Map<String, String>> newMap){
        for(String newOuterKey : newMap.keySet()){
            if(existingMap.containsKey(newOuterKey)){
                Map<String, String> newInnerMap = newMap.get(newOuterKey);
                Map<String, String> existingInnerMap = existingMap.get(newOuterKey);
                for(String newInnerKey : newInnerMap.keySet()){
                    if(existingInnerMap.containsKey(newInnerKey)){
                        return true;
                    }
                }
            }
        }
        return false;
    }


}
