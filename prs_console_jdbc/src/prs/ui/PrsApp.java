package prs.ui;

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
				getProduct();
				break;

			case "ap":
				addProduct();
				break;

			case "dp":
				deleteProduct();
				break;

			case "exit":
				// Nothing to do

				break;

			default:
				System.out.println("Invalid Command.");
				break;
			}
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
