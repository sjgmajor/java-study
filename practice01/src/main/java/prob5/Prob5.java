package prob5;

public class Prob5 {

	public static void main(String[] args) {
	
		 for (int i = 1; i <= 99; i++) {
	            int tenDigit = i / 10;
	            int oneDigit = i % 10;

	            int clapCount = 0;
	            if (tenDigit % 3 == 0 && tenDigit != 0) {
	                clapCount++;
	            }
	            if (oneDigit % 3 == 0 && oneDigit != 0) {
	                clapCount++;
	            }

	            if (clapCount > 0) {
	                System.out.print(i + ": ");
	                for (int j = 0; j < clapCount; j++) {
	                    System.out.print("짝");
	                }
	                System.out.println();
	            }
	        }

	
	
	
	
	
	
	
	}
}
