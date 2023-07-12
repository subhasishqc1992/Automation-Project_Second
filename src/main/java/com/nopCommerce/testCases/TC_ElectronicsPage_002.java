package com.nopCommerce.testCases;

import org.testng.annotations.Test;

import com.nopCommerce.pageObjects.CheckOut;
import com.nopCommerce.pageObjects.ElectronicsPage;
import com.nopCommerce.pageObjects.OrderInformation;
import com.nopCommerce.pageObjects.RegisterPage;

public class TC_ElectronicsPage_002 extends baseClass{
	
	@Test
	public void Registration() {
		
		driver.get(URL);
		logger.info("URL is entered");
		
		RegisterPage register = new RegisterPage(driver);
		
		register.RegisterTab();
		register.PersonalDetails(FirstName, LastName, Day, Month, Year, EmailSecond);
		register.CompanyDetails(Company);
		register.YourPassword(passWord);
		register.Registration();
		register.Continue();
		logger.info("Registration is completed");
		
	}
	
	
	@Test(dependsOnMethods = {"Registration"})
	public void Login() {
		
		com.nopCommerce.pageObjects.Login Lp = new com.nopCommerce.pageObjects.Login(driver);
		Lp.SubmitLogin(userNameSecond, passWord);
		logger.info("Username and password is provided");
	}
    
	@Test(dependsOnMethods = {"Login"})
	public void Home_Electronics() {
		ElectronicsPage ep = new ElectronicsPage(driver);
		ep.ElectronicsPage(Product);
		ep.CheckCart();
		CheckOut check = new CheckOut(driver);
		check.SelectCheckout();
		check.BillingAddress(Country,City,PostalCode,Mobile);
		check.ShippingMethod();
		check.PaymentMethod();
		check.PaymentInformation();
		check.ConfirmOrder();
		logger.info("Order Details are added to the Cart");
		
		OrderInformation Info = new OrderInformation(driver);
		Info.OrderNo();
		logger.info("Order is confirmed");
	}


}
