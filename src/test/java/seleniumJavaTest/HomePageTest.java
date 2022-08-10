package seleniumJavaTest;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.opencsv.exceptions.CsvValidationException;

import javaConfig.LaunchBrowser;
import javaConfig.UtilsCSV;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class HomePageTest extends LaunchBrowser {

	private static final Logger logger = LogManager.getLogger(HomePageTest.class);
	private WebDriver driver;
	private HomePage homePage;
	Map<String, String> csvData;

	@BeforeTest
	public void setUpTest() throws InterruptedException, IOException {
		driver = InvokeBrowser();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("baseURL"));
	}

	@BeforeClass
	public void loginTest() throws CsvValidationException, IOException {
		LoginPage loginPage = new LoginPage(driver);
		csvData = UtilsCSV.getCSVData(1);
		String userName = csvData.get("userName");
		String password = csvData.get("password");
		loginPage.getEmail().sendKeys(userName);
		loginPage.getPassword().sendKeys(password);
		homePage = loginPage.getLogin();
		logger.info("Logged In Successfully...");
	}

	@Test(priority = 2)
	public void listHeadersTest() throws InterruptedException, IOException {
		List<String> sidebarOptions = homePage.listSidebarNavOptions();

		for (String soption : sidebarOptions) {
			System.out.println(soption);
		}
		homePage.selectSidebarNavOption("Automation").click();
		Thread.sleep(15000);
	}

	@AfterTest
	public void exitTest() {
		driver.quit();
	}

}
