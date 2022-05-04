package baseClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utilities.MyLogger;

public class HudlBaseDriver {
	// Driver initialization with Wait
	protected static WebDriver driver;
	protected static WebDriverWait wait;
	MyLogger oLogger = new MyLogger();

	@BeforeSuite
	public void setup() throws IOException, InterruptedException {
		// Open chrome browser in incognito mode
		ChromeOptions options = new ChromeOptions();
		options.addArguments("incognito");

		System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");

		// Pass Options in chromedriver object
		driver = new ChromeDriver(options);
		driver.get("https://hudl.com");
		Thread.sleep(1000);

		// method to verify that user has landed on hudl.com
		if (driver.getCurrentUrl().endsWith("hudl.com/")) {
			oLogger.info("User has successfully navigated to hudl.com");
		} else {
			oLogger.info("User has not successfully navigated to hudl.com");
		}

		// Create a wait. All test and page classes use this wait.
		wait = new WebDriverWait(driver, 30);

		// Maximize Window and set implicit wait time
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();

	}

	@AfterSuite
	public void testTearDown() throws InterruptedException {
		// Close Browser & driver sessions
		driver.quit();
		oLogger.info("driver quit");

	} 

}
