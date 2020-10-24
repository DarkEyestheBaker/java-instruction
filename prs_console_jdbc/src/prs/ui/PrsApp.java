package prs.ui;

import java.sql.SQLException;
import java.util.List;

import prs.business.Product;
import prs.database.ProductDB;
import prs.exceptions.PrsDataException;

public class PrsApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the PRS App");
		System.out.println();
		System.out.println("COMMANDS");
		System.out.println("la - List all products");
		System.out.println("gp - Get product");
		System.out.println("ap - Add product");
		System.out.println("dp - Delete product");
		System.out.println("exit - Exit the application");
		System.out.println();
		String command = "";
		while (!command.equalsIgnoreCase("exit")) {
			command = Console.getString("Enter command: ");
			switch (command.toLowerCase()) {

			case "la":
				listProducts();
				break;

			case "gp":
				long id = ps.getLong("ProductID");
				String productName = ps.getString("ProductName: ");
				break;

		if (user == isAdmin()) {
				case "ap":
				long id = pa.addLong("ProductID");
				String product pa = pa.getString("int id, int vendorId, String partNumber, String name, double price, String unit, String photoPath");
				break;
		} else  {
			
			System.out.println("You do not have access to that function.");

				if (user == isAdmin()) {
			case "dp":
				long id = pd.deleteLong("Delete");
				break;
		} else  {
			
		System.out.println("You do not have access to that function.");
		
			case "exit":
				// Nothing to do
		
				break;
				
			default:
				System.out.println("Invalid Command.");
				break;
			}
			}

	private static void listProducts() {
		try {
			ProductDB productDb = new ProductDB();
			List<Product> products = productDb.getAll();
			System.out.println("Products:");
			for (Product product : products) {
				System.out.println(product);
			}
			System.out.println();
		} catch (PrsDataException e) {
			System.out.println("Could not retrieve products. Msg: " + e.getMessage());
		}
	}
}
