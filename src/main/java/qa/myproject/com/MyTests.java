package qa.myproject.com;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTests {
	
	@BeforeTest
	public static void beforeMethod(){
		//url navigate
	}
	
	@AfterMethod
	public static void afterMethod(){
		//browser close
	}
	
	@Test
	public static void loginValid(){
		//enter login details
		//verify logic verify
		
	}
	
	@Test
	public static void loginInvalid(){
		//enter login details - invalid
		//verify error message
		
	}
	
	@Test
	public static void alerts(){
		//click menu in home page
		//click alerts
		//verify no alerts displayed
	}

}
