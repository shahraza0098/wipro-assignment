package day_seven;

import java.util.*;

public class Hashmap_pra {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		 Map<String, Integer> map = new HashMap<>();

	        map.put("One", 1);
	        map.put("Ten", 10);
	        map.put("Nine", 9);
	        map.put("Two", 2);
	        map.put("Three", 3);
	        map.put("Three", 8);   // overwrites previous value
	        map.put("Other", 10);
	        map.put(null, null);
	        map.put(null, 3);      // overwrites null key value

	        System.out.println(map);

	        System.out.println(map.containsKey("nine"));   // case-sensitive
	        System.out.println(map.containsValue(9));

	        map.replace("Other", 10, 11);
	        map.replace("Nine", 90);  // replaces value directly

	        System.out.println(map);

	        System.out.println(map.get("Nine"));
	        System.out.println();
	}

}
