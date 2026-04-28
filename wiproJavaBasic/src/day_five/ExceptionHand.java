package day_five;

public class ExceptionHand {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
//		try {
//            String str = null;
//            
//            System.out.println( str.length()); 
//
//            int div = 10 / 0;
//
//        } catch (NullPointerException e) {
//            System.out.println("null pointer ");
//        } catch (ArithmeticException e) {
//            System.out.println("arth ex");
//        }

		try {
            String str = null;
            
            System.out.println( str.length()); 

            int div = 10 / 0;

        } catch (ArithmeticException e) {
            System.out.println("arth ex");
        }
		catch (Exception e) {
            System.out.println("general ex ");
        }finally {
        	System.out.println("HI")
        }
	}

}
