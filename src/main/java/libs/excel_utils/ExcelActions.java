package libs.excel_utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.InputStream;

public class ExcelActions {

    static String filePath = "src/main/java/files/creds.xlsx";

    public static String setEmail(String email) {
        try {

            InputStream excelFileLocation = new FileInputStream(filePath);

            XSSFWorkbook workbook = new XSSFWorkbook(excelFileLocation);
            XSSFSheet sheet = workbook.getSheetAt(0);

            Row row1 = sheet.getRow(1);
            Cell cellR1C0 = row1.getCell(0);
            email = cellR1C0.toString();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return email;
    }

    public static String setPassword(String password) {
        try {

            InputStream excelFileLocation = new FileInputStream(filePath);

            XSSFWorkbook workbook = new XSSFWorkbook(excelFileLocation);
            XSSFSheet sheet = workbook.getSheetAt(0);

            Row row1 = sheet.getRow(1);
            Cell cellR1C1 = row1.getCell(1);
            password = cellR1C1.toString();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return password;
    }


}
