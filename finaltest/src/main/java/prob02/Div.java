package prob02;

public class Div implements Arithmetic {

	@Override
	public int calculate(int lValue, int rValue) {
		return (int)(lValue / rValue);
	}

}
