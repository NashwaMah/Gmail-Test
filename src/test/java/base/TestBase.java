package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;


import dataProvider.ConfigFileReader;

public class TestBase {
	
	 public static WebDriver driver;
	 ConfigFileReader configFileReader;

	  
	 @BeforeSuite
	
	  public void startDriver() {
	      
		       configFileReader= new ConfigFileReader();
	            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + configFileReader.getDriverPath());
	            driver = new ChromeDriver();
	       

	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	        driver.navigate().to("http://www.gmail.com");
}
}
