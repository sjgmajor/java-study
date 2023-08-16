package prob02;

public class Sub implements Arithmetic {

	@Override
	public int calculate(int lValue, int rValue) {
		return (int)(lValue - rValue);
	}

}
