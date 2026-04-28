package bank.ques;


abstract class Bank{
	 abstract double getInterestRate();
}

class BOI extends Bank {
    double getInterestRate() {
        return 8.90;
    }
}

class BOA extends Bank {
    double getInterestRate() {
        return 8.0;
    }
}

public class MainBankClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BOI b1= new BOI();
		BOA b2= new BOA();
		
		
		System.out.println("BOI: "+b1.getInterestRate());
		System.out.println("BOA: "+b2.getInterestRate());
		
	}

}
