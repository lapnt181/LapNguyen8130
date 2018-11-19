package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Constant.Constant;

public class LoginPage extends GeneralPage {
	//Locators
	
	private final By _txtUsername = By.xpath("//input[@id='username']");
	private final By _txtPassword = By.xpath("//input[@id='password']");
	private final By _btnLogin = By.xpath("//input[@value='login']");
	private final By _btnLogout = By.xpath("//input[@value='logout']");
	private final By _lblLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");

	//Elements	
	public WebElement getTxtUsername() {
		return Constant.WEBDRIVER.findElement(_txtUsername);
	}
	
	public WebElement getTxtPassword() {
		return Constant.WEBDRIVER.findElement(_txtPassword);
	}
	
	public WebElement getBtnLogin() {
		return Constant.WEBDRIVER.findElement(_btnLogin);
	}
	
	public WebElement getBtnLogout() {
		return Constant.WEBDRIVER.findElement(_btnLogout);
	}
	
	public WebElement getLblLoginErrorMsg() {
		return Constant.WEBDRIVER.findElement(_lblLoginErrorMsg);
	}
	
	//Methods
	public HomePage login(String username, String password)
	{
		//Submit login credenticals
		this.getTxtUsername().sendKeys(username);
		this.getTxtPassword().sendKeys(password);
		this.getBtnLogin().click();

		//Land on homepage
		return new HomePage();
	}
	
	public HomePage logout()
	{
		this.getBtnLogout().click();
		return new HomePage();
	}

	
}
