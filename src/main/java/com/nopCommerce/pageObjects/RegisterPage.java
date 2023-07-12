package com.nopCommerce.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {
	
	WebDriver ldriver;
	Select sel;

	public RegisterPage(WebDriver rdriver){
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(css = ".ico-register")
	WebElement RegisterTab;
	
	@FindBy(css = "#gender-male")
	WebElement Gender;
	
	@FindBy(css = "#FirstName")
	WebElement FirstName;
	
	@FindBy(css = "#LastName")
	WebElement LastName;
	
	@FindBy(xpath = "//select[@name = 'DateOfBirthDay']")
	WebElement Date;
	
	@FindBy(xpath = "//select[@name = 'DateOfBirthMonth']")
	WebElement Month;
	
	@FindBy(xpath = "//select[@name = 'DateOfBirthYear']")
	WebElement Year;
	
	@FindBy(css = "#Email")
	WebElement EmailId;
	
	@FindBy(css = "#Company")
	WebElement CompanyName;
	
	@FindBy(css = "#Password")
	WebElement Password;
	
	@FindBy(css = "#ConfirmPassword")
	WebElement ConfirmPassword;
	
	@FindBy(css = "#register-button")
	WebElement Register;
	
	@FindBy(xpath = "//a[@class='button-1 register-continue-button']")
	WebElement Continue;
	
	public void RegisterTab() {
		RegisterTab.click();
	}
	
	public void PersonalDetails(String firstName, String lastName, String day, String month, String year, String email) {
		Gender.click();
		FirstName.sendKeys(firstName);
		LastName.sendKeys(lastName);
		
		sel = new Select(Date);
		sel.selectByVisibleText(day);
		
		sel = new Select(Month);
		sel.selectByVisibleText(month);
		
		sel = new Select(Year);
		sel.selectByVisibleText(year);
		
		EmailId.sendKeys(email);
	}
	
	public void CompanyDetails(String company) {
		CompanyName.sendKeys(company);
	}
	
	public void YourPassword(String password) {
		Password.sendKeys(password);
		ConfirmPassword.sendKeys(password);
	}
	
	public void Registration() {
		Register.click();
	}
	
	public void Continue() {
		Continue.click();
	}
	

}
