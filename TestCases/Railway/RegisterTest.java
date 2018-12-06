package Railway;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Common.Utilities;
import Constant.Constant;
import Constant.Messages;
import Mailinator.InboxPage;

public class RegisterTest {
	public HomePage homePage = new HomePage();
	public RegisterPage registerPage = new RegisterPage();
	public LoginPage loginPage = new LoginPage();
	public InboxPage inboxPage = new InboxPage();
	public String randomString = Utilities.randomStringGenerator();
	public String randomEmail = Utilities.mailinatorEmailGenerator(randomString);

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

	@Test(description = "TC07 - User can create new account")
	public void TC07() {
		homePage.gotoPage("Register");
		registerPage.createAccount(randomEmail, Constant.PASSWORD, Constant.PASSWORD, Constant.PID);
		String actualMsg = registerPage.GetPageLabel();
		String expectedMsg = Messages.REGISTER_SUCCESS_MESSAGE;
		Assert.assertEquals(actualMsg, expectedMsg, "Thank you message doesn't display as expected.\n");
	}

	@Test(description = "TC10 - User can't create account with \"Confirm password\" is not the same with \"Password\"")
	public void TC10() {
		homePage.gotoPage("Register");
		registerPage.createAccount(randomEmail, Constant.PASSWORD, Constant.INVALID_PASSWORD, Constant.PID);
		String actualMsg = registerPage.getErrorMessage();
		String expectedMsg = Messages.INVALID_REGISTER_MESSAGE;
		Assert.assertEquals(actualMsg, expectedMsg, "Error message doesn't display as expected.\n");
	}

	@Test(description = "TC11 - User can't create account while password and PID fields are empty")
	public void TC11() {
		homePage.gotoPage("Register");
		registerPage.createAccount(randomEmail, Constant.EMPTY, Constant.EMPTY, Constant.EMPTY);
		String actual = registerPage.getErrorMessage();
		String expected = Messages.INVALID_REGISTER_MESSAGE;
		Assert.assertEquals(actual, expected, "Error message doesn't display as expected.\n");
		String actualError1 = Utilities.getMessage("password");
		String expectedError1 = Messages.INVALID_PASSWORD_LENGTH_MESSAGE;
		Assert.assertEquals(actualError1, expectedError1, "Error message doesn't display as expected.\n");
		String actualError2 = Utilities.getMessage("pid-number");
		String expectedError2 = Messages.INVALID_PID_LENGTH_MESSAGE;
		Assert.assertEquals(actualError2, expectedError2, "Error message doesn't display as expected.\n");
	}

}