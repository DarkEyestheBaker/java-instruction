import java.io.Console;

public class PersonalManagerApp {
	public static void main(String[] args) {

		System.out.println("Welcome to the Person Manager!");

		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			System.out.print();
			String custOrEmp = Console.getString("Create customer or employee?  (c/e");

			boolean isValid;
			if (custOrEmp.equalsIgnoreCase("c") || custOrEmp.equalsIgnoreCase("e")) {
				isValid = true;
			}

			if (!isValid) {
				System.out.println("Error!  This entry is required.  Please try again.");
				continue;
			}
			String firstName = Console.getString("First name: ");
			String lastName = Console.getString("Last name: ");

			if (custOrEmp.equalsIgnoreCase("c")) {
				String custNum = Console.getString("Customer number:");

				Customer customer = new Customer(firstName, lastName, custNum);

				System.out.println("You entered a new customer");
				p = customer;
			} else {
				String ssn = Console.getString("SSN:  ");

				Employee employee = new Employee(firstName, lastName, ssn);
				System.out.println("You entered a new employee.");
				p = employee;
			}
			System.out.println("");
			choice = Console.getString("Continue?  (y/n)");

		}
		{

		}
//	public PersonalManagerApp(String firstName, String lastName) {
//		super(firstName, lastName);
	}
}
