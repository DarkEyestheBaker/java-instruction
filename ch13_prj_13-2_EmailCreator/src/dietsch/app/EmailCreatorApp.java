package dietsch.app;

import java.util.Locale;

public class EmailCreatorApp {

	public static void main(String[] args, Locale length) {

		String[] csv = { " james,butler ,jbutler@gmail.com", "Josephine,Darakjy,Josephine_Darakjy@darakjy.org",
				"ART,VENERE,ART@VENERE.ORG" };

		String template = "To: {email}\n" + "From: noreply@deals.com\n" + "Subject: Deals!\n\n" + "Hi {first_name},\n\n"
				+ "We've got some great deals for you. Check our website!";
		for (String currLine : csv) {
			System.out.println("=======================================================");
			String[] nameParts = currLine.split(",");

			String firstName = firstName.trim();
			String firstLtr = firstLtr.toUpperCase(0);
			String restLtr = restLtr.toLowerCase(length);
			String email = email.toLowerCase(length);
			String email = template.replace("{email}", nameParts[2]);
			String firstName = email.replace("{first_name}", nameParts[0]);
			System.out.println();
			System.out.println("first_name}" + firstLtr + restLtr);
			System.out.println();

		}

	}

}
