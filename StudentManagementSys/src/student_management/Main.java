package student_management;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		 Scanner sc = new Scanner(System.in);

	        while (true) {

	            System.out.println("\n**********Student Management System **********");

	            System.out.println("1. Add Student");
	            System.out.println("2. View Students");
	            System.out.println("3. Search Student");
	            System.out.println("4. Update Student");
	            System.out.println("5. Delete Student");
	            System.out.println("6. Exit");

	            System.out.print("Choose Option: ");

	            int choice = sc.nextInt();

	            switch (choice) {

	                case 1:
	                    StudentService.addStudent(sc);
	                    break;

	                case 2:
	                    StudentService.viewStudents();
	                    break;

	                case 3:
	                    StudentService.searchStudent(sc);
	                    break;

	                case 4:
	                    StudentService.updateStudent(sc);
	                    break;

	                case 5:
	                    StudentService.deleteStudent(sc);
	                    break;

	                case 6:
	                    System.out.println("Exiting");
	                    return;

	                default:
	                    System.out.println("Invalid Choice");
	            }
	        }
	}

}
