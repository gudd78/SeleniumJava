package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends EventCapture{
	private WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		waitImplicitly(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="email")
	private WebElement email;
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="login-button")
	private WebElement loginBtn;
	
	@FindBy(xpath="//input[@type='checkbox']")
	private WebElement rememberMe;
	
	public WebElement getEmail() {
		return email;
	}
	
	public WebElement getPassword() {
		return password;
	}
	
	public HomePage getLogin() {
//		waitElementToBeClickable(driver,loginBtn);
		loginBtn.click();
		HomePage home = new HomePage(driver);
		return home;
	}

	public WebElement getRememberMe() {
		return rememberMe;
	}

	
}
