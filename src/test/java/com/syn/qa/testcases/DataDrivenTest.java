package com.syn.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.syn.qa.util.Xls_Reader;

public class DataDrivenTest {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:/Soniya/SeleniumSetup/chromedriver_win32 (1)/chromedriver.exe");
		 
		// Initialize browser
		WebDriver driver=new ChromeDriver();
		 
		// Open site
		driver.get("https://Syngenta:Syngenta1@syngentamodel.test-syngentacp.acsitefactory.com/user");
		WebElement ele = driver.findElement(By.id("edit-name"));
		ele.clear();
		ele.sendKeys("soniya.vijaywargi@syngenta.com");
		WebElement ele1 = driver.findElement(By.id("edit-pass"));
		ele1.clear();
		ele1.sendKeys("10Soniya#2018!1");
		WebElement wb = driver.findElement(By.id("edit-submit"));
		wb.click();
		 
		// Maximize browser
		 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(3000);
		
		
		
		Xls_Reader reader = new Xls_Reader("C:\\Users\\u955590\\workspace\\TestProject\\src\\main\\java\\com\\syn\\qa\\testdata\\weather_config.xlsx");
		
		String logged_in = reader.getCellData("Weather widget configuration","Number of days to be displayed when logged in" , 1);
		System.out.println(logged_in);
		
		String Notlogged_in = reader.getCellData("Weather widget configuration","Number of days to be displayed when user is not logged in" , 2);
		System.out.println(Notlogged_in);
		
		String pred_bar = reader.getCellData("Weather widget configuration","Show predictability bar on widget" , 3);
		System.out.println(pred_bar);
		
		String color_max = reader.getCellData("Weather widget configuration","Colour code for maximum temp" , 4);
		System.out.println(color_max);
		
		String color_min = reader.getCellData("Weather widget configuration","Colour code for minimu temp" , 5);
		System.out.println(color_min);
		
		
		
		

	}

}
