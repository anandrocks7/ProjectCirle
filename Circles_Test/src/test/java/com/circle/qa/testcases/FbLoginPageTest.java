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

public class FbLoginPageTest extends Testbase {
	CircleLoginpage cloginpageobj;
	CircleHomepage chomepageobj;
	CircleMyaccountpage cmyacctpageobj;
	FbLoginpage fbloginpagobj;
	FbLandingpage fblandingpgobj;
	
	
	public FbLoginPageTest() { 
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
		
        
		}
	
	@Test(priority=1)
	public void fbtitlepagetest() {
		
		String fbtitle = fbloginpagobj.validatefbtitle();
		
		Assert.assertEquals(fbtitle, "Circles.Life - Home | Facebook");
			
	}
	
	@Test(priority=2)
	public void Fblogintest() {
			
		fblandingpgobj= fbloginpagobj.Loginfb(prop.getProperty("fbusrname"), prop.getProperty("fbpwd"));
		
	}
	
	
	@AfterClass
	public void TearDown() {
			
			driver.quit();
		}
		
}
