package Railway;

import org.openqa.selenium.By;

import Common.ElementHelper;
import Common.Utilities;

public class ChangePasswordPage extends GeneralPage {
	private final By txtCurrentPassword = By.xpath("//input[@id='currentPassword']");
	private final By txtNewPassword = By.xpath("//input[@id='newPassword']");
	private final By txtConfirmPassword = By.xpath("//input[@id='confirmPassword']");
	private final By btnChangePassword = By.xpath("//input[@title='Change password']");
	
	public ChangePasswordPage changePassword(String currentPassword, String newPassword, String confirmPassword) {
		ElementHelper.enter(Utilities.getElement(txtCurrentPassword),currentPassword);
		ElementHelper.enter(Utilities.getElement(txtNewPassword),newPassword);
		ElementHelper.enter(Utilities.getElement(txtConfirmPassword),confirmPassword);
		Utilities.getElement(btnChangePassword).click();
		return new ChangePasswordPage();
	}
	
}

