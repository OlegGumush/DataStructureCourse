package DataStructureGil;

import java.util.ArrayList;

public class Recursion {
	/**
	 * Q1 - return the n'th element in fibo series
	 * Complexity: O(2^n)
	 */
	public static int fiboAt(int n) {
		if(n == 1 || n == 2) return 1;
		return fiboAt(n-1) + fiboAt(n-2);
	}
	
	/**
	 * Q2 - a^b
	 * Complexity: O(b)
	 */
	public static int powAB(int a,int b) {
		if(b == 0) return 1;
		return a*powAB(a,b-1);
	}
	
	/**
	 * Q3 - How many times character appears in a string 
	 * Complexity: O(n) - n = str length
	 */
	public static int charInString(char c,String str) {
		int len = str.length();
		if(len == 0) return 0;
		if(str.charAt(0) == c) return 1 + charInString(c,str.substring(1));
		return charInString(c,str.substring(1));
	}
	
	/**
	 * Q4 - Returns the sum of the array
	 * Complexity: O(n)
	 */
	public static int sumArr(int[] a) {
		return sumArr(a,0);
	}
	
	private static int sumArr(int[] a, int i) {
		if(i == a.length-1) return a[i];
		return a[i] + sumArr(a,i+1);
	}

	/**
	 * Q5 - Checks if the array is palindrom
	 * Complexity: O(n)
	 */
	public static boolean isPalindrom(int[] a) {
		return isPalindrom(a,0);
	}
	
	private static boolean isPalindrom(int[] a, int i) {
		if(i == a.length/2) return true;
		return a[i] == a[a.length-1-i] && isPalindrom(a,i+1);
	}

	/**
	 * Q6 - Split the array a to 2 lists - positive numbers and negative numbers
	 * Complexity: O(n)
	 */
	public static ArrayList<Integer>[] splitArrPosAndNeg(int[] a) {
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] ans = new ArrayList[2];
		ans[0] = new ArrayList<Integer>();
		ans[1] = new ArrayList<Integer>();
		splitArrPosAndNeg(a,0,ans[0],ans[1]);
		return ans;
	}
	
	private static void splitArrPosAndNeg(int[] a, int i, ArrayList<Integer> arrPos, ArrayList<Integer> arrNeg) {
		if(i == a.length) return;
		if(a[i]>0)arrPos.add(a[i]);
		else if(a[i]<0)arrNeg.add(a[i]);
		splitArrPosAndNeg(a,i+1,arrPos,arrNeg);
	}

	/**
	 * Q7 - Returns the difference between two halves of the array
	 * Complexity: O(n)
	 */
	public static int diffBetweenHalves(int[] a) {
		return diffBetweenHalves(a,0,a.length-1);
	}
	
	private static int diffBetweenHalves(int[] a, int s, int e) {
		if(s >= e) return 0;
		return a[s] - a[e] + diffBetweenHalves(a,s+1,e-1);
	}

	/**
	 * Q8 - Is there the same element in the arrays a and b
	 * Complexity: O(n+m)
	 */
	public static boolean isSameElement(int[] a,int[] b) {
		return isSameElement(a,0,b,0);
	}
	
	private static boolean isSameElement(int[] a, int i, int[] b, int j) {
		if(i == a.length || j == b.length) return false;
		if(a[i] == b[j]) return true;
		if(a[i] < b[j]) return isSameElement(a,i+1,b,j);
		return isSameElement(a,i,b,j+1);
	}

	/**
	 * Q9 - Is subset with the sum s
	 * Complexity: O(2^n)
	 */
	public static boolean isSubsetWithSum(int[] a,int s) {
		return isSubsetWithSum(a,0,s);
	}
	
	private static boolean isSubsetWithSum(int[] a, int i, int s) {
		if(s == 0) return true;
		if(i == a.length-1) {
			if(a[i] == s) return true;
			else return false;
		}
		return isSubsetWithSum(a,i+1,s) || isSubsetWithSum(a,i+1,s-a[i]);
	}
}