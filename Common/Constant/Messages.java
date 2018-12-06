package Constant;

import org.openqa.selenium.WebDriver;

public class Messages {
	public static WebDriver WEBDRIVER;
	public static final String INVALID_LOGIN_MESSAGE = "There was a problem with your login and/or errors exist in your form.";
	public static final String INVALID_USER_PASS_MESSAGE = "Invalid username or password. Please try again.";
	public static final String FAIL_ATTEMP_MESSAGE = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
	public static final String REGISTER_SUCCESS_MESSAGE = "Thank you for registering your account";
	public static final String CHANGE_PASSWORD_SUCCESS_MESSAGE = "Your password has been updated";
	public static final String INVALID_REGISTER_MESSAGE = "There're errors in the form. Please correct the errors and try again.";
	public static final String INVALID_PASSWORD_LENGTH_MESSAGE = "Invalid password length";
	public static final String INVALID_PID_LENGTH_MESSAGE = "Invalid ID length";
	public static final String EXPIRED_RESET_TOKEN_MESSAGE = "The password reset token is incorrect or may be expired. Visit the forgot password page to generate a new one.";
	public static final String INVALID_RESET_TOKEN_MESSAGE = "The password reset token is invalid.";
	public static final String CANNOT_RESET_PASSWORD_MESSAGE = "Could not reset password. Please correct the errors and try again.";
	public static final String MISMATCH_PASSWORD_MESSAGE = "The password confirmation did not match the new password.";
	public static final String BOOK_TICKET_SUCCESS_MESSAGE = "Ticket booked successfully!";

}
