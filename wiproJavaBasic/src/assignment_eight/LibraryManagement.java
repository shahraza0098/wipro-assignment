package assignment_eight;

import java.util.*;
public class LibraryManagement {
	
	 public boolean checkAvailibilty(Map<String, Boolean> lib, String bookName) {
	        if (lib.containsKey(bookName)) {
	            return true;
	        }
	        return false; 
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Boolean> lib = new HashMap<>();
		lib.put("book1", true);
		lib.put("book2", true);
		lib.put("book3", false);
		lib.put("book4", true);
		lib.put("book5", false);
		
		
	     LibraryManagement obj = new LibraryManagement();

	        String book = "book3";

	        if (obj.checkAvailibilty(lib, book)) {
	            System.out.println(book + " available");
	        } else {
	            System.out.println(book + " not available");
	        }
		
		
		
		

	}

}
