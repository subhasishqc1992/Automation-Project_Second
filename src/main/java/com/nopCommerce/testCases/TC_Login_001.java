package com.nopCommerce.testCases;
import org.testng.annotations.Test;

import com.nopCommerce.pageObjects.RegisterPage;

public class TC_Login_001 extends baseClass {
	
	@Test
	public void Registration() {
		
		driver.get(URL);
		
		RegisterPage register = new RegisterPage(driver);
		
		register.RegisterTab();
		register.PersonalDetails(FirstName, LastName, Day, Month, Year, EmailFirst);
		register.CompanyDetails(Company);
		register.YourPassword(passWord);
		register.Registration();
		register.Continue();
		
	}
	
	
	@Test(dependsOnMethods = {"Registration"})
	public void Login() {
		
		com.nopCommerce.pageObjects.Login Lp = new com.nopCommerce.pageObjects.Login(driver);
		Lp.SubmitLogin(userNameFirst, passWord);
	}

}
