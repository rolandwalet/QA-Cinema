package com.qa.Cucumber_Selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LocalVenuesPage {
	
private String url = "http://localhost:4200/local-venues";
	
	@FindBy(xpath = "//*[@id=\"body\"]/app-local-venues/h1")
	private WebElement localVenuesTitle;

	public String getUrl() {
		return url;
	}
	
	public String findLocalVenuesTitle() {
		return localVenuesTitle.getText();
	}

}
