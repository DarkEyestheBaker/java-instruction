import java.text.NumberFormat;
import java.util.Scanner;

public class FutureValueApp {

	public static void main(String[] args) {
		System.out.println("The Future Value Calculator\n");

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			// get the input from the user
			System.out.print("Enter monthly investment:   ");
			double monthlyInvestment = sc.nextDouble();
			System.out.print("Enter number of years:      ");
			int years = sc.nextInt();

			NumberFormat percentFormatter = NumberFormat.getPercentInstance();
			percentFormatter.setMinimumFractionDigits(1);
			percentFormatter.setMaximumFractionDigits(1);

			// Printer header row
			System.out.println("Year");
			for (double intRate = 0.05; intRate <= 0.065; intRate += 0.005) {
				System.out.println(percentFormatter.format(intRate));
				System.out.println("\t" + percentFormatter.format(intRate));
			}
			System.out.println();

			for (int year = 1; year <= years; ++year) {
				System.out.print(year);
				for (double intRate = 0.05; intRate <= 0.065; intRate += 0.005) {
					double monthlyInterestRate = intRate / 12;
					int months = year * 12;
					// use a for loop to calculate the future value
					double futureValue = 0.0;
					for (int i = 1; i <= months; i++) {
						futureValue = (futureValue + monthlyInvestment) * (1 + monthlyInterestRate);
					}

					// format and display the result
					NumberFormat currency = NumberFormat.getCurrencyInstance();
					System.out.println("Future value:               " + currency.format(futureValue));
					System.out.println();

					// see if the user wants to continue
					System.out.print("Continue? (y/n): ");
					choice = sc.next();
					System.out.println();
				}
			}
			System.out.println("Bye!");
		}
	}

	public static double calculateFutureValue(double monthlyInv, double monthlyInterestRate, int months) {
		double futureValue = 0.0;

		return futureValue;

	}
}