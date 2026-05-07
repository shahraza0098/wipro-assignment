package day_eight_assign;
import java.io.*;
public class BuffReaderUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		 try {
	            BufferedReader br = new BufferedReader( new FileReader("data.txt"));

	            String line;

	            while ((line = br.readLine()) != null) {

	                if (line.contains("Java")) {
	                    System.out.println(line);
	                }
	            }

	            br.close();

	        } catch (Exception e) {
	            System.out.println(e);
	        }

	}

}
