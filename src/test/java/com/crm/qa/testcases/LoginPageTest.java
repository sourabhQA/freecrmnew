package com.crm.qa.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class LoginPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	public String sheetname = "login";
	
	  public LoginPageTest(){
		super();
		
	}
	
	@BeforeMethod
	public void setUp(){
		initializations();
	    loginpage = new LoginPage();
   }
	
	@AfterMethod
	public void close() {
		Driver.quit();
		
	}
	
	@DataProvider
	public  Object[][] getlogindata() {
	Object data[][] = 	TestUtil.getTestdata(sheetname);
		return data;
		
	}
	
	
	

	@Test(priority=4)
	public void verifyTitle() {
		String s = loginpage.validateLoginPageTitle();
	Assert.assertEquals(s, "#1 Free CRM software in the cloud for sales and service");
	}
	
	@Test(priority=3)
	public void verifyLogo() {
		boolean crm = loginpage.validateCrmLogo();
		Assert.assertTrue(crm);
	}
	
	@Test(dataProvider="getlogindata" , priority = 2)
	public void loginTest(String Username , String password) {
		
	homepage =	loginpage.login(Username, password);
	
	}
	
	@Test(priority=1)
	public void wrongcredTest() {
	loginpage.login(prop.getProperty("wrongusername"), prop.getProperty("wrongpassword"));
	boolean hik = loginpage.validateCrmLogo();
	Assert.assertTrue(hik);
	}
	
	
	
	
}
