package com.qa.Cucumber_Selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FindUsPage {
	
private String url = "http://localhost:4200/location";
	
	@FindBy(xpath = "//*[@id=\"body\"]/app-location/div/h1")
	private WebElement findUsTitle;

	public String getUrl() {
		return url;
	}
	
	public String findFindUsTitle() {
		return findUsTitle.getText();
	}
}
