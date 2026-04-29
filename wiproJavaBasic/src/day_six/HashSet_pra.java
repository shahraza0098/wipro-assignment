package day_six;

import java.util.*;

public class HashSet_pra {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		  Set<String> set = new LinkedHashSet<>();

	        set.add("Orange");
	        set.add("Mango");
	        set.add("Kiwi");
	        set.add("Apple");
	        set.add("Apple"); // duplicate (ignored)
	        set.add(null);
	        set.add(null);    // duplicate null (ignored)

	        System.out.println(set);

	        // equals check
	        System.out.println(set.equals("Orange")); // false

	        // remove element
	        set.remove("Kiwi");

	        // iterate using Iterator
	        Iterator<String> itr = set.iterator();
	        while (itr.hasNext()) {
	            System.out.println(itr.next());
	        }

	}

}
