package com.circle.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.circle.qa.base.Testbase;
import com.circle.qa.pages.CircleHomepage;
import com.circle.qa.pages.CircleLoginpage;
import com.circle.qa.pages.CircleMyaccountpage;
import com.circle.qa.pages.FbLoginpage;

public class CicrleMyaccountpageTest extends Testbase{

	CircleLoginpage cloginpageobj;
	CircleHomepage chomepageobj;
	CircleMyaccountpage cmyacctpageobj;
	FbLoginpage fbloginpagobj;

	public CicrleMyaccountpageTest() {
		super();
	}
	
	@BeforeClass
	public void setup() throws Exception {
		
		
		Initialization();
		cloginpageobj= new CircleLoginpage();
		chomepageobj= cloginpageobj.logincircle(prop.getProperty("emailc"), prop.getProperty("pwdc"));
		Thread.sleep(3000);
		cmyacctpageobj= chomepageobj.Clickmyaccountlink();
	}
	
	@Test(priority=1)
	public void Emailverifytest() {
	boolean displayed=cmyacctpageobj.Emailverify();
	
	Assert.assertTrue(displayed);
		
	}
	
	@Test(priority=2)
	public void Clickfblinktest() throws Exception {
		Thread.sleep(3000);
		fbloginpagobj = cmyacctpageobj.Clickfblink();
	}
	
	
	@AfterClass
	public void TearDown() {
		
		driver.quit();
	}
	
}
