package day_six;
import java.util.*;

public class List_pra {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		  List<Integer> list = new ArrayList<>();
	     
	        
	        List<Integer> list2 = new LinkedList<>();
	        

	        list2.add(5);

	        list2.add(4);
	        list2.add(9);
	        list2.add(0);
	        list2.add(8);
	        list2.add(null);
	        list2.add(null);
	        list2.add(null);
	        list2.add(8);

	     
	        list.add(4);
	        list.add(9);
	        list.add(0);
	        list.add(8);
	        list.add(null);
	        list.add(null);
	        list.add(null);
	        list.add(8);

	        // list.add(80);

	        System.out.println(list);
	        System.out.println(list.indexOf(8));
	        System.out.println(list.contains(9));
	        System.out.println(list.isEmpty());
	        System.out.println(list.lastIndexOf(null));

	        // list.remove(9); // removes index 9 (error if not present)
	        // System.out.println(list);

	        // list.remove("8"); // wrong: String vs Integer

//	        list1.remove("5"); // correct for String list
//	        System.out.println(list1);

	        System.out.println(list.get(2));

	        // getFirst() and getLast() are not available in ArrayList (Java <21)
	        System.out.println(list.get(0)); // first element
	        System.out.println(list.get(list.size() - 1)); // last element

	        list.set(2, 10);
	        System.out.println(list);

	        // reversed() only available in Java 21+
	        Collections.reverse(list);
	        System.out.println(list);

	}

}
