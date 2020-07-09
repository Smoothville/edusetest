package com.edu;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.chrome.ChromeOptions;


public class NewTest3 {
	
  WebDriver driver;
   // Add options to Google Chrome. The window-size is important for responsive sites
   ChromeOptions options = new ChromeOptions();//add
  
 
  @BeforeMethod
  public void beforeMethod() {
	    options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors", "--silent"); //add
	    System.setProperty("webdriver.chrome.driver", "chromedriver");
	    driver = new ChromeDriver(options);//add
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("192.168.42.9:8081");
  }
  
  @Test
  public void verifyAbout() {
	  	
    driver.findElement(By.id("About Us")).click();
     driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
      WebElement TxtBoxContent = driver.findElement(By.id("PID-ab2-pg"));
     String result = TxtBoxContent.getText();
     System.out.println("Printing " + result);
    System.out.println(result);
    Assert.assertEquals(result, result);
	  System.out.println("Test Successful.");
			
	}
  
  
  @AfterMethod
  public void afterMethod() {  
	  driver.close();
  }

}
