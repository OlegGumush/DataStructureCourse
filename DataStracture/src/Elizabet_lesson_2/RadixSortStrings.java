package Elizabet_lesson_2;


import java.util.Arrays;

public class RadixSortStrings {

	// LSD radix sort
    public static void sort(String[] a, int W) {
        int N = a.length;
        int R = 256;   // extend ASCII alphabet size
        String[] aux = new String[N];

        for (int d = W-1; d >= 0; d--) {
            // sort by key-indexed counting on dth character

            // compute frequency counts
            int[] count = new int[R];
            for (int i = 0; i < N; i++)
                count[a[i].charAt(d)]++;

            // compute cumulates
            for (int r = 1; r < R; r++)
                count[r] = count[r-1] + count[r];

            // move data
            for (int i = 0; i < N; i++){
            	int ind1 = a[i].charAt(d)-1;
            	int ind2 = count[ind1]++;
            	aux[ind2] = a[i];
               // aux[count[a[i].charAt(d)]++] = a[i];
            }
            // copy back
            for (int i = 0; i < N; i++)
                a[i] = aux[i];
        }
    }
	public static void main(String[] args) {
		String[]s = {"yes", "yet", "dad", "zoo", "all", "bad", "bug"};
		sort(s, 3);
		System.out.println(Arrays.toString(s));
		System.out.println((char)253);
	}

}
