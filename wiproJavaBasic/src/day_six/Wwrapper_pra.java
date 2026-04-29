package day_six;
import java.util.*;

public class Wwrapper_pra {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    // Primitive data
		List<Integer> ls=new ArrayList<Integer>();
		ls.add(9);
		ls.add(8);
		ls.add(4);
		
		ls.remove(Integer.valueOf(8));
		
		
		System.out.println(ls);
        int a = 10;

       
        Integer b = a;

       
        int c = b;

//        System.out.println(b);

        // Float examples
        float i = 20;
        Float j = i;   // Autoboxing
        float k = j;   // Unboxing

	}

}
