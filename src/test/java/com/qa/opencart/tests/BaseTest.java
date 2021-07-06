package com.qa.opencart.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.RegistrationPage;
import com.qa.opencart.pages.SearchResultsPage;

public class BaseTest {
	public WebDriver driver;
	public DriverFactory driverFactory;
	public Properties prop;
	public LoginPage loginPage;
	public AccountsPage accountsPage;
	public SearchResultsPage searchResultsPage;
	public ProductInfoPage productInfoPage;
	public RegistrationPage registrationPage;
	
	public SoftAssert softAssert = new SoftAssert();
	
	@BeforeTest
	public void setUp() {
		driverFactory = new DriverFactory();
		prop = driverFactory.init_prop();
		driver = driverFactory.init_driver(prop);
		loginPage = new LoginPage(driver);
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	
	

}




