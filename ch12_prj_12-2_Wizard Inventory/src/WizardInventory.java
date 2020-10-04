import java.util.ArrayList;

public class WizardInventory {
	private String show;
	private String grab;
	private String edit;
	private String drop;
	private String exit;
	public () {
		
	}
	//Inventory
	public static void main(String[] args) {
		ArrayList<String> wizInv = new ArrayList<>(4);
		wizInv.add("Tome of the Wizards");
		wizInv.add("Ring of Spell Storing");
		wizInv.add("Cloak of Displacement");
		 wizInv.add("Illusionist's Bracers");

		 //Edit Inventory - Remove one item and add Rod of Stewart
		 String wizInv = wizInv.remove();
		 
		 System.out.println("One " + wizInv + "was banished from this realm!  And " + wizInv.add("Rod of Stewart") + " was given a place of honor!");
		 
					
//Print lines - no input needed
		System.out.println("Welcome to the Wizard Inventory Game!");
		System.out.println();
		System.out.println("COMMAND MENU: ");
		System.out.println("show - Show all items");
		System.out.println("grab - Grab an item");
		System.out.println("edit - Edit an item");
		System.out.println("drop - Drop an item");
		System.out.println("exit - Exit program");

	}
	public  {
		this.command = command;
	}
	
	// get the input from the user
	System.out.println("Your command? ");
	if (this.)

}
