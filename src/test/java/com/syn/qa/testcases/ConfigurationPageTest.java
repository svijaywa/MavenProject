package com.syn.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.syn.qa.base.TestBase;
import com.syn.qa.pages.ConfigurationPage;
import com.syn.qa.pages.HomePage;
import com.syn.qa.pages.LoginPage;

public class ConfigurationPageTest extends TestBase{

	HomePage homePage;
    LoginPage loginPage;
    ConfigurationPage configurationPage;
	
	public ConfigurationPageTest(){
		
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
		configurationPage = new ConfigurationPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage.clickOnMenuLink();
		homePage.ClickOnConfigLink();
	}
	
	@Test(priority=1)
	public void clickOnSearchAPITest(){
		configurationPage.clickOnSearchAPILink();
	}
	
	@Test(priority=2)
	public void clickOnCustomerSettingsTest(){
		configurationPage.clickOnCustomerSettingsLink();
		
	}
	
    @AfterMethod
    public void tearDown(){
    	driver.quit();
    	
    }
	
	
	
}
