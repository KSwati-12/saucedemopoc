package org.h2k.ecommerce.saucedemo;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingWindows {

		public static void main(String args[]) throws IOException  {
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.rediff.com/");
			String parentWindowTitle= driver.getTitle();
			System.out.println("parentWindowTitle" + parentWindowTitle);
			
			//Navigate to Child Window
			//id or name or index starts with zero
			//NoSuchFrameException
			driver.switchTo().frame("moneyiframe");
			driver.findElement(By.id("query")).sendKeys("TCS");
			driver.findElement(By.className("getqbtn")).click();
			
			//Navigate to Parent Window
			driver.switchTo().defaultContent();
			
			parentWindowTitle= driver.getTitle();
			System.out.println("parentWindowTitle" + parentWindowTitle);
			
			//Handling Windows Logic
			System.out.println("######################Handling Windows Logic########################");
			String parentWindowName = driver.getWindowHandle();
			System.out.println("parentWindowName::" +parentWindowName);
			
			//Set - unique values [HashSet,TreeSet,LinkedHashSet]
		    Set<String> windowSet= driver.getWindowHandles();
		    System.out.println("Number of windows::"+ windowSet.size());
		    for(String wName:windowSet)
		    {
		    	System.out.println("wName Set Value::" + wName);
		    	if(!(wName.equals(parentWindowName)))
		    	{
		    		driver.switchTo().window(wName);
		    		if(driver.getTitle().contains("TATA"))
		    		{
		    			System.out.println("Child window Title Name::" + driver.getTitle());
		    			System.out.println("Stock Price::" + driver.findElement(By.id("ltpid")).getText());
		    			break;
		    		}
		    	}
		    }
            
		    driver.switchTo().window(parentWindowName);
		    System.out.println("Parent Window Title Name::"+ driver.getTitle());
		    driver.close();//close the browsers/windows which has focus by driver object
			
			driver.quit();//close all the browsers/windows which are launched by driver object

	}

}
