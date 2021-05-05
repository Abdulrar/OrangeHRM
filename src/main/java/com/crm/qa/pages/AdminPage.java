package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class AdminPage extends TestBase{

	
	@FindBy(id="btnAdd")
	@CacheLookup
	WebElement addBtn;	
	
	@FindBy(id="systemUser_userType")
	WebElement userRoleDD;
	
	@FindBy(id="systemUser_employeeName_empName")
	WebElement employeeName;
	
	@FindBy(id="systemUser_userName")
	WebElement userName;
	
	@FindBy(id="systemUser_status")
	WebElement status;
	
	@FindBy(id="systemUser_password")
	WebElement password;
	
	@FindBy(id="systemUser_confirmPassword")
	WebElement confirmPassword;
	
	@FindBy(id="btnSave")
	WebElement saveBtn;

	
	// Initializing the Page Objects:
		public AdminPage() {
			PageFactory.initElements(driver, this);
		}
	
		
		public String verifyAdminPageTitle(){
			return driver.getTitle();
		}
		
		public void clickOnAddButton(){
		
			addBtn.click();
		}
		
		public void addUser() {
			
			Select select = new Select(userRoleDD);
			select.selectByIndex(1);
			employeeName.sendKeys("Ananya Dash");
			userName.sendKeys("userName");
			
			Select selectStatus = new Select(status);
			selectStatus.selectByIndex(1);
			
			password.sendKeys("password");
			confirmPassword.sendKeys("password");
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
	    	js.executeScript("arguments[0].click();", saveBtn);
			//saveBtn.click();
			//return new HomePage();
			
		}
		
		
public void addUserWithDataDrivenApproch(String empName, String un, String pw, String cpw ) {
			
			Select select = new Select(userRoleDD);
			select.selectByIndex(1);
			employeeName.sendKeys(empName);
			userName.sendKeys(un);
			
			Select selectStatus = new Select(status);
			selectStatus.selectByIndex(1);
			
			password.sendKeys(pw);
			confirmPassword.sendKeys(cpw);
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
	    	js.executeScript("arguments[0].click();", saveBtn);
			saveBtn.click();
			//return new HomePage();
			
		}
		
}
