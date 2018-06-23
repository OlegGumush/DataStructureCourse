package Elizabet_lesson_6;

import java.util.Arrays;


public class TestStatic {
	public static int maxElement(int[] arr){
		int maxIndex = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > arr[maxIndex])  maxIndex = i;
		}
		return maxIndex;
	}
	public static void main(String[] args) {
		TestStatic ob = new TestStatic();
		int[]a1 = {1,2,3};
		System.out.println("maxIndex(a1)="+maxElement(a1)+", maxElement="+a1[maxElement(a1)]);
	}

}
