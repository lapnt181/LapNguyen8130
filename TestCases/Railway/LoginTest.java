package Railway;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Common.Utilities;
import Constant.Constant;

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
	
	@Test
	
	public void TC01() {
		System.out.println("TC01 - User can log into Railway with valid username and password");
		HomePage homePage = new HomePage();
		homePage.open();
		
		LoginPage loginPage = homePage.gotoLoginPage();
		
		String actualMsg = loginPage.login(Constant.USERNAME, Constant.PASSWORD).getWelcomeMessage();
		String expectedMsg = "Welcome " + Constant.USERNAME;
		
		Assert.assertEquals(actualMsg, expectedMsg,"Welcome message is display as expected");
	}

	@Test
	public void TC02() {
		System.out.println("User can't login with blank Username textbox");
		HomePage homePage = new HomePage();
		homePage.open();
		
		LoginPage loginPage = homePage.gotoLoginPage();
		
		String actualMsg = loginPage.login(Constant.EMPTY, Constant.PASSWORD).getErrorMessage();
		String expectedMsg = "There was a problem with your login and/or errors exist in your form.";
		Assert.assertEquals(actualMsg, expectedMsg,"Error message is display as expected");
	}
	
	@Test
	public void TC03() {
	System.out.println("User cannot log into Railway with invalid password");
	HomePage homePage = new HomePage();
	homePage.open();
	
	LoginPage loginPage = homePage.gotoLoginPage();
	
	String actualMsg = loginPage.login(Constant.USERNAME, Constant.INVALID_PASSWORD).getErrorMessage();
	String expectedMsg = "There was a problem with your login and/or errors exist in your form.";
	Assert.assertEquals(actualMsg, expectedMsg,"Error message is display as expected");
	}
	
	@Test
	public void TC04() {
		System.out.println("Login page displays when un-logged User clicks on \"Book ticket\" tab\r\n" + "");
		HomePage homePage = new HomePage();
		homePage.open();
		
		LoginPage loginPage = homePage.gotoLoginPage();
		loginPage.gotoBookTicketPage();
		String actualLbl = loginPage.getLblPage().getText();
		String expectedLbl = "Login page";
		Assert.assertEquals(actualLbl, expectedLbl,"Login page displayed as expected.");
	}
	
	@Test
	public void TC05() {
		System.out.println("System shows message when user enters wrong password several times");
		HomePage homePage = new HomePage();
		homePage.open();
		
		LoginPage loginPage = homePage.gotoLoginPage();
		loginPage.login(Constant.USERNAME, Constant.INVALID_PASSWORD);
		for (int i=0; i<3; i++) {
			loginPage.getTxtPassword().sendKeys(Constant.INVALID_PASSWORD);
			loginPage.getBtnLogin().click();
		}
		String actualMsg = loginPage.getErrorMessage();
		String expectedMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
		Assert.assertEquals(actualMsg, expectedMsg,"Error message is display as expected");
	}
	
}

