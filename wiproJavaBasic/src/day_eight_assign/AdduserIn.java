package day_eight_assign;
import java.io.*;
import java.util.*;
public class AdduserIn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 Scanner sc = new Scanner(System.in);

	        try {
	            FileWriter fw = new FileWriter("data.txt", true);

	            System.out.print("add text: ");
	            String text = sc.nextLine();

	            fw.write(text);
	            fw.write("\n");

	            fw.close();

	            System.out.println("added");

	        } catch (Exception e) {
	            System.out.println(e);
	        }

	        sc.close();

	}

}
