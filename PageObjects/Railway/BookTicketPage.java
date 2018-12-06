package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import Common.ElementHelper;
import Common.Utilities;
import Constant.Constant;
import Ticket.Ticket;

public class BookTicketPage extends GeneralPage {

	private final By listDepartDate = By.xpath("//select[@name='Date']");
	private final By listDepartFrom = By.xpath("//select[@name='DepartStation']");
	private final By listArriveTo = By.xpath("//select[@name='ArriveStation']");
	private final By listSeatType = By.xpath("//select[@name='SeatType']");
	private final By listTicketAmount = By.xpath("//select[@name='TicketAmount']");
	private final By btnBookTicket = By.xpath("//input[@value='Book ticket']");


	private final By tableHeader = By.xpath("//tr[@class='TableSmallHeader']/th");
	// / //th[text()="Arrive Station"]/../following-sibling::tr/td

	public void bookTicket(Ticket ticket) {
		Utilities.selectDropdownlistItem(Constant.BookTicketDropdownList.DATE.getValue(), ticket.getDepartDate());
		Utilities.selectDropdownlistItem(Constant.BookTicketDropdownList.DEPART_STATION.getValue(),
				ticket.getDepartFrom());
		Utilities.selectDropdownlistItem(Constant.BookTicketDropdownList.ARRIVE_STATION.getValue(),
				ticket.getArrivalTo());
		Utilities.selectDropdownlistItem(Constant.BookTicketDropdownList.SEAT_TYPE.getValue(), ticket.getSeatType());
		Utilities.selectDropdownlistItem(Constant.BookTicketDropdownList.TICKET_AMOUNT.getValue(),
				ticket.getTicketAmount());

		ElementHelper.click(Utilities.getElement(btnBookTicket));

	}

	public Boolean isTicketDataCorrect(Ticket ticket) {
		By ticketData = By.xpath("//tr/td[text()='" + ticket.getDepartFrom() + "']/../td[text()='"
				+ ticket.getArrivalTo() + "']/../td[text()='" + ticket.getSeatType() + "']/../td[text()='"
				+ ticket.getDepartDate() + "']/following-sibling::td[text()='" + ticket.getTicketAmount() + "']");
		boolean isTicketDataCorrect = isElementDisplayed(Constant.WEBDRIVER.findElement(ticketData));
		return isTicketDataCorrect;
	}
	
	public Boolean isFieldCorrect(String depart, String arrival) {
		String selectedDepart = new Select(Constant.WEBDRIVER.findElement(listDepartFrom)).getFirstSelectedOption().getText();
		String selectedArrival = new Select(Constant.WEBDRIVER.findElement(listArriveTo)).getFirstSelectedOption().getText();
		Boolean isFieldCorrect = null;
		if(selectedDepart.equals(depart) && selectedArrival.equals(arrival) == true )
			isFieldCorrect = true;
		return isFieldCorrect;
		
	}

	
}
