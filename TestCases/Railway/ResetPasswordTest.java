
package Railway;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Common.Utilities;
import Constant.Constant;
import Constant.Messages;
import Mailinator.InboxPage;

public class ResetPasswordTest {
	public HomePage homePage = new HomePage();
	public LoginPage loginPage = new LoginPage();
	public RegisterPage registerPage = new RegisterPage();
	public ChangePasswordPage changePassword = new ChangePasswordPage();
	public String randomString = Utilities.randomStringGenerator();
	public String randomEmail = Utilities.mailinatorEmailGenerator(randomString);

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Pre-condition");
		String randomString = Utilities.randomStringGenerator();
		String randomEmail = Utilities.mailinatorEmailGenerator(randomString);
		Utilities.openBrowser();
		homePage.open();
		homePage.gotoPage("Register");
		registerPage.createAccount(randomEmail, Constant.PASSWORD, Constant.PASSWORD, Constant.PID);
		InboxPage.openEmailLink(randomString, Constant.EMAIL_VALIDATION_TITLE,
				Constant.EmailTitle.ACTIVATE_ACCOUNT.getValue());
		registerPage.gotoPage("Login");
		loginPage.sendResetPassword(randomEmail);
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("Post-condition");
		Constant.WEBDRIVER.quit();
	}

	@Test(description = "TC12 - Errors display when password reset token is blank")
	public void TC12() throws InterruptedException {

		InboxPage.openEmailLink(randomString, Constant.RESET_PASSWORD_EMAIL_TITLE,
				Constant.EmailTitle.RESET_PASSWORD.getValue());
		String actual = loginPage.resetPassword(Constant.PASSWORD, Constant.PASSWORD, "Y").getErrorMessage();
		String expected = Messages.EXPIRED_RESET_TOKEN_MESSAGE;
		Assert.assertEquals(actual, expected, "Error message is not display as expected.\n");
		actual = Utilities.getMessage("reset-token");
		expected = Messages.INVALID_RESET_TOKEN_MESSAGE;
		Assert.assertEquals(actual, expected, "Error message is not display as expected.\n");
	}

	@Test(description = "TC13 - Errors display if password and confirm password don't match when resetting password")
	public void TC13() throws InterruptedException {

		InboxPage.openEmailLink(randomString, Constant.RESET_PASSWORD_EMAIL_TITLE,
				Constant.EmailTitle.RESET_PASSWORD.getValue());
		String actual = loginPage.resetPassword(Constant.PASSWORD, Constant.INVALID_PASSWORD, "Y").getErrorMessage();
		String expected = Messages.CANNOT_RESET_PASSWORD_MESSAGE;
		Assert.assertEquals(actual, expected, "Error message is not display as expected.\n");
		actual = Utilities.getMessage("confirm-password");
		expected = Messages.MISMATCH_PASSWORD_MESSAGE;
		Assert.assertEquals(actual, expected, "Error message is not display as expected.\n");
	}
}
