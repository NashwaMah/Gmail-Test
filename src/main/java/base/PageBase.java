package base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class PageBase {
	
	 
	  
	  protected WebDriver driver;
	  

	    //Super constructor
	    public PageBase(WebDriver driver) {
	        PageFactory.initElements(driver, this);
	    }
	    
	    protected static void clickButton(WebElement button) {
	        button.click();
	    }

	    protected static void setTextWebElement(WebElement textElement, String value) {
	        textElement.sendKeys(value);

	    }

	 
}
