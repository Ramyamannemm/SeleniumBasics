package crm.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelSheetRead {
  
	
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	
	
	public ExcelSheetRead() {
		try {
			FileInputStream fp=new FileInputStream(new File("./src/main/resources/ExcelDataFiles/AutomationTestData.xlsx"));
			workbook=new XSSFWorkbook(fp);
			sheet=workbook.getSheetAt(0);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public static Object[][] GetTestData()
	{
		ExcelSheetRead read=new ExcelSheetRead();
		
	int NoOfRows=sheet.getLastRowNum();
	int NoOfColumns=sheet.getRow(1).getLastCellNum();
	
	
	Object[][] data = new Object[NoOfRows][NoOfColumns];
	for (int i = 1; i < NoOfRows; i++) {
		for (int k = 0; k < NoOfColumns; k++) {
			data[i][k] = sheet.getRow(i).getCell(k).toString();
			System.out.println(data[i][k]);
		}
	}
	return data;
	}
	
	
	
	
	
	
	
	
	
}
