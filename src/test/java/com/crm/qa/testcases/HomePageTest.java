package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	
	HomePage homepage;
	TestUtil testutil;
	LoginPage loginpage;
	public HomePageTest() {
		super();
		
	}

	@BeforeMethod
	public void setup() {
		
		initializations();
		homepage = new HomePage();
		loginpage = new LoginPage();
		testutil = new TestUtil();
		
		homepage =	loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority=1)
	public void verifyusertitle() {
		testutil.frameswitch();
	boolean ba = homepage.validateCRMProtitle();
	Assert.assertTrue(ba);
	}
	
	@Test(priority=2)
	public void verifyCrm() {
	testutil.frameswitch();
		Assert.assertTrue(homepage.validateCRMProtitle());
		
	}
	@Test(priority=3)
	public void verifymenubar() {
		testutil.frameswitch();
	boolean bar =	homepage.validatemenubar();
	Assert.assertTrue(bar);
	}
	
	
	
	
	
	
	@AfterMethod
	public void teardown() {
	 Driver.quit();
	 
	}
	
	
	
	
	
	
	
	
	
	

}
