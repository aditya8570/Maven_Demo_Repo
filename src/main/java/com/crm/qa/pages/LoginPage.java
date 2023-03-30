package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//PageFactory - Object Reposatory - OR
	
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement lb;
	
	@FindBy(linkText = "Sign Up")
	WebElement SignUp;
	
	@FindBy(xpath= "//a[@class='navbar-brand']//img[@class='img-responsive']")
	WebElement crmlogo;
	
	
	public LoginPage() throws IOException{
		PageFactory.initElements(driver, this);
		
	}
	
	//Actions
	//Validate Title Page
	
	public String validateLoginPageTitle() {
		return driver.getTitle();	
	}
	
	//Validate CRM Logo
	
	public boolean ValidateCRMLogo() {
		return crmlogo.isDisplayed();
	}
	
	//Login Method
	
	public HomePage login(String un, String pw) throws InterruptedException {
		username.sendKeys(un);
		password.sendKeys(pw);
		Thread.sleep(4000);
		lb.click();
		return new HomePage();
	}

}