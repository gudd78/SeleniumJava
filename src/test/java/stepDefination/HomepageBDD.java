package stepDefination;

import java.io.IOException;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.opencsv.exceptions.CsvValidationException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import javaConfig.LaunchBrowser;
import javaConfig.UtilsCSV;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import seleniumJavaTest.HomePageTest;

@RunWith(Cucumber.class)
public class HomepageBDD extends LaunchBrowser{
	private static final Logger logger = LogManager.getLogger(HomePageTest.class);
	private WebDriver driver;
	private HomePage homePage;
	LoginPage loginPage;
	
	@Given("Login with to navigate to home page")
	public void login_with_to_navigate_to_home_page() throws InterruptedException, IOException, CsvValidationException {
		driver = InvokeBrowser();
		driver.manage().window().maximize();
		
	}

	@When("Get url LambdaTest")
	public void get_url_lambda_test() {
		driver.get(prop.getProperty("baseURL"));
		loginPage = new LoginPage(driver);
	}

	@When("Enter Username")
	public void enter_username() {
		loginPage.getEmail().sendKeys(prop.getProperty("username"));
	}

	@When("Enter Password")
	public void enter_password() {
		loginPage.getPassword().sendKeys(prop.getProperty("password"));
		homePage = loginPage.getLogin();
	}

	@Then("Homepage is displayed")
	public void login_successful() {
	    System.out.println(homePage.getHeaderAltText());
	    System.out.println(homePage.getWelcomeMsg());
	}
	
	@Then("Exit Browser after 10000ms")
	public void exit_browser() throws InterruptedException {
	    Thread.sleep(10000);
	    driver.close();
	}
	
}
