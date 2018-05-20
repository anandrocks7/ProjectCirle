package com.circle.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.circle.qa.base.Testbase;

public class FbProfilepage extends Testbase{

	
	
	
	@FindBy(xpath= "//input[@class='_1osa mentionsHidden' and  @name='add_comment_text']")  
	WebElement Inputcommentbox;
	// //div[contains(@class,'UFIAddCommentInput')]
	////div[@id='addComment_106679140213721']//div/descendant::div[contains(@class,'UFIAddCommentInput')]
	
	
	
	@FindBy(xpath= "//span[@class='UFICommentBody']//span[text()='bb']")
	WebElement Commentposted;
	
	
	public FbProfilepage() {
		PageFactory.initElements(driver, this);
	}
	
	
	//   
	
	public void Postcomment(String comment) throws Exception {
		Thread.sleep(8000);
		Inputcommentbox.click();
	
		
		Inputcommentbox.sendKeys(comment);
		Thread.sleep(1000);
		Inputcommentbox.sendKeys(Keys.ENTER);
	}
	
	public boolean Verifycomment() {
		
	return	Commentposted.isDisplayed();
	
	}
	
	
	
	
}


