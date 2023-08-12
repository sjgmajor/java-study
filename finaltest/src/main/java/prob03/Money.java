package prob03;

public class Money {
	
	private int amount;
	
	public Money(int amount) {
		this.setAmount(amount);
	}

	public Object add(Money three) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object minus(Money two) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object multiply(Money two) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object devide(Money five) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	/* 코드 작성 */
}

//1.사칙 연산 메쏘드(add, minus, multiply, devide)에서는 자신의 금액(amount)과 
//인자로 넘어온 Money 객체의 금액(amount)을 계산하고, 계산된 금액으로 새로운 Money 객체로 생성하여 리턴한다.

// 2.equals 메쏘드에서는 인자로 넘어온 Object 객체가 Money 타입인지를 확인하고, 
//Money 타입인 경우에 금액이 동일한지를 확인한다. 이 두가지 조건이 만족하는 경우에 true를 리턴한다.

