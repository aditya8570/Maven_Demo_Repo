package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath = "//td[contains(text(),'User: Aditya Shah')]")
	WebElement User;
	
	@FindBy(xpath = "//div[@id='navmenu']/ul/li[4]")
	WebElement Contacts;
	
	@FindBy(xpath = "//div[@id='navmenu']/ul/li[5]")
	WebElement Deals;
	
	@FindBy(xpath = "//div[@id='navmenu']/ul/li[6]")
	WebElement Tasks;
	
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement NewContacts;
	
	@FindBy(xpath="//a[contains(text(),'New Deal')]")
	WebElement NewDeals;
	
	@FindBy(xpath="//a[contains(text(),'New Task')]")
	WebElement NewTasks;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String VerifyHomePageTitle() {
		return driver.getTitle();	
	}
	
	public boolean VerifyingUserdisplayed() {
		return User.isDisplayed();
	}
	
	public ContactsPage clickonContactLink() {
		Contacts.click();
		return new ContactsPage();
	}
	
	public DealsPage clickonDealsLink() {
		Deals.click();
		return new DealsPage();
	}
	
	public TaskPage clickonTasksLink() {
		Tasks.click();
		return new TaskPage();
	}
	
	public void clickonNewContactLink() {
		Actions builder = new Actions(driver);
		builder.moveToElement(Contacts).build().perform();
		 NewContacts.click();	
	}
	
	public void clickonNewDealLink() {
		Actions builder = new Actions(driver);
		builder.moveToElement(Deals).build().perform();
		NewDeals.click();
	}
	
	public void clickonNewTaskLink() {
		Actions builder = new Actions(driver);
		builder.moveToElement(Tasks).build().perform();
		NewTasks.click();
	}
	
	
	
	

	
}
