package day_four;

public class Isarraypalidrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {5, 2, 3, 2, 5};
		
		
		boolean isArrayPalindrome=true;
		
		int i=0;
		int j= arr.length-1;
		
		while(i<j) {
			if(arr[i]!=arr[j]) {
				isArrayPalindrome=false;
			}
			i++;
			j--;
		}
		
		  if (isArrayPalindrome) {
	            System.out.println("palindrome");
	        } else {
	            System.out.println("not palindrome");
	        }

	}

}
