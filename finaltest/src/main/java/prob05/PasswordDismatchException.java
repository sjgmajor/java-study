package prob05;

@SuppressWarnings("serial")
public class PasswordDismatchException extends RuntimeException{

	PasswordDismatchException(){
		
	}
	
	PasswordDismatchException(String message){
		super(message);
	}
}
