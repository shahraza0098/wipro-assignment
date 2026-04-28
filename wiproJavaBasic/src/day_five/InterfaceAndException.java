package day_five;

interface StringNull{
	void printLength(String str);
}

class ExceptionEx{
	  public void printLength(String str) {
	        try {
	            int length = str.length();  
	            System.out.println("lenth: " + length);
	        } catch (NullPointerException e) {
	            System.out.println("null pointer exception");
	        }
	    }
}
public class InterfaceAndException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExceptionEx ex=new ExceptionEx();
		ex.printLength(null);
		ex.printLength("HII");

	}

}
