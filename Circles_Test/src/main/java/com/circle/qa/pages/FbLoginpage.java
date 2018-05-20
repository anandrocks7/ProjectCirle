package com.circle.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.circle.qa.base.Testbase;

public class FbLoginpage extends Testbase {

	@FindBy(xpath= "//td//input[@id='email']")
	WebElement Fbusername;
	
	@FindBy(xpath= "//td//input[@id='pass']")
	WebElement Fbpassword;
	
	@FindBy(xpath= "//input[@value='Log In']")
	WebElement Loginbtn;
	
	
	
	
	public FbLoginpage() {
		PageFactory.initElements(driver, this);
	}
	
     public String validatefbtitle() {
 		
 		return driver.getTitle();
 	}
 	
 	
 	public FbLandingpage Loginfb(String fbun,String fbpwd) {
 		
 		Fbusername.sendKeys(fbun);
 		Fbpassword.sendKeys(fbpwd);
 		
 		Loginbtn.click();
 		return new FbLandingpage();
 	}
 	
	
	
	
	
}
