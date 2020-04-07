package com.syn.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syn.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//PageFactory - OR
	@FindBy(name="name")
	WebElement username;
	
	@FindBy(name= "pass")
	WebElement password;
	
	@FindBy(id= "edit-submit")
	WebElement loginBtn;
	
	public LoginPage()
	{	
		PageFactory.initElements(driver, this);	
	}
	
	public String validateLoginTitle(){
		return driver.getTitle();
		
	}
	
	public HomePage login(String un, String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
		
	}	

}
