package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.utils.Constants;

public class AccountsPageTest extends BaseTest {

	@BeforeClass
	public void accPageSetup() {
		accountsPage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
	}

	@Test
	public void accPageTitleTest() {
		String title = accountsPage.getAccountPageTitle();
		System.out.println("acc page title is : " + title);
		Assert.assertEquals(title, Constants.ACCOUNTS_PAGE_TITLE);
	}

	@Test
	public void accPageSectionsListTest() {
		List<String> actualSecList = accountsPage.getAccountSecList();
		System.out.println("Acc secs : " + actualSecList);
		Assert.assertEquals(actualSecList, Constants.getExpectedAccSecList());
	}

	@Test
	public void logoutLinkTest() {
		Assert.assertTrue(accountsPage.isLogoutLinkExist());
	}

	@Test
	public void searchExistTest() {
		Assert.assertTrue(accountsPage.isSearchExist());
	}

	@Test
	public void headerTest() {
		Assert.assertEquals(accountsPage.getAccountsPageHeader(), Constants.ACCOUNTS_PAGE_HEADER);
	}
	
	
	@DataProvider
	public Object[][] productData() {
		return new Object[][] {
			{"MacBook"},
			{"iMac"},
			{"Apple"}
		};
	}
	
	@Test(dataProvider = "productData")
	public void searchTest(String productName) {
		searchResultsPage = accountsPage.doSearch(productName);
		Assert.assertTrue(searchResultsPage.getProductListCount()>0);
	}
	
	
	@DataProvider
	public Object[][] productSelectData() {
		return new Object[][] {
			{"MacBook", "MacBook Pro"},
			{"iMac", "iMac"},
			{"Apple", "Apple Cinema 30\""}
		};
	}
	@Test(dataProvider = "productSelectData")
	public void selectProductTest(String productName, String mainProductName) {
		searchResultsPage = accountsPage.doSearch(productName);
		productInfoPage = searchResultsPage.selectProduct(mainProductName);
		Assert.assertEquals(productInfoPage.getProductHeaderText(), mainProductName);
	}
	

}




