package DataStructureGil;

public class Sorts {
	/**
	 * Q1 - selectionSort Max
	 * Complexity: O(n^2)
	 */
	public static void selectionSort(int[] a) {
		int maxIndex;
		for (int i = 0; i < a.length; i++) {
			maxIndex = getMaxIndex(a,a.length-i);
			swap(a,a.length-1-i,maxIndex);
		}
	}
	
	private static void swap(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	private static int getMaxIndex(int[] a, int end) {
		int index = 0;
		for (int i = 0; i < end; i++) {
			if(a[i]>a[index]){
				index = i;
			}
		}
		return index;
	}
	
	/**
	 * Q2 - insertionSort recursive
	 * Complexity: O(n^2)
	 */
	public static void insertionSortRecursive(int[] a) {
		insertionSortRecursive(a,1);
	}
	
	private static void insertionSortRecursive(int[] a, int i) {
		if(i == a.length) return;
		moveToPlace(a,i);
		insertionSortRecursive(a,i+1);
	}

	private static void moveToPlace(int[] a, int i) {
		if(i == 0 || a[i-1] <= a[i]) return;
		swap(a,i-1,i);
		moveToPlace(a,i-1);
	}

	/**
	 * Q3 - selectionSort recursive
	 * Complexity: O(n^2)
	 */
	public static void selectionSortRecursive(int[] a) {
		selectionSortRecursive(a,0);
	}
	
	private static void selectionSortRecursive(int[] a, int i) {
		if(i == a.length) return;
		swap(a,i,getMinIndexRecursive(a,i));
		selectionSortRecursive(a,i+1);
	}

	private static int getMinIndexRecursive(int[] a, int i) {
		if(i == a.length-1) return i;
		int ind = getMinIndexRecursive(a,i+1);
		return a[i]<a[ind] ? i : ind;
	}

	/**
	 * Q4 - sumDigitsSort
	 * Complexity: O(n)
	 */
	public static void sumDigitsSort(int[] a) {
		int[] temp = new int[a.length];
		int k = 0;
		for (int i = 1; i <= 18; i++) {
			for (int j = 0; j < a.length; j++) {
				if(sumDigits(a[j]) == i) temp[k++] = a[j];
			}
		}
		for (int i = 0; i < a.length; i++) {
			a[i] = temp[i];
		}
	}
	
	private static int sumDigits(int n) {
		int sum = 0;
		while(n != 0) {
			sum += n%10;
			n/=10;
		}
		return sum;
	}

	/**
	 * Q5 - one char Sort
	 * Complexity: O(n)
	 */
	public static void OneCharSort(String[] a, int c) {
		if(c<=0) return;
		String[] temp = new String[a.length];
		int k = 0;
		for (int j = 0; j < a.length; j++) {
			if(c-1 >= a[j].length()) temp[k++] = a[j];
		}
		for (int i = 0; i <= 255; i++) {
			for (int j = 0; j < a.length; j++) {
				if(c-1 < a[j].length() && a[j].charAt(c-1) == i) temp[k++] = a[j];
			}
		}
		for (int i = 0; i < a.length; i++) {
			a[i] = temp[i];
		}
	}
	
	
	/**
	 * Q6 - Sorted by number of occurrences of character c
	 * Complexity: O(n*d) , d - the length of max string
	 */
	public static void FreqCharSort(String[] a, char c) {
		int maxLen = a[0].length();
		for (int i = 1; i < a.length; i++) {
			if(a[i].length()>maxLen) maxLen = a[i].length();
		}
		int[] freq = new int[maxLen];
		String[] temp = new String[a.length];
		for (int i = 0; i < a.length; i++) {
			freq[freqOfChar(a[i],c)]++;
		}
		for (int i = 1; i < freq.length; i++) {
			freq[i] += freq[i-1];
		}
		for (int i = 0; i < a.length; i++) {
			temp[--freq[freqOfChar(a[i],c)]] = a[i];
		}
		for (int i = 0; i < a.length; i++) {
        	a[i] = temp[i];
        }
	}
	
	private static int freqOfChar(String str, char c) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == c) count++;
		}
		return count;
	}

	/**
	 * Q7 - Serial place of element e (returns -1 if the element not found)
	 * Complexity: O(n)
	 */	
	public static int serialPlaceOf(int[] a,int e) {
		int index = 0;
		boolean isIn = false;
		for (int i = 0; i < a.length; i++) {
			if(a[i]<e) index++;
			else if(a[i] == e) isIn = true;
		}
		if(!isIn) return -1;
		return index;
	}
}