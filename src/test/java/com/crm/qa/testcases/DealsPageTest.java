/*
 * Author:Aditya
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
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class DealsPageTest extends TestBase{
	LoginPage lp;
	HomePage hp;
	TestUtil tl;
	ContactsPage cp;
	DealsPage dp;
	String sheetName = "Deals";
	
	public DealsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		initialization();
		lp= new LoginPage();
		hp = new HomePage();
		tl= new TestUtil();
		cp= new ContactsPage();
		dp= new DealsPage();
	    hp = lp.login(prop.getProperty("username"), prop.getProperty("password"));
	    tl.switchToFrame();
	    dp = hp.clickonDealsLink();
	}
	
	@Test(priority=1)
	public void verifyDealsTestPage() {
		Assert.assertTrue(dp.verifyDealsPage());
	}
	
	@DataProvider
	public Object[][] getCRMdata() throws Exception{
		Object[][]data = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=2, dataProvider ="getCRMdata")
	public void addnewDealsTest(String title, String company, String amount, String type) {
		hp.clickonNewDealLink();
		dp.addnewDeals(title, company, amount, type);		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
