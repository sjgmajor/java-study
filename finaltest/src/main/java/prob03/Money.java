package prob03;

import java.util.Objects;

public class Money {
	
	private int amount;
	
	public Money(int amount) {
		this.setAmount(amount);
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Money other = (Money) obj;
		return amount == other.amount;
	}

	public Object add(Money money) {
		return new Money(this.amount + money.amount);
	}

	public Object minus(Money money) {
		return new Money(this.amount - money.amount);
	}

	public Object multiply(Money money) {
		return new Money(this.amount * money.amount);
	}

	public Object devide(Money money) {
		return new Money(this.amount / money.amount);
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

