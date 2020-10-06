import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WizardInventory {

	public String getCommand() {
		return command;
	}

	{
	}
	private static final int MAX_INVENTORY_SIZE = 4;

	public static void main(String[] args) {
		printWelcomeMessage();

		List<String> inventory = new ArrayList<>();
		inventory.add("wooden staff");
		inventory.add("wizard hat");
		inventory.add("cloth shoes");
		inventory.add("tabby cat");
		System.out.println();

		boolean done = false;
		String command = "go";
		while (!command.equalsIgnoreCase("exit")) {
			command = Console.getString("Command:  ");
			System.out.println();

			switch (command) {
			case "show":
				showInventory(inventory);
				break;

			case "grab":
				addItemToInventory(inventory);
				break;

			case "edit":
				editInventory(inventory);
				break;

			case "drop":
				dropItemFromInventory(inventory);
				break;

			case "exit":
				done = true;
				System.out.println();
				System.out.println("Faretheewell and safe travels, adventurer!");
				break;

			default:
				System.out.println();
				System.out.println("No, fool!  Try again!");
				break;

			}
		}
	}

	// Print lines - no input needed
	String command;

	private static void printWelcomeMessage() {
		Scanner input = new Scanner(System.in);

		System.out.println("Welcome, adventurers, to the Wizard Inventory Game!");
		System.out.println();
		System.out.println("COMMAND MENU: ");
		System.out.println("show - Show all items");
		System.out.println("grab - Grab an item");
		System.out.println("edit - Edit an item");
		System.out.println("drop - Drop an item");
		System.out.println("exit - Exit program");
		System.out.println();
	}

	private static void showInventory(List<String> inventory) {
//		int oneBasedIndex = 1;

		for (String item : inventory) {
			System.out.println(inventory.indexOf(item) + 1 + ".  " + item);
//			oneBasedIndex++;

		}
	}

	private static void addItemToInventory(List<String> inventory) {
		if (inventory.size() > MAX_INVENTORY_SIZE) {
			System.out.println("You are overburdened.  Drop one item.");
			return;
		}
		String newItem = Console.getString("Name:  ");
		inventory.add(newItem);
		System.out.println(newItem + " was added.");

	}

	private static void editInventory(List<String> inventory) {
		int oneBasedIndex = Console.getInt("Number: ");
		int zeroBasedIndex = oneBasedIndex - 1;

		if (zeroBasedIndex < 0 || zeroBasedIndex >= inventory.size()) {
			System.out.println("Index invalid! ");
			return;
		}
		String newItemName = Console.getString("Updated name:  ");
		String previousItemName = inventory.set(zeroBasedIndex, newItemName);
		System.out.println("Replaced" + previousItemName + " with " + newItemName);
	}

	private static void dropItemFromInventory(List<String> inventory) {
		int oneBasedIndex = Console.getInt("Number: ");
		int zeroBasedIndex = oneBasedIndex - 1;

		if (zeroBasedIndex < 0 || zeroBasedIndex >= inventory.size()) {
			System.out.println("Index invalid! ");
			return;
		}
		String removedItem = inventory.remove(zeroBasedIndex);
		System.out.println(removedItem + " was removed!");

	}
}
