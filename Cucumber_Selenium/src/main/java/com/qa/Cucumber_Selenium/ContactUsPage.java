package com.qa.Cucumber_Selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage {
	
private String url = "http://localhost:4200/contact";
	
	@FindBy(xpath = "//*[@id=\"body\"]/app-contact/h2")
	private WebElement contactTitle;

	public String getUrl() {
		return url;
	}
	
	public String findContactTitle() {
		return contactTitle.getText();
	}

}
