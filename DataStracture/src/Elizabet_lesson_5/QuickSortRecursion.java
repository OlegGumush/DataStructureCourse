package Elizabet_lesson_5;
import java.util.Arrays;


public class QuickSortRecursion {
	

	public static void quickSort(int[] array){
		// sort
		quick_sort(array, 0, array.length-1);
	}

	public static void quick_sort(int[] array, int low, int high){
		if (low <= high){
			int pivot = partition(array, low, high);
			quick_sort(array, low, pivot-1);
			quick_sort(array, pivot+1, high);
		}
	}
	private static int partition(int[] array, int low, int high){
		
		int pivot = low;
		low=low+1;
		
		while (low <= high){
			if (array[low] <= array[pivot])
				low++;
			else if (array[high] > array[pivot])
				high--;
			else 
				swap(array, low, high);
		}
		swap(array, high, pivot);
		return high;//pivot = high;
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
	public static void main(String[] args) {
		int size = 10000;
		System.out.println("size = "+size);
		int [] a = MyLibrary.randomIntegerArray(size);
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
/// quick sort sorted array
		timeBefore = System.currentTimeMillis();
		quickSort(b);
		timeAfter = System.currentTimeMillis();
		elapse = (timeAfter-timeBefore)/1000.0;
		System.out.println("Quick Sort (sorted array) time = " + elapse+" seconds, is sorted? "+isSorted(b));

	}
}

 