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
	  String a = "This is about page. Lorem Ipsum Dipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.

It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).";
	 	
    driver.findElement((By.id("About Us")).click();
		String result = driver.findElement(By.id("PID-ab2-pg"));
    System.out.println(result);
    Assert.assertEquals(result, a);
	  System.out.println("Test Successful.");
			
	}
  
  
  @AfterMethod
  public void afterMethod() {  
	  driver.close();
  }

}
