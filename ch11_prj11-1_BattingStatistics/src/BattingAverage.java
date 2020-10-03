import java.util.Scanner;

public class BattingAverage {

	public BattingAverage() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter # of times at bat:  ");
		int num = sc.nextInt();

		// Array
		int[] myArray = new int[num];

		for (int i = 0; i < num; i++ ) {
			myArray[i] = sc.nextInt();
		}
		System.out.println("Result for at-bat:  " + num);
		System.out.println();
		
		System.out.println("Batting average: " + (sum num  /num) );
		System.out.println("Slugging percent: " + sum (num != 0) /num );

	}

	public static void main(String[] args) {

	}

}
