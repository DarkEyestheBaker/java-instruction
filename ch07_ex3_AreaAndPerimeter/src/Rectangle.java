import java.text.NumberFormat;

public class Rectangle {

	// Fields
	private double length;
	private double width;

	// Constructors
	public Rectangle() {
		length = 0.0;
		width = 0.0;
	}

	public Rectangle(double length, double width) {
		this.length = length;
		this.width = width;

	}

	// Getters and Setters or Setters and Getters
	public void setLength(double length) {
		this.length = length;
	}

	public double getLength() {
		return length;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getWidth() {
		return width;
	}

// Helper Method
	// Area
	public double getArea() {
		double area = width * length;
		return area;
	}

	public String getAreaFormatted() {
		double area = this.getArea();
		NumberFormat number = NumberFormat.getNumberInstance();
		number.setMinimumFractionDigits(3);
		String numberformatted = number.format(area);
		return numberformatted;
	}

	// Perimeter
	public double getPerimeter() {
		double perimeter = (2 * width) + (2 * length);
		return perimeter;
	}

	public String getPerimeterFormatted() {
		double perimeter = this.getPerimeter();
		NumberFormat number = NumberFormat.getNumberInstance();
		number.setMinimumFractionDigits(3);
		String numberformatted = number.format(perimeter);
		return numberformatted;
	}
}
