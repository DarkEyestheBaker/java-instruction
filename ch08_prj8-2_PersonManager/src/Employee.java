public class Employee extends Person {

	// Fields
	private String ssn;

	// Constructors
	public Employee(String firstName, String lastName, String employeeNumber) {
		super(firstName, lastName);

	}

	// Getters and setters
	public String getSsnr() {
		return ssn;
	}

	public void setSsnr(String ssnr) {
		this.ssn = ssn;
	}

	// Overrides
	@Override
	public String toString() {
		String maskedSsn = "xxx-xxx-" + ssn.substring(ssn.length() - 4);

		return super.toString() + "\nSSN: " + maskedSsn;
	}

}
