package Elizabet_lesson_2;

import java.util.Arrays;


public class RadixSort {//for numbers

	public static void countingSort(int[] a) {//O(n+k)
		/** find max and min values **/
		int N = a.length;
		int max = a[0], min = a[0];
		for (int i = 1; i < N; i++){
			if (a[i] > max) max = a[i];
			if (a[i] < min)  min = a[i];
		}
		int range = max - min + 1;
		/** make count/frequency array for each element **/
		int count[] = new int[range];
		for (int i = 0; i < a.length; i++)
			count[a[i] - min]++;
		/** modify count so that positions in final array is obtained **/
		for (int i = 1; i < range; i++)
			count[i] = count[i] + count[i-1];
		
		/** modify original array **/
		for (int i = 0, j = 0; i < range; i++){
			while (j < count[i]) a[j++] = i + min;
		}
	}

	public static void radixSort( int[] a){//O(n)+O(n*log(k))=O(n*log(k))
		int i, max = a[0], exp = 1, n = a.length;
		int base = 10;
		int[] temp = new int[n];
		for (i = 1; i < n; i++){
			if (a[i] > max) max = a[i];
		}
		while (max/exp > 0){
			int[] bucket = new int[base];
			for (i = 0; i < n; i++){
				int index = (a[i] / exp) % base;
				bucket[index]++;
			}
			for (i = 1; i < base; i++){
				bucket[i] = bucket[i] + bucket[i - 1];
			}
			for (i = n - 1; i >= 0; i--){
				//temp[--bucket[(a[i] / exp) % base]] = a[i];
				int ind1 = (a[i] / exp) % base;
				int ind2 = --bucket[ind1];
				temp[ind2] = a[i];
			}
			for (i = 0; i < n; i++)
				a[i] = temp[i];
			exp = exp * base;        
		}
	}     
	public static void main(String[] args) {
		int[]a = {493, 812, 715 ,212};
		radixSort(a);
		System.out.println(Arrays.toString(a));
		int[]a1 = {877, 567, 3456, 876, 467, 26, 934, 9876, 1, 4567};
		radixSort(a1);
		System.out.println(Arrays.toString(a1));
		//////////
		int[]a2 = {877, 567, 3456, 876, 467, 26, 934, 9876, 1, 4567};
		countingSort(a2);
		System.out.println(Arrays.toString(a2));
		int[]a3 = {1,6,4,1,3,6,5,8,6,9,12};
		radixSort(a3);
		System.out.println(Arrays.toString(a3));

	}

}
