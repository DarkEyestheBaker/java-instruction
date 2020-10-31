package dietsch.ui;

import java.util.ArrayList;
import java.util.List;

import dietsch.business.Conversion;

public class LengthConverterApp {

	public static void main(String[] args) {

		List<Conversion> conversions = new ArrayList<>();
		conversions.add(new Conversion("Miles", 0.0, "Kilometers", 1.6093));
		conversions.add(new Conversion("Kilometers", 0.0, "Miles", 0.6214));
		conversions.add(new Conversion("Inches", 0.0, "Centimeters", 2.54));

		System.out.println("Length Converter");

		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {

			int action = getUserAction();

			switch (action) {
			case 1:
				doConversion(conversions);
				break;

			case 2:
				addConversion(conversions);
				break;

			case 3:
				deleteConversion(conversions);
				break;
			}

			choice = Console.getString("Continue? (y/n) ", "y", "n");
		}
	}

	private static int getUserAction() {
		System.out.println("1 - Convert a length");
		System.out.println("2 - Add a type of conversion");
		System.out.println("3 - Delete a type of conversion");
		System.out.println("4 - Exit");
		return Console.getInt("Enter menu number:  ");

	}

	private static void doConversion(List<Conversion> conversions) {
		// Print all of the conversions with 1-based numbers
		int counter = 1;
		for (Conversion conversion : conversions) {
			System.out.println(counter + " - " + conversion);
			counter++;
		}
		// Prompt the user for a conversion number
		int conversionNum = Console.getInt("Enter conversion number: ");
		// Ensure the user entry is valid
		if (conversionNum < 1 || conversionNum > conversions.size()) {
			System.out.println("Invalid conversion number");
			return;
		}
		// Decrement conversionNum to make it zero-based
		conversionNum--;
		Conversion con = conversions.get(conversionNum);
		// Prompt for the fromValue using the fromUnit in the prompt
		double fromValue = Console.getDouble("Enter " + con.getFromUnit() + ": ");
		// Set the fromValue into the chosen conversion
		con.setFromValue(fromValue);
		// Display the result
		System.out.println(
				con.getFromValue() + " " + con.getFromUnit() + " = " + con.getToValue() + " " + con.getToUnit());
	}

	public static void addConversion(List<Conversion> conversions) {
		String getFrom = Console.getString("Enter from unit: ");
		String getTo = Console.getString("Enter to unit: ");
		double conRatio = Console.getDouble("Enter the conversion ratio: ");
		if (conversions.add(new Conversion(getFrom, 0.0, getTo, conRatio))) {
			System.out.println("This entry has been saved");
		} else {
			System.out.println("Error adding new conversion");
		}
	}

	public static void deleteConversion(List<Conversion> conversions) {
		int counter = 1;
		for (Conversion conversion : conversions) {
			System.out.println(counter + " - " + conversion);
			counter++;
			int conDelete = Console.getInt("Enter conversion number to delete: ");
			if (conDelete < 1 || conDelete > conversions.size()) {
				System.out.println("Invalid conversion number");
				return;
			}
			Conversion removedCon = conversions.remove(conDelete - 1);
			System.out.println("Conversion " + conDelete + removedCon + " removed successfully");
		}
	}
}
