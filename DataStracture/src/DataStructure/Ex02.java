package DataStructure;

public class Ex02 {
	/**
	 * Q1 - a) sum of 2 numbers a+b
	 * 		b) substruct 2 numbers a-b
	 * 		c) multiply 2 numbers a*b
	 * 		d) division 2 numbers a/b
	 * 		e) remainder a%b 
	 * Complexity: O(b)
	 */
	public static int sum(int a,int b) {
		if(b==0) return a;
		return sum(a,b-1) + 1; 
	}
	public static int substruct(int a,int b) {
		if(b==0) return a;
		return substruct(a,b-1) - 1; 
	}
	public static int multiply(int a,int b) {
		if(b==0) return 0;
		if(b==1) return a;
		return multiply(a,b-1) + a; 
	}
	public static int division(int a,int b) {
		if(a<b) return 0;
		return division(a-b,b) + 1; 
	}
	public static int remainder(int a,int b) {
		if(a<b) return a;
		return remainder(a-b,b); 
	}
	
	/**
	 * Q2 - calculate 2^n
	 * Complexity: O(2^n)
	 */
	public static int exp(int n){
		if(n==0) return 1;
		return exp(n-1)+exp(n-1);
	}
	
	/**
	 * Q3 - reverse number non recursion
	 * Complexity: O(log n)
	 */
	public static int reverseNumber(int num) {
		int ans = 0;
		while(num != 0) {
			ans = ans*10 + num%10;
			num /= 10;
		}
		return ans;
	}
	
	/**
	 * Q4 - reverse number recursion
	 * Complexity: O(log n)
	 */
	public static int reverseNumberRec(int num) {
		return reverseNumberRec(num,0);
	}
	
	private static int reverseNumberRec(int num, int ans) {
		if(num == 0) return ans;
		ans = ans*10 + num%10;
		return reverseNumberRec(num/10,ans);
	}
	
	/**
	 * Q5 - reverse string recursion
	 * Complexity: O(n) - n = string length
	 */
	public static String reverseString(String str) {
		if(str.length()==0) return "";
		return reverseString(str.substring(1)) + str.charAt(0);
	}
}