import java.util.ArrayList;
import java.util.Scanner;

public class WizardInventory {
	public String getCommand() {
		return command;
	}

	private String show;
	private String grab;
	private String edit;
	private String drop;
	private String exit;

	{

	}

	public static void main(String[] args) {
		// get the input from the user
		String command;

		Scanner input = new Scanner(System.in);		
		//Print lines - no input needed
				System.out.println("Welcome, adventurers, to the Wizard Inventory Game!");
				System.out.println();
				System.out.println("COMMAND MENU: ");
				System.out.println("show - Show all items");
				System.out.println("grab - Grab an item");
				System.out.println("edit - Edit an item");
				System.out.println("drop - Drop an item");
				System.out.println("exit - Exit program");
		

				command = input.next();
				Command[] commands = new Command[5];
				commands[0] = new Command(show);
				
				for(int i = 0; i < command; ) {
					System.out.println("Your command? ");
					commands[command] = input.next();
					
// Inventory				
				ArrayList<String> wizInv = new ArrayList<>(4);
		wizInv.add("Tome of the Wizards");
		wizInv.add("Ring of Spell Storing");
		wizInv.add("Cloak of Displacement");
		wizInv.add("Illusionist's Bracers");

		// Edit Inventory - Remove one item and add Rod of Stewart
		String wizInv = wizInv.remove();

		System.out.println("One " + wizInv + "was banished from this realm!  And " + wizInv.add("Rod of Stewart")
				+ " was given a place of honor!");



	}public

	{
		this.command = command;
	}

	// get the input from the user
	System.out.println("Your command? ");
	// Error message for bad user input
	System.out.println("No, fool!  Try again!");if(this.)
	{ //show
	}else if
	{ // grab
	}else if
	{//edit
	}else if
	{// drop
	}else
	{// exit
	}
	{
	}System.out.println("Faretheewell and safe travels, adventurer!");
}
}
