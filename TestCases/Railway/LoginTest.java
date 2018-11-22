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
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Pre-condition");

		System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath() + "\\Executables\\chromedriver.exe");
		Constant.WEBDRIVER = new ChromeDriver();
		Constant.WEBDRIVER.manage().window().maximize();
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("Post-condition");
		Constant.WEBDRIVER.quit();
	}

	@Test(description = "TC01 - User can log into Railway with valid username and password")
	public void TC01() {
		LoginPage loginPage = Utilities.initLoginPage();
		String actualMsg = loginPage.login(Constant.USERNAME, Constant.PASSWORD, 1).getWelcomeMessage();
		String expectedMsg = "Welcome " + Constant.USERNAME;
		Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is display as expected.\n");
	}

	@Test(description = "TC02 - User can't login with blank Username textbox")
	public void TC02() {
		LoginPage loginPage = Utilities.initLoginPage();
		String actualMsg = loginPage.login(Constant.EMPTY, Constant.PASSWORD, 1).getErrorMessage();
		String expectedMsg = Messages.INVALID_LOGIN_MESSAGE;
		Assert.assertEquals(actualMsg, expectedMsg, "Error message is not display as expected.\n");
	}

	@Test(description = "User cannot log into Railway with invalid password")
	public void TC03() {
		LoginPage loginPage = Utilities.initLoginPage();
		String actualMsg = loginPage.login(Constant.USERNAME, Constant.INVALID_PASSWORD, 1).getErrorMessage();
		String expectedMsg = Messages.INVALID_LOGIN_MESSAGE;
		Assert.assertEquals(actualMsg, expectedMsg, "Error message is not display as expected.\n");
	}

	@Test(description = "Login page displays when un-logged User clicks on Book ticket tab")
	public void TC04() {
		LoginPage loginPage = Utilities.initLoginPage();
		loginPage.gotoBookTicketPage();
		String actualLbl = loginPage.GetPageLabel();
		String expectedLbl = "Login page";
		Assert.assertEquals(actualLbl, expectedLbl, "Login page is not displayed as expected.\n");
	}

	@Test(description = "System shows message when user enters wrong password several times")
	public void TC05() {
		LoginPage loginPage = Utilities.initLoginPage();
		loginPage.login(Constant.USERNAME, Constant.INVALID_PASSWORD, 4);
		String actualMsg = loginPage.getErrorMessage();
		String expectedMsg = Messages.FAIL_ATTEMP_MESSAGE;
		Assert.assertEquals(actualMsg, expectedMsg, "Error message is not display as expected.\n");
	}
	
	@Test(description="Additional pages display once user logged in")
	public void TC06() {
		LoginPage loginPage = Utilities.initLoginPage();
		loginPage.login(Constant.EMPTY, Constant.PASSWORD, 1);
	}

}
