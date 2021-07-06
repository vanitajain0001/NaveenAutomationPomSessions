package com.qa.opencart.utils;

import java.util.Arrays;
import java.util.List;

public class Constants {

	public final static String LOGIN_PAGE_TITLE = "Account Login";
	public final static String ACCOUNTS_PAGE_TITLE = "My Account";

	public final static String ACCOUNTS_PAGE_HEADER = "Your Store";

	public final static int IMAC_IMAGE_COUNT = 3;
	public final static int MACBOOK_PRO_IMAGE_COUNT = 4;
	
	public final static String REGISTER_SUCCESS_MESSG = "Your Account Has Been Created!";
	
	public final static String REGISTER_SHEET_NAME = "register";
	public final static String PRODUCT_SHEET_NAME = "productinfo";

	

	public static List<String> getExpectedAccSecList() {
		return Arrays.asList("My Account", "My Orders", "My Affiliate Account", "Newsletter");
	}

}




