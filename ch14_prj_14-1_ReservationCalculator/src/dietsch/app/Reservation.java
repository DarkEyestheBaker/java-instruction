package dietsch.app;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;

/*
public String getPricePerNightFormatted()
public double getTotalPrice()
public String getTotalPriceFormatted()
**/

public class Reservation {
//Fields
	private LocalDate arrivalDate;
	private LocalDate departureDate;

	// Constructors

	public Reservation() {
		arrivalDate = null;
		departureDate = null;
	}

	public Reservation(LocalDate arrivalDate, LocalDate DepartureDate) {
		this.arrivalDate = arrivalDate;
		this.departureDate = departureDate;

	}

	// Getters & Setters
	public LocalDate getArrivalDate() {
		return arrivalDate;
	}

	public String getArrivalDateFormatted() {
		DateTimeFormatter dtFormat = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
		String dateFormatted = dtFormat.format(arrivalDate);
		return dateFormatted;

	}

	public void setArrivalDate(LocalDate arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public LocalDate getDepartureDate() {
		return departureDate;
	}

	public String getDepartureDateFormatted() {
		DateTimeFormatter dtFormat = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
		String dateFormatted = dtFormat.format(departureDate);
		return dateFormatted;

	}

	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}

//Business methods
	public int getNumberOfNights() {
		return (int) arrivalDate.until(departureDate, ChronoUnit.DAYS);

	}

	public String getPricePerNightFormatted() {
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
		return currencyFormat.format(NIGHTLY_RATE);

	}

	public double getTotalPrice() {
		return NIGHTLY_RATE * getNumberOfNights();
	}

	public String getTotalPriceFormatted() {
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
		return currencyFormat.format(getTotalPrice());
	}
}
