package Railway;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Common.Utilities;
import Constant.Constant;
import Constant.Messages;

public class LoginTest {
	public HomePage homePage = new HomePage();
	public LoginPage loginPage = new LoginPage();
	public RegisterPage registerPage = new RegisterPage();
	public ChangePasswordPage changePassword = new ChangePasswordPage();

	public String randomEmail = Utilities.randomEmailGenerator();

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Pre-condition");

		Utilities.openBrowser();
		homePage.open();

	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("Post-condition");
		Constant.WEBDRIVER.quit();
	}

	@Test(description = "TC01 - User can log into Railway with valid username and password")
	public void TC01() {
		loginPage.gotoPage("Login");
		String actual = loginPage.login(Constant.USERNAME, Constant.PASSWORD, 1).getWelcomeMessage();
		String expected = "Welcome " + Constant.USERNAME;
		Assert.assertEquals(actual, expected, "Welcome message is display as expected.\n");
	}

	@Test(description = "TC02 - User can't login with blank Username textbox")
	public void TC02() {
		loginPage.gotoPage("Login");
		String actual = loginPage.login(Constant.EMPTY, Constant.PASSWORD, 1).getErrorMessage();
		String expected = Messages.INVALID_LOGIN_MESSAGE;
		Assert.assertEquals(actual, expected, "Error message is not display as expected.\n");
	}

	@Test(description = "User cannot log into Railway with invalid password")
	public void TC03() {
		loginPage.gotoPage("Login");
		String actual = loginPage.login(Constant.USERNAME, Constant.INVALID_PASSWORD, 1).getErrorMessage();
		String expected = Messages.INVALID_LOGIN_MESSAGE;
		Assert.assertEquals(actual, expected, "Error message is not display as expected.\n");
	}

	@Test(description = "Login page displays when un-logged User clicks on Book ticket tab")
	public void TC04() {
		loginPage.gotoPage("Book ticket");
		String actual = loginPage.GetPageLabel();
		String expected = "Login page";
		Assert.assertEquals(actual, expected, "Login page is not displayed as expected.\n");
	}

	@Test(description = "System shows message when user enters wrong password several times")
	public void TC05() {
		loginPage.gotoPage("Login");
		loginPage.login(Constant.USERNAME, Constant.INVALID_PASSWORD, 4);
		String actual = loginPage.getErrorMessage();
		String expected = Messages.FAIL_ATTEMP_MESSAGE;
		Assert.assertEquals(actual, expected, "Error message is not display as expected.\n");
	}

	@Test(description = "Additional pages display once user logged in")
	public void TC06() {
		loginPage.gotoPage("Login");
		loginPage.login(Constant.USERNAME, Constant.PASSWORD, 1);

		Assert.assertEquals((boolean) loginPage.isTabDisplayed("My ticket"), true);
		Assert.assertEquals((boolean) loginPage.isTabDisplayed("Logout"), true);
		Assert.assertEquals((boolean) loginPage.isTabDisplayed("Change Password"), true);

		// Verify My ticket page is open
		loginPage.gotoPage("My ticket");
		String actualLbl = loginPage.GetPageLabel();
		String expectedLbl = "Manage ticket";
		Assert.assertEquals(actualLbl, expectedLbl, "Manage ticket page is not displayed as expected.\n");

		// Verify Change password page is open
		loginPage.gotoPage("Change password");
		actualLbl = loginPage.GetPageLabel();
		expectedLbl = "Change password";
		Assert.assertEquals(actualLbl, expectedLbl, "Change password page is not displayed as expected.\n");

	}

	@Test(description = "TC08 - User can't login with an account hasn't been activated")
	public void TC08() {
		homePage.gotoPage("Login");
		String actual = loginPage.login(randomEmail, Constant.PASSWORD, 1).getLoginErrorMessage();
		String expected = Messages.INVALID_USER_PASS_MESSAGE;
		Assert.assertEquals(actual, expected, "Error message is not display as expected.\n");
	}

	@Test(description = "User can change password")
	public void TC09() {
		homePage.gotoPage("Login");
		loginPage.login(Constant.USERNAME, Constant.PASSWORD, 1);
		loginPage.gotoPage("Change password");
		String actual = changePassword.changePassword(Constant.PASSWORD, Constant.PASSWORD, Constant.PASSWORD).getSuccessMessage();
		String expected = Messages.CHANGE_PASSWORD_SUCCESS_MESSAGE; 
		Assert.assertEquals(actual, expected, "Successful message is not display as expected.\n");
	}

}
