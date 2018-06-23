package DataStructure;

import java.util.Arrays;

public class Ex11 {
	/**
	 * Q1 - Max Heap for 12,19,10,4,23,7,45,8,15
	 */
	/**
	 * MaxHeap - [45, 23, 12, 15, 19, 7, 10, 8, 4]
	 */
	
	/**
	 * Q2 - Min Heap for 12,19,10,4,23,7,45,8,15
	 */
	/**
	 * MinHeap - [4, 8, 7, 12, 23, 10, 45, 19, 15]
	 */
	
	/**
	 * Q3 - 
	 */
	/**
	 * a) size/2 + size%2
	 * b) size/2
	 * c) no, just the first element is the max/min
	 */
	
	static class MaxHeap {
		final int negativeInfinity = Integer.MIN_VALUE;
		private int[] data;
		private int size;
		
		public MaxHeap(int[] arr) {
			size = arr.length;
			data = new int[size];
			for (int i = 0; i < arr.length; i++) {
				data[i] = arr[i];
			}
			buildMaxHeap();
		}

		private void buildMaxHeap() {
			for (int i = size/2; i >= 0; i--) {
				maxHeapify(i, size);
			}
		}
		
		private void maxHeapify(int v , int h_size) {
			int max;
			int left = leftChild(v);
			int right = rightChild(v);
			if(left < h_size && data[left]>data[v]) max = left;
			else max = v;
			if(right < h_size && data[right]>data[max]) max = right;
			if(max != v) {
				exchange(v, max);
				maxHeapify(max , h_size);
			}
		}
		
		private void exchange(int i, int j) {
			int temp = data[i];
			data[i] = data[j];
			data[j] = temp;
			
		}

		public void heapInsert(int key) {
			resize(1);
			data[size-1] = negativeInfinity;
			heapIncreaseKey(size-1,key);
		}
		
		private void resize(int amount) {
			int[] temp = new int[size+amount];
			for (int i = 0; i < size; i++) {
				temp[i] = data[i];
			}
			data = temp;
			size+=amount;
		}

		private void heapIncreaseKey(int i, int key) {
			if(key >= data[i]) {
				data[i] = key;
				while(i>0 && data[i]>data[parent(i)]) {
					exchange(i,parent(i));
					i = parent(i);
				}
			}
		}

		public int heapExtractMax() {
			int max = negativeInfinity;
			if(size>0) {
				max = data[0];
				data[0] = data[size-1];
				size--;
				maxHeapify(0, size);
			}
			return max;
		}

		public void heapSort() {
			int h_size = size;
			for (int i = h_size-1; i >= 0; i--) {
				exchange(0,i);
				h_size--;
				maxHeapify(0, h_size);
			}
		}
		@Override
		public String toString() {return Arrays.toString(data);}
		public int heapMaximum() {return data[0];}
		public boolean isEmpty() {return size == 0;}
		private int parent(int i) {return (i-1)/2;}
		private int leftChild(int p) {return p*2 + 1;}
		private int rightChild(int p) {return p*2 + 2;}
		
		/**
		 * Q4 - find value in heap and change it to new value (MaxHeap)
		 * Complexity: O(n) (n - number of items that higher than old_val)
		 */
		public void increaseValue(int old_val, int new_val) {
			int index = find(old_val,0);
			if(index!=-1) {
				heapIncreaseKey(index,new_val);
			}
		}

		private int find(int val,int index) {
			if(index>=data.length) return -1;
			if(val>data[index]) return -1;
			if(val==data[index]) return index;
			int i = find(val,leftChild(index));
			if(i != -1)return i;
			i = find(val,rightChild(index));
			return i;
		}
		
		/**
		 * Q5 - print all numbers from heap that higher than k
		 * Complexity: O(n) (n = number of items that higher than k)
		 */
		public void printHigherThan(int k) {
			printHigherThan(k,0);
		}

		private void printHigherThan(int k, int i) {
			if(i>=data.length) return;
			if(data[i]<=k) return;
			System.out.print(data[i] + " ");
			printHigherThan(k,leftChild(i));
			printHigherThan(k,rightChild(i));
		}
	}
	
	/**
	 * Q6 - Check weather given array is a max heap
	 * Complexity: O(n)
	 */
	public static boolean isMaxHeap(int[] arr) {
		return isMaxHeap(arr,0);
	}
	
	private static boolean isMaxHeap(int[] arr, int i) {
		int n = arr.length;
		if(i>=n) return true;
		return (i*2+1>=n ||arr[i]>arr[i*2+1]) && (i*2+2>=n || arr[i]>arr[i*2+2]) && isMaxHeap(arr,i*2+1) && isMaxHeap(arr,i*2+2);
	}
}