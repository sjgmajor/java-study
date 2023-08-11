package prob3;

public class Sparrow extends Bird {
	
	public Sparrow() {
		
	}
	public Sparrow(String name) {
		this.name = name;
	}
	
	public void fly() {
		System.out.println("참새(" + name + ")가 날아다닙니다.");
	}

	public void sing() {
		System.out.println("참새(" + name + ")가 소리내어 웁니다.");
	}
	public String toString() {
		return "참새" + super.toString();
	}

}
