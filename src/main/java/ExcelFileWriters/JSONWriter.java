package ExcelFileWriters;

import WebPages.ConfigProvider.ConfigProvider;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JSONWriter {

    public static void writeMapToJSON(Map<String, String> hasmap){
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(ConfigProvider.jsonFoleForData), hasmap);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
