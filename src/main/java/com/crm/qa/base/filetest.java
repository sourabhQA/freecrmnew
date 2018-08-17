package com.crm.qa.base;

import org.testng.annotations.Test;

public class filetest extends TestBase {
	
	
 public  filetest() {
	    super();
 }

 @Test
 public void printFile() {
	 
	String callic = prop.getProperty("browser");
	System.out.println(callic);
	 }
}
