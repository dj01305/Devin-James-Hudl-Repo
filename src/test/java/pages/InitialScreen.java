package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.MyLogger;

public class InitialScreen {
	private WebDriverWait wait;
	MyLogger oLogger = new MyLogger();

	@FindBy(xpath = "//a[@data-qa-id='site-logo']")
	private WebElement siteLogo;

	@FindBy(xpath = "//a[@data-qa-id='login']")
	private WebElement loginButton;

	// Constructor to initialize webdriverwait and page objects
	public InitialScreen(WebDriver driver, WebDriverWait wait) {
		this.wait = wait;
		PageFactory.initElements(driver, this);

	}

	// Method to verify visibility of Hudl logo
	public void verifyHudlLogo() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(siteLogo));
		oLogger.info("Hudl logo is displayed");
		Thread.sleep(2000);

	}
	
	// Method to click on the Login button
	public void clickLoginButton() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(loginButton));
		loginButton.click();
		oLogger.info("Login button has been clicked");
		Thread.sleep(2000);
	}

}
