package com.qa.Cucumber_Selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ScreensPage {
	
private String url = "http://localhost:4200/screens";
	
	@FindBy(xpath = "//*[@id=\"body\"]/app-screens/h2")
	private WebElement screensTitle;

	public String getUrl() {
		return url;
	}
	
	public String findscreensTitle() {
		return screensTitle.getText();
	}


}
