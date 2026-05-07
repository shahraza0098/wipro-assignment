package day_nine_assign;

class ABCPrinter {
    private int state = 0; // 0=A, 1=B, 2=C

    public synchronized void printA() {
        while (true) {
            while (state != 0) {
                try { wait(); } catch (InterruptedException e) {}
            }
            System.out.print("A ");
            state = 1;
            notifyAll();
        }
    }

    public synchronized void printB() {
        while (true) {
            while (state != 1) {
                try { wait(); } catch (InterruptedException e) {}
            }
            System.out.print("B ");
            state = 2;
            notifyAll();
        }
    }

    public synchronized void printC() {
        while (true) {
            while (state != 2) {
                try { wait(); } catch (InterruptedException e) {}
            }
            System.out.print("C ");
            state = 0;
            notifyAll();
        }
    }
}

public class ABCPrint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		 ABCPrinter obj = new ABCPrinter();

	        new Thread(() -> obj.printA()).start();
	        new Thread(() -> obj.printB()).start();
	        new Thread(() -> obj.printC()).start();

	}

}
