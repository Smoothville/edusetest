package com.edu;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.chrome.options; //add

public class NewTest2 {
	//WebDriver driver;
  chrome_options = Options(); //add
  chrome_options.add_argument("--headless"); //add
  driver = webdriver.Chrome(executable_path="./chromedriver", options=chrome_options); //add

  @BeforeMethod
  public void launch() {
	  
	    System.setProperty("webdriver.chrome.driver", "chromedriver");
	    //driver = new ChromeDriver();
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
