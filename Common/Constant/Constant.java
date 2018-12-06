package Constant;

import org.openqa.selenium.WebDriver;
import Ticket.Ticket;
public class Constant {

	public static WebDriver WEBDRIVER;
	public static final String RAILWAY_URL = "http://192.168.189.206:8888";
	public static final String MAILINATOR_URL = "https://www.mailinator.com/v3/index.jsp?zone=public&query=";
	public static final String VALIDATION_TEXT = "confirmationCode";
	public static final String USERNAME = "lap.nguyen@logigear.com";
	public static final String PASSWORD = "I@ml3g3nd";
	public static final String EMPTY = "";
	public static final String INVALID_USERNAME = "a@b.c";
	public static final String INVALID_PASSWORD = "12345678";
	public static final String PID = "12345678";
	public static final String EMAIL_VALIDATION_TITLE = "Please confirm your account";
	public static final String RESET_PASSWORD_EMAIL_TITLE = "Please reset your password";
	public static final String BOOK_TICKET_SUCCESSFULLY_TITLE = "Ticket booked successfully!";
	public static final Ticket TICKET = new Ticket("12/15/2018","Sài Gòn","Phan Thiết","Hard seat","1");
	
	public enum EmailTitle {
		ACTIVATE_ACCOUNT("confirmationCode"), RESET_PASSWORD("resetToken");

		private String str;

		EmailTitle(String str) {
			this.str = str;
		}

		public String getValue() {
			return str;
		}
	}

	public enum BookTicketDropdownList{
		DATE("Date"),
		DEPART_STATION("DepartStation"),
		ARRIVE_STATION("ArriveStation"),
		SEAT_TYPE("SeatType"),
		TICKET_AMOUNT("TicketAmount");
		
		private String str;
		BookTicketDropdownList(String str) {
			this.str = str;
		}

		public String getValue() {
			return str;
		}
		
	}
	
	public enum TabName {
		HOME("Home"), FAQ("FAQ"), CONTACT("Contact"), TIMETABLE("Timetable"), TICKETPRICE("Ticket price"), BOOKTICKET(
				"Book ticket"), REGISTER("Register"), LOGIN(
						"Login"), LOGOUT("Log out"), MYTICKET("My ticket"), CHANGEPASSWORD("Change password");

		private String str;

		TabName(String str) {
			this.str = str;
		}

		public String getValue() {
			return str;
		}

	}
}

