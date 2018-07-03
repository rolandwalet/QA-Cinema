package seleniumgluecode;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.Cucumber_Selenium.AboutUsPage;
import com.qa.Cucumber_Selenium.ClassificationsPage;
import com.qa.Cucumber_Selenium.ComingSoonPage;
import com.qa.Cucumber_Selenium.ContactUsPage;
import com.qa.Cucumber_Selenium.FindUsPage;
import com.qa.Cucumber_Selenium.HomePage;
import com.qa.Cucumber_Selenium.LocalVenuesPage;
import com.qa.Cucumber_Selenium.MessageBoardPage;
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

public class NavigationTest {
	
	private WebDriver driver;
	private Navigation nav;
	private HomePage home;
	private WhatsOnPage listings;
	private ComingSoonPage comingSoon;
	private MessageBoardPage msgBoard;
	private OpeningTimesPage opening;
	private ClassificationsPage classifications;
	private ScreensPage screens;
	private ContactUsPage contact;
	private LocalVenuesPage venues;
	private FindUsPage find;
	private AboutUsPage about;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\DevEnvironment\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		nav = PageFactory.initElements(driver, Navigation.class);
		home = PageFactory.initElements(driver, HomePage.class);
		listings = PageFactory.initElements(driver, WhatsOnPage.class);
		comingSoon = PageFactory.initElements(driver, ComingSoonPage.class);
		msgBoard = new MessageBoardPage();
		opening = PageFactory.initElements(driver, OpeningTimesPage.class);
		classifications = PageFactory.initElements(driver, ClassificationsPage.class);
		screens = PageFactory.initElements(driver, ScreensPage.class);
		contact = PageFactory.initElements(driver, ContactUsPage.class);
		venues = PageFactory.initElements(driver, LocalVenuesPage.class);
		find = PageFactory.initElements(driver, FindUsPage.class);
		about = PageFactory.initElements(driver, AboutUsPage.class);
		
		
	}
	
	@Given("^I am on the Home page$")
	public void i_am_on_the_Home_page() {
	    driver.get(home.getUrl());
	}

	@When("^when I press the Home button$")
	public void when_I_press_the_Home_button() {
	    nav.clickHomeFooterLink();
	}

	@Then("^I remain on the Home page$")
	public void i_remain_on_the_Home_page() {
	   assertEquals(home.getUrl(), driver.getCurrentUrl()); 
	}

	@Then("^when navigating to a different page$")
	public void when_navigating_to_a_different_page() {
	    nav.clickOpeningTimesFooterLink();
	}

	@When("^I press click the logo$")
	public void i_press_click_the_logo()  {
		nav.clickBanner();
	    
	}

	@Then("^Im taken back to to the Home Page$")
	public void im_taken_back_to_to_the_Home_Page() {
		assertEquals(home.getUrl(), driver.getCurrentUrl()); 
	}

	@When("^I click the currently showing link$")
	public void i_click_the_currently_showing_link() {
	   nav.clickCurrentlyShowingFooterLink();
	  
	}

	@Then("^I am taken to the films listing page$")
	public void i_am_taken_to_the_films_listing_page()  {
		assertEquals(listings.getUrl(), driver.getCurrentUrl());
	} 

	@Then("^the listings gallery heading is shown$")
	public void the_listings_gallery_heading_is_shown() {
	    assertEquals(true, listings.getContentTitle().contains("Listings Gallery"));
	    
	}

	@When("^I click the Coming Soon link$")
	public void i_click_the_Coming_Soon_link()  {
	   nav.clickComingSoonFooterLink();
	   
	}

	@Then("^I am taken to the Coming Soon page$")
	public void i_am_taken_to_the_Coming_Soon_page() {
	   assertEquals(comingSoon.getUrl(), driver.getCurrentUrl());
	}

	@When("^I click the Message board  link$")
	public void i_click_the_Message_board_link()  {
	    nav.clickMessageBoardFooterLink();
	}

	@Then("^I am taken to the Message board page$")
	public void i_am_taken_to_the_Message_board_page() {
	    assertEquals(msgBoard.getUrl(), driver.getCurrentUrl());
	    
	}

	@When("^I click the Opening Times  link$")
	public void i_click_the_Opening_Times_link() {
	   nav.clickOpeningTimesFooterLink();
	    
	}

	@Then("^I am taken to the Opening Times page$")
	public void i_am_taken_to_the_Opening_Times_page() {
		assertEquals(opening.getUrl(), driver.getCurrentUrl());
	}

	@Then("^the opening times heading is shown$")
	public void the_opening_times_heading_is_shown() {
	   assertEquals(true, opening.findOpeningTimesTitle().contains("Opening Times"));
	}

	@When("^I click the Classifications  link$")
	public void i_click_the_Classifications_link()  {
	   nav.clickClassificationsFooterLink();		
	}

	@Then("^I am taken to the Classifications page$")
	public void i_am_taken_to_the_Classifications_page()  {
		assertEquals(classifications.getUrl(), driver.getCurrentUrl());
	}

	@Then("^the Classifications heading is shown$")
	public void the_Classifications_heading_is_shown() {
		assertEquals(true, classifications.findClassificationsTitle().contains("Film Classifications"));
	}

	@When("^I click the Screens link$")
	public void i_click_the_Screens_link()  {
	   nav.clickScreensFooterLink();
	}

	@Then("^I am taken to the Screens page$")
	public void i_am_taken_to_the_Screens_page() {
	    assertEquals(screens.getUrl(), driver.getCurrentUrl());
	}

	@Then("^the Screeens heading is shown$")
	public void the_Screeens_heading_is_shown()  {
	   assertEquals(true, screens.findscreensTitle().contains("Screens"));
	}

	@When("^I click the contact Us link$")
	public void i_click_the_contact_Us_link() {
	   nav.clickContactUsFooterLink();
	}

	@Then("^I am taken to the Contact Us page$")
	public void i_am_taken_to_the_Contact_Us_page() {
		assertEquals(contact.getUrl(), driver.getCurrentUrl());
	}

	@Then("^the Contact Us heading is shown$")
	public void the_Contact_Us_heading_is_shown() {
	    assertEquals(true, contact.findContactTitle().contains("Contact Us"));
	}

	@When("^I click the Loacal Area link$")
	public void i_click_the_Loacal_Area_link()  {
	   nav.clickTheLocalAreaFooterLink();
	}

	@Then("^I am taken to the Loacal Area page$")
	public void i_am_taken_to_the_Loacal_Area_page()  {
		assertEquals(venues.getUrl(), driver.getCurrentUrl());
	}

	@Then("^the Local Venues heading is shown$")
	public void the_Local_Venues_heading_is_shown() {
		assertEquals(true, venues.findLocalVenuesTitle().contains("Local Venues"));
	}

	@When("^I click the Find Us link$")
	public void i_click_the_Find_Us_link()  {
	   nav.clickFindUsFooterLink();
	}

	@Then("^I am taken to the Find us page$")
	public void i_am_taken_to_the_Find_us_page()  {
		assertEquals(find.getUrl(), driver.getCurrentUrl());
	}

	@Then("^the How to find us heading is shown$")
	public void the_How_to_find_us_heading_is_shown()  {
	    assertEquals(true, find.findFindUsTitle().contains("How to Find"));
	}

	@When("^I click the About Us link$")
	public void i_click_the_About_Us_link() {
	    nav.clickAboutUsFooterLink();
	}

	@Then("^I am taken to the About Us page$")
	public void i_am_taken_to_the_About_Us_page() throws Throwable {
	    assertEquals(about.getUrl(), driver.getCurrentUrl());
	}

	@Then("^the About Us heading is shown$")
	public void the_About_Us_heading_is_shown() throws Throwable {
	   assertEquals(true, about.findAboutUsTitle().contains("QA Cinema Application"));
	}
	
	@After
	public void teardown() {
		driver.close();
	}
}
