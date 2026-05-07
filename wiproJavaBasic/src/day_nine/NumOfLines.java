package day_nine;
import java.io.*;
public class NumOfLines {

	public static void main(String[] args) throws Exception  {
		// TODO Auto-generated method stub

		
		  BufferedReader br = new BufferedReader(new FileReader("test.txt"));
	        int count = 0;

	        while (br.readLine() != null) {
	            count++;
	        }

	        br.close();
	        System.out.println("num of lines:" + count);
	}

}
