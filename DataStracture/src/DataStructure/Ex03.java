package DataStructure;

import java.util.Scanner;

public class Ex03 {
	/**
	 * Q1 - Binary Search
	 * Complexity: O(log n)
	 */
	public static int binarySearch(int[] a, int value) {
		if(value < a[0] || value > a[a.length-1]) return -1;
		int low=0,high = a.length-1;
		while(low<=high) {
			int mid = (low+high)/2;
			if(value == a[mid]) return mid;
			if(value < a[mid]) high = mid-1;
			else low = mid+1;
		}
		return -1;
	}
	
	/**
	 * Q2 - Guessing game
	 * Complexity: O(1) - known range
	 */
	public static void guessingGame() {
		int number = (int)(Math.random()*1000+1);
		int high = 1001, low = 1,choose=0;
		Scanner input = new Scanner(System.in);
		do {
			System.out.println("is it the number? "+ number);
			System.out.println("1 - yes");
			System.out.println("2 - smaller than what I printed");
			System.out.println("3 - bigger than what I printed");
			choose = input.nextInt();
			if(choose==2) {
				high = number;
				number = (number+low)/2;
			}
			if(choose==3) {
				low = number;
				number = (number+high)/2;
			}
		} while(choose!=1);
		System.out.println("WIN!");
		input.close();
	}
	
	/**
	 * Q3 - Common Strings in 3 sorted arrays
	 * Complexity: O(n*log n)
	 */
	public static String[] commonStrings(String[] a, String[] b, String[] c) {
		String[] ans;
		int size=0, pos=0;
		for (int i = 0; i < a.length; i++) {
			if(binarySearchString(b,a[i]) && binarySearchString(c,a[i])) size++;
		}
		ans = new String[size];
		for (int i = 0; i < a.length; i++) {
			if(binarySearchString(b,a[i]) && binarySearchString(c,a[i])) ans[pos++] = a[i];
		}
		return ans;
	}

	private static boolean binarySearchString(String[] a, String str) {
		if(str.compareTo(a[0])<0 || str.compareTo(a[a.length-1])>0) return false;
		int low=0,high = a.length-1;
		while(low<=high) {
			int mid = (low+high)/2;
			if(str.compareTo(a[mid])==0) return true;
			if(str.compareTo(a[mid])<0) high = mid-1;
			else low = mid+1;
		}
		return false;
	}
	
	/**
	 * Q4 - Checking whether there are 2 elements in sorted array with sum of 0 
	 * Complexity: O(n)
	 */	
	public static boolean isElementsWithSumZero(int[] a) {
		int s = 0, e = a.length-1;
		while(s<e) {
			int sum = a[s]+a[e];
			if(sum==0) return true;
			else if(sum>0)e--;
			else s++;
		}
		return false;
	}
	
	/**
	 * Q5 - Checking whether there is element more than n/2 times
	 * Complexity: O(n)
	 */	
	public static boolean isMostElement(int[] a) {
		int sum = 1;
		if(a.length==1)
			return true;
		for (int i = 1; i < a.length; i++) {
			if(a[i]==a[i-1]) {
				sum++;
				if(sum>a.length/2)
					return true;
			}
			else {
				sum=1;
				if(i>a.length/2) return false;
			}
		}
		return false;
	}
	
	/**
	 * Q6 - BinarySearchBetween
	 * Complexity: O(log n)
	 */
	public static int binarySearchBetween(int[] a, int value) {
		if(value < a[0]) return 0;
		if(value > a[a.length-1]) return a.length;
		return binarySearchBetween(a,0,a.length-1,value);
	}
	
	private static int binarySearchBetween(int[] a, int low, int high, int value) {
		if(low == high) return low;
		int mid = (low + high)/2;
		if(value == a[mid]) return mid;
		if(value < a[mid]) return binarySearchBetween(a,low,mid,value);
		else return binarySearchBetween(a,mid+1,high,value);
	}
}