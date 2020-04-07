package com.syn.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syn.qa.base.TestBase;

public class HomePage extends TestBase{
	
	//PageFactory - OR
	
	@FindBy(xpath="//a[contains(@title, 'Admin menu')]")
	WebElement MenuBtn;
	
	@FindBy(xpath="//a[contains(@title, 'Administer settings.')]")
	WebElement ConfigBtn;
	
	@FindBy(xpath="//a[text()='Structure']")
	WebElement StructureLink;
	
	public HomePage(){
		
		PageFactory.initElements(driver, this);	
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
		
	}
	
	public void clickOnMenuLink(){
		MenuBtn.click();
		
	}
	
	public ConfigurationPage ClickOnConfigLink(){
		ConfigBtn.click();
		return new ConfigurationPage();
		
	}
	
	public StructurePage clickOnStructureLink(){
		StructureLink.click();
		return new StructurePage();
		
	} 
	
}
