
public class DiceRollerApp {

	private static int getDieRoll() {
		int dieRoll = (int) (Math.random() * 6) + 1;
		return dieRoll;
	}

	private static void printExtraMessage(int die1, int die2) {
		if (die1 + die2 == 2) {
			System.out.println("Snake eyes!");
		} else if (die1 + die2 == 12) {
			System.out.println("Boxcars!");
		}
	}

	public static void main(String[] args) {
		int die1 = getDieRoll();
		int die2 = getDieRoll();

		String message = "Die 1: 	" + die1 + "\nDie 2: 	" + die2 + "\nTotal: 	" + (die1 + die2);
		printExtraMessage(die1, die2);

		System.out.println(message);
	}

}
