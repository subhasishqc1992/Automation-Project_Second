package com.nopCommerce.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.nopCommerce.utilities.WaitStatement;

public class ElectronicsPage {
WebDriver ldriver;
	

	public ElectronicsPage(WebDriver rdriver){
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//a[text()=' Electronics ']")
	WebElement Electronics;
	
	@FindBy(xpath = "//a[text()=' Cell phones ']")
	WebElement CellPhone;
	
	@FindBy(xpath= "//div[@class='item-grid']/div/div/div[@class='details']")
	List<WebElement> productTitle;
	
	@FindBy(xpath = "//a[text() = 'Shopping cart']")
	WebElement ShoppingCart;
	
	@FindBy(xpath = "//a[@class='product-name']")
	WebElement Product;
	
	@FindBy(xpath = "//span[@class='close']")
	WebElement CloseBtn;
	
	public void ElectronicsPage(String ProductName) {
		Electronics.click();
		CellPhone.click();
		
		for (int i = 0; i< productTitle.size();i++) {
			
		WebElement web =productTitle.get(i);
		
		List<WebElement> NameofTheProduct = web.findElements(By.xpath("//h2/a"));
		
		for(int j=0; j<NameofTheProduct.size();j++) {
			WebElement ActualOne = NameofTheProduct.get(j);
			if (ActualOne.getText().equalsIgnoreCase(ProductName)) {
				List<WebElement> ActualProduct = web.findElements(By.xpath("//div[@class='add-info']/div[@class='buttons']/button[@class='button-2 product-box-add-to-cart-button']"));
				WebElement SelectTheProduct = ActualProduct.get(j);
				SelectTheProduct.click();
			}
		}
			
		}
		}
	
	public void CheckCart() {
		
		CloseBtn.click();
		WaitStatement wait = new WaitStatement(ldriver);
		wait.ExplicitWait(ShoppingCart);
		
		Actions act = new Actions(ldriver);
		act.moveToElement(ShoppingCart).click().build().perform();
		
		//String GetProductName = Product.getText();
		//Assert.assertEquals(GetProductName, ProductName);
		
		
	}
}
