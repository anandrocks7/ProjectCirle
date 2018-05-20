package com.circle.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.circle.qa.base.Testbase;

public class CircleMyaccountpage extends Testbase {

	
	@FindBy(xpath= "//input[@value='circletest111@gmail.com']")
	WebElement Emailfieldvalue;
	
	@FindBy(xpath= "//a[contains(@href,'facebook')]")
	WebElement Fblink;
	
	
	
	
	public CircleMyaccountpage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean Emailverify() {
		
		return  Emailfieldvalue.isDisplayed();
	}
	
	public FbLoginpage Clickfblink() throws Exception {
		Thread.sleep(3000);
		Fblink.click();
		return new FbLoginpage();
	}
	
	
	
	
}
