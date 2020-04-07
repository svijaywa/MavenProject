package com.syn.qa.testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.syn.qa.util.ExcelReadWriteUtility;

public class Counting_ContentTypes{
	
	
	   String url;
	   String newUrl;
	   String exit_url = url + "/user/logout";
	   WebDriver driver;
		@Test(groups={"Smoke"})
	    public void content_types() throws Exception {
	        
            
	        ExcelReadWriteUtility.setExcelfile("C:/Soniya/SyngentaProject/TestData/site-migration.xlsx", "Sheet1");
	        int rows = ExcelReadWriteUtility.ExcelWSheet.getLastRowNum() - ExcelReadWriteUtility.ExcelWSheet.getFirstRowNum();
	       // System.out.println(rows);
	        

	        for (int i = 1; i <= rows; i++) {
	          
		      System.setProperty("webdriver.chrome.driver", "C:/Soniya/SeleniumSetup/chromedriver_win32 (1)/chromedriver.exe");
			  driver = new ChromeDriver();
			  driver.manage().window().maximize();

		      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
	          String countryname = ExcelReadWriteUtility.getStringCellData(i, 0);

	            driver.get(countryname);
	            url = driver.getCurrentUrl();
	            newUrl = url +"/user";
	            driver.get(newUrl);
	            
	            WebElement ele = driver.findElement(By.id("edit-name"));
	        	ele.clear();
	        	ele.sendKeys("Prachi_tushar.kadam@syngenta.com");
	        	WebElement ele1 = driver.findElement(By.id("edit-pass"));
	        	ele1.clear();
	        	ele1.sendKeys("Syngenta@2019%%");
	        	WebElement wb = driver.findElement(By.id("edit-submit"));
	        	wb.click();
	        	Thread.sleep(4000);
	        	
	        	driver.findElement(By.xpath("//a[@href=\"/admin\"]")).click();;
	        	driver.findElement(By.xpath("//a[@id=\"navbar-link-admin-structure\"]")).click();
	        	Thread.sleep(3000);
	        	driver.findElement(By.xpath("//li/a[@href=\"/admin/structure/types\"]")).click();
	        	Thread.sleep(3000);
	        	List<WebElement> eles = driver.findElements(By.xpath("//tbody/tr"));
	        	Integer size = eles.size();
	        	String str1 = Integer.toString(size);
	        	System.out.println(str1);
	        	
	        	
	        	List<WebElement> allEle=driver.findElements(By.xpath("//tbody/tr/td[1]"));
	        	
	        	
	        	for(WebElement eles1:allEle)
	        	{	
	        		String val=eles1.getText();
	        		System.out.println(val);
	        	}
	        	driver.close();
	        }
	        
	        
		}
}


	

