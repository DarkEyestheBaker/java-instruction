import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public final class CustomerTextFile implements DAO<Customer> {

	private List<Customer> customers = null;
	private Path customersPath = null;
	private File customersFile = null;

	private final String FIELD_SEP = "\t";

	public CustomerTextFile() {
		customersPath = Paths.get("customers.txt");
		customersFile = customersPath.toFile();
		// Read the customers from the file
		getAll();
	}

	@Override
	public List<Customer> getAll() {
		// if the customers file has already been read, don't read it again
		if (customers != null) {
			return customers;
		}

		customers = new ArrayList<>();

		// load the array list with Customer objects created from
		// the data in the file
		if (Files.exists(customersPath)) {
			try (BufferedReader in = new BufferedReader(new FileReader(customersFile))) {

				String line = in.readLine();

				while (line != null) {
					String[] fields = line.split(FIELD_SEP);
					Customer cust = new Customer(fields[0], fields[1], fields[2]);
					customers.add(cust);

					line = in.readLine();
				}
			} catch (IOException e) {
				System.out.println("Caught IOException in getAll(). " + e);
				return null;
			}
		} else {
			System.out.println("Customers file not found at " + customersPath.toAbsolutePath());

		}
		return customers;
	}

	@Override
	public Customer get(String email) throws IOException, NoSuchCustomerException {
		for (Customer c : customers) {
			if (c.getEmail().equals(email)) {
				return c;
			}
		}
		throw new NoSuchCustomerException("Customer with email " + email + " not found.");

	}

	@Override
	public boolean add(Customer c) {
		customers.add(c);
		return this.saveAll();
	}

	@Override
	public boolean delete(Customer c) {
		customers.remove(c);
		return this.saveAll();
	}

	@Override
	public boolean update(Customer newCustomer) {
		// get the old customer and remove it
		try {
			Customer oldCustomer = this.get(newCustomer.getEmail());
			int i = customers.indexOf(oldCustomer);
			customers.remove(i);

			// add the updated customer
			customers.add(i, newCustomer);
		} catch (NoSuchCustomerException ignored) {
			return false;
		}

		return this.saveAll();
	}

	private boolean saveAll() {
		// save the Customer objects in the array list to the file
		try (PrintWriter out = new PrintWriter(customersWriter(new BufferedWriter(new FileWriter(customersFile))))) {
			for (Customer c : customers) {
				out.print(c.getFirstName());
				out.print(FIELD_SEP);
				out.print(c.getLastName());
				out.print(FIELD_SEP);
				out.println(c.getEmail());
			}
		} catch (IOException e) {
			System.out.println(e);
			return false;
		}

		return true;
	}

	private Writer customersWriter(BufferedWriter bufferedWriter) {
		// TODO Auto-generated method stub
		return null;
	}
}