import java.text.NumberFormat;

public class MonthSelectorApp {

	public static void main(String[] args) {
		System.out.println("Monthly Sales\n");

		// declare monthNames and monthSales arrays
		String[] monthNames = { "Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sept", "Oct", "Nov", "Dec" };
		double[] monthSales = { 100.00, 200.01, 300.02, 400.03, 500.04, 600.05, 700.07, 800.08, 900.09, 1000.10,
				1100.11, 1200.12 };
//			int [] month = new month(13); 
//			month[0]=null;
//			month[1]=January;
//			month[2]=February;
//			month[3]=March;
//			month[4]=April;
//			month[5]=May;
//			month[6]=June;
//			month[7]=July;
//			month[8]=August;
//			month[9]=September;
//			month[10]=October;
//			month[11]=November;
//			month[12]=December;

//			int m = Integer.parseInt();System.out.println(month);
		// get currency formatting
		NumberFormat currency = NumberFormat.getCurrencyInstance();

		// get one or more months
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			// get the input from the user
			int monthNumber = Console.getInt("Enter month number: ");

			// validate input
			if (monthNumber < 1 || monthNumber > monthNames.length) {
				Console.displayLine("Invalid month number. Please try again.");
				continue;
			}

			// get the index number for the month
			// and display the month name and sales
			int monthIndex = monthNumber - 1;
			String monthName = monthNames[monthIndex];
			double salesForMonth = monthSales[monthIndex];

			System.out.println("Sales for  " + monthName + ": " + currency.format(salesForMonth));
			// check if the user wants to continue
			System.out.println();
			choice = Console.getString("Continue? (y/n): ");
			Console.displayLine();
		}

		// display the total sales for the year
		double totalSales = 0.0;

//		for (int i = 0; i < monthSales.length; i++) {
//			totalSales = totalSales + monthSales[i];
//		}
		for (double sales : monthSales) {
			totalSales += sales;
		}

		System.out.println("Total sales: " + currency.format(totalSales));
		Console.displayLine();
	}

}
