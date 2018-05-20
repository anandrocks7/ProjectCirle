package com.circle.qa.testcases;



import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.circle.qa.base.Testbase;
import com.circle.qa.pages.CircleHomepage;
import com.circle.qa.pages.CircleLoginpage;

public class CircleLoginPageTest extends Testbase {
	
	CircleLoginpage cloginpgObj;
	CircleHomepage chomepageobj;
	
	public CircleLoginPageTest() { 
		super();	
	}
	
	@BeforeClass
	public void setup() {
	
		Initialization();	
	cloginpgObj= new CircleLoginpage();
	}
    
	@Test(priority=1)
	public void circlepagetitletest() {
		
		String ctitle = cloginpgObj.validateloginpagetitle();
		System.out.println("Page title is - "+ ctitle);
		Assert.assertEquals(ctitle, "Unlimit your telco. Now.");
			
	}
	
	@Test(priority=2)
	public void circlelogintest() throws Exception {
		
		chomepageobj =cloginpgObj.logincircle(prop.getProperty("emailc"), prop.getProperty("pwdc"));
		
		
	}
	
	
	
	@AfterClass
	public void teardown()  {
		
		driver.quit();
	}
	
}
