package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	
	
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
	
	@Test(priority=2)
	public void loginTest() {
	homepage =	loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void wrongcredTest() {
	loginpage.login(prop.getProperty("wrongusername"), prop.getProperty("wrongpassword"));
	boolean hik = loginpage.validateCrmLogo();
	Assert.assertTrue(hik);
	System.out.println("Not able to login when i entered wrong password");
	}
	
	
	
	
}
