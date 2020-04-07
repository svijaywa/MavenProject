package com.syn.qa.testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.syn.qa.util.ExcelReadWriteUtility;

public class NumberOfContents {
	
	WebDriver driver;
	String url;
	String newUrl;
	String exit_url = url + "/user/logout";
	
	@Test(groups={"Smoke"})
    public void Number_Of_Contents() throws Exception {
        
        
        ExcelReadWriteUtility.setExcelfile("C:/Soniya/SyngentaProject/TestData/NumberOfContents.xlsx", "Sheet1");
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
        	ele1.sendKeys("Syngenta@2019$$");
        	WebElement wb = driver.findElement(By.id("edit-submit"));
        	wb.click();
        	Thread.sleep(4000);
        	
        	driver.findElement(By.xpath("//a[@href=\"/admin\"]")).click();;
        	driver.findElement(By.xpath("//a[@id=\"navbar-link-admin-content\"]")).click();
        	Thread.sleep(3000);
        	driver.findElement(By.xpath("//div[@id=\"edit-type-wrapper\"]/div/div/div/a/span")).click();
        	Thread.sleep(3000);
        	List<WebElement> allEle = driver.findElements(By.xpath("//div[@class= \"chosen-drop\"]/ul/li"));
        	System.out.println(allEle.size());
        	
        	for(int j=2; j<allEle.size(); j++) {
        	   
        	   String content_name = driver.findElement(By.xpath("//div[@class= \"chosen-drop\"]/ul/li["+j+"]")).getText();
        	   System.out.println(content_name);
        	   driver.findElement(By.xpath("//div[@class= \"chosen-drop\"]/ul/li["+j+"]")).click();
        	   driver.findElement(By.xpath("//div/input[@id=\"edit-submit-administration-nodes-clone\"]")).click();
        	   Thread.sleep(4000);
        	   
        	   if(driver.findElements(By.xpath("//ul[@class=\"pager\"]/li[@class=\"pager-item\"]")).size() !=0)		  
               {
        		   
        		   List<WebElement> counts =   driver.findElements(By.xpath("//tbody/tr"));
        		   System.out.println(counts.size()-1);
        		   List<WebElement> count_pager =   driver.findElements(By.xpath("//ul[@class=\"pager\"]/li[@class=\"pager-item\"]"));
        		   
        		   for(int k=1; k<=count_pager.size(); k++) {
        			   List<WebElement> count =   driver.findElements(By.xpath("//tbody/tr"));
            		   System.out.println(count.size()-1);      
        		   }  
        		   
               } else {
            	   
            	   if(driver.findElements(By.xpath("//tbody/tr[@class=\"views-row-first views-row-last\"]")).size() !=0)
               {
            		  
            		   System.out.println(driver.findElement(By.xpath("//tbody/tr/td")).getText());  
            	   }
               else {
            	   
            	   List<WebElement> count1 =   driver.findElements(By.xpath("//tbody/tr"));
        		   System.out.println(count1.size()); 
            	   	   
               }	  
               } 
        	   driver.findElement(By.xpath("//div[@id=\"edit-type-wrapper\"]/div/div/div/a/span")).click();    
        	      }
        	driver.close();
        }
        
        
	}
	

}
