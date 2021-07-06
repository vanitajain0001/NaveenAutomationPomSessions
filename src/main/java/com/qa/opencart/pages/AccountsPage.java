package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class AccountsPage {

	private WebDriver driver;
	private ElementUtil elementUtil;

	private By header = By.cssSelector("div#logo h1");
	private By accountSections = By.cssSelector("div#content h2");
	private By searchField = By.name("search");
	private By searchButton = By.xpath("//div[@id='search']//button[@type='button']");
	private By logoutLink = By.linkText("Logout");

	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}

	public String getAccountPageTitle() {
		return elementUtil.waitForTitleIs(Constants.ACCOUNTS_PAGE_TITLE, 5);
	}

	public String getAccountsPageHeader() {
		return elementUtil.doGetText(header);
	}

	public boolean isLogoutLinkExist() {
		return elementUtil.doIsDisplayed(logoutLink);
	}

	public void logout() {
		if (isLogoutLinkExist()) {
			elementUtil.doClick(logoutLink);
		}
	}

	public List<String> getAccountSecList() {
		List<WebElement> accSecList = elementUtil.waitForElementsToBeVisible(accountSections, 5);
		List<String> accSecValList = new ArrayList<String>();
		for (WebElement e : accSecList) {
			accSecValList.add(e.getText());
		}
		return accSecValList;
	}

	public boolean isSearchExist() {
		return elementUtil.doIsDisplayed(searchField);
	}
	
	public SearchResultsPage doSearch(String productName) {
		System.out.println("searching the product: " + productName);
		elementUtil.doSendKeys(searchField, productName);
		elementUtil.doClick(searchButton);
		return new SearchResultsPage(driver);
	}
	
	
	
	

}




