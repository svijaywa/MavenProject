package com.syn.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.syn.qa.util.ExcelReadWriteUtility;

public class CIP_Panel {
	
	@Test(groups={"Smoke"})
    public void cookie_panel() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:/Soniya/SeleniumSetup/chromedriver_win32 (1)/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        ExcelReadWriteUtility.setExcelfile("C:/Soniya/SyngentaProject/TestData/CIP.xlsx", "Sheet1");
        int rows = ExcelReadWriteUtility.ExcelWSheet.getLastRowNum() - ExcelReadWriteUtility.ExcelWSheet.getFirstRowNum();
        System.out.println(rows);

        for (int i = 0; i <= rows; i++) {
          String countryname = ExcelReadWriteUtility.getStringCellData(i, 0);

            driver.get(countryname);

            if(driver.findElements(By.xpath("//div[@class=\"popup-content info\"]")).size() !=0)		  
            {
            	System.out.println("Element is Present");
            	String Result = "Yes";
                ExcelReadWriteUtility.setCellData("C:/Soniya/SyngentaProject/TestData/CIP.xlsx", "Sheet1", Result, i, 1);
            } else {
            	System.out.println("Element is not Present");
                String Result = "No";
                ExcelReadWriteUtility.setCellData("C:/Soniya/SyngentaProject/TestData/CIP.xlsx", "Sheet1", Result, i, 1);
            }
            
        }
        driver.close();
    }

}
