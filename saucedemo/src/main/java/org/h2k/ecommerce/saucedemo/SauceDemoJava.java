package org.h2k.ecommerce.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
/* 1.This java class methods are used as test cases using annotations in test class SauceDemoTest.java
   2.No main method is used in this SauceDemoJava java class which is going to be used in test class to create test cases
   3.Methods are non static so it can be called in test class with object of this java class 
   4.Constructor is created and webdriver parameter is passed to constructor */
public class SauceDemoJava {
	WebDriver driver;

	public SauceDemoJava(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver= driver;
	}

	// create methods addtoCart->checkout-fillDetails-finish-logout 

		public void loginSauceDemo()
		{
			driver.findElement( By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		       
		    driver.findElement(By.id("password")).sendKeys("secret_sauce");
		        
		    driver.findElement(By.id("login-button")).click(); 
		}
		
		public void addToCart()
		{
			//Add to cart  button name=add-to-cart-sauce-labs-bike-light, remove button:name="remove-sauce-labs-bike-light"
			   //driver.findElement(By.tagName("//button[@name='add-to-cart-sauce-labs-bike-light';]")).click();
		       driver.findElement(By.name("add-to-cart-sauce-labs-bike-light")).click();
		       WebElement element = driver.findElement(By.name("remove-sauce-labs-bike-light"));
		       String buttonText =null;
		       buttonText = element.getText();
		       System.out.println(buttonText);
		}
		public void checkout()
		{
			//span class="shopping_cart_badge"
			//e.findElement(By.className("shopping_cart_link")).click();
		       driver.findElement(By.className("shopping_cart_badge")).click();
		       //checkout button id="checkout"
		       driver.findElement(By.id("checkout")).click();
		       //name =firstName ,placeholder="First Name"
		       driver.findElement(By.name("firstName")).sendKeys("Jemmy");
		       driver.findElement(By.name("lastName")).sendKeys("Walt");
		       driver.findElement(By.name("postalCode")).sendKeys("85432");
		       driver.findElement(By.name("continue")).click();
		       driver.findElement(By.name("finish")).click();
		       WebElement e = driver.findElement(By.xpath("//h2[contains(text(),'Thank you for your order!')]"));
		       String actual= e.getText();
		       String expected="Thank you for your order!";

		       if(actual.equals(expected))
		       {

		           System.out.println("Its working as expected");

		       }
		}
		//public static void fillDetails()
		//public static void finish()
		{}
		public void logout() throws InterruptedException
		{
			driver.findElement(By.id("react-burger-menu-btn")).click();
			//driver.findElement(By.xpath("//a[text()='Logout']/parent::nav/following-sibling::a[1]/a")).click();
			//driver.findElement(By.xpath("//a[@id='logout_sidebar_link']")).click();
			//driver.findElement(By.xpath("//a[normalize-space()='Logout'][1]")).click();.
			Thread.sleep(5000);
			
			driver.findElement(By.id("logout_sidebar_link")).click();
			
			
		}
		
	}


