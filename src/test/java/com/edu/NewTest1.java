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


public class NewTest1 {
	
  WebDriver driver;
   // Add options to Google Chrome. The window-size is important for responsive sites
   ChromeOptions options = new ChromeOptions();//add
   options.addArguments("headless");//add
   //options.addArguments("window-size=1200x600");
  
 
  @BeforeMethod
  public void beforeMethod() {
	  
	    System.setProperty("webdriver.chrome.driver", "chromedriver");
	    driver = new ChromeDriver(options);//add
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://35.193.29.31:30015/sampleapp/");
  }
  
  @Test
  public void addContact() {
	  
	 	driver.findElement(By.xpath("//div[@class = 'v-button v-widget']")).click();
		driver.findElement(By.id("gwt-uid-5")).sendKeys("Naresh");
		driver.findElement(By.id("gwt-uid-7")).sendKeys("T");
		driver.findElement(By.id("gwt-uid-9")).sendKeys("805983095");
		driver.findElement(By.id("gwt-uid-11")).sendKeys("test@gmail.com");
		driver.findElement(By.xpath("//div[@class = 'v-button v-widget primary v-button-primary']")).click();
			
	}
  
  @Test
  public void verifytitle() {
	  
        String a = driver.getTitle();
        System.out.println(a);
        Assert.assertEquals(a, "sampleapp");
	    System.out.println("Test Successful."); 
  }
  
  @AfterMethod
  public void afterMethod() {  
	  driver.close();
  }

}
