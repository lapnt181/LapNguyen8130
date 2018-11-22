package Common;

import org.openqa.selenium.WebElement;

public class ElementHelper {
	public static void enter(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}
}
