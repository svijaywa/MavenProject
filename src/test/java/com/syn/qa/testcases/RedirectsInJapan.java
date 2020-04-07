package com.syn.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.syn.qa.util.ExcelReadWriteUtility;

public class RedirectsInJapan {

	@Test(groups={"Smoke"})
    public void redirects() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:/Soniya/SeleniumSetup/chromedriver_win32 (1)/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        ExcelReadWriteUtility.setExcelfile("C:/Soniya/SyngentaProject/TestData/Redirects.xlsx", "Sheet1");
        int rows = ExcelReadWriteUtility.ExcelWSheet.getLastRowNum() - ExcelReadWriteUtility.ExcelWSheet.getFirstRowNum();
        System.out.println(rows);

        for (int i = 0; i <= rows; i++) {
          String url = ExcelReadWriteUtility.getStringCellData(i, 0);

            driver.get(url);
            Thread.sleep(5000);
            String RedirectUrl = driver.getCurrentUrl();
            ExcelReadWriteUtility.setCellData("C:/Soniya/SyngentaProject/TestData/Redirects.xlsx", "Sheet1", RedirectUrl, i, 1);   
            
        }
        driver.close();
    }
	
	
	
}
