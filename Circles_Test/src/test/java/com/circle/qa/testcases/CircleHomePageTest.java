package com.circle.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.circle.qa.base.Testbase;
import com.circle.qa.pages.CircleHomepage;
import com.circle.qa.pages.CircleLoginpage;
import com.circle.qa.pages.CircleMyaccountpage;

public class CircleHomePageTest extends Testbase {
	
	CircleLoginpage cloginpageobj;
	CircleHomepage chomepageobj;
	CircleMyaccountpage cmyacctpageobj;

	public CircleHomePageTest() {
		super();
	}
	
	@BeforeClass
	public void setup(){
		
		Initialization();
		cloginpageobj= new CircleLoginpage();
		chomepageobj= cloginpageobj.logincircle(prop.getProperty("emailc"), prop.getProperty("pwdc"));
	}
	
	
	@Test(priority=1)
	public void Homelinkverifytest() throws Exception {
		Thread.sleep(3000);
		boolean flag = chomepageobj.Homelinkverify();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=2)
	public void Myaccountlinkclicktest() throws Exception {
		Thread.sleep(3000);
		cmyacctpageobj=chomepageobj.Clickmyaccountlink();
		
		
	}
	
	@AfterClass
	public void TearDown()  {
		
		driver.quit();
	}
	
	
}
