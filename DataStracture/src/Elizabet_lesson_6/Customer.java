package Elizabet_lesson_6;


public class Customer {
	private String name;
	private int id;
	
	public Customer(String name, int id){
		this.name = name;
		this.id = id;
	}
	public String toString(){
		return "name = "+this.name+", id = "+id;
	}
	
	public class Account{
		private double balance;
		private int id;
		
		public Account(double balance, int id){
			this.balance = balance;
			this.id = id;
			
		}
		public String toString(){
			String ans="account id="+id+", name="+name + ", customer id="+Customer.this.id+", balance="+this.balance;
			return ans;
		}
		public double getBalance(){
			return balance;
		}
	}
	
	

}
