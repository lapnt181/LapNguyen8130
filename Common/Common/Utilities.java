package Common;

import java.time.Instant;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Constant.Constant;

public class Utilities {

	public static String getProjectPath() {
		return System.getProperty("user.dir");
	}

	public static void openBrowser() {
		System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath() + "\\Executables\\chromedriver.exe");
		Constant.WEBDRIVER = new ChromeDriver();
		Constant.WEBDRIVER.manage().window().maximize();
	}

	public static WebElement getElement(By element) {
		return Constant.WEBDRIVER.findElement(element);
	}

	public static String getElementText(By element) {
		return getElement(element).getText();
		// return getElements
	}

	public static String randomStringGenerator() {

		String randomString = "";
		randomString = "test" + Instant.now().getEpochSecond();
		return randomString;

	}

	public static int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}

	public static String mailinatorEmailGenerator(String string) {
		String email;
		return email = string + "@mailinator.com";
	}

	public static void waitForElement(int seconds, By waitConditionLocator) {
		WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, seconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(waitConditionLocator));
	}

	public static String getMessage(String field) {
		return Utilities
				.getElementText(By.xpath(String.format("//li[@class='%s']//label[@class='validation-error']", field)));

	}

	public static void selectDropdownlistItem(String dropDownList, String value) {
		By list = By.xpath("//select[@name='" + dropDownList + "']");
		Select select = new Select(Utilities.getElement(list));
		select.selectByVisibleText(value);
	}

}
