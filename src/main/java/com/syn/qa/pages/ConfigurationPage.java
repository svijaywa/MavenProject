package com.syn.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syn.qa.base.TestBase;

public class ConfigurationPage extends TestBase {
	
	@FindBy(xpath="//li/a[contains(text(), 'Search API')]")
	WebElement searchapilink;
	
	@FindBy(xpath="//li/a[text()='Customer settings']")
	WebElement CustomerSettingsLink;
	
	public ConfigurationPage(){
		
		PageFactory.initElements(driver, this);
	}
	
	public SearchAPIPage clickOnSearchAPILink(){
		searchapilink.click();
		return new SearchAPIPage();
		
		
	}
	
	public CustomerSettingsPage clickOnCustomerSettingsLink(){
		CustomerSettingsLink.click();
		return new CustomerSettingsPage();
		
		
	}

}
