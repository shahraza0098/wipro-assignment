package day_eleven_assign;
import java.util.*;
public class RemoveDup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	    String str = "aawweessdvfrgb";

        HashSet<Character> s = new HashSet<>();

        String res = "";

        for (char ch : str.toCharArray()) {

            if (!s.contains(ch)) {
                s.add(ch);
                res += ch;
            }
        }

        System.out.println("dup remove " + res);

	}

}
