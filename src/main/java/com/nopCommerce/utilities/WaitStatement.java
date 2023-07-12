package com.nopCommerce.utilities;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitStatement {
	
	WebDriver ldriver;

	public WaitStatement(WebDriver rdriver){
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public void ExplicitWait(WebElement element) {
		WebDriverWait wait = new WebDriverWait(ldriver,100);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

}
