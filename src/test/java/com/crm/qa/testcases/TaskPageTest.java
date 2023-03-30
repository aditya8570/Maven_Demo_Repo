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
import com.crm.qa.pages.TaskPage;
import com.crm.qa.util.TestUtil;

public class TaskPageTest extends TestBase{
	LoginPage lp;
	HomePage hp;
	TestUtil tl;
	ContactsPage cp;
	DealsPage dp;
	TaskPage tp;
	String sheetName = "Task";
	
	public TaskPageTest() {
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
	    tp = hp.clickonTasksLink();
	}
	
	@Test(priority=1)
	public void verifyTaskPageTest() {
		Assert.assertTrue(tp.verifyTaskPage());
	}
	
	@DataProvider
	public Object[][] getCRMTest() throws Exception {
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=2, dataProvider="getCRMTest")
	public void addNewTaskTest(String title, String type, String completion, String dealstag) {
		hp.clickonNewTaskLink();
		tp.addNewTask(title, type, completion, dealstag);
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
