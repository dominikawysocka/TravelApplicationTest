package com.travelers.helper;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ExcelHelper {


    public static Object[][] readExcelFile(File file) throws IOException {

        InputStream inputStream = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        //Iterator<Row> iterator = sheet.rowIterator();
        int rowNumber = sheet.getLastRowNum();
        int cellNumber = sheet.getRow(0).getLastCellNum();
        java.lang.String[][] data = new java.lang.String[rowNumber][cellNumber];

        for (int i = 0; i < rowNumber; i++) {
            Row row = sheet.getRow(i+1);
            for (int j = 0; j < row.getLastCellNum(); j++) {
                data[i][j] = row.getCell(j).getStringCellValue();
            }
        }
        return data;
//        while (iterator.hasNext()) {
//            Row row = iterator.next();
//            Iterator<Cell> cellIterator = row.cellIterator();
//            while (cellIterator.hasNext()) {
//                Cell cell = cellIterator.next();
//                if (cell.getCellTypeEnum().equals(CellType.STRING)) {
//                    System.out.println(cell.getStringCellValue());
//                } else if (cell.getCellTypeEnum().equals(CellType.NUMERIC)) {
//                    System.out.println(cell.getNumericCellValue());
//                }
//            }
//        }

    }

    public static void main(String[] args) throws IOException {
        File file = new File("src//main//resources//Files//daneTestowe.xlsx");
        Object[][] tabela = readExcelFile(file);
        System.out.println(tabela[0][0]);
    }


}
