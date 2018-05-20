package com.circle.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.circle.qa.base.Testbase;
import com.circle.qa.pages.CircleHomepage;
import com.circle.qa.pages.CircleLoginpage;
import com.circle.qa.pages.CircleMyaccountpage;
import com.circle.qa.pages.FbLandingpage;
import com.circle.qa.pages.FbLoginpage;
import com.circle.qa.pages.FbProfilepage;

public class FbProfilepageTest extends Testbase {
	
	
	CircleLoginpage cloginpageobj;
	CircleHomepage chomepageobj;
	CircleMyaccountpage cmyacctpageobj;
	FbLoginpage fbloginpagobj;
	FbProfilepage fbProfilepgobj;
	FbLandingpage fblandingpgobj;
	
	
	public FbProfilepageTest() { 
		super();	
	}
	
	@BeforeClass
	public void setup() throws Exception {
		
		Initialization();
		cloginpageobj= new CircleLoginpage();
		chomepageobj= cloginpageobj.logincircle(prop.getProperty("emailc"), prop.getProperty("pwdc"));
		
		cmyacctpageobj= chomepageobj.Clickmyaccountlink();
		
		//String Parentwindow= driver.getWindowHandle();
		//System.out.println(" Parentwindow is "+ Parentwindow);
		
		fbloginpagobj=cmyacctpageobj.Clickfblink();
		
		Thread.sleep(9000);
		
		for(String childtab:driver.getWindowHandles()) {
			
			driver.switchTo().window(childtab);
		}
		
		Thread.sleep(7000);
		fblandingpgobj=fbloginpagobj.Loginfb(prop.getProperty("fbusrname"), prop.getProperty("fbpwd"));
		fbProfilepgobj=fblandingpgobj.Clickprofile();
		Thread.sleep(5000);
        
		}
	
	
	
	
	
	@Test(priority=1)
	public void PostcommentTest() throws Exception {
		fbProfilepgobj.Postcomment(prop.getProperty("comment"));
		
	}
	
	@Test(priority=2)
	public void VerifycommentTest() {
		
		boolean Val= fbProfilepgobj.Verifycomment();
		Assert.assertTrue(Val);
	}
	
	@AfterClass
	public void TearDown() {
		
		driver.quit();
	}
	
	
}
