package Railway;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Common.Utilities;
import Constant.Constant;
import Constant.Messages;
import Mailinator.InboxPage;
import Ticket.Ticket;

public class BookTicketTest {
	public HomePage homePage = new HomePage();
	public LoginPage loginPage = new LoginPage();
	public RegisterPage registerPage = new RegisterPage();
	public BookTicketPage bookTicketPage = new BookTicketPage();
	public ChangePasswordPage changePassword = new ChangePasswordPage();
	public TimetablePage timetablePage = new TimetablePage();
	public MyTicketPage myTicketPage = new MyTicketPage();

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
		loginPage.login(randomEmail, Constant.PASSWORD, 1);
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("Post-condition");
		Constant.WEBDRIVER.quit();
	}

	@Test(description = "TC14 -User can book 1 ticket at a time.")
	public void TC14() {
		loginPage.gotoPage("Book ticket");
		bookTicketPage.bookTicket(Constant.TICKET);
		String actualLbl = bookTicketPage.GetPageLabel();
		String expectedLbl = Constant.BOOK_TICKET_SUCCESSFULLY_TITLE;
		Assert.assertEquals(actualLbl, expectedLbl, "The message does not display as expected.\n");
		Boolean actual = bookTicketPage.isTicketDataCorrect(Constant.TICKET);
		Boolean expected = true;
		Assert.assertEquals(actual, expected, "The booked ticket data is not matched.\n");

	}

	@Test(description = "User can open \"Book ticket\" page by clicking on \"Book ticket\" link in \"Train timetable\" page")
	public void TC15() {
		loginPage.gotoPage("Timetable");
		timetablePage.BookTicketFromTo("Huế", "Sài Gòn");
		Boolean actual = bookTicketPage.isFieldCorrect("Huế", "Sài Gòn");
		Boolean expected = true;
		Assert.assertEquals(actual, expected, "The fields are not matched.\n");
	}

	@Test(description = "User can cancel a ticket.")
	public void TC16() {
		Ticket ticket = Ticket.randomTicket();
		loginPage.gotoPage("Book ticket");
		bookTicketPage.bookTicket(ticket);
		bookTicketPage.gotoPage("My ticket");
		myTicketPage.deleteTicket(ticket);
		Boolean actual = myTicketPage.isTicketDisplayed(ticket);
		Boolean expected = false;
		Assert.assertEquals(actual, expected, "The ticket is not deleted as expected.\n");
	}

}
