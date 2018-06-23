package Elizabet_lesson_5;

import java.util.Arrays;


public class QuickSortInduction {

	public static void quickSort(int[] arr){
		quickSort(arr, 0,arr.length-1);
	}
	public static void quickSort(int[] arr, int low, int high)
	{
		int piv = arr[(high+low)/2];
		int i = low;
		int j = high;
		while (i<=j){
			while(arr[i]<piv)
				i++;
			while(arr[j]>piv)
				j--;
			if (j>=i) 
				swap(arr, i++, j--);
		}
		if (i<high) 
			quickSort(arr, i, high);
		if (j>low)
			quickSort(arr, low, j);
	}
	//Swap
	public static void swap(int [] array, int i, int j){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	private static boolean isSorted(int[] a) {
		for (int i = 1; i < a.length; i++)
			if (a[i] < a[i-1]) return false;
		return true;
	}
	public static void reverse(int[]arr){
		for (int i=0; i<arr.length/2; i++){
			swap(arr, i, arr.length-i-1);
		}
	}
	public static void main(String[] args) {
		int size = 10000;
		System.out.println("size = "+size);
		int [] a = MyLibrary.randomIntegerArray(size);
		//System.out.println(Arrays.toString(a));
		int[]b = Arrays.copyOf(a, size);
		long  timeBefore,timeAfter;
		double elapse;
// java sort
		timeBefore = System.currentTimeMillis();
		Arrays.sort(a);
		timeAfter = System.currentTimeMillis();
		elapse = (timeAfter-timeBefore)/1000.0;
		System.out.println("Java Sort time = " + elapse+" seconds, is sorted? "+isSorted(a));
/// quick sort 
		timeBefore = System.currentTimeMillis();
		quickSort(b);
		timeAfter = System.currentTimeMillis();
		elapse = (timeAfter-timeBefore)/1000.0;
		System.out.println("Quick Sort time = " + elapse+" seconds, is sorted? "+isSorted(b));
		//System.out.println(Arrays.toString(b));
/// quick sort (sorted array)
		//reverse(b);
		timeBefore = System.currentTimeMillis();
		quickSort(b);
		timeAfter = System.currentTimeMillis();
		elapse = (timeAfter-timeBefore)/1000.0;
		System.out.println("Quick Sort time (sorted array) = " + elapse+" seconds, is sorted? "+isSorted(b));
		System.out.println(Arrays.toString(b));

	}

}
