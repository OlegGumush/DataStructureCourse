package Elizabet_lesson_3;


import java.util.Arrays;
public class BinarySearch {
	public static void main(String[] args) {
		int size = 10000000;
		int []arr = MyLibrary.randomIntArrayOfDiffNumbers(size);
		//System.out.println(Arrays.toString(arr));
		long  timeBefore,timeAfter;
		double elapse;
		// JAVA sort
		timeBefore = System.currentTimeMillis();
		Arrays.sort(arr);
		int val = (arr[0]+arr[1]);
		timeAfter = System.currentTimeMillis();
		elapse = (timeAfter-timeBefore)/1000.0;
		System.out.println("Java Sort time = " + elapse+" seconds");		
		//MyLibrary.printIntegerArray(arr);
		// JAVA binary search 
		timeBefore = System.currentTimeMillis();
		int index = Arrays.binarySearch(arr, val);
		timeAfter = System.currentTimeMillis();
		elapse = (timeAfter-timeBefore)/1000.0;
		System.out.println("index = " + index + ", Java Search time = " + elapse+" seconds");		
		// Binary search Inductive
		timeBefore = System.currentTimeMillis();
		index = binarySearchInducion(arr, val);
		timeAfter = System.currentTimeMillis();
		elapse = (timeAfter-timeBefore)/1000.0;
		System.out.println("index = " + index + ", Binary search Inductive time = " + elapse+" seconds");		
		// Binary search Recursive
		timeBefore = System.currentTimeMillis();
		index = binarySearchRecursive(arr, val);
		timeAfter = System.currentTimeMillis();
		elapse = (timeAfter-timeBefore)/1000.0;
		System.out.println("index = " + index + ", Binary search Recursive time = " + elapse+" seconds");
		//
	}
	
	///////////////////////////////////////////////////////////////////////////////
	//חיפוש בינארי רגיל 
	public static int binarySearchInducion(int []arr,int value){//O(log2(n))
		if (value<arr[0])
			return -2;
		if (value>arr[arr.length-1])
			return -arr.length-1;
		int low = 0;
		int  high = arr.length-1;
		int middle = (low + high)/2;
		
		while (low <= high){
			middle = (low + high)/2;
			if (arr[middle] == value){//value was found
				return middle;
			}
			// value suppose to be left
			if (value < arr[middle]){
				high = middle-1;
			}
			// value suppose to be right
			else{
				low = middle+1;
			}
		}
		return -1;
	}
	//////////////////////////////////////////////////////////////////////////
	//חיפוש בינארי רקורסיבי
	public static int binarySearchRecursive(int arr[], int value){
		if (value<arr[0]) 
			return -1;
		if (value>arr[arr.length-1])
			return -arr.length-1;
		return binary_search_recurs(arr, 0, arr.length-1,value);
	}
	public static int binary_search_recurs(int arr[],int low,int high,int value){
		if (low <= high){
			int mid = (low+high)/2;
			if (value==arr[mid])   return mid;//value was found
			// value suppose to be on left
			else if (value<arr[mid]) return binary_search_recurs(arr, low, mid-1,value);
			// value suppose to be on right
			else return binary_search_recurs(arr, mid+1, high,value);
		}
		else return -1;
	}
	////////////////////////////////////////////////////////////////////////////

}
