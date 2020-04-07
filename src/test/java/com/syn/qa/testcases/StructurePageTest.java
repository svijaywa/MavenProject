package com.syn.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.syn.qa.base.TestBase;
import com.syn.qa.pages.ConfigurationPage;
import com.syn.qa.pages.HomePage;
import com.syn.qa.pages.LoginPage;
import com.syn.qa.pages.SearchAPIPage;

public class StructurePageTest extends TestBase {
	
	HomePage homePage;
    LoginPage loginPage;
    ConfigurationPage configurationPage;
    SearchAPIPage searchAPIPage;
	
	public StructurePageTest(){
		
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
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage.clickOnMenuLink();
		homePage.clickOnStructureLink();
		
		
	}
	
	
	
    @AfterMethod
    public void tearDown(){
    	driver.quit();
    	
    }
	

}
