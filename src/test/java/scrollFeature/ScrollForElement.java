package scrollFeature;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClass.HudlBaseDriver;
import utilities.MyLogger;

public class ScrollForElement extends HudlBaseDriver {
	private WebDriver driver;
	private WebDriverWait wait;
	MyLogger oLogger = new MyLogger();

	@FindBy(xpath = "//button[@id='logInWithOrganization']")
	private WebElement logInWithOrganizationButton;

	// Constructor to initialize webdriver, webdriverwait and page objects
	public ScrollForElement(WebDriver driver, WebDriverWait wait) {

		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);

	}

	// Method to scroll for the Log in with Organization button
	public void scrollForlogInWithOrganizationButton() throws InterruptedException {

		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("(//button[@id='logInWithOrganization'])"));
		je.executeScript("arguments[0].scrollIntoView(true);", element);
		oLogger.info("Scrolled for save and update button");
		Thread.sleep(1000);

	}
}
