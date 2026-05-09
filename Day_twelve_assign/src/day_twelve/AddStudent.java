package day_twelve;
import java.util.*;


import java.sql.*;

public class AddStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try(Connection con = DBConnection.getConnection()) {
			
			Scanner sc=new Scanner(System.in);
			
			
			  String query = "INSERT INTO user1(name, age, city,username, password) VALUES(?,?,?,?,?)";

	            PreparedStatement ps = con.prepareStatement(query);

	            System.out.print("enter name: ");
	            String name = sc.nextLine();

	            System.out.print("age: ");
	            int  age = sc.nextInt();
	            sc.nextLine();

	            System.out.print("city: ");
	            String city = sc.nextLine();
	       
	            
	            System.out.print("enter username: ");
	            String username = sc.nextLine();
	          
	            
	            System.out.print("enter password: ");
	            String password = sc.nextLine();
	        

	        

	            ps.setString(1, name);
	            ps.setInt(2, age);
	            ps.setString(3, city);
	            ps.setString(4, username);

	            ps.setString(5, password);
	            int rows = ps.executeUpdate();

	            if(rows > 0) {
	                System.out.println("Success!");
	            }

	            con.close();

			
		}catch(Exception e){
			   e.printStackTrace();
		}

	}

}
