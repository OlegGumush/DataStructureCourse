package Elizabet_lesson_6;




public class TestCostomer {

	public static void main(String[] args) {
		Customer c1 = new Customer("Dani", 1);
		Customer.Account a1 = c1.new Account(20000, 100); 
		Customer.Account a2 = c1.new Account(10000, 200);
		Customer.Account a3 = c1.new Account(1000, 300);
		System.out.println(c1);
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);
		Customer.Account ay = new Customer("Yael", 2).new Account(50000,1000);
		System.out.println(ay);
		System.out.println("balance of Yael="+ay.getBalance());
	}

}
