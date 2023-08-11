package prob6;

public class RectTriangle extends Shape implements Resizable {

	private double width;
	private double height;
	
	public  RectTriangle(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	@Override
	public void resize(double s) {
		width *= s;
		height *= s;
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
