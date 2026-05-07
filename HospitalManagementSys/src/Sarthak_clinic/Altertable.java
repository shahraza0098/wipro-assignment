package Sarthak_clinic;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class Altertable {
	public static void main(String[] args)  {
		String url="jdbc:mysql://localhost:3306/mydata";
		String user="root";
		String password="root";
		
		// create table
		String addcol="alter table students \r\n"
				+ "add address varchar(50)";
		// insert record
		
		String update101="update students \r\n"
				+ "set address=\"Pune\"\r\n"
				+ "where rollno=101";
		String update102="update students \r\n"
				+ "set address=\"Mumbai\"\r\n"
				+ "where rollno=102;";
		String update103="update students \r\n"
				+ "set address=\"Chennai\"\r\n"
				+ "where rollno=103;";
		
		try
		{
			// driver connection
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,user,password);
			System.out.println("Connection created");
			// create statement for query execution
			Statement stmt=con.createStatement();
			// call create query using statement
		//	stmt.executeUpdate(addcol);
			//System.out.println("new coloumn added");
			// call insert query using statement
			int rowInserted=stmt.executeUpdate(update101);
			int rowInserted1=stmt.executeUpdate(update102);
			int rowInserted2=stmt.executeUpdate(update103);
			if(rowInserted>0)
			{
				System.out.println("new Student record inserted ");
			}
			
			//Print table
			ResultSet rs=stmt.executeQuery("Select * from students");
			System.out.println("rollno\t name\t Per\t Email\t address");
			// while loop for fetching all the table records
			while(rs.next())
			{
				int rollno=rs.getInt("rollno");
				String name=rs.getString("name");
				int per=rs.getInt("per");
				String email=rs.getString("email");
				String address=rs.getString("address");
				System.out.println(rollno+" "+ name+" "+ per+" "+ email+"  "+address);
				//System.out.println("rollno:"+rollno+"\tName:"+ name+"Percentage:"+ per+"Email:"+ email);
			}
			
			stmt.close();
			con.close();
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e);
		}
		
		
 
	}
 
}// add new column students table
// update records for that column
// print table
 
 