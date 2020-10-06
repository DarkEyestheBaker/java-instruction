import java.util.HashMap;

public class HTMLConverterApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the HTML Converter!");
		private static String 
		String  grocList  = "<h1>Grocery List</h1>\n" +
				"<ul>\n" +
				" <li>Eggs</li>\n" +
				" <li>Milk</li>\n" +
				" <li>Butter</li>\n" +
				"</ul>";
		String[] grocListArray = grocList.split("  ");
		System.out.println("grocListArray length = " + grocListArray.length);
		for (String g : grocListArray) {
			System.out.println(g);
		System.out.println();
		}


		
		
		System.out.println("INPUT");
		
		
		System.out.println("OUTPUT");
	}

}
