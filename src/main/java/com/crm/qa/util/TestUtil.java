package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT= 10;
	
	public static String TESTDATA_SHEET_PATH= "C:\\QA\\SeleniumWorkSpace\\FreeCRMTest2\\src\\main\\java\\com\\crm\\qa\\data\\FreeCRM_TestData.xlsx";
	static XSSFWorkbook book;
	static XSSFSheet sheet;
	
	
	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}
	
	public static Object[][] getTestData(String sheetName) throws Exception{

		File file = new File(TESTDATA_SHEET_PATH);
		FileInputStream fn = new FileInputStream(file);
		 book = new XSSFWorkbook(fn);
		 sheet = book.getSheet(sheetName);
				
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0; i<sheet.getLastRowNum(); i++) {
			for(int k=0; k<sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i+1).getCell(k).toString();
				
			}
		}
		return data;
	}
}
		
		
		
		


