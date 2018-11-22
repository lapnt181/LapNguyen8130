package Railway;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Common.Utilities;
import Constant.Constant;
import Constant.Messages;

public class RegisterTest {
	public HomePage homePage = new HomePage();
	public RegisterPage registerPage = new RegisterPage();

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
		registerPage.createAccount(Utilities.randomEmailGenerator(),Constant.PASSWORD,Constant.PASSWORD,Constant.PID);
		String actualMsg= registerPage.GetPageLabel();
		String expectedMsg = Messages.REGISTER_SUCCESS_MESSAGE;
		Assert.assertEquals(actualMsg, expectedMsg, "Thank you message is display as expected.\n");
	}

}