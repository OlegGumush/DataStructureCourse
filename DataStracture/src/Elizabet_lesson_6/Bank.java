package Elizabet_lesson_6;


public class Bank {

	public static void main(String[] args) {
		Customer c1 = new Customer("Dani", 1);
		Customer.Account a1 = c1.new Account(100, 20000); 
		Customer.Account a2 = c1.new Account(101, 100000); 
		Customer.Account a3 = c1.new Account(102, 1000); 
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);
		///
		Customer.Account yaelAccount = new Customer("Yael", 22).new Account(200, 555555); 
		System.out.println(yaelAccount);
	}

}
