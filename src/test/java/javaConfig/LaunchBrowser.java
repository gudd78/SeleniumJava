package javaConfig;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class LaunchBrowser {

	protected static Properties prop = new Properties();
	protected static WebDriver driver;

	private static final Logger logger = LogManager.getLogger(LaunchBrowser.class);

	@Test
	public static WebDriver InvokeBrowser() throws InterruptedException, IOException {

		FileInputStream dataFilePath = new FileInputStream(
				System.getProperty("user.dir") + ".\\resources\\data.properties");
		prop.load(dataFilePath);
		String browserName;
		if (System.getProperty("browser") != null) {
			browserName = System.getProperty("browser");
		} else {
			browserName = prop.getProperty("browserName");
		}
		logger.info(browserName);
		if (browserName.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + prop.getProperty("firefoxPath"));
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + prop.getProperty("chromePath"));
			driver = new ChromeDriver();
		} else {
			System.setProperty("webdriver.edge.driver", 
					System.getProperty("user.dir") + prop.getProperty("edgePath"));
			driver = new EdgeDriver();
		}
		return driver;
	}

	public String takeScreenShot(WebDriver driver, String methodName) throws IOException {
		TakesScreenshot ss = (TakesScreenshot) driver;
		File file = ss.getScreenshotAs(OutputType.FILE);
		String destFile = System.getProperty("user.dir") + ".\\results\\screenshots\\" + methodName + ".png";
		FileUtils.copyFile(file, new File(destFile));
		return destFile;
	}

}
