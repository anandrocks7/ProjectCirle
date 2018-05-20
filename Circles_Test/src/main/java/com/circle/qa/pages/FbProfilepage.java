package com.circle.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.circle.qa.base.Testbase;

public class FbProfilepage extends Testbase{

	
	
	
	@FindBy(xpath= "//div[@id='addComment_106679140213721']//div/descendant::div[contains(@class,'UFIAddCommentInput')]")  
	WebElement Inputcommentbox;
	// //div[contains(@class,'UFIAddCommentInput')]
	////div[@id='addComment_106679140213721']//div/descendant::div[contains(@class,'UFIAddCommentInput')]
	////input[@class='_1osa mentionsHidden' and  @name='add_comment_text']
	
	
	
	@FindBy(xpath= "//span[@class='UFICommentBody']//span[text()='bb']")
	WebElement Commentposted;
	////descendant::span[@class='UFICommentBody'][2]
	
	
	public FbProfilepage() {
		PageFactory.initElements(driver, this);
	}
	
	
	//   
	
	public void Postcomment(String comment) throws Exception {
		Thread.sleep(8000);
		Inputcommentbox.click();
		Thread.sleep(2000);
		Inputcommentbox.sendKeys(comment);
		
		Inputcommentbox.sendKeys(Keys.ENTER);
	}
	
	public boolean Verifycomment() {
		
	return	Commentposted.isDisplayed();
	
	}
	
	
	
	
}


