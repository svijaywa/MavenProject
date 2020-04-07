package com.syn.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.syn.qa.base.TestBase;
import com.syn.qa.pages.ConfigurationPage;
import com.syn.qa.pages.FeaturesPage;
import com.syn.qa.pages.HomePage;
import com.syn.qa.pages.LoginPage;
import com.syn.qa.pages.SearchAPIPage;
import com.syn.qa.pages.StructurePage;

public class FeaturesPageTest extends TestBase {
	
	HomePage homePage;
    LoginPage loginPage;
    ConfigurationPage configurationPage;
    StructurePage structurePage;
    FeaturesPage featuresPage;
	
	public FeaturesPageTest(){
		
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
		structurePage = homePage.clickOnStructureLink();
		featuresPage =  structurePage.clickOnFeatureLinkPage();
			
	}
	
	@Test
	public void clickOnSyngentaFeatureTest(){
		featuresPage.clickOnSyngentaFeatureLink();
		featuresPage.clickOnCustomerFeatureLink();
		featuresPage.clickOnCustomerFeatureCheckbox();
		
	}
	
	
    @AfterMethod
    public void tearDown(){
    	driver.quit();
    	
    }
	
	
	

}
