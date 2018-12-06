package Ticket;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

import Common.Utilities;

public class Ticket {

	String departDate;
	String departFrom;
	String arrivalTo;
	String seatType;
	String ticketAmount;

	// constructor
	public Ticket(String departDate, String departFrom, String arrivalTo, String seatType, String ticketAmount) {
		this.departDate = departDate;
		this.departFrom = departFrom;
		this.arrivalTo = arrivalTo;
		this.seatType = seatType;
		this.ticketAmount = ticketAmount;
	}

	public String getDepartDate() {
		return departDate;
	}

	public String getDepartFrom() {
		return departFrom;
	}

	public String getArrivalTo() {
		return arrivalTo;
	}

	public String getSeatType() {
		return seatType;
	}

	public String getTicketAmount() {
		return ticketAmount;
	}

	public enum Destination {
		PHANTHIET("Phan Thiết"), NHATRANG("Nha Trang"), DANANG("Đà Nẵng"), HUE("Huế"), QUANGNGAI("Quảng Ngãi");

		private String str;

		Destination(String str) {
			this.str = str;
		}

		public String getValue() {
			return str;
		}
	}

	public enum SeatType {
		HARDSEAT("Hard seat"), SOFTSEAT("Soft seat"), SOFTSEATWAIR("Soft seat with air conditioner"), HARDBED(
				"Hard bed"), SOFTBED("Soft bed"), SOFTBEDWAIR("Soft bed with air conditioner");

		private String str;

		SeatType(String str) {
			this.str = str;
		}

		public String getValue() {
			return str;
		}
	}

	private static class RandomEnum<E extends Enum<E>> {

		private static final Random RND = new Random();
		private final E[] values;

		public RandomEnum(Class<E> token) {
			values = token.getEnumConstants();
		}

		public E random() {
			return values[RND.nextInt(values.length)];
		}
	}

	private static final RandomEnum<Destination> randomDestination = new RandomEnum<Destination>(Destination.class);
	private static final RandomEnum<SeatType> randomSeatType = new RandomEnum<SeatType>(SeatType.class);

	public static String randomDestination() {
		return randomDestination.random().getValue();
	}

	public static String randomSeatType() {
		return randomSeatType.random().getValue();
	}

	public static String randomDate() {
		String randomDate = "NULL";
		DateFormat dateFormat = new SimpleDateFormat("M/d/yyyy");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, Utilities.getRandomNumberInRange(4, 30));
		randomDate = dateFormat.format(cal.getTime());
		return randomDate;
	}

	public static Ticket randomTicket() {
		return new Ticket(randomDate(), "Sài Gòn", randomDestination(), randomSeatType(),
				Integer.toString(Utilities.getRandomNumberInRange(1, 10)));
	}
}
