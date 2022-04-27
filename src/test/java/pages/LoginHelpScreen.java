package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.MyLogger;

public class LoginHelpScreen {
	private WebDriverWait wait;
	MyLogger oLogger = new MyLogger();

	@FindBy(xpath = "//h1[contains(text(),'Login Help')]")
	private WebElement verifyLoginHelpScreen;
	
	@FindBy(xpath = "//button[@id='resetBtn']")
	private WebElement sendPasswordResetButton;
	
	@FindBy(xpath = "//h4[contains(text(),'Check Your Email')]")
	private WebElement verifyCheckYourEmailMessage;
	
	@FindBy(xpath = "//input[@id='forgot-email']")
	private WebElement emailInputVerifyLoginHelpScreen;

	// Constructor to initialize webdriverwait and page objects
	public LoginHelpScreen(WebDriver driver, WebDriverWait wait) {
		this.wait = wait;
		PageFactory.initElements(driver, this);

	}
	
	// Method to verify the Login Help screen
	public void verifyLoginHelpScreen() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(verifyLoginHelpScreen));
		oLogger.info("Login Help screen is displayed");
		Thread.sleep(1000);
	}
	
	// Method to enter email on Login Help screen
	public void enterEmailOnLoginHelpScreen(String email) throws InterruptedException {
		emailInputVerifyLoginHelpScreen.sendKeys(email);
		oLogger.info("Email has been entered");
		Thread.sleep(1000);
		
	}
	
	// Method to verify password reset
	public void verifyPasswordReset() throws InterruptedException {
		sendPasswordResetButton.click();
		oLogger.info("Send password reset button has been clicked");
		wait.until(ExpectedConditions.visibilityOf(verifyCheckYourEmailMessage));
		oLogger.info("Check your email message is displayed");
		Thread.sleep(1000);
	}

}
