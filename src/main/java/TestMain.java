import org.apache.poi.ss.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestMain {
    public static void writeData(Map<String, Object> data, String filePath) throws IOException {
        // Create a new Workbook
        Workbook workbook = WorkbookFactory.create(true); // true indicates create .xlsx format

        // Create a Sheet
        Sheet sheet = workbook.createSheet("Data");

        // Create a header row
        Row headerRow = sheet.createRow(0);
        int cellNum = 0;
        for (String key : data.keySet()) {
            Cell cell = headerRow.createCell(cellNum++);
            cell.setCellValue(key);
        }

        // Create data rows
        int rowNum = 1;
        Row row = sheet.createRow(rowNum++);
        for (Object value : data.values()) {
            Cell cell = row.createCell(cellNum++);
            if (value instanceof String) {
                cell.setCellValue((String) value);
            } else if (value instanceof Boolean) {
                cell.setCellValue((Boolean) value);
            } else if (value instanceof Integer || value instanceof Double || value instanceof Float) {
                cell.setCellValue(Double.parseDouble(value.toString()));
            } else {
                cell.setCellValue(value.toString());
            }
        }

        // Resize columns to fit the content
        for (int i = 0; i < cellNum; i++) {
            sheet.autoSizeColumn(i);
        }

        // Write the workbook to a file
        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
        }

        // Close the workbook
        workbook.close();
    }

    public static void main(String[] args) {
        // Example data
        Map<String, Object> data = Map.of(
                "Name", "John Doe",
                "Age", 30,
                "IsEmployed", true
        );


        // Output file path
        String filePath = "output.xlsx";

        // Write data to Excel file
        try {
            writeData(data, filePath);
            System.out.println("Data has been written to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//
//        System.out.println(clearString("Pe site din noiembrie 2014", ' ', 10));
//    }
//
//    static String clearString(String str, char character, int start){
//        int delimiterIndex = str.indexOf(character);
//
//        if (delimiterIndex != -1) {
//            String cutString = str.substring(delimiterIndex+start);
//
//            return cutString;
//
//        } else {
//            return "null!";
//        }
//    }
}


