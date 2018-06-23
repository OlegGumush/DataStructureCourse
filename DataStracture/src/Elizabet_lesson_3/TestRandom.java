package Elizabet_lesson_3;

import java.util.Random;



public class TestRandom {
	public static void main(String[] args) {
		Random gen = new Random(13);
		int size = 10;
		for (int i = 0; i < size; i++) {
			System.out.print(gen.nextInt(10)+", ");
		}
		System.out.println();
		for (int i = 0; i < size; i++) {
			double d = Math.random();
			System.out.printf("%5.2f\n",d);
		}
	}
}
//-1157793070, 1913984760, 1107254586,
//3, 0, 3, 0, 6, 6, 7, 8, 1, 4, 