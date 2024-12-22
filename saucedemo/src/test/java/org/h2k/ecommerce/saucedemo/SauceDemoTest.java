package org.h2k.ecommerce.saucedemo;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/* This test case java class is for methods from java class SauceDemoJava.java*/
/* To run this program right click on SauceDemotestnag.xml-->run as TenstNG Suite*/
/* Add SauceDemotestnag.xml in pom.xml unde <configuration>
          <suiteXmlFiles>  
            <suiteXmlFile>SauceDemotestng.xml</suiteXmlFile>*/


public class SauceDemoTest {
	WebDriver driver;
	
	@BeforeTest
	public void lauchBrowser()
	{   
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
	}
	
	@Test(priority=1)
	public void login()
	{
		SauceDemoJava demo1  = new SauceDemoJava(driver);
		
		demo1.loginSauceDemo(); 
		//demo1.addToCart();
	}
	
	@Test(priority=2)
	public void addToCart()
	{
		SauceDemoJava demo2 = new SauceDemoJava(driver);
		demo2.addToCart();
	}
	
	
}
