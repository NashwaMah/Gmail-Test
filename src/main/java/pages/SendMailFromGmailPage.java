package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.PageBase;

public class SendMailFromGmailPage extends PageBase{

	



	public SendMailFromGmailPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	
	@FindBy(id="identifierId")
	WebElement UserNametxt;

	@FindBy(xpath="//span[@class='CwaK9']")
	WebElement EmailNextBtn;
	
	@FindBy(id="passwordNext")
	WebElement PasswordNextBtn;
	
	@FindBy(xpath="//div[@class='Xb9hP']/input[@type=\"password\"]")
	WebElement Passwordtxt;
	
	@FindBy(xpath="//div[@class='z0']/div[@role='button']")
	WebElement ComposeBtn;
	
	@FindBy(xpath="//div[@class='J-JN-M-I J-J5-Ji Xv L3 T-I-ax7 T-I']/div[@class='J-J5-Ji J-JN-M-I-JG']")
	WebElement MoreOptionBtn;
	
	@FindBy(xpath="//div[@class='J-Ph Gi J-N']")
	WebElement LabelMenu;
	
	@FindBy(xpath="//div[@class='J-LC']/div[text()='Social']")
	WebElement SocialEmailType;
	
	@FindBy(xpath="//div[@role='menuitem']/div[text()='Apply']")
	WebElement ApplyBtn ;
	
	@FindBy(xpath="//textarea[@name='to']")
	WebElement RecipientsTotxt;
	
	@FindBy(xpath="//input[@name='subjectbox']")
	WebElement Subjecttxt;
	
	@FindBy(xpath="//div[@aria-label='Message Body']")
	WebElement Bodytxt;
	
	@FindBy(xpath="//div[@class='T-I J-J5-Ji aoO v7 T-I-atl L3']")
	WebElement SendBtn;
	
	@FindBy(xpath="//div[text()='Social']")
	WebElement SocialTab;
	
	
	@FindBy(xpath="//div[@class='Cp']//table[@class='F cf zt']/tbody/tr/td[@class='xY a4W']")
	WebElement StarEmail;
	
	@FindBy(xpath="//*[@class='zA zE']//span[@aria-label='Starred']/parent::td/following::td/following::td")
	WebElement EmailRecieved;

	@FindBy(xpath="//div[@class='ha']/h2")
	WebElement EmailSubject;
	
	
	@FindBy(xpath="//div[@class='ii gt']/div[@class='a3s aXjCH ']/div")
	WebElement EmailBody;
	
	
	
	public void SetUserName(String UserName)
	{
		
		UserNametxt.sendKeys(UserName);
		System.out.println("User Name added in Text Box" + UserName);
	}
	
	public void ClickNextBtn(String Page)
	{
		if( Page.equals("Email"))
		{
			clickButton(EmailNextBtn);
			System.out.println("Button Next Clicked After Adding Email ");
		}
		else if (Page.equals("Password"))
		{
			clickButton(PasswordNextBtn);
			System.out.println("Button Next Clicked After Adding Password ");
		}
	}
	
	public void SetPassword(String Password)
	{
		Passwordtxt.sendKeys(Password);
		System.out.println("Password added in Text Box" + Password);
	}
	
	public void ClickOnComposeBtn()
	{
		clickButton(ComposeBtn);
	}
	
	public void SetMailLabelToSocial()
	{
		clickButton(MoreOptionBtn);
		clickButton(LabelMenu);
		clickButton(SocialEmailType);
	}
	
	public void SetEmailRecipientsAndBody(String Body , String Recipients , String Subject)
	{
		RecipientsTotxt.sendKeys(Recipients);
		Subjecttxt.sendKeys(Subject);
		Bodytxt.sendKeys(Body);
	}
	
	public  void SendEmail() {
		clickButton(SendBtn);
	}
	
	public void OpenSocialTab()
	{
		clickButton(SocialTab);
	}
	
	public  void MarkEmailAsStarred(String Subject) {
		System.out.println("Click On Star Button");
		clickButton( StarEmail.findElements(By.xpath("//span[text()='"+Subject+"']/parent::span/parent::div/parent::div/parent::div/parent::td/preceding-sibling::td[@class='apU xY']")).get(0));
		
	}
	
	public  Boolean CheckMailRecievedInSocialTab(String Subject) {

		if(  StarEmail.findElements(By.xpath("//span[text()='"+Subject+"']/parent::span/parent::div/parent::div/parent::div/parent::td/preceding-sibling::td[@class='apU xY']")).get(0).isDisplayed())
		{
			System.out.println("Mail Recieved in Social Tab");
			return true;
		}
	   return false;	
	}
	
	
	public Boolean CheckMailMarkedAsStarred(String Subject)
	{
		  if(StarEmail.findElement(By.xpath("//span[text()='"+Subject+"']/parent::span/parent::div/parent::div/parent::div/parent::td/preceding-sibling::td[@class='apU xY']/span[@aria-label='Starred']")).isDisplayed())
		  {
			  System.out.println("Mail Marked as Starred");
			  return true;
		  }
		  
		  return false;
	}
	
	public void OpenRecievedEmail(String Subject)
	{
		System.out.println("Open Recieved Email");
		clickButton(StarEmail.findElements(By.xpath("//span[text()='"+Subject+"']/parent::span/parent::div")).get(0));
	}
	
	public String[] GetEmailSubjectAndBody()
	{
		String[] EmailContent= new String[2];
		System.out.println("Email Body is "+EmailBody.getText());
		EmailContent[0]=EmailBody.getText();
		System.out.println("Email Subject is "+EmailSubject.getText());
		EmailContent[1]= EmailSubject.getText();
		return EmailContent;
	}
	
	public Boolean checkPageTitleAfterLogIn(String UserName, WebDriver driver1)
	{
		System.out.print(driver1.getTitle());
		if(driver1.getTitle().contains("Inbox") && driver1.getTitle().contains(UserName))
		{ 
			return true;
		}
		return false;
	}
}
