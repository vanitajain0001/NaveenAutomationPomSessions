package com.qa.opencart.pages;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

public class ProductInfoPage {
	private WebDriver driver;
	private ElementUtil elementUtil;

	private By productHeader = By.cssSelector("div#content h1");
	private By productImages = By.cssSelector("ul.thumbnails img");
	private By productMetaData = By.cssSelector("div#content ul.list-unstyled:nth-of-type(1) li");
	private By productPriceData = By.cssSelector("div#content ul.list-unstyled:nth-of-type(2) li");

	private By qty = By.id("input-quantity");
	private By addToCartBtn = By.id("button-cart");

	private By sucessMessg = By.cssSelector("div.alert.alert-success.alert-dismissible");

	private Map<String, String> productInfoMap;

	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	public String getProductHeaderText() {
		return elementUtil.doGetText(productHeader);
	}

	public int getProductImagesCount() {
		return elementUtil.waitForElementsToBeVisible(productImages, 5).size();
	}

	public Map<String, String> getProductInfo() {
		//productInfoMap = new HashMap<String, String>();
		//productInfoMap = new LinkedHashMap<String, String>();
		productInfoMap = new TreeMap<String, String>();

		productInfoMap.put("name", getProductHeaderText());
		getProductMetaData();
		getProductPriceData();
		return productInfoMap;

	}

	private void getProductMetaData() {
		List<WebElement> metaDataList = elementUtil.doGetElements(productMetaData);
		// Brand: Apple
		// meta data:
		for (WebElement e : metaDataList) {
			String text = e.getText();
			String meta[] = text.split(":");
			String metaKey = meta[0].trim();
			String metaValue = meta[1].trim();
			productInfoMap.put(metaKey, metaValue);
		}
	}

	private void getProductPriceData() {
		// price:
		List<WebElement> metaPriceList = elementUtil.doGetElements(productPriceData);
		String price = metaPriceList.get(0).getText().trim();
		String exPrice = metaPriceList.get(1).getText().trim();
		productInfoMap.put("price", price);
		productInfoMap.put("ExTaxPrice", exPrice);
	}

}