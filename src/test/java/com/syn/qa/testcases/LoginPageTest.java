package com.syn.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.syn.qa.base.TestBase;
import com.syn.qa.pages.HomePage;
import com.syn.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest(){
		super();
	}
	
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage = new LoginPage();
		
	}
	
	@Test
	public void loginTest(){
	homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
		
	}
	

}
