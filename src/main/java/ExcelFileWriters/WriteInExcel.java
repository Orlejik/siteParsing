package ExcelFileWriters;
import org.apache.poi.ss.usermodel.Header;
import org.apache.poi.xssf.*;
import org.apache.poi.xssf.usermodel.XSSFHeaderFooterProperties;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WriteInExcel {
    public static void writeToExcelTable(Map<String, String> hashMapData, String filePath){
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet spreadSheet = workbook.createSheet("Parsed Data");

        Header header = spreadSheet.getFirstHeader();
        header.setCenter("Center First Page Header");
        header.setLeft("Left First Page Header");
        header.setRight("Right First Page Header");
        Header header2 = spreadSheet.getEvenHeader();
        header2.setCenter("Center Even Page Header");
        header2.setLeft("Left Even Page Header");
        header2.setRight("Right Even Page Header");
        Header header3 = spreadSheet.getOddHeader();
        header3.setCenter("Center Odd Page Header");
        header3.setLeft("Left Odd Page Header");
        header3.setRight("Right Odd Page Header");

        XSSFHeaderFooterProperties props = spreadSheet.getHeaderFooterProperties();
        props.setAlignWithMargins(true);
        props.setScaleWithDoc(true);
        props.removeDifferentFirst();
        props.removeDifferentOddEven();

        int rowNum = 1;

        for(HashMap.Entry entry : hashMapData.entrySet()){
            for (int j = 0; j <= hashMapData.size() ; j++) {
                XSSFRow row = spreadSheet.createRow(rowNum++);
                row.createCell(j).setCellValue((String) entry.getValue());
            }
        }

        try {
            FileOutputStream file = new FileOutputStream(filePath);
            workbook.write(file);
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
