package com.syn.qa.util;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ExcelDataConfig {
	
	public static XSSFWorkbook wb;
    public static XSSFSheet sh;
    public static XSSFCell Cell;
    public static XSSFRow Row;

    public void ExcelData(String excelPath) {
        try {
            FileInputStream FIS = new FileInputStream(excelPath);
            wb = new XSSFWorkbook(FIS);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getData(int sheetNumber, int row, int column){
        sh = wb.getSheetAt(0);
        String data = sh.getRow(row).getCell(column).getStringCellValue();
        return data;
    }

    public int getRowCount (int sheetIndex) {
        int row = wb.getSheetAt(sheetIndex).getLastRowNum();
        return row;
    }

    public static void setCellData(int sheetIndex, String path , String sheetName, String Result, int RowNum, int ColNum) throws Exception
    {
        try
        {
            Row = wb.getSheetAt(sheetIndex).getRow(RowNum);
            Cell = Row.getCell(ColNum);
            if (Cell == null)
            {
                Cell = Row.createCell(ColNum);
                Cell.setCellValue(Result);
            }
            else
            {
                Cell.setCellValue(Result);
            }

            FileOutputStream FOS = new FileOutputStream(path);
            wb.write(FOS);
            sh = wb.getSheet(sheetName);
            FOS.flush();
        }
        catch(Exception e)
        {
            throw (e);
        }
    }

}
