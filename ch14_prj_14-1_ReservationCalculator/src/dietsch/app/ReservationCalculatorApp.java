package dietsch.app;

import java.time.LocalDate;

public class ReservationCalculatorApp {

	private final double NIGHTLY_RATE = 145.0;

	public static void main(String[] args) {
		System.out.println("Welcome to the Reservation Calculator!");

		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {

			LocalDate arrivalDate = Console.getLocalDate("arrival");
			LocalDate departureDate = Console.getLocalDate("departure");

			Reservation res = new Reservation(arrivalDate, departureDate);

			System.out.println("Arrival Date: " + res.getArrivalDateFormatted());
			System.out.println("Departure Date" + res.getDepartureDateFormatted());
			System.out.println("Price: " + res.getPricePerNightFormatted());
			System.out.println(
					"TotalPrice:  " + res.getTotalPriceFormatted() + " for " + res.getNumberOfNights() + " nights.");

			System.out.println();

			choice = Console.getString("Continue? (y/n)");

		}
	}

}
