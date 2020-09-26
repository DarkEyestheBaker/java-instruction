
public class Circle extends Shape {
	// Fields
	private double radius;

	// Constructors
	public Circle(double radius) {
		this.radius = radius;

	}

	// Getters & Setters
	public double getRadius() {
		return radius;

	}

	public void setRadius(double radius) {
		this.radius = radius;

	}

	// Override
	@Override
	public double getArea() {
		double area = Math.PI * radius * radius;
		return area;
	}
}
