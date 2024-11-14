package org.h2k.ecommerce.saucedemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

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
	
	@Test
	public void login()
	{
		SauceDemoJava demo1  = new SauceDemoJava();
		demo1.loginSauceDemo(); 
	}
	
}
