import java.util;

public class Console {

	public Console() {
		import java.util.Scanner;
		    
		    private static Scanner sc = new Scanner(System.in);

		    public static String getString(String prompt) {
		        System.out.print(prompt);
		        String s = sc.next();  // read user entry
		        sc.nextLine();  // discard any other data entered on the line
		        return s;
		    }

	}
}
