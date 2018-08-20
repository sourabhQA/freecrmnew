package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;



  public class TestBase {
	  
	  
  public static Properties prop;
  public static WebDriver Driver;
	

	public TestBase(){
		
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\Saurabh\\eclipse-workspace\\freecrmnew\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
		public static void initializations(){
			
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "S:\\Cucumber\\chromedriver.exe");
			Driver = new ChromeDriver();
			Driver.get(prop.getProperty("url"));
		}
		else{
			System.out.println("hey");
		}
		
		    EventFiringWebDriver e_driver = new EventFiringWebDriver(Driver);
		    WebEventListener eventlistener = new WebEventListener();
		    e_driver.register(eventlistener);
		    Driver = e_driver;
			Driver.manage().window().maximize();
			Driver.manage().deleteAllCookies();
		    Driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		}
		
		
	


	
		
	}


