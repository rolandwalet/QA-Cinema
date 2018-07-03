package com.qa.Cucumber_Selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WhatsOnPage {
	
	private String url = "http://localhost:4200/listings-gallery";
	
	@FindBy(xpath ="//*[@id=\"body\"]/app-listings-gallery/h2")
	private WebElement listingsGalleryHeader;
	
	@FindBy(xpath = "//*[@id=\"pageContent\"]/h3[1]")
	private WebElement film1Container;

	@FindBy(xpath = "//*[@id=\"pageContent\"]/h3[2]")
	private WebElement film2Container;

	@FindBy(xpath = "//*[@id=\"pageContent\"]/h3[3]")
	private WebElement film3Container;
	
	@FindBy(xpath = "//*[@id=\"pageContent\"]/h3[4]")
	private WebElement film4Container;
	
	@FindBy(xpath = "//*[@id=\"pageContent\"]/table[1]")
	private WebElement ShowingTable1;
	
	@FindBy(xpath = "//*[@id=\"pageContent\"]/table[2]")
	private WebElement ShowingTable2;
	
	public String findfilm1() {
		return film1Container.getText();
	}
	
	public String findfilm2() {
		return film2Container.getText();
	}
	
	public String findfilm3() {
		return film3Container.getText();
	}
	
	public String findfilm4() {
		return film4Container.getText();
	}
	
	public String showingTable1() {
		return ShowingTable1.getText();		
	}
	
	public String showingTable2() {
		return ShowingTable2.getText();		
	}

	public String getUrl() {
		return url;
	}
	
	public String getContentTitle() {
		return listingsGalleryHeader.getText();
	}
	
	
	
	
	

}
