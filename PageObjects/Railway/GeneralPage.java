package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constant.Constant;

public class GeneralPage {
	// Locators
	private final By _lblPage = By.xpath("//h1[normalize-space()]");
	private final By tabLogin = By.xpath("//a[@href='/Account/Login.cshtml']");
	private final By tabLogout = By.xpath("//a[@href='/Account/Logout']");
	private final By tabBookTicket = By.xpath("//a[@href='/Page/BookTicketPage.cshtml']");
	private final By tabChangePassword = By.xpath("//a[@href='/Page/ChangePassword.cshtml']");
	private final By lblWelcomeMessage = By.xpath("//div[@class='account']");
	private final By lblErrorMessage = By.xpath("//p[@class='message error LoginForm']");
	private final By tabMyTicket = By.xpath("//a[@href='Page/ManageTicket.cshtml']");

	// Elements
	protected WebElement getTabLogin() {
		return Constant.WEBDRIVER.findElement(tabLogin);
	}

	protected WebElement getTabLogout() {
		return Constant.WEBDRIVER.findElement(tabLogout);
	}

	protected WebElement getTabMyTicket() {
		return Constant.WEBDRIVER.findElement(tabMyTicket);
	}

	protected WebElement getTabChangePassword() {
		return Constant.WEBDRIVER.findElement(tabChangePassword);
	}

	protected WebElement getTabBookTicket() {
		return Constant.WEBDRIVER.findElement(tabBookTicket);
	}

	protected WebElement getLblWelcomeMessage() {
		return Constant.WEBDRIVER.findElement(lblWelcomeMessage);
	}

	protected WebElement getLblLoginErrorMsg() {
		return Constant.WEBDRIVER.findElement(lblErrorMessage);
	}

	// Methods

	public String getWelcomeMessage() {
		return this.getLblWelcomeMessage().getText();
	}

	public String getErrorMessage() {
		return this.getLblLoginErrorMsg().getText();
	}

	public LoginPage gotoLoginPage() {
		this.getTabLogin().click();
		return new LoginPage();
	}

	public BookTicketPage gotoBookTicketPage() {
		this.getTabBookTicket().click();
		return new BookTicketPage();
	}

	public WebElement getLblPage() {
		return Constant.WEBDRIVER.findElement(_lblPage);
	}

	public String GetPageLabel() {
		return this.getLblPage().getText();
	}
	
	public Boolean isPageDisplayed(WebElement page) {
		return page.isDisplayed();
	}

	
	
}
