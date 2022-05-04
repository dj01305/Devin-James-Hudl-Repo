package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClass.HudlBaseDriver;
import utilities.MyLogger;

public class LogIntoHudlWithOrganizationScreen extends HudlBaseDriver {
	private WebDriverWait wait;
	MyLogger oLogger = new MyLogger();

	@FindBy(xpath = "//h2[contains(text(),'Log into Hudl')]")
	private WebElement verifyLogIntoHudleWithOrgScreen;
	
	@FindBy(xpath = "//input[@id='uniId_1']")
	private WebElement emailInput;
	
	@FindBy(xpath = "//button[@data-qa-id='log-in-with-sso']")
	private WebElement loginButton;

	// Constructor to initialize webdriverwait and page objects
	public LogIntoHudlWithOrganizationScreen(WebDriver driver, WebDriverWait wait) {
		this.wait = wait;
		PageFactory.initElements(driver, this);

	}
	
	// Method to verify Log Into Hudl With Org screen
	public void verifyLogIntoHudlWithOrgScreen() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(verifyLogIntoHudleWithOrgScreen));
		oLogger.info("Log into Hudl with org screen is displayed");
		Thread.sleep(1000);
	}
	
	// Method to enter email address
	public void enterEmailAddress(String email) throws InterruptedException {
		emailInput.sendKeys(email);
		oLogger.info("Email has been entered");
		Thread.sleep(1000);
	}
	
	// Method to click on the login button
	public void clickLoginButton() throws InterruptedException {
		loginButton.click();
		oLogger.info("Login button has been clicked");
		Thread.sleep(1000);
	}

}
