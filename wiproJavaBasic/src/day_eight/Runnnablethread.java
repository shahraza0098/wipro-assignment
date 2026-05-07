package day_eight;


p 

    
    
public class Runnnablethread implements Runnable {
	
	public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(Thread.currentThread().getName() + " = " + i);
            // Thread.yield();
        }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Runnnablethread t0 = new Runnnablethread();
        t0.run();

        Runnnablethread t1 = new Runnnablethread();
        t1.run();

        System.out.println(t0.equals(t1));

	}

}
