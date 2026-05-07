package student_management;

import java.sql.*;
import java.util.Scanner;

public class StudentService {

    // Add Student
    public static void addStudent(Scanner sc) {

        try (Connection con = DBConnection.getConnection()) {

            System.out.print("Enter Name: ");
            String name = sc.next();

            System.out.print("Enter Course: ");
            String course = sc.next();

            System.out.print("Enter Marks: ");
            double marks = sc.nextDouble();

            String query ="INSERT INTO students(name, course, marks) VALUES(?,?,?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, name);
            ps.setString(2, course);
            ps.setDouble(3, marks);

            int rows = ps.executeUpdate();

            if (rows > 0) {
            	 System.out.println("student added");
            }
               

        } catch (Exception e) {
            System.out.println("failed");
        }
    }

    // view
    public static void viewStudents() {

        try (Connection con = DBConnection.getConnection()) {

            String query = "SELECT * FROM students";

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            System.out.println("\nID\tName\tCourse\tMarks");

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id") + "\t" +
                        rs.getString("name") + "\t" +
                        rs.getString("course") + "\t" +
                        rs.getDouble("marks")
                );
            }

        } catch (Exception e) {
        	 System.out.println("failed");
        }
    }

    // search 
    // search
    public static void searchStudent(Scanner sc) {

        try (Connection con = DBConnection.getConnection()) {

            System.out.println("Search By:");
            System.out.println("1. ID");
            System.out.println("2. Name");
            System.out.println("3. Course");

            int choice = sc.nextInt();

            PreparedStatement ps = null;

            switch (choice) {

                case 1:

                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();

                    String query1 = "SELECT * FROM students WHERE id=?";

                    ps = con.prepareStatement(query1);

                    ps.setInt(1, id);

                    break;

                case 2:

                    System.out.print("enter student name: ");
                    String name = sc.next();

                    String query2 ="SELECT * FROM students WHERE name=?";

                    ps = con.prepareStatement(query2);

                    ps.setString(1, name);

                    break;

                case 3:

                    System.out.print("Enter Course Name: ");
                    String course = sc.next();

                    String query3 ="SELECT * FROM students WHERE course=?";

                    ps = con.prepareStatement(query3);

                    ps.setString(1, course);

                    break;

                default:
                    System.out.println("Invalid Choice");
                    return;
            }

            ResultSet rs = ps.executeQuery();

            boolean found = false;

            System.out.println("\nID\tName\tCourse\tMarks");

            while (rs.next()) {

                found = true;

                System.out.println(
                        rs.getInt("id") + "\t" +
                        rs.getString("name") + "\t" +
                        rs.getString("course") + "\t" +
                        rs.getDouble("marks")
                );
            }

            if (!found) {
                System.out.println("not found");
            }

        } catch (Exception e) {
            System.out.println("failed");
        }
    }

    // Update Student
    public static void updateStudent(Scanner sc) {

        try (Connection con = DBConnection.getConnection()) {

            System.out.print("Enter Student ID: ");
            int id = sc.nextInt();

            System.out.print("Enter New Marks: ");
            double marks = sc.nextDouble();

            String query =
                    "UPDATE students SET marks=? WHERE id=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setDouble(1, marks);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Student Updated");
            else
                System.out.println("Student Not Found");

        } catch (Exception e) {
        	 System.out.println("failed");
        }
    }

    // delete
    public static void deleteStudent(Scanner sc) {

        try (Connection con = DBConnection.getConnection()) {

            System.out.print("Enter Student ID: ");
            int id = sc.nextInt();

            String query =
                    "DELETE FROM students WHERE id=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Student Deleted");
            else
                System.out.println("Student Not Found");

        } catch (Exception e) {
        	 System.out.println("failed");
        }
    }
}