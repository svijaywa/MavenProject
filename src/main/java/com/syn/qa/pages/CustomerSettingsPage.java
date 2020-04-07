package com.syn.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.syn.qa.base.TestBase;

public class CustomerSettingsPage extends TestBase {
	

	@FindBy(xpath="//a/strong[text()= 'Social networks']")
	 WebElement socialNetworkLink;
	
	@FindBy(id="edit-syn-social-login-enable")
	 WebElement socialLogin;
	
	@FindBy(id="edit-syn-customer-social-logins-enabled-facebook")
	 WebElement facebookLogin;
	
	@FindBy(id="edit-syn-customer-social-logins-enabled-Google")
	 WebElement googleLogin;
	
	@FindBy(id="edit-syn-customer-social-logins-enabled-Twitter")
	 WebElement twitterLogin;
	
	@FindBy(id="edit-syn-customer-social-logins-enabled-Linkedln")
	 WebElement linkedlnLogin;
	
	public void fillCustomerSettingsForm(String Prof, String Pref, String Reg, String UserDash, String UserDash1){
		
		
		WebElement iframeMsg = driver.findElement(By.xpath("//div[@id='cke_1_contents']/iframe[contains(@class, 'cke_wysiwyg_frame cke_reset')]"));        
		driver.switchTo().frame(iframeMsg);
		WebElement body = driver.findElement(By.cssSelector("body"));
		body.sendKeys(Prof);
		driver.switchTo().defaultContent();
		

		WebElement iframeMsg1 = driver.findElement(By.xpath("//div[@id='cke_2_contents']/iframe[contains(@class, 'cke_wysiwyg_frame cke_reset')]"));        
		driver.switchTo().frame(iframeMsg1);
		WebElement body1 = driver.findElement(By.cssSelector("body"));
		body1.sendKeys(Pref);
		driver.switchTo().defaultContent();
		

		WebElement iframeMsg2 = driver.findElement(By.xpath("//div[@id='cke_3_contents']/iframe[contains(@class, 'cke_wysiwyg_frame cke_reset')]"));        
		driver.switchTo().frame(iframeMsg2);
		WebElement body2 = driver.findElement(By.cssSelector("body"));
		body2.sendKeys(Reg);
		driver.switchTo().defaultContent();

		WebElement iframeMsg3 = driver.findElement(By.xpath("//div[@id='cke_4_contents']/iframe[contains(@class, 'cke_wysiwyg_frame cke_reset')]"));        
		driver.switchTo().frame(iframeMsg3);
		WebElement body3 = driver.findElement(By.cssSelector("body"));
		body3.sendKeys(UserDash);
		driver.switchTo().defaultContent();

		WebElement iframeMsg4 = driver.findElement(By.xpath("//div[@id='cke_5_contents']/iframe[contains(@class, 'cke_wysiwyg_frame cke_reset')]"));        
		driver.switchTo().frame(iframeMsg4);
		WebElement body4 = driver.findElement(By.cssSelector("body"));
		body4.sendKeys(UserDash1);
		driver.switchTo().defaultContent();
		
		driver.findElement(By.id("edit-submit")).click();
		
		socialNetworkLink.click();
	
		
		
	}

}
