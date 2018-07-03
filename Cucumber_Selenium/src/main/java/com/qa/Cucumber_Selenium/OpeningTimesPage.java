package com.qa.Cucumber_Selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpeningTimesPage {
	
	private String url = "http://localhost:4200/opening-times";
	
	@FindBy(xpath = "//*[@id=\"body\"]/app-opening-times/div/h1")
	private WebElement openingTimesTitle;

	public String getUrl() {
		return url;
	}
	
	public String findOpeningTimesTitle() {
		return openingTimesTitle.getText();
	}
	

}
