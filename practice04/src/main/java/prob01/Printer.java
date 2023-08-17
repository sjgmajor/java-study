package prob01;

public class Printer {
//
//	public void println(int number) {
//		System.out.println(number);
//	}
//	
//	public void println(boolean bool) {
//		System.out.println(bool);
//	}
//	
//	public void println(double doubleNumber) {
//		System.out.println(doubleNumber);
//	}
//	
//	public void println(String string) {
//		System.out.println(string);
//	}
	
	public <T> void println(T t) {
		System.out.println(t);
	}
	
	public int sum(Integer...nums) {
		int s = 0;
		for(Integer i : nums) {
			s += i;
		}
		return s;
	}

	public <T> void println(T... ts) {
		for( T t : ts) {
		System.out.println(t);
		}
	}

	
}
