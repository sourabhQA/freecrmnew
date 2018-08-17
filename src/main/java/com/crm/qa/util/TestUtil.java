package com.crm.qa.util;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{
	public static long PAGE_IMPLICIT_WAIT = 20;

	
	
	
	
	public static void takescreen(WebDriver Driver , String filename) {
		
		
		
		
		TakesScreenshot scrShot =((TakesScreenshot)Driver);
		File scrFile = 	scrShot.getScreenshotAs(OutputType.FILE); 
		try {
			FileUtils.copyDirectory(scrFile, new File("C:\\Users\\Saurabh\\eclipse-workspace\\freecrmnew\\test-output","+filename+.png"));
			//FileUtils.copyFile(scrFile, new File(("C:\\Users\\Saurabh\\eclipse-workspace\\freecrmnew\\target"+filename+".png")));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public void frameswitch() {
		Driver.switchTo().frame("mainpanel");
	}



}
