package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import Common.Utilities;
import Constant.Constant;
import Mailinator.InboxPage;

public class GeneralPage {
	// Locators

	private final By tabHome = By.xpath("//span[text()='Home']");
	private final By tabFAQ = By.xpath("//span[text()='FAQ']");
	private final By tabContact = By.xpath("//span[text()='Contact']");
	private final By tabTimetable = By.xpath("//span[text()='Timetable']");
	private final By tabTicketPrice = By.xpath("//span[text()='Ticket price']");
	private final By tabBookTicket = By.xpath("//span[text()='Book ticket']");
	private final By tabMyTicket = By.xpath("//span[text()='My ticket']");
	private final By tabChangePassword = By.xpath("//span[text()='Change password']");
	private final By tabRegister = By.xpath("//span[text()='Register']");
	private final By tabLogin = By.xpath("//span[text()='Login']");
	private final By tabLogout = By.xpath("//span[text()='Log out']");

	private final By lblPage = By.xpath("//h1[normalize-space()]");
	private final By lblWelcomeMessage = By.xpath("//div[@class='account']");
	private final By lblLoginErrorMessage = By.xpath("//p[@class='message error LoginForm']");
	private final By lblErrorMessage = By.xpath("//p[@class='message error']");
	private final By lblSuccessMessage = By.xpath("//p[@class='message success']");

	// Elements

	// Methods

	public String getWelcomeMessage() {
		return Utilities.getElementText(lblWelcomeMessage);
	}

	public String getLoginErrorMessage() {
		return Utilities.getElementText(lblLoginErrorMessage);
	}

	public String getErrorMessage() {
		return Utilities.getElementText(lblErrorMessage);
	}

	public String getSuccessMessage() {
		return Utilities.getElementText(lblSuccessMessage);
	}

	public String getTabLabel(String tab) {
		String str = String.format("//span[text()='%s']", tab);
		WebElement element = Constant.WEBDRIVER.findElement(By.xpath(str));
		String tabName = Utilities.getElementText((By) element);
		return tabName;
	}

	public void gotoPage(String tabName) {
		String str = String.format("//span[text()='%s']", tabName);
		WebElement element = Constant.WEBDRIVER.findElement(By.xpath(str));
		element.click();
	}

	public Boolean isTabDisplayed(String tab) {
		Boolean isTabdisplayed = true;

		String str = String.format("//span[text()='%s']", tab);
		try {
			WebElement element = Constant.WEBDRIVER.findElement(By.xpath(str));
			isTabdisplayed = element.isDisplayed();
			return isTabdisplayed;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public WebElement getLblPage() {
		return Constant.WEBDRIVER.findElement(lblPage);
	}

	public String GetPageLabel() {
		return this.getLblPage().getText();
	}

	public Boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();
	}

}
