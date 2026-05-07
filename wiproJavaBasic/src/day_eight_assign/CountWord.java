package day_eight_assign;
import java.io.*;

public class CountWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		   int ln = 0;
	        int wrd = 0;
	        int charac = 0;

	        try {
	        	   File fl = new File("data.txt");
	            FileReader fr = new FileReader("data.txt");
	            BufferedReader br = new BufferedReader(fr);

	            String line;

	            while ((line = br.readLine()) != null) {
	            	ln++;

	            	charac += line.length();

	                String[] wordArr = line.split("\\s+");

	                wrd += wordArr.length;
	            }

	            br.close();

	            System.out.println("No lines: " + ln);
	            System.out.println("No of words: " + wrd);
	            System.out.println("No of char: " + charac);

	        } catch (Exception e) {
	            System.out.println(e);
	        }

	}

}
