package Elizabet_lesson_1;


import java.util.Scanner;

public class Hanoi{
	static long moves=0; //number of moves so far
	// towers: A B C
	// from A to C with help of B
	static void hanoi(int   height, char  A, char  B, char  C){
		if (height >= 1){
			hanoi(height-1, A, C, B); 
			moveDisk(A, C);
			hanoi(height-1, B,A , C);
		}
	}
	static void moveDisk(char A, char C){
		moves++;
		System.out.print(A);
		System.out.print(C);
		System.out.print(((moves % 20)==0) ? '\n' : ' ');
	}

	public static void main(String[] args){
		int TowerHeight;
		char A='A', C='C', B='B';
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Tower height");
		TowerHeight = sc.nextInt();
		sc.close();
		long start = System.currentTimeMillis();
		hanoi(TowerHeight, A, B, C);
		long end = System.currentTimeMillis();
		System.out.println();
		// print execution time in msec
		System.out.println((end-start)/1000.0+" seconds execution time"); 
		System.out.println(moves+" moves"); 
	}
}
