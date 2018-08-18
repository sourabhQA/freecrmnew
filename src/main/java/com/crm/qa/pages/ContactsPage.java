package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	

	
    @FindBy(xpath="//td[contains(text(),'Contacts')]")
    WebElement Contactslabel;
    
	public ContactsPage() {
		PageFactory.initElements(Driver, this);
			}
	
	
	public boolean Contactslabel() {
		return Contactslabel.isDisplayed();
		}
	
	public void clickoncheckbox() {
		
		
	}

}
