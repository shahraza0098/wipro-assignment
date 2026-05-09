package day_twelve;

import java.sql.*;
import java.util.*;

public class LoginService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try(Connection con = DBConnection.getConnection()) {
			
			Scanner sc=new Scanner(System.in);

            System.out.print("Enter Username: ");
            String username = sc.nextLine();

            System.out.print("Enter Password: ");
            String password = sc.nextLine();

            String query = "SELECT * FROM user1 WHERE username=? AND password=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                System.out.println("Login Successful");
                System.out.println("Welcome " + rs.getString("name"));
            } else {
                System.out.println("Invalid Username or Password");
            }

            con.close();
			
		}catch(Exception e){
			   e.printStackTrace();
		}

	}

}
