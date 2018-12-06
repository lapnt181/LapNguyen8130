package Railway;

import org.openqa.selenium.By;

import Common.ElementHelper;
import Common.Utilities;

public class LoginPage extends GeneralPage {
	// Locators

	private final By _txtUsername = By.xpath("//input[@id='username']");
	private final By _txtPassword = By.xpath("//input[@id='password']");
	private final By _txtEmail = By.xpath("//input[@id='email']");
	private final By _btnLogin = By.xpath("//input[@value='login']");
	private final By _btnLogout = By.xpath("//input[@value='logout']");
	private final By _btnSendInstruction = By.xpath("//input[@value='Send Instructions']");
	private final By _btnResetPassword = By.xpath("//input[@value='Reset Password']");
	private final By _lblLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");
	private final By _lblErrorMsg = By.xpath("//p[@class='message error']");
	private final By linkForgotPassword = By.xpath("//a[contains(@href,'ForgotPassword')]");
	private final By _txtNewPassword = By.xpath("//input[@id='newPassword']");
	private final By _txtConfirmPassword = By.xpath("//input[@id='confirmPassword']");
	private final By _txtResetToken = By.xpath("//input[@id='resetToken']");
	private final By _lblValidationError = By.xpath("//label[@class='validation-error']");

	// Elements

	// Methods
	public HomePage login(String username, String password, int times) {
		// Submit login credenticals
		for (int i = 0; i < times; i++) {
			// ElementHelper.enter(getTxtPassword(), password);
			ElementHelper.enter(Utilities.getElement(_txtUsername), username);
			ElementHelper.enter(Utilities.getElement(_txtPassword), password);
			Utilities.getElement(_btnLogin).click();
		}
		// Land on homepage
		return new HomePage();
	}

	public void sendResetPassword(String email) {
		ElementHelper.click(Utilities.getElement(linkForgotPassword));
		ElementHelper.enter(Utilities.getElement(_txtEmail), email);
		ElementHelper.click(Utilities.getElement(_btnSendInstruction));

	}

	public HomePage resetPassword(String password, String confirmPassword, String clearToken) {
		ElementHelper.enter(Utilities.getElement(_txtNewPassword), password);
		ElementHelper.enter(Utilities.getElement(_txtConfirmPassword), confirmPassword);
		if (clearToken.equals("Y")) {
			Utilities.getElement(_txtResetToken).clear();
		}
		ElementHelper.click(Utilities.getElement(_btnResetPassword));
		return new HomePage();
	}
	
	public String getValidationErrorMessage() {
		return Utilities.getElementText(_lblValidationError);
	}

	public HomePage logout() {
		Utilities.getElement(_btnLogout).click();
		return new HomePage();
	}

}
