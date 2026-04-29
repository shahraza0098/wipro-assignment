package daysix_assign;

class Box{
	int length;
}

public class PlayBox {
	
	
	 static void change(Box b) {
	        b.length = 20;
	        System.out.println("changed value: " + b.length);
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		  Box b = new Box();
	        b.length = 10;

	        System.out.println("before " + b.length);
	        change(b);
	        System.out.println("after: " + b.length);

	}

}
