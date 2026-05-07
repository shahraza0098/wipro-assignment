package Sarthak_clinic;
 
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
import java.sql.*;
//import packages
//load & register driver
// establish connection
//create statements
//execute query
//process result
// close connection
public class Jdbc_conn {
 
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
		String url="jdbc:mysql://localhost:3306/mydata";
		String user="root";
		String password="Mysql@007";
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection(url,user,password);
		System.out.println("Connection created");
		//create statement
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("Select * from Emp");
		System.out.println("ID\t name\t Salary");
		while(rs.next())
		{
			int id=rs.getInt("id");
			String name=rs.getString("name");
			int salary=rs.getInt("salary");
			System.out.println(id+" "+ name+" "+ salary);
			//System.out.println("ID:"+id+"\tName:"+ name+"Salary:"+ salary);
		}
		rs.close();
		stmt.close();
		con.close();
		
		
 
	}
 
}
 