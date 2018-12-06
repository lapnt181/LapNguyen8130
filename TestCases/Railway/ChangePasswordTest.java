package Railway;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Common.Utilities;
import Constant.Constant;
import Constant.Messages;
import Mailinator.InboxPage;

public class ChangePasswordTest {
	public HomePage homePage = new HomePage();
	public RegisterPage registerPage = new RegisterPage();
	public LoginPage loginPage = new LoginPage();
	public InboxPage inboxPage = new InboxPage();
	public ChangePasswordPage changePasswordPage = new ChangePasswordPage();
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
		String actual = changePasswordPage.changePassword(Constant.PASSWORD, Constant.PASSWORD, Constant.PASSWORD)
				.getSuccessMessage();
		String expected = Messages.CHANGE_PASSWORD_SUCCESS_MESSAGE;
		Assert.assertEquals(actual, expected, "Successful message is not display as expected.\n");
	}

}
