
public class Rectangle extends Square {

	// Fields
	private double height;

	// Constructors
	public Rectangle(double width, double height) {
		super(width);
		this.height = height;
	}

	// Getters & Setters
	public double getHeight() {
		return this.height;

	}

	public void setHeight(double height) {
		this.height = height;

	}

	// Override
	@Override
	public double getArea() {
		return this.getWidth() * height;
	}

}