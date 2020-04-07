package com.syn.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syn.qa.base.TestBase;

public class FeaturesPage extends TestBase {
	
	 @FindBy(xpath="//a/strong[text()='Syngenta']")
	 WebElement SyngentaFeatureLink;
	 

	 @FindBy(xpath="//a[text()='Customer']")
	 WebElement CustomerFeatureLink;
	 
	 @FindBy(xpath="//input[@id='edit-status-syn-customer']")
	 WebElement CustomerFeatureCheckbox;
	 
	 public FeaturesPage(){
		 
		 PageFactory.initElements(driver, this);
		 
	 }
	 
	 public void clickOnCustomerFeatureLink(){
		 SyngentaFeatureLink.click();
		 
	 }
	 public void clickOnCustomerFeatureCheckbox(){
		 CustomerFeatureLink.click();
		 
	 }
	 public void clickOnSyngentaFeatureLink(){
		 if(!CustomerFeatureCheckbox.isSelected())
			 CustomerFeatureCheckbox.click();
		 else
		 {
			 System.out.println("Customer Feature checkbox is checked");
		 }
		
		 
	 }
	 
			 
	

}
