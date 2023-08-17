package prob5;

public class MyStack03 <T>{
	
	private int maxSize;
	private int top;
	private T[] stackArr;


	public MyStack03(int maxSize) {
		this.maxSize = maxSize;
		this.top = -1;
		this.stackArr = (T[]) new Object[maxSize];
	}
	
	public void push(T t){
		if(isFull()) {
			resizeStackArr();
		}
		stackArr[++top] = t;
	}
	
	private void resizeStackArr() {
		maxSize *= 2;
		T[] newStackArr = (T[]) new Object[maxSize];
		for(int i = 0; i <= top; i++) {
			newStackArr[i] = stackArr[i];
		}
		stackArr = newStackArr;		
	}

	public T pop() throws MyStackException{
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