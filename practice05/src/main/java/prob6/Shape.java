package prob6;


public abstract class Shape {
	
	protected double width;
	protected double height;
	
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	abstract double getArea (); // 넓이
	abstract double getPerimeter(); // 둘레 길이


}
