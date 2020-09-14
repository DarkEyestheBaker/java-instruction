import java.util.Scanner;

public class CalculatorApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String choice;
		do {
			System.out.println("enter first operand");
			int operand1 = sc.nextInt();
			System.out.println("enter second operand");
			int operand2 = sc.nextInt();
			System.out.println("enter operation");
			String operation = sc.next();
			int answer = 0;
			switch (operation) {
			case "+":
				answer = sum(operand1, operand2);
			case "-":
				answer = subtract(operand1, operand2);
			case "*":
				answer = multiply(operand1, operand2);
			case "/":
				answer = divide(operand1, operand2);
				break;
			}
			System.out.println("the answer is:" + answer);
			System.out.println("continue?");
			choice = sc.next();
		} while (choice.equalsIgnoreCase("y"));
	}

	private static int sum(int operand1, int operand2) {
		return operand1 + operand2;
	}

	private static int subtract(int operand1, int operand2) {
		return operand1 - operand2;
	}

	private static int multiply(int operand1, int operand2) {
		return operand1 * operand2;
	}

	private static int divide(int operand1, int operand2) {
		return operand1 / operand2;
	}
}