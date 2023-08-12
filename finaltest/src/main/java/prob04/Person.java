package prob04;

public class Person {
	private static int numberOfPerson; // 전체 인구수
	private int age = 12;
	private String name = "";
	
	/* 코드 작성 */
	public Person(String name){
		this.name = name;
		// 나이는 12살, 이름은 ""로 초기화함
		numberOfPerson++;
	}
	
	public Person(int age, String name){
		this.age = age;
		this.name = name;
		// 나이는 age 매개변수, 이름은 name 매개변수로 셋팅
		numberOfPerson++;
	}

	public void selfIntroduce(){
		System.out.println("내 이름은 " + name + "이며, 나이는 " + age + "입니다.");
		// "내 이름은 ...이며, 나이는 ...살입니다." 출력함
	}
	                             // 예) 내이름은 김철수이며, 나이는 19살 입니다.

	public static int getPopulation(){
		// 전체 인구수를 return 함
		return numberOfPerson;
	}

}
