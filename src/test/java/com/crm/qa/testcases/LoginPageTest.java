package com.crm.qa.testcases;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage lp;
	HomePage hp;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws IOException {
		initialization();
		lp= new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title = lp.validateLoginPageTitle(); //Non-static method
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	
	@Test(priority=2)
	public void crmlogoImageTest() {
		boolean flag =lp.ValidateCRMLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void Login() throws InterruptedException {
		hp = lp.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}