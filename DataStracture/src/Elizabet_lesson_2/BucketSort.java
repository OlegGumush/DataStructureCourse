package Elizabet_lesson_2;

import java.util.Arrays;


public class BucketSort {
	
	public static void BucketSort(int[] arr){
		int min = arr[0], max = arr[0];
                
		for (int i = 1; i < arr.length; i++) 
		{
			if (arr[i]>max) 
				max = arr[i];
			if (arr[i]<min)
				min = arr[i];
		}
		int freq[] = new int[max-min+1];
		for (int i = 0; i < arr.length; i++) {
			freq[arr[i]-min]++;	
		}
		int j = 0;
		for (int k=0; k<freq.length; k++)
		{
			for (int i=0; i<freq[k]; i++){
				arr[j++] = k+min;
			}
		}
	}
	public static void main(String[] args) {
		int size = 20;
		int arr[]={1,32,4,3,2,1,2,3,4,1,2,76,76,7,6,76};
		
		BucketSort(arr);
		System.out.println(Arrays.toString(arr));
	}

}
