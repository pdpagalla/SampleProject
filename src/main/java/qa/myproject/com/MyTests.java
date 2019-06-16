package qa.myproject.com;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyTests extends CommonLibs{
	
	static String ivalidUsername = "invalidusername";
	static String invalidPassword = "invalidpassword";
	
	@BeforeMethod
	public void beforeMethod(){
		
		if(browser.equals("chrome")){
			System.out.println("Setting chrome browser");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(url);
			driver.manage().window().maximize();
		}else if(browser.equals("firefox")){
			System.out.println("Setting firefox browser");
			WebDriverManager.firefoxdriver().setup();
		}
	
	}
	
	@AfterTest
	public static void afterMethod(){
		driver.close();
	}
	
	@Test(priority=1)
	public static void loginValid(){
		enterCredentials(username, password);
		
	}
	
	@Test
	public static void loginInvalid(){
		enterCredentials(ivalidUsername,invalidPassword);
	}
	
	@Test(dependsOnMethods="loginValid")
	public static void alerts(){
		//enterCredentials(ivalidUsername,invalidPassword);
		selectDropDownByText("Item1");
	}

}
