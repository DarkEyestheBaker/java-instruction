
public class AreaCalculatorApp {
	private static void printArea(String shapeName, Shape shape) {
		System.out.println("The area of the " + shapeName + " you entered is " + shape.getArea());
	}

	public static void main(String[] args) {
		System.out.println("Welcome to the Area Calculator");
		System.out.println();

		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			String csr = Console.getString("Calculate area of a circle, square, or rectangle? c/s/r/  ");

			switch (csr) {
			case "c":
			case "C":
				double radius = Console.getDouble("Enter radius: ");
				Circle circle = new Circle(radius);
//				System.out.println("The area of the circle you entered is:  " + circle.getArea());
				printArea("Circle", circle);
				break;

			case "s":
			case "S":
				double squarewidth = Console.getDouble("Enter width: ");
				Square square = new Square(squarewidth);
//				System.out.println("The area of the square you entered is: " + square.getArea());
				printArea("Square", square);
				break;

			case "r":
			case "R":
				double rectangleWidth = Console.getDouble("Enter width: ");
				double height = Console.getDouble("Enter height: ");
				Rectangle rectangle = new Rectangle(rectangleWidth, height);
//				System.out.println("The area of the rectangle you entered is: " + rectangle.getArea());
				printArea("Rectangle", rectangle);
				break;
			}
			System.out.println();
			choice = Console.getString("Continue?  (y/n) ");
			System.out.println();
		}
		System.out.println("Come back soon!");
	}

}
