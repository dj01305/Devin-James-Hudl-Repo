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
	private WebDriver driver;
	private WebDriverWait wait;
	MyLogger oLogger = new MyLogger();

	@FindBy(xpath = "//h2[contains(text(),'Log into Hudl')]")
	private WebElement verifyLogIntoHudleWithOrgScreen;

	// Constructor to initialize webdriver, webdriverwait and page objects
	public LogIntoHudlWithOrganizationScreen(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);

	}
	
	// Method to verify Log Into Hudl With Org screen
	public void verifyLogIntoHudlWithOrgScreen() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(verifyLogIntoHudleWithOrgScreen));
		oLogger.info("Log into Hudl with org screen is displayed");
		Thread.sleep(1000);
	}

}
