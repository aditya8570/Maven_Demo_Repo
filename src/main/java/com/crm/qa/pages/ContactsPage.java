 package com.crm.qa.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{

	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement ContactLable;
	
	@FindBy(id="first_name")
	WebElement FirstName;
	
	@FindBy(id="surname")
	WebElement LastName;
	
	@FindBy(name="client_lookup")
	WebElement CompanyName;
	
	@FindBy(xpath = "(//input[@type='submit'])[1]")
	WebElement SaveButton;
	

	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyingContatctPage() {
		return ContactLable.isDisplayed();
	}
	
	public boolean selectcontactByName(String Name) {
		 driver.findElement(By.xpath("//a[text()='"+Name+"']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
		return true;
	}
	
	public void createNewContact(String title, String firstName, String lastName, String company) {
		Select s = new Select(driver.findElement(By.name("title")));
		s.selectByVisibleText(title);
		
		FirstName.sendKeys(firstName);
		LastName.sendKeys(lastName);
		CompanyName.sendKeys(company);
		SaveButton.click();
	}
	

	
	
}
