package Studio1;

public class Rectangle {
	
	private double length;
	private double width;
	
	public Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}
	
	public double getArea() {
		return this.length * this.width;
	}
	
	public double getPerimeter() {
		return 2 * this.length + 2 * this.width;
	}
	
	public boolean isSmaller(Rectangle otherRectangle) {
		if (this.getArea() < otherRectangle.getArea()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isSquare() {
		if (this.length == this.width) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String toString() {
		return "Length: " + this.length + " Width: " + this.width + " Area: " + this.getArea() 
			+ " Perimeter: " + this.getPerimeter() + " Is square: " + this.isSquare();
	}

	public static void main(String[] args) {
		Rectangle rect1 = new Rectangle(1, 2);
		Rectangle rect2 = new Rectangle(3, 3);
		
		System.out.println("rect1 " + rect1);
		System.out.println("rect2 " + rect2);
		
		if (rect1.isSmaller(rect2)) {
			System.out.println("rect1 is smaller");
		}
		else {
			System.out.println("rect2 is smaller");
		}
	}
}
