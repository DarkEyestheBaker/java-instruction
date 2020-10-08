package dietsch.app;

public class GreatestCommonDivisorApp {
	public static int calculateGreatestCommonDivisor(int x, int y) {
		while (x != 0) {
			while (y >= x) {
				y = y - x;
			}
			int tmp = x;
			x = y;
			y = x;

		}
		return y;
	}

	public static void main(String[] args) {

		String choice = "y;";
		while (choice.equalsIgnoreCase("y")) {
			int firstNumber = Console.getInt("Enter first number: ");
			int secondNumber = Console.getInt("Enter second number: ");

			int gCD = calculateGreatestCommonDivisor(firstNumber, secondNumber);

			System.out.println("Greatest common divsor " + gCD);
			System.out.println();
			choice = Console.getString("Continue? (y/n");

		}

	}

}
