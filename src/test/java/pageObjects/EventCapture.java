package pageObjects;

import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EventCapture {

	static int waitTime = 10;
	protected static Properties prop = new Properties();

	public void waitElementLocated(WebDriver driver, WebElement e) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
		wait.until(ExpectedConditions.visibilityOf(e));
	}
	public void waitElementsLocated(WebDriver driver, List<WebElement> e) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
		wait.until(ExpectedConditions.visibilityOfAllElements(e));
		
	}

	public void waitImplicitly(WebDriver driver) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitTime));
	}
	public void waitElementToBeClickable(WebDriver driver, WebElement e) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
		wait.until(ExpectedConditions.elementToBeClickable(e));
	}

}
