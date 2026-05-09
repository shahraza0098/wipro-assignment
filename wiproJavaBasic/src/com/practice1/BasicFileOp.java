package com.practice1;

import java.io.*;

public class BasicFileOp {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		try {
			File myFile=new File("first.txt");
			

            if(myFile.createNewFile()) {
                System.out.println("File created");
            }
            else {
                System.out.println("File already exists");
            }
			
            FileWriter f1=new FileWriter(myFile);
            f1.write("Hello there!");
            f1.close();

            System.out.println("Data written");
		}catch(Exception e) {
		System.out.println(e);
		}
	}

}
