package utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ExcelUtils {

    public static FileInputStream input;
    public static FileOutputStream output;
    public static XSSFWorkbook workbook;
    public static XSSFSheet sheet;
    public static XSSFRow row;
    public static XSSFCell cell;
    public static XSSFCellStyle cellStyle;

    public static int getRowCount(String excelFile, String excelSheet) {

        int rowCount = 0;
        try {
            input = new FileInputStream(excelFile);
            workbook = new XSSFWorkbook(input);
            sheet = workbook.getSheet(excelSheet);
            rowCount = sheet.getLastRowNum();
            workbook.close();
            input.close();
        } catch (Exception e) {
            printErrorAndShowIssue(e);
        }

        return rowCount;
    }

    public static int getCellCount(String excelFile, String excelSheet, int rowNumber) {

        int cellCount = 0;
        try {
            input = new FileInputStream(excelFile);
            workbook = new XSSFWorkbook(input);
            sheet = workbook.getSheet(excelSheet);
            row = sheet.getRow(rowNumber);
            cellCount = row.getLastCellNum();
            input.close();
            workbook.close();
        } catch (Exception e) {
            printErrorAndShowIssue(e);
        }

        return cellCount;
    }

    public static String getCellData(String excelFile, String excelSheet, int rowNumber, int columnNumber) {

        try {
            input = new FileInputStream(excelFile);
            workbook = new XSSFWorkbook(input);
            sheet = workbook.getSheet(excelSheet);
            row = sheet.getRow(rowNumber);
            cell = row.getCell(columnNumber);
        } catch (Exception e) {
            printErrorAndShowIssue(e);
        }

        String data;

        try {
            DataFormatter formatter = new DataFormatter();
            data = formatter.formatCellValue(cell);
            input.close();
            workbook.close();
            return data;
        } catch (Exception e) {
            printErrorAndShowIssue(e);
            data = "";

        }

        return data;

    }

    public static void setCellData(String excelFile, String excelSheet, int rowNumber, int colNumber, String data) {

        try {
            input = new FileInputStream(excelFile);
            workbook = new XSSFWorkbook(input);
            sheet = workbook.getSheet(excelSheet);
            cell = row.createCell(colNumber);
            cell.setCellValue(data);
            output = new FileOutputStream(excelFile);
            workbook.write(output);

            workbook.close();
            output.close();
            input.close();
        } catch (Exception e) {
            printErrorAndShowIssue(e);
        }
    }

    public static void fillGreenColor(String excelFile, String excelSheet, int rowNumber, int colNumber) {

        try {
            input = new FileInputStream(excelFile);
            workbook = new XSSFWorkbook(input);
            sheet = workbook.getSheet(excelSheet);
            row = sheet.getRow(rowNumber);
            cell = row.getCell(colNumber);

            cellStyle = workbook.createCellStyle();

            cellStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
            cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            cell.setCellStyle(cellStyle);
            output = new FileOutputStream(excelFile);
            workbook.write(output);
            workbook.close();
            input.close();
            output.close();

        } catch (Exception e) {
            printErrorAndShowIssue(e);
        }
    }


    public static void fillRedColor(String excelFile, String excelSheet, int rowNumber, int colNumber) {
        try {
            input = new FileInputStream(excelFile);
            workbook = new XSSFWorkbook(input);
            sheet = workbook.getSheet(excelSheet);
            row = sheet.getRow(rowNumber);
            cell = row.getCell(colNumber);

            cellStyle = workbook.createCellStyle();

            cellStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
            cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            cell.setCellStyle(cellStyle);
            output = new FileOutputStream(excelFile);
            workbook.write(output);
            workbook.close();
            input.close();
            output.close();

        } catch (Exception e) {
            printErrorAndShowIssue(e);
        }
    }

    public static void printErrorAndShowIssue(Exception e) {
        e.printStackTrace();
        System.out.println("Error,please check your code" + e);
    }

    public static void main(String[] args) {

        System.out.println(setEmail());
        System.out.println(setPassword());
    }

    public static String setEmail() {

        String email = String.valueOf(getRowCount("src/main/java/files/creds.xlsx", "Sheet1"));
        return email;
    }

    public static String setPassword() {

        String password = String.valueOf(getCellCount("src/main/java/files/creds.xlsx", "Sheet1", 1));
        return password;
    }
}
