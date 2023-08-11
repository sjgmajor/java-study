package prob6;

public class RectTriangle extends Shape implements Resizable {

	private double width;
	private double height;
	
	public  RectTriangle(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	@Override
	public void resize(double s) {
		this.height = height * s;
		getArea();
		getPerimeter();
	}

	@Override
	double getArea() {
		return width * height * 0.5;
	}

	@Override
	double getPerimeter() {
		return width + height +  Math.sqrt((width * width) + (height * height));
	}
	

}
