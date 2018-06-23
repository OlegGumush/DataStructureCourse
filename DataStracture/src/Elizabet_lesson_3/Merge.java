package Elizabet_lesson_3;

import java.util.Arrays;

////////////////////////////////////////////
//נבנה 2 מערכים רנדומאליים נמיין אותם ונשלח לפונקציה מיזוג
public class Merge {
	
	public static void main(String[] args) 
	{
		int size = 5;
		int a1[] = MyLibrary.randomIntegerArray(size);
		int a2[] = MyLibrary.randomIntegerArray(size);
		Arrays.sort(a1);
		Arrays.sort(a2);
		MyLibrary.printIntegerArray(a1);
		MyLibrary.printIntegerArray(a2);
		int res[] = merge(a1, a2);
		System.out.println("is sorted? "+isSorted(res));
		MyLibrary.printIntegerArray(res);
	}
	
	public static int[] merge(int[] a1, int[]a2){//O(m+n)=O(max(m,n))
		int [] res = new int[a1.length + a2.length];
		int i = 0, j = 0, k = 0;
		while(i<a1.length && j<a2.length)
		{
			if (a1[i] <= a2[j])
				res[k++] = a1[i++];
			else  res[k++] = a2[j++];
		}
		while (i<a1.length)
			res[k++] = a1[i++];
		while (j<a2.length)
			res[k++] = a2[j++];
		return res;
	}
	//סתם בודקת אם ממויין
	private static boolean isSorted(int[] a) {
        for (int i = 1; i < a.length; i++)
            if (a[i] < a[i-1]) return false;
        return true;
    }
	


}
