package day_four;
import java.util.HashSet;


public class Remove_dup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {1, 1,2,2,3, 4,4, 5,6, 6};
		 HashSet<Integer> s = new HashSet<>();

	        for (int num : arr) {
	            s.add(num);
	        }

	        System.out.println(s);

	}

}
