package com.circle.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.circle.qa.base.Testbase;

public class CircleHomepage extends Testbase {
	
	@FindBy(xpath="//a[@class='Links']//div[text()='MY ACCOUNT']")
	WebElement Myaccountlink;
	// 
	@FindBy(xpath= "//a[@class='Links']//div[text()='HOME']")
	WebElement Homelink;
	

	public CircleHomepage() {
		PageFactory.initElements(driver, this);		
	}

	public boolean Homelinkverify() {
		
		return Homelink.isDisplayed();
		}
	
	
	public  CircleMyaccountpage Clickmyaccountlink() throws Exception{
		Thread.sleep(3000);
		      Myaccountlink.click();
		      return new CircleMyaccountpage();
	}
	
	
	
}

