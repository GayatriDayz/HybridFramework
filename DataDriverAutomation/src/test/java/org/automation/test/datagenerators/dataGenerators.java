package org.automation.test.datagenerators;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class dataGenerators {
	
	@DataProvider(name="LoginDemo")
	public static Object[][] testDataGenerator() throws IOException{
		
		
		FileInputStream fis = new FileInputStream("C:/Automation/DataDriverAutomation/src/test/java/org/automation/test/testData/LoginSheet.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet loginSheet = wb.getSheet("login");
		
		
		int numberOfData = loginSheet.getPhysicalNumberOfRows();
		Object[][] testData = new Object[numberOfData][2];
		
		for(int i=0;i<numberOfData;i++)
		{
			XSSFRow row = loginSheet.getRow(i);
			XSSFCell username = row.getCell(0);
			XSSFCell password = row.getCell(1);
			testData[i][0] = username.getStringCellValue();
			testData[i][1] = password.getStringCellValue();
		}
		
		return testData;
	}

}

