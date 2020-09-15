import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Scanner;

public class TipCalculatorApp {

	public static void main(String[] args) {// ALL ITERATIONS
		System.out.println("Welcome to the Tip Calculator!"); // ALL ITERATIONS
		System.out.println(); // ALL ITERATIONS

		Scanner sc = new Scanner(System.in);
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		NumberFormat percent = NumberFormat.getPercentInstance();
		String choice;

//		final BigDecimal percent15 = new BigDecimal("0.15");
//		final BigDecimal percent20 = new BigDecimal("0.2");
//		final BigDecimal percent25 = new BigDecimal("0.25");

//// String y/n
//		String choice = "y";
//		while (choice.equalsIgnoreCase("y")) {

//// Meal Cost		
//			System.out.print("Cost of meal: ");
//			BigDecimal mealCost = sc.nextBigDecimal();
//			NumberFormat currency = NumberFormat.getCurrencyInstance();
//			currency.setMaximumFractionDigits(2);
//
//// 15% Tip
//			System.out.println();
//			System.out.println("15%");
//			BigDecimal TipAmount15 = mealCost.multiply(percent15);
//			percent15.multiply(mealCost);
//			System.out.println("Tip Amount:  " + TipAmount15);
//
//			BigDecimal totalAmount15 = mealCost.add(TipAmount15);
//			System.out.println("Total amount: " + totalAmount15);
//
//// 20% Tip
//			System.out.println();
//			System.out.println("20%");
//			BigDecimal TipAmount20 = mealCost.multiply(percent20);
//			percent20.multiply(mealCost);
//			System.out.println("Tip Amount:  " + TipAmount20);
//
//			BigDecimal totalAmount20 = mealCost.add(TipAmount20);
//			System.out.println("Total amount: " + totalAmount20);
//
//// 25% Tip
//			System.out.println();
//			System.out.println("25%");
//			BigDecimal TipAmount25 = mealCost.multiply(percent25);
//			percent25.multiply(mealCost);
//			System.out.println("Tip Amount:  " + TipAmount25);
//
//			BigDecimal totalAmount25 = mealCost.add(TipAmount25);
//			System.out.println("Total amount: " + totalAmount25);

		do {
			System.out.println("Cost of the meal: ");
			BigDecimal cost = sc.nextBigDecimal();

			BigDecimal tipPercent = new BigDecimal("0.15");
			BigDecimal tipIncrement = new BigDecimal("0.05");
			for (int i = 0; i < 3; ++i) {
//Calculate tip and total

				BigDecimal tipAmount = cost.multiply(tipPercent);
				BigDecimal totalCost = cost.add(tipAmount);

				System.out.println(percent.format(tipPercent));
				System.out.println("Tip amount:  " + currency.format(tipAmount));
				System.out.println("Total amount:  " + currency.format(totalCost));
				System.out.println();

				tipPercent = tipPercent.add(tipIncrement);

			}

			System.out.println("Continue? y/n");
			choice = sc.next();
		} while (choice.equalsIgnoreCase("y"));

//// Continue
//			System.out.println();
//			System.out.print("Continue? y/n: ");
//			choice = sc.next();
//			System.out.println();
//		}
		System.out.println();
		System.out.println("Bye!");
	}
}
