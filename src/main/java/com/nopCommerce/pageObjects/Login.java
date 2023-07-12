package com.nopCommerce.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nopCommerce.utilities.WaitStatement;

public class Login {
	
	WebDriver ldriver;

	public Login(WebDriver rdriver){
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//a[text() = 'Log in']")
	WebElement LoginLink;
	
	@FindBy(css = ".email")
	WebElement Username;
	
	@FindBy(css = ".password")
	WebElement Password;
	
	@FindBy(xpath = "//button[@class='button-1 login-button']")
	WebElement Login;
	
	public void SubmitLogin(String name, String password) {
		WaitStatement wait = new WaitStatement(ldriver);
		wait.ExplicitWait(LoginLink);
		LoginLink.click();
		Username.sendKeys(name);
		Password.sendKeys(password);
		Login.click();
	}

}
