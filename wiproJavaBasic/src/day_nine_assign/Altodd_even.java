package day_nine_assign;

class AltOddEven {
     int num = 1;


    public synchronized void odd() {
        while (num <= 100) {
            if (num % 2 == 0) {
                try { wait(); } catch (InterruptedException e) {}
            } else {
                System.out.println("odd:" + num++);
                notify();            }
        }
    }

    public synchronized void even() {
        while (num <= 100) {
            if (num % 2 != 0) {
                try { wait(); } catch (InterruptedException e) {}
            } else {
                System.out.println("even:" + num++);
                notify();
            }
        }
    }
}

public class Altodd_even {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AltOddEven obj = new AltOddEven();

        Thread t1 = new Thread(() -> obj.odd());
        Thread t2 = new Thread(() -> obj.even());

        t1.start();
        t2.start();
		
		

	}

}
