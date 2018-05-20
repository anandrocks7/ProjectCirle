package com.circle.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.circle.qa.base.Testbase;

public class CircleLoginpage extends  Testbase{

	//OR
	@FindBy(xpath= "//img[@alt='Circles.Life']")
	WebElement Cirlelogo;
	
	@FindBy(xpath= "//input[@name='email' and @type='text']")
	WebElement Email;
	
	@FindBy(xpath= "//input[@name='password']")
	WebElement Password;
	
	@FindBy(xpath= "//button[text()='Sign In']")
	WebElement Signinbtn;
	
	//Initialization elements via constructor
	public CircleLoginpage(){
		
		PageFactory.initElements(driver, this);	
	}
	
	//Actions
	public String validateloginpagetitle() {
		
		return driver.getTitle();
	}
	
	
	public boolean validatelogo() { 
		
	return Cirlelogo.isDisplayed();	
	}
	
	
	public CircleHomepage logincircle(String un,String pwd) {
		Email.sendKeys(un);
		Password.sendKeys(pwd);
		Signinbtn.click();
		
		return new CircleHomepage();
	}
	
	
	
	
	
	
	
	
	
}
