import java.text.NumberFormat;

public class MonthSelectorApp {

	public static void main(String[] args) {
		System.out.println("Monthly Sales\n");
		
		// declare monthNames and monthSales arrays
String[] month = new String[13]
			
			int [] monthNumber = new month(13); {
			month[0]=null;
			month[1]=January;
			month[2]=February;
			month[3]=March;
			month[4]=April;
			month[5]=May;
			month[6]=June;
			month[7]=July;
			month[8]=August;
			month[9]=September;
			month[10]=October;
			month[11]=November;
			month[12]=December;

			int m = Integer.parseInt();System.out.println(month);
		// get currency formatting
		NumberFormat currency = NumberFormat.getCurrencyInstance();

		// get one or more months
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			// get the input from the user
			int monthNumber = Console.getInt("Enter month number: ");

			// validate input
			if (monthNumber < 1 || monthNumber > 12) {
				Console.displayLine("Invalid month number. Please try again.");
				continue;
			}

			// get the index number for the month
			// and display the month name and sales

			// check if the user wants to continue
			choice = Console.getString("Continue? (y/n): ");
			Console.displayLine();
		}

		// display the total sales for the year

		Console.displayLine();
	}

}
