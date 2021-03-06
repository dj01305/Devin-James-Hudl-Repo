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
	MyLogger oLogger = new MyLogger();

	@FindBy(xpath = "//button[@id='logInWithOrganization']")
	private WebElement logInWithOrganizationButton;

	// Constructor to initialize webdriver, webdriverwait and page objects
	public ScrollForElement(WebDriver driver, WebDriverWait wait) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// Method to scroll for the Log in with Organization button
	public void scrollForlogInWithOrganizationButton() throws InterruptedException {

		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//button[@data-qa-id='log-in-with-organization-btn']"));
		je.executeScript("arguments[0].scrollIntoView(true);", element);
		oLogger.info("Scrolled for log in with organization button");
		Thread.sleep(1000);

	}
}
