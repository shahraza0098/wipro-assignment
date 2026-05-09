package day_twelve;
import java.util.*;

import java.sql.*;
public class InsertMany {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		   Scanner sc = new Scanner(System.in);

	        try {

	            Connection con = DBConnection.getConnection();

	            String query = "INSERT INTO user1(name,  age,city,  username, password) VALUES(?,?,?,?,?)";

	            PreparedStatement ps = con.prepareStatement(query);

	            System.out.print("enter number of record you want to enter: ");
	            int n = sc.nextInt();
	            sc.nextLine();

	            for(int i = 1; i <= n; i++) {

	                System.out.println("\nEnter Details of Student " + i);

	                System.out.print("name: ");
	                String name = sc.nextLine();
	                
	                System.out.print("age: ");
	                int age = sc.nextInt();
	                sc.nextLine();

	                System.out.print(" city: ");
	                String city = sc.nextLine();

	               

	                System.out.print(" username: ");
	                String username = sc.nextLine();

	                System.out.print("Password:");
	                String password = sc.nextLine();

	                ps.setString(1, name);
	                ps.setInt(2, age);
	                ps.setString(3, city);
	               
	                ps.setString(4, username);
	                ps.setString(5, password);

	                ps.executeUpdate();
	            }

	            System.out.println("\n Inserted Successfully");

	            con.close();

	        } catch(Exception e) {
	            e.printStackTrace();
	        }

	        sc.close();
	}

}
