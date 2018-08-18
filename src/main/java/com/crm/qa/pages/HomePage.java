package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	
	@FindBy(xpath = "//td[contains(text(),\"saurabh singh\")]")
	WebElement username;
	
	@FindBy(id = "handle_CRMBLOG")
	WebElement CRMProtitle;
	
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement Contactstab;
	
	
	@FindBy(xpath ="//ul[@class=\"mlddm\"]")
	WebElement menuBar;
	
	
	public HomePage() {
		
		PageFactory.initElements(Driver, this);
			}
	

	public boolean  validateUsername() {
	return username.isDisplayed();
	}
	
	public  boolean validateCRMProtitle() {
		
	return	CRMProtitle.isDisplayed();
		
		
	}
	
	
	public boolean validatemenubar() {
		return menuBar.isDisplayed();
		
		
	}
	
	public ContactsPage Contactspage() {
		
		
		
		 Contactstab.click();
	return new ContactsPage();
	}
	
	
	
	public void clickonnewcontact() {
		Actions action = new Actions(Driver);
		action.moveToElement(Contactstab).build().perform();
		
		
	}


}
