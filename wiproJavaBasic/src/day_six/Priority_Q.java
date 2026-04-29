package day_six;

import java.util.*;

public class Priority_Q {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Queue<String> q = new PriorityQueue<>();
		

        q.add("Dahod");
        q.add("Chennai");
        q.add("Mumbai");
        q.add("Pune");
        q.add("Bhopal");
        q.add("Ahemdabad");

        System.out.println(q);

        // remove head element
        q.remove();
        System.out.println(q);

        q.remove();
        System.out.println(q);

        // remove specific element
        q.remove("Mumbai");
        System.out.println(q);

        // offer (adds element)
        System.out.println(q.offer("Alpha"));

        System.out.println(q);

        // peek → retrieve head (does not remove)
        System.out.println(q.peek());

        // poll → retrieve and remove head
        System.out.println(q.poll());

	}

}
