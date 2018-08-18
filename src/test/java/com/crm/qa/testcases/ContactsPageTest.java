package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	
	
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	TestUtil testutil;
   public ContactsPageTest(){
		
		super();
	}
   
   
   
	@BeforeMethod
  public void Setup() {
	  
	  
	  initializations();
	  loginpage = new LoginPage();
	  homepage = new HomePage();
      testutil = new TestUtil();
	  contactspage = new ContactsPage();
	  homepage =	loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	  testutil.frameswitch();
	  contactspage =homepage.Contactspage();
	 }
	
	@BeforeMethod
	public void teardown() {
		
		Driver.close();
		
	}
	@Test(priority=1)
	public void verifycontactlabel() {
		Assert.assertTrue(contactspage.Contactslabel(), "This is not a contacts page ");
		}
	
	
	
	
	
	

}
