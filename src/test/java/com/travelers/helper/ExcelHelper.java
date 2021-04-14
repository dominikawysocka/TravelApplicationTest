package com.travelers.helper;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public class ExcelHelper {


    public static void readExcelFile() throws IOException {

        InputStream inputStream = new FileInputStream("src//main//resources//Files//daneTestowe.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = sheet.rowIterator();

        while (iterator.hasNext()) {
            Row row = iterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                if(cell.getCellTypeEnum().equals(CellType.STRING)) {
                    System.out.println(cell.getStringCellValue());
                }
                else if(cell.getCellTypeEnum().equals(CellType.NUMERIC)){
                    System.out.println(cell.getNumericCellValue());
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
       readExcelFile();
    }





}
