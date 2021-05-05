package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.AdminPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class AdminPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	AdminPage adminPage;
	TestUtil testUtil;

	String sheetName = "adduser";
	
	public AdminPageTest() {
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
		homePage = new HomePage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		adminPage = homePage.clickOnAdminLink();
		adminPage.clickOnAddButton();
	}
	
	/*
	 * @Test(priority=1) public void clickOnAdminLinkTest(){
	 * 
	 * homePage.clickOnAdminLink(); }
	 */
	
	@Test(priority=1)
	public void verifyAdminPageTitleTest(){
		String adminPageTitle = adminPage.verifyAdminPageTitle();
		Assert.assertEquals(adminPageTitle, "OrangeHRM","Admin page title not matched");
	}
	
	
	@Test(priority=2)
	public void addUserTest(){
		adminPage.addUser();
		//Verify navigate to home page 
		Assert.assertTrue(homePage.verifyCorrectUserName());
		
	}
	
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority=3, dataProvider="getCRMTestData")
	public void addUserWithDataDrivenApprochTest(String empName, String un, String pw, String cpw){
		//adminPage.addUserWithDataDrivenApproch("Ananya Dash", "userName", "Password", "Password");
		adminPage.addUserWithDataDrivenApproch(empName, un, pw, cpw);
		
		//Verify navigate to home page 
		Assert.assertTrue(homePage.verifyCorrectUserName());
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	

}
