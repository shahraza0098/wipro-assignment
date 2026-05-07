package assignment_eight;
import java.util.*;

public class Non_repeat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		  String str = "shashid";

	        HashMap<Character, Integer> map = new HashMap<>();

	     
	        for (char ch : str.toCharArray()) {
	            map.put(ch, map.getOrDefault(ch, 0) + 1);
	        }

	      
	        for (char ch : str.toCharArray()) {
	            if (map.get(ch) == 1) {
	                System.out.println("mpm rep chrac: " + ch);
	                return;
	            }
	        }

	        System.out.println("not found");

	}

}
