package Elizabet_lesson_9;

public class TestHashCode 
{
	public static int myHashCode1(int k, int m){
		double a = (Math.sqrt(5) - 1)/2;
		double u = m*((k*a) % 1);
		return (int)u;
	}
	public static int myHashCode2(int k, int m){
		double a = 0.81;
		double u = m*((k*a) % 1);
		return (int)u;
	}
	public static void main(String[] args) {
		double a = 2.345;
		int x = 3;
		System.out.println("a%1 = "+a%1);
		System.out.println("x%1 = "+x%1);
		System.out.println("hash code 1: " + myHashCode1(123456,10000));
		System.out.println("hash code 2: " + myHashCode2(7,10));
		System.out.println();
		for(char c='a'; c<='z'; c++){
			String s = "" + c;
			System.out.print(s.hashCode() + ", ");
		}
		System.out.println();
		for(Integer  i=0; i<=20; i++){
			System.out.print(i.hashCode() + ", ");
		}
		System.out.println();
		Double d = 3.14159; 
		System.out.println(d.hashCode());
		String s = "hello world";
		System.out.println(s.hashCode());
	}
}
