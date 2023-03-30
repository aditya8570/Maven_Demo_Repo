/*
 * Author - Aditya
 */

package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactPageTest extends TestBase{
	
	LoginPage lp;
	HomePage hp;
	TestUtil tl;
	ContactsPage cp;
	String sheetName = "Contacts";
	
	public ContactPageTest() {
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
	    tl.switchToFrame();
	    cp = hp.clickonContactLink();
	}
	
	@Test(priority=1)
	public void verifyingContactPageTest() {
		boolean flag= cp.verifyingContatctPage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=2)
	public void selectcontactsByName() {
		boolean flag = cp.selectcontactByName("Aditya S Modi");
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void selectMultiplecontactsByName() {
		cp.selectcontactByName("Aditya S Modi");
		cp.selectcontactByName("GJX1 4L");
	}
	
	@DataProvider
	public Object[][] getCRMTestData() throws Exception {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	

	
	@Test(priority=4, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title, String firstName, String lastName, String company) {
		hp.clickonNewContactLink();
		//cp.createNewContact("Mr.", "Tom", "Peter", "Google");
		cp.createNewContact(title, firstName, lastName, company);
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
