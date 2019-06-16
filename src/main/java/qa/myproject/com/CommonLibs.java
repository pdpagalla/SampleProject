package qa.myproject.com;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CommonLibs {
	
	static WebDriver driver;
	static String url;
	static String browser;
	static String username;
	static String password;
	
		
	static{
		String fileName = "Environment.properties";
        ClassLoader classLoader = new MyTests().getClass().getClassLoader();
        InputStream resourceStream = classLoader.getResourceAsStream(fileName);
       Properties prop = new Properties();
       try {
		prop.load(resourceStream);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}   
       url = prop.getProperty("BaseURL");
       username = prop.getProperty("Username");
       password = prop.getProperty("Password");
       browser = prop.getProperty("Browser");
	}
	
	public static void enterCredentials(String myUsername, String myPassword){
		clearText("txtUsername");
		enterText("txtUsername",myUsername);
		enterText("txtPassword",myPassword);
		click("loginButton");
	}
	
	public static void enterText(String elementName, String myText){
		driver.findElement(By.id(elementName)).sendKeys(myText);
/*		
		if(elementName.contains("//")){
			driver.findElement(By.xpath(elementName)).sendKeys(myText);
	}else if(elementName.contains(".")){
		driver.findElement(By.cssSe(elementName)).sendKeys(myText);
	}else{
		driver.findElement(By.id(elementName)).sendKeys(myText);*/
	}
	
	
	public static void click(String buttonName){
		driver.findElement(By.id(buttonName)).click();
	}
	
	public static void clearText(String elementName){
		driver.findElement(By.id(elementName)).clear();
	}
	
	public static void selectDropDownByText(String text){
		Select sel = new Select(null);
		sel.selectByVisibleText(text);
	}

}
