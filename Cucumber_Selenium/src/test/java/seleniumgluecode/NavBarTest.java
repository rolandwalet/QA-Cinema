package seleniumgluecode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.Cucumber_Selenium.ClassificationsPage;
import com.qa.Cucumber_Selenium.ComingSoonPage;
import com.qa.Cucumber_Selenium.ContactUsPage;
import com.qa.Cucumber_Selenium.HomePage;
import com.qa.Cucumber_Selenium.Navigation;
import com.qa.Cucumber_Selenium.OpeningTimesPage;
import com.qa.Cucumber_Selenium.ScreensPage;
import com.qa.Cucumber_Selenium.WhatsOnPage;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;

public class NavBarTest {
	
	private WebDriver driver;
	private Navigation nav;
	private WebDriverWait wait;
	
	private HomePage home;
	private WhatsOnPage listings;
	private ComingSoonPage comingSoon;
	private OpeningTimesPage opening;
	private ClassificationsPage classifications;
	private ScreensPage screens;
	private ContactUsPage contact;
	
	
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\DevEnvironment\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 3); 
		nav = PageFactory.initElements(driver, Navigation.class);
		home = PageFactory.initElements(driver, HomePage.class);
		listings = PageFactory.initElements(driver, WhatsOnPage.class);
		comingSoon = PageFactory.initElements(driver, ComingSoonPage.class);
		opening = PageFactory.initElements(driver, OpeningTimesPage.class);
		classifications = PageFactory.initElements(driver, ClassificationsPage.class);
		screens = PageFactory.initElements(driver, ScreensPage.class);
		contact = PageFactory.initElements(driver, ContactUsPage.class);
	}
	
	@Given("^I am on any page of the site$")
	public void i_am_on_any_page_of_the_site() {
		driver.get(home.getUrl()); 
	   
	}

	@When("^I press the Films Button$")
	public void i_press_the_Films_Button() {
		nav.clickFilmsLink();	   
	}

	@When("^I press the Whats on button on the drop down$")
	public void i_press_the_Whats_on_button_on_the_drop_down() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"cdk-overlay-0\"]/div/div/button[1]"))).click();
		
	}

	@Then("^I am taken to the listing page$")
	public void i_am_taken_to_the_listing_page() {
	   assertEquals(listings.getUrl(), driver.getCurrentUrl());
	}

	@When("^I press the Future Releases button on the drop down$")
	public void i_press_the_Future_Releases_button_on_the_drop_down() {	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"cdk-overlay-0\"]/div/div/button[2]"))).click();
	}

	@Then("^I am taken to the FutureReleases page$")
	public void i_am_taken_to_the_Future_Releases_page() {
		assertEquals(comingSoon.getUrl(), driver.getCurrentUrl());
	   
	}

	@When("^I press the Information Button$")
	public void i_press_the_Information_Button() {
	   nav.clickInformationButton();
	   
	}

	@When("^I press the Opening Times button on the drop down$")
	public void i_press_the_Opening_Times_button_on_the_drop_down() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"cdk-overlay-0\"]/div/div/button[1]"))).click();
	   
	}
	
	@Then("^I am taken to the OpeningTimes page")
	public void I_am_taken_to_the_OpeningTimes_page() {
		assertEquals(opening.getUrl(), driver.getCurrentUrl());
	}

	@When("^I press the Classifications button on the drop down$")
	public void i_press_the_Classifications_button_on_the_drop_down() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"cdk-overlay-0\"]/div/div/button[2]"))).click();
	   
	}
	
	@Then("^I am taken to the Classification page")
	public void I_am_taken_to_the_Classification_page() {
		assertEquals(classifications.getUrl(), driver.getCurrentUrl());
	}

	@When("^I press the Screens button on the drop down$")
	public void i_press_the_Screens_button_on_the_drop_down() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"cdk-overlay-0\"]/div/div/button[3]"))).click();
	   
	}
	
	@Then("^I am taken to the Screen page")
	public void I_am_taken_to_the_Screen_page() {
		assertEquals(screens.getUrl(), driver.getCurrentUrl());
	}

	@When("^I press the Conact Us Button$")
	public void i_press_the_Conact_Us_Button() {
	   nav.clickContactUsButton();
	   
	}

	@Then("^I am taken to the ContactUs Page$")
	public void i_am_taken_to_the_Contact_Us_Page() {
	   assertEquals(contact.getUrl(), driver.getCurrentUrl());
	   
	}
	
	@After
	public void teardown() {
		driver.close();
	}

}
