package com.circle.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.circle.qa.util.Testutil;

public class Testbase {

	public static WebDriver driver;
	public static Properties prop;
	
	public Testbase()
	{
		try {
		prop = new Properties();
		//System.out.println(System.getProperty("user.dir"));
		FileInputStream ip = new FileInputStream("C:\\Selenium_Project\\Circles_Test\\src\\main\\java\\com\\circle\\qa\\config\\config.properties");
		prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void Initialization()
	{ 
		String browsername= prop.getProperty("browser");
		if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium_additionalinstalls\\chromedriver_win32\\chromedriver.exe");
		 driver=new ChromeDriver();
		}else if (browsername.equals("firefox")) 
		{
			
			System.setProperty("webdriver.gecko.driver","C:\\Users\\Anand\\Downloads\\Donloads for selenium\\geckodriver-v0.20.1-win64\\geckodriver.exe");
			//System.setProperty("webdriver.gecko.driver","C:\\Program Files\\Mozilla Firefox\\firefox.exe"); 
			driver = new FirefoxDriver();
		}
		 
		 
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Testutil.Page_load_Timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Testutil.Implicit_Wait, TimeUnit.SECONDS);
		
		 driver.get(prop.getProperty("url"));
		 
		}
		
	
	


}
