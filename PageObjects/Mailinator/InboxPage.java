package Mailinator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Common.ElementHelper;
import Common.Utilities;
import Constant.Constant;

public class InboxPage {
	//private static final By mailSubject = By.xpath("//td[contains(text(),'" + Constant.EMAIL_VALIDATION_TITLE + "')]");
	private static final By webLink = By.xpath("//a");

	public static void openEmailLink(String email,String emailTitle, String action) {
		By mailSubject = By.xpath("//td[contains(text(),'" + emailTitle + "')]");
		String accountInboxLink = Constant.MAILINATOR_URL + email;
		Constant.WEBDRIVER.navigate().to(accountInboxLink);
		Utilities.waitForElement(10, mailSubject);
		ElementHelper.click(Utilities.getElement(mailSubject));
		WebElement iframe = Constant.WEBDRIVER.findElement(By.id("msg_body"));
		Constant.WEBDRIVER.switchTo().frame(iframe);
		Utilities.waitForElement(10, webLink);
		String link = Constant.WEBDRIVER.findElement(By.xpath("//a")).getAttribute("href");
		Constant.WEBDRIVER.switchTo().defaultContent();
		Constant.WEBDRIVER.navigate().to(link);
	}
}