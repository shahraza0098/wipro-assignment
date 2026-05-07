package day_nine_assign;
class BankAccount {
     int bal = 1000;

    public synchronized void deposit(int amt) {
    	bal += amt;
        System.out.println(Thread.currentThread().getName() +
                " dep: " + amt + " bal: " + bal);
    }

    public synchronized void withdraw(int amount) {
        if (bal >= amount) {
        	bal -= amount;
            System.out.println(Thread.currentThread().getName() +
                    " withdrawn: " + amount + " bal: " + bal);
        } else {
            System.out.println(Thread.currentThread().getName() +
                    "  no fund");
        }
    }
}
public class BankSys {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 BankAccount account = new BankAccount();

	        Runnable task = () -> {
	            account.deposit(500);
	            account.withdraw(700);
	        };

	        Thread t1 = new Thread(task, "User1");
	        Thread t2 = new Thread(task, "User2");

	        t1.start();
	        t2.start();

	}

}
