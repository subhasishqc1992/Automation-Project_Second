package com.nopCommerce.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
public ReadConfig() {
		
		File src = new File("./ConfigurationFiles/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}
		
		catch (Exception e) {
			System.out.println("Exception is"+ e.getMessage());
		}
		 
	}
	
	public String GetCurrentUrl() {
		String BaseUrl = pro.getProperty("URL");
		return BaseUrl;
	}
	
	public String Password() {
		String BasePassword = pro.getProperty("passWord");
		return BasePassword;
	}
	
	public String FirstTestCase() {
		String BaseuserName = pro.getProperty("userName_FirstTestCase");
		return BaseuserName;
	}
	
	public String UserNameSecondTestCase() {
		String BaseuserName = pro.getProperty("userName_SecondTestCase");
		return BaseuserName;
	}
	
	public String ChromeDriver() {
		String BaseChropath = pro.getProperty("ChroPath");
		return BaseChropath;
	}
	
	public String FirefoxDriver() {
		String BaseFirepath = pro.getProperty("FirePath");
		return BaseFirepath;
	}
	
	public String IeDriver() {
		String BaseIePath = pro.getProperty("IePath");
		return BaseIePath;
	}
	
	public String FirstName() {
		String FirstNm = pro.getProperty("FirstName");
		return FirstNm;
	}
	
	public String LastName() {
		String LastNm = pro.getProperty("LastName");
		return LastNm;
	}
	
	public String Day() {
		String day = pro.getProperty("Day");
		return day;
	}
	
	public String Month() {
		String month = pro.getProperty("Month");
		return month;
	}
	
	public String Year() {
		String year = pro.getProperty("Year");
		return year;
	}
	
	public String CompanyName() {
		String Company = pro.getProperty("Company");
		return Company;
	}
	
	public String ProductName() {
		String Product = pro.getProperty("ProductName");
		return Product;
	}
	
	public String CountryName() {
		String Country = pro.getProperty("SelectCountry");
		return Country;
	}
	
	public String CityName() {
		String City = pro.getProperty("City");
		return City;
	}
	
	public String PostalCode() {
		String Pin = pro.getProperty("PostalCd");
		return Pin;
	}
	
	public String MobileNo() {
		String Mobile = pro.getProperty("MobileNo");
		return Mobile;
	}


}
