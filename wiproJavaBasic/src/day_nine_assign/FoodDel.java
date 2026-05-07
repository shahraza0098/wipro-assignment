package day_nine_assign;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.*;

class Order implements Runnable {
    private int orderId;

    public Order(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public void run() {
        System.out.println("placing order" + orderId +
                " by " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000); 
        } catch (InterruptedException e) {}
        System.out.println("order del " + orderId);
    }
}

public class FoodDel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 ExecutorService pool = Executors.newFixedThreadPool(3); 
	        for (int i = 1; i <= 10; i++) {
	            pool.execute(new Order(i));
	        }

	        pool.shutdown();

	}

}
