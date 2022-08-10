package seleniumJavaTest;


import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import javaConfig.LaunchBrowser;
import pageObjects.LoginPage;

public class LoginPageTest extends LaunchBrowser{
	private static final Logger logger = LogManager.getLogger(LoginPageTest.class);
	private WebDriver driver;
	
	@Test
	public void loginTest() throws InterruptedException, IOException{
		driver = InvokeBrowser();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("baseURL"));
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.getEmail().sendKeys(prop.getProperty("username"));
		loginPage.getPassword().sendKeys(prop.getProperty("password"));
		loginPage.getLogin();
		Thread.sleep(5000);
		logger.info("Logged In Successfully...");	
//		driver.close();		
	}
//	@Test
	public void logTest() throws InterruptedException, IOException {
		driver = InvokeBrowser();
		driver.get("https://www.google.com");
		Assert.assertTrue(true);
	}
	
	@AfterMethod
	public void exitTest() {
		driver.quit();
	}
	
}

