package dietsch.ui;

import java.util.Scanner;

public class Console {

	private static Scanner sc = new Scanner(System.in);

	public static void displayLine() {
		System.out.println();
	}

	public static void displayLine(String s) {
		System.out.println(s);
	}

	public static String getString(String prompt) {
		System.out.print(prompt);
		String s = sc.nextLine();
		return s;
	}

	public static String getString(String prompt, String allowedValOne, String allowedValTwo) {
		String value = "";
		boolean isValid = false;
		while (!isValid) {
			value = getString(prompt);
			if (value.equalsIgnoreCase(allowedValOne) || value.equalsIgnoreCase(allowedValTwo)) {
				isValid = true;
			} else {
				System.out.println("Invalid entry. Please enter " + allowedValOne + " or " + allowedValTwo);
			}
		}
		return value;
	}

	String choice = "y";
	{
	while(choice.equalsIgnoreCase("y") ) {
	{
		System.out.println("Enter grade: ");
	}
}

	public static int getInt(String prompt) {
		int i = 0;
		boolean isValid = false;
		while (!isValid) {
			System.out.print(prompt);
			if  is valid = true;
		System.out.println("Error! Invalid integer. Try again.");
			}
		}return i;

	}

	public static double getDouble(String prompt) {
		double d = 0;
		while (true) {
			System.out.print(prompt);
			try {
				d = Double.parseDouble(sc.nextLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println("Error! Invalid decimal. Try again.");
			}
		}
		return d;
	}
}