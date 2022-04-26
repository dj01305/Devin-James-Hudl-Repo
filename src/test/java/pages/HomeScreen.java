package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.MyLogger;

public class HomeScreen {
	private WebDriver driver;
	private WebDriverWait wait;
	MyLogger oLogger = new MyLogger();

	@FindBy(xpath = "//span[contains(text(),'Home')]")
	private WebElement verifyHomeScreen;

	// Constructor to initialize webdriver, webdriverwait and page objects
	public HomeScreen(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);

	}

	// Method to verify that user has landed on the home screen
	public void verifyHomeScreen() throws InterruptedException {
		try{
			wait.until(ExpectedConditions.visibilityOf(verifyHomeScreen));
			oLogger.info("User has navigated to the home screen");
			Thread.sleep(2000);
		}catch(Exception e) {
			oLogger.info("User has not navigated to the home screen");
		}
		
	}
}
