package Elizabet_lesson_4;

import java.util.Arrays;

public class MergeSortFirst
{
	
	public static void mergeSort(int arr[]){
		mergeSort(arr, 0, arr.length);
	}
	private static void mergeSort(int arr[], int low, int high){
		// sort a[low, high)
		int n = high - low;
		
		if (n <= 1)
			return;
		int mid = (low + high)/2;
		
		mergeSort(arr, low, mid);
		mergeSort(arr, mid, high);
		
		int [] temp = new int[n];
		int i = low, j = mid, k=0;
		
		// merge two arrays: arr[low, mid), arr[mid, high)
		while(i<mid && j<high)
		{
			if (arr[j] < arr[i])
				temp[k++] = arr[j++];
			else  temp[k++] = arr[i++];
		}
		while (i<mid) 
			temp[k++] = arr[i++];
		while (j<high)
			temp[k++] = arr[j++];

		for(int p=0; p<n; p++) 
			arr[low + p] = temp[p];
	}
	private static boolean isSorted(int[] a) {
		for (int i = 1; i < a.length; i++)
			if (a[i] < a[i-1]) return false;
		return true;
	}
	public static void main(String[] args) {
		int[]arr = {11,2,6,4};
 		mergeSort(arr);
		System.out.println(Arrays.toString(arr));
	}

}
