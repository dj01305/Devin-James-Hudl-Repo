package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.codec.binary.Base64;
import utilities.MyLogger;

public class LoginScreen {
	private WebDriverWait wait;
	MyLogger oLogger = new MyLogger();

	@FindBy(xpath = "//input[@id='email']")
	private WebElement emailInput;

	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordInput;

	@FindBy(xpath = "//button[@id='logIn']")
	private WebElement loginButton;

	@FindBy(xpath = "//label[contains(text(),'Remember me')]")
	private WebElement rememberMeCheckBox;

	@FindBy(xpath = "//a[@data-qa-id='need-help-link']")
	private WebElement needHelpLink;

	@FindBy(xpath = "//button[@data-qa-id='log-in-with-organization-btn']")
	private WebElement logInWithOrganizationButton;

	@FindBy(xpath = "//p[@data-qa-id='error-display']")
	private WebElement weDidntRecognizeEmailAndOrPasswordMessage;
	
	@FindBy(xpath = "//p[@data-qa-id='error-display']")
	private WebElement thisAccountCantLoginWithOrgMessage;
	

	// Constructor to initialize webdriverwait and page objects
	public LoginScreen(WebDriver driver, WebDriverWait wait) {
		this.wait = wait;
		PageFactory.initElements(driver, this);

	}

	// Method to verify that user has landed on the log in screen
	public void verifyLoginScreen() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(emailInput));
		oLogger.info("User has navigated to the login screen");
		Thread.sleep(2000);

	}

	// Method to enter the user email address
	public void enterEmailAddress(String email) throws InterruptedException {
		emailInput.sendKeys(email);
		oLogger.info("Email: " + "'" + email + "'" + " has been entered");
		Thread.sleep(1000);

	}

	// Method to enter the user password
	public void enterPassword() throws InterruptedException, IOException {
		Properties properties = new Properties();
		FileInputStream fileInputStream = new FileInputStream(
				"C:\\Users\\dj051670\\Documents\\PracticeAutomation\\HudlProject\\src\\test\\resources\\properties\\config.properties");
		properties.load(fileInputStream);
		byte[] encodedString = Base64.encodeBase64("password".getBytes());
		oLogger.info("Password has been encoded");
		passwordInput.sendKeys(properties.getProperty("password"));
		oLogger.info("Encoded Password: " + "'" + encodedString + "'" + " has been entered");
		Thread.sleep(1000);
	}

	// Method to enter the wrong user password
	public void enterInvalidPassword() throws InterruptedException, IOException {
		Properties properties = new Properties();
		FileInputStream fileInputStream = new FileInputStream(
				"C:\\Users\\dj051670\\Documents\\PracticeAutomation\\HudlProject\\src\\test\\resources\\properties\\config.properties");
		properties.load(fileInputStream);
		byte[] encodedString = Base64.encodeBase64("invalidPassword".getBytes());
		oLogger.info("Password has been encoded");
		passwordInput.sendKeys(properties.getProperty("invalidPassword"));
		oLogger.info("Encoded invalid Password: " + "'" + encodedString + "'" + " has been entered");
		Thread.sleep(1000);
	}
	
	// Method to click on the remember me checkbox
	public void clickRememberMeCheckbox() {
		try{
			rememberMeCheckBox.click();
			oLogger.info("Remember me checkbox has been clicked");
			Thread.sleep(1000);
		}catch(Exception e) {
			oLogger.info("Remember me checkbox was not successfully clicked");
		}
		
	}
	

	// Method to click on the login button
	public void clickLoginButton() throws InterruptedException {
		loginButton.click();
		oLogger.info("Login button has been clicked");
		Thread.sleep(2000);
	}

	// Method to check if user is able to login with invalid password
	public void verifyWeDidntRecognizeEmailOrPasswordMessage() {
		try {
			wait.until(ExpectedConditions.visibilityOf(weDidntRecognizeEmailAndOrPasswordMessage));
			oLogger.info("We didn't recognize that email and/or password message has been displayed");
		} catch (Exception e) {
			oLogger.info("We didn't recognize that email and/or password message was not displayed");
		}
	}
	
	// Method to click on the Need Help? Button
	public void clickNeedHelpLink() throws InterruptedException {
		needHelpLink.click();
		oLogger.info("Need Help link has been clicked");
		Thread.sleep(2000);
	}
	
	// Method to click on the log in with organization button
	public void clickLogInWithOrganizationButton() throws InterruptedException {
		logInWithOrganizationButton.click();
		oLogger.info("Log in with organization button has been clicked");
		Thread.sleep(1000);
		
	}
	
	// Method to verify that the user can't log in with an org error message
	public void verifyUserCantLogInWithOrgErrorMessage() {
		try {
			wait.until(ExpectedConditions.visibilityOf(thisAccountCantLoginWithOrgMessage));
			oLogger.info("User can't log in with org message is displayed");
			Thread.sleep(1000);
		}catch(Exception e) {
			oLogger.info("User can't log in with org message not displayed");
		}
		
		
	}

}
