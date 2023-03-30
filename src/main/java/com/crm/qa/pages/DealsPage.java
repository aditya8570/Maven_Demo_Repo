package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class DealsPage extends TestBase{
	
	@FindBy(xpath = "(//td[@class='datacardtitle'])[4]")
	WebElement StatusLable;
	
	@FindBy(name="title")
	WebElement Title;
	
	@FindBy(name="client_lookup")
	WebElement Company;
	
	@FindBy(name="amount")
	WebElement Amount;
	
	@FindBy(xpath = "//input[@value='Save']")
	WebElement SaveButton;
	
	public DealsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyDealsPage() {
		return StatusLable.isDisplayed();
	}
	
	public void addnewDeals(String title, String company, String amount, String type) {
		Title.sendKeys(title);
		Company.sendKeys(company);
		Amount.sendKeys(amount);
		Select s = new Select(driver.findElement(By.name("type")));
		s.selectByVisibleText(type);
		
		List<WebElement> Source = driver.findElements(By.xpath("//input[@type='radio']"));
		Source.get(0).click();
		SaveButton.click();
	}
	
	
	
}


