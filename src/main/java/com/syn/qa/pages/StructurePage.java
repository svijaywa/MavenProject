package com.syn.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syn.qa.base.TestBase;

public class StructurePage extends TestBase{
	
	@FindBy(xpath="//li/a[contains(text(), 'Features')]")
	WebElement FeaturesLink;
	
	public StructurePage()
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public FeaturesPage clickOnFeatureLinkPage(){
		FeaturesLink.click();
		return new FeaturesPage();
	}
	

}
