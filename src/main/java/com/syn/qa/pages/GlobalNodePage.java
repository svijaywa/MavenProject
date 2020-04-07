package com.syn.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syn.qa.base.TestBase;

public class GlobalNodePage extends TestBase{

	@FindBy(xpath="//input[@id='edit-reindex']")
	WebElement GlobalReindexBtn;
	
	@FindBy(xpath="//input[@id='edit-submit']")
	WebElement ConfirmBtn;
	
	@FindBy(xpath="//input[@id='edit-button']")
	WebElement IndexNowBtn;
	
	public GlobalNodePage(){
		
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnReindexPage(){
		GlobalReindexBtn.click();
		
	}
	public void clickOnConfirmBtnPage(){
		ConfirmBtn.click();
		
	}
	
	public void clickOnIndexNowBtnPage(){
		IndexNowBtn.click();
		
	}
	
	
}
