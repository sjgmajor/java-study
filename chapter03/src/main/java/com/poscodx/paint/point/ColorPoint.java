package com.poscodx.paint.point;

public class ColorPoint extends Point {
	
	private String color;

	public String getColor() {
		return color;
	}

	@Override
	public void show() {
		System.out.println("점[x=" + getX() + ",y=" + getY() +
				", color=" + color + "]을 그렸습니다");
	}
	

	public void setColor(String color) {
		this.color = color;
	}
}
