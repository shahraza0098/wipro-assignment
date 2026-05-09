package day_twelve;
import java.util.*;

import java.sql.*;
public class DisplayRecords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

        try {

            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM user1";

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(query);

            System.out.println("------------------------------------------------------");
            System.out.println("ID\tName\tCourse\tMarks\tUsername");
            System.out.println("------------------------------------------------------");

            while(rs.next()) {

                System.out.println(
                        rs.getInt("id") + "\t" +
                        rs.getString("name") + "\t" +
                        rs.getInt("age") + "\t" +
                        rs.getString("city") + "\t" +
                        rs.getString("username")
                );
            }

            con.close();

        } catch(Exception e) {
            e.printStackTrace();
        }

	}

}
