import java.text.NumberFormat;

public class AccountBalanceApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Account Balance Calculator!");
		System.out.println();

		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();

		CheckingAccount ca = new CheckingAccount(1000.0, 1.0);
		SavingsAccount sa = new SavingsAccount(1000.0, 1.0);

		System.out.println("Starting balances");
		System.out.println("Checking: " + currencyFormatter.format(ca.getBalance()));
		System.out.println("Savings: " + currencyFormatter.format(sa.getBalance()));

		System.out.println();
		System.out.println("Enter the transactions for the month:	");
		System.out.println();

		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {

			{
				String wOrD = Console.getString("Withdraw or deposit? (w/d) ");
				String chkOrSav = Console.getString("Checking or savings? (c/s) ");
				double amount = Console.getDouble("Amount?: ");

				if (wOrD.equalsIgnoreCase("w")) {
					if (chkOrSav.equalsIgnoreCase("c")) {
						withdrawAmount(ca, amount);
					} else {
						withdrawAmount(sa, amount);
					}
				} else {
					if (chkOrSav.equalsIgnoreCase("c")) {
						depositAmount(ca, amount);
					} else {
						depositAmount(sa, amount);
					}
				}
				System.out.println();
				choice = Console.getString("Continue? (y/n)");
			}

//Do end of month
			ca.applyMonthlyFee();
			sa.applyMonthlyInterest();

			System.out.println("Monthly payments and fees");
			System.out.println("Checking fee: 		" + currencyFormatter.format(ca.getMonthlyFee()));
			System.out.println("Savings interest payment:	" + currencyFormatter.format(sa.getCalculatedInterest()));
			System.out.println();
			System.out.println("Finals balances");
			System.out.println("Checking:" + currencyFormatter.format(ca.getBalance()));
			System.out.println("Savings: " + currencyFormatter.format(sa.getBalance()));
		}
	}

	private static void withdrawAmount(Withdrawable w, double amount) {
		w.withdraw(amount);
	}

	private static void depositAmount(Depositable d, double amount) {
		d.deposit(amount);

	}
}
