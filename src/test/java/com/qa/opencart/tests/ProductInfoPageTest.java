package com.qa.opencart.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ExcelUtil;

public class ProductInfoPageTest extends BaseTest {

	@BeforeClass
	public void accPageSetup() {
		accountsPage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
	}

	
	@DataProvider
	public Object[][] getProductData() {
		return ExcelUtil.getTestData(Constants.PRODUCT_SHEET_NAME);
	}
	
	@Test(dataProvider = "getProductData")
	public void productInfoHeaderTest(String productName, String mainProductName) {
		searchResultsPage = accountsPage.doSearch(productName);
		productInfoPage = searchResultsPage.selectProduct(mainProductName);
		Assert.assertEquals(productInfoPage.getProductHeaderText(), mainProductName);
	}

	
	@Test
	public void productImagesTest() {
		searchResultsPage = accountsPage.doSearch("iMac");
		productInfoPage = searchResultsPage.selectProduct("iMac");
		Assert.assertEquals(productInfoPage.getProductImagesCount(), Constants.IMAC_IMAGE_COUNT);
	}
	
	@Test
	public void productInfoTest() {
		searchResultsPage = accountsPage.doSearch("Macbook");
		productInfoPage = searchResultsPage.selectProduct("MacBook Pro");
		Map<String, String> actProductInfoMap = productInfoPage.getProductInfo();
		actProductInfoMap.forEach((k,v) -> System.out.println(k + ":"+ v));
		
		softAssert.assertEquals(actProductInfoMap.get("name"), "MacBook Pro");
		softAssert.assertEquals(actProductInfoMap.get("Brand"), "Apple");
		softAssert.assertEquals(actProductInfoMap.get("Product Code"), "Product 18");
		softAssert.assertEquals(actProductInfoMap.get("price"), "$2,000.00");

		softAssert.assertAll();
	}
	
	
}




