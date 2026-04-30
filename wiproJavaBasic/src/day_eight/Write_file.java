package day_eight;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Write_file {

	public static void main(String[] args) throws IOException  {
		// TODO Auto-generated method stub
		
		   File file = new File("demo.txt"); // create file object
	        file.createNewFile();             // create file

	        FileWriter wr = new FileWriter("demo.txt");

	        wr.write("Let's learn Java Programming\nSelenium Automation\n");
	        // wr.write(""); // optional

	        wr.close();

	        Scanner sc = new Scanner(file);

	        while (sc.hasNextLine()) {
	            System.out.println(sc.nextLine());
	        }

	        sc.close();

	}

}
