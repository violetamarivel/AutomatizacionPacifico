package com.pacifico.framework.utilities;

import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

public class ExcelUtil {

    static Sheet wrksheet;
    static Workbook wrkbook = null;
    static Hashtable dict = new Hashtable();
    static Hashtable dictData = new Hashtable();
    static Hashtable dictDataRow = new Hashtable();

    //Create a Constructor
    public ExcelUtil(String ExcelSheetPath, String sheetName) throws BiffException, IOException {
        WorkbookSettings ws = new WorkbookSettings();
        ws.setEncoding("Cp1252");

        //Initialize
        wrkbook = Workbook.getWorkbook(new File(ExcelSheetPath), ws);
        wrksheet = wrkbook.getSheet(sheetName);

        //Call the Column Dictionary to store column Names
        ColumnDictionary();
        SheetDictionary();
    }

    //Returns the Number of Rows
    public static int RowCount() {
        return wrksheet.getRows();
    }

    //Returns the Cell value by taking row and Column values as argument
    private static String ReadCell(int column, int row) {
        return wrksheet.getCell(column, row).getContents();
    }

    public static String ReadCell(String columnName, int rowNumber) {
        return ReadCell(GetCell(columnName), rowNumber);
    }

    //Create Column Dictionary to hold all the Column Names
    private static void ColumnDictionary() {
        //Iterate through all the columns in the Excel sheet and store the value in Hashtable
        for (int col = 0; col < wrksheet.getColumns(); col++) {
            dict.put(ReadCell(col, 0), col);
        }
    }

    //Create Row Dictionary to hold all Data
    private static void SheetDictionary() {
        //Iterate through all the columns in the Excel sheet and store the value in Hashtable
        System.out.println("Total rows of excel found " + wrksheet.getRows());
        for (int row = 0; row < wrksheet.getRows(); row++) {
            if (row != 0) {
                for (int col = 0; col < wrksheet.getColumns(); col++) {
//                System.out.println("-------------"+ReadCell(col,0)+"   "+ReadCell(col,row));
                    dictData.put(ReadCell(col, 0), ReadCell(col, row));

                }
                dictDataRow.put(ReadCell(0, row) + "-" + ReadCell(1, row), dictData);
                dictData = new Hashtable();
//            System.out.println("-----"+ReadCell(0,row));
            }
        }
    }

    //Read Column Names
    private static int GetCell(String colName) {
        try {
            int value;
            value = ((Integer) dict.get(colName)).intValue();
            return value;
        } catch (NullPointerException e) {
            return (0);

        }
    }

    public static Hashtable allDataSheet() {
        return dictDataRow;
    }
}
