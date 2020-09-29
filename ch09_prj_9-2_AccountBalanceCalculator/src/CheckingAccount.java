
public class CheckingAccount extends Account {
//Fields
	private double monthlyFee;

	// Constructors
	public CheckingAccount() {
		monthlyFee = 0.0;
	}

	public CheckingAccount(double initialBalance, double monthlyFee) {
		super(initialBalance);
		this.monthlyFee = monthlyFee;

	}

	// Getters (static monthly fee - can't remove it)
	public double getMonthlyFee() {
		return monthlyFee;
	}

	// Helpers
	public void applyMonthlyFee() {
		balance -= monthlyFee;
	}
}
