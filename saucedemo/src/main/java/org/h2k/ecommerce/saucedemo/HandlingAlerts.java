package org.h2k.ecommerce.saucedemo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingAlerts {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
		String parentWindowTitle= driver.getTitle();
		System.out.println("parentWindowTitle::" + parentWindowTitle);
		driver.findElement(By.id("Register")).click();
		//Alert
		Alert alrt = driver.switchTo().alert();
		String validationTextMsg = alrt.getText();
		System.out.println(validationTextMsg);
		alrt.accept(); // click on OK
		//alrt.dismiss(); //click on cancel
		String parentWindowName = driver.getWindowHandle();
		System.out.println(parentWindowName);
	}

}
