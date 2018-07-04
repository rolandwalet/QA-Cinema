package com.qa.Cucumber_Selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AboutUsPage {
	
private String url = "http://localhost:4200/about-us";
	
	@FindBy(xpath = "//*[@id=\"body\"]/app-about-us/tabset/div/tab[1]/h1")
	private WebElement aboutUsTitle;

	public String getUrl() {
		return url;
	}
	
	public String findAboutUsTitle() {
		return aboutUsTitle.getText();
	}

}
