package tests;

import java.io.IOException;
import org.testng.annotations.Test;
import baseClass.HudlBaseDriver;
import pages.HomeScreen;
import pages.InitialScreen;
import pages.LogIntoHudlWithOrganizationScreen;
import pages.LoginHelpScreen;
import pages.LoginScreen;
import scrollFeature.ScrollForElement;

public class HudlLoginTests extends HudlBaseDriver {
	String email = "devinspencerjames@gmail.com";
	String invalidEmail = "devonspencerjames@gmail.com";

	@Test(testName = "Login to Hudl (Happy Path)")
	public void loginToHudlTest() throws InterruptedException, IOException {

		// *************PAGE INSTANTIATION*************
		InitialScreen initialScreen = new InitialScreen(driver, wait);
		LoginScreen loginScreen = new LoginScreen(driver, wait);
		HomeScreen homeScreen = new HomeScreen(driver, wait);

		// *************PAGE METHODS******************
		initialScreen.clickLoginButton();
		loginScreen.verifyLoginScreen();
		loginScreen.enterEmailAddress(email);
		loginScreen.enterPassword();
		loginScreen.clickRememberMeCheckbox();
		loginScreen.clickLoginButton();
		homeScreen.verifyHomeScreen();

	}

	@Test(testName = "Login to Hudl (Valid email, invalid password)")
	public void loginToHudlWithInvalidPasswordTest() throws InterruptedException, IOException {

		// *************PAGE INSTANTIATION*************
		InitialScreen initialScreen = new InitialScreen(driver, wait);
		LoginScreen loginScreen = new LoginScreen(driver, wait);

		// *************PAGE METHODS******************
		initialScreen.clickLoginButton();
		loginScreen.verifyLoginScreen();
		loginScreen.enterEmailAddress(email);
		loginScreen.enterInvalidPassword();
		loginScreen.clickLoginButton();
		loginScreen.verifyWeDidntRecognizeEmailOrPasswordMessage();

	}

	@Test(testName = "Login to Hudl (Invalid email, valid password)")
	public void loginToHudlWithInvalidEmailTest() throws InterruptedException, IOException {

		// *************PAGE INSTANTIATION*************
		InitialScreen initialScreen = new InitialScreen(driver, wait);
		LoginScreen loginScreen = new LoginScreen(driver, wait);

		// *************PAGE METHODS******************
		initialScreen.clickLoginButton();
		loginScreen.verifyLoginScreen();
		loginScreen.enterEmailAddress(invalidEmail);
		loginScreen.enterPassword();
		loginScreen.clickLoginButton();
		loginScreen.verifyWeDidntRecognizeEmailOrPasswordMessage();

	}

	@Test(testName = "Login to Hudl (Blank email, Blank password)")
	public void loginToHudlWithBlankEmailBlankPasswordTest() throws InterruptedException, IOException {

		// *************PAGE INSTANTIATION*************
		InitialScreen initialScreen = new InitialScreen(driver, wait);
		LoginScreen loginScreen = new LoginScreen(driver, wait);

		// *************PAGE METHODS******************
		initialScreen.clickLoginButton();
		loginScreen.verifyLoginScreen();
		loginScreen.clickLoginButton();
		loginScreen.verifyWeDidntRecognizeEmailOrPasswordMessage();

	}

	@Test(testName = "Verify Need Help button functionailty")
	public void verifyNeedHelpButtonFunctionalityTest() throws InterruptedException, IOException {

		// *************PAGE INSTANTIATION*************
		InitialScreen initialScreen = new InitialScreen(driver, wait);
		LoginScreen loginScreen = new LoginScreen(driver, wait);
		LoginHelpScreen loginHelpScreen = new LoginHelpScreen(driver, wait);

		// *************PAGE METHODS******************
		initialScreen.clickLoginButton();
		loginScreen.verifyLoginScreen();
		loginScreen.clickNeedHelpLink();
		loginHelpScreen.verifyLoginHelpScreen();
		loginHelpScreen.enterEmailOnLoginHelpScreen(email);
		loginHelpScreen.verifyPasswordReset();

	}

	@Test(testName = "Verify Log into Hudl with organization functionailty")
	public void verifyLogIntoHudlWithOrganziationFunctionalityTest() throws InterruptedException, IOException {

		// *************PAGE INSTANTIATION*************
		InitialScreen initialScreen = new InitialScreen(driver, wait);
		LoginScreen loginScreen = new LoginScreen(driver, wait);
		LogIntoHudlWithOrganizationScreen logIntoHudlWithOrganizationScreen = new LogIntoHudlWithOrganizationScreen(
				driver, wait);
		ScrollForElement scrollForElement = new ScrollForElement(driver, wait);
		// *************PAGE METHODS******************
		initialScreen.clickLoginButton();
		loginScreen.verifyLoginScreen();
		scrollForElement.scrollForlogInWithOrganizationButton();
		loginScreen.clickLogInWithOrganizationButton();
		logIntoHudlWithOrganizationScreen.verifyLogIntoHudlWithOrgScreen();
		logIntoHudlWithOrganizationScreen.enterEmailAddress(email);
		logIntoHudlWithOrganizationScreen.clickLoginButton();
		loginScreen.verifyUserCantLogInWithOrgErrorMessage();
		

	}

	@Test(testName = "Logout of Hudl")
	public void logOutOfHudlTest() throws InterruptedException, IOException {

		// *************PAGE INSTANTIATION*************
		InitialScreen initialScreen = new InitialScreen(driver, wait);
		LoginScreen loginScreen = new LoginScreen(driver, wait);
		HomeScreen homeScreen = new HomeScreen(driver, wait);

		// *************PAGE METHODS******************
		initialScreen.clickLoginButton();
		loginScreen.verifyLoginScreen();
		loginScreen.enterEmailAddress(email);
		loginScreen.enterPassword();
		loginScreen.clickLoginButton();
		homeScreen.verifyHomeScreen();
		homeScreen.clickUserMenu();
		homeScreen.clickLogoutButton();
		initialScreen.verifyHudlLogo();
		

	}
}
