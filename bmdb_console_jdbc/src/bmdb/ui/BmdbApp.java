package bmdb.ui;

import java.time.LocalDate;
import java.util.List;

import bmdb.business.Actor;
import bmdb.db.ActorDB;

public class BmdbApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Bootcamp Movie Database!");
		System.out.println();
		System.out.println("COMMANDS");
		System.out.println("la = List Actors");
		System.out.println("aa - Add Actor");
		System.out.println("gabn - Get Actor by Last Name");
		System.out.println("gabi - Get Actor by ID");
		System.out.println("da - Delete Actor by ID");
		System.out.println("ca - Change Actor");
		System.out.println("exit - Exit Application");

		ActorDB actorDB = new ActorDB();

		String command = Console.getLine("Enter command:  ");
		while (!command.equalsIgnoreCase("exit")) {

			switch (command) {
			case "la":
				List<Actor> actors = actorDB.getAll();
				System.out.println("Actors: ");
				for (Actor actor : actors) {
					System.out.println(actor);
				}
				break;

			case "aa":
				String changeFirstName = Console.getString("First name: ");
				String changeLastName = Console.getString("Last name: ");
				String changeGender = Console.getString("Gender (M/F):");
				String changeBirthDateStr = Console.getString("Birthdate: (YYYY-MM-DD): ");
				LocalDate changeBirthDate = LocalDate.parse(changeBirthDateStr);

				Actor actor = new Actor(0, changeFirstName, changeLastName, changeGender, changeBirthDate);

				if (actorDB.add(actor)) {
					System.out.println("Actor changed successfully!");
				} else {
					System.out.println("Error changing actor.");
				}
				break;

			case "gabn":
				String lastName = Console.getString("Actor's last name: ");
				Actor actor2 = actorDB.getActorByLastName(lastName);
				if (actor2 == null) {
					System.out.println("No actor found");
				} else {
					System.out.println(actor2);
				}
				break;

			case "gabi":
				long id = Console.getInt("Actor's ID: ");
				Actor actorByID = actorDB.get(id);
				if (actorByID == null) {
					System.out.println("No actor found.");
				}
				break;

			case "da":
				long idToDel = Console.getInt("Actor's ID to delete: ");
				if (actorDB.delete(idToDel)) {
					System.out.println("Actor deleted successfully.");
				} else {
					System.out.println("Error deleting actor.");
				}
				break;

			case "ca":
				String newFirstName = Console.getString("First name: ");
				String newLastName = Console.getString("Last name: ");
				String newGender = Console.getString("Gender (M/F):");
				String newBirthDateStr = Console.getString("Birthdate: (YYYY-MM-DD): ");
				LocalDate newBirthDate = LocalDate.parse(newBirthDateStr);

				Actor newActor = new Actor(0, newFirstName, newLastName, newGender, newBirthDate);

				if (actorDB.add(newActor)) {
					System.out.println("Actor added successfully!");
				} else {
					System.out.println("Error adding actor.");
				}
				break;

			}
			System.out.println();
			command = Console.getString("Enter command:  ");
		}
	}
}
