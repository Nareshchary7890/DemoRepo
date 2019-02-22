package com.crm.qa.webpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.baseclass.BaseConfig;
	

public class LoginPage extends BaseConfig{
	
	@FindBy(how=How.XPATH,using="//input[@name='username']")
	@CacheLookup
	WebElement Username;
	
	@FindBy(how=How.XPATH,using="//input[@name='password']")
	@CacheLookup
	WebElement Password;
	
	@FindBy(how=How.XPATH,using="//input[@type='submit' and @value='Login']")
	@CacheLookup
	WebElement LoginBtn;
	
	@FindBy(how=How.XPATH,using="(//img[@class='img-responsive'])[1]")
	@CacheLookup
	WebElement CRMLogo ;
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public String verifyLoginTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyCRMLogo() {
		return CRMLogo.isDisplayed();
	}
	
	
	public HomePage verifyLogin(String usrnm, String pwd) throws InterruptedException {
		Username.sendKeys(usrnm);
		Password.sendKeys(pwd);
		Thread.sleep(2000);
		
		LoginBtn.click();
		return new HomePage();
		
	}
	
	
	
	
	
	
	
}
