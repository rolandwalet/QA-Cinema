package com.qa.Cucumber_Selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClassificationsPage {
	
private String url = "http://localhost:4200/classifications";
	
	@FindBy(xpath = "//*[@id=\"body\"]/app-classifications/h2")
	private WebElement classificationsTitle;

	public String getUrl() {
		return url;
	}
	
	public String findClassificationsTitle() {
		return classificationsTitle.getText();
	}

}
