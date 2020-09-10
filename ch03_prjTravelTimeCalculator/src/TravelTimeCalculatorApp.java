import java.util.Scanner;

public class TravelTimeCalculatorApp {

	public static void main(String[] args) {
		final int MINUTES_PER_HOUR = 60;

		System.out.println("Welcome to the Travel Time Calculator!");
		System.out.println();

		Scanner sc = new Scanner(System.in);

		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			System.out.print("Enter miles:  		");
			double miles = sc.nextDouble();

			System.out.print("Enter miles per hour:  ");
			double mph = sc.nextDouble();

			int hours = (int) (miles / mph);

			double milesRemaining = miles % mph;

			int minutes = (int) ((miles / mph * MINUTES_PER_HOUR) % MINUTES_PER_HOUR);
			System.out.println();

			System.out.println("Estimated travel time  ");
			System.out.println("---------------------- ");
			System.out.println("Hours:  " + hours);
			System.out.println("Minutes: " + minutes);

			System.out.println();
			System.out.println("Continue? (y/n)");
			choice = sc.next();
		}
		System.out.println("Bye!");
	}
}