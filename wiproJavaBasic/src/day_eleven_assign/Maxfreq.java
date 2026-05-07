package day_eleven_assign;
import java.util.*;
public class Maxfreq {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 int[] arr = {1, 2, 3, 1, 2, 1, 4};

	        HashMap<Integer, Integer> map = new HashMap<>();

	   
	        for (int num : arr) {
	            map.put(num, map.getOrDefault(num, 0) + 1);
	        }

	        int maxFreq = 0;
	        int element = 0;

	        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

	            if (entry.getValue() > maxFreq) {
	                maxFreq = entry.getValue();
	                element = entry.getKey();
	            }
	        }

	        System.out.println("element" + element);
	        System.out.println("freq: " + maxFreq);

	}

}
