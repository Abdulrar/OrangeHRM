package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//*[contains(text(),'Welcome')]")
	@CacheLookup
	WebElement userNameLabel;

	@FindBy(xpath = "//*[@alt='OrangeHRM']")
	WebElement imgLogo;
	
	@FindBy(xpath = "//*[@id='menu_admin_viewAdminModule']")
	WebElement adminLink;
	
	
	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	
	public boolean verifyCorrectUserName(){
		return userNameLabel.isDisplayed();
	}
	
	public AdminPage clickOnAdminLink(){
		
		adminLink.click();
		
		return new AdminPage();
	}
	
	
	
	
	
	
	

}
