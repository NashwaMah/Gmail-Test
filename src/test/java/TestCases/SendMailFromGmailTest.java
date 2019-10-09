package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import dataProvider.ConfigFileReader;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import pages.SendMailFromGmailPage;

public class SendMailFromGmailTest extends TestBase{

	SendMailFromGmailPage SendMailFromGmailObject;
	ConfigFileReader configFileReader;
	
	@Test()
    @Severity(SeverityLevel.NORMAL)
    @Description("Log in to Gmail with correct UserName and password  ")
	@Step("Add UserName And Password And Verfiy User Logged in Successfully")
    public void LoginToGmail() throws Exception {
	
		configFileReader = new ConfigFileReader();
		SendMailFromGmailObject = new SendMailFromGmailPage(driver);
		SendMailFromGmailObject.SetUserName(configFileReader.getUserName());
		SendMailFromGmailObject.ClickNextBtn("Email");
		SendMailFromGmailObject.SetPassword(configFileReader.getPassword());
		Thread.sleep(500);// wait till next button be clickable
		SendMailFromGmailObject.ClickNextBtn("Password");
		Thread.sleep(1500);// wait till inbox opened 
		Assert.assertTrue(SendMailFromGmailObject.checkPageTitleAfterLogIn(configFileReader.getUserName(),driver));
		
	}
	
	
	
	@Test(dependsOnMethods="LoginToGmail")
    @Severity(SeverityLevel.NORMAL)
    @Description("Send Social Email to Same Recipients that logged in   ")
	@Step("Create Social Email with Subject And Body Then Send And check Email recieved Under Social Tab Correctly")
    public void SendSocialEmail() throws Exception {
	
		configFileReader = new ConfigFileReader();
		SendMailFromGmailObject = new SendMailFromGmailPage(driver);
		SendMailFromGmailObject.ClickOnComposeBtn();
		SendMailFromGmailObject.SetMailLabelToSocial();
		SendMailFromGmailObject.SetEmailRecipientsAndBody(configFileReader.getEmailBody(), configFileReader.getUserName(), configFileReader.getEmailSubject());
		SendMailFromGmailObject.SendEmail();
		SendMailFromGmailObject.OpenSocialTab();
		Thread.sleep(6000); // wait till mail recieved 
		Assert.assertTrue(SendMailFromGmailObject.CheckMailRecievedInSocialTab(configFileReader.getEmailSubject()));
		
		
	}
	
	@Test(dependsOnMethods="SendSocialEmail")
    @Severity(SeverityLevel.NORMAL)
    @Description("Open Social Tab and Mark Email As Starred ")
	@Step("Mark Recieved Mail As Starred and check it marked correctly")
    public void OpenMailAndMarkAsStarred() throws Exception {
	
		configFileReader = new ConfigFileReader();
		SendMailFromGmailObject = new SendMailFromGmailPage(driver);
		SendMailFromGmailObject.MarkEmailAsStarred(configFileReader.getEmailSubject());
		Thread.sleep(3000);
		Assert.assertTrue(SendMailFromGmailObject.CheckMailMarkedAsStarred(configFileReader.getEmailSubject()));
	}
	
	
	@Test(dependsOnMethods="OpenMailAndMarkAsStarred")
    @Severity(SeverityLevel.NORMAL)
    @Description(" Open Email and check Body And Subject is correct  ")
	@Step("Open Recieved Email and Check Body And Subject is Correct")
    public void CheckBodyAndSubjectForTheSocialEmailRecieved() throws Exception {
	
		configFileReader = new ConfigFileReader();
		SendMailFromGmailObject = new SendMailFromGmailPage(driver);
		SendMailFromGmailObject.OpenRecievedEmail(configFileReader.getEmailSubject());
		Assert.assertEquals(SendMailFromGmailObject.GetEmailSubjectAndBody()[0], configFileReader.getEmailBody());
		Assert.assertEquals(SendMailFromGmailObject.GetEmailSubjectAndBody()[1], configFileReader.getEmailSubject());
	}
	
}
