package day_eleven_assign;
import java.util.*;
public class SortMapByKey {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  HashMap<Integer, String> mp = new HashMap<>();

	        mp.put(3, "io");
	        mp.put(1, "po");
	        mp.put(2, "ko");

	
	        TreeMap<Integer, String> sortedMap = new TreeMap<>(mp);

	        System.out.println(sortedMap);

	}

}
