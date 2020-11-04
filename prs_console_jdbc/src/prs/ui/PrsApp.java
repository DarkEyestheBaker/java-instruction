package prs.ui;

import java.util.List;

import prs.business.Product;
import prs.business.User;
import prs.database.ProductDB;
import prs.database.UserDB;
import prs.exceptions.PrsDataException;

public class PrsApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the PRS App");
		System.out.println();
		System.out.println("COMMANDS");
		System.out.println("login - Login");
		System.out.println("la - List all products");
		System.out.println("gp - Get product");
		System.out.println("ap - Add product");
		System.out.println("dp - Delete product");
		System.out.println("exit - Exit the application");
		System.out.println();

		User authenticatedUser = null;

		String command = "";
		while (!command.equalsIgnoreCase("exit")) {
			try {

				command = Console.getString("Enter command: ");

				if (command.equalsIgnoreCase("login")) {
					authenticatedUser = login();

					if (authenticatedUser == null) {
						System.out.println("Username/password not found.");
					} else {
						System.out.println("Welcome, " + authenticatedUser.getFirstName());
					}
				} else if (command.equalsIgnoreCase("logout")) {
					authenticatedUser = null;
				} else if (command.equalsIgnoreCase("exit")) {
					System.out.println("Bye!");

				} else if (authenticatedUser != null) {

					switch (command.toLowerCase()) {
					case "login":
						login();
						break;

					case "la":
						listProducts();
						break;

					case "gp":
						getProduct();
						break;

					case "ap":
						addProduct();
						break;

					case "dp":
						deleteProduct();
						break;

//				case "lu":
//					ListUsers();
//					break;

					default:
						System.out.println("Invalid Command.");
						break;
					}
				} else {
					System.out.println("Must login to perform this action.");
				}
			} catch (Exception e) {
				System.out.println("Caught exception: " + e);
			}
		}
	}

	private static User login() {
		try {
			String userName = Console.getString("User Name: ");
			String password = Console.getString("Password: ");

			UserDB userDB = new UserDB();
			User user = userDB.authenticateUser(userName, password);
			return user;
		} catch (PrsDataException e) {
			System.err.println("Error login in. Msg: " + e.getMessage());
			return null;
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

	private static void getProduct() {
		try {
			ProductDB productDb = new ProductDB();
			int productID = Console.getInt("Product ID: ");
			Product product = productDb.get(productID);
			System.out.println("Product: " + product);
			System.out.println();
		} catch (PrsDataException e) {
			System.out.println("Could not retrieve products. Msg: " + e.getMessage());
		}
	}

	private static void addProduct() {
		System.out.println("Not implemented at this time. Check back later. ");
	}

	private static void deleteProduct() {
		System.out.println("Not implemented at this time. Check back later. ");
	}
}
