
public class BattingStatsApp {

	public BattingStatsApp() {

	}

	public static void main(String[] args) {
		System.out.println("Welcome to the Batting Average Calculator!  Batter UP!");
		System.out.println();

		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {

			choice = Console.getString("Continue?  (y/n) ");
			System.out.println("You're out!");
			System.out.println();
		}
	}

}
