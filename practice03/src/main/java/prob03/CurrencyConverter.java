package prob03;

public class CurrencyConverter {
	
	private static double rate;

	public static void setRate(double r) {
		rate = r;
	}

	public static double toDollar(double won) {
		return (double) (won / rate);
	}

	public static double toKRW(double dollar) {
		// TODO Auto-generated method stub
		return (double) (dollar * rate);
	}

}
