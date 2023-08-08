package prob04;
public class Prob04 {

	public static void main(String[] args) {
		char[] c1 = reverse( "Hello World" );
		printCharArray( c1 );
		
		char[] c2 = reverse( "Java Programming!" );
		printCharArray( c2 );
	}
	
	public static char[] reverse(String str) {
		/* 코드를 완성합니다 */
		 char[] array = str.toCharArray();
	     int length = array.length;
		
	     for(int i = 0; i < length/2; i++) {
	            char temp = array[i];
	            array[i] = array[length - i - 1];
	            array[length - i - 1] = temp;
	        }   
	     
		return array;
	}

	public static void printCharArray(char[] array){
		/* 코드를 완성합니다 */
		for (char c : array) {
            System.out.print(c);
        }
		System.out.println();
	}
}