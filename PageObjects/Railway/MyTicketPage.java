package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import Common.ElementHelper;
import Common.Utilities;
import Constant.Constant;
import Ticket.Ticket;

public class MyTicketPage extends GeneralPage {
	public void deleteTicket(Ticket ticket) {
		By ticketBtn = By.xpath("//tr/td[text()='" + ticket.getDepartFrom() + "']/../td[text()='"
				+ ticket.getArrivalTo() + "']/../td[text()='" + ticket.getSeatType() + "']/../td[text()='"
				+ ticket.getDepartDate() + "']/following-sibling::td[text()='" + ticket.getTicketAmount() + "']/..//input[@value='Cancel']");
		ElementHelper.click(Utilities.getElement(ticketBtn));
		Constant.WEBDRIVER.switchTo().alert().dismiss();
	}
	public Boolean isTicketDisplayed(Ticket ticket) {
		By ticketData = By.xpath("//tr/td[text()='" + ticket.getDepartFrom() + "']/../td[text()='"
				+ ticket.getArrivalTo() + "']/../td[text()='" + ticket.getSeatType() + "']/../td[text()='"
				+ ticket.getDepartDate() + "']/following-sibling::td[text()='" + ticket.getTicketAmount() + "']");
		Boolean isTicketDisplayed = null;
		try {
			WebElement element = Constant.WEBDRIVER.findElement(ticketData);
			isTicketDisplayed = element.isEnabled();
			return isTicketDisplayed;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
