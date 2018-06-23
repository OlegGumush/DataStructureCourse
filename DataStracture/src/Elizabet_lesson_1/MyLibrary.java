package Elizabet_lesson_1;

public class MyLibrary {
	public static void printArray(int []arr){
		for(int i=0; i<arr.length-1; i = i+1){
			System.out.print(arr[i] + ", ");
		}
		System.out.println(arr[arr.length-1]);
	}
	public static int[] getArray(int size){
		int a[] = new int[size];
		for(int i = 0; i<a.length; i = i+1){
			a[i] = (int)(Math.random()*a.length);
		}
		return a;
	}

}
