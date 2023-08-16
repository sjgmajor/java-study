package prob05;

@SuppressWarnings("serial")
public class UserNotFoundException extends RuntimeException{
	
	UserNotFoundException(){
		
	}
	
	UserNotFoundException(String message){
		super(message);
	}
	
}
