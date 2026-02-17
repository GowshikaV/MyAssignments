package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	public static String[][] readData (String filename, String sheetname) throws IOException {

		XSSFWorkbook exl = new XSSFWorkbook("./data/"+filename+".xlsx");       // To open Workbook
		XSSFSheet sheet = exl.getSheet(sheetname);                                          // To open the exact Sheet
		//XSSFSheet sheet = exl.getSheetAt(0);

		int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();           // No. of Rows - Includes 1st Row
		int rowCount = sheet.getLastRowNum();                                 // No. of Rows - Excludes 1st Row
		int columnCount = sheet.getRow(0).getLastCellNum();                   // No. of Columns
		String singleValue = sheet.getRow(1).getCell(1).getStringCellValue(); // To retrieve a single value

		System.out.println("Total No. of Rows: " + physicalNumberOfRows);
		System.out.println("Total No. of Rows without header: " + rowCount);
		System.out.println("Total No. of Columns: " + columnCount);
		System.out.println("Single cell Value: " + singleValue);
		                                                                       
		String[][] data = new String[rowCount][columnCount];                  // To retrieve all the date from the Excel

		for (int i = 1; i <=rowCount; i++) {
			for (int j = 0; j<columnCount; j++) {
				String allData = sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.println("All Data: " + allData);
				data [i-1][j] = allData;
			}

		}
		return data;

	}


}
