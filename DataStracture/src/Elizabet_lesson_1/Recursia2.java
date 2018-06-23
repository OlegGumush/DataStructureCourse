package Elizabet_lesson_1;

//חיפוש ברקורסיה
public class Recursia2 {

	public static int search(int[]arr, int value){
		return search(arr, 0, value);
	}
	public static int search(int[]arr, int start, int value){
		int ans = -1;
		if (start > arr.length-1) ans = -1;
		else if (arr[start] == value) ans = start;
		else ans = search(arr, start+1, value);
		return ans;
	}
    // swap the characters at indices i and j
	public static void swap(char[] a, int i, int j) {
        char c;
        c = a[i];
        a[i] = a[j]; 
        a[j] = c;
    }

     public static void mystery1(int a, int b) {//a=0, b=8
    	   if (a != b) {
    	       int m = (a + b) / 2;
    	       mystery1(a, m - 1);
    	       System.out.println(m);
    	       mystery1(m + 1, b);
    	   }
    	}

 


	public static void main(String[] args) {
/*		int[]arr = {9,5,8,4,7};
		System.out.println(search(arr, 9));
		System.out.println(search(arr, 7));
		System.out.println(search(arr, 4));
		System.out.println(search(arr, 3));
*/		///////
	
		mystery1(0,8);
	}

}
