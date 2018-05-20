package com.circle.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.circle.qa.base.Testbase;

public class FbLandingpage extends Testbase {

	@FindBy(xpath= "//span[text()='Circle']")
	WebElement Profilelink;
	
	public FbLandingpage() {
		PageFactory.initElements(driver, this);
	}
	
	
public FbProfilepage Clickprofile() {
		
		Profilelink.click();
		
		return new FbProfilepage();
	}
	
}
