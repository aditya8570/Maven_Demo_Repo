package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	
	LoginPage lp;
	HomePage hp;
	TestUtil tl;
	ContactsPage cp;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		initialization();
		lp= new LoginPage();
		hp = new HomePage();
		tl= new TestUtil();
		cp= new ContactsPage();
	    hp = lp.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyingHomePageTitleTest() {
		String Title = hp.VerifyHomePageTitle();
		Assert.assertEquals(Title, "CRMPRO", "HomePage Title not matched");
	}
	
	@Test(priority=2)
	public void verifyingHomePageUsername() {
		tl.switchToFrame();
		boolean flag = hp.VerifyingUserdisplayed();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest() {
		tl.switchToFrame();
		cp = hp.clickonContactLink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

	
}
