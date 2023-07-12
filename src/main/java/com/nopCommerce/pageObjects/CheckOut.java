package com.nopCommerce.pageObjects;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.nopCommerce.utilities.WaitStatement;

public class CheckOut {
	
	WebDriver ldriver;
	
	public CheckOut(WebDriver rdriver){
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(css = "#termsofservice")
	WebElement CheckBox;
	
	@FindBy(css = "#checkout")
	WebElement CheckOut;
	
	@FindBy(css = "#checkout_attribute_1")
	WebElement GiftWrapping;
	
	@FindBy(css = "#BillingNewAddress_CountryId")
	WebElement CountryName;
	
	@FindBy(css = "#BillingNewAddress_StateProvinceId")
	WebElement StateName;
	
	@FindBy(css = "#BillingNewAddress_City")
	WebElement CityName;
	
	@FindBy(css = "#BillingNewAddress_Address1")
	WebElement AddressOne;
	
	@FindBy(css = "#BillingNewAddress_ZipPostalCode")
	WebElement PostalCode;
	
	@FindBy(css = "#BillingNewAddress_PhoneNumber")
	WebElement Mobile;
	
	@FindBy(xpath = "//button[text()='Continue']")
    List<WebElement> ContinueBtn;
	
	@FindBy(css = "#shippingoption_1")
	WebElement Shipping;
	
	@FindBy(css = "#paymentmethod_0")
	WebElement Payment;
	
	@FindBy(xpath = "//button[text()='Confirm']")
	WebElement ConfirmBtn;
	
	public void SelectCheckout() {
		WaitStatement wait = new WaitStatement(ldriver);
		wait.ExplicitWait(GiftWrapping);
		
		Select Gift = new Select(GiftWrapping);
		Gift.selectByIndex(1);
		
		CheckBox.click();
		CheckOut.click();
	}
	
	public void BillingAddress(String SelectCountry, String City,String PostalCd,String MobileNo) {
		Select Country = new Select(CountryName);
		Country.selectByVisibleText(SelectCountry);
		
		Select State = new Select(StateName);
		WaitStatement WaitForElement = new WaitStatement(ldriver);
		WaitForElement.ExplicitWait(StateName);
		State.selectByIndex(0);
		
		CityName.sendKeys(City);
		AddressOne.sendKeys(City);
		PostalCode.sendKeys(PostalCd);
		Mobile.sendKeys(MobileNo);
		ContinueBtn.get(0).click();	
		
	}
	
	public void ShippingMethod() {
		Shipping.click();
		ContinueBtn.get(2).click();
		
	}
	
	public void PaymentMethod() {
		Payment.click();
		ContinueBtn.get(3).click();
	}
	
	public void PaymentInformation() {
		ContinueBtn.get(4).click();
	}
	
	public void ConfirmOrder() {
		ConfirmBtn.click();
	}

}
