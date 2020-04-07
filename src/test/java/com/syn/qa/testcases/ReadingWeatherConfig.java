package com.syn.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.syn.qa.util.ExcelUtils;

public class ReadingWeatherConfig {

	public static void main(String[] args) throws Exception {
		
//		System.setProperty("webdriver.chrome.driver", "C:/Soniya/SeleniumSetup/chromedriver_win32 (1)/chromedriver.exe");
//		 
//		// Initialize browser
//		WebDriver driver=new ChromeDriver();
//		 
//		// Open site
//		driver.get("https://Syngenta:Syngenta1@syngentamodel.test-syngentacp.acsitefactory.com/user");
//		WebElement ele = driver.findElement(By.id("edit-name"));
//		ele.clear();
//		ele.sendKeys("soniya.vijaywargi@syngenta.com");
//		WebElement ele1 = driver.findElement(By.id("edit-pass"));
//		ele1.clear();
//		ele1.sendKeys("10Soniya#2018!1");
//		WebElement wb = driver.findElement(By.id("edit-submit"));
//		wb.click();
//		 
//		// Maximize browser
//		 
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		Thread.sleep(3000);


		ExcelUtils.setExcelfile("C:\\Users\\u955590\\workspace\\TestProject\\src\\main\\java\\com\\syn\\qa\\testdata\\weather_config.xlsx", "Weather widget configuration");
		int rowCount = ExcelUtils.ExcelWSheet.getLastRowNum() - ExcelUtils.ExcelWSheet.getFirstRowNum();
		
		
		for (int i=0; i<=rowCount; i++)
			//here i=0 depends if we need to start from first row and i=1when there is header row in the sheet
			{
		      String str =	ExcelUtils.getStringCellData(i, 1);
		      System.out.println(str);
			}
         
		
		
	}

}
