import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Scanner;

public class TipCalculatorApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Tip Calculator!");
		System.out.println();

		Scanner sc = new Scanner(System.in);

		BigDecimal percent15 = new BigDecimal("0.15");
		BigDecimal percent20 = new BigDecimal("0.2");
		BigDecimal percent25 = new BigDecimal("0.25");

		// String y/n
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {

// Meal Cost		
			System.out.print("Cost of meal: ");
			BigDecimal mealCost = sc.nextBigDecimal();
			NumberFormat currency = NumberFormat.getCurrencyInstance();
			currency.setMaximumFractionDigits(2);

// 15% Tip
			System.out.println();
			System.out.println("15%");
			BigDecimal TipAmount15 = mealCost.multiply(percent15);
			percent15 = percent15.multiply(mealCost);
			System.out.println("Tip Amount:  " + TipAmount15);

			BigDecimal totalAmount15 = mealCost.add(TipAmount15);
			System.out.println("Total amount: " + totalAmount15);

// 20% Tip
			System.out.println();
			System.out.println("20%");
			BigDecimal TipAmount20 = mealCost.multiply(percent20);
			percent20 = percent20.multiply(mealCost);
			System.out.println("Tip Amount:  " + TipAmount20);

			BigDecimal totalAmount20 = mealCost.add(TipAmount20);
			System.out.println("Total amount: " + totalAmount20);

// 25% Tip
			System.out.println();
			System.out.println("25%");
			BigDecimal TipAmount25 = mealCost.multiply(percent25);
			percent25 = percent25.multiply(mealCost);
			System.out.println("Tip Amount:  " + TipAmount25);

			BigDecimal totalAmount25 = mealCost.add(TipAmount25);
			System.out.println("Total amount: " + totalAmount25);

// Continue
			System.out.println();
			System.out.print("Continue? y/n: ");
			choice = sc.next();

		}
		System.out.println();
		System.out.println("Bye!");
	}
}
