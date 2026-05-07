package day_eight_assign;
import java.io.*;
public class WordCnt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		   int count = 0;

	        try {
	            BufferedReader br = new BufferedReader(new FileReader("data.txt"));

	            String line;

	            while ((line = br.readLine()) != null) {

	                String[] wrds = line.split("\\s+");

	                for (String wrd : wrds) {

	                    if (wrd.equals("Java")) {
	                        count++;
	                    }
	                }
	            }

	            br.close();

	            System.out.println("wrd count " + count);

	        } catch (Exception e) {
	            System.out.println(e);
	        }

	}

}
