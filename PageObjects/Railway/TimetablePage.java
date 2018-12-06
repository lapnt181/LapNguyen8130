package Railway;
import org.openqa.selenium.By;

import Common.ElementHelper;
import Common.Utilities;

public class TimetablePage extends GeneralPage {

	public void BookTicketFromTo(String depart, String arrival) {
		By linkTicketFromTo = By.xpath("//td[text()='"+depart+"']/following-sibling::td[text()='"+arrival+"']/..//a[contains(@href, 'Book')]");
		ElementHelper.click(Utilities.getElement(linkTicketFromTo));
	}
	
}
