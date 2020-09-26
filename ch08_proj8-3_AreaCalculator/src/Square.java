
public class Square extends Shape {

	// Fields
	private double width;

	// Constructors
	public Square(double width) {
		this.width = width;

	}

	// Getters & Setters
	public double getWidth() {
		return width;

	}

	public void setArea(double width) {
		this.width = width;

	}

	// Override
	@Override
	public double getArea() {
		double area = width * width;
		return area;
		// or return Math.pow(width, 2.0);

	}

}
