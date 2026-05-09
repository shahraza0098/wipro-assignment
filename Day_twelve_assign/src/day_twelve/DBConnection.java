package day_twelve;

import java.sql.Connection;
import java.sql.DriverManager;
public class DBConnection {

	
		// TODO Auto-generated method stub
		
		static String url = "jdbc:mysql://localhost:3306/day_twelve";
	    static String user = "root";
	    static String password = "Mysql@007";

	    public static Connection getConnection() throws Exception {
	    	Class.forName("com.mysql.cj.jdbc.Driver");
	    	
	    	return DriverManager.getConnection(url, user, password);

	}

}
