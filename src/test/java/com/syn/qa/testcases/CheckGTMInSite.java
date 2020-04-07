package com.syn.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.syn.qa.util.ExcelDataConfig;
import com.syn.qa.util.ExcelReadWriteUtility;

public class CheckGTMInSite {
	
	@Test(groups={"Smoke"})
    public void siteHack() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:/Soniya/SeleniumSetup/chromedriver_win32 (1)/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        ExcelReadWriteUtility.setExcelfile("C:/Soniya/SyngentaProject/TestData/GTM_Demo.xlsx", "Sheet1");
        int rows = ExcelReadWriteUtility.ExcelWSheet.getLastRowNum() - ExcelReadWriteUtility.ExcelWSheet.getFirstRowNum();
        System.out.println(rows);

        for (int i = 0; i <= rows; i++) {
          String countryname = ExcelReadWriteUtility.getStringCellData(i, 0);

            driver.get(countryname);
            Thread.sleep(5000);

            if(driver.getPageSource().contains("https://www.googletagmanager.com/gtm.js"))
            {
                String Result = "GTM is present";
                System.out.println("GTM is present");
                ExcelReadWriteUtility.setCellData("C:/Soniya/SyngentaProject/TestData/GTM_Demo.xlsx", "Sheet1", Result, i, 1);
            } else {
                String Result = "GTM is Not present";
                System.out.println("GTM is not Present");
                ExcelReadWriteUtility.setCellData("C:/Soniya/SyngentaProject/TestData/GTM_Demo.xlsx", "Sheet1", Result, i, 1);
            }
            
        }
        driver.close();
    }
}