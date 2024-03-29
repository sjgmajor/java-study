package chapter04;

public class ObjectTest01 {

	public static void main(String[] args) {
		Point point = new Point();

		// Class klass = point.getClass(); // reflection
		System.out.println(point.getClass());
		System.out.println(point.hashCode()); // address X
											  // reference X
											  // address 기반의 해싱값
		
		System.out.println(point.toString()); // getClass() + "@" + hashCode()
		System.out.println(point); // println에 point를 입력하면 point.toString을 출력함
	}

}
