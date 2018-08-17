package com.crm.qa.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.qa.util.TestUtil;



public class Testanish {
	
	@Test
	public void screen() throws IOException {
		//String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		System.setProperty("webdriver.chrome.driver", "S:\\Cucumber\\chromedriver.exe");
		WebDriver Driver = new ChromeDriver();
	    Driver.get("https://dev.wowconnect.com");
		Driver.manage().window().maximize();
		Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		TestUtil.takescreen(Driver, "cl");
	System.out.println("print pic");
	
		
		Driver.close();
	}
	

}
