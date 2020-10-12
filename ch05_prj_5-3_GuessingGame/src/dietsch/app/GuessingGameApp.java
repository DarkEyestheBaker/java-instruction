package dietsch.app;

public class GuessingGameApp {

	private static void displayWelcome(int limit) {
	}

	public static void main(String[] args) {

		int numToGuess = NumberUtil.getRandomInt(100);
		System.out.println(numToGuess);
		int userGuess = 0;
		int numGuesses = 0;
		System.out.println("I'm thinking of a number from 1 to 100.");
		System.out.println("Try to guess it.");
		while (userGuess != numToGuess) {
			numGuesses++;

			userGuess = Console.getInt("Enter number between 1 and 100:  ", 1, 100);

			if (userGuess > (10 + numToGuess)) {
				System.out.println("Way too high!");
			} else if (userGuess > numToGuess) {
				System.out.println("Too high!");
			} else if (userGuess < (numToGuess - 10)) {
				System.out.println("Way too low!");
			} else if (userGuess < numToGuess) {
				System.out.println("Too low!");
			} else {
				System.out.println("You got it in " + numGuesses + " tries!");
			}
		}
	}
}
