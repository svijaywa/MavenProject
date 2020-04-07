package com.syn.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syn.qa.base.TestBase;

public class SearchAPIPage extends TestBase {
	
	@FindBy(xpath="//td/a[contains(text(), 'Global node index')]")
	WebElement GlobalNodeIndexLink;
	
	public SearchAPIPage()
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public GlobalNodePage ClickOnGlobalNodePage(){
		GlobalNodeIndexLink.click();
		return new GlobalNodePage();
	 
	}

}
