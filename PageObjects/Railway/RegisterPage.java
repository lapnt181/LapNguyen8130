package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Constant.Constant;
import Common.ElementHelper;
import Common.Utilities;

public class RegisterPage extends GeneralPage {
	// Locators

		private final By txtEmail = By.xpath("//input[@id='email']");
		private final By txtPassword = By.xpath("//input[@id='password']");
		private final By txtConfirmPassword = By.xpath("//input[@id='confirmPassword']");
		private final By txtPid = By.xpath("//input[@id='pid']");
		private final By btnRegister = By.xpath("//input[@title='Register']");

	// Element
	// Methods
		
		public void createAccount(String email, String password, String confirmPassword, String pid) {
			
			ElementHelper.enter(Utilities.getElement(txtEmail),email);
			ElementHelper.enter(Utilities.getElement(txtPassword),password);
			ElementHelper.enter(Utilities.getElement(txtConfirmPassword),confirmPassword);
			ElementHelper.enter(Utilities.getElement(txtPid),pid);
			Utilities.getElement(btnRegister).click();
		}
}
