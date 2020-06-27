package com.edu;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;//add
import org.testng.Assert;
import org.testng.annotations.AfterMethod;


public class NewTest2 {
	WebDriver driver;
        // Add options to Google Chrome. The window-size is important for responsive sites
        ChromeOptions options = new ChromeOptions(); //add
        options.addArguments("headless"); //add
        //options.addArguments("window-size=1200x600");

  @BeforeMethod
  public void launch() {
	  
	    System.setProperty("webdriver.chrome.driver", "chromedriver");
	    driver = new ChromeDriver(options); //add options
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    driver.get("https://facebook.com");

	  }
  
  @Test
  public void verifyurl() {
	  
	    String x = driver.getCurrentUrl();
	    System.out.println(x);
	    Assert.assertEquals(x, "https://www.facebook.com/");
  }
  
  @Test
  public void verifytitle() {
	  
        String a = driver.getTitle();
        System.out.println(a);
        //Assert.assertEquals(a, "Facebook");
	//System.out.println("Test Successful.");    
  }
  
  @AfterMethod
  public void close() {
	  
	  driver.close();
  }

}
