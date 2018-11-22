package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Common.Utilities;
import Constant.Constant;

public class GeneralPage {
	// Locators

	// private final By tabHome = By.xpath("//a[@href='/Page/HomePage.cshtml']");
	// private final By tabFAQ = By.xpath("//a[@href='/Page/FAQ.cshtml']");
	// private final By tabContact = By.xpath("//a[@href='/Page/Contact.cshtml']");
	// private final By tabTimetable =
	// By.xpath("//a[@href='/Page/TrainTimeListPage.cshtml']");
	// private final By tabTicketPrice =
	// By.xpath("//a[@href='/Page/TrainPriceListPage.cshtml']");
	// private final By tabBookTicket =
	// By.xpath("//a[@href='/Page/BookTicketPage.cshtml']");
	// private final By tabMyTicket =
	// By.xpath("//a[@href='/Page/ManageTicket.cshtml']");
	// private final By tabChangePassword =
	// By.xpath("//a[@href='/Account/ChangePassword.cshtml']");
	// private final By tabLogin = By.xpath("//a[@href='/Account/Login.cshtml']");
	// private final By tabLogout = By.xpath("//a[@href='/Account/Logout']");

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
	private final By lblErrorMessage = By.xpath("//p[@class='message error LoginForm']");

	// Elements

	// Methods

	public String getWelcomeMessage() {
		return Utilities.getElementText(lblWelcomeMessage);
	}

	public String getErrorMessage() {
		return Utilities.getElementText(lblErrorMessage);
	}

	public String getTabLabel(String tab) {
		String tabName = "";
		switch (tab) {
		case "Login":
			tabName = Utilities.getElementText(tabLogin);
			break;
		case "Logout":
			tabName = Utilities.getElementText(tabLogout);
			break;
		case "Home":
			tabName = Utilities.getElementText(tabHome);
			break;
		case "FAQ":
			tabName = Utilities.getElementText(tabFAQ);
			break;
		case "Contact":
			tabName = Utilities.getElementText(tabContact);
			break;
		case "Timetable":
			tabName = Utilities.getElementText(tabTimetable);
			break;
		case "TicketPrice":
			tabName = Utilities.getElementText(tabTicketPrice);
			break;
		case "BookTicket":
			tabName = Utilities.getElementText(tabBookTicket);
			break;
		case "MyTicket":
			tabName = Utilities.getElementText(tabMyTicket);
			break;
		case "ChangePassword":
			tabName = Utilities.getElementText(tabChangePassword);
		case "Register":
			tabName = Utilities.getElementText(tabRegister);
			break;
		}
		return tabName;
	}

	public void gotoPage(String pageName) {

		switch (pageName) {
		case "Login":
			Constant.WEBDRIVER.findElement(tabLogin).click();
			break;
		case "Home":
			Constant.WEBDRIVER.findElement(tabHome).click();
			break;
		case "FAQ":
			Constant.WEBDRIVER.findElement(tabFAQ).click();
			break;
		case "Contact":
			Constant.WEBDRIVER.findElement(tabContact).click();
			break;
		case "Timetable":
			Constant.WEBDRIVER.findElement(tabTimetable).click();
			break;
		case "TicketPrice":
			Constant.WEBDRIVER.findElement(tabTicketPrice).click();
			break;
		case "BookTicket":
			Constant.WEBDRIVER.findElement(tabBookTicket).click();
			break;
		case "MyTicket":
			Constant.WEBDRIVER.findElement(tabMyTicket).click();
			break;
		case "ChangePassword":
			Constant.WEBDRIVER.findElement(tabChangePassword).click();
			break;
		case "Register":
			Constant.WEBDRIVER.findElement(tabRegister).click();
			break;
		}
	}

	public Boolean isTabDisplayed(String tab) {
		Boolean isTabdisplayed = true;
		switch (tab) {
		case "Logout":
			isTabdisplayed = isElementDisplayed(Utilities.getElement(tabLogout));
			break;
		case "ChangePassword":
			isTabdisplayed = isElementDisplayed(Utilities.getElement(tabChangePassword));
			break;
		case "MyTicket":
			isTabdisplayed = isElementDisplayed(Utilities.getElement(tabMyTicket));
			break;
		}
		return isTabdisplayed;
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
