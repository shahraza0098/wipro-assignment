package day_eleven_assign;

public class NonRepeating {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	     String str = "shahid";

	        char result = ' ';

	        for (int i = 0; i < str.length(); i++) {

	            int count = 0;

	            for (int j = 0; j < str.length(); j++) {

	                if (str.charAt(i) == str.charAt(j)) {
	                    count++;
	                }
	            }

	            if (count == 1) {
	                result = str.charAt(i);
	                break;
	            }
	        }

	        System.out.println("first non repeateing " + result);

	}

}
