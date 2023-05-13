package utils;

import utils.ExcelUtils;

import java.io.FileInputStream;
import java.util.Properties;

public class ExcelActions {

    static String filePath = "src/main/java/files/creds.xlsx";
    public static int rows = ExcelUtils.getRowCount(filePath, "Sheet1");


}
