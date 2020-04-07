package com.syn.qa.testcases;

import java.io.FileNotFoundException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.syn.qa.base.TestBase;
import com.syn.qa.pages.ConfigurationPage;
import com.syn.qa.pages.CustomerSettingsPage;
import com.syn.qa.pages.HomePage;
import com.syn.qa.pages.LoginPage;
import com.syn.qa.util.TestUtil;

public class CustomerSettingsTest extends TestBase{
	
	HomePage homePage;
    LoginPage loginPage;
    ConfigurationPage configurationPage;
    CustomerSettingsPage customerSettingsPage;
    String sheetName = "Customer Profile";
	
	public CustomerSettingsTest(){
		
		super();
	}
	
	//test cases should be independent to each other
	//before each test case launch the browser and login
	//after each test case, close the browser
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage = new LoginPage();
		customerSettingsPage = new CustomerSettingsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage.clickOnMenuLink();
		configurationPage = homePage.ClickOnConfigLink();	
		customerSettingsPage = configurationPage.clickOnCustomerSettingsLink();
	}
	
	@DataProvider
	public Object[][] getCustomerProfileTestData() throws FileNotFoundException{
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
		
	}
	
	
	@Test(priority=1, dataProvider="getCustomerProfileTestData")
	public void fillCustomerSettingsFormTest(String MyProfile, String MyPref, String Reg, String UserDash, String UserDash1){
		customerSettingsPage.fillCustomerSettingsForm(MyProfile, MyPref, Reg, UserDash, UserDash1);
		
		
	}
	
  @AfterMethod
    public void tearDown(){
    	driver.quit();
    	
    }
	
	
	
	

}
