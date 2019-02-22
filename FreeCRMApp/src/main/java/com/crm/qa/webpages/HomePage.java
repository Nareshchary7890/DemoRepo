package com.crm.qa.webpages;

import com.crm.qa.baseclass.BaseConfig;

public class HomePage extends BaseConfig{

	public HomePage() {
		super();
	}
	
	public String HomePageTitle() {
		return driver.getTitle();
		
	}
	
}
