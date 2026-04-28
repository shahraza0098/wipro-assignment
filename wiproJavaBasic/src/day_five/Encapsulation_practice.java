package day_five;

class BankBalance{
	private double balance;
	
	public double deposit(double amount) {
		if(amount>0) {
			balance= (amount+balance);
		}else {
			System.out.println("Invalid amount");
		}
		return balance;
	}
	
	public double withdraw(int amount) {
		
		if(balance<0) {
			System.out.println("Insufficient fund");
		}
		
		balance =balance-amount;
		
		return balance;
	}
	
	
	public double getBalance() {
		return balance;
	}
}

public class Encapsulation_practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		

	}

}
