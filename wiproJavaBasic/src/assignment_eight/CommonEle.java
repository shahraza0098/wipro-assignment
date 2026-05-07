package assignment_eight;


import java.util.*;

public class CommonEle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 HashSet<Integer> s1 = new HashSet<>();
		 
	     HashSet<Integer> s2 = new HashSet<>();

	        s1.add(1);
	        s1.add(2);
	        s1.add(3);
	        s1.add(4);

	        s2.add(3);
	        s2.add(4);
	        s2.add(5);
	        s2.add(6);

	        HashSet<Integer> res = new HashSet<>();

	   //adding result
	        for (Integer num : s1) {
	            if (s2.contains(num)) {
	            	res.add(num);
	            }
	        }

	        System.out.println("common " + res);

	}

}
