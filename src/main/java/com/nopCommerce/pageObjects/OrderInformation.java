package com.nopCommerce.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderInformation {
	
	WebDriver ldriver;

	public OrderInformation(WebDriver rdriver){
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(css = ".order-number")
	WebElement OrderNumber;
	
	@FindBy(xpath = "//button[text()='Continue']")
	WebElement ContinueBtn;
	
	public void OrderNo() {
		System.out.println(OrderNumber.getText());
		ContinueBtn.click();
	}
	

}
