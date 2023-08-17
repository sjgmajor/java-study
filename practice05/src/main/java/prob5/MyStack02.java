package prob5;

public class MyStack02 {
	
	private int maxSize;
	private int top;
	private Object[] stackArr;


	public MyStack02(int maxSize) {
		this.maxSize = maxSize;
		this.top = -1;
		this.stackArr = new Object[maxSize];
	}
	
	public void push(Object str){
		if(isFull()) {
			resizeStackArr();
		}
		stackArr[++top] = str;
	}
	
	private void resizeStackArr() {
		maxSize *= 2;
		Object[] newStackArr = new Object[maxSize];
		for(int i = 0; i <= top; i++) {
			newStackArr[i] = stackArr[i];
		}
		stackArr = newStackArr;		
	}

	public Object pop() throws MyStackException{
		if(isEmpty()) {
			throw new MyStackException();
		}
		return stackArr[top--];
	}

	public boolean isEmpty() {
		return (top == -1);
	}

    public boolean isFull() {
		return (top == maxSize -1);
	}
}