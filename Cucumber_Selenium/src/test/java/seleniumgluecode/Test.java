package seleniumgluecode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.Cucumber_Selenium.Navigation;
import com.qa.Cucumber_Selenium.WhatsOnPage;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;

public class Test {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	private Navigation nav;
	private WhatsOnPage whatson;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\DevEnvironment\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		nav = PageFactory.initElements(driver, Navigation.class);
		wait = new WebDriverWait(driver, 3); 
	}
	
		
	@Given("^The QA_cinema homepage$")
	public void the_QA_cinema_homepage()  {
	    driver.get("http://localhost:4200/home");
	   
	}
	
	@When("^I navigate to the whats on page$")
	public void i_navigate_to_the_whats_on_page() {
	   nav.clickFilmsLink();
	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"cdk-overlay-0\"]/div/div/button[1]"))).click();
	}
	
	@Then("^I see the films that are on$")
	public void i_see_the_films_that_are_on() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"pageContent\"]/h3[4]")));
		whatson = PageFactory.initElements(driver, WhatsOnPage.class);
		assertEquals(true, whatson.findfilm1().contains("Deadpool")&&(whatson.findfilm2().contains("Jurassic World"))&&(whatson.findfilm3().contains("Solo")));
	   
	}
	
	@Then("^showing details for each film$")
	public void showing_details_for_each_film() throws Throwable {
	  assertEquals(true, whatson.showingTable1().contains("00")&&(whatson.showingTable2().contains("00")));	   
	}
	
	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}

}

// https://www.pluralsight.com/guides/how-to-implement-a-simple-wait-using-java-and-selenium?gclid=EAIaIQobChMI_cv3v_qA3AIVExIbCh07XQl2EAAYAiAAEgLZp_D_BwE&aid=701j0000001heIpAAI&promo=&oid=&utm_source=non_branded&utm_medium=digital_paid_search_google&utm_campaign=UK_Dynamic&utm_content=&pbb2c=1&s_kwcid=AL!5668!3!277727472908!b!!g!!&ef_id=Wzpi8gAABa@WjVza:20180702173754:s


