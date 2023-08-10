package paint;

public abstract class Shape implements Drawable {
	private String lineClolr;
	private String fillColor;
		
	public String getLineClolr() {
		return lineClolr;
	}
	public void setLineClolr(String lineClolr) {
		this.lineClolr = lineClolr;
	}
	public String getFillColor() {
		return fillColor;
	}
	public void setFillColor(String fillColor) {
		this.fillColor = fillColor;
	}

}
