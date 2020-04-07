package com.syn.qa.testcases;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BarCodeRead {

	@Test
	public void downloadPDFfile() throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver",
				"C:/Soniya/SeleniumSetup/chromedriver_win32 (1)/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Open site
		driver.get("https://barcode.tec-it.com/en");

		// Maximize browser

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String barcodeUrl = driver.findElement(By.tagName("img")).getAttribute("src");
		System.out.println(barcodeUrl);

		URL url = new URL(barcodeUrl);
		BufferedImage bufferedImage = ImageIO.read(url);
	}

}
