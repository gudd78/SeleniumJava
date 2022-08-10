package pageObjects;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends EventCapture {

	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		waitImplicitly(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[contains(text(),'Hi there')]")
	private WebElement welcomeMsg;
	
	@FindBy(xpath = "//a[@class='lambda__logo']/img")
	private WebElement headerAltText;

	@FindBy(xpath = "//div[@class='header__aside__menu']/div/a")
	private List<WebElement> sidebarNavOptions;

	public String getWelcomeMsg(){
		return welcomeMsg.getText();
	}
	public String getHeaderAltText() {
		return headerAltText.getAttribute("alt");
	}

	public List<String> listSidebarNavOptions() {
		List<String> headers = sidebarNavOptions.stream().filter(x->x.getText().length()>0).map(x->x.getText()).collect(Collectors.toList());
		return headers;
	}

	public WebElement selectSidebarNavOption(String option) {
		for (WebElement s : sidebarNavOptions) {
			if (s.getText().equalsIgnoreCase(option)) {
				return s;
			}
		}
		return null;
	}
}
