package prob5;

public class MyStack {
	
	private int maxSize;
	private int top;
	private String[] stackArr;


	public MyStack(int maxSize) {
		this.maxSize = maxSize;
		this.top = -1;
		this.stackArr = new String[maxSize];
	}
	
	public void push(String str){
		if(isFull()) {
			resizeStackArr();
		}
		stackArr[++top] = str;
	}
	
	private void resizeStackArr() {
		maxSize *= 2;
		String[] newStackArr = new String[maxSize];
		for(int i = 0; i <= top; i++) {
			newStackArr[i] = stackArr[i];
		}
		stackArr = newStackArr;		
	}

	public String pop() throws MyStackException{
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