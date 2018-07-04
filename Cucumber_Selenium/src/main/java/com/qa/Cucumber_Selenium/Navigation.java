package com.qa.Cucumber_Selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Navigation {
	
	//NavBar buttons
	@FindBy(xpath = "/html/body/app-root/div/mat-toolbar/mat-toolbar-row[2]/mat-card-content[1]/button")
	private WebElement filmsLink; 
	@FindBy(xpath = "/html/body/app-root/div/mat-toolbar/mat-toolbar-row[2]/mat-card-content[2]/button")
	private WebElement bookingLink; 
	@FindBy(xpath = "/html/body/app-root/div/mat-toolbar/mat-toolbar-row[2]/mat-card-content[3]/button")
	private WebElement InformationLink; 
	@FindBy(xpath = "/html/body/app-root/div/mat-toolbar/mat-toolbar-row[2]/mat-card-content[4]/button")
	private WebElement contactLink;

	@FindBy(xpath = "//*[@id=\"cdk-overlay-0\"]/div/div/button[1]")
	private WebElement whatsonLink; 
	@FindBy(xpath = "//*[@id=\"cdk-overlay-1\"]/div/div/button[2]")
	private WebElement futureReleasesLink; 
	
	@FindBy(xpath = "//*[@id=\"cdk-overlay-0\"]/div/div/button[1]")
	private WebElement openingTimesLink; 
	@FindBy(xpath = "//*[@id=\"cdk-overlay-0\"]/div/div/button[2]")
	private WebElement classificationsLink; 
	@FindBy(xpath = "//*[@id=\"cdk-overlay-0\"]/div/div/button[3]")
	private WebElement ScreensLink; 
	
	//footer Links
	
	@FindBy(xpath = "//*[@id=\"footer\"]/ul[1]/li[1]/a")
	private WebElement home;
	@FindBy(xpath = "//*[@id=\"footer\"]/ul[1]/li[2]/a")
	private WebElement currentlyShowing;
	@FindBy(xpath = "//*[@id=\"footer\"]/ul[1]/li[3]/a")
	private WebElement comingSoon;
	@FindBy(xpath = "//*[@id=\"footer\"]/ul[1]/li[4]/a")
	private WebElement messageBoard;
	@FindBy(xpath = "//*[@id=\"footer\"]/ul[2]/li[1]/a")
	private WebElement openingTimes;
	@FindBy(xpath = "//*[@id=\"footer\"]/ul[2]/li[2]/a")
	private WebElement classifications;
	@FindBy(xpath = "//*[@id=\"footer\"]/ul[2]/li[3]/a")
	private WebElement screens;
	@FindBy(xpath = "//*[@id=\"footer\"]/ul[2]/li[4]/a")
	private WebElement ticketBooking;
	@FindBy(xpath = "//*[@id=\"footer\"]/ul[3]/li[1]/a")
	private WebElement contactUs;
	@FindBy(xpath = "//*[@id=\"footer\"]/ul[3]/li[2]/a")
	private WebElement theLocalArea;
	@FindBy(xpath = "//*[@id=\"footer\"]/ul[3]/li[3]/a")
	private WebElement findUs;
	@FindBy(xpath = "//*[@id=\"footer\"]/ul[3]/li[4]/a")
	private WebElement aboutUs;
	
	//header
	@FindBy(xpath = "//*[@id=\"header\"]/a")
	private WebElement qaCinemaBanner;
	
	
	
	public void clickFilmsLink() {
		filmsLink.click();
	}
	
	public void clickWhatsOn() {
		whatsonLink.click();
	}
	
	
	public void clickBanner() {
		qaCinemaBanner.click();
	}
	
	public void clickInformationButton() {
		InformationLink.click();
	}
	
	public void clickContactUsButton() {
		contactLink.click();
	}
	
	
	//footer navigation
	
	public void clickHomeFooterLink() {
		home.click();
	}
	
	public void clickCurrentlyShowingFooterLink() {
		currentlyShowing.click();
	}
	
	public void clickComingSoonFooterLink() {
		comingSoon.click();
	}
	
	public void clickMessageBoardFooterLink() {
		messageBoard.click();
	}
	
	public void clickOpeningTimesFooterLink() {
		openingTimes.click();
	}
	
	public void clickClassificationsFooterLink() {
		classifications.click();
	}
	
	public void clickScreensFooterLink() {
		screens.click();
	}
	
	public void clickTicketBookingFooterLink() {
		ticketBooking.click();
	}
	
	public void clickContactUsFooterLink() {
		contactUs.click();
	}
	
	public void clickTheLocalAreaFooterLink() {
		theLocalArea.click();
	}
	
	public void clickFindUsFooterLink() {
		findUs.click();
	}
	
	public void clickAboutUsFooterLink() {
		aboutUs.click();
	}
	
	
	
	

}
