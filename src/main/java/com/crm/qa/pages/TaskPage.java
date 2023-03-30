package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class TaskPage extends TestBase{
	
	@FindBy(xpath = "(//td[@class='datacardtitle'])[3]")
	WebElement TaskLable;
	
	@FindBy(name = "title")
	WebElement Title;
	
	@FindBy(name="completion")
	WebElement Completion;
	
	@FindBy(name="prospect_lookup")
	WebElement DealsTag;
	
	@FindBy(xpath = "(//input[@type='submit'])[2]")
	WebElement SaveButton;
	
	public TaskPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyTaskPage() {
		return TaskLable.isDisplayed();
	}
	
	public void addNewTask(String title, String type, String completion, String dealstag) {
		Title.sendKeys(title);
		
		Select s = new Select(driver.findElement(By.name("status")));
		s.selectByVisibleText(type);
		
		Completion.sendKeys(completion);
		DealsTag.sendKeys(dealstag);
		SaveButton.click();
		
	}

}


