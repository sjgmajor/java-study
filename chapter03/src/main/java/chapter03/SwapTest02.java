package chapter03;

public class SwapTest02 {

	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		
		System.out.println("a =" + a+ ", b=" + b);

		swap(a,b);
		
		System.out.println("a =" + a+ ", b=" + b);
		}

	
	// call by value로 인해 작업 후 삭제됨
	private static void swap(int m, int n) {
		int temp = m;
		m = n;
		n = temp;
		
	}
	
	

}
