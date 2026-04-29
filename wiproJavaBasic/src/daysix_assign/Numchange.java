package daysix_assign;

public class Numchange {
	
	static int changeNum(int a) {
		a=a*10;
		return a;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int x=10;
		System.out.println("Number:"+x);
		x=changeNum(x);
		System.out.println("Number:"+x);
	}

}
