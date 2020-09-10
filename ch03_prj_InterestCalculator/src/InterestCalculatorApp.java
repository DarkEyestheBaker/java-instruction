
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Scanner;

public class InterestCalculatorApp {

	public static void main(String[] args) {
		// Print greeting
		System.out.println("Welcome to the Interest Calculator!");
		System.out.println();

		Scanner sc = new Scanner(System.in);

		// String y/n
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {

// Calculate Loan
			System.out.print("Enter loan amount: ");
			double loan = sc.nextDouble();
			NumberFormat currency = NumberFormat.getCurrencyInstance();
			currency.setMaximumFractionDigits(2);
			String loanString = currency.format(loan);

// Calculating Interest Rate		
			System.out.print("Enter interest rate: ");
			double interestRate = sc.nextDouble();
			NumberFormat percent = NumberFormat.getPercentInstance();
			percent.setMaximumFractionDigits(3);
			String rateString = percent.format(interestRate);
			System.out.println();

//Calculating Interest
			System.out.println("Loan Amount: " + currency.format(loan));
			double interest = loan * interestRate;
			NumberFormat currency2 = NumberFormat.getCurrencyInstance();
			currency2.setMaximumFractionDigits(2);
			BigDecimal interestString = new BigDecimal(Double.toString(interest));
			interestString = interestString.setScale(2, RoundingMode.HALF_UP);

//Interest Rate
			System.out.println("Interest rate: " + percent.format(interestRate));

//Interest		
			System.out.println("Interest: " + currency.format(interest));

			System.out.print("Continue? y/n: ");
			choice = sc.next();

			System.out.println("Bye!");
		}
	}
}
