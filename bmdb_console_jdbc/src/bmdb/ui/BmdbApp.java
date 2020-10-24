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
		System.out.println("ua - Update Actor");
		System.out.println("gm - Get Movie");
		System.out.println("am - Add Movie");
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
				addActor(actorDB);
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

			case "gm":
				List<Movie> movies = movieDB.getAll();
				System.out.println("Actors: ");
				for (Movie movie : movies) {
					System.out.println(movie);
				}
				break;

			case "am":

				Movie newMovie = new Movie(0, newMovieTitle, newYear, newGenre, newRating, newDirector);

				if (movieDB.add(newMovie)) {
					System.out.println("Movie added successfully!");
				} else {
					System.out.println("Error adding movier.");
				}
				break;
			case "ua"
			updateActor(actorDB);
			break;

			}
			System.out.println();
			command = Console.getString("Enter command:  ");
		}
	}

	private static void addActor(ActorDB actorDB) {
		String firstName = Console.getString("First name: ");
		String lastName = Console.getString("Last name: ");
		String gender = Console.getString("Gender (M/F):");
		String birthDateStr = Console.getString("Birthdate: (YYYY-MM-DD): ");
		LocalDate birthDate = LocalDate.parse(birthDateStr);

		Actor actor = new Actor(0, firstName, lastName, gender, birthDate);

		if (actorDB.add(actor)) {
			System.out.println("Actor changed successfully!");
		} else {
			System.out.println("Error changing actor.");
		}
	}

	private static void updateActor(ActorDB actorDB);

	String updateFirstName = Console.getString("First name: ");
	String updateLastName = Console.getString("Last name: ");
	String updateGender = Console.getString("Gender (M/F):");
	String updateBirthDateStr = Console.getString("Birthdate: (YYYY-MM-DD): ");
	LocalDate updateBirthDate = LocalDate.parse(updateBirthDateStr);

	Actor actor = new Actor(0, updateFirstName, updateLastName, updateGender, updateBirthDate);

	if(actorDB.add(actor))
	{
		System.out.println("Actor changed successfully!");
	}else
	{
		System.out.println("Error changing actor.");
	}
}}
