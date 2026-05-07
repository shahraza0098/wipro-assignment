package assignment_eight;

import java.util.*;

public class SecLarEleList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> list=new ArrayList<>();
		
		list.add(5);
		list.add(8);
		list.add(9);
		list.add(11);
		list.add(19);
		list.add(15);
		   int lar = Integer.MIN_VALUE;
	        int secLar = Integer.MIN_VALUE;

	        for (int num : list) {
	            if (num > lar) {
	            	secLar = lar;
	            	lar = num;
	            } else if (num > secLar && num != lar) {
	            	secLar = num;
	            }
	        }
	        
	        
	        
	        System.out.println("secnd largest:"+ secLar);


	}

}
