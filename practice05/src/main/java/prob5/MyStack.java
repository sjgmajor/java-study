package prob5;

public class MyStack {
	
	private int top;
	private String[] stackArr;
	private int maxSize;

	
	public MyStack(int maxSize) {
		this.top = -1;
		this.stackArr = new String[maxSize];
		this.maxSize = maxSize;
	}
	
	public void push(String str) throws MyStackException {
		if(isFull()) {
			resizeStackArr();
		}
		top++;
		stackArr[top] = str;

	}
	
	private void resizeStackArr() {
		maxSize *= 2;
		String[] newStackArr = new String[maxSize];
		for(int i = 0; i < top; i++) {
			newStackArr[i] = stackArr[i];
		}
		stackArr = newStackArr;		
	}



	public String pop() throws MyStackException{
		if(isEmpty()) {
			throw new MyStackException();
		}
		String str = stackArr[top];
		top--;
		return str;
	}

	public boolean isEmpty() {
		
		return top == -1;
	}

    public boolean isFull() {
		
		return top == maxSize -1;
	}
	
}