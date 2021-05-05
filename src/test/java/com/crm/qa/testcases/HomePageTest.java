package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.AdminPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	AdminPage adminPage;
	TestUtil testUtil;

	public HomePageTest() {
		super();
	}

	//test cases should be separated -- independent with each other
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "OrangeHRM","Home page title not matched");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest(){
		
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
	@Test(priority=2)
	public void clickOnAdminLinkTest(){
		
		adminPage = homePage.clickOnAdminLink();
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	

}
