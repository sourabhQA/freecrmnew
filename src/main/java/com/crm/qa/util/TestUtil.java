package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{
	public static long PAGE_IMPLICIT_WAIT = 20;
     public static String fileloc = "C:\\Users\\Saurabh\\eclipse-workspace\\freecrmnew\\src\\main\\java\\com\\crm\\qa\\testdata\\Excelfile.xlsx";
	 static Workbook book;
	 static Sheet sheet;
	
	
	public static void takescreen(WebDriver Driver , String filename) {
		
		
		
	
		String currentdir = System.getProperty("user.dir");
		TakesScreenshot scrShot =((TakesScreenshot)Driver);
	
		File scrFile = 	scrShot.getScreenshotAs(OutputType.FILE); 
		try {
			FileUtils.copyDirectory(scrFile, new File(currentdir + "/SCREENSHOTS/" + System.currentTimeMillis() + ".png"));
			//FileUtils.copyFile(scrFile, new File(("C:\\Users\\Saurabh\\eclipse-workspace\\freecrmnew\\target"+filename+".png")));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public void frameswitch() {
		Driver.switchTo().frame("mainpanel");
	}

	public static Object[][] getTestdata(String sheetname) {
	FileInputStream	file;
	file = null;
		try {
			 file = new FileInputStream(fileloc);
		} catch (FileNotFoundException e) {
			System.out.println("file not traceble");
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetname);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	
		
	}
	
	

}
