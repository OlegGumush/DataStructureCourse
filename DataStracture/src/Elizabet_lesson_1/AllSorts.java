package Elizabet_lesson_1;

import java.util.Arrays;

//all sorts n^2 + main 

public class AllSorts {
	public static void main(String[] args) {
		int size = 100000;
		System.out.println("size = "+size);
		int [] array = MyLibrary.getArray(size);
		int[]a = Arrays.copyOf(array, size);
		long  timeBefore,timeAfter;
		double elapse;
	// java sort
		timeBefore = System.currentTimeMillis();
		Arrays.sort(array);
		timeAfter = System.currentTimeMillis();
		elapse = (timeAfter-timeBefore)/1000.0;
		System.out.println("Java Sort time = " + elapse+" seconds, is sorted? "+isSorted(array)); 
	// bubble sort
		array = Arrays.copyOf(a, size);
		bubbleSort(array);
		timeAfter = System.currentTimeMillis();
		elapse = (timeAfter-timeBefore)/1000.0;
		System.out.println("bubbleSort time = " + elapse+" seconds, is sorted? "+isSorted(array));		
	// bubble sort recursive
		array = Arrays.copyOf(a, size);
		bubbleSort(array);
		timeAfter = System.currentTimeMillis();
		elapse = (timeAfter-timeBefore)/1000.0;
		System.out.println("bubbleSort recursive time = " + elapse+" seconds, is sorted? "+isSorted(array));		
	//  selection sort
		array = Arrays.copyOf(a, size);
		timeBefore = System.currentTimeMillis();
		selectionSort(array);
		timeAfter = System.currentTimeMillis();;
		elapse = (timeAfter-timeBefore)/1000.0;
		System.out.println("selectionSort time = " + elapse+" seconds, is sorted? "+isSorted(array));		

	// insertion sort
		array = Arrays.copyOf(a, size);
		timeBefore = System.currentTimeMillis();
		insertionSort1(array);
		timeAfter = System.currentTimeMillis();;
		elapse = (timeAfter-timeBefore)/1000.0;
		System.out.println("insertionSort time = " + elapse+" seconds, is sorted? "+isSorted(array));		

	// insertion sort2
		array = Arrays.copyOf(a, size);
		timeBefore = System.currentTimeMillis();
		insertionSort2(array);
		timeAfter = System.currentTimeMillis();;
		elapse = (timeAfter-timeBefore)/1000.0;
		System.out.println("insertionSort2 time = " + elapse+" seconds, is sorted? "+isSorted(array));		
		//
		/**
		size = 100000
		Java Sort time = 0.019 seconds, is sorted? true
		bubbleSort time = 28.958 seconds, is sorted? true
		bubbleSort recursive time = 57.858 seconds, is sorted? true
		selectionSort time = 9.395 seconds, is sorted? true
		insertionSort time = 11.122 seconds, is sorted? true
		insertionSort2 time = 6.198 seconds, is sorted? true
		 **/
	}
	public static void bubbleSort(int[] arr){
		boolean flag = true;
		for (int i=0; flag && i <arr.length; i++){
			flag = false;
			for (int j=0; j < arr.length-1-i; j++){
				if(arr[j] > arr[j+1]){
					swap(arr, j, j+1);
					flag = true;
				}
			}
		}		
	}
	public static void recursiveBubbleSort(int[] arr, int n) {
        if (n == 0) {
            return; //finished sorting
        }
        
        for (int i = 0; i < n; i++) {
            if (arr[i+1] < arr[i]) {
                swap(arr, i, i+1);
            }
        }
        recursiveBubbleSort(arr, n-1);
    }
	
	public static void insertionSort1(int[] arr){
		for (int i=1; i <arr.length; i++){
			int j = i;
			while (j>0 && arr[j]<arr[j-1]){
				swap(arr, j, j-1);
				j = j-1;
			}			
		}		
	}
	public static void insertionSort2(int[] array){
	    for (int i = 1; i < array.length; i++){
	        int j = i;
	        int B = array[i];
	        while ((j > 0) && (array[j-1] > B)){
	            array[j] = array[j-1];
	            j--;
	        }
	        array[j] = B;
	    }
	}
	public static void selectionSort1(int[] arr){
		int i, j, smallestIndex;
		for (i=0; i<arr.length; i++)
		{
			smallestIndex = i;
			for (j=i+1; j<arr.length; j++)
			{
				if (arr[smallestIndex] > arr[j])
					smallestIndex = j;
			}
			int temp = arr[smallestIndex];
			arr[smallestIndex] = arr[i];
			arr[i] = temp;
		}
	}


	public static int arrayMinIndex(int from, int arr[]){
		//	 find the index of array's smalest number – begin with from number
		int index=from;
		for (int i=from;i<arr.length; i++){
			if (arr[i] < arr[index])
				index = i;
		}
		return index;
	}
	public static void selectionSort(int[] arr){
		int i, smallestIndex;
		for (i=0; i<arr.length; i++){
			smallestIndex = arrayMinIndex(i, arr);
			swap(arr, i, smallestIndex);
		}
	}
	
	//Swap
	public static void swap(int [] array, int i, int j){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	public static boolean isSorted(int[] arr){
		boolean ans = true;
		for (int i = 0; ans && i < arr.length-1; i++) {
			if (arr[i] > arr[i+1]) ans = false;
		}
		return ans;
	}
}
