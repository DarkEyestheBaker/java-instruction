import java.text.NumberFormat;
import java.util.Scanner;

public class InvoiceApp {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String choice = "y";

		while (!choice.equalsIgnoreCase("n")) {
			// get the input from the user
			System.out.print("Enter customer type (r/c/t): ");
			String customerType = sc.next();
			System.out.print("Enter subtotal:   ");
			double subtotal = sc.nextDouble();

			// get the discount percent
			double discountPercent = 0.0;

			if (customerType.equalsIgnoreCase("r)")) {
				System.out.println("In if case r or R");
				if (subtotal < 100) {
					discountPercent = 0.0;
				} else if (subtotal >= 100 && subtotal < 250) {
					discountPercent = 0.1;
				} else if (subtotal >= 250 && subtotal < 500) {
					discountPercent = 0.25;
				} else if (subtotal >= 500) {
					discountPercent = 0.3;

				} else if (customerType.equalsIgnoreCase("c)")) {
					System.out.println("In if case c or C");

				} else if (subtotal > 0) {
					discountPercent = 0.2;
				}
				if (customerType.equalsIgnoreCase("t")) {
					System.out.println("In case t/T");
					if (subtotal <= 500) {
						discountPercent = 0.4;
					} else {
						discountPercent = 0.5;
					}
				} else {
					System.out.println("In else case");
					discountPercent = 0.0;
				}
//			// get the discount percent
//			double discountPercent = 0.0;
//			switch (customerType) {
//			case "r":
//			case "R":
//				if (subtotal < 100) {
//					discountPercent = 0.0;
//				} else if (subtotal >= 250 && subtotal < 500) {
//					discountPercent = .25;
//				} else if (subtotal >= 500) {
//					discountPercent = .3;
//				}
//				break;
//			case "c":
//			case "C":
//				if (subtotal > 0) {
//					discountPercent = .2;
//				}
//				break;
//
//			case "t":
//			case "T":
//				if (subtotal < 500) {
//					discountPercent = 0.4;
//				} else if (subtotal >= 500) {
//					discountPercent = .5;
//				}
//				break;
//			}
//
				// calculate the discount amount and round to 2 decimals
				double discountAmount = subtotal * discountPercent;
				discountAmount = Math.ceil(discountAmount * 100) / 100;
				// calculate the total
				double total = subtotal - discountAmount;
				// format and display the results
				NumberFormat currency = NumberFormat.getCurrencyInstance();
				NumberFormat percent = NumberFormat.getPercentInstance();
				System.out.println("Discount percent: " + percent.format(discountPercent) + "\n" + "Discount amount:  "
						+ currency.format(discountAmount) + "\n" + "Total:            " + currency.format(total)
						+ "\n");
				// see if the user wants to continue
				System.out.print("Continue? (y/n): ");
				choice = sc.next();
				System.out.println();
			}
		}
	}
}
